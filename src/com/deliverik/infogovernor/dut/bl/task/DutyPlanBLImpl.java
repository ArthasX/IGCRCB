/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dut.model.DutyPlan;
import com.deliverik.infogovernor.dut.model.condition.DutyPlanSearchCond;
import com.deliverik.infogovernor.dut.model.dao.DutyPlanDAO;

/**
 * 值班检查管理业务逻辑接口
 */
public class DutyPlanBLImpl extends BaseBLImpl implements DutyPlanBL {
	/** DutyAuditDef DAO */
	protected DutyPlanDAO dutyPlanDAO;

	public void setDutyPlanDAO(DutyPlanDAO dutyPlanDAO) {
		this.dutyPlanDAO = dutyPlanDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(DutyPlanSearchCond cond){
		
		return dutyPlanDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param dpid 值班检查项ID
	 * @return 值班检查项ID
	 */
	public DutyPlan searchDutyPlanByKey(Integer dpid) throws BLException{
		
		return checkExistDutyPlan(dpid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部值班检查项信息
	 */
	public List<DutyPlan> searchDutyPlanAll(){
		
		return dutyPlanDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DutyPlan> searchDutyPlan(DutyPlanSearchCond cond, int start, int count){
		
		return dutyPlanDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param dutyPlan 登录数据
	 * @return 值班检查项信息
	 */
	public DutyPlan registDutyPlan(DutyPlan dutyPlan) throws BLException{
		
		return dutyPlanDAO.save(dutyPlan);
	}

	/**
	 * 删除处理
	 * 
	 * @param dadid 值班检查项ID
	 * @return
	 */
	public void deleteDutyPlan(Integer dpid) throws BLException{
		
		DutyPlan dutyPlan = checkExistDutyPlan(dpid);
		
		dutyPlanDAO.delete(dutyPlan);
	}

	/**
	 * 变更处理
	 * 
	 * @param dutyAuditDef 变更数据
	 * @return 值班检查项信息
	 */
	public DutyPlan updateDutyPlan(DutyPlan dutyPlan) throws BLException{
		
		checkExistDutyPlan(dutyPlan.getDpid());
		return dutyPlanDAO.save(dutyPlan);
	}

	/**
	 * 值班检查项信息存在检查
	 * 
	 * @param dadid 值班检查项ID
	 * @return 值班检查项信息
	 * @throws BLException 
	 */
	protected DutyPlan checkExistDutyPlan(Integer dpid) throws BLException{
		DutyPlan info = dutyPlanDAO.findByPK(dpid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","值班基本");
		}
		return info;
	}
}

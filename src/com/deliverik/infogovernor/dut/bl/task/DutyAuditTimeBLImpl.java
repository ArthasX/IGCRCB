/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dut.model.DutyAuditTime;
import com.deliverik.infogovernor.dut.model.condition.DutyAuditTimeSearchCond;
import com.deliverik.infogovernor.dut.model.dao.DutyAuditTimeDAO;

/**
 * 
 * 值班检查项检查时间业务逻辑实现类
 *
 */
public class DutyAuditTimeBLImpl   extends BaseBLImpl implements DutyAuditTimeBL{
	
	/** DutyAuditTime DAO */
	protected DutyAuditTimeDAO dutyAuditTimeDAO;
	
	public void setDutyAuditTimeDAO(
			DutyAuditTimeDAO dutyAuditTimeDAO) {
		this.dutyAuditTimeDAO = dutyAuditTimeDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(DutyAuditTimeSearchCond cond){
		
		return dutyAuditTimeDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param dadid 值班检查项ID
	 * @return 值班检查项ID
	 */
	public DutyAuditTime searchDutyAuditTimeByKey(Integer datid) throws BLException{
		
		return checkExistDutyAuditTime(datid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部值班检查项信息
	 */
	public List<DutyAuditTime> searchDutyAuditTimeAll(){
		
		return dutyAuditTimeDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DutyAuditTime> searchDutyAuditTime(DutyAuditTimeSearchCond cond, int start, int count){
		
		return dutyAuditTimeDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param dutyAuditTime 登录数据
	 * @return 值班检查项信息
	 */
	public DutyAuditTime registDutyAuditTime(DutyAuditTime dutyAuditTime) throws BLException{
		
		return dutyAuditTimeDAO.save(dutyAuditTime);
	}

	/**
	 * 删除处理
	 * 
	 * @param dadid 值班检查项ID
	 * @return
	 */
	public void deleteDutyAuditTime(Integer datid) throws BLException{
		
		DutyAuditTime dutyAuditTime = checkExistDutyAuditTime(datid);
		
		dutyAuditTimeDAO.delete(dutyAuditTime);
	}

	/**
	 * 变更处理
	 * 
	 * @param dutyAuditTime 变更数据
	 * @return 值班检查项信息
	 */
	public DutyAuditTime updateDutyAuditTime(DutyAuditTime dutyAuditTime) throws BLException{
		
		checkExistDutyAuditTime(dutyAuditTime.getDadid());
		return dutyAuditTimeDAO.save(dutyAuditTime);
	}

	/**
	 * 值班检查项信息存在检查
	 * 
	 * @param dadid 值班检查项ID
	 * @return 值班检查项信息
	 * @throws BLException 
	 */
	protected DutyAuditTime checkExistDutyAuditTime(Integer datid) throws BLException{
		DutyAuditTime info = dutyAuditTimeDAO.findByPK(datid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","值班检查项基本");
		}
		return info;
	}

}

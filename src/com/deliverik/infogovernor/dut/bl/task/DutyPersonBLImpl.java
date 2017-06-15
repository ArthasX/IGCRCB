/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dut.model.DutyPerson;
import com.deliverik.infogovernor.dut.model.condition.DutyPersonSearchCond;
import com.deliverik.infogovernor.dut.model.dao.DutyPersonDAO;

/**
 * 值班检查管理业务逻辑接口
 */
public class DutyPersonBLImpl extends BaseBLImpl implements DutyPersonBL {
	/** DutyAuditDef DAO */
	protected DutyPersonDAO dutyPersonDAO;

	public void setDutyPersonDAO(DutyPersonDAO dutyPersonDAO) {
		this.dutyPersonDAO = dutyPersonDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(DutyPersonSearchCond cond){
		
		return dutyPersonDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param dpid 值班检查项ID
	 * @return 值班检查项ID
	 */
	public DutyPerson searchDutyPersonByKey(Integer dperid) throws BLException{
		
		return checkExistDutyPerson(dperid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部值班检查项信息
	 */
	public List<DutyPerson> searchDutyPersonAll(){
		
		return dutyPersonDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DutyPerson> searchDutyPerson(DutyPersonSearchCond cond, int start, int count){
		
		return dutyPersonDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param dutyAuditDef 登录数据
	 * @return 值班检查项信息
	 */
	public DutyPerson registDutyPerson(DutyPerson DutyPerson) throws BLException{
		
		return dutyPersonDAO.save(DutyPerson);
	}

	/**
	 * 删除处理
	 * 
	 * @param dadid 值班检查项ID
	 * @return
	 */
	public void deleteDutyPerson(Integer dperid) throws BLException{
		
		DutyPerson DutyPerson = checkExistDutyPerson(dperid);
		
		dutyPersonDAO.delete(DutyPerson);
	}

	/**
	 * 变更处理
	 * 
	 * @param dutyAuditDef 变更数据
	 * @return 值班检查项信息
	 */
	public DutyPerson updateDutyPerson(DutyPerson DutyPerson) throws BLException{
		
		checkExistDutyPerson(DutyPerson.getDpid());
		return dutyPersonDAO.save(DutyPerson);
	}

	/**
	 * 值班检查项信息存在检查
	 * 
	 * @param dadid 值班检查项ID
	 * @return 值班检查项信息
	 * @throws BLException 
	 */
	protected DutyPerson checkExistDutyPerson(Integer dperid) throws BLException{
		DutyPerson info = dutyPersonDAO.findByPK(dperid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","值班人基本");
		}
		return info;
	}
}

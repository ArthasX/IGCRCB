/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dut.model.DutyAuditDef;
import com.deliverik.infogovernor.dut.model.condition.DutyAuditDefSearchCond;
import com.deliverik.infogovernor.dut.model.dao.DutyAuditDefDAO;

/**
 * 值班检查管理业务逻辑接口
 */
public class DutyAuditDefBLImpl extends BaseBLImpl implements DutyAuditDefBL {
	
	/** DutyAuditDef DAO */
	protected DutyAuditDefDAO dutyAuditDefDAO;
	
	public void setDutyAuditDefDAO(
			DutyAuditDefDAO dutyAuditDefDAO) {
		this.dutyAuditDefDAO = dutyAuditDefDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(DutyAuditDefSearchCond cond){
		
		return dutyAuditDefDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param dadid 值班检查项ID
	 * @return 值班检查项ID
	 */
	public DutyAuditDef searchDutyAuditDefByKey(Integer dadid) throws BLException{
		
		return checkExistDutyAuditDef(dadid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部值班检查项信息
	 */
	public List<DutyAuditDef> searchDutyAuditDefAll(){
		
		return dutyAuditDefDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DutyAuditDef> searchDutyAuditDef(DutyAuditDefSearchCond cond, int start, int count){
		
		return dutyAuditDefDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param dutyAuditDef 登录数据
	 * @return 值班检查项信息
	 */
	public DutyAuditDef registDutyAuditDef(DutyAuditDef dutyAuditDef) throws BLException{
		
		return dutyAuditDefDAO.save(dutyAuditDef);
	}

	/**
	 * 删除处理
	 * 
	 * @param dadid 值班检查项ID
	 * @return
	 */
	public void deleteDutyAuditDef(Integer dadid) throws BLException{
		
		DutyAuditDef dutyAuditDef = checkExistDutyAuditDef(dadid);
		
		dutyAuditDefDAO.delete(dutyAuditDef);
	}

	/**
	 * 变更处理
	 * 
	 * @param dutyAuditDef 变更数据
	 * @return 值班检查项信息
	 */
	public DutyAuditDef updateDutyAuditDef(DutyAuditDef dutyAuditDef) throws BLException{
		
		checkExistDutyAuditDef(dutyAuditDef.getDadid());
		return dutyAuditDefDAO.save(dutyAuditDef);
	}

	/**
	 * 值班检查项信息存在检查
	 * 
	 * @param dadid 值班检查项ID
	 * @return 值班检查项信息
	 * @throws BLException 
	 */
	protected DutyAuditDef checkExistDutyAuditDef(Integer dadid) throws BLException{
		DutyAuditDef info = dutyAuditDefDAO.findByPK(dadid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","值班检查项基本");
		}
		return info;
	}
}

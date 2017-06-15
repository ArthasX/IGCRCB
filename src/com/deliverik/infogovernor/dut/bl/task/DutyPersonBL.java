/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dut.model.DutyPerson;
import com.deliverik.infogovernor.dut.model.condition.DutyPersonSearchCond;


/**
 * 值班检查管理业务逻辑接口
 */
public interface DutyPersonBL extends BaseBL{

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(DutyPersonSearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param dpid 检查项ID
	 * @return 检查项ID
	 */
	public DutyPerson searchDutyPersonByKey(Integer dperid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部值班检查项信息
	 */
	public List<DutyPerson> searchDutyPersonAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DutyPerson> searchDutyPerson(DutyPersonSearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param DutyAuditDef 登录数据
	 * @return 值班检查项信息
	 */
	public DutyPerson registDutyPerson(DutyPerson auditCheckRelation) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param dadid 检查项ID
	 * @throws BLException
	 */
	public void deleteDutyPerson(Integer dperid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param auditCheckRelation 变更数据
	 * @return 值班检查项信息
	 */
	public DutyPerson updateDutyPerson(DutyPerson auditCheckRelation) throws BLException;

}

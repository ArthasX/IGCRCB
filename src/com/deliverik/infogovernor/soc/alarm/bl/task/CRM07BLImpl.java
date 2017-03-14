/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM07Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM07SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.dao.CRM07DAO;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM07TB;

/**
  * 概述: CRM07业务逻辑实现
  * 功能描述: CRM07业务逻辑实现
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public class CRM07BLImpl extends BaseBLImpl implements
		CRM07BL {

	/** CRM07DAO接口 */
	protected CRM07DAO crm07DAO;
	
	/**
	 * CRM07DAO接口设定
	 *
	 * @param crm07DAO CRM07DAO接口
	 */
	public void setCrm07DAO(CRM07DAO crm07DAO) {
		this.crm07DAO = crm07DAO;
	}

	/**
	 * CRM07实例取得
	 *
	 * @return CRM07实例
	 */
	public CRM07TB getCRM07TBInstance() {
		return new CRM07TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CRM07Info> searchCRM07() {
		return crm07DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CRM07Info searchCRM07ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CRM07SearchCond cond) {
		return crm07DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CRM07Info> searchCRM07(
			CRM07SearchCond cond) {
		return crm07DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CRM07Info> searchCRM07(
			CRM07SearchCond cond, int start,
			int count) {
		return crm07DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CRM07Info registCRM07(CRM07Info instance)
		throws BLException {
		return crm07DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CRM07Info updateCRM07(CRM07Info instance)
		throws BLException {
		checkExistInstance(instance.getRuleconditionid());
		return crm07DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCRM07ByPK(Integer pk)
		throws BLException {
		crm07DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCRM07(CRM07Info instance)
		throws BLException {
		crm07DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CRM07Info checkExistInstance(Integer pk)
		throws BLException {
		CRM07Info instance = crm07DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}
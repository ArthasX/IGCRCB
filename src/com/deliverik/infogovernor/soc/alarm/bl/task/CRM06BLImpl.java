/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM06Info;
import com.deliverik.infogovernor.soc.alarm.model.CRM06VWInfo;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM06SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.dao.CRM06DAO;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM06TB;

/**
  * 概述: CRM06业务逻辑实现
  * 功能描述: CRM06业务逻辑实现
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public class CRM06BLImpl extends BaseBLImpl implements
		CRM06BL {

	/** CRM06DAO接口 */
	protected CRM06DAO crm06DAO;
	
	
	public CRM06DAO getCrm06DAO() {
		return crm06DAO;
	}

	public void setCrm06DAO(CRM06DAO crm06DAO) {
		this.crm06DAO = crm06DAO;
	}

	/**
	 * CRM06实例取得
	 *
	 * @return CRM06实例
	 */
	public CRM06TB getCRM06TBInstance() {
		return new CRM06TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CRM06Info> searchCRM06() {
		return crm06DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CRM06Info searchCRM06ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CRM06SearchCond cond) {
		return crm06DAO.getSearchCount(cond);
	}
	
	/**
	 * 视图条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchVWCount(CRM06SearchCond cond) {
		return crm06DAO.getSearchVWCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CRM06Info> searchCRM06(
			CRM06SearchCond cond) {
		return crm06DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CRM06Info> searchCRM06(
			CRM06SearchCond cond, int start,
			int count) {
		return crm06DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CRM06Info registCRM06(CRM06Info instance)
		throws BLException {
		return crm06DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CRM06Info updateCRM06(CRM06Info instance)
		throws BLException {
		checkExistInstance(instance.getServerid());
		return crm06DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCRM06ByPK(Integer pk)
		throws BLException {
		crm06DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCRM06(CRM06Info instance)
		throws BLException {
		crm06DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CRM06Info checkExistInstance(Integer pk)
		throws BLException {
		CRM06Info instance = crm06DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	public List<CRM06VWInfo> searchCRM06VW(final CRM06SearchCond cond, final int start, final int count){
		return crm06DAO.findVWByCond(cond, start, count);
	}
	
	public List<String> getSearchVWByInstance(final CRM06SearchCond cond){
		return crm06DAO.getSearchVWByInstance(cond);
	}

}
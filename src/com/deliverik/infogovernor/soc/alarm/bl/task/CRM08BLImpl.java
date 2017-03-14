/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM08Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM08SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.dao.CRM08DAO;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM08TB;

/**
  * 概述: CRM08业务逻辑实现
  * 功能描述: CRM08业务逻辑实现
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public class CRM08BLImpl extends BaseBLImpl implements
		CRM08BL {

	/** CRM08DAO接口 */
	protected CRM08DAO crm08DAO;
	
	/**
	 * CRM08DAO接口设定
	 *
	 * @param crm08DAO CRM08DAO接口
	 */
	public void setCrm08DAO(CRM08DAO crm08DAO) {
		this.crm08DAO = crm08DAO;
	}

	/**
	 * CRM08实例取得
	 *
	 * @return CRM08实例
	 */
	public CRM08TB getCRM08TBInstance() {
		return new CRM08TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CRM08Info> searchCRM08() {
		return crm08DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CRM08Info searchCRM08ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CRM08SearchCond cond) {
		return crm08DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CRM08Info> searchCRM08(
			CRM08SearchCond cond) {
		return crm08DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CRM08Info> searchCRM08(
			CRM08SearchCond cond, int start,
			int count) {
		return crm08DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CRM08Info registCRM08(CRM08Info instance)
		throws BLException {
		return crm08DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CRM08Info updateCRM08(CRM08Info instance)
		throws BLException {
		checkExistInstance(instance.getRuletempid());
		return crm08DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCRM08ByPK(Integer pk)
		throws BLException {
		crm08DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCRM08(CRM08Info instance)
		throws BLException {
		crm08DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CRM08Info checkExistInstance(Integer pk)
		throws BLException {
		CRM08Info instance = crm08DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}
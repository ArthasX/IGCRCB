/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM05Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM05SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.dao.CRM05DAO;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM05TB;

/**
  * 概述: CRM05业务逻辑实现
  * 功能描述: CRM05业务逻辑实现
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public class CRM05BLImpl extends BaseBLImpl implements
		CRM05BL {

	/** CRM05DAO接口 */
	protected CRM05DAO crm05DAO;
	
	
	public CRM05DAO getCrm05DAO() {
		return crm05DAO;
	}

	public void setCrm05DAO(CRM05DAO crm05DAO) {
		this.crm05DAO = crm05DAO;
	}

	/**
	 * CRM05实例取得
	 *
	 * @return CRM05实例
	 */
	public CRM05TB getCRM05TBInstance() {
		return new CRM05TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CRM05Info> searchCRM05() {
		return crm05DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CRM05Info searchCRM05ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CRM05SearchCond cond) {
		return crm05DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CRM05Info> searchCRM05(
			CRM05SearchCond cond) {
		return crm05DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CRM05Info> searchCRM05(
			CRM05SearchCond cond, int start,
			int count) {
		return crm05DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CRM05Info registCRM05(CRM05Info instance)
		throws BLException {
		return crm05DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CRM05Info updateCRM05(CRM05Info instance)
		throws BLException {
		checkExistInstance(instance.getFileid());
		return crm05DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCRM05ByPK(Integer pk)
		throws BLException {
		crm05DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCRM05(CRM05Info instance)
		throws BLException {
		crm05DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CRM05Info checkExistInstance(Integer pk)
		throws BLException {
		CRM05Info instance = crm05DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}
/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM02Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM02SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.dao.CRM02DAO;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM02TB;

/**
  * 概述: CRM02业务逻辑实现
  * 功能描述: CRM02业务逻辑实现
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public class CRM02BLImpl extends BaseBLImpl implements
		CRM02BL {

	/** CRM02DAO接口 */
	protected CRM02DAO crm02DAO;
	

	/**
	 * CRM02实例取得
	 *
	 * @return CRM02实例
	 */
	public CRM02TB getCRM02TBInstance() {
		return new CRM02TB();
	}

	public CRM02DAO getCrm02DAO() {
		return crm02DAO;
	}

	public void setCrm02DAO(CRM02DAO crm02DAO) {
		this.crm02DAO = crm02DAO;
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CRM02Info> searchCRM02() {
		return crm02DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CRM02Info searchCRM02ByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CRM02SearchCond cond) {
		return crm02DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CRM02Info> searchCRM02(
			CRM02SearchCond cond) {
		return crm02DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CRM02Info> searchCRM02(
			CRM02SearchCond cond, int start,
			int count) {
		return crm02DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CRM02Info registCRM02(CRM02Info instance)
		throws BLException {
		return crm02DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CRM02Info updateCRM02(CRM02Info instance)
		throws BLException {
		checkExistInstance(instance.getTablename());
		return crm02DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCRM02ByPK(String pk)
		throws BLException {
		crm02DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCRM02(CRM02Info instance)
		throws BLException {
		crm02DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CRM02Info checkExistInstance(String pk)
		throws BLException {
		CRM02Info instance = crm02DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}
/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM04Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM04SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.dao.CRM04DAO;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM04TB;

/**
  * 概述: CRM04业务逻辑实现
  * 功能描述: CRM04业务逻辑实现
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public class CRM04BLImpl extends BaseBLImpl implements
		CRM04BL {

	/** CRM04DAO接口 */
	protected CRM04DAO crm04DAO;
	
	/**
	 * CRM04DAO接口设定
	 *
	 * @param cRM04DAO CRM04DAO接口
	 */
	public void setCrm04DAO(CRM04DAO crm04DAO) {
		this.crm04DAO = crm04DAO;
	}

	/**
	 * CRM04实例取得
	 *
	 * @return CRM04实例
	 */
	public CRM04TB getCRM04TBInstance() {
		return new CRM04TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CRM04Info> searchCRM04() {
		return crm04DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CRM04Info searchCRM04ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CRM04SearchCond cond) {
		return crm04DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CRM04Info> searchCRM04(
			CRM04SearchCond cond) {
		return crm04DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CRM04Info> searchCRM04(
			CRM04SearchCond cond, int start,
			int count) {
		return crm04DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CRM04Info registCRM04(CRM04Info instance)
		throws BLException {
		return crm04DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CRM04Info updateCRM04(CRM04Info instance)
		throws BLException {
		checkExistInstance(instance.getAlarmid());
		return crm04DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCRM04ByPK(Integer pk)
		throws BLException {
		crm04DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCRM04(CRM04Info instance)
		throws BLException {
		crm04DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CRM04Info checkExistInstance(Integer pk)
		throws BLException {
		CRM04Info instance = crm04DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}
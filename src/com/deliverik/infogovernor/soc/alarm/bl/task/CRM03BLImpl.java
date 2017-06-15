/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM03Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM03SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.dao.CRM03DAO;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM03TB;

/**
  * 概述: CRM03业务逻辑实现
  * 功能描述: CRM03业务逻辑实现
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public class CRM03BLImpl extends BaseBLImpl implements
		CRM03BL {

	/** CRM03DAO接口 */
	protected CRM03DAO crm03DAO;
	
	/**
	 * CRM03DAO接口设定
	 *
	 * @param cRM03DAO CRM03DAO接口
	 */
	public void setCrm03DAO(CRM03DAO crm03DAO) {
		this.crm03DAO = crm03DAO;
	}

	/**
	 * CRM03实例取得
	 *
	 * @return CRM03实例
	 */
	public CRM03TB getCRM03TBInstance() {
		return new CRM03TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CRM03Info> searchCRM03() {
		return crm03DAO.findAll();
	}


	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CRM03SearchCond cond) {
		return crm03DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CRM03Info> searchCRM03(
			CRM03SearchCond cond) {
		return crm03DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CRM03Info> searchCRM03(
			CRM03SearchCond cond, int start,
			int count) {
		return crm03DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CRM03Info registCRM03(CRM03Info instance)
		throws BLException {
		return crm03DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CRM03Info updateCRM03(CRM03Info instance)
		throws BLException {
		return crm03DAO.save(instance);
	}


	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCRM03(CRM03Info instance)
		throws BLException {
		crm03DAO.delete(instance);
	}


}
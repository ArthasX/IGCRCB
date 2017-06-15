/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0429Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0429SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0429DAO;

/**
  * 概述: 主机容量视图业务逻辑实现
  * 功能描述: 主机容量视图业务逻辑实现
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将HostCapacityRealTimeVWBLImpl表名改为SOC0429BLImpl
  */
public class SOC0429BLImpl extends BaseBLImpl implements
		SOC0429BL {

	/** 主机容量视图DAO接口 */
	protected SOC0429DAO soc0429DAO;
	
	/**
	 * 主机容量视图DAO接口设定
	 *
	 * @param hostCapacityVWDAO 主机容量视图DAO接口
	 */
	public void setSoc0429DAO(SOC0429DAO soc0429DAO) {
		this.soc0429DAO = soc0429DAO;
	}


	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0429Info> searchSOC0429() {
		return soc0429DAO.findAll();
	}


	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0429SearchCond cond) {
		return soc0429DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0429Info> searchSOC0429(
			SOC0429SearchCond cond) {
		return soc0429DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0429Info> searchSOC0429(
			SOC0429SearchCond cond, int start,
			int count) {
		return soc0429DAO.findByCond(cond, start, count);
	}

	

}
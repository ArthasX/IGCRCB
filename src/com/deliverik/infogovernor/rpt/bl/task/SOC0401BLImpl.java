/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0401Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0401SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0401DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0401TB;

/**
  * 概述: 数据库容量实时表业务逻辑实现
  * 功能描述: 数据库容量实时表业务逻辑实现
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将DBCapacityRealTimeBLImpl表名改为SOC0401BLImpl
  */
public class SOC0401BLImpl extends BaseBLImpl implements
		SOC0401BL {

	/** 数据库容量实时表DAO接口 */
	protected SOC0401DAO soc0401DAO;
	
	/**
	 * 数据库容量实时表DAO接口设定
	 *
	 * @param soc0401DAO 数据库容量实时表DAO接口
	 */
	public void setSoc0401DAO(SOC0401DAO soc0401DAO) {
		this.soc0401DAO = soc0401DAO;
	}

	/**
	 * 数据库容量实时表实例取得
	 *
	 * @return 数据库容量实时表实例
	 */
	public SOC0401TB getSOC0401Instance() {
		return new SOC0401TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0401Info> searchSOC0401() {
		return soc0401DAO.findAll();
	}


	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0401SearchCond cond) {
		return soc0401DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0401Info> searchSOC0401(
			SOC0401SearchCond cond) {
		return soc0401DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0401Info> searchSOC0401(
			SOC0401SearchCond cond, int start,
			int count) {
		return soc0401DAO.findByCond(cond, start, count);
	}
}
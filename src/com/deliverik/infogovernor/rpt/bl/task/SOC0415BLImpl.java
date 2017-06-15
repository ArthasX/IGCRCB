/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0415Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0415SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0415DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0415TB;

/**
  * 概述: 表空间容量实时表业务逻辑实现
  * 功能描述: 表空间容量实时表业务逻辑实现
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/10 将TSCapacityRealTimeBLImpl表名修改为SOC0415BLImpl
  */
public class SOC0415BLImpl extends BaseBLImpl implements
		SOC0415BL {

	/** 表空间容量实时表DAO接口 */
	protected SOC0415DAO soc0415DAO;
	
	/**
	 * 表空间容量实时表DAO接口设定
	 *
	 * @param soc0415DAO 表空间容量实时表DAO接口
	 */
	public void setSoc0415DAO(SOC0415DAO soc0415DAO) {
		this.soc0415DAO = soc0415DAO;
	}

	/**
	 * 表空间容量实时表实例取得
	 *
	 * @return 表空间容量实时表实例
	 */
	public SOC0415TB getSOC0415Instance() {
		return new SOC0415TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0415Info> searchSOC0415() {
		return soc0415DAO.findAll();
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0415SearchCond cond) {
		return soc0415DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0415Info> searchSOC0415(
			SOC0415SearchCond cond) {
		return soc0415DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0415Info> searchSOC0415(
			SOC0415SearchCond cond, int start,
			int count) {
		return soc0415DAO.findByCond(cond, start, count);
	}


}
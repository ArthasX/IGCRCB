/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0405Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0405SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0405DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0405TB;

/**
  * 概述: 逻辑卷容量实时表业务逻辑实现
  * 功能描述: 逻辑卷容量实时表业务逻辑实现
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将LVCapacityRealTimeBLImpl表名改为SOC0405BLImpl
  */
public class SOC0405BLImpl extends BaseBLImpl implements
		SOC0405BL {

	/** 逻辑卷容量实时表DAO接口 */
	protected SOC0405DAO soc0405DAO;
	
	/**
	 * 逻辑卷容量实时表DAO接口设定
	 *
	 * @param soc0405DAO 逻辑卷容量实时表DAO接口
	 */
	public void setSoc0405DAO(SOC0405DAO soc0405DAO) {
		this.soc0405DAO = soc0405DAO;
	}

	/**
	 * 逻辑卷容量实时表实例取得
	 *
	 * @return 逻辑卷容量实时表实例
	 */
	public SOC0405TB getSOC0405Instance() {
		return new SOC0405TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0405Info> searchSOC0405() {
		return soc0405DAO.findAll();
	}


	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0405SearchCond cond) {
		return soc0405DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0405Info> searchSOC0405(
			SOC0405SearchCond cond) {
		return soc0405DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0405Info> searchSOC0405(
			SOC0405SearchCond cond, int start,
			int count) {
		return soc0405DAO.findByCond(cond, start, count);
	}


}
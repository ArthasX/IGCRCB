/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;
import com.deliverik.framework.soc.asset.model.dao.MonitoringAlarmIPVWDAO;

/**
 * 概述:监控告警ip视图BL实现
 * 功能描述: 监控告警ip视图BL实现
 * 创建人：王磊
 * 创建记录: 2014/04/01
 * 修改记录: 
 */

public class MonitoringAlarmIPVWBLImpl extends BaseBLImpl implements
	MonitoringAlarmIPVWBL {

	/** 监控告警ip视图DAO */
	protected MonitoringAlarmIPVWDAO monitoringAlarmIPVWDAO;

	public void setMonitoringAlarmIPVWDAO(
			MonitoringAlarmIPVWDAO monitoringAlarmIPVWDAO) {
		this.monitoringAlarmIPVWDAO = monitoringAlarmIPVWDAO;
	}
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0107Info> findByCond(final SOC0107SearchCond cond){
		return monitoringAlarmIPVWDAO.findByCond(cond);
	}
}

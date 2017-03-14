/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;

/**
 * 概述:监控告警ip视图DAO接口
 * 功能描述: 监控告警ip视图DAO接口
 * 创建人：王磊
 * 创建记录: 2014/04/01
 * 修改记录: 
 */

public interface MonitoringAlarmIPVWDAO extends BaseHibernateDAO<SOC0107Info> {

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0107Info> findByCond(final SOC0107SearchCond cond);
}

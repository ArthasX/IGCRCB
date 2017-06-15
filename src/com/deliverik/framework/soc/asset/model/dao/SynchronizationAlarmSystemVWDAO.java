/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SynchronizationAlarmSystemVWInfo;
import com.deliverik.framework.soc.asset.model.condition.SynchronizationAlarmSystemVWSearchCond;

/**
 * 概述:同步告警系统视图DAO接口
 * 功能描述: 同步告警系统视图DAO接口
 * 创建人：王磊
 * 创建记录: 2014/04/03
 * 修改记录: 
 */

public interface SynchronizationAlarmSystemVWDAO extends BaseHibernateDAO<SynchronizationAlarmSystemVWInfo> {

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SynchronizationAlarmSystemVWInfo> findByCond(final SynchronizationAlarmSystemVWSearchCond cond);
}

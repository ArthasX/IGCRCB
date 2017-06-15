/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SynchronizationAlarmSystemVWInfo;
import com.deliverik.framework.soc.asset.model.condition.SynchronizationAlarmSystemVWSearchCond;
import com.deliverik.framework.soc.asset.model.dao.SynchronizationAlarmSystemVWDAO;

/**
 * 概述:同步告警系统视图BL实现
 * 功能描述: 同步告警系统视图BL实现
 * 创建人：王磊
 * 创建记录: 2014/04/03
 * 修改记录: 
 */

public class SynchronizationAlarmSystemVWBLImpl extends BaseBLImpl implements
	SynchronizationAlarmSystemVWBL {

	/** 同步告警系统视图DAO */
	protected SynchronizationAlarmSystemVWDAO synchronizationAlarmSystemVWDAO;

	public void setSynchronizationAlarmSystemVWDAO(
			SynchronizationAlarmSystemVWDAO synchronizationAlarmSystemVWDAO) {
		this.synchronizationAlarmSystemVWDAO = synchronizationAlarmSystemVWDAO;
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SynchronizationAlarmSystemVWInfo> findByCond(final SynchronizationAlarmSystemVWSearchCond cond){
		return synchronizationAlarmSystemVWDAO.findByCond(cond);
	}
}

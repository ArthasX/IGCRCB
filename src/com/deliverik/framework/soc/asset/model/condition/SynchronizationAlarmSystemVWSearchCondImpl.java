/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
 * 概述:同步告警系统视图查询条件实现
 * 功能描述: 同步告警系统视图查询条件实现
 * 创建人：王磊
 * 创建记录: 2014/04/03
 * 修改记录: 
 */

public class SynchronizationAlarmSystemVWSearchCondImpl implements
	SynchronizationAlarmSystemVWSearchCond {
	
	/**同步类型  */
	protected String itype;

	/**同步类型取得 */
	public String getItype() {
		return itype;
	}

	/**同步类型设定 */
	public void setItype(String itype) {
		this.itype = itype;
	}
}

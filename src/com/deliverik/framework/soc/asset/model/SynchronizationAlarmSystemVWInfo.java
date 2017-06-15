/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model;

/**
 * 概述:同步告警系统视图接口
 * 功能描述: 同步告警系统视图接口
 * 创建人：王磊
 * 创建记录: 2014/04/03
 * 修改记录: 
 */

public interface SynchronizationAlarmSystemVWInfo {

	/**
	 * id取得
	 *
	 * @return id
	 */
	public Integer getRid();
	
	/**
	 * 已同步系统id取得
	 *
	 * @return 已同步系统id
	 */
	public Integer getIlsid();
	
	/**
	 * 已同步系统名称取得
	 *
	 * @return 已同步系统名称
	 */
	public String getIlsname();
	
	/**
	 * 需同步系统名称取得
	 *
	 * @return 需同步系统名称
	 */
	public String getEaname();
}

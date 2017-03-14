/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * 概述: 告警系统显示信息表检索条件接口
  * 功能描述: 告警系统显示信息表检索条件接口
  * 创建记录: 2014/03/05
  * 修改记录: 
  */
public interface IndicatorLightsSystemSearchCond {

	/**
	 * 系统名称取得
	 *
	 * @return 系统名称
	 */
	public String getIlsname();

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getIlsstatus();
}
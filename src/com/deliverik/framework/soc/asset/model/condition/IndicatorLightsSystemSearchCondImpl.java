/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * 概述: 告警系统显示信息表检索条件实现
  * 功能描述: 告警系统显示信息表检索条件实现
  * 创建记录: 2014/03/05
  * 修改记录: 
  */
public class IndicatorLightsSystemSearchCondImpl implements
		IndicatorLightsSystemSearchCond {

	/** 系统名称 */
	protected String ilsname;

	/** 状态 */
	protected String ilsstatus;

	/**
	 * 系统名称取得
	 *
	 * @return 系统名称
	 */
	public String getIlsname() {
		return ilsname;
	}

	/**
	 * 系统名称设定
	 *
	 * @param ilsname 系统名称
	 */
	public void setIlsname(String ilsname) {
		this.ilsname = ilsname;
	}

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getIlsstatus() {
		return ilsstatus;
	}

	/**
	 * 状态设定
	 *
	 * @param ilsstatus 状态
	 */
	public void setIlsstatus(String ilsstatus) {
		this.ilsstatus = ilsstatus;
	}

}
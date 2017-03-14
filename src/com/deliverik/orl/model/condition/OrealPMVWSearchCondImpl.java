/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.orl.model.condition;

/**
 * 概述: 欧莱雅监控指标视图检索条件实现
 * 功能描述: 欧莱雅监控指标视图检索条件实现
 * 创建人：Lu Jiayuan
 * 创建记录： 2014/02/26
 * 修改记录：
 */
public class OrealPMVWSearchCondImpl implements OrealPMVWSearchCond {
	/** 是否监控(标识) */
	protected String enabled_eq;
	
	/** 平台名称 */
	protected String platform_name_like;
	
	/** 平台名称(in) */
	protected String[] platform_name_in;
	
	/**
	 * Getter and Setter
	 */
	/**
	 * 是否监控(标识)取得
	 * @return enabled_eq 是否监控(标识)
	 */
	public String getEnabled_eq() {
		return enabled_eq;
	}
	/**
	 * 是否监控(标识)设定
	 * @param enabled_eq
	 */
	public void setEnabled_eq(String enabled_eq) {
		this.enabled_eq = enabled_eq;
	}

	/**
	 * 平台名称取得
	 * @return platform_name_like 平台名称
	 */
	public String getPlatform_name_like() {
		return platform_name_like;
	}
	/**
	 * 平台名称设定
	 * @param platform_name_like
	 */
	public void setPlatform_name_like(String platform_name_like) {
		this.platform_name_like = platform_name_like;
	}

	/**
	 * 平台名称(in)取得
	 * @return platform_name_in 平台名称(in)
	 */
	public String[] getPlatform_name_in() {
		return platform_name_in;
	}
	/**
	 * 平台名称(in)设定
	 * @param platform_name_in
	 */
	public void setPlatform_name_in(String[] platform_name_in) {
		this.platform_name_in = platform_name_in;
	}
}
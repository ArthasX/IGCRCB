/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.orl.model.condition;

/**
 * 概述: 欧莱雅告警表检索条件接口
 * 功能描述: 欧莱雅告警表检索条件接口
 * 创建人：Lu Jiayuan
 * 创建记录： 2014/02/26
 * 修改记录：
 */
public interface OrealAlertSearchCond {
	/**
	 * 是否修复(标识)取得
	 * @return fixed_eq 是否修复(标识)
	 */
	public String getFixed_eq();

	/**
	 * 平台名称取得
	 * @return platform_name_like 平台名称
	 */
	public String getPlatform_name_like();
	/**
	 * 平台名称(in)取得
	 * @return platform_name_in 平台名称(in)
	 */
	public String[] getPlatform_name_in();
}
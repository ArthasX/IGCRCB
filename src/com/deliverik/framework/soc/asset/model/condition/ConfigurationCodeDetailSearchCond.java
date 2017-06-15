/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
 * <p>
 * 资产模型属性取值范围检索条件
 * </p>
 * <p>
 * <br>
 * <table border="1">
 * <tr>
 * <td>ccdcategory</td>
 * <td>资产属性取值范围标识</td>
 * </tr>
 * <tr>
 * <td>ccdstatus</td>
 * <td>资产属性取值范围状态<br>0:停用<br>1:启用</td>
 * </tr> 
 * <tr>
 * <td>ccdtype</td>
 * <td>资产属性取值范围所属应用<br>"A":表示资产用<br>其他:未使用</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface ConfigurationCodeDetailSearchCond {

	/**
	 * 资产属性取值范围标识取得
	 * @return 资产属性取值范围标识
	 */
	public String getCcdcategory();

	/**
	 * 资产属性取值范围状态取得
	 * @return 资产属性取值范围状态
	 */
	public String getCcdstatus();

	/**
	 * 资产属性取值范围所属应用取得
	 * @return 资产属性取值范围所属应用
	 */
	public String getCcdtype();

}

/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
 * <p>
 * 机房信息检索条件
 * </p>
 * <p>
 * <br>
 * <table border="1">
 * <tr>
 * <td>eiid</td>
 * <td>机房ID</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface SOC0601SearchCond {

	/**
	 * 机房ID取得
	 * @return 机房ID
	 */
	public String getEiid();
	
	/**
	 * 关联机房属性取得
	 * @return 关联机房属性
	 */
	public String getRelateroom();
}

/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
 * <p>
 * 机房机柜统计分析信息检索条件
 * </p>
 * <p>
 * <br>
 * <table border="1">
 * <tr>
 * <td>roomeiid_q</td>
 * <td>机房ID</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface SOC0604SearchCond {
	/**
	 * 机房ID取得
	 * @return 机房ID
	 */
	public Integer getRoomeiid_q();
}

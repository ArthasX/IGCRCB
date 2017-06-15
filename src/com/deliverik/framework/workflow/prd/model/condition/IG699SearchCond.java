/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * 流程缺省参与者变量权限查询条件
 * </p>
 * <p>
 * （未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>psdid</td>
 * <td>流程状态ID</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG699SearchCond {
	
	/**
	 * 流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid();

	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public String getPdvid_like();
	
	
}

/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * 流程状态变量前处理检索条件
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
public interface IG211SearchCond {
	/**
	 * 流程状态变量前处理ID取得
	 * @return 流程状态变量前处理ID
	 */
	public String getPsidid();
	
	/**
	 * 流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid();
	
	/**
	 * 流程变量ID取得
	 * @return 流程变量ID
	 */
	public String getPidid();

	/**
	 * 流程变量名称取得
	 * @return 流程变量名称
	 */
	public String getPidname();
	
	/**
	 * 流程变量类型取得
	 * @return 流程变量类型
	 */
	public String getPidtype();

	/**
	 * 流程变量值取得
	 * @return 流程变量值
	 */
	public String getPidvalue();
	
	/**
	 * 主键取得
	 * 
	 * @return 主键 
	 */
	public String getPsidid_like();
}

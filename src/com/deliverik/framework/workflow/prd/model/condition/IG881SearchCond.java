/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * 流程参与者变量权限查询条件
 * </p>
 * <p>
 * （未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>psdid</td>
 * <td>流程状态ID</td>
 * </tr>
 * <tr>
 * <td>ppdid</td>
 * <td>流程参与者ID</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG881SearchCond {
	/**
	 * 流程参与者变量权限ID取得
	 * @return 流程参与者变量权限ID
	 */
	public String getPipdid();
	
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
	 * 流程参与者变量权限取得
	 * @return 流程参与者变量权限
	 */
	public String getPidaccess();
	
	/**
	 * 流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid();
	
	/**
	 * 流程参与者ID取得
	 * @return 流程参与者ID
	 */
	public String getPpdid();
	
	/**
	 * 流程ID取得
	 * @return 流程ID
	 */
	public String getPdid();

	/**
	 * 流程参与者变量权限ID取得
	 * 
	 * @return 流程参与者变量权限ID
	 */
	public String getPipdid_like();
	
}

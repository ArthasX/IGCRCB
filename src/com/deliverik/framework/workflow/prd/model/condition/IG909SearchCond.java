package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * 流程缺省变量权限视图检索条件
 * </p>
 * <p>
 * （未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>psdid</td>
 * <td>流程状态ID</td>
 * </tr>
 * <tr>
 * <td>pdid</td>
 * <td>流程类型ID</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG909SearchCond {
	
	/**
	 * 流程状态ID取得
	 * 
	 * @return 流程状态ID
	 */
	public String getPsdid();
	
	/**
	 * 流程类型ID取得
	 * 
	 * @return 流程类型ID
	 */
	public String getPdid();

}

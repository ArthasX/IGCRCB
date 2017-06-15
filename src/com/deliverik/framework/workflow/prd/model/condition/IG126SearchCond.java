package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * 流程页面定义信息检索条件
 * </p>
 * <p>
 * （未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>pdid</td>
 * <td>流程定义ID</td>
 * </tr>
 * <tr>
 * <td>pjdtype</td>
 * <td>页面类型</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface IG126SearchCond {
	
	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public String getPdid();
	
	/**
	 * 页面类型取得
	 * 
	 * @return 页面类型
	 */
	public String getPjdtype();

	/**
	 * 流程页面定义ID取得
	 * 
	 * @return 流程页面定义ID
	 */
	public String getPjdid_like();
}

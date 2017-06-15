package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * 流程事件定义信息检索条件
 * </p>
 * <p>
 * （未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>pdid</td>
 * <td>流程定义ID</td>
 * </tr>
 * <tr>
 * <td>psdid</td>
 * <td>状态ID</td>
 * </tr>
 * <tr>
 * <td>pedtype</td>
 * <td>事件类型</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface IG413SearchCond {
	
	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public String getPdid();
	
	/**
	 * 状态ID取得
	 * 
	 * @return 状态ID
	 */
	public String getPsdid();

	/**
	 * 事件类型取得
	 * 
	 * @return 事件类型
	 */
	public String getPedtype();

	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public String getPedid_like();
}

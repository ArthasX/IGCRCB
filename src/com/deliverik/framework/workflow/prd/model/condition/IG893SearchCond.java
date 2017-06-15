package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * 流程参与者变量权限视图检索条件
 * </p>
 * <p>
 * （未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>流程状态ID</td>
 * <td>流程定义ID</td>
 * </tr>
 * <tr>
 * <td>roleid</td>
 * <td>流程参与者角色ID</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG893SearchCond {
	
	/**
	 * 流程状态ID取得
	 * 
	 * @return 流程状态ID
	 */
	public String getPsdid();
	
	/**
	 * 流程参与者角色ID取得
	 * 
	 * @return 流程参与者角色ID
	 */
	public Integer getRoleid();
	
	/**
	 * 表单全局控制节点id集合取得
	 * @return 表单全局控制节点id
	 */
	public String getFormGlobalPsdids();

}

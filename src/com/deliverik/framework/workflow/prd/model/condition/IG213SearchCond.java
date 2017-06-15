/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * 流程状态检索条件
 * </p>
 * <p>
 * （未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>pdid</td>
 * <td>流程名称ID</td>
 * </tr>
 * <tr>
 * <td>psdid</td>
 * <td>流程状态ID</td>
 * </tr>
 * <tr>
 * <td>psdname</td>
 * <td>流程状态名称</td>
 * </tr>
 * <tr>
 * <td>psdcode</td>
 * <td>流程状态标识</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG213SearchCond {
	/**
	 * 流程角色类型定义ID取得
	 * @return 流程角色类型定义ID
	 */
	public String getPrtdid();
	
	/**
	 * 流程名称ID取得
	 * @return 流程名称ID
	 */
	public String getPdid();

	/**
	 * 流程角色类型取得
	 * @return 流程角色类型
	 */
	public String getRoletype();

	/**
	 * 流程状态ID取得
	 * 
	 * @return 流程状态ID
	 */
	public String getPrtdid_like();
}

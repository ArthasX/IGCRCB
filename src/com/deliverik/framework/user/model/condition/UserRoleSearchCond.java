package com.deliverik.framework.user.model.condition;

/**
 * <p>
 * 用户角色授权信息检索条件
 * </p>
 * <p>
 * (未做说明的属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>userid</td>
 * <td>用户ID</td>
 * </tr> 
 * <tr>
 * <td>roleid</td>
 * <td>用户角色ID</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface UserRoleSearchCond {
	
	/**
	 * 用户ID取得
	 * @return 用户ID
	 */
	public String getUserid();
	
	/**
	 * 用户角色ID取得
	 * @return 用户角色ID
	 */
	public Integer getRoleid();

}

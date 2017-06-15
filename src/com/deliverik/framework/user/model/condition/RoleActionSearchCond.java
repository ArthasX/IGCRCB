package com.deliverik.framework.user.model.condition;

/**
 * <p>
 * 角色菜单授权信息检索条件
 * </p>
 * <p>
 * (未做说明的属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>roleid</td>
 * <td>角色ID</td>
 * </tr> 
 * <tr>
 * <td>actname</td>
 * <td>菜单ID</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface RoleActionSearchCond {
	
	/**
	 * 角色ID取得
	 * @return 角色ID
	 */
	public  Integer getRoleid();
	
	/**
	 * 菜单ID取得
	 * @return 菜单ID
	 */
	public String getActname();
	
}

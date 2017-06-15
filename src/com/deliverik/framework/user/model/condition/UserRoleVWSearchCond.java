package com.deliverik.framework.user.model.condition;

import java.util.List;

/**
 * <p>
 * 用户角色授权信息检索条件
 * </p>
 * <p>
 * (未做说明的属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>roleid</td>
 * <td>角色ID</td>
 * </tr> 
 * <tr>
 * <td>roleid</td>
 * <td>用户角色ID</td>
 * </tr> 
 * <tr>
 * <td>roletype</td>
 * <td>用户角色类型</td>
 * </tr> 
 * <tr>
 * <td>roles_Like</td>
 * <td>用户角色类型（前方一致模糊匹配）</td>
 * </tr> 
 * <tr>
 * <td>roles_BP_EX</td>
 * <td>扩展用户角色类型（只能与roles_Like并用，取并集。区间匹配）</td>
 * </tr> 
 * <tr>
 * <td>isRolemanager</td>
 * <td>角色负责人（当值为true时查询出角色负责人，其他值时不过滤）</td>
 * </tr> 
 * <tr>
 * <td>dutyflag</td>
 * <td>角色值班人（当值为true时查询出角色值班人，其他值时不过滤）</td>
 * </tr> 
 * <tr>
 * <td>assetdomain</td>
 * <td>角色管理内容</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface UserRoleVWSearchCond {
	
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

	/**
	 * 用户角色类型取得
	 * @return 用户角色类型
	 */
	public String getRoletype();
	
	/**
	 * 用户角色类型取得
	 * @return 用户角色类型
	 */
	public String getRoles_Like();
	
	/**
	 * 扩展用户角色类型取得
	 * @return 扩展用户角色类型
	 */
	public String[] getRoles_BP_EX();
	
	/**
	 * 角色负责人取得
	 * @return 角色负责人取得
	 */
	public boolean isRolemanager();
	
	/**
	 * 角色值班人取得
	 * @return 角色值班人取得
	 */
	public boolean isDutyflag();
	
	/**
	 * 角色管理内容取得
	 * @return 角色管理内容
	 */
	public String getAssetdomain();
	
	/**
	 * 角色机构管理范围取得
	 * 
	 * @return 角色机构管理范围
	 */
	public String getRoledomain_like();
	
	/**
	 * 角色机构管理范围取得
	 * 
	 * @return 角色机构管理范围
	 */
	public String getRoledomain();
	
	/**
	 * 机构syscoding左侧模糊查询取得
	 *
	 * @return orgid_like 机构syscoding左侧模糊查询
	 */
	public String getOrgid_like();
	
	/**
	 * 按角色名称模糊查询取得
	 *
	 * @return rolename_like 按角色名称模糊查询
	 */
	public String getRolename_like();

	/**
	 * 按角色用户授权ID查询设定
	 *
	 * @param urid 按角色用户授权ID查询
	 */
	public void setUrid_eq(Integer urid_eq);
	
	/**
	 * 用户名取得
	 * @return username_like 用户名
	 */
	public String getUsername_like();
	
	/**
	 * 角色范围取得
	 *
	 * @return roleid_in 角色范围
	 */
	public List<Integer> getRoleid_in();
}

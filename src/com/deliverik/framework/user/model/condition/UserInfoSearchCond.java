package com.deliverik.framework.user.model.condition;

/**
 * <p>
 * 用户角色机构信息检索条件
 * </p>
 * <p>
 * (未做说明的属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>userida</td>
 * <td>用户ID</td>
 * </tr> 
 * <tr>
 * <td>username</td>
 * <td>用户姓名（模糊匹配）</td>
 * </tr> 
 * <tr>
 * <td>roleida</td>
 * <td>用户角色ID</td>
 * </tr>
 * <tr>
 * <td>rolename</td>
 * <td>用户角色名称</td>
 * </tr> 
 * <tr>
 * <td>roletype</td>
 * <td>用户角色类型</td>
 * </tr> 
 * <tr>
 * <td>orgida</td>
 * <td>用户机构层次码（前方一致模糊匹配）</td>
 * </tr> 
 * <tr>
 * <td>orgname</td>
 * <td>用户机构名称</td>
 * </tr>  
 * </table>
 * </p>
 * 
 */
public interface UserInfoSearchCond {
	
	/**
	 * 用户ID取得
	 * @return 用户ID
	 */
	public String getUserida();

	/**
	 * 用户姓名取得
	 * @return 用户姓名
	 */
	public String getUsername();
	
	/**
	 * 用户角色ID取得
	 * @return 用户角色ID
	 */
	public Integer getRoleida();

	/**
	 * 用户角色名称取得
	 * @return 用户角色名称
	 */
	public String getRolename();
	
	/**
	 * 用户角色类型取得
	 * @return 用户角色类型
	 */
	public String getRoletype();
	
	/**
	 * 用户机构层次码取得
	 * @return 用户机构层次码
	 */
	public String getOrgida();

	/**
	 * 用户机构名称取得
	 * @return 用户机构名称
	 */
	public String getOrgname();
	
	/**
	 * 工号取得
	 * @return 工号
	 */
	public String getUserinfo();
	
	/**
	 * 工号取得
	 * @return 工号
	 */
	public String getUserinfo_like();

	/**
	 * 用户名称，PMS系统对接专用取得
	 * @return username_forPms 用户名称，PMS系统对接专用
	 */
	
	public String getUsername_forPms() ;
}

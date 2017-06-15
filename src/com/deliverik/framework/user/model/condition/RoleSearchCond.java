package com.deliverik.framework.user.model.condition;

import java.util.List;

/**
 * <p>
 * 角色信息检索条件
 * </p>
 * <p>
 * (未做说明的属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>rolename</td>
 * <td>角色名称</td>
 * </tr> 
 * <tr>
 * <td>rolename_q</td>
 * <td>角色名称（前方一致模糊匹配）</td>
 * </tr> 
 * <tr>
 * <td>roletype</td>
 * <td>角色类型（当roletypeEqual等于1时，完全匹配）</td>
 * </tr> 
 * <tr>
 * <td>roletypeEqual</td>
 * <td>sql语句比较关系（值1为等于）</td>
 * </tr> 
 * <tr>
 * <td>roledomain</td>
 * <td>角色机构管理范围</td>
 * </tr> 
 * <tr>
 * <td>roledomain_Like</td>
 * <td>角色机构管理范围（前方一致模糊匹配）</td>
 * </tr> 
 * <tr>
 * <td>roles_Like</td>
 * <td>角色类型（当roletypeEqual等于1时，前方一致模糊匹配）</td>
 * </tr> 
 * <tr>
 * <td>roles_BP_EX</td>
 * <td>扩展角色类型</td>
 * </tr> 
 * <tr>
 * <td>assetdomain</td>
 * <td>角色资产管理范围</td>
 * </tr> 
 * <tr>
 * <td>assetdomain_q</td>
 * <td>角色资产管理范围（前方一致模糊匹配）</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface RoleSearchCond {
	
	/**
	 * 角色名称取得
	 * @return 角色名称
	 */
	public String getRolename();
	
	/**
	 * 角色名称取得
	 * @return 角色名称
	 */
	public String getRolename_q();
	
	/**
	 * 角色类型取得
	 * @return 角色类型
	 */
	public String getRoletype();
	
	/**
	 * SQL语句比较关系取得
	 * @return SQL语句比较关系
	 */
	public int getRoletypeEqual();
	
	/**
	 * 角色机构管理范围取得
	 * @return 角色机构管理范围
	 */
	public String getRoledomain();
	
	/**
	 * 角色机构管理范围取得
	 * @return 角色机构管理范围
	 */
	public String getRoledomain_Like();
	
	/**
	 * 角色类型取得
	 * @return 角色类型
	 */
	public String getRoles_Like();
	
	/**
	 * 扩展角色类型取得
	 * @return 扩展角色类型
	 */
	public String[] getRoles_BP_EX();
	
	/**
	 * 角色资产管理范围取得
	 * @return 角色资产管理范围
	 */
	public String getAssetdomain();

	/**
	 * 角色资产管理范围取得
	 * @return 角色资产管理范围
	 */
	public String getAssetdomain_q();
	
	/**
	 * 角色类型查询条件取得
	 * @return 角色类型查询条件
	 */
	public String getRoletype_gt();
	
	/**
	 *  自定义流程ID取得
	 * @return 自定义流程ID
	 */
	public String getPdid();
	
	/**
	 * 角色ID范围取得
	 * @return roleid_in 角色ID范围
	 */
	public List<Integer> getRoleid_in();
	
	/**
	 * 角色ID不在此范围取得
	 * @return 角色ID不在此范围
	 */
	public String getRoleid_not_in();

}

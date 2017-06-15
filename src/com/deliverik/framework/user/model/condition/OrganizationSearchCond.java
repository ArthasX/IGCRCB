package com.deliverik.framework.user.model.condition;

import java.util.List;

/**
 * <p>
 * 机构信息检索条件
 * </p>
 * <p>
 * (未做说明的属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>orgname</td>
 * <td>机构名称</td>
 * </tr> 
 * <tr>
 * <td>orgname_q</td>
 * <td>机构名称（模糊匹配）</td>
 * </tr> 
 * <tr>
 * <td>orgpar</td>
 * <td>上级机构层次码</td>
 * </tr> 
 * <tr>
 * <td>is_in_use</td>
 * <td>机构状态</td>
 * </tr> 
 * <tr>
 * <td>orgparid</td>
 * <td>上级机构层次码</td>
 * </tr> 
 * <tr>
 * <td>orgsuper</td>
 * <td>上级机构层次码（当值不为空，且不等于0时，查询根节点以外的机构）</td>
 * </tr> 
 * <tr>
 * <td>orgsyscoding</td>
 * <td>机构层次码</td>
 * </tr> 
 * <tr>
 * <td>roledomain_q</td>
 * <td>角色机构管理范围（前方一致模糊匹配）</td>
 * </tr> 
 * <tr>
 * <td>orgparstr_q</td>
 * <td>上级机构层次码（前方一致模糊匹配，不包括orgparstr_q的值本身）</td>
 * </tr> 
 * <tr>
 * <td>orgsyscoding_q</td>
 * <td>机构层次码</td>
 * </tr> 
 * <tr>
 * <td>syscoding_area</td>
 * <td>机构层次码集合（区间匹配）</td>
 * </tr> 
 * <tr>
 * <td>sortType</td>
 * <td>排序方式（传入CommonDefineUtils.SORT_BY_ORGSYSCODING则按照机构层次码升序排序）</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface OrganizationSearchCond {
	
	/**
	 * 机构名称取得
	 * @return 机构名称
	 */
	public String getOrgname();

	/**
	 * 机构名称取得
	 * @return 机构名称
	 */
	public String getOrgname_q();

	/**
	 * 上级机构层次码取得
	 * @return 上级机构层次码
	 */
	public String getOrgpar();

	/**
	 * 机构状态取得
	 * @return 机构状态
	 */
	public String getIs_in_use();

	/**
	 * 上级机构层次码取得
	 * @return 上级机构层次码
	 */
	public String getOrgparid();

	/**
	 * 上级机构层次码取得
	 * @return 上级机构层次码
	 */
	public Integer getOrgsuper();

	/**
	 * 机构层次码取得
	 * @return 机构层次码
	 */
	public String getOrgsyscoding();

	/**
	 * 角色机构管理范围取得
	 * @return 角色机构管理范围
	 */
	public String getRoledomain_q();

	/**
	 * 角色机构管理范围结点全名取得（平台保留）
	 * @return 角色机构管理范围结点全名
	 */
	public String getComplete_name();

	/**
	 * 上级机构层次码取得
	 * @return 上级机构层次码
	 */
	public String getOrgparstr_q();

	/**
	 * 机构层次码取得
	 * @return 机构层次码
	 */
	public String getOrgsyscoding_q();
	
	/**
	 * 机构层次码集合取得
	 * @return 机构层次码集合
	 */
	public List<String> getSyscoding_area();
	
	/**
	 * 排序方式取得
	 * @return 排序方式
	 */
	public String getSortType();
	
	/**
	 * 机构层次码集合取得（平台保留）
	 * @return 机构层次码集合
	 */
	public List<String> getNot_in_syscoding_area();
	
	/**
	 * 需要过滤的机构层次码取得（平台保留）
	 * @return 需要过滤的机构层次码
	 */
	public String getXbtype();
	
	/**
	 * 机构名称(模糊查询)取得
	 *
	 * @return orgname_like 机构名称(模糊查询)
	 */
	public String getOrgname_like();
}

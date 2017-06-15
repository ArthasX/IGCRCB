package com.deliverik.framework.user.model.condition;

import java.util.List;

/**
 * <p>
 * 用户信息检索条件
 * </p>
 * <p>
 * (未做说明的属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>userid</td>
 * <td>用户ID</td>
 * </tr> 
 * <tr>
 * <td>userid_q</td>
 * <td>用户ID（模糊匹配）</td>
 * </tr> 
 * <tr>
 * <td>username</td>
 * <td>用户姓名</td>
 * </tr> 
 * <tr>
 * <td>username_q</td>
 * <td>用户姓名（模糊匹配）</td>
 * </tr>
 * <tr>
 * <td>password</td>
 * <td>用户口令</td>
 * </tr> 
 * <tr>
 * <td>orgid</td>
 * <td>用户机构层次码（前方一致模糊匹配）</td>
 * </tr> 
 * <tr>
 * <td>usermobile</td>
 * <td>用户手机</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface UserSearchCond {
	
	/**
	 * 用户ID取得
	 * @return 用户ID
	 */
	public String getUserid();
	
	/**
	 * 用户ID取得
	 * @return 用户ID
	 */
	public String getUserid_q();
	
	/**
	 * 用户姓名取得
	 * @return 用户姓名
	 */
	public String getUsername();
	
	/**
	 * 用户姓名取得
	 * @return 用户姓名
	 */
	public String getUsername_q();

	/**
	 * 用户口令取得
	 * @return 用户口令
	 */
	public String getPassword();
	
	/**
	 * 用户机构层次码取得
	 * @return 用户机构层次码
	 */
	public String getOrgid();
	
	/**
	 * 用户机构层次码取得
	 * @return 用户机构层次码
	 */
	public String getOrgid_like();
	
	/**
	 * 用户手机取得
	 * @return 用户手机
	 */
	public String getUsermobile();

	/**
	 * 逻辑删除标志位取得
	 * @return 逻辑删除标志位
	 */
	public String getDeleteflag();
	
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
	 * 用户ID范围取得
	 * @return userid_in 用户ID范围
	 */
	public List<String> getUserid_in();
}

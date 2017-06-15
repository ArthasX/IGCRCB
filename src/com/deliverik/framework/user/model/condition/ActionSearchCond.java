package com.deliverik.framework.user.model.condition;

/**
 * <p>
 * 菜单信息检索条件
 * </p>
 * <p>
 * (未做说明的属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>actlabel</td>
 * <td>菜单显示名称</td>
 * </tr>
 * <tr>
 * <td>actroletype</td>
 * <td>菜单可授予角色类型（模糊匹配）</td>
 * </tr>
 * <tr>
 * <td>actname</td>
 * <td>菜单名称</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface ActionSearchCond {
	
	/**
	 * 菜单显示名称取得
	 * @return 菜单显示名称
	 */
	public String getActlabel();
	
	/**
	 * 菜单可授予角色类型取得
	 * @return 菜单可授予角色类型
	 */
	public String getActroletype();
	
	/**
	 * 菜单名称取得
	 * @return 菜单名称
	 */
	public String getActname_like();
	
	/**
	 * URL取得
	 * @return URL名称
	 */
	public String getActurl_like();
	
	/**
     * 菜单类型取得
     * @return 菜单类型
     */
    public String getActtype();
    
    /**
     * @return the 自定义流程自动生成菜单的状态标记（1代表无效）
     */
    public String getActl1id();
}

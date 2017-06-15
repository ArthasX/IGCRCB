package com.deliverik.framework.user.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * 菜单信息
 * </p>
 */
public interface Action  extends BaseModel {

	/**
	 * 菜单ID取得
	 * @return 菜单ID
	 */
	public String getActname();
	
	/**
	 * 菜单显示名称取得
	 * @return 菜单显示名称
	 */
	public  String getActlabel();

	/**
	 * 菜单描述取得
	 * @return 菜单描述
	 */
	public  String getActdesc();

	/**
	 * 菜单URL取得
	 * @return 菜单URL
	 */
	public  String getActurl();

	/**
	 * 菜单类型取得
	 * @return 菜单类型
	 */
	public  String getActtype();

	/**
	 * 一级菜单ID取得
	 * @return 一级菜单ID
	 */
	public  Integer getActl1id();

	/**
	 * 二级菜单ID取得
	 * @return 二级菜单ID
	 */
	public  Integer getActl2id();

	/**
	 * 三级菜单ID取得
	 * @return 三级菜单ID
	 */
	public  Integer getActl3id();
	
	/**
	 * 菜单可授予角色类型(逗号分割)取得
	 * @return 菜单可授予角色类型(逗号分割)
	 */
	public  String getActroletype();

	/**
	 * 菜单排序ID取得
	 * @return 菜单排序ID
	 */
	public String getActsortid();
	
	/**
	 * 菜单URL类型取得
	 * @return 菜单URL类型
	 */
	public String getActurltype();

}
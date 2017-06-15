/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: 授权管理_资源组授权
 * @Author  lujiayuan
 * @History 2010/11/19 新建
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGSYM0422Form extends BaseForm {
	/** 角色ID(HQ中) */
	protected String roleid;
	
	/** 角色名称(HQ同步) */
	protected String rolename;
	
	/** 资源组ID(组) 添加 */
	protected String[] ids_add;
	/** 资源组ID(组) 删除 */
	protected String[] ids_del;

	/**
	 * getter and setter
	 */
	/**
	 * 角色ID(HQ中)取得
	 *
	 * @return roleid 角色ID(HQ中)
	 */
	public String getRoleid() {
		return roleid;
	}

	/**
	 * 角色ID(HQ中)设定
	 *
	 * @param roleid 角色ID(HQ中)
	 */	
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
	
	/**
	 * 角色名称(HQ同步)取得
	 *
	 * @return rolename 角色名称(HQ同步)
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * 角色名称(HQ同步)设定
	 *
	 * @param rolename 角色名称(HQ同步)
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * 资源组ID(组)添加取得
	 *
	 * @return ids_add 资源组ID(组)添加
	 */
	public String[] getIds_add() {
		return ids_add;
	}

	/**
	 * 资源组ID(组)添加设定
	 *
	 * @param ids_add 资源组ID(组)添加
	 */
	public void setIds_add(String[] ids_add) {
		this.ids_add = ids_add;
	}

	/**
	 * 资源组ID(组)删除取得
	 *
	 * @return ids_del 资源组ID(组)删除
	 */
	public String[] getIds_del() {
		return ids_del;
	}

	/**
	 * 资源组ID(组)删除设定
	 *
	 * @param ids_del 资源组ID(组)删除
	 */
	public void setIds_del(String[] ids_del) {
		this.ids_del = ids_del;
	}
}

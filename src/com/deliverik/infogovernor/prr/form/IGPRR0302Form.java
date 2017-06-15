/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 角色查询form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR0302Form extends BaseForm{
	
	/** 角色名称 */
	protected String rolename_q;
	
	/** 角色类型 */
	protected String roletype;
	
	/** 角色id集合 */
	protected String roleids;
	
	/** 添加标识 A 复制人；B 值班人 ； C 执行人 */
	protected String addFlag;
	
	/** 新增内容 */
	protected String[] addContent;
	
	/** 角色类型不可选标识 */
	protected String disabled;
	
	/** 角色ID集合 */
	protected String roleidin;

	/**
	 * 角色名称取得
	 * @return 角色名称
	 */
	public final String getRolename_q() {
		return rolename_q;
	}

	/**
	 * 角色名称设定
	 * @param rolename_q 角色名称
	 */
	public final void setRolename_q(String rolename_q) {
		this.rolename_q = rolename_q;
	}

	/**
	 * 角色类型取得
	 * @return 角色类型
	 */
	public final String getRoletype() {
		return roletype;
	}

	/**
	 * 角色类型设定
	 * @param roletype 角色类型
	 */
	public final void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	/**
	 * 角色id集合取得
	 * @return 角色id
	 */
	public final String getRoleids() {
		return roleids;
	}

	/**
	 * 角色id集合设定
	 * @param roleids 角色id集合
	 */
	public final void setRoleids(String roleids) {
		this.roleids = roleids;
	}
	
	/**
	 * 重写reset方法清空原form值
	 */
	public void reset() {
		this.rolename_q = null;
		this.roletype = null;
		this.disabled = null;
		this.roleids = null;
		this.roleidin = null;
	}

	/**
	 * 新增标识取得
	 * @return 新增标识
	 */
	public final String getAddFlag() {
		return addFlag;
	}

	/**
	 * 新增标识设定
	 * @param addFlag 新增标识
	 */
	public final void setAddFlag(String addFlag) {
		this.addFlag = addFlag;
	}

	/**
	 * 新增内容取得
	 * @return 新增内容
	 */
	public final String[] getAddContent() {
		return addContent;
	}

	/**
	 * 新增内容舌定
	 * @param addContent 新增内容
	 */
	public final void setAddContent(String[] addContent) {
		this.addContent = addContent;
	}

	/**
	 * 角色类型不可选标识取得
	 * @return disabled 角色类型不可选标识
	 */
	public String getDisabled() {
		return disabled;
	}

	/**
	 * 角色类型不可选标识设定
	 * @param disabled 角色类型不可选标识
	 */
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	/**
	 * 角色ID集合取得
	 * @return roleidin 角色ID集合
	 */
	public String getRoleidin() {
		return roleidin;
	}

	/**
	 * 角色ID集合设定
	 * @param roleidin 角色ID集合
	 */
	public void setRoleidin(String roleidin) {
		this.roleidin = roleidin;
	}
}

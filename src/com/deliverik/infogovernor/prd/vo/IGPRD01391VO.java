/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prd.model.IG298Info;

/**
 * 概述: 流程状态参与角色定义VO
 * 功能描述: 流程状态参与角色定义VO
 * 创建记录: 2012/04/11
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGPRD01391VO extends BaseVO implements Serializable {

	/** 可选角色列表 */
	protected List<Role> lst_Role;
	
	/** 已选角色列表  */
	protected List<IG298Info> lst_ProcessStatusRoleDef;

	/**
	 * 可选角色列表取得
	 * 
	 * @return 可选角色列表
	 */
	public List<Role> getLst_Role() {
		return lst_Role;
	}

	/**
	 * 可选角色列表设定
	 * 
	 * @param lst_Role 可选角色列表
	 */
	public void setLst_Role(List<Role> lst_Role) {
		this.lst_Role = lst_Role;
	}

	/**
	 * 已选角色列表取得
	 * 
	 * @return 已选角色列表
	 */
	public List<IG298Info> getLst_ProcessStatusRoleDef() {
		return lst_ProcessStatusRoleDef;
	}

	/**
	 * 已选角色列表设定
	 * 
	 * @param lst_ProcessStatusRoleDef 已选角色列表
	 */
	public void setLst_ProcessStatusRoleDef(
			List<IG298Info> lst_ProcessStatusRoleDef) {
		this.lst_ProcessStatusRoleDef = lst_ProcessStatusRoleDef;
	}
	
}

/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserInfo;

/**
 * @Description: 流程定义_参与者Vo
 * @Author  
 * @History 2009-8-23     新建 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRR01035VO extends BaseVO implements Serializable {
	
	/** 角色 */
	private Role role;
	
	/** 机构 */
	private Organization org;
	
	/** 用户列表 */
	private List<UserInfo> lst_UserInfo;
	
	/**
	 * 机构取得
	 *
	 * @return org 机构
	 */
	public Organization getOrg() {
		return org;
	}

	/**
	 * 机构设定
	 *
	 * @param org 机构
	 */
	public void setOrg(Organization org) {
		this.org = org;
	}

//	/**
//	 * 构造函数
//	 * 
//	 * @param role 角色
//	 * @param lst_UserInfo 用户列表
//	 */
//	public IGPRR01035VO(Role role, List<UserInfo> lst_UserInfo) {
//		this.role = role;
//		this.lst_UserInfo = lst_UserInfo;
//	}

	/**
	 * 角色设定
	 *
	 * @param role 角色
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * 用户列表设定
	 *
	 * @param lst_UserInfo 用户列表
	 */
	public void setLst_UserInfo(List<UserInfo> lst_UserInfo) {
		this.lst_UserInfo = lst_UserInfo;
	}

	/**
	 * 角色取得
	 * 
	 * @return 角色
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * 用户列表取得
	 * 
	 * @return 用户列表
	 */
	public List<UserInfo> getLst_UserInfo() {
		return lst_UserInfo;
	}

}

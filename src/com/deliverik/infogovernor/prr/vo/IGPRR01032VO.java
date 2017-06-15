/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserRoleInfo;

/**
 * @Description: 流程定义_参与者Vo
 * @Author  
 * @History 2009-8-23     新建 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRR01032VO extends BaseVO implements Serializable {
	
	/** 角色 */
	private Role role;
	
	/** 用户列表 */
	private List<UserRoleInfo> lst_UserRoleInfo;
	
	/**
	 * 构造函数
	 * 
	 * @param role 角色
	 * @param lst_UserRoleInfo 用户列表
	 */
	public IGPRR01032VO(Role role, List<UserRoleInfo> lst_UserRoleInfo) {
		this.role = role;
		this.lst_UserRoleInfo = lst_UserRoleInfo;
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
	public List<UserRoleInfo> getLst_UserRoleInfo() {
		return lst_UserRoleInfo;
	}

}

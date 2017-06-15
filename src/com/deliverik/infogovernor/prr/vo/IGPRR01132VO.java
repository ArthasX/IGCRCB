/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prr.model.IG602Info;

/**
 * @Description: 流程定义_参与者Vo
 * @Author  
 * @History 2009-8-23     新建 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRR01132VO extends BaseVO implements Serializable {
	
	/** 角色 */
	private Role role;
	
	/** 用户列表 */
	private List<IG602Info> lst_ProcessExecutorVWInfo;
	
	/**
	 * 构造函数
	 * 
	 * @param role 角色
	 * @param lst_ProcessExecutorVWInfo 用户列表
	 */
	public IGPRR01132VO(Role role, List<IG602Info> lst_ProcessExecutorVWInfo) {
		this.role = role;
		this.lst_ProcessExecutorVWInfo = lst_ProcessExecutorVWInfo;
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
	public List<IG602Info> getLst_ProcessExecutorVWInfo() {
		return lst_ProcessExecutorVWInfo;
	}

}

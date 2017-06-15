/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.prj.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.infogovernor.prj.model.Project;

public class IGPRJ0104VO extends BaseVO implements Serializable{

	private static final long serialVersionUID = 6062462392118956960L;
	
	protected Integer pid;

	protected List<Role> roleList;

	protected List<String> principalList;
	
	protected Project project;
	
	protected Map<String,List<Role>> roleMap;
	
	public Map<String, List<Role>> getRoleMap() {
		return roleMap;
	}

	public void setRoleMap(Map<String, List<Role>> roleMap) {
		this.roleMap = roleMap;
	}
	
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<String> getPrincipalList() {
		return principalList;
	}

	public void setPrincipalList(List<String> principalList) {
		this.principalList = principalList;
	}
	
}

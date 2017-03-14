/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_授权管理_角色授权VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM04101VO extends BaseVO implements Serializable {

	/**
	 * 未授权角色对象List
	 */
	
	protected List<Role> roleList;
	
	/**
	 * 已授权角色对象List
	 */
	
	protected List<Role> yroleList;
	
	
	protected Map<String,List<Role>> roleMap;

	/**
	 * 构造方法
	 * @param roleList List<Role>,ownRoleList List<RoleReport>
	 */
	

	
	public IGSYM04101VO(List<Role> roleList,List<Role> yroleList) {
		this.roleList = roleList;
		this.yroleList = yroleList;
	}
	
	/**
	 * 获取未授权角色对象List
	 * @return List<UserRoleInfo>
	 */
	
	public List<Role> getRoleList() {
		return roleList;
	}

	public List<Role> getYroleList() {
		return yroleList;
	}

	public Map<String, List<Role>> getRoleMap() {
		return roleMap;
	}

	public void setRoleMap(Map<String, List<Role>> roleMap) {
		this.roleMap = roleMap;
	}
	


	
}

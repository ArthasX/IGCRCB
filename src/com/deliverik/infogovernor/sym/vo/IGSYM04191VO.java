/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.Map;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.infogovernor.sym.model.UserNotRole;

/**
 * @Description: 角色管理_角色负责人
 * @Author  
 * @History 2009-8-18     新建 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGSYM04191VO extends BaseVO implements Serializable {

	/**
	 * 角色info
	 */
	protected Role roleInfo;

	/**
	 * 用户list
	 */
	protected List<User> userList;
	
	/**
	 * 角色负责人map
	 */
	protected Map<Integer, UserInfo> userInfoMap;
	
	/**
	 * 用户list
	 */
	protected List<UserInfo> userInfoList;

	/**
	 * 用户list
	 */
	protected List<UserNotRole> userNotRoleList;

	/**
	 * 关闭页面标示
	 */
	protected String sign;
	
	/**
	 * 角色ID
	 */
	protected String roleid;
	/**
	 * 构造方法
	 * @param userInfoMap Map<Integer, UserInfo>
	 */
	
	public IGSYM04191VO(List<UserNotRole> userNotRoleList , Role roleInfo) {
		this.userNotRoleList = userNotRoleList;
		this.roleInfo = roleInfo;
	}
	
	public IGSYM04191VO(String sign , String roleid) {
		this.sign = sign;
		this.roleid = roleid;
	}
	
	public Role getRoleInfo() {
		return roleInfo;
	}

	public void setRoleInfo(Role roleInfo) {
		this.roleInfo = roleInfo;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Map<Integer, UserInfo> getUserInfoMap() {
		return userInfoMap;
	}

	public void setUserInfoMap(Map<Integer, UserInfo> userInfoMap) {
		this.userInfoMap = userInfoMap;
	}

	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}

	public List<UserNotRole> getUserNotRoleList() {
		return userNotRoleList;
	}

	public void setUserNotRoleList(List<UserNotRole> userNotRoleList) {
		this.userNotRoleList = userNotRoleList;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

}

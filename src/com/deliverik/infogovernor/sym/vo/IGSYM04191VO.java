/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * @Description: ��ɫ����_��ɫ������
 * @Author  
 * @History 2009-8-18     �½� 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGSYM04191VO extends BaseVO implements Serializable {

	/**
	 * ��ɫinfo
	 */
	protected Role roleInfo;

	/**
	 * �û�list
	 */
	protected List<User> userList;
	
	/**
	 * ��ɫ������map
	 */
	protected Map<Integer, UserInfo> userInfoMap;
	
	/**
	 * �û�list
	 */
	protected List<UserInfo> userInfoList;

	/**
	 * �û�list
	 */
	protected List<UserNotRole> userNotRoleList;

	/**
	 * �ر�ҳ���ʾ
	 */
	protected String sign;
	
	/**
	 * ��ɫID
	 */
	protected String roleid;
	/**
	 * ���췽��
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

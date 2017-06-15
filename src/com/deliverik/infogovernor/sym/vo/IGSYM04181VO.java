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

/**
 * @Description: ��ɫ����_��ɫ������
 * @Author  
 * @History 2009-8-18     �½� 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGSYM04181VO extends BaseVO implements Serializable {

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
	 * ���췽��
	 * @param userInfoMap Map<Integer, UserInfo>
	 */
	
	public IGSYM04181VO(List<UserInfo> userInfoList , Role roleInfo) {
		this.userInfoList = userInfoList;
		this.roleInfo = roleInfo;
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

}

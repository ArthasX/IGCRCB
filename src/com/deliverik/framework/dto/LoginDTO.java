package com.deliverik.framework.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;


/**
 *
 */
@SuppressWarnings("serial")
public class LoginDTO extends BaseDTO implements Serializable{

	protected User user;
	
	protected List<UserRoleInfo> userRoleInfoList;

	protected String errorMessage;

	/**
	 * 
	 * @return User
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 */
	public void setErrorMessage(String message) {
		errorMessage = message;
	}

	public List<UserRoleInfo> getUserRoleInfoList() {
		return userRoleInfoList;
	}

	public void setUserRoleInfoList(List<UserRoleInfo> userRoleInfoList) {
		this.userRoleInfoList = userRoleInfoList;
	}

}

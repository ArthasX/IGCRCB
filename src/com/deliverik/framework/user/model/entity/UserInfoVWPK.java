package com.deliverik.framework.user.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * <p>
 * 用户信息实体主键
 * </p>
 */
@SuppressWarnings("serial")
public class UserInfoVWPK extends BasePK implements Serializable {

	/** 用户ID */
	protected String userida;

	/** 用户角色ID */
	protected Integer roleida;
	
	/**
	 * 构造函数
	 */
	public UserInfoVWPK(){}
	
	/**
	 * 构造函数
	 */
	public UserInfoVWPK(String userida, Integer roleida) {
		this.userida = userida;
		this.roleida = roleida;
	}
}

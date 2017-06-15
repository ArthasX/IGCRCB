package com.deliverik.framework.user.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * <p>
 * �û���Ϣʵ������
 * </p>
 */
@SuppressWarnings("serial")
public class UserInfoVWPK extends BasePK implements Serializable {

	/** �û�ID */
	protected String userida;

	/** �û���ɫID */
	protected Integer roleida;
	
	/**
	 * ���캯��
	 */
	public UserInfoVWPK(){}
	
	/**
	 * ���캯��
	 */
	public UserInfoVWPK(String userida, Integer roleida) {
		this.userida = userida;
		this.roleida = roleida;
	}
}

package com.deliverik.framework.user.model.condition;

/**
 * �û���ɫ��Ȩ��Ϣ��������ʵ��
 * 
 */
public class UserRoleSearchCondImpl implements UserRoleSearchCond {

	/** �û�ID */
	protected String userid;
	
	/** �û���ɫID */
	protected Integer roleid;
	
	/**
	 * �û�IDȡ��
	 * @return �û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �û�ID�趨
	 *
	 * @param userid �û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * �û���ɫIDȡ��
	 * @return �û���ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * �û���ɫID�趨
	 *
	 * @param roleid �û���ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
}

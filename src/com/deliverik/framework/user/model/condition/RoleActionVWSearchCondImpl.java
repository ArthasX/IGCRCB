package com.deliverik.framework.user.model.condition;

/**
 * ��ɫ�˵���Ȩ��Ϣ��������ʵ��
 * 
 */
public class RoleActionVWSearchCondImpl implements RoleActionVWSearchCond {

	/** ��ɫID */
	protected Integer roleid;
	
	/** �˵�ID */
	protected String actname;
	
	/**
	 * ��ɫIDȡ��
	 * @return ��ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ��ɫID�趨
	 *
	 * @param roleid ��ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * �˵�IDȡ��
	 * @return �˵�ID
	 */
	public String getActname() {
		return actname;
	}

	/**
	 * �˵�ID�趨
	 *
	 * @param actname �˵�ID
	 */
	public void setActname(String actname) {
		this.actname = actname;
	}
	
}

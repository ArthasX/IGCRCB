/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.resultset;

/**
 * ���̱���Ϣ
 */
public class PrivateProcessForm implements PrivateProcessFormInfo {
	
	/** �����߽�ɫID */
	private Integer roleid;
	
	/** �������û�ID */
	private String userid;

	/** ��ֵ */
	private String value;
	
	/** ��ע��Ϣ */
	private String comment;
	
	/**
	 * �����߽�ɫIDȡ��
	 *
	 * @return �����߽�ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * �������û�IDȡ��
	 * 
	 * @return �������û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * ��ֵȡ��
	 *
	 * @return ��ֵ
	 */
	public String getValue() {
		return value;
	}

	/**
	 * �����߽�ɫID�趨
	 *
	 * @param roleid �����߽�ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
	/**
	 * �������û�ID�趨
	 * 
	 * @param userid �������û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ��ֵ�趨
	 *
	 * @param value ��ֵ
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * ��ע��Ϣȡ��
	 * @return comment ��ע��Ϣ
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * ��ע��Ϣ�趨
	 * @param comment ��ע��Ϣ
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

}

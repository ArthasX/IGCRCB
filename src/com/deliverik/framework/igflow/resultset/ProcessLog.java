/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.resultset;

/**
 * ������־��Ϣ
 */
public class ProcessLog implements ProcessLogInfo {
	
	/** �ύʱ�� */
	private String committime;

	/** ��־ID */
	public Integer plid;

	/** ״̬ID */
	private String psdid;

	/** �����¼ */
	private String record;
	
	/** �����ɫID */
	private Integer roleid;

	/** �����ɫ���� */
	private String rolename;

	/** ������ID */
	private String userid;
	
	/** ���������� */
	private String username;
	
	/**
	 * �ύʱ��ȡ��
	 * @return �ύʱ��
	 */
	public String getCommittime() {
		return committime;
	}

	/**
	 * ��־ID�趨
	 * @param committime ��־ID
	 */
	public void setCommittime(String committime) {
		this.committime = committime;
	}

	/**
	 * ��־IDȡ��
	 * @return ��־ID
	 */
	public Integer getPlid() {
		return plid;
	}


	/**
	 * �ύʱ���趨
	 * @param committime �ύʱ��
	 */
	public void setPlid(Integer plid) {
		this.plid = plid;
	}

	/**
	 * ״̬IDȡ��
	 * @return ״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ״̬ID�趨
	 * @param psdid ״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * �����¼ȡ��
	 * @return �����¼
	 */
	public String getRecord() {
		return record;
	}

	/**
	 * �����¼�趨
	 * @param record �����¼
	 */
	public void setRecord(String record) {
		this.record = record;
	}

	/**
	 * �����ɫIDȡ��
	 * @return �����ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * �����ɫID�趨
	 * @param roleid �����ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * �����ɫ����ȡ��
	 * @return �����ɫ����
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * �����ɫ�����趨
	 * @param rolename �����ɫ����
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	/**
	 * ������IDȡ��
	 * @return ������ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * ������ID�趨
	 * @param userid ������ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * �����������趨
	 * @param username ����������
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
}
/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.parameter;

/**
 * ״̬��������Ϣ
 */
public class StatusParticipant implements StatusParticipantInfo {
	
	/** ��־������Ϣ */
	private WorkFlowLogInfo logInfo;

	/** ���̴����ɫID */
	private Integer roleid;
	
	/** ����״̬���� */
	private String statusname;

	/** ���̴�����ID */
	private String userid;
	
	/** ״̬�� */
	private String statuscode;
	
	/**
	 * ���캯��
	 * 
	 * @param logInfo ��־������Ϣ
	 */
	public StatusParticipant(WorkFlowLogInfo logInfo) {
		this.logInfo = logInfo;
	}

	/**
	 * ��־������Ϣȡ��
	 * 
	 * @return ��־������Ϣ
	 */
	public WorkFlowLogInfo getLogInfo() {
		return logInfo;
	}

	/**
	 * ���̴����ɫIDȡ��
	 * 
	 * @return ���̴����ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ����״̬����ȡ��
	 * 
	 * @return ����״̬����
	 */
	public String getStatusname() {
		return statusname;
	}

	/**
	 * ���̴�����IDȡ��
	 * 
	 * @return ���̴�����ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * ��־������Ϣ�趨
	 * 
	 * @param logInfo ��־������Ϣ
	 */
	public void setLogInfo(WorkFlowLogInfo logInfo) {
		this.logInfo = logInfo;
	}

	/**
	 * ���̴����ɫID�趨
	 * 
	 * @param roleid ���̴����ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * ����״̬�����趨
	 * 
	 * @param statusname ����״̬����
	 */
	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}

	/**
	 * ���̴�����ID�趨
	 * 
	 * @param userid ���̴�����ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}


	/**
	 * ״̬��ȡ��
	 * @return statuscode ״̬��
	 */
	public String getStatuscode() {
		return statuscode;
	}

	/**
	 * ״̬���趨
	 * @param statuscode ״̬��
	 */
	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}
}

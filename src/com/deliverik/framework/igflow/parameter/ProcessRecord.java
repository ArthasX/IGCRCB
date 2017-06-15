/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.parameter;

import java.util.Map;

/**
 * ���̷�����Ϣ
 */
public class ProcessRecord implements ProcessRecordInfo {
	
	/** ���̷�����ID */
	private String crtuserid;

	/** ���̶���ID */
	private String defid;
	
	/** ���̶���״̬��0���ԣ�1������ */
	private String defstatus;
	
	/** �������� */
	private String description;
	
	/** ��ֵ���� */
	private Map<String, String> formvalue;

	/** ��־������Ϣ */
	private WorkFlowLogInfo logInfo;

	/** ���̷����ɫID */
	private Integer roleid;
	
	/** �������� */
	private String title;

	/** ������ʵ��ID */
	public Integer groupID;
	
	/** �����鶨��ID */
	public String groupDefID;

	/**
	 * ���캯��
	 * 
	 * @param logInfo ��־������Ϣ
	 */
	public ProcessRecord(WorkFlowLogInfo logInfo) {
		this.logInfo = logInfo;
	}

	/**
	 * ���̷�����IDȡ��
	 * 
	 * @return ���̷�����ID
	 */
	public String getCrtuserid() {
		return crtuserid;
	}

	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getDefid() {
		return defid;
	}

	/**
	 * ���̶���״̬ȡ��
	 * 
	 * @return ���̶���״̬
	 */
	public String getDefstatus() {
		return defstatus;
	}

	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * ��ֵ����ȡ��
	 * 
	 * @return ��ֵ����
	 */
	public Map<String, String> getFormvalue() {
		return formvalue;
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
	 * ���̷����ɫIDȡ��
	 * 
	 * @return ���̷����ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * ���̷�����ID�趨
	 * 
	 * @param crtuserid ���̷�����ID
	 */
	public void setCrtuserid(String crtuserid) {
		this.crtuserid = crtuserid;
	}

	/**
	 * ���̶���ID�趨
	 * 
	 * @param defid ���̶���ID
	 */
	public void setDefid(String defid) {
		this.defid = defid;
	}
	
	/**
	 * ���̶���״̬�趨
	 * 
	 * @param defstatus ���̶���״̬
	 */
	public void setDefstatus(String defstatus) {
		this.defstatus = defstatus;
	}

	/**
	 * ���������趨
	 * 
	 * @param description ��������
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * ��ֵ����ȡ��
	 * 
	 * @param formvalue
	 */
	public void setFormvalue(Map<String, String> formvalue) {
		this.formvalue = formvalue;
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
	 * ���̷����ɫID�趨
	 * 
	 * @param roleid ���̷����ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * ���������趨
	 * 
	 * @param title ��������
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * ������ʵ��IDȡ��
	 * 
	 * @return ������ʵ��ID
	 */
	public Integer getGroupID() {
		if(groupID != null && groupID == 0) {
			return null;
		}
		return groupID;
	}

	/**
	 * ������ʵ��ID�趨
	 * 
	 * @param groupID ������ʵ��ID
	 */
	public void setGroupID(Integer groupID) {
		this.groupID = groupID;
	}

	/**
	 * �����鶨��IDȡ��
	 * 
	 * @return �����鶨��ID
	 */
	public String getGroupDefID() {
		return groupDefID;
	}

	/**
	 * �����鶨��ID�趨
	 * 
	 * @param groupDefID �����鶨��ID
	 */
	public void setGroupDefID(String groupDefID) {
		this.groupDefID = groupDefID;
	}
	
}

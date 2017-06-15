/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.parameter;

/**
 * ���б���Ϣ
 */
public class PublicProcessInfoValue implements PublicProcessInfoValueInfo{

	/** ������ */
	private String formname;
	
	/** ��ֵ */
	private String formvalue;
	
	/** ��־������Ϣ */
	private WorkFlowLogInfo logInfo;
	
	/**
	 * ���캯��
	 * 
	 * @param logInfo ��־������Ϣ
	 */
	public PublicProcessInfoValue(WorkFlowLogInfo logInfo) {
		this.logInfo = logInfo;
	}

	/**
	 * ������ȡ��
	 * 
	 * @return ������
	 */
	public String getFormname() {
		return formname;
	}

	/**
	 * ��ֵȡ��
	 * 
	 * @return ��ֵ
	 */
	public String getFormvalue() {
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
	 * �������趨
	 * 
	 * @param formname ������
	 */
	public void setFormname(String formname) {
		this.formname = formname;
	}

	/**
	 * ��ֵ�趨
	 * 
	 * @param formvalue ��ֵ
	 */
	public void setFormvalue(String formvalue) {
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
	
}

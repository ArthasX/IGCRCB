/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.resultset;

/**
 * �������־��Ϣ
 */
public class ProcessFormLog implements ProcessFormLogInfo {
	
	/** ������ID */
	private String pidid;

	/** ������ */
	private String name;

	/** ��ֵ */
	private String value;

	/**
	 * ������IDȡ��
	 * @return ������ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ������ID�趨
	 * @param pidid ������ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getName() {
		return name;
	}

	/**
	 * �������趨
	 * @param name ������
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ֵȡ��
	 * @return ��ֵ
	 */
	public String getValue() {
		return value;
	}

	/**
	 * ��ֵ�趨
	 * @param value 
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
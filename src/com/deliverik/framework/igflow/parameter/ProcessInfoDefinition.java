/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.igflow.parameter;

/**
 * ��������Ϣ
 */
public class ProcessInfoDefinition implements ProcessInfoDefinitionInfo{

	/** ���������� */
	protected String pidid;
	
	/** ������ */
	protected String pidname;
	
	/** �������������� */
	protected String ppidid;

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * �����������趨
	 * @param pidid ����������
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * �������趨
	 * @param pidname ������
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * ��������������ȡ��
	 * @return ��������������
	 */
	public String getPpidid() {
		return ppidid;
	}

	/**
	 * ���������������趨
	 * @param ppidid ��������������
	 */
	public void setPpidid(String ppidid) {
		this.ppidid = ppidid;
	}
}

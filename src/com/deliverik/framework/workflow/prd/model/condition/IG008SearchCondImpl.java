/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: ��Ա����ɫ�޶���������ʵ��
  * ��������: ��Ա����ɫ�޶���������ʵ��
  * ������¼: 2013/11/27
  * �޸ļ�¼: 
  */
public class IG008SearchCondImpl implements IG008SearchCond {

	/** ���������� */
	protected String pidid;
	
	/** ���̶������� */
	protected String pdid;

	/**
	 * ����������ȡ��
	 * @return pidid ����������
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
	 * ���̶�������ȡ��
	 * @return pdid ���̶�������
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶��������趨
	 * @param pdid ���̶�������
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
}
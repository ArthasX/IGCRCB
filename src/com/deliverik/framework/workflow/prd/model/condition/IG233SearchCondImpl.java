/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: �Զ������̷��ɶ�����������ʵ��
  * ��������: �Զ������̷��ɶ�����������ʵ��
  * ������¼: 2013/03/12
  * �޸ļ�¼: 
  */
public class IG233SearchCondImpl implements IG233SearchCond {

	/** �����ɽڵ�ID */
	protected String psdid;
	
	/** ���̶������� */
	protected String pdid;

	/**
	 * �����ɽڵ�idȡ��
	 * @return �����ɽڵ�id
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * �����ɽڵ�id�趨
	 * @param psdid �����ɽڵ�id
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ���̶�������ȡ��
	 * @return ���̶�������
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
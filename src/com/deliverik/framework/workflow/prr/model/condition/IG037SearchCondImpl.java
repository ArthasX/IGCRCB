/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * ����: ���̵�����־���������ʵ��
  * ��������: ���̵�����־���������ʵ��
  * ������¼: 2014/11/14
  * �޸ļ�¼: 
  */
public class IG037SearchCondImpl implements
		IG037SearchCond {

	/**	�������� */
	protected Integer prid;

	/**	���̵����û�ID */
	protected String iruserid;
	
	/**	���̵��벿��ID */
	protected String irorgid;
	
	/**	���̵��벿��ID��ƥ�� */
	protected String irorgid_like_l;
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���������趨
	 * @param prid ��������
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ���̵����û�IDȡ��
	 * @return ���̵����û�ID
	 */
	public String getIruserid() {
		return iruserid;
	}

	/**
	 * ���̵����û�ID�趨
	 * @param iruserid ���̵����û�ID
	 */
	public void setIruserid(String iruserid) {
		this.iruserid = iruserid;
	}

	/**
	 * ���̵��벿��IDȡ��
	 * @return ���̵��벿��ID
	 */
	public String getIrorgid() {
		return irorgid;
	}

	/**
	 * ���̵��벿��ID�趨
	 * @param irorgid ���̵��벿��ID
	 */
	public void setIrorgid(String irorgid) {
		this.irorgid = irorgid;
	}

	/**
	 * ���̵��벿��ID��ƥ��ȡ��
	 * @return ���̵��벿��ID��ƥ��
	 */
	public String getIrorgid_like_l() {
		return irorgid_like_l;
	}

	/**
	 * ���̵��벿��ID��ƥ���趨
	 * @param irorgid_like_l ���̵��벿��ID��ƥ��
	 */
	public void setIrorgid_like_l(String irorgid_like_l) {
		this.irorgid_like_l = irorgid_like_l;
	}
	
}
/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

/**
  * ����: ��ƶԱȽ����Ϣ���������ʵ��
  * ��������: ��ƶԱȽ����Ϣ���������ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class AuditResultSearchCondImpl implements
		AuditResultSearchCond {
	
	/** ��Ƹ���ʱ�� */
	protected String autupdtime;
	
	/** ��ƶԱ�ʱ�� */
	protected String autcomptime;
	
	/** ����������� */
	protected Integer autid;
	
	/** �ʲ������ */
	protected String esyscoding;

	/**
	 * �ʲ������ȡ��
	 * @return �ʲ������
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �ʲ�������趨
	 * @param esyscoding �ʲ������
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * ��Ƹ���ʱ��ȡ��
	 * @return ��Ƹ���ʱ��
	 */
	public String getAutupdtime() {
		return autupdtime;
	}

	/**
	 * ��Ƹ���ʱ���趨
	 * @param autupdtime ��Ƹ���ʱ��
	 */
	public void setAutupdtime(String autupdtime) {
		this.autupdtime = autupdtime;
	}

	/**
	 * ��ƶԱ�ʱ��ȡ��
	 * @return ��ƶԱ�ʱ��
	 */
	public String getAutcomptime() {
		return autcomptime;
	}

	/**
	 * ��ƶԱ�ʱ���趨
	 * @param autcomptime ��ƶԱ�ʱ��
	 */
	public void setAutcomptime(String autcomptime) {
		this.autcomptime = autcomptime;
	}

	/**
	 * �������IDȡ��
	 * @return �������ID
	 */
	public Integer getAutid() {
		return autid;
	}

	/**
	 * �������ID�趨
	 * @param autid �������ID
	 */
	public void setAutid(Integer autid) {
		this.autid = autid;
	}
	

}
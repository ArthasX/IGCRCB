/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

/**
  * ����: �ԱȽ����Ϣ���������ʵ��
  * ��������: �ԱȽ����Ϣ���������ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class CIResultSearchCondImpl implements
		CIResultSearchCond {
	
	/** ʱ��� ��ʼ */
	protected String citime_from;
	
	/** ʱ��� ���� */
	protected String citime_to;
	
	/** �������� */
	protected String citdesc;
	
	/** �ʲ������ */
	protected String esyscoding;



	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getCitdesc() {
		return citdesc;
	}

	/**
	 * ���������趨
	 * @param citdesc ��������
	 */
	public void setCitdesc(String citdesc) {
		this.citdesc = citdesc;
	}

	/**
	 * ʱ��� ��ʼȡ��
	 * @return ʱ��� ��ʼ
	 */
	public String getCitime_from() {
		return citime_from;
	}

	/**
	 * ʱ��� ��ʼ�趨
	 * @param citime_from ʱ��� ��ʼ
	 */
	public void setCitime_from(String citime_from) {
		this.citime_from = citime_from;
	}

	/**
	 * ʱ��� ����ȡ��
	 * @return ʱ��� ����
	 */
	public String getCitime_to() {
		return citime_to;
	}

	/**
	 * ʱ��� �����趨
	 * @param citime_to ʱ��� ����
	 */
	public void setCitime_to(String citime_to) {
		this.citime_to = citime_to;
	}

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
	

}
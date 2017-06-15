package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.condition.CIResultSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * CI����ԱȽ����ѯ����FORM
 * 
 */
public class IGASM2202Form extends BaseForm implements CIResultSearchCond{
	
	private static final long serialVersionUID = 1L;

	
	/** CI���ʱ��� ��ʼ */
	protected String citime_from;
	
	/** CI���ʱ��� ���� */
	protected String citime_to;
	
	/** CI����������� */
	protected String citdesc;
	
	/** �ʲ������ */
	protected String esyscoding;
	
	/** �ʲ����� */
	protected String ename;
	
	/** �����ʶ */
	protected Integer[] checkbox;
	
	/** CI���ID */
	protected Integer[] cirids;
	
	/** CI������˵�� */
	protected String[] ciresultdesces;



	/**
	 * CI�����������ȡ��
	 * @return CI�����������
	 */
	public String getCitdesc() {
		return citdesc;
	}

	/**
	 * CI������������趨
	 * @param citdesc CI�����������
	 */
	public void setCitdesc(String citdesc) {
		this.citdesc = citdesc;
	}

	/**
	 * CI���ʱ��� ��ʼȡ��
	 * @return CI���ʱ��� ��ʼ
	 */
	public String getCitime_from() {
		return citime_from;
	}

	/**
	 * CI���ʱ��� ��ʼ�趨
	 * @param citime_from CI���ʱ��� ��ʼ
	 */
	public void setCitime_from(String citime_from) {
		this.citime_from = citime_from;
	}

	/**
	 * CI���ʱ��� ����ȡ��
	 * @return CI���ʱ��� ����
	 */
	public String getCitime_to() {
		return citime_to;
	}

	/**
	 * CI���ʱ��� �����趨
	 * @param citime_to CI���ʱ��� ����
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

	/**
	 * �ʲ�����ȡ��
	 * @return �ʲ�����
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * �ʲ������趨
	 * @param einame �ʲ�����
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * �����ʶȡ��
	 * @return �����ʶ
	 */
	public Integer[] getCheckbox() {
		return checkbox;
	}

	/**
	 * �����ʶ�趨
	 * @param checkbox �����ʶ
	 */
	public void setCheckbox(Integer[] checkbox) {
		this.checkbox = checkbox;
	}

	/**
	 * CI������˵��ȡ��
	 * @return CI������˵��
	 */
	public String[] getCiresultdesces() {
		return ciresultdesces;
	}

	/**
	 * CI������˵���趨 
	 * @param ciresultdesces CI������˵��
	 */
	public void setCiresultdesces(String[] ciresultdesces) {
		this.ciresultdesces = ciresultdesces;
	}

	/**
	 * CI���IDȡ��
	 * @return CI���ID
	 */
	public Integer[] getCirids() {
		return cirids;
	}

	/**
	 * CI���ID�趨
	 * @param cirids CI���ID
	 */
	public void setCirids(Integer[] cirids) {
		this.cirids = cirids;
	}
	

}

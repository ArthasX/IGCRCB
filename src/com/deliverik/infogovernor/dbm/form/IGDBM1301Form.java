/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.dbm.form;
import com.deliverik.framework.base.BaseForm;


/**
 * ��������-����Form
 *
 */
@SuppressWarnings("serial")
public class IGDBM1301Form extends BaseForm {

	protected Integer wmid;

	/** �������� */
	protected String wmname;

	/** ���� */
	protected String wmdesc;

	/** ���״̬(0-δ���1-�����) */
	protected String wmstatus;

	/** �������� */
	protected String wmstartdate_from;
	
	protected String wmstartdate_to;

	/** Ƶ�� */
	protected String wmfrequency;
	
	//������
	protected String wmusername;
	
	/**
	 * @return the Ƶ��
	 */
	public String getWmfrequency() {
		return wmfrequency;
	}

	/**
	 * @param Ƶ�� the wmfrequency to set
	 */
	public void setWmfrequency(String wmfrequency) {
		this.wmfrequency = wmfrequency;
	}

	/**
	 * @return the wmusername
	 */
	public String getWmusername() {
		return wmusername;
	}

	/**
	 * @param wmusername the wmusername to set
	 */
	public void setWmusername(String wmusername) {
		this.wmusername = wmusername;
	}

	/**
	 * @return the wmid
	 */
	public Integer getWmid() {
		return wmid;
	}

	/**
	 * @param wmid the wmid to set
	 */
	public void setWmid(Integer wmid) {
		this.wmid = wmid;
	}

	/**
	 * @return the ��������
	 */
	public String getWmname() {
		return wmname;
	}

	/**
	 * @param �������� the wmname to set
	 */
	public void setWmname(String wmname) {
		this.wmname = wmname;
	}

	/**
	 * @return the ����
	 */
	public String getWmdesc() {
		return wmdesc;
	}

	/**
	 * @param ���� the wmdesc to set
	 */
	public void setWmdesc(String wmdesc) {
		this.wmdesc = wmdesc;
	}

	/**
	 * @return the ���״̬(0-δ���1-�����)
	 */
	public String getWmstatus() {
		return wmstatus;
	}

	/**
	 * @param ���״̬(0-δ���1-�����) the wmstatus to set
	 */
	public void setWmstatus(String wmstatus) {
		this.wmstatus = wmstatus;
	}

	/**
	 * @return the ��������
	 */
	public String getWmstartdate_from() {
		return wmstartdate_from;
	}

	/**
	 * @param �������� the wmstartdate_from to set
	 */
	public void setWmstartdate_from(String wmstartdate_from) {
		this.wmstartdate_from = wmstartdate_from;
	}

	/**
	 * @return the wmstartdate_to
	 */
	public String getWmstartdate_to() {
		return wmstartdate_to;
	}

	/**
	 * @param wmstartdate_to the wmstartdate_to to set
	 */
	public void setWmstartdate_to(String wmstartdate_to) {
		this.wmstartdate_to = wmstartdate_to;
	}
	
}

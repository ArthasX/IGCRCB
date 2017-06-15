/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.model.condition;


/**
  * ����: ���ռ����������ʵ��
  * ��������: ���ռ����������ʵ��
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public class RiskMonitoringSearchCondImpl implements
		RiskMonitoringSearchCond {
	
	protected Integer rmid;

	protected Integer[] rmid_in;
	
	/** ���ղ�������id */
	protected Integer rsid;

	/** ����������� */
	protected String rmname;

	/** �ƻ���ʼʱ�� */
	protected String rmstartdate;
	
	/** ��ѯ���� �ƻ���ʼʱ��*/
	protected String rmstartdate_from;
	
	/** ��ѯ���� �ƻ���ʼʱ��*/
	protected String rmstartdate_to;

	/** ʵ�����ʱ�� */
	protected String rmenddate;
	
	/** ��ѯ���� ʵ�����ʱ��*/
	protected String rmenddate_from;
	
	/** ��ѯ���� ʵ�����ʱ��*/
	protected String rmenddate_to;

	/**
	 * rmidȡ��
	 * @return rmid  rmid
	 */
	public Integer getRmid() {
		return rmid;
	}

	/**
	 * rmid�趨
	 * @param rmid  rmid
	 */
	public void setRmid(Integer rmid) {
		this.rmid = rmid;
	}

	/**
	 * ���ղ�������idȡ��
	 * @return rsid  ���ղ�������id
	 */
	public Integer getRsid() {
		return rsid;
	}

	/**
	 * ���ղ�������id�趨
	 * @param rsid  ���ղ�������id
	 */
	public void setRsid(Integer rsid) {
		this.rsid = rsid;
	}

	/**
	 * �����������ȡ��
	 * @return rmname  �����������
	 */
	public String getRmname() {
		return rmname;
	}

	/**
	 * ������������趨
	 * @param rmname  �����������
	 */
	public void setRmname(String rmname) {
		this.rmname = rmname;
	}

	/**
	 * �ƻ���ʼʱ��ȡ��
	 * @return rmstartdate  �ƻ���ʼʱ��
	 */
	public String getRmstartdate() {
		return rmstartdate;
	}

	/**
	 * �ƻ���ʼʱ���趨
	 * @param rmstartdate  �ƻ���ʼʱ��
	 */
	public void setRmstartdate(String rmstartdate) {
		this.rmstartdate = rmstartdate;
	}

	/**
	 * ��ѯ�����ƻ���ʼʱ��ȡ��
	 * @return rmstartdate_from  ��ѯ�����ƻ���ʼʱ��
	 */
	public String getRmstartdate_from() {
		return rmstartdate_from;
	}

	/**
	 * ��ѯ�����ƻ���ʼʱ���趨
	 * @param rmstartdate_from  ��ѯ�����ƻ���ʼʱ��
	 */
	public void setRmstartdate_from(String rmstartdate_from) {
		this.rmstartdate_from = rmstartdate_from;
	}

	/**
	 * ��ѯ�����ƻ���ʼʱ��ȡ��
	 * @return rmstartdate_to  ��ѯ�����ƻ���ʼʱ��
	 */
	public String getRmstartdate_to() {
		return rmstartdate_to;
	}

	/**
	 * ��ѯ�����ƻ���ʼʱ���趨
	 * @param rmstartdate_to  ��ѯ�����ƻ���ʼʱ��
	 */
	public void setRmstartdate_to(String rmstartdate_to) {
		this.rmstartdate_to = rmstartdate_to;
	}

	/**
	 * ʵ�����ʱ��ȡ��
	 * @return rmenddate  ʵ�����ʱ��
	 */
	public String getRmenddate() {
		return rmenddate;
	}

	/**
	 * ʵ�����ʱ���趨
	 * @param rmenddate  ʵ�����ʱ��
	 */
	public void setRmenddate(String rmenddate) {
		this.rmenddate = rmenddate;
	}

	/**
	 * ��ѯ����ʵ�����ʱ��ȡ��
	 * @return rmenddate_from  ��ѯ����ʵ�����ʱ��
	 */
	public String getRmenddate_from() {
		return rmenddate_from;
	}

	/**
	 * ��ѯ����ʵ�����ʱ���趨
	 * @param rmenddate_from  ��ѯ����ʵ�����ʱ��
	 */
	public void setRmenddate_from(String rmenddate_from) {
		this.rmenddate_from = rmenddate_from;
	}

	/**
	 * ��ѯ����ʵ�����ʱ��ȡ��
	 * @return rmenddate_to  ��ѯ����ʵ�����ʱ��
	 */
	public String getRmenddate_to() {
		return rmenddate_to;
	}

	/**
	 * ��ѯ����ʵ�����ʱ���趨
	 * @param rmenddate_to  ��ѯ����ʵ�����ʱ��
	 */
	public void setRmenddate_to(String rmenddate_to) {
		this.rmenddate_to = rmenddate_to;
	}

	/**
	 * rmid_inȡ��
	 * @return rmid_in  rmid_in
	 */
	public Integer[] getRmid_in() {
		return rmid_in;
	}

	/**
	 * rmid_in�趨
	 * @param rmid_in  rmid_in
	 */
	public void setRmid_in(Integer[] rmid_in) {
		this.rmid_in = rmid_in;
	}


}
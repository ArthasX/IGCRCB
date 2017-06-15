/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model.condition;


/**
  * ����: �����ʵ�����������ʵ��
  * ��������: �����ʵ�����������ʵ��
  * ������¼: 2013/07/18
  * �޸ļ�¼: 
  */
public class RegulatoryReportInstanceSearchCondImpl implements
		RegulatoryReportInstanceSearchCond {

	/** ���ʶ */
	protected String key_eq;

	/** ״̬��0������1�رգ�2��ֹ */
	protected String status_eq = "0";
	
	/** ��ǰ��¼��userid*/
	protected String userid;
	
	/** ����״̬��*/
	protected String psdname;
	
	/** ��������*/
	protected String prtype;
	
	/** ʵ��id*/
	protected Integer instanceid ;
	
	/** ������*/
	protected String inituser ;
	
	/** ����ʼʱ�� */
	protected String propentime;
	
	/** �������ʱ�� */
	protected String proclosetime;
	
	/** �����ʶ*/
	protected String orderby;
	
	/** ��������*/
	protected String prtitle;
	
	/** ��������ID��ƥ�� */
	protected String prpdid_like;	

	/** ���Ƚ��������ʶ*/
	protected String orderby_quarter;
	
	/** ���ȱ���״̬*/
	protected String prstatus;

	/** ���ȱ�ʶ */
	private String quarter;
	

	/** ���Ȳ�ѯ�� */
	private String year;

	/** �������ѯ���ڵ��� */
	private String year_GtEq;
	/** �·ݱ�־ */
	private String month;
	
	/**���*/
	private String reportman;
	
	/**�����*/
	private String reportdepartment;
	
	
	
	/**  
	 * ��ȡreportman  
	 * @return reportman 
	 */
	public String getReportman() {
		return reportman;
	}

	/**  
	 * ����reportman  
	 * @param reportman
	 */
	
	public void setReportman(String reportman) {
		this.reportman = reportman;
	}

	/**  
	 * ��ȡreportdepartment  
	 * @return reportdepartment 
	 */
	public String getReportdepartment() {
		return reportdepartment;
	}

	/**  
	 * ����reportdepartment  
	 * @param reportdepartment
	 */
	
	public void setReportdepartment(String reportdepartment) {
		this.reportdepartment = reportdepartment;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * ���ȱ���״̬ȡ��
	 *
	 * @return prstatus ���ȱ���״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ���ȱ���״̬�趨
	 *
	 * @param prstatus ���ȱ���״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * ���ʶȡ��
	 *
	 * @return ���ʶ
	 */
	public String getKey_eq() {
		return key_eq;
	}

	/**
	 * ���ʶ�趨
	 *
	 * @param key_eq ���ʶ
	 */
	public void setKey_eq(String key_eq) {
		this.key_eq = key_eq;
	}

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getStatus_eq() {
		return status_eq;
	}

	/**
	 * ״̬�趨
	 *
	 * @param status_eq ״̬
	 */
	public void setStatus_eq(String status_eq) {
		this.status_eq = status_eq;
	}

	/**
	 * ��ǰ��¼��useridȡ��
	 *
	 * @return ��ǰ��¼��userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * ��ǰ��¼��userid �趨
	 *
	 * @param userid ��ǰ��¼��userid 
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * ����״̬��ȡ��
	 *
	 * @return ����״̬��
	 */
	public String getPsdname() {
		return psdname;
	}
	/**
	 * ����״̬�� �趨
	 *
	 * @param psdname ����״̬��
	 */
	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}
	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPrtype() {
		return prtype;
	}
	/**
	 * �������� �趨
	 *
	 * @param prtype ��������
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}
	/**
	 * ʵ��idȡ��
	 *
	 * @return ʵ��id
	 */
	public Integer getInstanceid() {
		return instanceid;
	}
	/**
	 * ʵ��id�趨
	 *
	 * @param instanceid ʵ��id
	 */
	public void setInstanceid(Integer instanceid) {
		this.instanceid = instanceid;
	}

	public String getInituser() {
		return inituser;
	}

	public void setInituser(String inituser) {
		this.inituser = inituser;
	}

	/**
	 *����ʼʱ��ȡ��
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 *����ʼʱ���趨
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 *�������ʱ��ȡ��
	 */
	public String getProclosetime() {
		return proclosetime;
	}

	/**
	 *�������ʱ���趨
	 */
	public void setProclosetime(String proclosetime) {
		this.proclosetime = proclosetime;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	public String getPrtitle() {
		return prtitle;
	}

	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * ��������ID��ƥ��ȡ��
	 *
	 * @return prpdid_like ��������ID��ƥ��
	 */
	public String getPrpdid_like() {
		return prpdid_like;
	}

	/**
	 * ��������ID��ƥ���趨
	 *
	 * @param prpdid_like ��������ID��ƥ��
	 */
	public void setPrpdid_like(String prpdid_like) {
		this.prpdid_like = prpdid_like;
	}

	/**
	 * ���Ƚ��������ʶȡ��
	 *
	 * @return orderby_quarter ���Ƚ��������ʶ
	 */
	public String getOrderby_quarter() {
		return orderby_quarter;
	}

	/**
	 * ���Ƚ��������ʶ�趨
	 *
	 * @param orderby_quarter ���Ƚ��������ʶ
	 */
	public void setOrderby_quarter(String orderby_quarter) {
		this.orderby_quarter = orderby_quarter;
	}

	/**
	 * ���ȱ�ʶȡ��
	 * @return quarter ���ȱ�ʶ
	 */
	public String getQuarter() {
		return quarter;
	}

	/**
	 * ���ȱ�ʶ�趨
	 * @param quarter ���ȱ�ʶ
	 */
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	/**
	 * ���Ȳ�ѯ��ȡ��
	 * @return year ���Ȳ�ѯ��
	 */
	public String getYear() {
		return year;
	}

	/**
	 * ���Ȳ�ѯ���趨
	 * @param year ���Ȳ�ѯ��
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * �������ѯ���ڵ���ȡ��
	 * @return year_GtEq �������ѯ���ڵ���
	 */
	public String getYear_GtEq() {
		return year_GtEq;
	}

	/**
	 * �������ѯ���ڵ����趨
	 * @param year_GtEq �������ѯ���ڵ���
	 */
	public void setYear_GtEq(String year_GtEq) {
		this.year_GtEq = year_GtEq;
	}

	public String getMonth() {
		// TODO Auto-generated method stub
		return month;
	}


	
}
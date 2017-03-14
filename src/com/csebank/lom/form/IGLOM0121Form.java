/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.DealSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * �Ӵ�����ͳ����ϸ����Form
 *
 */
public class IGLOM0121Form extends BaseForm implements DealSearchCond {
	
	
	private static final long serialVersionUID = 1L;

	protected String rid;
	protected String deptName;
	protected String rstatus;
	protected String dealTime;
	protected String rapporgid;
	protected String year;
	protected String month;
	
	/** ��Ҫ���벿�� */
	protected String rapporgid_org;
	
	/** ��ʼ�·� */
	protected String month_from_org;
	
	/** �����·� */
	protected String month_to_org;
	
	/** ��� */
	protected String year_org;
	


	/**
	 * ���ŽӴ�ͳ�����벿�Ų����ȡ��
	 * @return ���ŽӴ�ͳ�����벿�Ų����
	 */
	public String getRapporgid_org() {
		return rapporgid_org;
	}

	/**
	 * ���ŽӴ�ͳ�����벿�Ų�����趨
	 * @param rapporgid_org ���ŽӴ�ͳ�����벿�Ų����
	 */
	public void setRapporgid_org(String rapporgid_org) {
		this.rapporgid_org = rapporgid_org;
	}

	/**
	 * ���ŽӴ�ͳ�����ȡ��
	 * @return ���ŽӴ�ͳ�����
	 */
	public String getYear_org() {
		return year_org;
	}

	/**
	 * ���ŽӴ�ͳ������趨
	 * @param year_org ���ŽӴ�ͳ�����
	 */
	public void setYear_org(String year_org) {
		this.year_org = year_org;
	}

	/**
	 * ���ŽӴ�ͳ�ƿ�ʼ�·�ȡ��
	 * @return ���ŽӴ�ͳ�ƿ�ʼ�·�
	 */
	public String getMonth_from_org() {
		return month_from_org;
	}

	/**
	 * ���ŽӴ�ͳ�ƿ�ʼ�·��趨
	 * @param month_from_org ���ŽӴ�ͳ�ƿ�ʼ�·�
	 */
	public void setMonth_from_org(String month_from_org) {
		this.month_from_org = month_from_org;
	}

	/**
	 * ���ŽӴ�ͳ�ƽ����·�ȡ��
	 * @return ���ŽӴ�ͳ�ƽ����·�
	 */
	public String getMonth_to_org() {
		return month_to_org;
	}

	/**
	 * ���ŽӴ�ͳ�ƽ����·��趨
	 * @param month_to_org ���ŽӴ�ͳ�ƽ����·�
	 */
	public void setMonth_to_org(String month_to_org) {
		this.month_to_org = month_to_org;
	}

	public String getMonth() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRapporgid_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getRid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRstatus_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRtime_from() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRtime_to() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getYear() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getRstatus() {
		return rstatus;
	}

	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}

	public String getDealTime() {
		return dealTime;
	}

	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}

	public String getRapporgid() {
		return rapporgid;
	}

	public void setRapporgid(String rapporgid) {
		this.rapporgid = rapporgid;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}

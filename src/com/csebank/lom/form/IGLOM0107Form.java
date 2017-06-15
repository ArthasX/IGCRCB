/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.DealSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * �Ӵ���������Form
 *
 */
public class IGLOM0107Form extends BaseForm implements DealSearchCond {
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * �Ӵ�����ID
	 */
	protected Integer rid;
	
	/** ɾ���Ӵ��������� */
	protected String[] deleteRid;
	
	/** ��Ҫ���벿�Ų���� */
	protected String rapporgid;
	
	/** ��Ҫ���벿������ */
	protected String deptName;
	protected String rtime_from;
	protected String rtime_to;
	
	/** ״̬��1�����У�2������ */
	protected String rstatus;
	

	
	/** �������� */
	protected String dealTime;
	
	/** �·� */
	protected String month;
	
	/** ��� */
	protected String year;
	

	/**
	 * �Ӵ�����ID
	 * @return �Ӵ�����ID
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * �Ӵ�����ID
	 * @param rid �Ӵ�����ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	/**
	 * ɾ���Ӵ���������
	 * @return ɾ���Ӵ���������
	 */
	public String[] getDeleteRid() {
		return deleteRid;
	}

	/**
	 * ɾ���Ӵ���������
	 * @param deleteRid ɾ���Ӵ���������
	 */
	public void setDeleteRid(String[] deleteRid) {
		this.deleteRid = deleteRid;
	}

	

	

	


	/**
	 * ״̬ȡ��
	 * @return ״̬
	 */
	public String getRstatus() {
		return rstatus;
	}

	/**
	 * ״̬�趨
	 * @param rstatus ״̬
	 */
	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}

	/**
	 * �·�ȡ��
	 * @return �·�
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * �·��趨
	 * @param month �·�
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * ���ȡ��
	 * @return ���
	 */
	public String getYear() {
		return year;
	}

	/**
	 * ����趨
	 * @param year ���
	 */
	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth_from_org() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMonth_to_org() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRapporgid_org() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getYear_org() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
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

	public String getRtime_from() {
		return rtime_from;
	}

	public void setRtime_from(String rtime_from) {
		this.rtime_from = rtime_from;
	}

	public String getRtime_to() {
		return rtime_to;
	}

	public void setRtime_to(String rtime_to) {
		this.rtime_to = rtime_to;
	}

}

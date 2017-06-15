/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.DealSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * ģ�飺���ڹ���-�Ӵ�����
 * ����Ͳ͹���ͳ����ϸ����Form
 * ���ߣ�������
 *
 */
public class IGLOM0118Form extends BaseForm implements DealSearchCond {
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * �Ӵ�����ID
	 */
	protected Integer rid;
	protected String dealTime;
	
	/** ɾ���Ӵ��������� */
	protected String[] deleteRid;
	
	/** ��Ҫ���벿�Ų���� */
	protected String rapporgid;
	
	/** ��Ҫ���벿������ */
	protected String deptName;
	
	/** ״̬��1�����У�2������ */
	protected String rstatus;
	
	
	
	/** ��ѯ���ڶο�ʼ */
	protected String rtime_from;
	
	/** ��ѯ���ڶν��� */
	protected String rtime_to;
	
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
	 * ��ѯ���ڶο�ʼȡ��
	 * @return ��ѯ���ڶο�ʼ
	 */
	public String getRtime_from() {
		return rtime_from;
	}

	/**
	 * ��ѯ���ڶο�ʼ�趨
	 * @param rtime_from ��ѯ���ڶο�ʼ
	 */
	public void setRtime_from(String rtime_from) {
		this.rtime_from = rtime_from;
	}

	/**
	 * ��ѯ���ڶν���ȡ��
	 * @return ��ѯ���ڽ���
	 */
	public String getRtime_to() {
		return rtime_to;
	}

	/**
	 * ��ѯ���ڶν����趨
	 * @param rtime_to ��ѯ���ڶο�ʼ
	 */
	public void setRtime_to(String rtime_to) {
		this.rtime_to = rtime_to;
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

	public String getRapporgid() {
		return rapporgid;
	}

	public void setRapporgid(String rapporgid) {
		this.rapporgid = rapporgid;
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

}

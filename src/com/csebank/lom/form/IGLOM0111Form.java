/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.RecptionSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * �Ӵ�����ͳ����ϸ����Form
 *
 */
public class IGLOM0111Form extends BaseForm implements RecptionSearchCond {
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * �Ӵ�����ID
	 */
	protected Integer rid;
	
	/** ɾ���Ӵ��������� */
	protected String[] deleteRid;
	
	/** ��Ҫ���벿�Ų���� */
	protected String rapporgid_q;
	
	/** ��Ҫ���벿������ */
	protected String rapporgname;
	
	/** ״̬��1�����У�2������ */
	protected String rstatus_q;
	
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
	 * ��Ҫ���벿������ȡ��
	 * @return ��Ҫ���벿������
	 */
	public String getRapporgname() {
		return rapporgname;
	}

	/**
	 * ��Ҫ���벿�������趨
	 * @param rapporgname ��Ҫ���벿������
	 */
	public void setRapporgname(String rapporgname) {
		this.rapporgname = rapporgname;
	}

	/**
	 * ��Ҫ���벿�Ų����
	 * @return ��Ҫ���벿�Ų����
	 */
	public String getRapporgid_q() {
		return rapporgid_q;
	}

	/**
	 * ��Ҫ���벿�Ų����
	 * @param rapporgid ��Ҫ���벿�Ų����
	 */
	public void setRapporgid_q(String rapporgid_q) {
		this.rapporgid_q = rapporgid_q;
	}

	/**
	 * ״̬
	 * @return ״̬
	 */
	public String getRstatus_q() {
		return rstatus_q;
	}

	/**
	 * ״̬
	 * @param rstatus ״̬
	 */
	public void setRstatus_q(String rstatus_q) {
		this.rstatus_q = rstatus_q;
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

	public String getRetime_from() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRetime_to() {
		// TODO Auto-generated method stub
		return null;
	}

}

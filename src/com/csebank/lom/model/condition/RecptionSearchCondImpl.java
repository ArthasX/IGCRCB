/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * �Ӵ���ѯ�ӿ�ʵ��
 *
 */
public class RecptionSearchCondImpl implements RecptionSearchCond {
	
	/**
	 * �Ӵ�ID
	 */
	protected Integer rid;
	
	/**
	 * �Ӵ�״̬
	 */
	protected String rstatus_q;
	
	/**
	 * �Ӵ���ʼʱ���ѯ��ʼ
	 */
	protected String rtime_from;
	
	/**
	 * �Ӵ���ʼʱ���ѯ����
	 */
	protected String rtime_to;
	
	/**
	 * �Ӵ�����ʱ���ѯ��ʼ
	 */
	protected String retime_from;
	
	/**
	 * �Ӵ�����ʱ���ѯ����
	 */
	protected String retime_to;
	
	/**
	 * ���벿�Ų����
	 */
	protected String rapporgid_q;
	
	/**
	 * ͳ�����
	 */
	protected String year;
	
	/**
	 * ͳ���·�
	 */
	protected String month;
	
	/**
	 * ���ŽӴ�ͳ�����벿�Ų����
	 */
	protected String rapporgid_org;
	
	/**
	 * ���ŽӴ�ͳ�����
	 */
	protected String year_org;
	
	/**
	 * ���ŽӴ�ͳ�ƿ�ʼ�·�
	 */
	protected String month_from_org;
	
	/**
	 * ���ŽӴ�ͳ�ƽ����·�
	 */
	protected String month_to_org;

	/**
	 * �Ӵ�IDȡ��
	 * @return �Ӵ�ID
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * �Ӵ�ID�趨
	 * @param rid �Ӵ�ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	
	
	/**
	 * �Ӵ�״̬ȡ��
	 * @return �Ӵ�״̬
	 */
	public String getRstatus_q() {
		return rstatus_q;
	}

	/**
	 * �Ӵ�״̬�趨
	 * @param rstatus �Ӵ�״̬
	 */
	public void setRstatus_q(String rstatus_q) {
		this.rstatus_q = rstatus_q;
	}

	/**
	 * �Ӵ���ʼʱ���ѯȡ��
	 * @return �Ӵ���ʼʱ���ѯ
	 */
	public String getRtime_from() {
		return rtime_from;
	}

	/**
	 * �Ӵ���ʼʱ���ѯ�趨
	 * @param rtime_from �Ӵ���ʼʱ���ѯ
	 */
	public void setRtime_from(String rtime_from) {
		this.rtime_from = rtime_from;
	}

	/**
	 * �Ӵ�����ʱ���ѯȡ��
	 * @return �Ӵ�����ʱ���ѯ
	 */
	public String getRtime_to() {
		return rtime_to;
	}

	/**
	 * �Ӵ�����ʱ���ѯ�趨
	 * @param rtime_to �Ӵ�����ʱ���ѯ
	 */
	public void setRtime_to(String rtime_to) {
		this.rtime_to = rtime_to;
	}

	/**
	 * ���벿�Ų����ȡ��
	 * @return ���벿�Ų����
	 */
	public String getRapporgid_q() {
		return rapporgid_q;
	}

	/**
	 * ���벿�Ų�����趨
	 * @param rapporgid ���벿�Ų����
	 */
	public void setRapporgid_q(String rapporgid_q) {
		this.rapporgid_q = rapporgid_q;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

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

	/**
	 * �Ӵ�����ʱ���ѯ��ʼȡ��
	 * @return �Ӵ�����ʱ���ѯ��ʼ
	 */
	public String getRetime_from() {
		return retime_from;
	}

	/**
	 * �Ӵ�����ʱ���ѯ��ʼ�趨
	 * @param retime_from �Ӵ�����ʱ���ѯ��ʼ
	 */
	public void setRetime_from(String retime_from) {
		this.retime_from = retime_from;
	}

	/**
	 * �Ӵ�����ʱ���ѯ����ȡ��
	 * @return �Ӵ�����ʱ���ѯ����
	 */
	public String getRetime_to() {
		return retime_to;
	}

	/**
	 * �Ӵ�����ʱ���ѯ�����趨
	 * @param retime_to �Ӵ�����ʱ���ѯ����
	 */
	public void setRetime_to(String retime_to) {
		this.retime_to = retime_to;
	}

}

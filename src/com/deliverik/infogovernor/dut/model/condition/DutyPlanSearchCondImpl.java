/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */
package com.deliverik.infogovernor.dut.model.condition;
/**
 * 
 * ֵ��ƻ���ѯʵ����
 *
 */
public class DutyPlanSearchCondImpl  implements DutyPlanSearchCond{
	
	/** ֵ��ƻ�״̬ */
	protected String dpstatus;
	
	/** ֵ������ */
	protected String dadcategory;
	
	/** ֵ������ */
	protected String dptime;
	
	/** ֵ�����ڣ����ڵ���ƥ�䣩 */
	protected String dptime_ge;

	/** ֵ�����ڣ�С�ڵ���ƥ�䣩 */
	protected String dptime_le;
	protected String dptype;
	
	/** ֵ��ƻ������� */
	protected Integer dpid;
	
	/**
	 * ֵ��ƻ�״̬ȡ��
	 * @return ֵ��ƻ�״̬
	 */
	public String getDpstatus() {
		return dpstatus;
	}

	/**
	 * ֵ��ƻ�״̬�趨
	 *
	 * @param dpstatus ֵ��ƻ�״̬
	 */
	public void setDpstatus(String dpstatus) {
		this.dpstatus = dpstatus;
	}

	/**
	 * ֵ������ȡ��
	 * @return ֵ������
	 */
	public String getDadcategory() {
		return dadcategory;
	}

	/**
	 * ֵ�������趨
	 *
	 * @param dadcategory ֵ������
	 */
	public void setDadcategory(String dadcategory) {
		this.dadcategory = dadcategory;
	}

	/**
	 * ֵ������ȡ��
	 * @return ֵ������
	 */
	public String getDptime() {
		return dptime;
	}

	/**
	 * ֵ�������趨
	 *
	 * @param dptime ֵ������
	 */
	public void setDptime(String dptime) {
		this.dptime = dptime;
	}

	public String getDptype() {
		return dptype;
	}

	public void setDptype(String dptype) {
		this.dptype = dptype;
	}
	
	/**
	 * ֵ�����ڣ����ڵ���ƥ�䣩ȡ��
	 * @return ֵ�����ڣ����ڵ���ƥ�䣩
	 */
	public String getDptime_ge() {
		return dptime_ge;
	}

	/**
	 * ֵ�����ڣ����ڵ���ƥ�䣩�趨
	 *
	 * @param dptime_ge ֵ�����ڣ����ڵ���ƥ�䣩
	 */
	public void setDptime_ge(String dptime_ge) {
		this.dptime_ge = dptime_ge;
	}

	public String getDptime_le() {
		return dptime_le;
	}

	public void setDptime_le(String dptime_le) {
		this.dptime_le = dptime_le;
	}

	/**
	 * ֵ��ƻ�������ȡ��
	 *
	 * @return dpid ֵ��ƻ�������
	 */
	public Integer getDpid() {
		return dpid;
	}

	/**
	 * ֵ��ƻ��������趨
	 *
	 * @param dpid ֵ��ƻ�������
	 */
	public void setDpid(Integer dpid) {
		this.dpid = dpid;
	}
	
}

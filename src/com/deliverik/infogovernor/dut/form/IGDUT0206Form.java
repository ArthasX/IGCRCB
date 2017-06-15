/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */
package com.deliverik.infogovernor.dut.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * ֵ��������ѯForm
 */
public class IGDUT0206Form extends BaseForm {


	private static final long serialVersionUID = 1L;
	
	/** ֵ��ƻ�״̬ ִ����*/
	protected String dpstatus;
	
	/** ֵ������ */
	protected String dadcategory;
	
	/** ֵ������ ��ǰ����*/
	protected String dptime;
	
	/** �������� */
	protected String dpquestion;
	
	/** �ܽ� */
	protected String dpinfo;
	
	/**
	 * ֵ��ƻ�ID
	 */
	protected Integer dpid;
	
	/**
	 * �װ�/ҹ��
	 */
	protected String dptype;
	
	/**
	 * ������ID
	 */
	protected String dperuserid;
	
	/**
	 * ����������
	 */
	protected String dperusername;
	
	protected String currentdate = IGStringUtils.getCurrentDate();
	
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

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getDpquestion() {
		return dpquestion;
	}

	/**
	 * ���������趨
	 *
	 * @param dpquestion ��������
	 */
	public void setDpquestion(String dpquestion) {
		this.dpquestion = dpquestion;
	}

	/**
	 * �ܽ�ȡ��
	 * @return �ܽ�
	 */
	public String getDpinfo() {
		return dpinfo;
	}

	/**
	 * �ܽ��趨
	 *
	 * @param dpinfo �ܽ�
	 */
	public void setDpinfo(String dpinfo) {
		this.dpinfo = dpinfo;
	}

	/**
	 * ֵ��ƻ�IDȡ��
	 * @return ֵ��ƻ�
	 */
	public Integer getDpid() {
		return dpid;
	}

	/**
	 * ֵ��ƻ�ID�趨
	 * @param dpid ֵ��ƻ�ID
	 */
	public void setDpid(Integer dpid) {
		this.dpid = dpid;
	}

	/**
	 * �װ�/ҹ��ȡ��
	 * @return �װ�/ҹ��
	 */
	public String getDptype() {
		return dptype;
	}

	/**
	 * �װ�/ҹ���趨
	 * @param dptype �װ�/ҹ��
	 */
	public void setDptype(String dptype) {
		this.dptype = dptype;
	}

	/**
	 * ������IDȡ��
	 * @return ������
	 */
	public String getDperuserid() {
		return dperuserid;
	}

	/**
	 * ������ID�趨
	 * @param dperuserid ������
	 */
	public void setDperuserid(String dperuserid) {
		this.dperuserid = dperuserid;
	}

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getDperusername() {
		return dperusername;
	}

	/**
	 * �����������趨
	 * @param dperusername ����������
	 */
	public void setDperusername(String dperusername) {
		this.dperusername = dperusername;
	}

	public String getCurrentdate() {
		return currentdate;
	}

	public void setCurrentdate(String currentdate) {
		this.currentdate = currentdate;
	}

	
}

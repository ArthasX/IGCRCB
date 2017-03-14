/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: 
 * @Author       zhangqiang
 * @History      @2014-7-9�½� 
 * 			
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGRIS0501Form extends BaseForm {

	protected Integer rcid;

	/** ��������� */
	protected String rcname;

	/** ���Ƶ�� */
	protected String rcfrequency;

	/** ������ */
	protected String rcusername;

	/** �������� */
	protected String rccategoryname;

	/** �������� */
	protected String prtitle;

	/** ��鷽ʽ */
	protected String rcrtestmode;

	/** ����� */
	protected String rcstatus;

	/** ʵ�ʼ��ʱ�� */
	protected String rccreatetime;
	
	/** ���˵�� */
	protected String rcrcomment;

	/** ���̶� */
	protected String rcrresult;

	/** ���� */
	protected String rcrattch;

	/** ���ƻ�ʱ�� */
	protected String rcrplandate;
	
	/**��*/
	protected String year;
	/**��*/
	protected String month;

	/**
	 * rcidȡ��
	 * @return rcid rcid
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * rcid�趨
	 * @param rcid rcid
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * ���������ȡ��
	 * @return rcname ���������
	 */
	public String getRcname() {
		return rcname;
	}

	/**
	 * ����������趨
	 * @param rcname ���������
	 */
	public void setRcname(String rcname) {
		this.rcname = rcname;
	}

	/**
	 * ���Ƶ��ȡ��
	 * @return rcfrequency ���Ƶ��
	 */
	public String getRcfrequency() {
		return rcfrequency;
	}

	/**
	 * ���Ƶ���趨
	 * @param rcfrequency ���Ƶ��
	 */
	public void setRcfrequency(String rcfrequency) {
		this.rcfrequency = rcfrequency;
	}

	/**
	 * ������ȡ��
	 * @return rcusername ������
	 */
	public String getRcusername() {
		return rcusername;
	}

	/**
	 * �������趨
	 * @param rcusername ������
	 */
	public void setRcusername(String rcusername) {
		this.rcusername = rcusername;
	}

	/**
	 * ��������ȡ��
	 * @return rccategoryname ��������
	 */
	public String getRccategoryname() {
		return rccategoryname;
	}

	/**
	 * ���������趨
	 * @param rccategoryname ��������
	 */
	public void setRccategoryname(String rccategoryname) {
		this.rccategoryname = rccategoryname;
	}

	/**
	 * ��������ȡ��
	 * @return prtitle ��������
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * ���������趨
	 * @param prtitle ��������
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * ��鷽ʽȡ��
	 * @return rcrtestmode ��鷽ʽ
	 */
	public String getRcrtestmode() {
		return rcrtestmode;
	}

	/**
	 * ��鷽ʽ�趨
	 * @param rcrtestmode ��鷽ʽ
	 */
	public void setRcrtestmode(String rcrtestmode) {
		this.rcrtestmode = rcrtestmode;
	}

	/**
	 * �����ȡ��
	 * @return rcstatus �����
	 */
	public String getRcstatus() {
		return rcstatus;
	}

	/**
	 * ������趨
	 * @param rcstatus �����
	 */
	public void setRcstatus(String rcstatus) {
		this.rcstatus = rcstatus;
	}

	/**
	 * ʵ�ʼ��ʱ��ȡ��
	 * @return rccreatetime ʵ�ʼ��ʱ��
	 */
	public String getRccreatetime() {
		return rccreatetime;
	}

	/**
	 * ʵ�ʼ��ʱ���趨
	 * @param rccreatetime ʵ�ʼ��ʱ��
	 */
	public void setRccreatetime(String rccreatetime) {
		this.rccreatetime = rccreatetime;
	}

	/**
	 * ���˵��ȡ��
	 * @return rcrcomment ���˵��
	 */
	public String getRcrcomment() {
		return rcrcomment;
	}

	/**
	 * ���˵���趨
	 * @param rcrcomment ���˵��
	 */
	public void setRcrcomment(String rcrcomment) {
		this.rcrcomment = rcrcomment;
	}

	/**
	 * ���̶�ȡ��
	 * @return rcrresult ���̶�
	 */
	public String getRcrresult() {
		return rcrresult;
	}

	/**
	 * ���̶��趨
	 * @param rcrresult ���̶�
	 */
	public void setRcrresult(String rcrresult) {
		this.rcrresult = rcrresult;
	}

	/**
	 * ����ȡ��
	 * @return rcrattch ����
	 */
	public String getRcrattch() {
		return rcrattch;
	}

	/**
	 * �����趨
	 * @param rcrattch ����
	 */
	public void setRcrattch(String rcrattch) {
		this.rcrattch = rcrattch;
	}

	/**
	 * ���ƻ�ʱ��ȡ��
	 * @return rcrplandate ���ƻ�ʱ��
	 */
	public String getRcrplandate() {
		return rcrplandate;
	}

	/**
	 * ���ƻ�ʱ���趨
	 * @param rcrplandate ���ƻ�ʱ��
	 */
	public void setRcrplandate(String rcrplandate) {
		this.rcrplandate = rcrplandate;
	}

	/**
	 * ��ȡ��
	 * @return year ��
	 */
	public String getYear() {
		return year;
	}

	/**
	 * ���趨
	 * @param year ��
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * ��ȡ��
	 * @return month ��
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * ���趨
	 * @param month ��
	 */
	public void setMonth(String month) {
		this.month = month;
	}

}

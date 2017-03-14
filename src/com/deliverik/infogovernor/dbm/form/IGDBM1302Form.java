/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.dbm.form;
import com.deliverik.framework.base.BaseForm;


/**
 * ��������-����Form
 *
 */
@SuppressWarnings("serial")
public class IGDBM1302Form extends BaseForm {

	protected Integer wmid;
	
	/** �������� */
	protected String wmname;

	/** ���� */
	protected String wmdesc;

	/** ���״̬(0-δ���1-�����) */
	protected String wmstatus;

	/** �������� */
	protected String wmstartdate;

	/** ����������� */
	protected String wmlimitdate;

	/** ʵ��������� */
	protected String wmfactdate;

	/** Ƶ�� */
	protected String wmfrequency;

	/** ����ִ�б��ʽ  */
	protected String wmcron;

	/** ������id */
	protected String wmuserid;

	/** ���������� */
	protected String wmusername;

	/** �����˽�ɫid */
	protected String wmroleid;

	/** �����˽�ɫ���� */
	protected String wmrolename;

	/** ѡ�� */
	protected String wmoption;

	/** ����ʱ�䣨Сʱ�� */
	protected String wmremindh;

	/** ����ʱ�䣨���ӣ� */
	protected String wmremindm;

	/** ������Դ 0-�Ǽ�1-����  */
	protected String wmtype;

	/** �Ƿ�����0-����1-��������  */
	protected String wmremind;

	/** ��ע */
	protected String wmremark;
	
	/** ���ռ��Ƶ������ */
	protected String wmfrequencydesc;
	
	/** ���ռ��Ƶ��(��) */
	protected String[] wmfrequencyweek;
	
	/** ���ռ��Ƶ��(��) */
	protected String[] wmfrequencymonth;
	
	/** ���ռ��Ƶ��(ÿ�����һ��) */
	protected String wmfrequencymonthlastday;
	/** ����Դ wmid  */
	protected String rewmid;
	
	/** ���ռ��Ƶ��(��) */
	protected String wmfrequencyweeks;
	
	/** ���ռ��Ƶ��(��) */
	protected String wmfrequencymonths;
	
	/**
	 * @return the ����Դwmid
	 */
	public String getRewmid() {
		return rewmid;
	}

	/**
	 * @param ����Դwmid the rewmid to set
	 */
	public void setRewmid(String rewmid) {
		this.rewmid = rewmid;
	}

	/**
	 * @return the wmid
	 */
	public Integer getWmid() {
		return wmid;
	}

	/**
	 * @param wmid the wmid to set
	 */
	public void setWmid(Integer wmid) {
		this.wmid = wmid;
	}

	/**
	 * @return the ��������
	 */
	public String getWmname() {
		return wmname;
	}

	/**
	 * @param �������� the wmname to set
	 */
	public void setWmname(String wmname) {
		this.wmname = wmname;
	}

	/**
	 * @return the ����
	 */
	public String getWmdesc() {
		return wmdesc;
	}

	/**
	 * @param ���� the wmdesc to set
	 */
	public void setWmdesc(String wmdesc) {
		this.wmdesc = wmdesc;
	}

	/**
	 * @return the ���״̬(0-δ���1-�����)
	 */
	public String getWmstatus() {
		return wmstatus;
	}

	/**
	 * @param ���״̬(0-δ���1-�����) the wmstatus to set
	 */
	public void setWmstatus(String wmstatus) {
		this.wmstatus = wmstatus;
	}

	/**
	 * @return the ��������
	 */
	public String getWmstartdate() {
		return wmstartdate;
	}

	/**
	 * @param �������� the wmstartdate to set
	 */
	public void setWmstartdate(String wmstartdate) {
		this.wmstartdate = wmstartdate;
	}

	/**
	 * @return the �����������
	 */
	public String getWmlimitdate() {
		return wmlimitdate;
	}

	/**
	 * @param ����������� the wmlimitdate to set
	 */
	public void setWmlimitdate(String wmlimitdate) {
		this.wmlimitdate = wmlimitdate;
	}

	/**
	 * @return the ʵ���������
	 */
	public String getWmfactdate() {
		return wmfactdate;
	}

	/**
	 * @param ʵ��������� the wmfactdate to set
	 */
	public void setWmfactdate(String wmfactdate) {
		this.wmfactdate = wmfactdate;
	}

	/**
	 * @return the Ƶ��
	 */
	public String getWmfrequency() {
		return wmfrequency;
	}

	/**
	 * @param Ƶ�� the wmfrequency to set
	 */
	public void setWmfrequency(String wmfrequency) {
		this.wmfrequency = wmfrequency;
	}

	/**
	 * @return the ����ִ�б��ʽ
	 */
	public String getWmcron() {
		return wmcron;
	}

	/**
	 * @param ����ִ�б��ʽ the wmcron to set
	 */
	public void setWmcron(String wmcron) {
		this.wmcron = wmcron;
	}

	/**
	 * @return the ������id
	 */
	public String getWmuserid() {
		return wmuserid;
	}

	/**
	 * @param ������id the wmuserid to set
	 */
	public void setWmuserid(String wmuserid) {
		this.wmuserid = wmuserid;
	}

	/**
	 * @return the ����������
	 */
	public String getWmusername() {
		return wmusername;
	}

	/**
	 * @param ���������� the wmusername to set
	 */
	public void setWmusername(String wmusername) {
		this.wmusername = wmusername;
	}

	/**
	 * @return the �����˽�ɫid
	 */
	public String getWmroleid() {
		return wmroleid;
	}

	/**
	 * @param �����˽�ɫid the wmroleid to set
	 */
	public void setWmroleid(String wmroleid) {
		this.wmroleid = wmroleid;
	}

	/**
	 * @return the �����˽�ɫ����
	 */
	public String getWmrolename() {
		return wmrolename;
	}

	/**
	 * @param �����˽�ɫ���� the wmrolename to set
	 */
	public void setWmrolename(String wmrolename) {
		this.wmrolename = wmrolename;
	}

	/**
	 * @return the ѡ��
	 */
	public String getWmoption() {
		return wmoption;
	}

	/**
	 * @param ѡ�� the wmoption to set
	 */
	public void setWmoption(String wmoption) {
		this.wmoption = wmoption;
	}

	/**
	 * @return the ����ʱ�䣨Сʱ��
	 */
	public String getWmremindh() {
		return wmremindh;
	}

	/**
	 * @param ����ʱ�䣨Сʱ�� the wmremindh to set
	 */
	public void setWmremindh(String wmremindh) {
		this.wmremindh = wmremindh;
	}

	/**
	 * @return the ����ʱ�䣨���ӣ�
	 */
	public String getWmremindm() {
		return wmremindm;
	}

	/**
	 * @param ����ʱ�䣨���ӣ� the wmremindm to set
	 */
	public void setWmremindm(String wmremindm) {
		this.wmremindm = wmremindm;
	}

	/**
	 * @return the ������Դ0-�Ǽ�1-����
	 */
	public String getWmtype() {
		return wmtype;
	}

	/**
	 * @param ������Դ0-�Ǽ�1-���� the wmtype to set
	 */
	public void setWmtype(String wmtype) {
		this.wmtype = wmtype;
	}

	/**
	 * @return the �Ƿ�����0-����1-��������
	 */
	public String getWmremind() {
		return wmremind;
	}

	/**
	 * @param �Ƿ�����0-����1-�������� the wmremind to set
	 */
	public void setWmremind(String wmremind) {
		this.wmremind = wmremind;
	}

	/**
	 * @return the ��ע
	 */
	public String getWmremark() {
		return wmremark;
	}

	/**
	 * @param ��ע the wmremark to set
	 */
	public void setWmremark(String wmremark) {
		this.wmremark = wmremark;
	}

	/**
	 * @return the ���ռ��Ƶ������
	 */
	public String getWmfrequencydesc() {
		return wmfrequencydesc;
	}

	/**
	 * @param ���ռ��Ƶ������ the wmfrequencydesc to set
	 */
	public void setWmfrequencydesc(String wmfrequencydesc) {
		this.wmfrequencydesc = wmfrequencydesc;
	}

	/**
	 * @return the ���ռ��Ƶ��(��)
	 */
	public String[] getWmfrequencyweek() {
		return wmfrequencyweek;
	}

	/**
	 * @param ���ռ��Ƶ��(��) the wmfrequencyweek to set
	 */
	public void setWmfrequencyweek(String[] wmfrequencyweek) {
		this.wmfrequencyweek = wmfrequencyweek;
	}

	/**
	 * @return the ���ռ��Ƶ��(��)
	 */
	public String[] getWmfrequencymonth() {
		return wmfrequencymonth;
	}

	/**
	 * @param ���ռ��Ƶ��(��) the wmfrequencymonth to set
	 */
	public void setWmfrequencymonth(String[] wmfrequencymonth) {
		this.wmfrequencymonth = wmfrequencymonth;
	}

	/**
	 * @return the ���ռ��Ƶ��(ÿ�����һ��)
	 */
	public String getWmfrequencymonthlastday() {
		return wmfrequencymonthlastday;
	}

	/**
	 * @param ���ռ��Ƶ��(ÿ�����һ��) the wmfrequencymonthlastday to set
	 */
	public void setWmfrequencymonthlastday(String wmfrequencymonthlastday) {
		this.wmfrequencymonthlastday = wmfrequencymonthlastday;
	}

	/**
	 * @return the ���ռ��Ƶ��(��)
	 */
	public String getWmfrequencyweeks() {
		return wmfrequencyweeks;
	}

	/**
	 * @param ���ռ��Ƶ��(��) the wmfrequencyweeks to set
	 */
	public void setWmfrequencyweeks(String wmfrequencyweeks) {
		this.wmfrequencyweeks = wmfrequencyweeks;
	}

	/**
	 * @return the ���ռ��Ƶ��(��)
	 */
	public String getWmfrequencymonths() {
		return wmfrequencymonths;
	}

	/**
	 * @param ���ռ��Ƶ��(��) the wmfrequencymonths to set
	 */
	public void setWmfrequencymonths(String wmfrequencymonths) {
		this.wmfrequencymonths = wmfrequencymonths;
	}
	
}

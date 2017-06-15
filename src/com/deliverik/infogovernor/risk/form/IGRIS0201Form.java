package com.deliverik.infogovernor.risk.form;

import com.deliverik.framework.base.BaseForm;


/**
 * ���ռ��FORM
 * 
 */
@SuppressWarnings("serial")
public class IGRIS0201Form extends BaseForm {
	
	/** ���ռ��ID */
	protected Integer rcid;

	/** ���ռ������ */
	protected String rcname;
	
	/** ���ռ������ */
	protected String rcdesc;
	
	/** ���ռ������ */
	protected String rctype;
	
	/** ���ռ��״̬ */
	protected String rcstatus;
	
	/** ���ռ��״̬��ѯ */
	protected String rcstatus_q;
	
	/** ���ռ����ʼ���� */
	protected String rcstartdate;
	
	/** ���ռ��������� */
	protected String rcenddate;
	
	/** ���ռ��Ƶ�� */
	protected String rcfrequency;
	
	/** ���ռ��������id */
	protected String rcuserid;
	
	/** ���ռ������������ */
	protected String rcusername;
	
	/** ���ռ���������ɫid */
	protected String rcroleid;
	
	/** ���ռ���������ɫ�� */
	protected String rcrolename;
	
	/** ���ռ������ʲ� */
	protected Integer rcasset;
	
	/** ���ռ������ʲ����� */
	protected String rcassetname;
	
	/** ���ռ�鸽�� */
	protected String rcattch;
	
	/** ���ռ��ѡ�� */
	protected String rcoption;
	
	/** ���ռ�����ִ�б��ʽ */
	protected String rccron;
	
	protected String fingerPrint;
	
	/** 0Ϊ���� 1Ϊ��� */
	protected String mode;

	protected String rcrtestmode;
	
	/** ���ռ�����Ʋ�ѯ���� */
	protected String rcname_q;
	
	/** �������ID */
	protected Integer raid;
	
	/** ����������������� */
	protected String[] radids;
	
	/** ���ռ������� */
	protected String rccategory;
	
	/** ���ռ����������� */
	protected String rccategoryname;
	
	/** ���ռ��Ǽ�ʱ�� */
	protected String rccreatetime;
	
	/** ���ռ������ʱ�� */
	protected String rcapprovetime;
	
	/** ���ռ�������� */
	protected String rcapprover;
	
	/** ���ռ������ */
	protected String rcclass;
	
	/** ���ռ�������ϸID*/
	protected String csid;
	
	/** ��Ϣ��ȫ���� */
	protected String isSecurityApproval;
	
	/**
	 * @return the radids
	 */
	public String[] getRadids() {
		return radids;
	}

	/**
	 * @param radids the radids to set
	 */
	public void setRadids(String[] radids) {
		this.radids = radids;
	}
	

	/**
	 * @return the csid
	 */
	public String getCsid() {
		return csid;
	}

	/**
	 * @param csid the csid to set
	 */
	public void setCsid(String csid) {
		this.csid = csid;
	}

	/**
	 * @return the raid
	 */
	public Integer getRaid() {
		return raid;
	}

	/**
	 * @param raid the raid to set
	 */
	public void setRaid(Integer raid) {
		this.raid = raid;
	}

	/**
	 * @return the rcname_q
	 */
	public String getRcname_q() {
		return rcname_q;
	}

	/**
	 * @param rcname_q the rcname_q to set
	 */
	public void setRcname_q(String rcname_q) {
		this.rcname_q = rcname_q;
	}

	/**
	 * @return the rcid
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * @return the rcname
	 */
	public String getRcname() {
		return rcname;
	}

	/**
	 * @return the rcdesc
	 */
	public String getRcdesc() {
		return rcdesc;
	}

	/**
	 * @return the rctype
	 */
	public String getRctype() {
		return rctype;
	}

	/**
	 * @return the rcstatus
	 */
	public String getRcstatus() {
		return rcstatus;
	}

	/**
	 * @return the rcstartdate
	 */
	public String getRcstartdate() {
		return rcstartdate;
	}

	/**
	 * @return the rcenddate
	 */
	public String getRcenddate() {
		return rcenddate;
	}

	/**
	 * @return the rcfrequency
	 */
	public String getRcfrequency() {
		return rcfrequency;
	}

	/**
	 * @return the rcuserid
	 */
	public String getRcuserid() {
		return rcuserid;
	}

	/**
	 * @return the rcusername
	 */
	public String getRcusername() {
		return rcusername;
	}

	/**
	 * @return the rcroleid
	 */
	public String getRcroleid() {
		return rcroleid;
	}

	/**
	 * @return the rcrolename
	 */
	public String getRcrolename() {
		return rcrolename;
	}

	/**
	 * @return the rcasset
	 */
	public Integer getRcasset() {
		return rcasset;
	}

	/**
	 * @return the rcassetname
	 */
	public String getRcassetname() {
		return rcassetname;
	}

	/**
	 * @return the rcattch
	 */
	public String getRcattch() {
		return rcattch;
	}

	/**
	 * @return the rcoption
	 */
	public String getRcoption() {
		return rcoption;
	}

	/**
	 * @return the rccron
	 */
	public String getRccron() {
		return rccron;
	}

	/**
	 * @return the fingerPrint
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @param rcid the rcid to set
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * @param rcname the rcname to set
	 */
	public void setRcname(String rcname) {
		this.rcname = rcname;
	}

	/**
	 * @param rcdesc the rcdesc to set
	 */
	public void setRcdesc(String rcdesc) {
		this.rcdesc = rcdesc;
	}

	/**
	 * @param rctype the rctype to set
	 */
	public void setRctype(String rctype) {
		this.rctype = rctype;
	}

	/**
	 * @param rcstatus the rcstatus to set
	 */
	public void setRcstatus(String rcstatus) {
		this.rcstatus = rcstatus;
	}

	public String getRcstatus_q() {
		return rcstatus_q;
	}

	public void setRcstatus_q(String rcstatus_q) {
		this.rcstatus_q = rcstatus_q;
	}

	/**
	 * @param rcstartdate the rcstartdate to set
	 */
	public void setRcstartdate(String rcstartdate) {
		this.rcstartdate = rcstartdate;
	}

	/**
	 * @param rcenddate the rcenddate to set
	 */
	public void setRcenddate(String rcenddate) {
		this.rcenddate = rcenddate;
	}

	/**
	 * @param rcfrequency the rcfrequency to set
	 */
	public void setRcfrequency(String rcfrequency) {
		this.rcfrequency = rcfrequency;
	}

	/**
	 * @param rcuserid the rcuserid to set
	 */
	public void setRcuserid(String rcuserid) {
		this.rcuserid = rcuserid;
	}

	/**
	 * @param rcusername the rcusername to set
	 */
	public void setRcusername(String rcusername) {
		this.rcusername = rcusername;
	}

	/**
	 * @param rcroleid the rcroleid to set
	 */
	public void setRcroleid(String rcroleid) {
		this.rcroleid = rcroleid;
	}

	/**
	 * @param rcrolename the rcrolename to set
	 */
	public void setRcrolename(String rcrolename) {
		this.rcrolename = rcrolename;
	}

	/**
	 * @param rcasset the rcasset to set
	 */
	public void setRcasset(Integer rcasset) {
		this.rcasset = rcasset;
	}

	/**
	 * @param rcassetname the rcassetname to set
	 */
	public void setRcassetname(String rcassetname) {
		this.rcassetname = rcassetname;
	}

	/**
	 * @param rcattch the rcattch to set
	 */
	public void setRcattch(String rcattch) {
		this.rcattch = rcattch;
	}

	/**
	 * @param rcoption the rcoption to set
	 */
	public void setRcoption(String rcoption) {
		this.rcoption = rcoption;
	}

	/**
	 * @param rccron the rccron to set
	 */
	public void setRccron(String rccron) {
		this.rccron = rccron;
	}

	/**
	 * @param fingerPrint the fingerPrint to set
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * ���ռ�������ȡ��
	 * @return ���ռ�������
	 */
	public String getRccategory() {
		return rccategory;
	}

	/**
	 * ���ռ��������趨
	 *
	 * @param rccategory ���ռ�������
	 */
	public void setRccategory(String rccategory) {
		this.rccategory = rccategory;
	}

	/**
	 * ���ռ�����������ȡ��
	 * @return ���ռ�����������
	 */
	public String getRccategoryname() {
		return rccategoryname;
	}

	/**
	 * ���ռ������������趨
	 *
	 * @param rccategoryname ���ռ�����������
	 */
	public void setRccategoryname(String rccategoryname) {
		this.rccategoryname = rccategoryname;
	}
	
	/**
	 * ���ռ��Ǽ�ʱ��ȡ��
	 * @return ���ռ��Ǽ�ʱ��
	 */
	public String getRccreatetime() {
		return rccreatetime;
	}

	/**
	 * ���ռ��Ǽ�ʱ���趨
	 *
	 * @param rccreatetime ���ռ��Ǽ�ʱ��
	 */
	public void setRccreatetime(String rccreatetime) {
		this.rccreatetime = rccreatetime;
	}
	
	/**
	 * ���ռ������ʱ��ȡ��
	 * @return ���ռ������ʱ��
	 */
	public String getRcapprovetime() {
		return rcapprovetime;
	}

	/**
	 * ���ռ������ʱ���趨
	 *
	 * @param rcapprovetime ���ռ������ʱ��
	 */
	public void setRcapprovetime(String rcapprovetime) {
		this.rcapprovetime = rcapprovetime;
	}

	/**
	 * ���ռ��������ȡ��
	 * @return ���ռ��������
	 */
	public String getRcapprover() {
		return rcapprover;
	}

	/**
	 * ���ռ���������趨
	 *
	 * @param rcapprover ���ռ��������
	 */
	public void setRcapprover(String rcapprover) {
		this.rcapprover = rcapprover;
	}

	public String getRcclass() {
		return rcclass;
	}

	public void setRcclass(String rcclass) {
		this.rcclass = rcclass;
	}

	public String getIsSecurityApproval() {
		return isSecurityApproval;
	}

	public void setIsSecurityApproval(String isSecurityApproval) {
		this.isSecurityApproval = isSecurityApproval;
	}

	/**
	 * @return the rcrtestmode
	 */
	public String getRcrtestmode() {
		return rcrtestmode;
	}

	/**
	 * @param rcrtestmode the rcrtestmode to set
	 */
	public void setRcrtestmode(String rcrtestmode) {
		this.rcrtestmode = rcrtestmode;
	}
	
	
}

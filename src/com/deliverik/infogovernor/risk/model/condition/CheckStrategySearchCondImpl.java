/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
  * ����: �����Լ�������ʵ��
  * ��������: �����Լ�������ʵ��
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
public class CheckStrategySearchCondImpl implements
		CheckStrategySearchCond {

	protected Integer csid;

	/** ������� */
	protected String csname;

	/** ���� */
	protected String csdesc;

	/** ״̬ */
	protected String csstatus;

	/** ��ʼ���� */
	protected String csstartdate;

	/** �������� */
	protected String csenddate;
	
	/** ��Ҫ�̶�*/
	protected String cstype;

	/** Ƶ�� */
	protected String csfrequency;
	
	/** ��鷽ʽ*/
	protected String csrtestmode;

	/** ����ִ�б��ʽ */
	protected String cscron;

	/** ������ID */
	protected String csuserid;

	/** ���������� */
	protected String csusername;

	/** �������ɫID */
	protected String csroleid;

	/** �������ɫ���� */
	protected String csrolename;

	/** ����������id */
	protected String csasset;

	/** �������������� */
	protected String csassetname;
	
	/** �����������ɫid*/
	protected String csassetorgid;
	
	/** ��������������*/
	protected String csassetorgname;

	/** ���� */
	protected String csattch ;

	/** ѡ�� */
	protected String csoption ;

	/**
	 * @return the csid
	 */
	public Integer getCsid() {
		return csid;
	}

	/**
	 * @param csid the csid to set
	 */
	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	/**
	 * @return the csname
	 */
	public String getCsname() {
		return csname;
	}

	/**
	 * @param csname the csname to set
	 */
	public void setCsname(String csname) {
		this.csname = csname;
	}

	/**
	 * @return the csdesc
	 */
	public String getCsdesc() {
		return csdesc;
	}

	/**
	 * @param csdesc the csdesc to set
	 */
	public void setCsdesc(String csdesc) {
		this.csdesc = csdesc;
	}

	/**
	 * @return the csstatus
	 */
	public String getCsstatus() {
		return csstatus;
	}

	/**
	 * @param csstatus the csstatus to set
	 */
	public void setCsstatus(String csstatus) {
		this.csstatus = csstatus;
	}

	/**
	 * @return the csstartdate
	 */
	public String getCsstartdate() {
		return csstartdate;
	}

	/**
	 * @param csstartdate the csstartdate to set
	 */
	public void setCsstartdate(String csstartdate) {
		this.csstartdate = csstartdate;
	}

	/**
	 * @return the csenddate
	 */
	public String getCsenddate() {
		return csenddate;
	}

	/**
	 * @param csenddate the csenddate to set
	 */
	public void setCsenddate(String csenddate) {
		this.csenddate = csenddate;
	}

	/**
	 * @return the csfrequency
	 */
	public String getCsfrequency() {
		return csfrequency;
	}

	/**
	 * @param csfrequency the csfrequency to set
	 */
	public void setCsfrequency(String csfrequency) {
		this.csfrequency = csfrequency;
	}

	/**
	 * @return the cscron
	 */
	public String getCscron() {
		return cscron;
	}

	/**
	 * @param cscron the cscron to set
	 */
	public void setCscron(String cscron) {
		this.cscron = cscron;
	}

	/**
	 * @return the csuserid
	 */
	public String getCsuserid() {
		return csuserid;
	}

	/**
	 * @param csuserid the csuserid to set
	 */
	public void setCsuserid(String csuserid) {
		this.csuserid = csuserid;
	}

	/**
	 * @return the csusername
	 */
	public String getCsusername() {
		return csusername;
	}

	/**
	 * @param csusername the csusername to set
	 */
	public void setCsusername(String csusername) {
		this.csusername = csusername;
	}

	/**
	 * @return the csroleid
	 */
	public String getCsroleid() {
		return csroleid;
	}

	/**
	 * @param csroleid the csroleid to set
	 */
	public void setCsroleid(String csroleid) {
		this.csroleid = csroleid;
	}

	/**
	 * @return the csrolename
	 */
	public String getCsrolename() {
		return csrolename;
	}

	/**
	 * @param csrolename the csrolename to set
	 */
	public void setCsrolename(String csrolename) {
		this.csrolename = csrolename;
	}

	/**
	 * @return the csasset
	 */
	public String getCsasset() {
		return csasset;
	}

	/**
	 * @param csasset the csasset to set
	 */
	public void setCsasset(String csasset) {
		this.csasset = csasset;
	}

	/**
	 * @return the csassetname
	 */
	public String getCsassetname() {
		return csassetname;
	}

	/**
	 * @param csassetname the csassetname to set
	 */
	public void setCsassetname(String csassetname) {
		this.csassetname = csassetname;
	}

	/**
	 * @return the csattch
	 */
	public String getCsattch() {
		return csattch;
	}

	/**
	 * @param csattch the csattch to set
	 */
	public void setCsattch(String csattch) {
		this.csattch = csattch;
	}

	/**
	 * @return the csoption
	 */
	public String getCsoption() {
		return csoption;
	}

	/**
	 * @param csoption the csoption to set
	 */
	public void setCsoption(String csoption) {
		this.csoption = csoption;
	}

	/**
	 * @return the cstype
	 */
	public String getCstype() {
		return cstype;
	}

	/**
	 * @param cstype the cstype to set
	 */
	public void setCstype(String cstype) {
		this.cstype = cstype;
	}

	/**
	 * @return the csrtestmode
	 */
	public String getCsrtestmode() {
		return csrtestmode;
	}

	/**
	 * @param csrtestmode the csrtestmode to set
	 */
	public void setCsrtestmode(String csrtestmode) {
		this.csrtestmode = csrtestmode;
	}

	/**
	 * @return the csassetorgid
	 */
	public String getCsassetorgid() {
		return csassetorgid;
	}

	/**
	 * @param csassetorgid the csassetorgid to set
	 */
	public void setCsassetorgid(String csassetorgid) {
		this.csassetorgid = csassetorgid;
	}

	/**
	 * @return the csassetorgname
	 */
	public String getCsassetorgname() {
		return csassetorgname;
	}

	/**
	 * @param csassetorgname the csassetorgname to set
	 */
	public void setCsassetorgname(String csassetorgname) {
		this.csassetorgname = csassetorgname;
	}
	
	
	
}
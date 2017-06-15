package com.deliverik.infogovernor.risk.model.condition;


/**
 * ���ռ����Ϣ��ѯ����ʵ��
 * 
 */
public class RiskCheckSearchCondImpl implements RiskCheckSearchCond {

	/** ���ռ��ID */
	protected Integer rcid;
	
	protected Integer[] rcid_in;

	/** ���ռ������ */
	protected String rcname;
	
	/** ���ռ������ */
	protected String rcdesc;
	
	/** ���ռ������ */
	protected String rctype;
	
	/** ���ռ��״̬ */
	protected String rcstatus;
	
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
	
	/** ���ռ�鸽�� */
	protected String rcattch;
	
	/** ���ռ��ѡ�� */
	protected String rcoption;
	
	/** ���ռ�����Ʋ�ѯ���� */
	protected String rcname_q;
	
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
	protected String yearMonth;
	protected String month;
	protected String year;
	protected String startDate;
	protected String endDate;
	
	/** ����ʱ�� */
	protected String rcCreateTime_like;
	
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


	public String getYearMonth() {
		return yearMonth;
	}

	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getStartDate() {
		return startDate;
	}


	/**
	 * @return the rcid_in
	 */
	public Integer[] getRcid_in() {
		return rcid_in;
	}

	/**
	 * @param rcid_in the rcid_in to set
	 */
	public void setRcid_in(Integer[] rcid_in) {
		this.rcid_in = rcid_in;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return rcCreateTime_like ����ʱ��
	 */
	public String getRcCreateTime_like() {
		return rcCreateTime_like;
	}

	/**
	 * ����ʱ���趨
	 * @param rcCreateTime_like ����ʱ��
	 */
	public void setRcCreateTime_like(String rcCreateTime_like) {
		this.rcCreateTime_like = rcCreateTime_like;
	}

	
}

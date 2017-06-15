package com.deliverik.infogovernor.risk.model.condition;


/**
 * ���ռ����Ϣ��ѯ����ʵ��
 * 
 */
public class RiskCheckResultSearchCondImpl implements RiskCheckResultSearchCond {

	/** ���ռ����ID */
	protected Integer rcrid;
	
	protected Integer[] rcrid_in;
	
	/** ���ռ��ID */
	protected Integer rcid;
	
	/** ���ռ����������*/
	protected String rcname;

	/** ���ռ��ƻ����ʱ�� */
	protected String rcrplandate;

	/** ���ռ��ƻ����ʱ�� */
	protected String rcrplandate_from;

	/** ���ռ��ƻ����ʱ�� */
	protected String rcrplandate_to;
	
	/** ���ռ��ʵ�ʼ��ʱ�� */
	protected String rcrrealtime;
	
	/** ���ռ��ʵ�ʼ��ʱ�� */
	protected String rcrrealtime_like;
	
	/** ���ռ��ʵ�ʼ��ʱ�� */
	protected String rcrrealtime_isNull;

	/** ���ռ�����ύ��id */
	protected String rcruserid;
	
	/** ���ռ�����ύ������ */
	protected String rcrusername;
	
	/** ���ռ���� */
	protected String rcrresult;
	
	/** ���ռ����˵�� */
	protected String rcrcomment;
	
	protected String rcruserid_isNull;
	
	/** �ƻ�ִ�м�鿪ʼ���ڣ���ѯ������ */
	protected String startdate;
	
	/** �ƻ�ִ�м��������ڣ���ѯ������*/
	protected String enddate;

	/** ���ռ��������������_like */
	protected String rcusername_like;
	
	/** �ƻ�ִ�м�����ѯ������*/
	protected String rcname_like;
	
	/** �ƻ�ִ�м�鿪ʼ����from����ѯ������*/
	protected String ntime_from;
	
	/** �ƻ�ִ�м�鿪ʼ����to����ѯ������*/
	protected String ntime_to;
	

	/** ���ռ������� */
	protected String rccategory;
	/** ���ռ������� */
	protected String rccategoryname;
	
	/** δ��鹤����ʶ */
	protected String chtype;
	
	/** ���ռ��״̬ */
	protected String rcrstatic;

	/** ���ռ���������ɫID */
	protected Integer[] rcroleid;
	
	/** ���ռ�鲻������������ID */
	protected String rcuserid_ne;
	
	/** ��Ҫ�̶� */
	protected String rctype_eq;
	
	/** ���ռ��������ID */
	protected String rcuserid;
	/** ���ռ�������Ա */
	protected String rcrelateduser;
	protected String rcusername;
	protected String ciiop;
	protected String rcapprovetime;
	protected String rcclass;
	protected String year;
	
	/** ��鷽ʽ  */
	protected String rcrtestmode;
	
	public String getRcapprovetime() {
		return rcapprovetime;
	}

	public void setRcapprovetime(String rcapprovetime) {
		this.rcapprovetime = rcapprovetime;
	}

	public String getRcusername() {
		return rcusername;
	}

	public void setRcusername(String rcusername) {
		this.rcusername = rcusername;
	}

	public String getCiiop() {
		return ciiop;
	}

	public void setCiiop(String ciiop) {
		this.ciiop = ciiop;
	}

	protected String ciiopid;
	public String getCiiopid() {
		return ciiopid;
	}

	public void setCiiopid(String ciiopid) {
		this.ciiopid = ciiopid;
	}

	/**
	 * ���ռ��������IDȡ��
	 */
	public String getRcuserid() {
		return rcuserid;
	}

	/**
	 * ���ռ��������ID�趨
	 * @param rcuserid ���ռ��������ID
	 */
	public void setRcuserid(String rcuserid) {
		this.rcuserid = rcuserid;
	}

	/**
	 * ��Ҫ�̶Ȼ�ȡ
	 * 
	 * @return ��Ҫ�̶�
	 */
	public String getRctype_eq() {
		return rctype_eq;
	}

	/**
	 * ��Ҫ�̶��趨
	 * 
	 * @param rctype_eq ��Ҫ�̶�
	 */
	public void setRctype_eq(String rctype_eq) {
		this.rctype_eq = rctype_eq;
	}

	/**
	 * ���ռ�鲻������������IDȡ��
	 * @return ���ռ�鲻������������ID
	 */
	public String getRcuserid_ne() {
		return rcuserid_ne;
	}

	/**
	 * ���ռ�鲻������������ID�趨
	 * @param rcruserid_ne ���ռ�鲻������������ID
	 */
	public void setRcuserid_ne(String rcuserid_ne) {
		this.rcuserid_ne = rcuserid_ne;
	}
	
	/**
	 * ���ռ���������ɫIDȡ��
	 * @return ���ռ���������ɫID
	 */
	public Integer[] getRcroleid() {
		return rcroleid;
	}

	/**
	 * ���ռ���������ɫID�趨
	 * @param rcroleid ���ռ���������ɫID
	 */
	public void setRcroleid(Integer[] rcroleid) {
		this.rcroleid = rcroleid;
	}

	/**
	 * @return the rcname
	 */
	public String getRcname() {
		return rcname;
	}

	/**
	 * @param rcname the rcname to set
	 */
	public void setRcname(String rcname) {
		this.rcname = rcname;
	}

	/**
	 * @return the startdate
	 */
	public String getStartdate() {
		return startdate;
	}

	/**
	 * @return the enddate
	 */
	public String getEnddate() {
		return enddate;
	}

	/**
	 * @param startdate the startdate to set
	 */
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	/**
	 * @param enddate the enddate to set
	 */
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	/**
	 * @return the rcruserid_isNull
	 */
	public String getRcruserid_isNull() {
		return rcruserid_isNull;
	}

	/**
	 * @param rcruserid_isNull the rcruserid_isNull to set
	 */
	public void setRcruserid_isNull(String rcruserid_isNull) {
		this.rcruserid_isNull = rcruserid_isNull;
	}

	/**
	 * @return the rcrrealtime
	 */
	public String getRcrrealtime() {
		return rcrrealtime;
	}

	/**
	 * ���ռ��ʵ�ʼ��ʱ��ȡ��
	 * @return rcrrealtime_like ���ռ��ʵ�ʼ��ʱ��
	 */
	public String getRcrrealtime_like() {
		return rcrrealtime_like;
	}

	/**
	 * ���ռ��ʵ�ʼ��ʱ���趨
	 * @param rcrrealtime_like ���ռ��ʵ�ʼ��ʱ��
	 */
	public void setRcrrealtime_like(String rcrrealtime_like) {
		this.rcrrealtime_like = rcrrealtime_like;
	}

	/**
	 * @param rcrrealtime the rcrrealtime to set
	 */
	public void setRcrrealtime(String rcrrealtime) {
		this.rcrrealtime = rcrrealtime;
	}

	/**
	 * @return the rcrid
	 */
	public Integer getRcrid() {
		return rcrid;
	}

	/**
	 * @return the rcid
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * @return the rcrplandate
	 */
	public String getRcrplandate() {
		return rcrplandate;
	}


	/**
	 * @return the rcruserid
	 */
	public String getRcruserid() {
		return rcruserid;
	}

	/**
	 * @return the rcrusername
	 */
	public String getRcrusername() {
		return rcrusername;
	}

	/**
	 * @return the rcrresult
	 */
	public String getRcrresult() {
		return rcrresult;
	}

	/**
	 * @return the rcrcomment
	 */
	public String getRcrcomment() {
		return rcrcomment;
	}

	/**
	 * @param rcrid the rcrid to set
	 */
	public void setRcrid(Integer rcrid) {
		this.rcrid = rcrid;
	}

	/**
	 * @param rcid the rcid to set
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * @param rcrplandate the rcrplandate to set
	 */
	public void setRcrplandate(String rcrplandate) {
		this.rcrplandate = rcrplandate;
	}

	

	/**
	 * @param rcruserid the rcruserid to set
	 */
	public void setRcruserid(String rcruserid) {
		this.rcruserid = rcruserid;
	}

	/**
	 * @param rcrusername the rcrusername to set
	 */
	public void setRcrusername(String rcrusername) {
		this.rcrusername = rcrusername;
	}

	/**
	 * @param rcrresult the rcrresult to set
	 */
	public void setRcrresult(String rcrresult) {
		this.rcrresult = rcrresult;
	}

	/**
	 * @param rcrcomment the rcrcomment to set
	 */
	public void setRcrcomment(String rcrcomment) {
		this.rcrcomment = rcrcomment;
	}
	
	public String getRcusername_like() {
		return rcusername_like;
	}

	public void setRcusername_like(String rcusername_like) {
		this.rcusername_like = rcusername_like;
	}

	public String getRcname_like() {
		return rcname_like;
	}

	public void setRcname_like(String rcname_like) {
		this.rcname_like = rcname_like;
	}

	public String getNtime_from() {
		return ntime_from;
	}

	public void setNtime_from(String ntime_from) {
		this.ntime_from = ntime_from;
	}

	public String getNtime_to() {
		return ntime_to;
	}

	public void setNtime_to(String ntime_to) {
		this.ntime_to = ntime_to;
	}
	
	

	/**
	 * rccategoryȡ��
	 *
	 * @return rccategory rccategory
	 */
	public String getRccategory() {
		return rccategory;
	}

	/**
	 * rccategory�趨
	 *
	 * @param rccategory rccategory
	 */
	public void setRccategory(String rccategory) {
		this.rccategory = rccategory;
	}
	
	/**
	 * δ��鹤����ʶȡ��
	 * @return δ��鹤����ʶ
	 */
	public String getChtype() {
		return chtype;
	}
	
	/**
	 * δ��鹤����ʶ�趨
	 *
	 * @param notReview δ��鹤����ʶ
	 */
	public void setChtype(String chtype) {
		this.chtype = chtype;
	}
	
	/**
	 * ���ռ��ʵ�ʼ��ʱ��ȡ��
	 * 
	 * @return ���ռ��ʵ�ʼ��ʱ��
	 */
	public String getRcrrealtime_isNull() {
		return rcrrealtime_isNull;
	}

	/**
	 * ���ռ��ʵ�ʼ��ʱ���趨
	 * 
	 * @param rcrrealtime_isNull ���ռ��ʵ�ʼ��ʱ��
	 */
	public void setRcrrealtime_isNull(String rcrrealtime_isNull) {
		this.rcrrealtime_isNull = rcrrealtime_isNull;
	}
	
	/**
	 * ���ռ��״̬ȡ��
	 * @return ���ռ��״̬
	 */
	public String getRcrstatic() {
		return rcrstatic;
	}

	/**
	 * ���ռ��״̬�趨
	 *
	 * @param rcrstatic ���ռ��״̬
	 */
	public void setRcrstatic(String rcrstatic) {
		this.rcrstatic = rcrstatic;
	}

	/**
	 * ���ռ�������Ա��ȡ
	 * @return ���ռ�������Ա
	 */
	public String getRcrelateduser() {
		return rcrelateduser;
	}

	/**
	 * ���ռ�������Ա�趨
	 * @param rcrelateduser ���ռ�������Ա
	 */
	public void setRcrelateduser(String rcrelateduser) {
		this.rcrelateduser = rcrelateduser;
	}
	public String getRccategoryname() {
		return rccategoryname;
	}

	public void setRccategoryname(String rccategoryname) {
		this.rccategoryname = rccategoryname;
	}

	public String getRcclass() {
		return rcclass;
	}

	public void setRcclass(String rcclass) {
		this.rcclass = rcclass;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRcrplandate_from() {
		return rcrplandate_from;
	}

	public void setRcrplandate_from(String rcrplandate_from) {
		this.rcrplandate_from = rcrplandate_from;
	}

	public String getRcrplandate_to() {
		return rcrplandate_to;
	}

	public void setRcrplandate_to(String rcrplandate_to) {
		this.rcrplandate_to = rcrplandate_to;
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
	 * @return the rcrid_in
	 */
	public Integer[] getRcrid_in() {
		return rcrid_in;
	}

	/**
	 * @param rcrid_in the rcrid_in to set
	 */
	public void setRcrid_in(Integer[] rcrid_in) {
		this.rcrid_in = rcrid_in;
	}

	
}

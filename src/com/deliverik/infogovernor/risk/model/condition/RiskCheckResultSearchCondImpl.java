package com.deliverik.infogovernor.risk.model.condition;


/**
 * 风险检查信息查询条件实现
 * 
 */
public class RiskCheckResultSearchCondImpl implements RiskCheckResultSearchCond {

	/** 风险检查结果ID */
	protected Integer rcrid;
	
	protected Integer[] rcrid_in;
	
	/** 风险检查ID */
	protected Integer rcid;
	
	/** 风险检查检查项名称*/
	protected String rcname;

	/** 风险检查计划检查时间 */
	protected String rcrplandate;

	/** 风险检查计划检查时间 */
	protected String rcrplandate_from;

	/** 风险检查计划检查时间 */
	protected String rcrplandate_to;
	
	/** 风险检查实际检查时间 */
	protected String rcrrealtime;
	
	/** 风险检查实际检查时间 */
	protected String rcrrealtime_like;
	
	/** 风险检查实际检查时间 */
	protected String rcrrealtime_isNull;

	/** 风险检查结果提交人id */
	protected String rcruserid;
	
	/** 风险检查结果提交人姓名 */
	protected String rcrusername;
	
	/** 风险检查结果 */
	protected String rcrresult;
	
	/** 风险检查结果说明 */
	protected String rcrcomment;
	
	protected String rcruserid_isNull;
	
	/** 计划执行检查开始日期（查询条件） */
	protected String startdate;
	
	/** 计划执行检查结束日期（查询条件）*/
	protected String enddate;

	/** 风险检查结果责任人姓名_like */
	protected String rcusername_like;
	
	/** 计划执行检查项（查询条件）*/
	protected String rcname_like;
	
	/** 计划执行检查开始日期from（查询条件）*/
	protected String ntime_from;
	
	/** 计划执行检查开始日期to（查询条件）*/
	protected String ntime_to;
	

	/** 风险检查项类别 */
	protected String rccategory;
	/** 风险检查项类别 */
	protected String rccategoryname;
	
	/** 未检查工作标识 */
	protected String chtype;
	
	/** 风险检查状态 */
	protected String rcrstatic;

	/** 风险检查责任组角色ID */
	protected Integer[] rcroleid;
	
	/** 风险检查不包含的责任人ID */
	protected String rcuserid_ne;
	
	/** 重要程度 */
	protected String rctype_eq;
	
	/** 风险检查责任人ID */
	protected String rcuserid;
	/** 风险检查相关人员 */
	protected String rcrelateduser;
	protected String rcusername;
	protected String ciiop;
	protected String rcapprovetime;
	protected String rcclass;
	protected String year;
	
	/** 检查方式  */
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
	 * 风险检查责任人ID取得
	 */
	public String getRcuserid() {
		return rcuserid;
	}

	/**
	 * 风险检查责任人ID设定
	 * @param rcuserid 风险检查责任人ID
	 */
	public void setRcuserid(String rcuserid) {
		this.rcuserid = rcuserid;
	}

	/**
	 * 重要程度获取
	 * 
	 * @return 重要程度
	 */
	public String getRctype_eq() {
		return rctype_eq;
	}

	/**
	 * 重要程度设定
	 * 
	 * @param rctype_eq 重要程度
	 */
	public void setRctype_eq(String rctype_eq) {
		this.rctype_eq = rctype_eq;
	}

	/**
	 * 风险检查不包含的责任人ID取得
	 * @return 风险检查不包含的责任人ID
	 */
	public String getRcuserid_ne() {
		return rcuserid_ne;
	}

	/**
	 * 风险检查不包含的责任人ID设定
	 * @param rcruserid_ne 风险检查不包含的责任人ID
	 */
	public void setRcuserid_ne(String rcuserid_ne) {
		this.rcuserid_ne = rcuserid_ne;
	}
	
	/**
	 * 风险检查责任组角色ID取得
	 * @return 风险检查责任组角色ID
	 */
	public Integer[] getRcroleid() {
		return rcroleid;
	}

	/**
	 * 风险检查责任组角色ID设定
	 * @param rcroleid 风险检查责任组角色ID
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
	 * 风险检查实际检查时间取得
	 * @return rcrrealtime_like 风险检查实际检查时间
	 */
	public String getRcrrealtime_like() {
		return rcrrealtime_like;
	}

	/**
	 * 风险检查实际检查时间设定
	 * @param rcrrealtime_like 风险检查实际检查时间
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
	 * rccategory取得
	 *
	 * @return rccategory rccategory
	 */
	public String getRccategory() {
		return rccategory;
	}

	/**
	 * rccategory设定
	 *
	 * @param rccategory rccategory
	 */
	public void setRccategory(String rccategory) {
		this.rccategory = rccategory;
	}
	
	/**
	 * 未检查工作标识取得
	 * @return 未检查工作标识
	 */
	public String getChtype() {
		return chtype;
	}
	
	/**
	 * 未检查工作标识设定
	 *
	 * @param notReview 未检查工作标识
	 */
	public void setChtype(String chtype) {
		this.chtype = chtype;
	}
	
	/**
	 * 风险检查实际检查时间取得
	 * 
	 * @return 风险检查实际检查时间
	 */
	public String getRcrrealtime_isNull() {
		return rcrrealtime_isNull;
	}

	/**
	 * 风险检查实际检查时间设定
	 * 
	 * @param rcrrealtime_isNull 风险检查实际检查时间
	 */
	public void setRcrrealtime_isNull(String rcrrealtime_isNull) {
		this.rcrrealtime_isNull = rcrrealtime_isNull;
	}
	
	/**
	 * 风险检查状态取得
	 * @return 风险检查状态
	 */
	public String getRcrstatic() {
		return rcrstatic;
	}

	/**
	 * 风险检查状态设定
	 *
	 * @param rcrstatic 风险检查状态
	 */
	public void setRcrstatic(String rcrstatic) {
		this.rcrstatic = rcrstatic;
	}

	/**
	 * 风险检查相关人员获取
	 * @return 风险检查相关人员
	 */
	public String getRcrelateduser() {
		return rcrelateduser;
	}

	/**
	 * 风险检查相关人员设定
	 * @param rcrelateduser 风险检查相关人员
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
	 * 检查方式取得
	 * @return rcrtestmode 检查方式
	 */
	public String getRcrtestmode() {
		return rcrtestmode;
	}

	/**
	 * 检查方式设定
	 * @param rcrtestmode 检查方式
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

package com.deliverik.infogovernor.ven.form;

import com.deliverik.framework.base.BaseForm;


/**
 * 风险检查结果FORM
 * 
 */
@SuppressWarnings("serial")
public class IGVEN0201Form extends BaseForm {
	
	protected Integer rmid;

	/** 风险策略主键id */
	protected Integer rsid;

	/** 监测任务名称 */
	protected String rmname;

	/** 计划开始时间 */
	protected String rmstartdate;
	
	/** 查询条件 计划开始时间*/
	protected String rmstartdate_from;
	
	/** 查询条件 计划开始时间*/
	protected String rmstartdate_to;

	/** 实际完成时间 */
	protected String rmenddate;
	
	/** 查询条件 实际完成时间*/
	protected String rmenddate_from;
	
	/** 查询条件 实际完成时间*/
	protected String rmenddate_to;

	/**
	 * rmid取得
	 * @return rmid  rmid
	 */
	public Integer getRmid() {
		return rmid;
	}

	/**
	 * rmid设定
	 * @param rmid  rmid
	 */
	public void setRmid(Integer rmid) {
		this.rmid = rmid;
	}

	/**
	 * 风险策略主键id取得
	 * @return rsid  风险策略主键id
	 */
	public Integer getRsid() {
		return rsid;
	}

	/**
	 * 风险策略主键id设定
	 * @param rsid  风险策略主键id
	 */
	public void setRsid(Integer rsid) {
		this.rsid = rsid;
	}

	/**
	 * 监测任务名称取得
	 * @return rmname  监测任务名称
	 */
	public String getRmname() {
		return rmname;
	}

	/**
	 * 监测任务名称设定
	 * @param rmname  监测任务名称
	 */
	public void setRmname(String rmname) {
		this.rmname = rmname;
	}

	/**
	 * 计划开始时间取得
	 * @return rmstartdate  计划开始时间
	 */
	public String getRmstartdate() {
		return rmstartdate;
	}

	/**
	 * 计划开始时间设定
	 * @param rmstartdate  计划开始时间
	 */
	public void setRmstartdate(String rmstartdate) {
		this.rmstartdate = rmstartdate;
	}

	/**
	 * 查询条件计划开始时间取得
	 * @return rmstartdate_from  查询条件计划开始时间
	 */
	public String getRmstartdate_from() {
		return rmstartdate_from;
	}

	/**
	 * 查询条件计划开始时间设定
	 * @param rmstartdate_from  查询条件计划开始时间
	 */
	public void setRmstartdate_from(String rmstartdate_from) {
		this.rmstartdate_from = rmstartdate_from;
	}

	/**
	 * 查询条件计划开始时间取得
	 * @return rmstartdate_to  查询条件计划开始时间
	 */
	public String getRmstartdate_to() {
		return rmstartdate_to;
	}

	/**
	 * 查询条件计划开始时间设定
	 * @param rmstartdate_to  查询条件计划开始时间
	 */
	public void setRmstartdate_to(String rmstartdate_to) {
		this.rmstartdate_to = rmstartdate_to;
	}

	/**
	 * 实际完成时间取得
	 * @return rmenddate  实际完成时间
	 */
	public String getRmenddate() {
		return rmenddate;
	}

	/**
	 * 实际完成时间设定
	 * @param rmenddate  实际完成时间
	 */
	public void setRmenddate(String rmenddate) {
		this.rmenddate = rmenddate;
	}

	/**
	 * 查询条件实际完成时间取得
	 * @return rmenddate_from  查询条件实际完成时间
	 */
	public String getRmenddate_from() {
		return rmenddate_from;
	}

	/**
	 * 查询条件实际完成时间设定
	 * @param rmenddate_from  查询条件实际完成时间
	 */
	public void setRmenddate_from(String rmenddate_from) {
		this.rmenddate_from = rmenddate_from;
	}

	/**
	 * 查询条件实际完成时间取得
	 * @return rmenddate_to  查询条件实际完成时间
	 */
	public String getRmenddate_to() {
		return rmenddate_to;
	}

	/**
	 * 查询条件实际完成时间设定
	 * @param rmenddate_to  查询条件实际完成时间
	 */
	public void setRmenddate_to(String rmenddate_to) {
		this.rmenddate_to = rmenddate_to;
	}

	
	
	
	
	
	
	//-----------------------------------------------
//	/** 风险检查结果ID */
//	protected Integer rcrid;
//	
//	/** 风险检查ID */
//	protected Integer rcid;
//
//	/** 风险检查计划检查时间 */
//	protected String rcrplandate;
//	
//	/** 风险检查实际检查时间 */
//	protected String rcrrealtime;
//	
//	/** 风险检查结果提交人ID */
//	protected String rcruserid;
//	
//	/** 风险检查结果责任人姓名_like */
//	protected String rcusername_like;
//	
//	/** 风险检查结果提交人姓名 */
//	protected String rcrusername;
//	
//	/** 风险检查结果 */
//	protected String rcrresult;
//	
//	/** 风险检查结果说明 */
//	protected String rcrcomment;
//	
//	/** 风险检查对象 */
//	protected RiskCheck riskCheck;
//
//	
//	/** 计划执行检查开始日期（查询条件） */
//	protected String startdate;
//	
//	/** 计划执行检查结束日期（查询条件）*/
//	protected String enddate;
//	
//	/** 计划执行检查项（查询条件）*/
//	protected String rcname_like;
//	
//	/** 计划执行检查开始日期from（查询条件）*/
//	protected String ntime_from;
//	
//	/** 计划执行检查开始日期to（查询条件）*/
//	protected String ntime_to;
//	
//	/** 计划执行检查结束日期from（查询条件）*/
//	protected String etime_from;
//	
//	/** 计划执行检查结束日期to（查询条件）*/
//	protected String etime_to;	
//
//	/** 未检查工作标识 */
//	protected String chtype;
//	
//	/** 风险检查项类别 */
//	protected String rccategory;
//	
//	/** 风险检查项类别名称 */
//	protected String rccategoryname;
//	
//	protected Integer csid;
//	
//	
//	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
//	
//	/** 风险检查状态 */
//	protected String rcrstatic;
//	
//	/** 重要程度 */
//	protected String rctype_eq;
//	
//	/** 返回标识 */
//	protected String mode;
//	protected String ciiop;
//	protected String rcrtestmode;
//	
//	/** 风险检查类型 */
//	protected String rcclass;
//	/**
//	 * 返回标识获取
//	 * 
//	 * @return 返回标识
//	 */
//	public String getMode() {
//		return mode;
//	}
//
//	/**
//	 * 返回标识设定
//	 * 
//	 * @param mode 返回标识
//	 */
//	public void setMode(String mode) {
//		this.mode = mode;
//	}
//	
//	/**
//	 * 重要程度获取
//	 * 
//	 * @return 重要程度
//	 */
//	public String getRctype_eq() {
//		return rctype_eq;
//	}
//
//	/**
//	 * 重要程度设定
//	 * 
//	 * @param rctype_eq 重要程度
//	 */
//	public void setRctype_eq(String rctype_eq) {
//		this.rctype_eq = rctype_eq;
//	}
//	/**
//	 * 计划执行检查开始日期（查询条件）取得
//	 * @return 计划执行检查开始日期（查询条件）
//	 */
//	public String getStartdate() {
//		return startdate;
//	}
//
//
//	/**
//	 * 计划执行检查结束日期（查询条件）取得
//	 * @return 计划执行检查结束日期（查询条件）
//	 */
//	public String getEnddate() {
//		return enddate;
//	}
//
//
//	/**
//	 * 计划执行检查开始日期（查询条件）设定
//	 * @param startdate 计划执行检查开始日期（查询条件）
//	 */
//	public void setStartdate(String startdate) {
//		this.startdate = startdate;
//	}
//
//
//	/**
//	 * 计划执行检查结束日期（查询条件）设定
//	 * @param enddate 计划执行检查结束日期（查询条件）
//	 */
//	public void setEnddate(String enddate) {
//		this.enddate = enddate;
//	}
//
//
//	/**
//	 * @return the fileMap
//	 */
//	public Map<Integer, FormFile> getFileMap() {
//		return fileMap;
//	}
//
//
//	/**
//	 * @param fileMap the fileMap to set
//	 */
//	public void setFileMap(Map<Integer, FormFile> fileMap) {
//		this.fileMap = fileMap;
//	}
//
//
//	/**
//	 * 风险检查结果附件数据取得
//	 * @return 风险检查结果附件数据
//	 */
//	public FormFile getAttachFile(int index) {
//		return (FormFile) fileMap.get( new Integer( index ) );
//	}
//
//
//	/**
//	 * 风险检查结果附件数据
//	 *
//	 * @param index 风险检查结果附件数据数组索引
//	 * @param file 风险检查结果附件数据
//	 */
//	public void setAttachFile(int index, FormFile file) {
//		fileMap.put( new Integer( index ), file );
//	}
//
//
//	/**
//	 * 风险检查结果ID取得
//	 * @return 风险检查结果ID
//	 */
//	public Integer getRcrid() {
//		return rcrid;
//	}
//
//	/**
//	 * 风险检查ID取得
//	 * @return the 风险检查ID
//	 */
//	public Integer getRcid() {
//		return rcid;
//	}
//
//	/**
//	 * 风险检查计划检查时间取得
//	 * @return 风险检查计划检查时间
//	 */
//	public String getRcrplandate() {
//		return rcrplandate;
//	}
//
//	/**
//	 * 风险检查实际检查时间取得
//	 * @return 风险检查实际检查时间
//	 */
//	public String getRcrrealtime() {
//		return rcrrealtime;
//	}
//
//	/**
//	 * 风险检查结果提交人ID取得
//	 * @return 风险检查结果提交人ID
//	 */
//	public String getRcruserid() {
//		return rcruserid;
//	}
//
//	/**
//	 * 风险检查结果提交人姓名取得
//	 * @return 风险检查结果提交人姓名
//	 */
//	public String getRcrusername() {
//		return rcrusername;
//	}
//
//	/**
//	 * 风险检查结果设定
//	 * @param rcrresult 风险检查结果
//	 */
//	public String getRcrresult() {
//		return rcrresult;
//	}
//
//	/**
//	 * 风险检查结果说明取得
//	 * @return 风险检查结果说明
//	 */
//	public String getRcrcomment() {
//		return rcrcomment;
//	}
//
//	/**
//	 * 风险检查对象取得
//	 * @return 风险检查对象
//	 */
//	public RiskCheck getRiskCheck() {
//		return riskCheck;
//	}
//
//	/**
//	 * 风险检查结果ID设定
//	 * @param rcrid 风险检查结果ID
//	 */
//	public void setRcrid(Integer rcrid) {
//		this.rcrid = rcrid;
//	}
//
//	/**
//	 * 风险检查ID设定
//	 * @param rcid 风险检查ID
//	 */
//	public void setRcid(Integer rcid) {
//		this.rcid = rcid;
//	}
//
//	/**
//	 * 风险检查计划检查时间设定
//	 * @param rcrplandate 风险检查计划检查时间
//	 */
//	public void setRcrplandate(String rcrplandate) {
//		this.rcrplandate = rcrplandate;
//	}
//
//	/**
//	 * 风险检查实际检查时间设定
//	 * @param rcrrealtime 风险检查实际检查时间
//	 */
//	public void setRcrrealtime(String rcrrealtime) {
//		this.rcrrealtime = rcrrealtime;
//	}
//
//	/**
//	 * 风险检查结果提交人ID设定
//	 * @param rcruserid 风险检查结果提交人ID
//	 */
//	public void setRcruserid(String rcruserid) {
//		this.rcruserid = rcruserid;
//	}
//
//	/**
//	 * 风险检查结果提交人姓名设定
//	 * @param rcrusername 风险检查结果提交人姓名
//	 */
//	public void setRcrusername(String rcrusername) {
//		this.rcrusername = rcrusername;
//	}
//
//	/**
//	 * 风险检查结果设定
//	 * @param rcrresult 风险检查结果
//	 */
//	public void setRcrresult(String rcrresult) {
//		this.rcrresult = rcrresult;
//	}
//
//	/**
//	 * 风险检查结果说明设定
//	 * @param rcrcomment 风险检查结果说明
//	 */
//	public void setRcrcomment(String rcrcomment) {
//		this.rcrcomment = rcrcomment;
//	}
//
//	/**
//	 * 风险检查对象设定
//	 * @param riskCheck 风险检查对象
//	 */
//	public void setRiskCheck(RiskCheck riskCheck) {
//		this.riskCheck = riskCheck;
//	}
//
//	/**
//	 * 风险检查结果责任人姓名_like取得
//	 * return 风险检查结果责任人姓名_like
//	 */	
//	public String getRcusername_like() {
//		return rcusername_like;
//	}
//
//	/**
//	 * 风险检查结果责任人姓名_like设定
//	 * @param rcrcomment 风险检查结果责任人姓名_like
//	 */
//	public void setRcusername_like(String rcusername_like) {
//		this.rcusername_like = rcusername_like;
//	}
//
//	
//	public String getRcname_like() {
//		return rcname_like;
//	}
//
//
//	public void setRcname_like(String rcname_like) {
//		this.rcname_like = rcname_like;
//	}
//
//
//	public String getNtime_from() {
//		return ntime_from;
//	}
//
//
//	public void setNtime_from(String ntime_from) {
//		this.ntime_from = ntime_from;
//	}
//
//
//	public String getNtime_to() {
//		return ntime_to;
//	}
//
//
//	public void setNtime_to(String ntime_to) {
//		this.ntime_to = ntime_to;
//	}
//
//	/**
//	 * 未检查工作标识取得
//	 * @return 未检查工作标识
//	 */
//	public String getChtype() {
//		return chtype;
//	}
//	
//	/**
//	 * 未检查工作标识设定
//	 *
//	 * @param notReview 未检查工作标识
//	 */
//	public void setChtype(String chtype) {
//		this.chtype = chtype;
//	}
//	
//	/**
//	 * 风险检查项类别取得
//	 * @return 风险检查项类别
//	 */
//	public String getRccategory() {
//		return rccategory;
//	}
//
//	/**
//	 * 风险检查项类别设定
//	 *
//	 * @param rccategory 风险检查项类别
//	 */
//	public void setRccategory(String rccategory) {
//		this.rccategory = rccategory;
//	}
//
//	/**
//	 * 风险检查项类别名称取得
//	 * @return 风险检查项类别名称
//	 */
//	public String getRccategoryname() {
//		return rccategoryname;
//	}
//
//	/**
//	 * 风险检查项类别名称设定
//	 *
//	 * @param rccategoryname 风险检查项类别名称
//	 */
//	public void setRccategoryname(String rccategoryname) {
//		this.rccategoryname = rccategoryname;
//	}
//
//	/**
//	 * 风险检查状态取得
//	 * @return 风险检查状态
//	 */
//	public String getRcrstatic() {
//		return rcrstatic;
//	}
//
//	/**
//	 * 风险检查状态设定
//	 *
//	 * @param rcrstatic 风险检查状态
//	 */
//	public void setRcrstatic(String rcrstatic) {
//		this.rcrstatic = rcrstatic;
//	}
//
//	public String getCiiop() {
//		return ciiop;
//	}
//
//	public void setCiiop(String ciiop) {
//		this.ciiop = ciiop;
//	}
//
//	public String getRcrtestmode() {
//		return rcrtestmode;
//	}
//
//	public void setRcrtestmode(String rcrtestmode) {
//		this.rcrtestmode = rcrtestmode;
//	}
//
//	/**
//	 * 风险检查类型取得
//	 * @return rcclass 风险检查类型
//	 */
//	public String getRcclass() {
//		return rcclass;
//	}
//
//	
//	/**
//	 * @return the etime_from
//	 */
//	public String getEtime_from() {
//		return etime_from;
//	}
//
//	/**
//	 * @param etime_from the etime_from to set
//	 */
//	public void setEtime_from(String etime_from) {
//		this.etime_from = etime_from;
//	}
//
//	/**
//	 * @return the etime_to
//	 */
//	public String getEtime_to() {
//		return etime_to;
//	}
//
//	/**
//	 * @param etime_to the etime_to to set
//	 */
//	public void setEtime_to(String etime_to) {
//		this.etime_to = etime_to;
//	}
//
//	/**
//	 * 风险检查类型设定
//	 * @param rcclass 风险检查类型
//	 */
//	public void setRcclass(String rcclass) {
//		this.rcclass = rcclass;
//	}
//
//	/**
//	 * @return the csid
//	 */
//	public Integer getCsid() {
//		return csid;
//	}
//
//	/**
//	 * @param csid the csid to set
//	 */
//	public void setCsid(Integer csid) {
//		this.csid = csid;
//	}
	
	
}

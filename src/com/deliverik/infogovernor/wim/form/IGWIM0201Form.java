/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.wim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description 工作项管理Form
 * 
 * @date 2017年6月9日15:47:38
 * 
 * @author WangLiang
 *
 */
@SuppressWarnings("serial")
public class IGWIM0201Form extends BaseForm{
	
	protected Integer wiid;

	/** 工作定义表主键 */
	protected Integer wdid;
	
	/** 工作项名称 */
	protected String wdname;

	/** 工作实例名称 */
	protected String winame;

	/** 工作状态（0，未执行；1，执行中，2，已执行；3，结束；4，中止；） */
	protected String wistatus;
	
	/** 发起人（userid） */
	protected String initiatorId;

	/** 周期/频率 */
	protected String cycle;

	/** 工作项描述 */
	protected String description;

	/** 开始日期 */
	protected String beginDate;

	/** 负责人 */
	protected String leaderId;
	
	/** 负责人名称 */
	protected String leaderName;
	

	/** 发起类型（1，自动发起；2，手动发起） */
	protected String wiLunchType;

	/** 执行情况描述 */
	protected String wiDescription;

	/** 工作确认日期 */
	protected String confirmDate;

	/** 时间戳 */
	protected String fingerPrint;

	/** 执行人 */
	protected String excutorId;
	
	/** 执行人名称 */
	protected String excutorName;

	/** 日期栏日期 */
	protected String titleDate;

	/** 执行时间 （小时）*/
	protected String excuteTime;

	/** 实际处理日期 */
	protected String actualDealwithDate;

	/** 执行情况描述 */
	protected String wlDescription;

	/** 表记录创建日期 */
	protected String crtDate;
	
	/** 时间戳 */
	protected String fingerprint;

	/** 按钮动作 */
	protected String btnAction;
	
	/**工作时间*/
	protected String workDate ;
	
	/**部门*/
	protected String orgsyscoding ;
	
	/**人员*/
	protected String userid;

	/**开始日期从*/
	protected String begindate_from;
	
	/**开始日期到*/
	protected String begindate_to;
	
	/** 打开页面标识 */
	protected String openFlag;
	
	/**
	 * 取得 打开页面标识
	 * 
	 * @return openFlag 打开页面标识
	 */
	public String getOpenFlag() {
		return openFlag;
	}


	/**
	 * 设定 打开页面标识
	 * 
	 * @param openFlag 打开页面标识
	 */
	public void setOpenFlag(String openFlag) {
		this.openFlag = openFlag;
	}


	/**
	 * @return the 工作时间
	 */
	public String getWorkDate() {
		return workDate;
	}
	

	/**
	 * @param 工作时间 the workDate to set
	 */
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	

	/**
	 * @return the 部门
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}
	

	/**
	 * @param 部门 the orgsyscoding to set
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}
	

	/**
	 * @return the 人员
	 */
	public String getUserid() {
		return userid;
	}
	

	/**
	 * @param 人员 the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	

	
	/**
	 * 取得 工作实例表主键
	 * 
	 * @return wiid
	*/
	public Integer getWiid() {
		return wiid;
	}
	

	/**
	 * 取得 执行人
	 * 
	 * @return excutorId
	*/
	public String getExcutorId() {
		return excutorId;
	}
	

	/**
	 * 取得 执行人名称
	 * 
	 * @return excutorName
	*/
	public String getExcutorName() {
		return excutorName;
	}
	

	/**
	 * 取得 日期栏日期
	 * 
	 * @return titleDate
	*/
	public String getTitleDate() {
		return titleDate;
	}
	

	/**
	 * 取得 执行时间（小时）
	 * 
	 * @return excuteTime
	*/
	public String getExcuteTime() {
		return excuteTime;
	}
	

	/**
	 * 取得 实际处理日期
	 * 
	 * @return actualDealwithDate
	*/
	public String getActualDealwithDate() {
		return actualDealwithDate;
	}
	

	/**
	 * 取得 执行情况描述
	 * 
	 * @return wlDescription
	*/
	public String getWlDescription() {
		return wlDescription;
	}
	

	/**
	 * 取得 表记录创建日期
	 * 
	 * @return crtDate
	*/
	public String getCrtDate() {
		return crtDate;
	}
	

	/**
	 * 取得 时间戳
	 * 
	 * @return fingerprint
	*/
	public String getFingerprint() {
		return fingerprint;
	}
	

	/**
	 * 取得 按钮动作
	 * 
	 * @return btnAction
	*/
	public String getBtnAction() {
		return btnAction;
	}


	/**
	 *  工作实例表主键设定
	 * 
	 * @param wiid
	 */
	public void setWiid(Integer wiid) {
		this.wiid = wiid;
	}
	


	/**
	 *  执行人设定
	 * 
	 * @param excutorId
	 */
	public void setExcutorId(String excutorId) {
		this.excutorId = excutorId;
	}
	


	/**
	 *  执行人名称设定
	 * 
	 * @param excutorName
	 */
	public void setExcutorName(String excutorName) {
		this.excutorName = excutorName;
	}
	


	/**
	 *  日期栏日期设定
	 * 
	 * @param titleDate
	 */
	public void setTitleDate(String titleDate) {
		this.titleDate = titleDate;
	}
	


	/**
	 *  执行时间（小时）设定
	 * 
	 * @param excuteTime
	 */
	public void setExcuteTime(String excuteTime) {
		this.excuteTime = excuteTime;
	}
	


	/**
	 *  实际处理日期设定
	 * 
	 * @param actualDealwithDate
	 */
	public void setActualDealwithDate(String actualDealwithDate) {
		this.actualDealwithDate = actualDealwithDate;
	}
	


	/**
	 *  执行情况描述设定
	 * 
	 * @param wlDescription
	 */
	public void setWlDescription(String wlDescription) {
		this.wlDescription = wlDescription;
	}
	


	/**
	 *  表记录创建日期设定
	 * 
	 * @param crtDate
	 */
	public void setCrtDate(String crtDate) {
		this.crtDate = crtDate;
	}
	


	/**
	 *  时间戳设定
	 * 
	 * @param fingerprint
	 */
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
	


	/**
	 *  按钮动作设定
	 * 
	 * @param btnAction
	 */
	public void setBtnAction(String btnAction) {
		this.btnAction = btnAction;
	}
	/**
	 * 取得 主键
	 * 
	 * @return wiid
	*/
	public Integer getPK() {
		return wiid;
	}

	

	/**
	 * 取得 工作定义表主键
	 * 
	 * @return wdid
	*/
	public Integer getWdid() {
		return wdid;
	}
	

	/**
	 * 取得 工作项名称
	 * 
	 * @return wdname
	*/
	public String getWdname() {
		return wdname;
	}
	

	/**
	 * 取得 工作实例名称
	 * 
	 * @return winame
	*/
	public String getWiname() {
		return winame;
	}
	

	/**
	 * 取得 工作状态（0，未执行；1，执行中，2，已执行；3，结束；4，中止；）
	 * 
	 * @return wistatus
	*/
	public String getWistatus() {
		return wistatus;
	}
	

	/**
	 * 取得 发起人（userid）
	 * 
	 * @return initiatorId
	*/
	public String getInitiatorId() {
		return initiatorId;
	}
	

	/**
	 * 取得 周期频率
	 * 
	 * @return cycle
	*/
	public String getCycle() {
		return cycle;
	}
	

	/**
	 * 取得 工作项描述
	 * 
	 * @return description
	*/
	public String getDescription() {
		return description;
	}
	

	/**
	 * 取得 开始日期
	 * 
	 * @return beginDate
	*/
	public String getBeginDate() {
		return beginDate;
	}
	

	/**
	 * 取得 负责人
	 * 
	 * @return leaderId
	*/
	public String getLeaderId() {
		return leaderId;
	}
	

	/**
	 * 取得 负责人名称
	 * 
	 * @return leaderName
	*/
	public String getLeaderName() {
		return leaderName;
	}
	

	/**
	 * 取得 发起类型（1，自动发起；2，手动发起）
	 * 
	 * @return wiLunchType
	*/
	public String getWiLunchType() {
		return wiLunchType;
	}
	

	/**
	 * 取得 执行情况描述
	 * 
	 * @return wiDescription
	*/
	public String getWiDescription() {
		return wiDescription;
	}
	

	/**
	 * 取得 工作确认日期
	 * 
	 * @return confirmDate
	*/
	public String getConfirmDate() {
		return confirmDate;
	}

	/**
	 * 取得 时间戳
	 * 
	 * @return fingerPrint
	*/
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 *  工作定义表主键设定
	 * 
	 * @param wdid
	 */
	public void setWdid(Integer wdid) {
		this.wdid = wdid;
	}
	

	/**
	 *  工作项名称设定
	 * 
	 * @param wdname
	 */
	public void setWdname(String wdname) {
		this.wdname = wdname;
	}
	

	/**
	 *  工作实例名称设定
	 * 
	 * @param winame
	 */
	public void setWiname(String winame) {
		this.winame = winame;
	}
	

	/**
	 *  工作状态（0，未执行；1，执行中，2，已执行；3，结束；4，中止；）设定
	 * 
	 * @param wistatus
	 */
	public void setWistatus(String wistatus) {
		this.wistatus = wistatus;
	}
	

	/**
	 *  发起人（userid）设定
	 * 
	 * @param initiatorId
	 */
	public void setInitiatorId(String initiatorId) {
		this.initiatorId = initiatorId;
	}
	

	/**
	 *  周期频率设定
	 * 
	 * @param cycle
	 */
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	

	/**
	 *  工作项描述设定
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	

	/**
	 *  开始日期设定
	 * 
	 * @param beginDate
	 */
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	

	/**
	 *  负责人设定
	 * 
	 * @param leaderId
	 */
	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}
	

	/**
	 *  负责人名称设定
	 * 
	 * @param leaderName
	 */
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	

	/**
	 *  发起类型（1，自动发起；2，手动发起）设定
	 * 
	 * @param wiLunchType
	 */
	public void setWiLunchType(String wiLunchType) {
		this.wiLunchType = wiLunchType;
	}
	

	/**
	 *  执行情况描述设定
	 * 
	 * @param wiDescription
	 */
	public void setWiDescription(String wiDescription) {
		this.wiDescription = wiDescription;
	}
	

	/**
	 *  工作确认日期设定
	 * 
	 * @param confirmDate
	 */
	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}
	
	

	/**
	 *  时间戳设定
	 * 
	 * @param fingerPrint
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public String getBegindate_from() {
		return begindate_from;
	}

	public void setBegindate_from(String begindate_from) {
		this.begindate_from = begindate_from;
	}

	public String getBegindate_to() {
		return begindate_to;
	}

	public void setBegindate_to(String begindate_to) {
		this.begindate_to = begindate_to;
	}
	
}

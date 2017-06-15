/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.aut.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_工作管理_查询Form
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGAUT0104Form extends BaseForm{
	
	/**工作编号*/
	protected Integer prid;
	
	/**工作名称*/
	protected String prtitle;
	
	/**工作状态*/
	protected String prstatus;
	
	/**流程类型*/
	protected String prtype;
	
	/**项目编号*/
	protected String pcode;
	
	/**发起者姓名*/
	protected String prusername;
	
	/**开始时间*/
	protected String propentime;
	
	/**结束时间*/
	protected String prclosetime;
	
	/**紧急程度*/
	protected String prurgency;
	
	/**是否工作*/
	protected int isWork;
	
	/** 流程编号 */
	protected String prserialnum;
	
	/** 平台保留 */
	protected String prActive;
	
	/** 流程定义主键 */
	protected String prpdid;
	
	/** 流程记录计划执行时间 */
	protected String prplantime_like;
	
	/** 流程类型数组 */
	protected String[] prTypeArray;
	
	/** 流程状态数组 */
	protected String[] prStatusArray;
	
	/** 平台保留 */
	protected String userid_q;
	
	/** 删除的变更记录ID*/
	protected Integer delprid;
	
	/** 管理标识 */
	protected String isAdmin;
	
	/**内容*/
	protected String prdesc;
	
	/**排序标识*/
	protected String order;
	
	/** 排序字段 */
	protected String sing;
	
	protected String selectstatus;
	/**
	 * 流程类型数组
	 */
	protected String[] prtypes;
	
	/** 
	 * 个人工作的当前用户是否存在流程审批角色 
	 * 存在:1
	 */
	protected String approveflag;
	
	/** 菜单ID */
	protected String actname;
	
	/** 是否定制查询页面 0不是 */
	protected String custom;
	
	/** 表单名集合 */
	protected String[] varnames;
	
	/** 表单值集合 */
	protected String[] varvalues;
	
	/** 表单显示值集合 */
	protected String[] varvalue;
	
	/** 机构码 */
	protected String prorgid_like;
	
	/** 查询类型标识 */
	protected String type ;

	/**
	 * 工作编号取得
	 * @return prid 工作编号
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 工作编号设定
	 * @param prid 工作编号
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 工作名称取得
	 * @return prtitle 工作名称
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * 工作名称设定
	 * @param prtitle 工作名称
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * 工作状态取得
	 * @return prstatus 工作状态
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 工作状态设定
	 * @param prstatus 工作状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * 流程类型取得
	 * @return prtype 流程类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 流程类型设定
	 * @param prtype 流程类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 项目编号取得
	 * @return pcode 项目编号
	 */
	public String getPcode() {
		return pcode;
	}

	/**
	 * 项目编号设定
	 * @param pcode 项目编号
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	/**
	 * 发起者姓名取得
	 * @return prusername 发起者姓名
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * 发起者姓名设定
	 * @param prusername 发起者姓名
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * 开始时间取得
	 * @return propentime 开始时间
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * 开始时间设定
	 * @param propentime 开始时间
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * 结束时间取得
	 * @return prclosetime 结束时间
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * 结束时间设定
	 * @param prclosetime 结束时间
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * 紧急程度取得
	 * @return prurgency 紧急程度
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * 紧急程度设定
	 * @param prurgency 紧急程度
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	/**
	 * 是否工作取得
	 * @return isWork 是否工作
	 */
	public int getIsWork() {
		return isWork;
	}

	/**
	 * 是否工作设定
	 * @param isWork 是否工作
	 */
	public void setIsWork(int isWork) {
		this.isWork = isWork;
	}

	/**
	 * 流程编号取得
	 * @return prserialnum 流程编号
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * 流程编号设定
	 * @param prserialnum 流程编号
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	/**
	 * 平台保留取得
	 * @return prActive 平台保留
	 */
	public String getPrActive() {
		return prActive;
	}

	/**
	 * 平台保留设定
	 * @param prActive 平台保留
	 */
	public void setPrActive(String prActive) {
		this.prActive = prActive;
	}

	/**
	 * 流程定义主键取得
	 * @return prpdid 流程定义主键
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * 流程定义主键设定
	 * @param prpdid 流程定义主键
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * 流程记录计划执行时间取得
	 * @return prplantime_like 流程记录计划执行时间
	 */
	public String getPrplantime_like() {
		return prplantime_like;
	}

	/**
	 * 流程记录计划执行时间设定
	 * @param prplantime_like 流程记录计划执行时间
	 */
	public void setPrplantime_like(String prplantime_like) {
		this.prplantime_like = prplantime_like;
	}

	/**
	 * 流程类型数组取得
	 * @return prTypeArray 流程类型数组
	 */
	public String[] getPrTypeArray() {
		return prTypeArray;
	}

	/**
	 * 流程类型数组设定
	 * @param prTypeArray 流程类型数组
	 */
	public void setPrTypeArray(String[] prTypeArray) {
		this.prTypeArray = prTypeArray;
	}

	/**
	 * 流程状态数组取得
	 * @return prStatusArray 流程状态数组
	 */
	public String[] getPrStatusArray() {
		return prStatusArray;
	}

	/**
	 * 流程状态数组设定
	 * @param prStatusArray 流程状态数组
	 */
	public void setPrStatusArray(String[] prStatusArray) {
		this.prStatusArray = prStatusArray;
	}

	/**
	 * 平台保留取得
	 * @return userid_q 平台保留
	 */
	public String getUserid_q() {
		return userid_q;
	}

	/**
	 * 平台保留设定
	 * @param userid_q 平台保留
	 */
	public void setUserid_q(String userid_q) {
		this.userid_q = userid_q;
	}

	/**
	 * 删除的变更记录ID取得
	 * @return delprid 删除的变更记录ID
	 */
	public Integer getDelprid() {
		return delprid;
	}

	/**
	 * 删除的变更记录ID设定
	 * @param delprid 删除的变更记录ID
	 */
	public void setDelprid(Integer delprid) {
		this.delprid = delprid;
	}

	/**
	 * 管理标识取得
	 * @return isAdmin 管理标识
	 */
	public String getIsAdmin() {
		return isAdmin;
	}

	/**
	 * 管理标识设定
	 * @param isAdmin 管理标识
	 */
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * 内容取得
	 * @return prdesc 内容
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * 内容设定
	 * @param prdesc 内容
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	/**
	 * 排序标识取得
	 * @return order 排序标识
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * 排序标识设定
	 * @param order 排序标识
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * 排序字段取得
	 * @return sing 排序字段
	 */
	public String getSing() {
		return sing;
	}

	/**
	 * 排序字段设定
	 * @param sing 排序字段
	 */
	public void setSing(String sing) {
		this.sing = sing;
	}

	/**
	 * selectstatus取得
	 * @return selectstatus selectstatus
	 */
	public String getSelectstatus() {
		return selectstatus;
	}

	/**
	 * selectstatus设定
	 * @param selectstatus selectstatus
	 */
	public void setSelectstatus(String selectstatus) {
		this.selectstatus = selectstatus;
	}

	/**
	 * 流程类型数组取得
	 * @return prtypes 流程类型数组
	 */
	public String[] getPrtypes() {
		return prtypes;
	}

	/**
	 * 流程类型数组设定
	 * @param prtypes 流程类型数组
	 */
	public void setPrtypes(String[] prtypes) {
		this.prtypes = prtypes;
	}

	/**
	 * 个人工作的当前用户是否存在流程审批角色存在:1取得
	 * @return approveflag 个人工作的当前用户是否存在流程审批角色存在:1
	 */
	public String getApproveflag() {
		return approveflag;
	}

	/**
	 * 个人工作的当前用户是否存在流程审批角色存在:1设定
	 * @param approveflag 个人工作的当前用户是否存在流程审批角色存在:1
	 */
	public void setApproveflag(String approveflag) {
		this.approveflag = approveflag;
	}

	/**
	 * 菜单ID取得
	 * @return actname 菜单ID
	 */
	public String getActname() {
		return actname;
	}

	/**
	 * 菜单ID设定
	 * @param actname 菜单ID
	 */
	public void setActname(String actname) {
		this.actname = actname;
	}

	/**
	 * 是否定制查询页面0不是取得
	 * @return custom 是否定制查询页面0不是
	 */
	public String getCustom() {
		return custom;
	}

	/**
	 * 是否定制查询页面0不是设定
	 * @param custom 是否定制查询页面0不是
	 */
	public void setCustom(String custom) {
		this.custom = custom;
	}

	/**
	 * 表单名集合取得
	 * @return varnames 表单名集合
	 */
	public String[] getVarnames() {
		return varnames;
	}

	/**
	 * 表单名集合设定
	 * @param varnames 表单名集合
	 */
	public void setVarnames(String[] varnames) {
		this.varnames = varnames;
	}

	/**
	 * 表单值集合取得
	 * @return varvalues 表单值集合
	 */
	public String[] getVarvalues() {
		return varvalues;
	}

	/**
	 * 表单值集合设定
	 * @param varvalues 表单值集合
	 */
	public void setVarvalues(String[] varvalues) {
		this.varvalues = varvalues;
	}

	/**
	 * 表单显示值集合取得
	 * @return varvalue 表单显示值集合
	 */
	public String[] getVarvalue() {
		return varvalue;
	}

	/**
	 * 表单显示值集合设定
	 * @param varvalue 表单显示值集合
	 */
	public void setVarvalue(String[] varvalue) {
		this.varvalue = varvalue;
	}

	/**
	 * 机构码取得
	 * @return prorgid_like 机构码
	 */
	public String getProrgid_like() {
		return prorgid_like;
	}

	/**
	 * 机构码设定
	 * @param prorgid_like 机构码
	 */
	public void setProrgid_like(String prorgid_like) {
		this.prorgid_like = prorgid_like;
	}

	/**
	 * 查询类型标识取得
	 * @return type 查询类型标识
	 */
	public String getType() {
		return type;
	}

	/**
	 * 查询类型标识设定
	 * @param type 查询类型标识
	 */
	public void setType(String type) {
		this.type = type;
	}
}

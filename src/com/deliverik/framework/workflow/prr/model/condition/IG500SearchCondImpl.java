/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.condition;

import java.util.List;

/**
 * <p>概述:流程记录信息检索条件实现</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
public class IG500SearchCondImpl implements IG500SearchCond {

	/**
	 * 流程记录题目
	 */
	protected String prtitle;
	
	/**
	 * 流程记录类型
	 */
	protected String prtype;
	
	/**
	 * 流程记录状态
	 */
	protected String prstatus;
	
	/** 处理人处理状态*/
	protected String ppstatus;
	
	/**
	 * 流程记录ID
	 */
	protected Integer prid;
	
	/**
	 * 流程记录流程类型ID
	 */
	protected String prpdid;
	
	/**
	 * 一组流程记录流程类型ID模糊查询
	 */
	protected String[] prpdid_like_or;
	
	/**
	 * 流程记录相关项目编号
	 */
	protected String pcode;
	
	/**
	 * 流程记录发起者用户姓名
	 */
	protected String prusername;
	
	/**
	 * 流程记录紧急程度
	 */
	protected String prurgency;
	
	/**
	 * 流程记录影响程度
	 */
	protected String primpact;
	
	/**
	 * 流程记录优先级
	 */
	protected String prpriority;
	
	/**
	 * 流程记录建立时间（大等于）
	 */
	protected String propentime;
	
	/**
	 * 流程记录建立时间（小等于）
	 */
	protected String prclosetime;
	
	/**
	 * 流程记录关闭时间（like）
	 */
	protected String prclosetime_like;
	
	/**
	 * 流程记录相关资产ID
	 */
	protected Integer prassetid;
	
	/**
	 * 流程记录相关资产类型
	 */
	protected String prassetcategory;
	
	/**
	 * 流程记录工单号
	 */
	protected String prserialnum;
	
	/**
	 * 流程记录状态子状态
	 */
	protected String prsubstatus;
	
	/**
	 * 流程记录发起者用户ID
	 */
	protected String pruserid;
	
	/**
	 * 流程记录发起者角色ID
	 */
	protected Integer prroleid;
	
	/**
	 * 流程记录计划执行时间
	 */
	protected String prplantime;
	
	/**
	 * 流程记录计划执行时间
	 */
	protected String prplantime_like;
	
	/**
	 * 流程记录计划执行周期
	 */
	protected String prduration;
	
	/**
	 * 流程类型数组
	 */
	protected String[] prTypeArray;
	
	/**
	 * 流程状态数组
	 */
	protected String[] prStatusArray;
	
	/**
	 * 平台保留
	 */
	protected String prActive;
	
	/**
	 * 平台保留
	 */
	protected String selectMode;
	
	/**
	 * 平台保留
	 */
	protected int isWork;
	
	/**
	 * 平台保留
	 */
	public List<Integer> pridNotInList;
	
	/**
	 * 平台保留
	 */
	public List<String> prserialnumNotInList;
	
	/**
	 * 平台保留
	 */
	protected String userid_q;
	
	/**内容*/
	protected String prdesc;
	
	/**排序标识*/
	protected String order;
	
	protected String sing;
	
	/**内外需流程标识*/
	protected String lctype;
	
	/**是否为告警事件1为是0为否获取*/
	protected String alarm_Is;
	
	/** 事是否已经确认1为否0为是*/
	protected String ppbacktime_isNull;
	
	/** 处置类型(演练/应急) */
	protected String dwpType;

	/**
	 * 流程类型数组
	 */
	protected String[] prtypes;
	
	/** 
	 * 个人工作的当前用户是否存在流程审批角色 
	 * 存在:1
	 */
	protected String approveflag;
	
	/** 表单名集合 */
	protected String[] varnames;
	
	/** 表单值集合 */
	protected String[] varvalues;
	
	/** 条件标识 */
	protected String[] varmodes;
	
	/** 流程参与人（like）*/
	protected String ppusername_like;
	
	/** 流程参与人ID */
	protected String ppuserid;
		/** 流程参与人ID（like）*/
	/** 流程类型指定状态数组(数据格式：prpdid_ppstatus) */
	protected String[] prpdidAndPpstatus_or;
	
	/** 流程参与人所属流程状态*/
	protected String ppstatus_eq;
	
	/** 流程参与人处理时间是否为空标识 */
	protected String ppproctime_status_active;
	
	/** 流程参与人ID(和状态联动)*/
	protected String ppuserid_status_eq;
	
	/** 流程参与人角色类型(和状态联动)*/
	protected String roletype_status_eq;
	
	/** 流程参与人所属角色数组(和状态联动)*/
	protected String[] pproleid_status_in;
	
	protected String ppuserid_like;

	/** 发起人机构码 */
	protected String prorgid_like;
	
	/**  流程记录工单号like数组 */
    protected String prserialnum_likeArr[];
    
    /** 流程状态不等于 */
    protected String prstatus_ne;

    /** 流程记录建立时间（like）*/
	protected String propentime_like;
	
	/** 发起人机构码 */
	protected String prorgid_in;
    
	/** 问题来源 */
    protected String prassetname;
    
	/**流程id范围*/
	protected String prid_in;
	
	/** 关联菜单 */
	protected String pdactname;
    
	/** 变更结果的标示 (Y代表成功) */
	protected String pivarlabel;
	
	/** 发起角色ID集合 */
	protected List<Integer> prroleid_in;
	
	/** 发起角色ID集合 */
	
	/**事件分类*/
	protected String pivarValue;
	
	/**服务分类分类*/
	protected String pppivarValue;
	
	/**检查工作类别*/
	protected String csrtestmode;
	
	/**是否为领导*/
	public String leaderFlag;
	
	/**机构id*/
	public String orgID;
	
	
	/**
	 * 流程组ID
	 */
	protected Integer pid;
	
	protected String flag;
	protected List<Integer> prroleid_not_in;
	
	/** 搜索关键字 */
	protected String content;
	
	/** 表单名集合 */
	protected String[] varnames_in;
	
	/** 表单值集合 */
	protected String[] varvalues_in;

	/**
	 * 流程名
	 */
	protected String prpdname;

	/**
	 * 平台保留
	 */
	public String getUserid_q() {
		return userid_q;
	}

	/**
	 * 平台保留
	 */
	public void setUserid_q(String userid_q) {
		this.userid_q = userid_q;
	}

	public String getSing() {
		return sing;
	}

	public void setSing(String sing) {
		this.sing = sing;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * 功能：流程记录题目取得
	 * @return  流程记录题目
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * 功能：流程记录题目设定
	 * @param prtitle 流程记录题目
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * 功能：流程记录类型取得
	 * @return  流程记录类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 功能：流程记录类型设定
	 * @param prtype 流程记录类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 功能：流程记录状态取得
	 * @return 流程记录状态
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 功能：流程记录状态设定
	 * @param prstatus 流程记录状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	
	/**处理人处理状态获取
	 * @return the ppstatus
	 */
	public String getPpstatus() {
		return ppstatus;
	}

	/**处理人处理状态设定
	 * @param ppstatus the ppstatus to set
	 */
	public void setPpstatus(String ppstatus) {
		this.ppstatus = ppstatus;
	}

	/**
	 * 功能：流程记录ID取得
	 * @return 流程记录ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 功能：流程记录ID设定
	 * @param prid 流程记录ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 功能：流程记录相关项目编号取得
	 * @return 流程记录相关项目编号
	 */
	public String getPcode() {
		return pcode;
	}

	/**
	 * 功能：流程记录相关项目编号设定
	 * @param pcode 流程记录相关项目编号
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	/**
	 * 功能：流程记录发起者用户姓名取得
	 * @return 流程记录发起者用户姓名
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * 功能：流程记录发起者用户姓名设定
	 * @param prusername 流程记录发起者用户姓名
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * 功能：流程记录紧急程度取得
	 * @return 流程记录紧急程度
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * 功能：流程记录紧急程度设定
	 * @param prurgency 流程记录紧急程度
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	/**
	 * 功能：流程记录建立时间（大等于）取得
	 * @return 流程记录建立时间（大等于）
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * 功能：流程记录建立时间（大等于）设定
	 * @param propentime 流程记录建立时间（大等于）
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * 功能：流程记录建立时间（小等于）取得
	 * @return 流程记录建立时间（小等于）
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * 功能：流程记录建立时间（小等于）设定
	 * @param prclosetime 流程记录建立时间（小等于）
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * 功能：流程记录流程类型ID取得
	 * @return 流程记录流程类型ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * 功能：流程记录流程类型ID设定
	 * @param prpdid 流程记录流程类型ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * 一组流程记录流程类型ID模糊查询取得
	 *
	 * @return prpdid_like_or 一组流程记录流程类型ID模糊查询
	 */
	public String[] getPrpdid_like_or() {
		return prpdid_like_or;
	}

	/**
	 * 一组流程记录流程类型ID模糊查询设定
	 *
	 * @param prpdid_like_or 一组流程记录流程类型ID模糊查询
	 */
	public void setPrpdid_like_or(String[] prpdid_like_or) {
		this.prpdid_like_or = prpdid_like_or;
	}

	/**
	 * 功能：流程记录发起者用户ID取得
	 * @return 流程记录发起者用户ID
	 */
	public String getPruserid() {
		return pruserid;
	}

	/**
	 * 功能：流程记录发起者用户ID设定
	 * @param pruserid 流程记录发起者用户ID
	 */
	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}

	/**
	 * 功能：流程记录发起者角色ID取得
	 * @return 流程记录发起者角色ID
	 */
	public Integer getPrroleid() {
		return prroleid;
	}

	/**
	 * 功能：流程记录发起者角色ID设定
	 * @param prroleid 流程记录发起者角色ID
	 */
	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}

	/**
	 * 功能：流程记录计划执行时间取得
	 * @return 流程记录计划执行时间
	 */
	public String getPrplantime() {
		return prplantime;
	}
	
	/**
	 * 功能：流程记录计划执行时间设定
	 * @param prplantime 流程记录计划执行时间
	 */
	public void setPrplantime(String prplantime) {
		this.prplantime = prplantime;
	}
	
	/**
	 * 功能：流程记录计划执行时间取得
	 * @return 流程记录计划执行时间
	 */
	public String getPrplantime_like() {
		return prplantime_like;
	}

	/**
	 * 功能：流程记录计划执行时间设定
	 * @param prplantime_like 流程记录计划执行时间
	 */
	public void setPrplantime_like(String prplantime_like) {
		this.prplantime_like = prplantime_like;
	}

	/**
	 * 功能：流程记录计划执行周期取得
	 * @return 流程记录计划执行周期
	 */
	public String getPrduration() {
		return prduration;
	}

	/**
	 * 功能：流程记录计划执行周期设定
	 * @param prduration 流程记录计划执行周期
	 */
	public void setPrduration(String prduration) {
		this.prduration = prduration;
	}

	
	/**
	 * 功能：流程记录相关资产ID取得
	 * @return 流程记录相关资产ID
	 */
	public Integer getPrassetid() {
		return prassetid;
	}

	/**
	 * 功能：流程记录相关资产ID设定
	 * @param prassetid 流程记录相关资产ID
	 */
	public void setPrassetid(Integer prassetid) {
		this.prassetid = prassetid;
	}

	/**
	 * 功能：流程记录相关资产类型取得
	 * @return 流程记录相关资产类型
	 */
	public String getPrassetcategory() {
		return prassetcategory;
	}

	/**
	 * 功能：流程记录相关资产类型设定
	 * @param prassetcategory 流程记录相关资产类型
	 */
	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}

	/**
	 * 功能：流程记录工单号取得
	 * @return 流程记录工单号
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * 功能：流程记录工单号设定
	 * @param prserialnum 流程记录工单号
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	/**
	 * 功能：流程记录状态子状态取得
	 * @return 流程记录状态子状态
	 */
	public String getPrsubstatus() {
		return prsubstatus;
	}

	/**
	 * 功能：流程记录状态子状态设定
	 * @param prsubstatus 流程记录状态子状态
	 */
	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}

	
	/**
	 * 平台保留
	 * @return 
	 */
	public int getIsWork() {
		return isWork;
	}

	/**
	 * 平台保留
	 * @param isWork 
	 */
	public void setIsWork(int isWork) {
		this.isWork = isWork;
	}

	/**
	 * 平台保留
	 * @return 
	 */
	public String getSelectMode() {
		return selectMode;
	}

	/**
	 * 平台保留
	 * @param selectMode 
	 */
	public void setSelectMode(String selectMode) {
		this.selectMode = selectMode;
	}
	
	/**
	 * 平台保留
	 * @return 
	 */
	public List<Integer> getPridNotInList() {
		return pridNotInList;
	}

	/**
	 * 平台保留
	 * @param pridNotInList 
	 */
	public void setPridNotInList(List<Integer> pridNotInList) {
		this.pridNotInList = pridNotInList;
	}

	/**
	 * 平台保留
	 * @return 
	 */
	public List<String> getPrserialnumNotInList() {
		return prserialnumNotInList;
	}

	/**
	 * 平台保留
	 * @param prserialnumNotInList 
	 */
	public void setPrserialnumNotInList(List<String> prserialnumNotInList) {
		this.prserialnumNotInList = prserialnumNotInList;
	}

	/**
	 * 平台保留
	 * @return 
	 */
	public String getPrActive() {
		return prActive;
	}

	/**
	 * 平台保留
	 * @param prActive 
	 */
	public void setPrActive(String prActive) {
		this.prActive = prActive;
	}

	public String getPrdesc() {
		return prdesc;
	}

	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	public String[] getPrtypes() {
		return prtypes;
	}

	public void setPrtypes(String[] prtypes) {
		this.prtypes = prtypes;
	}


	/**
	 * 功能：流程记录多种流程类型数组取得
	 * @return 流程记录流程类型数组
	 */
	public String[] getPrTypeArray() {
		return prTypeArray;
	}

	/**
	 * 功能：流程记录多种流程类型数组设置
	 * @param prTypeArray
	 */
	public void setPrTypeArray(String[] prTypeArray) {
		this.prTypeArray = prTypeArray;
	}

	public String[] getPrStatusArray() {
		return prStatusArray;
	}

	public void setPrStatusArray(String[] prStatusArray) {
		this.prStatusArray = prStatusArray;
	}

	public String getPrimpact() {
		return primpact;
	}

	public void setPrimpact(String primpact) {
		this.primpact = primpact;
	}

	public String getPrpriority() {
		return prpriority;
	}

	public void setPrpriority(String prpriority) {
		this.prpriority = prpriority;
	}

	/**
	 * 流程审批角色标识获取
	 * @return 流程审批角色标识
	 */
	public String getApproveflag() {
		return approveflag;
	}

	/**
	 * 流程审批角色标识设定
	 * @param approveflag 流程审批角色标识
	 */
	public void setApproveflag(String approveflag) {
		this.approveflag = approveflag;
	}
	
	/**
	 * 表单名集合取得
	 * @return 表单名集合
	 */
	public String[] getVarnames() {
		return varnames;
	}

	/**
	 * 表单名集合设定
	 * @return 表单名集合
	 */
	public String[] getVarvalues() {
		return varvalues;
	}

	/**
	 * 流程参与人（like）取得
	 *
	 * @return ppusername_like 流程参与人（like）
	 */
	public String getPpusername_like() {
		return ppusername_like;
	}

	/**
	 * 流程参与人（like）设定
	 *
	 * @param ppusername_like 流程参与人（like）
	 */
	public void setPpusername_like(String ppusername_like) {
		this.ppusername_like = ppusername_like;
	}

	/**
	 * 流程参与人ID取得
	 * @return ppuserid 流程参与人ID
	 */
	public String getPpuserid() {
		return ppuserid;
	}

	/**
	 * 流程参与人ID设定
	 * @param ppuserid 流程参与人ID
	 */
	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}

	/**
	 * 表单值集合取得
	 * @param varnames 表单值集合
	 */
	public void setVarnames(String[] varnames) {
		this.varnames = varnames;
	}

	/**
	 * 表单值集合设定
	 * @param varvalues 表单值集合
	 */
	public void setVarvalues(String[] varvalues) {
		this.varvalues = varvalues;
	}

	/**
	 * 发起人机构码取得
	 * @return 发起人机构码
	 */
	public String getProrgid_like() {
		return prorgid_like;
	}

	/**
	 * 发起人机构码设定
	 * @param prorgid_like 发起人机构码
	 */
	public void setProrgid_like(String prorgid_like) {
		this.prorgid_like = prorgid_like;
	}

	/**
	 * 流程类型指定状态数组(数据格式：prpdid_ppstatus)取得
	 * @return 流程类型指定状态数组(数据格式：prpdid_ppstatus)
	 */
	public String[] getPrpdidAndPpstatus_or() {
		return prpdidAndPpstatus_or;
	}

	/**
	 * 流程类型指定状态数组(数据格式：prpdid_ppstatus)设定
	 * @param prpdidAndPpstatus_or 流程类型指定状态数组(数据格式：prpdid_ppstatus)
	 */
	public void setPrpdidAndPpstatus_or(String[] prpdidAndPpstatus_or) {
		this.prpdidAndPpstatus_or = prpdidAndPpstatus_or;
	}

	/**
	 * 流程参与人所属流程状态取得
	 * @return 流程参与人所属流程状态
	 */
    public String getPpstatus_eq() {
		return ppstatus_eq;
	}
    
    /**
     * 流程参与人所属流程状态设定
     * @param ppstatus_eq 流程参与人所属流程状态
     */
	public void setPpstatus_eq(String ppstatus_eq) {
		this.ppstatus_eq = ppstatus_eq;
	}

	/**
	 * 流程参与人处理时间是否为空标识取得
	 * @return 流程参与人处理时间是否为空标识
	 */
	public String getPpproctime_status_active() {
		return ppproctime_status_active;
	}

	/**
	 * 流程参与人处理时间是否为空标识设定
	 * @param ppproctime_status_active 流程参与人处理时间是否为空标识
	 */
	public void setPpproctime_status_active(String ppproctime_status_active) {
		this.ppproctime_status_active = ppproctime_status_active;
	}

	/**
	 * 流程参与人ID(和状态联动)取得
	 * @return 流程参与人ID(和状态联动)
	 */
	public String getPpuserid_status_eq() {
		return ppuserid_status_eq;
	}

	/**
	 * 流程参与人ID(和状态联动)设定
	 * @param ppuserid_status_eq 流程参与人ID(和状态联动)
	 */
	public void setPpuserid_status_eq(String ppuserid_status_eq) {
		this.ppuserid_status_eq = ppuserid_status_eq;
	}

	/**
	 * 流程参与人角色类型(和状态联动)取得
	 * @return 流程参与人角色类型(和状态联动)
	 */
	public String getRoletype_status_eq() {
		return roletype_status_eq;
	}

	/**
	 * 流程参与人角色类型(和状态联动)设定
	 * @param roletype_status_eq 流程参与人角色类型(和状态联动)
	 */
	public void setRoletype_status_eq(String roletype_status_eq) {
		this.roletype_status_eq = roletype_status_eq;
	}

	/**
	 * 流程参与人所属角色数组(和状态联动)取得
	 * @return 流程参与人所属角色数组(和状态联动)
	 */
	public String[] getPproleid_status_in() {
		return pproleid_status_in;
	}

	/**
	 * 流程参与人所属角色数组(和状态联动)设定
	 * @param pproleid_status_in 流程参与人所属角色数组(和状态联动)
	 */
	public void setPproleid_status_in(String[] pproleid_status_in) {
		this.pproleid_status_in = pproleid_status_in;
	}

	/**
     * 流程记录工单号like数组取得
     * @return prserialnum_likeArr 流程记录工单号like数组
     */
    public String[] getPrserialnum_likeArr() {
        return prserialnum_likeArr;
    }
    
    /**
     * 流程记录工单号like数组设定
     * @param prserialnum_likeArr 流程记录工单号like数组
     */
    public void setPrserialnum_likeArr(String[] prserialnum_likeArr) {
        this.prserialnum_likeArr = prserialnum_likeArr;
    }

	/**
	 * 流程状态不等于取得
	 * @return prstatus_ne 流程状态不等于
	 */
	public String getPrstatus_ne() {
		return prstatus_ne;
	}

	/**
	 * 流程状态不等于设定
	 * @param prstatus_ne 流程状态不等于
	 */
	public void setPrstatus_ne(String prstatus_ne) {
		this.prstatus_ne = prstatus_ne;
	}

	/**
	 * 流程记录建立时间（like）取得
	 * @return propentime_like 流程记录建立时间（like）
	 */
	public String getPropentime_like() {
		return propentime_like;
	}

	/**
	 * 流程记录建立时间（like）设定
	 * @param propentime_like 流程记录建立时间（like）
	 */
	public void setPropentime_like(String propentime_like) {
		this.propentime_like = propentime_like;
	}

	
	/**
	 * 流程记录关闭时间(like)取得
	 * @return the prclosetime_like
	 */
	public String getPrclosetime_like() {
		return prclosetime_like;
	}

	/**
	 * 流程记录关闭时间(like)设定
	 * @param prclosetime_like the prclosetime_like to set
	 */
	public void setPrclosetime_like(String prclosetime_like) {
		this.prclosetime_like = prclosetime_like;
	}

	/**
	 * 内外需流程标识取得
	 * @return lctype 内外需流程标识
	 */
	public String getLctype() {
		return lctype;
	}

	/**
	 * 内外需流程标识设定
	 * @param lctype 内外需流程标识
	 */
	public void setLctype(String lctype) {
		this.lctype = lctype;
	}

	/**
	 * 发起人机构码取得
	 * @return prorgid_in 发起人机构码
	 */
	public String getProrgid_in() {
		return prorgid_in;
	}

	/**
	 * 发起人机构码设定
	 * @param prorgid_in
	 */
	public void setProrgid_in(String prorgid_in) {
		this.prorgid_in = prorgid_in;
	}

    /**
     * 问题来源取得
     *
     * @return prassetname 问题来源
     */
    public String getPrassetname() {
        return prassetname;
    }

    /**
     * 问题来源设定
     *
     * @param prassetname 问题来源
     */
    public void setPrassetname(String prassetname) {
        this.prassetname = prassetname;
    }
	
		/**
	 * 获取流程id范围
	 * @return
	 */
	public String getPrid_in() {
		return prid_in;
	}
	/**
	 * 设置流程id范围
	 * @param prid_in
	 */
	public void setPrid_in(String prid_in) {
		this.prid_in = prid_in;
	}

	/**
	 * 关联菜单取得
	 * @return pdactname 关联菜单
	 */
	public String getPdactname() {
		return pdactname;
	}

	/**
	 * 关联菜单设定
	 * @param pdactname 关联菜单
	 */
	public void setPdactname(String pdactname) {
		this.pdactname = pdactname;
	}

	/**
	 * 发起角色ID集合取得
	 * @return prroleid_in 发起角色ID集合
	 */
	public List<Integer> getPrroleid_in() {
		return prroleid_in;
	}

	/**
	 * 发起角色ID集合设定
	 * @param prroleid_in 发起角色ID集合
	 */
	public void setPrroleid_in(List<Integer> prroleid_in) {
		this.prroleid_in = prroleid_in;
	}

	/**
	 * 发起角色ID集合取得
	 * @return prroleid_not_in 发起角色ID集合
	 */
	public List<Integer> getPrroleid_not_in() {
		return prroleid_not_in;
	}

	/**
	 * 发起角色ID集合设定
	 * @param prroleid_not_in 发起角色ID集合
	 */
	public void setPrroleid_not_in(List<Integer> prroleid_not_in) {
		this.prroleid_not_in = prroleid_not_in;
	}

	/**
	 * 搜索关键字取得
	 * @return content 搜索关键字
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 搜索关键字设定
	 * @param content 搜索关键字
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 表单名集合取得
	 * @return the varnames_in
	 */
	public String[] getVarnames_in() {
		return varnames_in;
	}

	/**
	 * 表单名集合设定
	 * @param varnames_in the 表单名集合
	 */
	public void setVarnames_in(String[] varnames_in) {
		this.varnames_in = varnames_in;
	}

	/**
	 * 表单值集合取得
	 * @return the varvalues_in
	 */
	public String[] getVarvalues_in() {
		return varvalues_in;
	}

	/**
	 * 表单值集合设定
	 * @param varvalues_in the 表单值集合
	 */
	public void setVarvalues_in(String[] varvalues_in) {
		this.varvalues_in = varvalues_in;
	}

	/**
	 * 是否为告警事件1为是0为否获取获取
	 * @return the alarm_Is
	 */
	public String getAlarm_Is() {
		return alarm_Is;
	}

	/**
	 * 是否为告警事件1为是0为否获取设定
	 * @param alarm_Is
	 */
	public void setAlarm_Is(String alarm_Is) {
		this.alarm_Is = alarm_Is;
	}

	/**
	 * 事是否已经确认1为否0为是获取
	 * @return the ppbacktime_isNull
	 */
	public String getPpbacktime_isNull() {
		return ppbacktime_isNull;
	}

	/**
	 * 事是否已经确认1为否0为是设定
	 * @param ppbacktime_isNull
	 */
	public void setPpbacktime_isNull(String ppbacktime_isNull) {
		this.ppbacktime_isNull = ppbacktime_isNull;
	}

	/**
	 * @return the varmodes
	 */
	public String[] getVarmodes() {
		return varmodes;
	}

	/**
	 * @param varmodes the varmodes to set
	 */
	public void setVarmodes(String[] varmodes) {
		this.varmodes = varmodes;
	}

	/**
	 * @return the ppuserid_like
	 */
	public String getPpuserid_like() {
		return ppuserid_like;
	}

	/**
	 * @param ppuserid_like the ppuserid_like to set
	 */
	public void setPpuserid_like(String ppuserid_like) {
		this.ppuserid_like = ppuserid_like;
	}

	/**
	 * @return the pivarlabel
	 */
	public String getPivarlabel() {
		return pivarlabel;
	}

	/**
	 * @param pivarlabel the pivarlabel to set
	 */
	public void setPivarlabel(String pivarlabel) {
		this.pivarlabel = pivarlabel;
	}

	/**
	 * @return the pivarValue
	 */
	public String getPivarValue() {
		return pivarValue;
	}

	/**
	 * @param pivarValue the pivarValue to set
	 */
	public void setPivarValue(String pivarValue) {
		this.pivarValue = pivarValue;
	}

	/**
	 * @return the pppivarValue
	 */
	public String getPppivarValue() {
		return pppivarValue;
	}

	/**
	 * @param pppivarValue the pppivarValue to set
	 */
	public void setPppivarValue(String pppivarValue) {
		this.pppivarValue = pppivarValue;
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
	 * @return the leaderFlag
	 */
	public String getLeaderFlag() {
		return leaderFlag;
	}

	/**
	 * @param leaderFlag the leaderFlag to set
	 */
	public void setLeaderFlag(String leaderFlag) {
		this.leaderFlag = leaderFlag;
	}

	/**
	 * @return the orgID
	 */
	public String getOrgID() {
		return orgID;
	}

	/**
	 * @param orgID the orgID to set
	 */
	public void setOrgID(String orgID) {
		this.orgID = orgID;
	}

	/**
	 * @return the pid
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * @param pid the pid to set
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	/** 处置类型(演练/应急) */
	public String getDwpType() {
		return dwpType;
	}

	/** 处置类型(演练/应急) */
	public void setDwpType(String dwpType) {
		this.dwpType = dwpType;
	}

	/** 流程名 */
	public String getPrpdname() {
		return prpdname;
	}

	public void setPrpdname(String prpdname) {
		this.prpdname = prpdname;
	}
}

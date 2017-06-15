/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>概述:流程记录与参与用户信息检索条件实现</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
public class IG677SearchCondImpl implements IG677SearchCond {

	/**
	 * 流程记录题目
	 */
	protected String prtitle;
	
	/**
	 * 流程记录类型
	 */
	protected String prtype;

	/**
	 * 流程模版
	 */
	protected String prpdid;
	
	/**
	 * 流程记录状态
	 */
	protected String prstatus;
	
	/**
	 * 流程参与用户角色ID
	 */
	protected Integer pproleid;
	
	/**
	 * 流程参与用户ID
	 */
	protected String ppuserid;
	
	/**
	 * 流程参与用户指定时间
	 */
	protected String ppinittime;
	
	/**
	 * 流程参与用户处理完成时间
	 */
	protected String ppproctime;
	
	/**
	 * 流程参与用户处理完成开始时间
	 */
	protected String ppproctime_from;
	
	/**
	 * 流程参与用户处理完成结束时间
	 */
	protected String ppproctime_to;
	
	/**
	 * 流程参与用户名字
	 */
	protected String ppusername;
	
	/**
	 * 流程记录ID
	 */
	protected Integer prid;
	
	/**
	 * 流程记录紧急程度
	 */
	protected String prurgency;
	
	/**
	 * 流程记录建立时间
	 */
	protected String propentime;
	
	/**
	 * 流程记录建立时间（小等于）
	 */
	protected String prclosetime;
	
	/**
	 * 流程参与用户的参与状态
	 */
	protected String ppstatus;
	
	/**
	 * 流程记录状态子状态
	 */
	protected String prsubstatus;
	
	/**
	 * 流程记录相关项目编号
	 */
	protected String pcode;
	
	/**
	 * 流程记录计划执行时间
	 */
	protected String prplantime;// 事件发生时间从(柱形图显示条件)
	
	/**
	 * 流程记录计划执行周期
	 */
	protected String prduration;// 事件发生时间至(柱形图显示条件)
	
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
	protected String mode;
	
	/**
	 * 平台保留
	 */
	protected String prActive;
	
	/**
	 * 平台保留
	 */
	protected boolean isTodo;
	
	/**
	 * 平台保留
	 */
	protected boolean isToImplement;
	
	/**
	 * 发文流程状态过滤条件
	 */
	protected String dsstatus;

	/**
	 * 
	 */
	protected String[] prtypes;
	
	
    /**
     * 取得
     *
     * @return prtypes 
     */
    public String[] getPrtypes() {
        return prtypes;
    }

    /**
     * 设定
     *
     * @param prtypes 
     */
    public void setPrtypes(String[] prtypes) {
        this.prtypes = prtypes;
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
	 * 功能：流程参与用户的参与状态取得
	 * @return 流程参与用户的参与状态
	 */
	public String getPpstatus() {
		return ppstatus;
	}

	/**
	 * 功能：流程参与用户的参与状态设定
	 * @param ppstatus 流程参与用户的参与状态
	 */
	public void setPpstatus(String ppstatus) {
		this.ppstatus = ppstatus;
	}

	/**
	 * 功能：流程记录题目取得
	 * @return 流程记录题目
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
	 * @return 流程记录类型
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
	
	/**
	 * 功能：流程参与用户角色ID取得
	 * @return 流程参与用户角色ID
	 */
	public Integer getPproleid() {
		return pproleid;
	}

	/**
	 * 功能：流程参与用户角色ID设定
	 * @param pproleid 流程参与用户角色ID
	 */
	public void setPproleid(Integer pproleid) {
		this.pproleid = pproleid;
	}

	/**
	 * 功能：流程参与用户ID取得
	 * @return 流程参与用户ID
	 */
	public String getPpuserid() {
		return ppuserid;
	}

	/**
	 * 功能：流程参与用户ID设定
	 * @param ppuserid 流程参与用户ID
	 */
	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}

	/**
	 * 功能：流程参与用户指定时间取得
	 * @return 流程参与用户指定时间
	 */
	public String getPpinittime() {
		return ppinittime;
	}

	/**
	 * 功能：流程参与用户指定时间设定
	 * @param ppinittime 流程参与用户指定时间
	 */
	public void setPpinittime(String ppinittime) {
		this.ppinittime = ppinittime;
	}

	/**
	 * 功能：流程参与用户处理完成时间取得
	 * @return 流程参与用户处理完成时间
	 */
	public String getPpproctime() {
		return ppproctime;
	}

	/**
	 * 功能：流程参与用户处理完成时间设定
	 * @param ppproctime 流程参与用户处理完成时间
	 */
	public void setPpproctime(String ppproctime) {
		this.ppproctime = ppproctime;
	}
	
	/**
	 * 功能：流程参与用户处理完成开始时间取得
	 * @return 流程参与用户处理完成开始时间
	 */
	public String getPpproctime_from() {
		return ppproctime_from;
	}

	/**
	 * 功能：流程参与用户处理完成开始时间设定
	 * @param ppproctime_from 流程参与用户处理完成开始时间
	 */
	public void setPpproctime_from(String ppproctime_from) {
		this.ppproctime_from = ppproctime_from;
	}

	/**
	 * 功能：流程参与用户处理完成结束时间取得
	 * @return 流程参与用户处理完成结束时间
	 */
	public String getPpproctime_to() {
		return ppproctime_to;
	}

	/**
	 * 功能：流程参与用户处理完成结束时间设定
	 * @param ppproctime_to 流程参与用户处理完成结束时间
	 */
	public void setPpproctime_to(String ppproctime_to) {
		this.ppproctime_to = ppproctime_to;
	}

	/**
	 * 功能：流程参与用户名字取得
	 * @return 流程参与用户名字
	 */
	public String getPpusername() {
		return ppusername;
	}

	/**
	 * 功能：流程参与用户名字设定
	 * @param ppusername 流程参与用户名字
	 */
	public void setPpusername(String ppusername) {
		this.ppusername = ppusername;
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
	 * 功能：流程记录建立时间取得
	 * @return 流程记录建立时间
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * 功能：流程记录建立时间设定
	 * @param propentime 流程记录建立时间
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
	 * 平台保留
	 * @return 
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 平台保留
	 * @param mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
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
	 * @param mode
	 */
	public void setPrActive(String prActive) {
		this.prActive = prActive;
	}

	/**
	 * 平台保留
	 * @return 
	 */
	public boolean isTodo() {
		return isTodo;
	}

	/**
	 * 平台保留
	 * @param mode
	 */
	public void setTodo(boolean todo) {
		isTodo = todo;
		
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
	 * @param mode
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
	 * @param mode
	 */
	public void setSelectMode(String selectMode) {
		this.selectMode = selectMode;
	}

	/**
	 * 平台保留
	 * @return 
	 */
	public boolean isToImplement() {
		return isToImplement;
	}

	/**
	 * 平台保留
	 * @param mode
	 */
	public void setToImplement(boolean isToImplement) {
		this.isToImplement = isToImplement;
	}

	/**
	 * 功能：发文流程状态过滤条件取得
	 * @return 发文流程状态过滤条件
	 */
	public String getDsstatus() {
		return dsstatus;
	}

	/**
	 * 功能：发文流程状态过滤条件设定
	 * @param dsstatus 发文流程状态过滤条件
	 */
	public void setDsstatus(String dsstatus) {
		this.dsstatus = dsstatus;
	}

    /**
     * 流程模版取得
     *
     * @return prpdid 流程模版
     */
    public String getPrpdid() {
        return prpdid;
    }

    /**
     * 流程模版设定
     *
     * @param prpdid 流程模版
     */
    public void setPrpdid(String prpdid) {
        this.prpdid = prpdid;
    }
	
	/**流程节点状态表示码(完全匹配)*/
	protected String psdid_eq;
	/**
	 * 流程节点状态表示码(完全匹配)取得
	 * @return
	 */
	public String getPsdid_eq() {
		return psdid_eq;
	}
	/**
	 * 流程节点状态表示码(完全匹配)设定
	 * @param psdid_eq
	 */
	public void setPsdid_eq(String psdid_eq) {
		this.psdid_eq = psdid_eq;
	}
	
	/**发起人机构码(完全匹配)*/
	protected String pporgid_eq;
	/**
	 * 发起人机构码(完全匹配)取得
	 * @return
	 */
	public String getPporgid_eq() {
		return pporgid_eq;
	}
	/**
	 * 发起人机构码(完全匹配)设定
	 * @param pporgid_eq
	 */
	public void setPporgid_eq(String pporgid_eq) {
		this.pporgid_eq = pporgid_eq;
	}
}

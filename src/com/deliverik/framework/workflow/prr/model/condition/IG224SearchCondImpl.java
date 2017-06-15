/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * 流程状态日志查询条件实现
 */
public class IG224SearchCondImpl implements IG224SearchCond {

	/** 流程ID */
	protected Integer prid;
	
	/** 是否查询流程当前状态记录标识 */
	protected boolean currentPrstatus;
	
	/** 流程状态 */
	private String prstatus;
	
	/** 流程状态NOT */
	protected String prstatus_ne;

	/** 流程状态定义ID */
	protected String psdid;
	
	/** 上级流程状态定义ID */
	protected String ppsdid;
	
	/** 虚拟节点状态 */
	protected String virtualstatus;

	/** 当前状态 */
	protected String nowstatus;
	
	/** 动态分支编号 */
	protected Integer psdnum;
	
	/** 是否挂起 */
	protected boolean pend;
	
	/**
	 * 流程ID取得
	 * 
	 * @return 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程ID取得
	 * 
	 * @param prid 流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 流程状态取得
	 * 
	 * @return 流程状态
	 */
	public boolean isCurrentPrstatus() {
		return currentPrstatus;
	}

	/**
	 * 是否查询流程当前状态记录标识设定
	 * 
	 * @param currentPrstatus 是否查询流程当前状态记录标识
	 */
	public void setCurrentPrstatus(boolean currentPrstatus) {
		this.currentPrstatus = currentPrstatus;
	}

	/**
	 * 流程状态标识设定
	 * @param prstatus
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * 流程状态获取
	 * @return
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 流程状态NOT取得
	 * @return 流程状态NOT
	 */
	public String getPrstatus_ne() {
		return prstatus_ne;
	}

	/**
	 * 流程状态NOT设定
	 * @param prstatus_ne 流程状态NOT
	 */
	public void setPrstatus_ne(String prstatus_ne) {
		this.prstatus_ne = prstatus_ne;
	}

	/**
	 * 流程状态定义ID取得
	 * @return 流程状态定义ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程状态定义ID设定
	 * @param psdid 流程状态定义ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 上级流程状态定义ID取得
	 * @return 上级流程状态定义ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * 上级流程状态定义ID设定
	 * @param ppsdid 上级流程状态定义ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}

	/**
	 * 虚拟节点状态取得
	 * @return 虚拟节点状态
	 */
	public String getVirtualstatus() {
		return virtualstatus;
	}

	/**
	 * 虚拟节点状态设定
	 * @param virtualstatus 虚拟节点状态
	 */
	public void setVirtualstatus(String virtualstatus) {
		this.virtualstatus = virtualstatus;
	}

	/**
	 * 动态分支编号取得
	 * @return 动态分支编号
	 */
	public Integer getPsdnum() {
		return psdnum;
	}

	/**
	 * 动态分支编号设定
	 * @param psdnum 动态分支编号
	 */
	public void setPsdnum(Integer psdnum) {
		this.psdnum = psdnum;
	}

	/**
	 * 当前状态取得
	 * @return 当前状态
	 */
	public String getNowstatus() {
		return nowstatus;
	}

	/**
	 * 当前状态设定
	 * @param nowstatus 当前状态
	 */
	public void setNowstatus(String nowstatus) {
		this.nowstatus = nowstatus;
	}

	/**
	 * 是否挂起取得
	 * @return 是否挂起
	 */
	public boolean isPend() {
		return pend;
	}

	/**
	 * 是否挂起设定
	 * @param pend 是否挂起
	 */
	public void setPend(boolean pend) {
		this.pend = pend;
	}
	
}

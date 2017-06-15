/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 报表历史填报记录视图查询条件实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ReportHistoryVWSearchCondImpl implements ReportHistoryVWSearchCond{

	/** 组类型 */
	protected String prtype;
	
	/** 流程定义ID */
	protected String pdid;
	
	/** 当前流程ID */
	protected Integer currentPrid;

	/**
	 * 组类型取得
	 * @return prtype 组类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 组类型设定
	 * @param prtype 组类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 流程定义ID取得
	 * @return pdid 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 当前流程ID取得
	 * @return currentPrid 当前流程ID
	 */
	public Integer getCurrentPrid() {
		return currentPrid;
	}

	/**
	 * 当前流程ID设定
	 * @param currentPrid 当前流程ID
	 */
	public void setCurrentPrid(Integer currentPrid) {
		this.currentPrid = currentPrid;
	}
}

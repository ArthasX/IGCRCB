/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 历史数据分组信息form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSMR0501Form extends BaseForm{

	/** 分组标识 */
	protected String prtype;
	
	/** 流程定义ID */
	protected String pdid;
	
	/** 当前流程主键 */
	protected Integer currentPrid;
	
	/** 复制按钮标识 */
	protected String showCopy;

	/**
	 * 分组标识取得
	 * @return prtype 分组标识
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 分组标识设定
	 * @param prtype 分组标识
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
	 * 当前流程主键取得
	 * @return currentPrid 当前流程主键
	 */
	public Integer getCurrentPrid() {
		return currentPrid;
	}

	/**
	 * 当前流程主键设定
	 * @param currentPrid 当前流程主键
	 */
	public void setCurrentPrid(Integer currentPrid) {
		this.currentPrid = currentPrid;
	}

	/**
	 * 复制按钮标识取得
	 * @return showCopy 复制按钮标识
	 */
	public String getShowCopy() {
		return showCopy;
	}

	/**
	 * 复制按钮标识设定
	 * @param showCopy 复制按钮标识
	 */
	public void setShowCopy(String showCopy) {
		this.showCopy = showCopy;
	}
}

/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 变更批量分派Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC0403Form extends BaseForm{

	/** 流程ID集合 */
	protected Integer[] prid;
	
	/** 流程定义ID */
	protected String pdid;
	
	/** 流程状态码 */
	protected String prstatus;
	
	/** 按钮名称 */
	protected String buttonName;
	
	/** 按钮标识 */
	protected String buttonCode;
	
	/** 被分派参与人信息集合 */
	protected String[] participants;

	protected Integer[] prids;
	/**
	 * 流程ID集合取得
	 * @return prid 流程ID集合
	 */
	public Integer[] getPrid() {
		return prid;
	}

	/**
	 * 流程ID集合设定
	 * @param prid 流程ID集合
	 */
	public void setPrid(Integer[] prid) {
		this.prid = prid;
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
	 * 流程状态码取得
	 * @return prstatus 流程状态码
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 流程状态码设定
	 * @param prstatus 流程状态码
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * 按钮名称取得
	 * @return buttonName 按钮名称
	 */
	public String getButtonName() {
		return buttonName;
	}

	/**
	 * 按钮名称设定
	 * @param buttonName 按钮名称
	 */
	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}

	/**
	 * 按钮标识取得
	 * @return buttonCode 按钮标识
	 */
	public String getButtonCode() {
		return buttonCode;
	}

	/**
	 * 按钮标识设定
	 * @param buttonCode 按钮标识
	 */
	public void setButtonCode(String buttonCode) {
		this.buttonCode = buttonCode;
	}

	/**
	 * 被分派参与人信息集合取得
	 * @return participants 被分派参与人信息集合
	 */
	public String[] getParticipants() {
		return participants;
	}

	/**
	 * 被分派参与人信息集合设定
	 * @param participants 被分派参与人信息集合
	 */
	public void setParticipants(String[] participants) {
		this.participants = participants;
	}

	/**
	 * @return the prids
	 */
	public Integer[] getPrids() {
		return prids;
	}

	/**
	 * @param prids the prids to set
	 */
	public void setPrids(Integer[] prids) {
		this.prids = prids;
	}
	
	
}

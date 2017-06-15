/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 流程状态可调整参与者定义Form
 * 功能描述: 流程状态可调整参与者定义Form
 * 创建记录: 2012/05/09
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGPRD0142Form extends BaseForm {
	
	/** 流程定义ID */
	protected String pdid;
	
	/** 流程状态ID */
	protected String psdid;
	
	protected String[] ids;
	
	/** 处理方式：0-删除，1-增加 */
	protected String mode;

	/** 上级状态ID */
	protected String ppsdid;
	
	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * 
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程状态ID取得
	 * 
	 * @return 流程状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程状态ID设定
	 * 
	 * @param psdid 流程状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}
	
	/**
	 * 处理方式取得
	 * 
	 * @return 处理方式
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 处理方式设定
	 * 
	 * @param mode 处理方式
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/** 查看模式 0最新：可编辑，1：历史：只查看 */
	protected String viewhistory;

	/**
	 * 查看模式
	 *
	 * @return 查看模式
	 */
	public String getViewhistory() {
		return viewhistory;
	}

	/**
	 * 查看模式
	 *
	 * @param viewHistory  0：最新，1历史
	 */
	public void setViewhistory(String viewhistory) {
		this.viewhistory = viewhistory;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	/**
	 * 上级状态ID取得
	 * @return 上级状态ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * 上级状态ID设定
	 * @param ppsdid 上级状态ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}
}

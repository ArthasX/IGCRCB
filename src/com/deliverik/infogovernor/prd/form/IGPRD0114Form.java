/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * 流程定义_分派角色Form
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0114Form extends BaseForm {
	
	/** 参与者ID */
	protected String ppdid;
	
	/** 定义ID */
	protected String pdid;
	
	/** 状态ID */
	protected String psdid;
	
	/** 模式：1-清除 */
	protected String mode;
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.ppdid = null;
	}

	/**
	 * 参与者ID取得
	 * @return
	 */
	public String getPpdid() {
		return ppdid;
	}

	/**
	 * 参与者ID设定
	 * @param ppdid参与者ID
	 */
	public void setPpdid(String ppdid) {
		this.ppdid = ppdid;
	}

	/**
	 * 定义ID取得
	 * @return 定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 定义ID设定
	 * @param pdid定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 状态ID取得
	 * @return 状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 状态ID设定
	 * @param psdid状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 模式取得
	 * @return 模式
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 模式设定
	 * @param mode 模式
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
}

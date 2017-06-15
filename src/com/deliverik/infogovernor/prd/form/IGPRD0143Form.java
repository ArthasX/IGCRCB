/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prd.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 流程状态可分派机构定义Form
 * 功能描述: 流程状态可分派机构定义Form
 * 创建记录: 2012/04/11
 * 修改记录: 2013/02/25		130225	流程机构相关修改(状态可分派机构配置)
 */
@SuppressWarnings("serial")
public class IGPRD0143Form extends BaseForm {
	
	/** 流程定义ID */
	protected String pdid;
	
	/** 流程状态ID */
	protected String psdid;
	
	/** 流程状态可分派角色定义ID */
	protected String[] psodids;
	
	/** 角色ID */
	protected String[] orgsyscodings;
	
	/** 处理方式：0-删除，1-增加 */
	protected String mode;
	
	/**
	 * 初始化
	 * 
	 * @param mapping ActionMapping
	 * @param request HttpServletRequest
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.orgsyscodings = null;
	}
	
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
	 * 流程状态可分派角色定义ID取得
	 *
	 * @return psodids 流程状态可分派角色定义ID
	 */
	public String[] getPsodids() {
		return psodids;
	}

	/**
	 * 流程状态可分派角色定义ID设定
	 *
	 * @param psodids 流程状态可分派角色定义ID
	 */
	public void setPsodids(String[] psodids) {
		this.psodids = psodids;
	}

	/**
	 * 角色ID取得
	 *
	 * @return orgsyscodings 角色ID
	 */
	public String[] getOrgsyscodings() {
		return orgsyscodings;
	}

	/**
	 * 角色ID设定
	 *
	 * @param orgsyscodings 角色ID
	 */
	public void setOrgsyscodings(String[] orgsyscodings) {
		this.orgsyscodings = orgsyscodings;
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

	/** 上级状态ID */
	protected String ppsdid;

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

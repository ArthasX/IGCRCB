/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 自定义流程表单查询条件定义Form
 * 功能描述: 自定义流程表单查询条件定义Form
 * 创建记录: 2013/03/15
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGPRD0145Form extends BaseForm{
	
	/** 流程类型主键 */
	protected String pdid;
	
	/** 要删除的信息集合 */
	protected String[] pidid_del;
	
	/** 要添加的信息集合 */
	protected String[] pidid_add;
	
	/**处理方式：0-删除，1-增加*/
	protected String mode;
	
	/** 流程查询显示列 */
	protected String[] processQueryShowColumns;
	
	/** 流程查询条件 */
	protected String[] processQuerys;
	
	/** 查看模式 0最新：可编辑，1：历史：只查看 */
	protected String viewhistory;

	
	/**
	 * @return the processQueryShowColumns
	 */
	public String[] getProcessQueryShowColumns() {
		return processQueryShowColumns;
	}

	/**
	 * @param processQueryShowColumns the processQueryShowColumns to set
	 */
	public void setProcessQueryShowColumns(String[] processQueryShowColumns) {
		this.processQueryShowColumns = processQueryShowColumns;
	}

	/**
	 * @return the processQuerys
	 */
	public String[] getProcessQuerys() {
		return processQuerys;
	}

	/**
	 * @param processQuerys the processQuerys to set
	 */
	public void setProcessQuerys(String[] processQuerys) {
		this.processQuerys = processQuerys;
	}

	/**
	 * 流程类型主键取得
	 * @return 流程类型主键
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程类型主键设定
	 * @param pdid 流程类型主键
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 要删除的信息集合取得
	 * @return 要删除的信息集合
	 */
	public String[] getPidid_del() {
		return pidid_del;
	}

	/**
	 * 要添加的信息集合取得
	 * @return 要添加的信息集合
	 */
	public String[] getPidid_add() {
		return pidid_add;
	}

	/**
	 * 要删除的信息集合设定
	 * @param pidid_del 要删除的信息集合
	 */
	public void setPidid_del(String[] pidid_del) {
		this.pidid_del = pidid_del;
	}

	/**
	 * 要添加的信息集合设定
	 * @param pidid_add 要添加的信息集合
	 */
	public void setPidid_add(String[] pidid_add) {
		this.pidid_add = pidid_add;
	}

	/**
	 * 处理方式取得
	 * @return 处理方式
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 处理方式设定
	 * @param mode 处理方式
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

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
}

/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.cim.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 审计控制台显示FORM
 * 功能描述: 审计控制台显示FORM
 * 创建记录: 2011/04/29
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGCIM0301Form extends BaseForm {
	
	/** 任务复选框 */
	protected String[] auwtids;

	/** 任务状态是否完成 */
	protected String taskDone;
	
	/** 审计任务ID */
	protected Integer autid;
	
	/**
	 * 任务复选框取得
	 * 
	 * @return 任务复选框
	 */
	public String[] getAuwtids() {
		return auwtids;
	}

	/**
	 * 任务复选框设定
	 * 
	 * @param auwtids 任务复选框
	 */
	public void setAuwtids(String[] auwtids) {
		this.auwtids = auwtids;
	}

	/**
	 * 任务状态是否完成取得
	 * 
	 * @return 任务状态是否完成
	 */
	public String getTaskDone() {
		return taskDone;
	}

	/**
	 * 任务状态是否完成设定
	 * 
	 * @param 任务状态是否完成
	 */
	public void setTaskDone(String taskDone) {
		this.taskDone = taskDone;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.taskDone = "0";//默认查询未完成
		this.auwtids = null;
	}

	/**
	 * 审计任务ID取得
	 * @return 审计任务ID
	 */
	public Integer getAutid() {
		return autid;
	}

	/**
	 * 审计任务ID设定
	 * @param autid 审计任务ID
	 */
	public void setAutid(Integer autid) {
		this.autid = autid;
	}

}

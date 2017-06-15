/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 控制台显示FORM
 * 功能描述: 控制台显示FORM
 * 创建记录: 2011/04/29
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM2001Form extends BaseForm {
	
	/** 任务复选框 */
	protected String[] eitids;

	/** 任务状态是否完成 */
	protected String taskDone;
	
	/**
	 * 任务复选框取得
	 * 
	 * @return 任务复选框
	 */
	public String[] getEitids() {
		return eitids;
	}

	/**
	 * 任务复选框设定
	 * 
	 * @param eitids 任务复选框
	 */
	public void setEitids(String[] eitids) {
		this.eitids = eitids;
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
		this.eitids = null;
	}

}

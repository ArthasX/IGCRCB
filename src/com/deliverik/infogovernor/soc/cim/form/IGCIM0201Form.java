/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.cim.form;

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
public class IGCIM0201Form extends BaseForm {
	
	/** 任务复选框 */
	protected String[] eitids;

	/** 任务状态是否完成 */
	protected String taskDone;
	
	/** 查询状态 */
	protected String status;

	/** 查询后保留痕迹 */
	protected boolean taskError; 

	protected boolean taskToDos; 
	
	protected boolean taskBeing; 
	
	protected boolean taskDoness; 
	
	protected boolean taskAgnore;
	
	/** 最新采集时间 */
	protected String impcreatetime_s;
	
	/** 最新采集时间 */
	protected String impcreatetime_e;
	
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public boolean getTaskError() {
		return taskError;
	}

	public void setTaskError(boolean taskError) {
		this.taskError = taskError;
	}

	public boolean getTaskToDos() {
		return taskToDos;
	}

	public void setTaskToDos(boolean taskToDos) {
		this.taskToDos = taskToDos;
	}

	public boolean getTaskBeing() {
		return taskBeing;
	}

	public void setTaskBeing(boolean taskBeing) {
		this.taskBeing = taskBeing;
	}

	public boolean getTaskDoness() {
		return taskDoness;
	}

	public void setTaskDoness(boolean taskDoness) {
		this.taskDoness = taskDoness;
	}

	public boolean getTaskAgnore() {
		return taskAgnore;
	}

	public void setTaskAgnore(boolean taskAgnore) {
		this.taskAgnore = taskAgnore;
	}
	
	public String getImpcreatetime_s() {
		return impcreatetime_s;
	}

	public void setImpcreatetime_s(String impcreatetime_s) {
		this.impcreatetime_s = impcreatetime_s;
	}

	public String getImpcreatetime_e() {
		return impcreatetime_e;
	}

	public void setImpcreatetime_e(String impcreatetime_e) {
		this.impcreatetime_e = impcreatetime_e;
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
		this.status = "1,2";
		this.eitids = null;
	}

}

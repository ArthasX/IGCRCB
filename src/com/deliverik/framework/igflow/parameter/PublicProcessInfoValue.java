/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.parameter;

/**
 * 公有表单信息
 */
public class PublicProcessInfoValue implements PublicProcessInfoValueInfo{

	/** 表单名称 */
	private String formname;
	
	/** 表单值 */
	private String formvalue;
	
	/** 日志参数信息 */
	private WorkFlowLogInfo logInfo;
	
	/**
	 * 构造函数
	 * 
	 * @param logInfo 日志参数信息
	 */
	public PublicProcessInfoValue(WorkFlowLogInfo logInfo) {
		this.logInfo = logInfo;
	}

	/**
	 * 表单名称取得
	 * 
	 * @return 表单名称
	 */
	public String getFormname() {
		return formname;
	}

	/**
	 * 表单值取得
	 * 
	 * @return 表单值
	 */
	public String getFormvalue() {
		return formvalue;
	}

	/**
	 * 日志参数信息取得
	 * 
	 * @return 日志参数信息
	 */
	public WorkFlowLogInfo getLogInfo() {
		return logInfo;
	}

	/**
	 * 表单名称设定
	 * 
	 * @param formname 表单名称
	 */
	public void setFormname(String formname) {
		this.formname = formname;
	}

	/**
	 * 表单值设定
	 * 
	 * @param formvalue 表单值
	 */
	public void setFormvalue(String formvalue) {
		this.formvalue = formvalue;
	}

	/**
	 * 日志参数信息设定
	 * 
	 * @param logInfo 日志参数信息
	 */
	public void setLogInfo(WorkFlowLogInfo logInfo) {
		this.logInfo = logInfo;
	}
	
}

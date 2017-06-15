/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

/**
 * 处理表单日志信息
 */
public class ProcessFormLog implements ProcessFormLogInfo {
	
	/** 表单定义ID */
	private String pidid;

	/** 表单名称 */
	private String name;

	/** 表单值 */
	private String value;

	/**
	 * 表单定义ID取得
	 * @return 表单定义ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 表单定义ID设定
	 * @param pidid 表单定义ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 表单名称取得
	 * @return 表单名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 表单名称设定
	 * @param name 表单名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 表单值取得
	 * @return 表单值
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 表单值设定
	 * @param value 
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
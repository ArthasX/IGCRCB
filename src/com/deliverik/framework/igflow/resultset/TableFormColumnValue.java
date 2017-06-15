/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.igflow.resultset;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 表格式表单列值信息
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class TableFormColumnValue implements TableFormColumnValueInfo{

	/** 列全路径 */
	protected String fullName;
	
	/** 行号 */
	protected String rownumber;
	
	/** 列值 */
	protected String value;

	/**
	 * 列全路径取得
	 * @return fullName 列全路径
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * 列全路径设定
	 * @param fullName 列全路径
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * 行号取得
	 * @return rownumber 行号
	 */
	public String getRownumber() {
		return rownumber;
	}

	/**
	 * 行号设定
	 * @param rownumber 行号
	 */
	public void setRownumber(String rownumber) {
		this.rownumber = rownumber;
	}

	/**
	 * 列值取得
	 * @return value 列值
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 列值设定
	 * @param value 列值
	 */
	public void setValue(String value) {
		this.value = value;
	}
}

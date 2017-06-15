/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.soc.mnt.form;


import com.deliverik.framework.base.BaseForm;

/**
 * 概述:监控类型阀值信息form
 * 功能描述：
 * 创建记录：张楠    2012/02/09
 */
@SuppressWarnings("serial")
public class IGMNT0102Form extends BaseForm{
	
	/**
	 * 主键id数组
	 */
	protected String[] mtdId;

	/**
	 * 监控类型id
	 */
	protected Integer mtId;

	/**
	 * 监控类型阀值数组
	 */
	protected String[] mtdValue;
	
	/**
	 * 监控类型状态
	 */
	protected String[] deleteFlag;
	
	/**
	 * 比较符数组
	 */
	protected String[] compare;
	
	/**
	 * 告警描述
	 */
	protected String[] mtdDes;
	
	/**
	 * 监控类型阀值数组获取
	 * @return
	 */
	public String[] getMtdValue() {
		return mtdValue;
	}

	/**
	 * 监控类型阀值数组设定
	 * @param mtdValue
	 */
	public void setMtdValue(String[] mtdValue) {
		this.mtdValue = mtdValue;
	}

	/**
	 * 监控类型id获取
	 * @return
	 */
	public Integer getMtId() {
		return mtId;
	}

	/**
	 * 监控类型id设定
	 * @param mtId
	 */
	public void setMtId(Integer mtId) {
		this.mtId = mtId;
	}

	/**
	 * 监控类型状态获取
	 * @return
	 */
	public String[] getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * 监控类型状态设定
	 * @param deleteFlag
	 */
	public void setDeleteFlag(String[] deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	/**
	 * 主键id数组获取
	 * @return
	 */
	public String[] getMtdId() {
		return mtdId;
	}

	/**
	 * 主键id数组设定
	 * @param mtdId
	 */
	public void setMtdId(String[] mtdId) {
		this.mtdId = mtdId;
	}

	/**
	 * 比较符数组取得
	 * @return
	 */
	public String[] getCompare() {
		return compare;
	}

	/**
	 * 比较符数组设定
	 * @param compare
	 */
	public void setCompare(String[] compare) {
		this.compare = compare;
	}

	/**
	 * 告警描述取得
	 * @return
	 */
	public String[] getMtdDes() {
		return mtdDes;
	}

	/**
	 * 告警描述设定
	 * @param mtdDes
	 */
	public void setMtdDes(String[] mtdDes) {
		this.mtdDes = mtdDes;
	}
}

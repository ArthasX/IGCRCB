/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.soc.mnt.form;


import com.deliverik.framework.base.BaseForm;

/**
 * 概述:监控对象查询form
 * 功能描述：
 * 创建记录：张楠    2012/02/09
 */
@SuppressWarnings("serial")
public class IGMNT0104Form extends BaseForm{
	
	/**
	 * 监控类型id
	 */
	protected String mtId_eq;
	
	/**
	 * 监控对象名称
	 */
	protected String moName_eq;
	
	/**
	 * 创建时间从
	 */
	protected String moCreateTime_from;
	
	/**
	 * 创建时间到
	 */
	protected String moCreateTime_to;
	
	/**
	 * 监控对象id
	 */
	protected String moId;
	
	/**
	 * 监控对象状态
	 */
	protected String deleteFlag;

	/**
	 * 创建时间到获取
	 * @return
	 */
	public String getMoCreateTime_to() {
		return moCreateTime_to;
	}
	
	/**
	 * 创建时间到设定
	 * @return
	 */
	public void setMoCreateTime_to(String moCreateTime_to) {
		this.moCreateTime_to = moCreateTime_to;
	}

	/**
	 * 创建时间从获取
	 * @return
	 */
	public String getMoCreateTime_from() {
		return moCreateTime_from;
	}

	/**
	 * 创建时间从设定
	 * @return
	 */
	public void setMoCreateTime_from(String moCreateTime_from) {
		this.moCreateTime_from = moCreateTime_from;
	}

	/**
	 * 监控类型id取得
	 * @return
	 */
	public String getMtId_eq() {
		return mtId_eq;
	}

	/**
	 * 监控类型id设定
	 * @param mtId_eq
	 */
	public void setMtId_eq(String mtId_eq) {
		this.mtId_eq = mtId_eq;
	}

	/**
	 * 监控对象名称取得
	 * @return
	 */
	public String getMoName_eq() {
		return moName_eq;
	}

	/**
	 * 监控对象名称设定
	 * @param moName_eq
	 */
	public void setMoName_eq(String moName_eq) {
		this.moName_eq = moName_eq;
	}

	/**
	 * 监控对象状态取得
	 * @return
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * 监控对象状态设定
	 * @param deleteFlag
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * 监控对象id取得
	 * @return
	 */
	public String getMoId() {
		return moId;
	}

	/**
	 * 监控对象id设定
	 * @param moId
	 */
	public void setMoId(String moId) {
		this.moId = moId;
	}
}

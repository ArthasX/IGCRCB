/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.plugin.sms.dto;

import java.io.Serializable;
import java.util.Locale;

import com.deliverik.framework.base.BaseDTO;
/**
 * 概述:告警信息管理DTO
 * 功能描述：
 * 创建记录：2012/09/28 By 卢嘉元
 */

@SuppressWarnings("serial")
public class SMSDTO extends BaseDTO implements Serializable{
	
	/** 国际化信息 */
	protected Locale locale;
	
	/**
	 * getter and setter
	 */
	/**
	 * 国际化信息取得
	 *
	 * @return locale 国际化信息
	 */
	public Locale getLocale() {
		return locale;
	}
	/**
	 * 国际化信息设定
	 *
	 * @param locale 国际化信息
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
}
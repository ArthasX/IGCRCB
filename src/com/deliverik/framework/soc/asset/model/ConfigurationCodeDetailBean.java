/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.framework.soc.asset.model;

/**
 * 资产属性取值范围bean
 * 
 */
public class ConfigurationCodeDetailBean {


	/**
	 * 资产属性取值范围标识取得
	 * @return 资产属性取值范围标识
	 */
	public String ccdcategory;
	
	/**
	 * 资产属性取值范围标识名称取得
	 * @return 资产属性取值范围标识名称
	 */
	public String ccdlabel;

	public String getCcdcategory() {
		return ccdcategory;
	}

	public void setCcdcategory(String ccdcategory) {
		this.ccdcategory = ccdcategory;
	}

	public String getCcdlabel() {
		return ccdlabel;
	}

	public void setCcdlabel(String ccdlabel) {
		this.ccdlabel = ccdlabel;
	}



}
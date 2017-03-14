/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.framework.soc.asset.model.condition;

import com.deliverik.framework.soc.asset.model.condition.SOC0151SearchCond;

/**
 * 资产模型属性取值范围检索条件实现
 * 
 */
public class SOC0151SearchCondImpl implements SOC0151SearchCond {

	/**
	 * 资产属性取值范围标识
	 */
	public String ccdcategory;
	
	/**
	 * 资产属性取值范围状态（1启用，0停用）
	 */
	public String ccdstatus;

	/**
	 * 资产属性取值范围所属应用
	 */
	public String ccdtype;

	
	/**
	 * 资产属性取值范围标识取得
	 * @return 资产属性取值范围标识
	 */
	public String getCcdcategory() {
		return ccdcategory;
	}

	/**
	 * 资产属性取值范围标识设定
	 *
	 * @param ccdcategory 资产属性取值范围标识
	 */
	public void setCcdcategory(String ccdcategory) {
		this.ccdcategory = ccdcategory;
	}

	/**
	 * 资产属性取值范围状态取得
	 * @return 资产属性取值范围状态
	 */
	public String getCcdstatus() {
		return ccdstatus;
	}

	/**
	 * 资产属性取值范围状态设定
	 *
	 * @param ccdstatus 资产属性取值范围状态
	 */
	public void setCcdstatus(String ccdstatus) {
		this.ccdstatus = ccdstatus;
	}

	/**
	 * 资产属性取值范围所属应用取得
	 * @return 资产属性取值范围所属应用
	 */
	public String getCcdtype() {
		return ccdtype;
	}

	/**
	 * 资产属性取值范围所属应用设定
	 *
	 * @param ccdtype 资产属性取值范围所属应用
	 */
	public void setCcdtype(String ccdtype) {
		this.ccdtype = ccdtype;
	}

}

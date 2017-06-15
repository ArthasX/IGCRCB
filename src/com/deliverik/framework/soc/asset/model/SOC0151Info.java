/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * 资产模型属性取值范围
 * </p>
 */
public interface SOC0151Info  extends BaseModel {

	/**
	 * 资产模型属性取值范围ID取得
	 * @return 资产模型属性取值范围ID
	 */
	public Integer getCcdid();

	/**
	 * 资产模型属性取值范围标识取得
	 * @return 资产模型属性取值范围标识
	 */
	public String getCcdcategory();
	
	/**
	 * 资产模型属性取值范围标识名称取得
	 * @return 资产模型属性取值范围标识名称
	 */
	public String getCcdlabel();

	/**
	 * 资产模型属性取值范围值取得
	 * @return 资产模型属性取值范围值
	 */
	public String getCcdvalue();

	/**
	 * 资产模型属性取值范围状态取得
	 * @return 资产模型属性取值范围状态
	 */
	public String getCcdstatus();

	/**
	 * 资产模型属性取值范围所属应用取得
	 * @return 资产模型属性取值范围所属应用
	 */
	public String getCcdtype();

	/**
	 * 资产模型属性取值范围预留字段取得
	 * @return 资产模型属性取值范围预留字段
	 */
	public String getCcdinfo();

}
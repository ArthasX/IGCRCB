/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.asset.model;

/**
 * 资产属性取值范围bean
 * 
 */
public class IG545Bean {


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
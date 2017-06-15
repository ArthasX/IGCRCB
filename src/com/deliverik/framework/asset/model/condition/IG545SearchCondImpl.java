/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.condition;

/**
 * 资产模型属性取值范围检索条件实现
 * 
 */
public class IG545SearchCondImpl implements IG545SearchCond {

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

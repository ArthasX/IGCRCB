/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.condition;


/**
  * 概述: 实体链路图检索条件实现
  * 功能描述: 实体链路图检索条件实现
  * 创建记录: 2011/05/24
  * 修改记录: 
  */
public class EiLinkMapSearchCondImpl implements
		EiLinkMapSearchCond {
	
	/** 域ID */
	protected Integer domainid_eq;

	/** 域版本 */
	protected Integer domainversion_eq;
	
	/** 资产ID */
	protected Integer eiid_eq;
	
	/** 创建时间 */
	protected String createtime_eq;
	
	/** 绘图标记 */
	protected String linkflag_eq;
	
	/** 资产层次码 */
	protected String esyscoding_eq;
	
	protected Integer otherEiid;

	/**
	 * 域ID取得
	 * 
	 * @return 域ID
	 */
	public Integer getDomainid_eq() {
		return domainid_eq;
	}

	/**
	 * 域ID设定
	 * 
	 * @param domainid_eq 域ID
	 */
	public void setDomainid_eq(Integer domainid_eq) {
		this.domainid_eq = domainid_eq;
	}

	/**
	 * 域版本取得
	 * 
	 * @return 域版本
	 */
	public Integer getDomainversion_eq() {
		return domainversion_eq;
	}

	/**
	 * 域版本设定
	 * 
	 * @param domainversion_eq 域版本
	 */
	public void setDomainversion_eq(Integer domainversion_eq) {
		this.domainversion_eq = domainversion_eq;
	}

	/**
	 * 资产ID取得
	 * 
	 * @return 资产ID
	 */
	public Integer getEiid_eq() {
		return eiid_eq;
	}

	/**
	 * 资产ID设定
	 * 
	 * @param eiid_eq 资产ID
	 */
	public void setEiid_eq(Integer eiid_eq) {
		this.eiid_eq = eiid_eq;
	}

	/**
	 * 创建时间取得
	 * 
	 * @return 创建时间
	 */
	public String getCreatetime_eq() {
		return createtime_eq;
	}

	/**
	 * 创建时间设定
	 * 
	 * @param createtime_eq 创建时间
	 */
	public void setCreatetime_eq(String createtime_eq) {
		this.createtime_eq = createtime_eq;
	}

	/**
	 * 绘图标记取得
	 * 
	 * @return 绘图标记
	 */
	public String getLinkflag_eq() {
		return linkflag_eq;
	}

	/**
	 * 绘图标记设定
	 * 
	 * @param linkflag_eq 绘图标记
	 */
	public void setLinkflag_eq(String linkflag_eq) {
		this.linkflag_eq = linkflag_eq;
	}
	
	/**
	 * 资产层次码取得
	 *
	 * @return 资产层次码
	 */
	public String getEsyscoding_eq() {
		return esyscoding_eq;
	}

	/**
	 * 资产层次码设定
	 *
	 * @param esyscoding_eq 资产层次码
	 */
	public void setEsyscoding_eq(String esyscoding_eq) {
		this.esyscoding_eq = esyscoding_eq;
	}

	/**
	 * otherEiid取得
	 *
	 * @return otherEiid otherEiid
	 */
	public Integer getOtherEiid() {
		return otherEiid;
	}

	/**
	 * otherEiid设定
	 *
	 * @param otherEiid otherEiid
	 */
	public void setOtherEiid(Integer otherEiid) {
		this.otherEiid = otherEiid;
	}
	
}
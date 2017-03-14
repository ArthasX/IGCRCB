/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset;

import java.io.Serializable;


import com.deliverik.framework.base.BasePK;
/**
 * 概述: 资产域明细表实体主键
 * 功能描述: 资产域明细表实体主键
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class EiDomainDetailCIPK extends BasePK implements Serializable {
	
	protected Integer domainid;
	
	
	protected Integer domainversion;
	
	protected Integer eiversion;
	
	protected Integer eiid;
	
	/**
	 * 构造函数
	 */
	public EiDomainDetailCIPK(){}
	
	/**
	 * 构造函数
	 */
	public EiDomainDetailCIPK(Integer domainid, Integer domainversion,
			Integer eiversion, Integer eiid) {
		super();
		this.domainid = domainid;
		this.domainversion = domainversion;
		this.eiversion = eiversion;
		this.eiid = eiid;
	}

	public Integer getDomainid() {
		return domainid;
	}


	public void setDomainid(Integer domainid) {
		this.domainid = domainid;
	}

	public Integer getDomainversion() {
		return domainversion;
	}

	public void setDomainversion(Integer domainversion) {
		this.domainversion = domainversion;
	}

	public Integer getEiversion() {
		return eiversion;
	}

	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	
	
}

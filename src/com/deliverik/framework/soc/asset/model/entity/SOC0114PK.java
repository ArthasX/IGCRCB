/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: 实体链路图实体主键
  * 功能描述: 实体链路图实体主键
  * 创建记录: 2011/05/24
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class SOC0114PK extends BasePK implements Serializable {

	/** 域ID */
	protected Integer domainid;

	/** Domain版本 */
	protected Integer domainversion;

	/** 链路ID */
	protected Integer linkid;

	/** 链路顺序 */
	protected Integer linkorder;

	/**
	 * 构造函数
	 */
	public SOC0114PK() {

	}

	/**
	 * 构造函数
	 */
	public SOC0114PK(Integer domainid, Integer domainversion, Integer linkid, Integer linkorder) {
		super();
		this.domainid = domainid;
		this.domainversion = domainversion;
		this.linkid = linkid;
		this.linkorder = linkorder;
	}

	/**
	 * 域ID取得
	 *
	 * @return 域ID
	 */
	public Integer getDomainid() {
		return domainid;
	}

	/**
	 * 域ID设定
	 *
	 * @param domainid 域ID
	 */
	public void setDomainid(Integer domainid) {
		this.domainid = domainid;
	}

	/**
	 * Domain版本取得
	 *
	 * @return Domain版本
	 */
	public Integer getDomainversion() {
		return domainversion;
	}

	/**
	 * Domain版本设定
	 *
	 * @param domainversion Domain版本
	 */
	public void setDomainversion(Integer domainversion) {
		this.domainversion = domainversion;
	}

	/**
	 * 链路ID取得
	 *
	 * @return 链路ID
	 */
	public Integer getLinkid() {
		return linkid;
	}

	/**
	 * 链路ID设定
	 *
	 * @param linkid 链路ID
	 */
	public void setLinkid(Integer linkid) {
		this.linkid = linkid;
	}

	/**
	 * 链路顺序取得
	 *
	 * @return 链路顺序
	 */
	public Integer getLinkorder() {
		return linkorder;
	}

	/**
	 * 链路顺序设定
	 *
	 * @param linkorder 链路顺序
	 */
	public void setLinkorder(Integer linkorder) {
		this.linkorder = linkorder;
	}

}
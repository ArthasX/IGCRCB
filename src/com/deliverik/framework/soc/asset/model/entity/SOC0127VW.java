/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.soc.asset.model.SOC0127Info;

/**
  * 概述: 配置所属关系视图
  * 功能描述: 配置所属关系视图
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0127PK.class)
public class SOC0127VW implements Serializable, Cloneable, SOC0127Info {

	/** 源资产ID */
	@Id
	protected Integer brpareiid;

	/** 源资产大版本 */
	protected Integer brparversion;

	/** 源资产小版本 */
	protected Integer brparsmallversion;

	/** 目的资产ID */
	@Id
	protected Integer brcldeiid;

	/** 目的资产大版本 */
	protected Integer brcldversion;

	/** 目的资产小版本 */
	protected Integer brcldsmallversion;

	/** 源资产信息 */
	@ManyToOne
	@JoinColumn(name="brpareiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0123VW parEntityItemVW;

	/** 目的资产信息 */
	@ManyToOne
	@JoinColumn(name="brcldeiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0123VW cldEntityItemVW;

	/**
	 * 源资产取得
	 *
	 * @return 源资产
	 */
	public SOC0123VW getParEntityItemVW() {
		return parEntityItemVW;
	}
	/**
	 * 源资产设定
	 *
	 * @param parEntityItemVW 源资产
	 */
	public void setParEntityItemVW(SOC0123VW parEntityItemVW) {
		this.parEntityItemVW = parEntityItemVW;
	}
	
	/**
	 * 目的资产取得
	 *
	 * @return 目的资产
	 */
	public SOC0123VW getCldEntityItemVW() {
		return cldEntityItemVW;
	}
	/**
	 * 目的资产设定
	 *
	 * @param cldEntityItemVW 目的资产
	 */
	public void setCldEntityItemVW(SOC0123VW cldEntityItemVW) {
		this.cldEntityItemVW = cldEntityItemVW;
	}

	/**
	 * 源资产ID取得
	 *
	 * @return 源资产ID
	 */
	public Integer getBrpareiid() {
		return brpareiid;
	}

	/**
	 * 源资产ID设定
	 *
	 * @param brpareiid源资产ID
	 */
	public void setBrpareiid(Integer brpareiid) {
		this.brpareiid = brpareiid;
	}

	/**
	 * 源资产大版本取得
	 *
	 * @return 源资产大版本
	 */
	public Integer getBrparversion() {
		return brparversion;
	}

	/**
	 * 源资产大版本设定
	 *
	 * @param brparversion源资产大版本
	 */
	public void setBrparversion(Integer brparversion) {
		this.brparversion = brparversion;
	}

	/**
	 * 源资产小版本取得
	 *
	 * @return 源资产小版本
	 */
	public Integer getBrparsmallversion() {
		return brparsmallversion;
	}

	/**
	 * 源资产小版本设定
	 *
	 * @param brparsmallversion源资产小版本
	 */
	public void setBrparsmallversion(Integer brparsmallversion) {
		this.brparsmallversion = brparsmallversion;
	}

	/**
	 * 目的资产ID取得
	 *
	 * @return 目的资产ID
	 */
	public Integer getBrcldeiid() {
		return brcldeiid;
	}

	/**
	 * 目的资产ID设定
	 *
	 * @param brcldeiid目的资产ID
	 */
	public void setBrcldeiid(Integer brcldeiid) {
		this.brcldeiid = brcldeiid;
	}

	/**
	 * 目的资产大版本取得
	 *
	 * @return 目的资产大版本
	 */
	public Integer getBrcldversion() {
		return brcldversion;
	}

	/**
	 * 目的资产大版本设定
	 *
	 * @param brcldversion目的资产大版本
	 */
	public void setBrcldversion(Integer brcldversion) {
		this.brcldversion = brcldversion;
	}

	/**
	 * 目的资产小版本取得
	 *
	 * @return 目的资产小版本
	 */
	public Integer getBrcldsmallversion() {
		return brcldsmallversion;
	}

	/**
	 * 目的资产小版本设定
	 *
	 * @param brcldsmallversion目的资产小版本
	 */
	public void setBrcldsmallversion(Integer brcldsmallversion) {
		this.brcldsmallversion = brcldsmallversion;
	}

}
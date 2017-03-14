/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.dao.hibernate.LogicalDelete;
import com.deliverik.framework.soc.asset.model.SOC0110Info;

/**
  * 概述: 配置所属关系表实体
  * 功能描述: 配置所属关系表实体
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0110")
public class SOC0110TB extends BaseEntity implements Serializable,
		Cloneable, SOC0110Info,LogicalDelete {

	/** 逻辑主键 */
	@Id
	@TableGenerator(
		name="SOC0110_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="SOC0110_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SOC0110_TABLE_GENERATOR")
	protected Integer brid;

	/** 源资产ID */
	protected Integer brpareiid;

	/** 源资产大版本 */
	protected Integer brparversion;

	/** 源资产小版本 */
	protected Integer brparsmallversion;

	/** 目的资产ID */
	protected Integer brcldeiid;

	/** 目的资产大版本 */
	protected Integer brcldversion;

	/** 目的资产小版本 */
	protected Integer brcldsmallversion;

	/** 关系类型（物理/逻辑） */
	protected String brtype;

	/** 关系说明 */
	protected String brdes;

	/** 创建时间 */
	protected String brcreatetime;

	/** 逻辑删除标识 */
	protected String deleteflag;
	
	/** 关联关系码 */
	protected String brraletioncode;

	/** 资产关系项 */
	protected String brassetrelation;
	
	/** 资产所属树根节点实体标识 */
	protected Integer eirootmark;
	
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
	 * 关联关系码取得
	 *
	 * @return 关联关系码
	 */
	public String getBrraletioncode() {
		return brraletioncode;
	}
	/**
	 * 关联关系码设定
	 *
	 * @param extraletioncode关联关系码
	 */
	public void setBrraletioncode(String brraletioncode) {
		this.brraletioncode = brraletioncode;
	}
	/**
	 * 资产关系项取得
	 *
	 * @return 资产关系项
	 */
	public String getBrassetrelation() {
		return brassetrelation;
	}
	/**
	 * 资产关系项设定
	 *
	 * @param extassetrelation资产关系项
	 */
	public void setBrassetrelation(String brassetrelation) {
		this.brassetrelation = brassetrelation;
	}
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
	 * 逻辑主键取得
	 *
	 * @return 逻辑主键
	 */
	public Integer getBrid() {
		return brid;
	}

	/**
	 * 逻辑主键设定
	 *
	 * @param brid逻辑主键
	 */
	public void setBrid(Integer brid) {
		this.brid = brid;
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

	/**
	 * 关系类型（物理/逻辑）取得
	 *
	 * @return 关系类型（物理/逻辑）
	 */
	public String getBrtype() {
		return brtype;
	}

	/**
	 * 关系类型（物理/逻辑）设定
	 *
	 * @param brtype关系类型（物理/逻辑）
	 */
	public void setBrtype(String brtype) {
		this.brtype = brtype;
	}

	/**
	 * 关系说明取得
	 *
	 * @return 关系说明
	 */
	public String getBrdes() {
		return brdes;
	}

	/**
	 * 关系说明设定
	 *
	 * @param brdes关系说明
	 */
	public void setBrdes(String brdes) {
		this.brdes = brdes;
	}

	/**
	 * 创建时间取得
	 *
	 * @return 创建时间
	 */
	public String getBrcreatetime() {
		return brcreatetime;
	}

	/**
	 * 创建时间设定
	 *
	 * @param brcreatetime创建时间
	 */
	public void setBrcreatetime(String brcreatetime) {
		this.brcreatetime = brcreatetime;
	}

	/**
	 * 逻辑删除标识取得
	 *
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * 逻辑删除标识设定
	 *
	 * @param brdeleteflag逻辑删除标识
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return brid;
	}
	
	/**
	 * 资产所属树根节点实体标识取得
	 * @return 资产所属树根节点实体标识
	 */
	public Integer getEirootmark() {
		return eirootmark;
	}
	
	/**
	 * 资产所属树根节点实体标识设定
	 *
	 * @param eirootmark 资产所属树根节点实体标识
	 */
	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}

}
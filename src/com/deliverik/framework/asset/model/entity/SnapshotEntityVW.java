/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
  * 概述: 快照关系表实体
  * 功能描述: 快照关系表实体
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
@Entity
public class SnapshotEntityVW implements Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/** 逻辑主键 */
	@Id	
	protected Integer srid;

	/** DomainID */
	protected Integer srdomainid;

	/** 扩展算法类型 */
	protected String srarithmetictype;

	/** Domain版本 */
	protected Integer srdomainversion;

	/** 源资产ID */
	protected Integer srpareiid;

	/** 源资产大版本 */
	protected Integer srparversion;

	/** 源资产小版本 */
	protected Integer srparsmallversion;
	
	/** 源资产Einame */
	protected String srpareiname;

	/** 源资产Eilabel */
	protected String srpareilabel;

	/** 目的资产ID */
	protected Integer srcldeiid;

	/** 目的资产大版本 */
	protected Integer srcldversion;

	/** 目的资产小版本 */
	protected Integer srcldsmallversion;
	
	/** 目的资产Einame */
	protected String srcldeiname;

	/** 目的资产Eilabel */
	protected String srcldeilabel;

	/** 创建时间 */
	protected String srcreatetime;

	/** 资产关系项 */
	protected String srassetrelation;
	
	/** 逻辑删除标识 */
	protected String deleteflag;
		
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
	 * 逻辑主键取得
	 *
	 * @return 逻辑主键
	 */
	public Integer getSrid() {
		return srid;
	}

	/**
	 * 逻辑主键设定
	 *
	 * @param srid逻辑主键
	 */
	public void setSrid(Integer srid) {
		this.srid = srid;
	}

	/**
	 * DomainID取得
	 *
	 * @return DomainID
	 */
	public Integer getSrdomainid() {
		return srdomainid;
	}

	/**
	 * DomainID设定
	 *
	 * @param srdomainidDomainID
	 */
	public void setSrdomainid(Integer srdomainid) {
		this.srdomainid = srdomainid;
	}

	/**
	 * 扩展算法类型取得
	 *
	 * @return 扩展算法类型
	 */
	public String getSrarithmetictype() {
		return srarithmetictype;
	}

	/**
	 * 扩展算法类型设定
	 *
	 * @param srarithmetictype扩展算法类型
	 */
	public void setSrarithmetictype(String srarithmetictype) {
		this.srarithmetictype = srarithmetictype;
	}

	/**
	 * Domain版本取得
	 *
	 * @return Domain版本
	 */
	public Integer getSrdomainversion() {
		return srdomainversion;
	}

	/**
	 * Domain版本设定
	 *
	 * @param srdomainversionDomain版本
	 */
	public void setSrdomainversion(Integer srdomainversion) {
		this.srdomainversion = srdomainversion;
	}

	/**
	 * 源资产ID取得
	 *
	 * @return 源资产ID
	 */
	public Integer getSrpareiid() {
		return srpareiid;
	}

	/**
	 * 源资产ID设定
	 *
	 * @param srpareiid源资产ID
	 */
	public void setSrpareiid(Integer srpareiid) {
		this.srpareiid = srpareiid;
	}

	/**
	 * 源资产大版本取得
	 *
	 * @return 源资产大版本
	 */
	public Integer getSrparversion() {
		return srparversion;
	}

	/**
	 * 源资产大版本设定
	 *
	 * @param srparversion源资产大版本
	 */
	public void setSrparversion(Integer srparversion) {
		this.srparversion = srparversion;
	}

	/**
	 * 源资产小版本取得
	 *
	 * @return 源资产小版本
	 */
	public Integer getSrparsmallversion() {
		return srparsmallversion;
	}

	/**
	 * 源资产小版本设定
	 *
	 * @param srparsmallversion源资产小版本
	 */
	public void setSrparsmallversion(Integer srparsmallversion) {
		this.srparsmallversion = srparsmallversion;
	}

	/**
	 * 目的资产ID取得
	 *
	 * @return 目的资产ID
	 */
	public Integer getSrcldeiid() {
		return srcldeiid;
	}

	/**
	 * 目的资产ID设定
	 *
	 * @param srcldeiid目的资产ID
	 */
	public void setSrcldeiid(Integer srcldeiid) {
		this.srcldeiid = srcldeiid;
	}

	/**
	 * 目的资产大版本取得
	 *
	 * @return 目的资产大版本
	 */
	public Integer getSrcldversion() {
		return srcldversion;
	}

	/**
	 * 目的资产大版本设定
	 *
	 * @param srcldversion目的资产大版本
	 */
	public void setSrcldversion(Integer srcldversion) {
		this.srcldversion = srcldversion;
	}

	/**
	 * 目的资产小版本取得
	 *
	 * @return 目的资产小版本
	 */
	public Integer getSrcldsmallversion() {
		return srcldsmallversion;
	}

	/**
	 * 目的资产小版本设定
	 *
	 * @param srcldsmallversion目的资产小版本
	 */
	public void setSrcldsmallversion(Integer srcldsmallversion) {
		this.srcldsmallversion = srcldsmallversion;
	}

	/**
	 * 创建时间取得
	 *
	 * @return 创建时间
	 */
	public String getSrcreatetime() {
		return srcreatetime;
	}

	/**
	 * 创建时间设定
	 *
	 * @param srcreatetime创建时间
	 */
	public void setSrcreatetime(String srcreatetime) {
		this.srcreatetime = srcreatetime;
	}

	/**
	 * 资产关系项取得
	 *
	 * @return 资产关系项
	 */
	public String getSrassetrelation() {
		return srassetrelation;
	}

	/**
	 * 资产关系项设定
	 *
	 * @param srassetrelation资产关系项
	 */
	public void setSrassetrelation(String srassetrelation) {
		this.srassetrelation = srassetrelation;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return srid;
	}

	public String getSrpareiname() {
		return srpareiname;
	}

	public void setSrpareiname(String srpareiname) {
		this.srpareiname = srpareiname;
	}

	public String getSrpareilabel() {
		return srpareilabel;
	}

	public void setSrpareilabel(String srpareilabel) {
		this.srpareilabel = srpareilabel;
	}

	public String getSrcldeiname() {
		return srcldeiname;
	}

	public void setSrcldeiname(String srcldeiname) {
		this.srcldeiname = srcldeiname;
	}

	public String getSrcldeilabel() {
		return srcldeilabel;
	}

	public void setSrcldeilabel(String srcldeilabel) {
		this.srcldeilabel = srcldeilabel;
	}
	
}
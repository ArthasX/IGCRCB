/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.entity;

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

import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.SnapshotRelationInfo;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.dao.hibernate.LogicalDelete;

/**
  * 概述: 快照关系表实体
  * 功能描述: 快照关系表实体
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SnapshotRelation")
public class SnapshotRelationTB extends BaseEntity implements Serializable,
		Cloneable, SnapshotRelationInfo,LogicalDelete  {

	/** 逻辑主键 */
	@Id
	@TableGenerator(
		name="SNAPSHOTRELATION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="SNAPSHOTRELATION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SNAPSHOTRELATION_TABLE_GENERATOR")
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

	/** 目的资产ID */
	protected Integer srcldeiid;

	/** 目的资产大版本 */
	protected Integer srcldversion;

	/** 目的资产小版本 */
	protected Integer srcldsmallversion;

	/** 关系类型（物理/逻辑） */
	protected String srtype;

	/** 关系说明 */
	protected String srdes;

	/** 创建时间 */
	protected String srcreatetime;

	/** 关联关系码 */
	protected String srraletioncode;

	/** 资产关系项 */
	protected String srassetrelation;
	
	/** 逻辑删除标识 */
	protected String deleteflag;
	
	/** 资产（正向）信息 */
	@ManyToOne
	@JoinColumn(name="srpareiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG749VW parEntityItemVW;

	/** 资产（反向）信息 */
	@ManyToOne
	@JoinColumn(name="srcldeiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG749VW cldEntityItemVW;
	
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
	 * 关系类型（物理/逻辑）取得
	 *
	 * @return 关系类型（物理/逻辑）
	 */
	public String getSrtype() {
		return srtype;
	}

	/**
	 * 关系类型（物理/逻辑）设定
	 *
	 * @param srtype关系类型（物理/逻辑）
	 */
	public void setSrtype(String srtype) {
		this.srtype = srtype;
	}

	/**
	 * 关系说明取得
	 *
	 * @return 关系说明
	 */
	public String getSrdes() {
		return srdes;
	}

	/**
	 * 关系说明设定
	 *
	 * @param srdes关系说明
	 */
	public void setSrdes(String srdes) {
		this.srdes = srdes;
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
	 * 关联关系码取得
	 *
	 * @return 关联关系码
	 */
	public String getSrraletioncode() {
		return srraletioncode;
	}

	/**
	 * 关联关系码设定
	 *
	 * @param srraletioncode关联关系码
	 */
	public void setSrraletioncode(String srraletioncode) {
		this.srraletioncode = srraletioncode;
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
	
	/**
	 * 资产(正向)信息取得
	 * @return 资产(正向)信息
	 */
	public IG749Info getParEntityItemVW() {
	    return parEntityItemVW;
	}
	
	/**
	 * 资产(反向)信息取得
	 * @return 资产(反向)信息
	 */
	public IG749Info getCldEntityItemVW() {
	    return cldEntityItemVW;
	}

}
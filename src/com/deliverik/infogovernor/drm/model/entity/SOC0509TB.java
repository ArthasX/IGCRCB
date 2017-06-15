/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.drm.model.SOC0509Info;

/**
  * 概述: 预案章节信息实体
  * 功能描述: 预案章节信息实体
  * 创建记录: 2016/07/07
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0509")
public class SOC0509TB extends BaseEntity implements Serializable,
		Cloneable, SOC0509Info {

	/** cid */
	@Id
	protected String cid;

	/** eid */
	protected String eid;

	/** pcid */
	protected String pcid;

	/** cname */
	protected String cname;

	/** clabel */
	protected String clabel;

	/** cdesc */
	protected String cdesc;

	/** cunit */
	protected String cunit;

	/** cstatus */
	protected String cstatus;

	/** 用作层级(标识在在树中的层级) */
	protected Integer cseq;

	/** ccategory */
	protected String ccategory;

	/** coption */
	protected String coption;

	/** cattach */
	protected String cattach;

	/** esyscoding */
	protected String esyscoding;

	protected String corder;
	/**
	 * cid取得
	 *
	 * @return cid
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * cid设定
	 *
	 * @param cid cid
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * eid取得
	 *
	 * @return eid
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * eid设定
	 *
	 * @param eid eid
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * pcid取得
	 *
	 * @return pcid
	 */
	public String getPcid() {
		return pcid;
	}

	/**
	 * pcid设定
	 *
	 * @param pcid pcid
	 */
	public void setPcid(String pcid) {
		this.pcid = pcid;
	}

	/**
	 * cname取得
	 *
	 * @return cname
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * cname设定
	 *
	 * @param cname cname
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * clabel取得
	 *
	 * @return clabel
	 */
	public String getClabel() {
		return clabel;
	}

	/**
	 * clabel设定
	 *
	 * @param clabel clabel
	 */
	public void setClabel(String clabel) {
		this.clabel = clabel;
	}

	/**
	 * cdesc取得
	 *
	 * @return cdesc
	 */
	public String getCdesc() {
		return cdesc;
	}

	/**
	 * cdesc设定
	 *
	 * @param cdesc cdesc
	 */
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	/**
	 * cunit取得
	 *
	 * @return cunit
	 */
	public String getCunit() {
		return cunit;
	}

	/**
	 * cunit设定
	 *
	 * @param cunit cunit
	 */
	public void setCunit(String cunit) {
		this.cunit = cunit;
	}

	/**
	 * cstatus取得
	 *
	 * @return cstatus
	 */
	public String getCstatus() {
		return cstatus;
	}

	/**
	 * cstatus设定
	 *
	 * @param cstatus cstatus
	 */
	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

	/** 用作层级(标识在在树中的层级) */
	public Integer getCseq() {
		return cseq;
	}

	/** 用作层级(标识在在树中的层级) */
	public void setCseq(Integer cseq) {
		this.cseq = cseq;
	}

	/**
	 * ccategory取得
	 *
	 * @return ccategory
	 */
	public String getCcategory() {
		return ccategory;
	}

	/**
	 * ccategory设定
	 *
	 * @param ccategory ccategory
	 */
	public void setCcategory(String ccategory) {
		this.ccategory = ccategory;
	}

	/**
	 * coption取得
	 *
	 * @return coption
	 */
	public String getCoption() {
		return coption;
	}

	/**
	 * coption设定
	 *
	 * @param coption coption
	 */
	public void setCoption(String coption) {
		this.coption = coption;
	}

	/**
	 * cattach取得
	 *
	 * @return cattach
	 */
	public String getCattach() {
		return cattach;
	}

	/**
	 * cattach设定
	 *
	 * @param cattach cattach
	 */
	public void setCattach(String cattach) {
		this.cattach = cattach;
	}

	/**
	 * esyscoding取得
	 *
	 * @return esyscoding
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * esyscoding设定
	 *
	 * @param esyscoding esyscoding
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getCorder() {
		return corder;
	}

	public void setCorder(String corder) {
		this.corder = corder;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return cid;
	}

}
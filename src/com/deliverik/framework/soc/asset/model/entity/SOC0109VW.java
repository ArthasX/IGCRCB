/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0109VWInfo;

/**
  * 概述: SOC0109VW实体
  * 功能描述: SOC0109VW实体
  * 创建记录: 2016/06/21
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0109VWPK.class)
@Table(name="SOC0109VW")
public class SOC0109VW extends BaseEntity implements Serializable,
		Cloneable, SOC0109VWInfo {

	/** 主键 */
	@Id
	protected Integer id;

	/** 资产模型属性ID                            */
	@Id
	protected String cid;

	/** 资产模型ID（外键）                        */
	protected String eid;

	/** 资产模型属性名称                          */
	protected String cname;

	/** CLABEL                                    */
	protected String clabel;

	/** 资产模型属性说明                          */
	protected String cdesc;

	/** 资产模型属性单位                          */
	protected String cunit;

	/** 资产模型属性状态                          */
	protected String cstatus;

	/** 资产模型属性是否显示标识（1显示，0不显示? */
	protected String cseq;

	/** 资产模型属性所属模型的模型分类            */
	protected String ccategory;

	/** 资产模型属性取值范围ID                    */
	protected String coption;

	/** 资产模型属性数据类型                      */
	protected String cattach;

	/** 资产模型属性所属模型层次码                */
	protected String esyscoding;
	/** 资产模型属性必填项 */
	protected String crequired;
	
	/** 排序标识 */
	protected Integer corder;
	
	/**
	 * @return the crequired
	 */
	public String getCrequired() {
		return crequired;
	}

	/**
	 * @param crequired the crequired to set
	 */
	public void setCrequired(String crequired) {
		this.crequired = crequired;
	}

	/**
	 * @return the corder
	 */
	public Integer getCorder() {
		return corder;
	}

	/**
	 * @param corder the corder to set
	 */
	public void setCorder(Integer corder) {
		this.corder = corder;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 主键设定
	 *
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 资产模型属性ID                           取得
	 *
	 * @return 资产模型属性ID                           
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * 资产模型属性ID                           设定
	 *
	 * @param cid 资产模型属性ID                           
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * 资产模型ID（外键）                       取得
	 *
	 * @return 资产模型ID（外键）                       
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * 资产模型ID（外键）                       设定
	 *
	 * @param eid 资产模型ID（外键）                       
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * 资产模型属性名称                         取得
	 *
	 * @return 资产模型属性名称                         
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * 资产模型属性名称                         设定
	 *
	 * @param cname 资产模型属性名称                         
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * CLABEL                                   取得
	 *
	 * @return CLABEL                                   
	 */
	public String getClabel() {
		return clabel;
	}

	/**
	 * CLABEL                                   设定
	 *
	 * @param clabel CLABEL                                   
	 */
	public void setClabel(String clabel) {
		this.clabel = clabel;
	}

	/**
	 * 资产模型属性说明                         取得
	 *
	 * @return 资产模型属性说明                         
	 */
	public String getCdesc() {
		return cdesc;
	}

	/**
	 * 资产模型属性说明                         设定
	 *
	 * @param cdesc 资产模型属性说明                         
	 */
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	/**
	 * 资产模型属性单位                         取得
	 *
	 * @return 资产模型属性单位                         
	 */
	public String getCunit() {
		return cunit;
	}

	/**
	 * 资产模型属性单位                         设定
	 *
	 * @param cunit 资产模型属性单位                         
	 */
	public void setCunit(String cunit) {
		this.cunit = cunit;
	}

	/**
	 * 资产模型属性状态                         取得
	 *
	 * @return 资产模型属性状态                         
	 */
	public String getCstatus() {
		return cstatus;
	}

	/**
	 * 资产模型属性状态                         设定
	 *
	 * @param cstatus 资产模型属性状态                         
	 */
	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

	/**
	 * 资产模型属性是否显示标识（1显示，0不显示?取得
	 *
	 * @return 资产模型属性是否显示标识（1显示，0不显示?
	 */
	public String getCseq() {
		return cseq;
	}

	/**
	 * 资产模型属性是否显示标识（1显示，0不显示?设定
	 *
	 * @param cseq 资产模型属性是否显示标识（1显示，0不显示?
	 */
	public void setCseq(String cseq) {
		this.cseq = cseq;
	}

	/**
	 * 资产模型属性所属模型的模型分类           取得
	 *
	 * @return 资产模型属性所属模型的模型分类           
	 */
	public String getCcategory() {
		return ccategory;
	}

	/**
	 * 资产模型属性所属模型的模型分类           设定
	 *
	 * @param ccategory 资产模型属性所属模型的模型分类           
	 */
	public void setCcategory(String ccategory) {
		this.ccategory = ccategory;
	}

	/**
	 * 资产模型属性取值范围ID                   取得
	 *
	 * @return 资产模型属性取值范围ID                   
	 */
	public String getCoption() {
		return coption;
	}

	/**
	 * 资产模型属性取值范围ID                   设定
	 *
	 * @param coption 资产模型属性取值范围ID                   
	 */
	public void setCoption(String coption) {
		this.coption = coption;
	}

	/**
	 * 资产模型属性数据类型                     取得
	 *
	 * @return 资产模型属性数据类型                     
	 */
	public String getCattach() {
		return cattach;
	}

	/**
	 * 资产模型属性数据类型                     设定
	 *
	 * @param cattach 资产模型属性数据类型                     
	 */
	public void setCattach(String cattach) {
		this.cattach = cattach;
	}

	/**
	 * 资产模型属性所属模型层次码               取得
	 *
	 * @return 资产模型属性所属模型层次码               
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产模型属性所属模型层次码               设定
	 *
	 * @param esyscoding 资产模型属性所属模型层次码               
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new SOC0109VWPK(id, cid);
	}

}
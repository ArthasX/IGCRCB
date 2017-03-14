/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.asset.model.IG612Info;

/**
  * 概述: 资产模型属性缺省值视图
  * 功能描述: 资产模型属性缺省值视图
  * 创建记录: 2012/07/20
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
public class IG612VW implements Serializable,
		Cloneable, IG612Info {

	/** 资产模型属性ID */
	@Id
	protected String cid;
	
	/** 资产模型ID */
	protected String eid;
	
	/** 资产模型属性名称 */
	protected String cname;
	
	/** 资产模型属性编号 */
	protected String clabel;

	/** 资产模型属性说明 */
	protected String cdesc;
	
	/** 资产模型属性单位 */
	protected String cunit;
	
	/** 资产模型属性状态（1启用，2停用） */
	protected String cstatus;
	
	/** 资产模型属性是否显示标识（1显示，0不显示） */
	protected String cseq;

	/** 资产模型属性类型 */
	protected String ccategory;
	
	/** 资产模型属性取值范围 */
	protected String coption;

	/** 资产模型属性附件标识 */
	protected String cattach;
	
	/** 资产模型层次码*/
	public String esyscoding;
	
	/** 资产模型属性必填项 */
	protected String crequired;
	
	/** 记录时间戳 */
	protected String fingerPrint;
	
	/** 资产模型属性默认值 */
	protected String cvalue;
	
	/**
	 * 资产模型层次码取得
	 * @return 资产模型层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}
	
	/**
	 * 资产模型层次码设定
	 *
	 * @param esyscoding 资产模型层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 资产模型属性ID取得
	 * @return 资产模型属性ID
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * 资产模型属性ID设定
	 *
	 * @param cid 资产模型属性ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * 资产模型ID设定
	 *
	 * @param eid 资产模型ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * 资产模型属性名称取得
	 * @return 资产模型属性名称
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * 资产模型属性名称设定
	 *
	 * @param cname 资产模型属性名称
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * 资产模型属性说明取得
	 * @return 资产模型属性说明
	 */
	public String getCdesc() {
		return cdesc;
	}

	/**
	 * 资产模型属性说明设定
	 *
	 * @param cdesc 资产模型属性说明
	 */
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	/**
	 * 资产模型属性单位取得
	 * @return 资产模型属性单位
	 */
	public String getCunit() {
		return cunit;
	}

	/**
	 * 资产模型属性单位设定
	 *
	 * @param cunit 资产模型属性单位
	 */
	public void setCunit(String cunit) {
		this.cunit = cunit;
	}

	/**
	 * 资产模型属性状态取得
	 * @return 资产模型属性状态
	 */
	public String getCstatus() {
		return cstatus;
	}

	/**
	 * 资产模型属性状态设定
	 *
	 * @param cstatus 资产模型属性状态
	 */
	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

	/**
	 * 资产模型属性是否显示标识取得
	 * @return 资产模型属性是否显示标识
	 */
	public String getCseq() {
		return cseq;
	}

	/**
	 * 资产模型属性是否显示标识设定
	 *
	 * @param cseq 资产模型属性是否显示标识
	 */
	public void setCseq(String cseq) {
		this.cseq = cseq;
	}

	/**
	 * 资产模型属性类型取得
	 * @return 资产模型属性类型 
	 */
	public String getCcategory() {
		return ccategory;
	}

	/**
	 * 资产模型属性类型设定
	 *
	 * @param ccategory 资产模型属性类型
	 */
	public void setCcategory(String ccategory) {
		this.ccategory = ccategory;
	}

	/**
	 * 资产模型属性编号取得
	 * @return 资产模型属性编号
	 */
	public String getClabel() {
		return clabel;
	}

	/**
	 * 资产模型属性编号设定
	 *
	 * @param clabel 资产模型属性编号
	 */
	public void setClabel(String clabel) {
		this.clabel = clabel;
	}

	/**
	 * 资产模型属性取值范围取得
	 * @return 资产模型属性取值范围
	 */
	public String getCoption() {
		return coption;
	}

	/**
	 * 资产模型属性取值范围设定
	 *
	 * @param coption 资产模型属性取值范围
	 */
	public void setCoption(String coption) {
		this.coption = coption;
	}

	/**
	 * 资产模型属性附件标识取得
	 * @return 资产模型属性附件标识
	 */
	public String getCattach() {
		return cattach;
	}

	/**
	 * 资产模型属性附件标识设定
	 *
	 * @param cattach 资产模型属性附件标识
	 */
	public void setCattach(String cattach) {
		this.cattach = cattach;
	}
	
	/**
	 * 资产模型属性必填项取得
	 * @return 资产模型属性必填项
	 */
	public String getCrequired() {
		return crequired;
	}
	
	/**
	 * 资产模型属性必填项设定
	 *
	 * @param crequired 资产模型属性必填项
	 */
	public void setCrequired(String crequired) {
		this.crequired = crequired;
	}

	/**
	 * 记录时间戳取得
	 * @return 记录时间戳
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}
	
	/**
	 * 记录时间戳设定
	 *
	 * @param crequired 记录时间戳
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	/**
	 * 资产模型属性默认值取得
	 * @return 资产模型属性默认值
	 */
	public String getCvalue() {
		return cvalue;
	}

	/**
	 * 资产模型属性默认值设定
	 *
	 * @param cvalue 资产模型属性默认值
	 */
	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}
	
}
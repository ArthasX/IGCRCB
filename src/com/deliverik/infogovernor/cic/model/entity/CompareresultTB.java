/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.cic.model.CompareresultInfo;

/**
  * 概述: 比对结果实体
  * 功能描述: 比对结果实体
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="compareresult")
public class CompareresultTB extends BaseEntity implements Serializable,
		Cloneable, CompareresultInfo {

	/** crid */
	@Id
	@GeneratedValue(generator = "crid")
	@GenericGenerator(name = "crid", strategy = "sequence", 
			parameters = { @Parameter(name = "sequence", 
						value = "compareresult_seq") })
	protected Integer crid;

	/** 比较对象表id */
	protected Integer fkCoid;

	/** 比较执行表ID */
	protected Integer fkCpid;

	/** eid */
	protected String eid;

	/** cid */
	protected String cid;

	/** 目标eiid */
	protected Integer teiid;

	/** 目标ciid */
	protected String tciid;

	/** 源eiid */
	protected Integer seiid;

	/** 源ciid */
	protected String sciid;

	/** 源属性值 */
	protected String svalue;

	/** 目标属性值 */
	protected String tvalue;

	/** 属性类型 */
	protected String configtype;

	/** 是否是基本属性 */
	protected Integer isbase;

	/** 父节点模型id */
	protected String peid;

	/**
	 * crid取得
	 *
	 * @return crid
	 */
	public Integer getCrid() {
		return crid;
	}

	/**
	 * crid设定
	 *
	 * @param crid crid
	 */
	public void setCrid(Integer crid) {
		this.crid = crid;
	}

	/**
	 * 比较对象表id取得
	 *
	 * @return 比较对象表id
	 */
	public Integer getFkCoid() {
		return fkCoid;
	}

	/**
	 * 比较对象表id设定
	 *
	 * @param fkCoid 比较对象表id
	 */
	public void setFkCoid(Integer fkCoid) {
		this.fkCoid = fkCoid;
	}

	/**
	 * 比较执行表ID取得
	 *
	 * @return 比较执行表ID
	 */
	public Integer getFkCpid() {
		return fkCpid;
	}

	/**
	 * 比较执行表ID设定
	 *
	 * @param fkCpid 比较执行表ID
	 */
	public void setFkCpid(Integer fkCpid) {
		this.fkCpid = fkCpid;
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
	 * 目标eiid取得
	 *
	 * @return 目标eiid
	 */
	public Integer getTeiid() {
		return teiid;
	}

	/**
	 * 目标eiid设定
	 *
	 * @param teiid 目标eiid
	 */
	public void setTeiid(Integer teiid) {
		this.teiid = teiid;
	}

	/**
	 * 目标ciid取得
	 *
	 * @return 目标ciid
	 */
	public String getTciid() {
		return tciid;
	}

	/**
	 * 目标ciid设定
	 *
	 * @param tciid 目标ciid
	 */
	public void setTciid(String tciid) {
		this.tciid = tciid;
	}

	/**
	 * 源eiid取得
	 *
	 * @return 源eiid
	 */
	public Integer getSeiid() {
		return seiid;
	}

	/**
	 * 源eiid设定
	 *
	 * @param seiid 源eiid
	 */
	public void setSeiid(Integer seiid) {
		this.seiid = seiid;
	}

	/**
	 * 源ciid取得
	 *
	 * @return 源ciid
	 */
	public String getSciid() {
		return sciid;
	}

	/**
	 * 源ciid设定
	 *
	 * @param sciid 源ciid
	 */
	public void setSciid(String sciid) {
		this.sciid = sciid;
	}

	/**
	 * 源属性值取得
	 *
	 * @return 源属性值
	 */
	public String getSvalue() {
		return svalue;
	}

	/**
	 * 源属性值设定
	 *
	 * @param svalue 源属性值
	 */
	public void setSvalue(String svalue) {
		this.svalue = svalue;
	}

	/**
	 * 目标属性值取得
	 *
	 * @return 目标属性值
	 */
	public String getTvalue() {
		return tvalue;
	}

	/**
	 * 目标属性值设定
	 *
	 * @param tvalue 目标属性值
	 */
	public void setTvalue(String tvalue) {
		this.tvalue = tvalue;
	}

	/**
	 * 属性类型取得
	 *
	 * @return 属性类型
	 */
	public String getConfigtype() {
		return configtype;
	}

	/**
	 * 属性类型设定
	 *
	 * @param configtype 属性类型
	 */
	public void setConfigtype(String configtype) {
		this.configtype = configtype;
	}

	/**
	 * 是否是基本属性取得
	 *
	 * @return 是否是基本属性
	 */
	public Integer getIsbase() {
		return isbase;
	}

	/**
	 * 是否是基本属性设定
	 *
	 * @param isbase 是否是基本属性
	 */
	public void setIsbase(Integer isbase) {
		this.isbase = isbase;
	}

	/**
	 * 父节点模型id取得
	 *
	 * @return 父节点模型id
	 */
	public String getPeid() {
		return peid;
	}

	/**
	 * 父节点模型id设定
	 *
	 * @param peid 父节点模型id
	 */
	public void setPeid(String peid) {
		this.peid = peid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	@Override
	public Serializable getPK() {
		return crid;
	}

}
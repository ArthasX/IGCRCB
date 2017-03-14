/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.drm.model.EmergencyResourceInfo;

/**
  * 概述: EmergencyResource实体
  * 功能描述: EmergencyResource实体
  * 创建记录: 2016/06/14
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="EmergencyResource")
public class EmergencyResourceTB extends BaseEntity implements Serializable,
		Cloneable, EmergencyResourceInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="EMERGENCYRESOURCE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="EMERGENCYRESOURCE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="EMERGENCYRESOURCE_TABLE_GENERATOR")

	protected Integer erid;
	
	/** 对应资产码 */
	protected String esyscoding;
	
	/** 对应资产属性cid */
	protected String ercids;
	
	/** 资源名称 */
	protected String ername;

	/** 资源描述 */
	protected String erdesc;

	/** 资源状态 */
	protected String erstatus;

	/** 资源编号 */
	protected String erlabel;

	/** 资源编码 */
	protected String ercode;

	/** 父级编码 */
	protected String erparcode;

	/** 录入时间 */
	protected String ercreatetime;

	/** 录入人id */
	protected String eruserid;

	/** 录入人姓名 */
	protected String erusername;

	/**
	 * @return the 对应资产属性cid
	 */
	public String getErcids() {
		return ercids;
	}

	/**
	 * @param ercids the ercids to set
	 */
	public void setErcids(String ercids) {
		this.ercids = ercids;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getErid() {
		return erid;
	}

	/**
	 * 主键设定
	 *
	 * @param erid 主键
	 */
	public void setErid(Integer erid) {
		this.erid = erid;
	}

	/**
	 * 资源名称取得
	 *
	 * @return 资源名称
	 */
	public String getErname() {
		return ername;
	}

	/**
	 * 资源名称设定
	 *
	 * @param ername 资源名称
	 */
	public void setErname(String ername) {
		this.ername = ername;
	}

	/**
	 * 资源描述取得
	 *
	 * @return 资源描述
	 */
	public String getErdesc() {
		return erdesc;
	}

	/**
	 * 资源描述设定
	 *
	 * @param erdesc 资源描述
	 */
	public void setErdesc(String erdesc) {
		this.erdesc = erdesc;
	}

	/**
	 * 资源状态取得
	 *
	 * @return 资源状态
	 */
	public String getErstatus() {
		return erstatus;
	}

	/**
	 * 资源状态设定
	 *
	 * @param erstatus 资源状态
	 */
	public void setErstatus(String erstatus) {
		this.erstatus = erstatus;
	}

	/**
	 * 资源编号取得
	 *
	 * @return 资源编号
	 */
	public String getErlabel() {
		return erlabel;
	}

	/**
	 * 资源编号设定
	 *
	 * @param erlabel 资源编号
	 */
	public void setErlabel(String erlabel) {
		this.erlabel = erlabel;
	}

	/**
	 * 资源编码取得
	 *
	 * @return 资源编码
	 */
	public String getErcode() {
		return ercode;
	}

	/**
	 * 资源编码设定
	 *
	 * @param ercode 资源编码
	 */
	public void setErcode(String ercode) {
		this.ercode = ercode;
	}

	/**
	 * 父级编码取得
	 *
	 * @return 父级编码
	 */
	public String getErparcode() {
		return erparcode;
	}

	/**
	 * 父级编码设定
	 *
	 * @param erparcode 父级编码
	 */
	public void setErparcode(String erparcode) {
		this.erparcode = erparcode;
	}

	/**
	 * 录入时间取得
	 *
	 * @return 录入时间
	 */
	public String getErcreatetime() {
		return ercreatetime;
	}

	/**
	 * 录入时间设定
	 *
	 * @param ercreatetime 录入时间
	 */
	public void setErcreatetime(String ercreatetime) {
		this.ercreatetime = ercreatetime;
	}

	/**
	 * 录入人id取得
	 *
	 * @return 录入人id
	 */
	public String getEruserid() {
		return eruserid;
	}

	/**
	 * 录入人id设定
	 *
	 * @param eruserid 录入人id
	 */
	public void setEruserid(String eruserid) {
		this.eruserid = eruserid;
	}

	/**
	 * 录入人姓名取得
	 *
	 * @return 录入人姓名
	 */
	public String getErusername() {
		return erusername;
	}

	/**
	 * 录入人姓名设定
	 *
	 * @param erusername 录入人姓名
	 */
	public void setErusername(String erusername) {
		this.erusername = erusername;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return erid;
	}

	/**
	 * @return the esyscoding
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * @param 对应资产码  the esyscoding to set
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

}
/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.room.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.room.model.CompareTemplateInfo;


/**
  * 概述: compareTemplate实体
  * 功能描述: compareTemplate实体
  * 创建记录: 2011/05/24
  * 修改记录: 2013-05-30 XuDongWang
  */
@SuppressWarnings("serial")
@Entity
@Table(name="compareTemplate")
public class CompareTemplateTB extends BaseEntity implements Serializable,
		Cloneable, CompareTemplateInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="COMPARETEMPLATE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="COMPARETEMPLATE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="COMPARETEMPLATE_TABLE_GENERATOR")
	protected Integer ctpid;

	/** 类别ID */
	protected String ctcategory;
	
	/** 类型 */
	protected String cttype;
	
	/**设备资产ID*/
	protected String cteiid;
	
	/**设备x位置坐标*/
	protected String ctx;
	
	/**设备y位置坐标*/
	protected String cty;
	
	/**设备所属地板x*/
	protected String ctfloorx;
	
	/**设备所属地板y*/
	protected String ctfloory;
	
	/**设备所属层*/
	protected String ctindex;
	
	/** 名称 */
	protected String ctName;
	
	/** 说明 */
	protected String ctInfo;
	
	/** 所属分区编号 */
	protected String ctZoneId;
	

	public Serializable getPK() {
		return ctpid;
	}

	/**
	 * ctpid取得
	 *
	 * @return ctpid ctpid
	 */
	public Integer getCtpid() {
		return ctpid;
	}
	
	/**
	 * ctcategory取得
	 *
	 * @return ctcategory ctcategory
	 */
	public String getCtcategory() {
		return ctcategory;
	}

	/**
	 * cttype取得
	 *
	 * @return cttype cttype
	 */
	public String getCttype() {
		return cttype;
	}

	/**
	 * cteiid取得
	 *
	 * @return cteiid cteiid
	 */
	public String getCteiid() {
		return cteiid;
	}

	/**
	 * ctx取得
	 *
	 * @return ctx ctx
	 */
	public String getCtx() {
		return ctx;
	}

	/**
	 * cty取得
	 *
	 * @return cty cty
	 */
	public String getCty() {
		return cty;
	}

	/**
	 * ctfloorx取得
	 *
	 * @return ctfloorx ctfloorx
	 */
	public String getCtfloorx() {
		return ctfloorx;
	}

	/**
	 * ctfloory取得
	 *
	 * @return ctfloory ctfloory
	 */
	public String getCtfloory() {
		return ctfloory;
	}

	/**
	 * ctpid设定
	 *
	 * @param ctpid ctpid
	 */
	public void setCtpid(Integer ctpid) {
		this.ctpid = ctpid;
	}
	
	/**
	 * ctcategory设定
	 *
	 * @param ctcategory ctcategory
	 */
	public void setCtcategory(String ctcategory) {
		this.ctcategory = ctcategory;
	}

	/**
	 * cttype设定
	 *
	 * @param cttype cttype
	 */
	public void setCttype(String cttype) {
		this.cttype = cttype;
	}

	/**
	 * cteiid设定
	 *
	 * @param cteiid cteiid
	 */
	public void setCteiid(String cteiid) {
		this.cteiid = cteiid;
	}

	/**
	 * ctx设定
	 *
	 * @param ctx ctx
	 */
	public void setCtx(String ctx) {
		this.ctx = ctx;
	}

	/**
	 * cty设定
	 *
	 * @param cty cty
	 */
	public void setCty(String cty) {
		this.cty = cty;
	}

	/**
	 * ctfloorx设定
	 *
	 * @param ctfloorx ctfloorx
	 */
	public void setCtfloorx(String ctfloorx) {
		this.ctfloorx = ctfloorx;
	}

	/**
	 * ctfloory设定
	 *
	 * @param ctfloory ctfloory
	 */
	public void setCtfloory(String ctfloory) {
		this.ctfloory = ctfloory;
	}
	
	/**
	 * ctindex设定
	 *
	 * @param ctindex ctindex
	 */
	public String getCtindex() {
		return ctindex;
	}
	
	/**
	 * ctindex设定
	 *
	 * @param ctindex ctindex
	 */
	public void setCtindex(String ctindex) {
		this.ctindex = ctindex;
	}

	/**
	 * ctName取得
	 *
	 * @return ctName ctName
	 */
	public String getCtName() {
		return ctName;
	}

	/**
	 * ctName设定
	 *
	 * @param ctName ctName
	 */
	public void setCtName(String ctName) {
		this.ctName = ctName;
	}

	/**
	 * ctInfo取得
	 *
	 * @return ctInfo ctInfo
	 */
	public String getCtInfo() {
		return ctInfo;
	}

	/**
	 * ctInfo设定
	 *
	 * @param ctInfo ctInfo
	 */
	public void setCtInfo(String ctInfo) {
		this.ctInfo = ctInfo;
	}

	/**
	 * ctZoneId取得
	 *
	 * @return ctZoneId ctZoneId
	 */
	public String getCtZoneId() {
		return ctZoneId;
	}

	/**
	 * ctZoneId设定
	 *
	 * @param ctZoneId ctZoneId
	 */
	public void setCtZoneId(String ctZoneId) {
		this.ctZoneId = ctZoneId;
	}
}
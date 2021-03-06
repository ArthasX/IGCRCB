/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.room.model.condition;

import java.io.Serializable;

/**
  * 概述: compareTemplate检索条件实现
  * 功能描述: compareTemplate检索条件实现
  * 创建记录: 2011/05/23
  * 修改记录: 
  */
public class CompareTemplateSearchCondImpl implements CompareTemplateSearchCond {
	protected Integer ctid;

	/** 类别ID */
	protected String category;

	/** 类型 */
	protected String type;
	
	/** 类型为机柜 */
	protected String cabtype;

	/** 横向宽度 */
	protected String xwidth;

	/** 纵向宽度 */
	protected String ywidth;

	/** 值 */
	protected String value;
	
	/** 图例数组 */
	protected String[] legendArray;

	/**设备资产ID*/
	protected String cteiid;
	
	/** 类型不等于  */
	protected String netype;
	
	/** 所属分区编号 */
	protected String ctZoneId;
	
	/** type不为zone和naf标识	"ok":不为zone和naf */
	protected String notZoneAndNotNafFlag;
	
	/**设备所属地板x*/
	protected String ctfloorx;
	
	/**设备所属地板y*/
	protected String ctfloory;
	
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getCtid() {
		return ctid;
	}

	/**
	 * 主键设定
	 *
	 * @param ctid 主键
	 */
	public void setCtid(Integer ctid) {
		this.ctid = ctid;
	}

	/**
	 * 类别ID取得
	 *
	 * @return 类别ID
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * 类别ID设定
	 *
	 * @param category 类别ID
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * 类型取得
	 *
	 * @return 类型
	 */
	public String getType() {
		return type;
	}

	/**
	 * 类型设定
	 *
	 * @param type 类型
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 横向宽度取得
	 *
	 * @return 横向宽度
	 */
	public String getXwidth() {
		return xwidth;
	}

	/**
	 * 横向宽度设定
	 *
	 * @param xwidth 横向宽度
	 */
	public void setXwidth(String xwidth) {
		this.xwidth = xwidth;
	}

	/**
	 * 纵向宽度取得
	 *
	 * @return 纵向宽度
	 */
	public String getYwidth() {
		return ywidth;
	}

	/**
	 * 纵向宽度设定
	 *
	 * @param ywidth 纵向宽度
	 */
	public void setYwidth(String ywidth) {
		this.ywidth = ywidth;
	}

	/**
	 * 值取得
	 *
	 * @return 值
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 值设定
	 *
	 * @param value 值
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return ctid;
	}

	public String getCabtype() {
		return cabtype;
	}

	public void setCabtype(String cabtype) {
		this.cabtype = cabtype;
	}

	public String[] getLegendArray() {
		return legendArray;
	}

	public void setLegendArray(String[] legendArray) {
		this.legendArray = legendArray;
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
	 * cteiid设定
	 *
	 * @param cteiid cteiid
	 */
	public void setCteiid(String cteiid) {
		this.cteiid = cteiid;
	}
	
	/**
	 * netype取得
	 *
	 * @return netype netype
	 */
	public String getNetype() {
		return netype;
	}

	/**
	 * netype设定
	 *
	 * @param netype netype
	 */
	public void setNetype(String netype) {
		this.netype = netype;
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

	/**
	 * type不为zone和naf标识 取得
	 *
	 * @return notZoneAndNotNafFlag
	 */
	public String getNotZoneAndNotNafFlag() {
		return notZoneAndNotNafFlag;
	}

	/**
	 * type不为zone和naf标识 设定
	 *
	 * @param notZoneAndNotNafFlag
	 */
	public void setNotZoneAndNotNafFlag(String notZoneAndNotNafFlag) {
		this.notZoneAndNotNafFlag = notZoneAndNotNafFlag;
	}

	public String getCtfloorx() {
		return ctfloorx;
	}

	public void setCtfloorx(String ctfloorx) {
		this.ctfloorx = ctfloorx;
	}

	public String getCtfloory() {
		return ctfloory;
	}

	public void setCtfloory(String ctfloory) {
		this.ctfloory = ctfloory;
	}
	
	
	
	
}
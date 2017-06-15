/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.IndicatorLightsXmlInfo;

/**
  * 概述: 告警系统显示区域表实体
  * 功能描述: 告警系统显示区域表实体
  * 创建记录: 2014/03/05
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IndicatorLightsXml")
public class IndicatorLightsXmlTB extends BaseEntity implements Serializable,
		Cloneable, IndicatorLightsXmlInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="INDICATORLIGHTSXML_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="INDICATORLIGHTSXML_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="INDICATORLIGHTSXML_TABLE_GENERATOR")
	protected Integer ixid;

	/** 区域名称 */
	protected String ixtitle;

	/** 位置X坐标 */
	protected String ixplacex;

	/** 位置Y坐标 */
	protected String ixplacey;

	/** 宽度 */
	protected Integer ixwidth;

	/** 高度 */
	protected Integer ixheight;

	/** rotation */
	protected String rotation;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getIxid() {
		return ixid;
	}

	/**
	 * 主键设定
	 *
	 * @param ixid 主键
	 */
	public void setIxid(Integer ixid) {
		this.ixid = ixid;
	}

	/**
	 * 区域名称取得
	 *
	 * @return 区域名称
	 */
	public String getIxtitle() {
		return ixtitle;
	}

	/**
	 * 区域名称设定
	 *
	 * @param ixtitle 区域名称
	 */
	public void setIxtitle(String ixtitle) {
		this.ixtitle = ixtitle;
	}

	/**
	 * 位置X坐标取得
	 *
	 * @return 位置X坐标
	 */
	public String getIxplacex() {
		return ixplacex;
	}

	/**
	 * 位置X坐标设定
	 *
	 * @param ixplacex 位置X坐标
	 */
	public void setIxplacex(String ixplacex) {
		this.ixplacex = ixplacex;
	}

	/**
	 * 位置Y坐标取得
	 *
	 * @return 位置Y坐标
	 */
	public String getIxplacey() {
		return ixplacey;
	}

	/**
	 * 位置Y坐标设定
	 *
	 * @param ixplacey 位置Y坐标
	 */
	public void setIxplacey(String ixplacey) {
		this.ixplacey = ixplacey;
	}

	/**
	 * 宽度取得
	 *
	 * @return 宽度
	 */
	public Integer getIxwidth() {
		return ixwidth;
	}

	/**
	 * 宽度设定
	 *
	 * @param ixwidth 宽度
	 */
	public void setIxwidth(Integer ixwidth) {
		this.ixwidth = ixwidth;
	}

	/**
	 * 高度取得
	 *
	 * @return 高度
	 */
	public Integer getIxheight() {
		return ixheight;
	}

	/**
	 * 高度设定
	 *
	 * @param ixheight 高度
	 */
	public void setIxheight(Integer ixheight) {
		this.ixheight = ixheight;
	}

	/**
	 * rotation取得
	 *
	 * @return rotation
	 */
	public String getRotation() {
		return rotation;
	}

	/**
	 * rotation设定
	 *
	 * @param rotation rotation
	 */
	public void setRotation(String rotation) {
		this.rotation = rotation;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return ixid;
	}

}
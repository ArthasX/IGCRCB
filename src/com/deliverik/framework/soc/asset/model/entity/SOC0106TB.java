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
import com.deliverik.framework.soc.asset.model.SOC0106Info;

/**
  * 概述: 审计待处理任务临时实体
  * 功能描述: 审计待处理任务临时实体
  * 创建记录: 2012/07/31
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0106")
public class SOC0106TB extends BaseEntity implements Serializable,
		Cloneable, SOC0106Info {

	/** awtId */
	@Id
	@TableGenerator(
		name="SOC0106_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="SOC0106_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SOC0106_TABLE_GENERATOR")
	protected Integer awtId;

	/** 文件名字 */
	protected String fileName;

	/** batName */
	protected String batName;

	/** 实体名字 */
	protected String eiName;

	/** 实体Id */
	protected String auwtId;

	/**
	 * awtId取得
	 *
	 * @return awtId
	 */
	public Integer getAwtId() {
		return awtId;
	}

	/**
	 * awtId设定
	 *
	 * @param awtId awtId
	 */
	public void setAwtId(Integer awtId) {
		this.awtId = awtId;
	}

	/**
	 * 文件名字取得
	 *
	 * @return 文件名字
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * 文件名字设定
	 *
	 * @param fileName 文件名字
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * batName取得
	 *
	 * @return batName
	 */
	public String getBatName() {
		return batName;
	}

	/**
	 * batName设定
	 *
	 * @param batName batName
	 */
	public void setBatName(String batName) {
		this.batName = batName;
	}

	/**
	 * 实体名字取得
	 *
	 * @return 实体名字
	 */
	public String getEiName() {
		return eiName;
	}

	/**
	 * 实体名字设定
	 *
	 * @param eiName 实体名字
	 */
	public void setEiName(String eiName) {
		this.eiName = eiName;
	}

	/**
	 * 实体Id取得
	 *
	 * @return 实体Id
	 */
	public String getAuwtId() {
		return auwtId;
	}

	/**
	 * 实体Id设定
	 *
	 * @param auwtId 实体Id
	 */
	public void setAuwtId(String auwtId) {
		this.auwtId = auwtId;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return awtId;
	}

}
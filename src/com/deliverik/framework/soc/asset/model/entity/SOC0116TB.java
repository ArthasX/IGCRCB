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
import com.deliverik.framework.soc.asset.model.SOC0116Info;

/**
  * 概述: EiWaitTaskTemp实体
  * 功能描述: EiWaitTaskTemp实体
  * 创建记录: 2012/07/30
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0116")
public class SOC0116TB extends BaseEntity implements Serializable,
		Cloneable, SOC0116Info {

	/** ewtId */
	@Id
	@TableGenerator(
		name="SOC0116_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="SOC0116_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SOC0116_TABLE_GENERATOR")
	protected Integer ewtId;

	/** 文件名字 */
	protected String fileName;

	/** userId */
	protected String userId;

	/** 实体名字 */
	protected String eiName;

	/** 实体Id */
	protected String eitId;

	/**
	 * ewtId取得
	 *
	 * @return ewtId
	 */
	public Integer getEwtId() {
		return ewtId;
	}

	/**
	 * ewtId设定
	 *
	 * @param ewtId ewtId
	 */
	public void setEwtId(Integer ewtId) {
		this.ewtId = ewtId;
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
	 * userId取得
	 *
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * userId设定
	 *
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setEitId(String eitId) {
		this.eitId = eitId;
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
	public String getEitId() {
		return eitId;
	}

	/**
	 * 实体Id设定
	 *
	 * @param eiId 实体Id
	 */
	public void setEiId(String eitId) {
		this.eitId = eitId;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return ewtId;
	}

}
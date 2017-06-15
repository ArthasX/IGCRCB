/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rpt.model.SOC0423Info;

/**
  * 概述: 容量对象表实体
  * 功能描述: 容量对象表实体
  * 创建记录: 2012/08/09
  * 修改记录: 将CapacityObjectListTB表名改为SOC0423TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0423")
public class SOC0423TB extends BaseEntity implements Serializable,
		Cloneable, SOC0423Info {

	/** 主键 */
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "identity")
	protected Integer id;

	/** 名称 */
	protected String name;

	/** 对象类型 */
	protected String objectType;

	/** 对象名称 */
	protected String objectName;
	
	/** 错误代码 */
	protected Integer errorNum;
	
	/** 告警代码 */
	protected Integer warningNum;
	
	/** 状态 */
	protected Integer status;

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
	 * 名称取得
	 *
	 * @return 名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 名称设定
	 *
	 * @param name 名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 对象类型取得
	 *
	 * @return 对象类型
	 */
	public String getObjectType() {
		return objectType;
	}

	/**
	 * 对象类型设定
	 *
	 * @param objectType 对象类型
	 */
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	/**
	 * 对象名称取得
	 *
	 * @return 对象名称
	 */
	public String getObjectName() {
		return objectName;
	}

	/**
	 * 对象名称设定
	 *
	 * @param objectName 对象名称
	 */
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return id;
	}

	/**
	 * 错误代码取得
	 *
	 * @return errorNum 错误代码
	 */
	public Integer getErrorNum() {
		return errorNum;
	}

	/**
	 * 错误代码设定
	 *
	 * @param errorNum 错误代码
	 */
	public void setErrorNum(Integer errorNum) {
		this.errorNum = errorNum;
	}

	/**
	 * 告警代码取得
	 *
	 * @return warningNum 告警代码
	 */
	public Integer getWarningNum() {
		return warningNum;
	}

	/**
	 * 告警代码设定
	 *
	 * @param warningNum 告警代码
	 */
	public void setWarningNum(Integer warningNum) {
		this.warningNum = warningNum;
	}

	/**
	 * 状态取得
	 *
	 * @return status 状态
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 状态设定
	 *
	 * @param status 状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

}
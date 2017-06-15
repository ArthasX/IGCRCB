/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rpt.model.SOC0424Info;

/**
  * 概述: 报告类型表实体
  * 功能描述: 报告类型表实体
  * 创建记录: 2012/07/18
  * 修改记录: 2012/08/09 将ReportTypeTB表名改为SOC0424TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0424")
public class SOC0424TB extends BaseEntity implements Serializable,
		Cloneable, SOC0424Info {

	/** 报名字 */
	@Id
	protected String reportName;

	/** 类型 */
	protected String rtType;

	/** 存储类型 */
	protected String storageType;

	/**
	 * 报名字取得
	 *
	 * @return 报名字
	 */
	public String getReportName() {
		return reportName;
	}

	/**
	 * 报名字设定
	 *
	 * @param reportName 报名字
	 */
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	/**
	 * 类型取得
	 *
	 * @return 类型
	 */
	public String getRtType() {
		return rtType;
	}

	/**
	 * 类型设定
	 *
	 * @param rtType 类型
	 */
	public void setRtType(String rtType) {
		this.rtType = rtType;
	}

	/**
	 * 存储类型取得
	 *
	 * @return 存储类型
	 */
	public String getStorageType() {
		return storageType;
	}

	/**
	 * 存储类型设定
	 *
	 * @param storageType 存储类型
	 */
	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}
	@Override
	public Serializable getPK() {
		return null;
	}


}
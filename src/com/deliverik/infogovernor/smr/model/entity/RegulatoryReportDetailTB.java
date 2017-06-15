/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.smr.model.RegulatoryReportDetailInfo;

/**
  * 概述: 报表填报明细表实体
  * 功能描述: 报表填报明细表实体
  * 创建记录: 2013/07/18
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="RegulatoryReportDetail")
public class RegulatoryReportDetailTB extends BaseEntity implements Serializable,
		Cloneable, RegulatoryReportDetailInfo {

	/** 自增ID */
	@Id
	@TableGenerator(
		name="REGULATORYREPORTDETAIL_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="REGULATORYREPORTDETAIL_SEQUENCE", initialValue=1000, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="REGULATORYREPORTDETAIL_TABLE_GENERATOR")
	protected Integer detailID;

	/** 填报实例ID */
	protected Integer instanceID;

	/** 流程ID */
	protected Integer prid;
	

	/**
	 * 自增ID取得
	 *
	 * @return 自增ID
	 */
	public Integer getDetailID() {
		return detailID;
	}

	/**
	 * 自增ID设定
	 *
	 * @param detailID 自增ID
	 */
	public void setDetailID(Integer detailID) {
		this.detailID = detailID;
	}

	/**
	 * 填报实例ID取得
	 *
	 * @return 填报实例ID
	 */
	public Integer getInstanceID() {
		return instanceID;
	}

	/**
	 * 填报实例ID设定
	 *
	 * @param instanceID 填报实例ID
	 */
	public void setInstanceID(Integer instanceID) {
		this.instanceID = instanceID;
	}

	/**
	 * 流程ID取得
	 *
	 * @return 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 *
	 * @param prid 流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return detailID;
	}

}
/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rpt.model.SOC0410Info;

/**
  * 概述: 存储lun实时表实体
  * 功能描述: 存储lun实时表实体
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将PVStorageRealTimeTB表名改为SOC0410TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0410")
public class SOC0410TB extends BaseEntity implements Serializable,
		Cloneable, SOC0410Info {

	/** 主键 */
	@Id
	@TableGenerator(
		name="PVSTORAGEREALTIME_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="PVSTORAGEREALTIME_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="PVSTORAGEREALTIME_TABLE_GENERATOR")
	protected Integer psId;

	/** 存储序列号 */
	protected String sName;

	/** lunid */
	protected String lunid;

	/** pv大小 */
	protected Integer pvSize;

	/** 是否被分配 */
	protected String isUsed;

	/** 日期 */
	protected String createDate;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPsId() {
		return psId;
	}

	/**
	 * 主键设定
	 *
	 * @param psId 主键
	 */
	public void setPsId(Integer psId) {
		this.psId = psId;
	}

	/**
	 * 存储序列号取得
	 *
	 * @return 存储序列号
	 */
	public String getSName() {
		return sName;
	}

	/**
	 * 存储序列号设定
	 *
	 * @param sName 存储序列号
	 */
	public void setSName(String sName) {
		this.sName = sName;
	}

	/**
	 * lunid取得
	 *
	 * @return lunid
	 */
	public String getLunid() {
		return lunid;
	}

	/**
	 * lunid设定
	 *
	 * @param lunid lunid
	 */
	public void setLunid(String lunid) {
		this.lunid = lunid;
	}

	/**
	 * pv大小取得
	 *
	 * @return pv大小
	 */
	public Integer getPvSize() {
		return pvSize;
	}

	/**
	 * pv大小设定
	 *
	 * @param pvSize pv大小
	 */
	public void setPvSize(Integer pvSize) {
		this.pvSize = pvSize;
	}

	/**
	 * 是否被分配取得
	 *
	 * @return 是否被分配
	 */
	public String getIsUsed() {
		return isUsed;
	}

	/**
	 * 是否被分配设定
	 *
	 * @param isUsed 是否被分配
	 */
	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}

	/**
	 * 日期取得
	 *
	 * @return 日期
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * 日期设定
	 *
	 * @param createDate 日期
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return psId;
	}

}
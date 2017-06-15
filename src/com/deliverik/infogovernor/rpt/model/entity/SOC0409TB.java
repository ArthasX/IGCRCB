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
import com.deliverik.infogovernor.rpt.model.SOC0409Info;

/**
  * 概述: 主机pv实时表实体
  * 功能描述: 主机pv实时表实体
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将PVHostRealTimeTB表名改为SOC0409TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0409")
public class SOC0409TB extends BaseEntity implements Serializable,
		Cloneable, SOC0409Info {

	/** 主键 */
	@Id
	@TableGenerator(
		name="PVHOSTREALTIME_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="PVHOSTREALTIME_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="PVHOSTREALTIME_TABLE_GENERATOR")
	protected Integer phId;

	/** 存储序列号 */
	protected String sName;

	/** 主机名 */
	protected String hostName;

	/** 卷组名 */
	protected String vgName;

	/** 日期 */
	protected String createDate;

	/** lunid */
	protected String lunid;

	/** pv大小 */
	protected Integer pvSize;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPhId() {
		return phId;
	}

	/**
	 * 主键设定
	 *
	 * @param phId 主键
	 */
	public void setPhId(Integer phId) {
		this.phId = phId;
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
	 * 主机名取得
	 *
	 * @return 主机名
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * 主机名设定
	 *
	 * @param hostName 主机名
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	/**
	 * 卷组名取得
	 *
	 * @return 卷组名
	 */
	public String getVgName() {
		return vgName;
	}

	/**
	 * 卷组名设定
	 *
	 * @param vgName 卷组名
	 */
	public void setVgName(String vgName) {
		this.vgName = vgName;
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
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return phId;
	}

}
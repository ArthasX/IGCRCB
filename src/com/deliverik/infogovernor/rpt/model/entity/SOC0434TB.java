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
import com.deliverik.infogovernor.rpt.model.SOC0434Info;

/**
  * 概述: PVVIO实体
  * 功能描述: PVVIO实体
  * 创建记录: 2012/08/20
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="PVVIO")
public class SOC0434TB extends BaseEntity implements Serializable,
		Cloneable, SOC0434Info {

	/** PVVID */
	@Id
	@TableGenerator(
		name="PVVIO_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="PVVIO_SEQUENCE", initialValue=1000, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="PVVIO_TABLE_GENERATOR")
	protected Integer PVVID;

	/** SN */
	protected String SN;

	/** PVID */
	protected String PVID;

	/** SNAME */
	protected String SNAME;

	/** LUNID */
	protected String LUNID;

	/** PVSIZE */
	protected Integer PVSIZE;

	/** ISUSED */
	protected String ISUSED;

	/** CREATEDATE */
	protected String CREATEDATE;

	/**
	 * PVVID取得
	 *
	 * @return PVVID
	 */
	public Integer getPVVID() {
		return PVVID;
	}

	/**
	 * PVVID设定
	 *
	 * @param PVVID PVVID
	 */
	public void setPVVID(Integer PVVID) {
		this.PVVID = PVVID;
	}

	/**
	 * SN取得
	 *
	 * @return SN
	 */
	public String getSN() {
		return SN;
	}

	/**
	 * SN设定
	 *
	 * @param SN SN
	 */
	public void setSN(String SN) {
		this.SN = SN;
	}

	/**
	 * PVID取得
	 *
	 * @return PVID
	 */
	public String getPVID() {
		return PVID;
	}

	/**
	 * PVID设定
	 *
	 * @param PVID PVID
	 */
	public void setPVID(String PVID) {
		this.PVID = PVID;
	}

	/**
	 * SNAME取得
	 *
	 * @return SNAME
	 */
	public String getSNAME() {
		return SNAME;
	}

	/**
	 * SNAME设定
	 *
	 * @param SNAME SNAME
	 */
	public void setSNAME(String SNAME) {
		this.SNAME = SNAME;
	}

	/**
	 * LUNID取得
	 *
	 * @return LUNID
	 */
	public String getLUNID() {
		return LUNID;
	}

	/**
	 * LUNID设定
	 *
	 * @param LUNID LUNID
	 */
	public void setLUNID(String LUNID) {
		this.LUNID = LUNID;
	}

	/**
	 * PVSIZE取得
	 *
	 * @return PVSIZE
	 */
	public Integer getPVSIZE() {
		return PVSIZE;
	}

	/**
	 * PVSIZE设定
	 *
	 * @param PVSIZE PVSIZE
	 */
	public void setPVSIZE(Integer PVSIZE) {
		this.PVSIZE = PVSIZE;
	}

	/**
	 * ISUSED取得
	 *
	 * @return ISUSED
	 */
	public String getISUSED() {
		return ISUSED;
	}

	/**
	 * ISUSED设定
	 *
	 * @param ISUSED ISUSED
	 */
	public void setISUSED(String ISUSED) {
		this.ISUSED = ISUSED;
	}

	/**
	 * CREATEDATE取得
	 *
	 * @return CREATEDATE
	 */
	public String getCREATEDATE() {
		return CREATEDATE;
	}

	/**
	 * CREATEDATE设定
	 *
	 * @param CREATEDATE CREATEDATE
	 */
	public void setCREATEDATE(String CREATEDATE) {
		this.CREATEDATE = CREATEDATE;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return PVVID;
	}

}
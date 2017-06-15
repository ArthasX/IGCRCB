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
import com.deliverik.infogovernor.smr.model.RemindInfoInfo;

/**
  * 概述: 提醒信息表实体
  * 功能描述: 提醒信息表实体
  * 创建记录: 2013/08/05
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="remindInfo")
public class RemindInfoTB extends BaseEntity implements Serializable,
		Cloneable, RemindInfoInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="REMINDINFO_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="REMINDINFO_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="REMINDINFO_TABLE_GENERATOR")
	protected Integer riid;


	/** 用户id */
	protected String riuseid;

	/** 提醒信息 */
	protected String riinfo;

	/** 状态 */
	protected String ristatus;

	/** 报表类型 */
	protected String ritype;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getRiid() {
		return riid;
	}

	/**
	 * 主键设定
	 *
	 * @param riid 主键
	 */
	public void setRiid(Integer riid) {
		this.riid = riid;
	}

	/**
	 * 用户id取得
	 *
	 * @return 用户id
	 */
	public String getRiuseid() {
		return riuseid;
	}

	/**
	 * 用户id设定
	 *
	 * @param riuseid 用户id
	 */
	public void setRiuseid(String riuseid) {
		this.riuseid = riuseid;
	}

	/**
	 * 提醒信息取得
	 *
	 * @return 提醒信息
	 */
	public String getRiinfo() {
		return riinfo;
	}

	/**
	 * 提醒信息设定
	 *
	 * @param riinfo 提醒信息
	 */
	public void setRiinfo(String riinfo) {
		this.riinfo = riinfo;
	}

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getRistatus() {
		return ristatus;
	}

	/**
	 * 状态设定
	 *
	 * @param ristatus 状态
	 */
	public void setRistatus(String ristatus) {
		this.ristatus = ristatus;
	}

	/**
	 * 报表类型取得
	 *
	 * @return 报表类型
	 */
	public String getRitype() {
		return ritype;
	}

	/**
	 * 报表类型设定
	 *
	 * @param ritype 报表类型
	 */
	public void setRitype(String ritype) {
		this.ritype = ritype;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return riid;
	}

}
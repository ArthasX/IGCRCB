/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.dbm.model.Ip_FilterInfo;

/**
  * 概述: 全网IP过滤实体
  * 功能描述: 全网IP过滤实体
  * 创建记录: 2012/11/07
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="Hq_Ip_Filter")
public class Ip_FilterTB extends BaseEntity implements Serializable,
		Cloneable, Ip_FilterInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="IP_FILTER_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IP_FILTER_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IP_FILTER_TABLE_GENERATOR")
	protected Integer id;

	/** IP地址 */
	protected String ip;

	/** 添加时间 */
	protected String addtime;

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
	 * IP地址取得
	 *
	 * @return IP地址
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * IP地址设定
	 *
	 * @param ip IP地址
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 添加时间取得
	 *
	 * @return 添加时间
	 */
	public String getAddtime() {
		return addtime;
	}

	/**
	 * 添加时间设定
	 *
	 * @param addtime 添加时间
	 */
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return id;
	}

}
/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.fxk.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.fxk.model.AcceptuserInfo;

/**
  * 概述: 风险管理提示接收者数据表实体
  * 功能描述: 风险管理提示接收者数据表实体
  * 创建记录: 2014/06/17
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="acceptuser")
public class AcceptuserTB extends BaseEntity implements Serializable,
		Cloneable, AcceptuserInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="ACCEPTUSER_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="ACCEPTUSER_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="ACCEPTUSER_TABLE_GENERATOR")
	protected Integer apid;

	/** 接收者id */
	protected String apuserid;

	/** 接收者名字 */
	protected String apusername;

	/** 接收机构码 */
	protected String aporgid;

	/** 接收机构名称 */
	protected String aporgname;

	/** 风险提示主键 */
	protected Integer rwid;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getApid() {
		return apid;
	}

	/**
	 * 主键设定
	 *
	 * @param apid 主键
	 */
	public void setApid(Integer apid) {
		this.apid = apid;
	}

	/**
	 * 接收者id取得
	 *
	 * @return 接收者id
	 */
	public String getApuserid() {
		return apuserid;
	}

	/**
	 * 接收者id设定
	 *
	 * @param apuserid 接收者id
	 */
	public void setApuserid(String apuserid) {
		this.apuserid = apuserid;
	}

	/**
	 * 接收者名字取得
	 *
	 * @return 接收者名字
	 */
	public String getApusername() {
		return apusername;
	}

	/**
	 * 接收者名字设定
	 *
	 * @param apusername 接收者名字
	 */
	public void setApusername(String apusername) {
		this.apusername = apusername;
	}

	/**
	 * 接收机构码取得
	 *
	 * @return 接收机构码
	 */
	public String getAporgid() {
		return aporgid;
	}

	/**
	 * 接收机构码设定
	 *
	 * @param aporgid 接收机构码
	 */
	public void setAporgid(String aporgid) {
		this.aporgid = aporgid;
	}

	/**
	 * 接收机构名称取得
	 *
	 * @return 接收机构名称
	 */
	public String getAporgname() {
		return aporgname;
	}

	/**
	 * 接收机构名称设定
	 *
	 * @param aporgname 接收机构名称
	 */
	public void setAporgname(String aporgname) {
		this.aporgname = aporgname;
	}

	/**
	 * 风险提示主键取得
	 *
	 * @return 风险提示主键
	 */
	public Integer getRwid() {
		return rwid;
	}

	/**
	 * 风险提示主键设定
	 *
	 * @param rwid 风险提示主键
	 */
	public void setRwid(Integer rwid) {
		this.rwid = rwid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return apid;
	}

}
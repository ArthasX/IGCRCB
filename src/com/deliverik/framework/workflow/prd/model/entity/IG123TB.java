/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG123Info;

/**
  * 概述: 自定义流程机构范围表实体
  * 功能描述: 自定义流程机构范围表实体
  * 创建记录: 2013/03/07
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG123")
public class IG123TB extends BaseEntity implements Serializable,
		Cloneable, IG123Info {

	/** 主键 */
	@Id
	protected String potdid;

	/** 流程类型主键 */
	protected String pdid;

	/** 机构码 */
	protected String orgid;

	/** 机构名称 */
	protected String orgname;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getPotdid() {
		return potdid;
	}

	/**
	 * 主键设定
	 *
	 * @param potdid 主键
	 */
	public void setPotdid(String potdid) {
		this.potdid = potdid;
	}

	/**
	 * 流程类型主键取得
	 *
	 * @return 流程类型主键
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程类型主键设定
	 *
	 * @param pdid 流程类型主键
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 机构码取得
	 *
	 * @return 机构码
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * 机构码设定
	 *
	 * @param orgid 机构码
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * 机构名称取得
	 *
	 * @return 机构名称
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 机构名称设定
	 *
	 * @param orgname 机构名称
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return potdid;
	}

}
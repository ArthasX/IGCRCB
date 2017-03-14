/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
  * 概述: 工作管理实体
  * 功能描述: 工作管理实体
  * 创建记录: 2016/04/19
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
public class WorkmanagerVW implements Serializable {

	/** 主键 */
	@Id
	protected Integer wmid;
	
	/** 工作名称 */
	protected String wmname;

	/** 发起人id */
	protected String wmuserid;

	/** 发起人姓名 */
	protected String wmusername;

	/**
	 * @return the 主键
	 */
	public Integer getWmid() {
		return wmid;
	}

	/**
	 * @param 主键 the wmid to set
	 */
	public void setWmid(Integer wmid) {
		this.wmid = wmid;
	}

	/**
	 * @return the 发起人id
	 */
	public String getWmuserid() {
		return wmuserid;
	}

	/**
	 * @param 发起人id the wmuserid to set
	 */
	public void setWmuserid(String wmuserid) {
		this.wmuserid = wmuserid;
	}

	/**
	 * @return the 发起人姓名
	 */
	public String getWmusername() {
		return wmusername;
	}

	/**
	 * @param 发起人姓名 the wmusername to set
	 */
	public void setWmusername(String wmusername) {
		this.wmusername = wmusername;
	}

	/**
	 * @return the 工作名称
	 */
	public String getWmname() {
		return wmname;
	}

	/**
	 * @param 工作名称 the wmname to set
	 */
	public void setWmname(String wmname) {
		this.wmname = wmname;
	}

}
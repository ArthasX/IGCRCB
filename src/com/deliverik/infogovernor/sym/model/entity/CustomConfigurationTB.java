/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.sym.model.CustomConfigurationInfo;

/**
  * 概述: 自定义流程配置表实体
  * 功能描述: 自定义流程配置表实体
  * 创建记录: 2012/11/05
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CustomConfiguration")
public class CustomConfigurationTB extends BaseEntity implements Serializable,
		Cloneable, CustomConfigurationInfo {

	/** 报表ID */
	@Id
	@GeneratedValue(generator = "rfdid")
	@GenericGenerator(name = "rfdid", strategy = "assigned")
	protected Integer rfdid;

	/** 报表定义ID */
	protected String pdid;

	/** 统计的状态 */
	protected String prstatusInfo;

	/** 表单ID */
	protected String pidid;

	/** 表单值 */
	protected String pidvalue;

	/** 登记人ID */
	protected String userid;
	
	/** 创建时间 */
	protected String createTime;
	
	/** 更新时间 */
	protected String updateTime;

	/**
	 * 报表ID取得
	 *
	 * @return 报表ID
	 */
	public Integer getRfdid() {
		return rfdid;
	}

	/**
	 * 报表ID设定
	 *
	 * @param rfdid 报表ID
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}

	/**
	 * 报表定义ID取得
	 *
	 * @return 报表定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 报表定义ID设定
	 *
	 * @param pdid 报表定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 统计的状态取得
	 *
	 * @return 统计的状态
	 */
	public String getPrstatusInfo() {
		return prstatusInfo;
	}

	/**
	 * 统计的状态设定
	 *
	 * @param prstatusInfo 统计的状态
	 */
	public void setPrstatusInfo(String prstatusInfo) {
		this.prstatusInfo = prstatusInfo;
	}

	/**
	 * 表单ID取得
	 *
	 * @return 表单ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 表单ID设定
	 *
	 * @param pidid 表单ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 表单值取得
	 *
	 * @return 表单值
	 */
	public String getPidvalue() {
		return pidvalue;
	}

	/**
	 * 表单值设定
	 *
	 * @param pidvalue 表单值
	 */
	public void setPidvalue(String pidvalue) {
		this.pidvalue = pidvalue;
	}

	/**
	 * 登记人ID取得
	 *
	 * @return 登记人ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 登记人ID设定
	 *
	 * @param userid 登记人ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return rfdid;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

}
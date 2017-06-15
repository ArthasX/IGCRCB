/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.drm.model.TrainplanInfo;

/**
  * 概述: 培训计划表实体
  * 功能描述: 培训计划表实体
  * 创建记录: 2015/04/10
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="trainplan")
public class TrainplanTB extends BaseEntity implements Serializable,
		Cloneable, TrainplanInfo {

	/** 主键 */
	@Id
	@TableGenerator(
			name="TRAINPLANTB_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
			pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
			pkColumnValue="TRAINPLANTB_SEQUENCE", initialValue=1, allocationSize=1
		)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TRAINPLANTB_TABLE_GENERATOR")
	protected  Integer tpid;

	/** 计划名称 */
	protected String tpname;

	/** 发起人id */
	protected String tpuserid;

	/** 发起人姓名 */
	protected String tpusername;

	/** 发起部门id */
	protected String ptorgid;

	/** 发起部门名称 */
	protected String tporgname;

	/** 发起日期 */
	protected String tptime;

	/** 计划状态 */
	protected String tpstatus;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getTpid() {
		return tpid;
	}

	/**
	 * 主键设定
	 *
	 * @param tpid 主键
	 */
	public void setTpid(Integer tpid) {
		this.tpid = tpid;
	}

	/**
	 * 计划名称取得
	 *
	 * @return 计划名称
	 */
	public String getTpname() {
		return tpname;
	}

	/**
	 * 计划名称设定
	 *
	 * @param tpname 计划名称
	 */
	public void setTpname(String tpname) {
		this.tpname = tpname;
	}

	/**
	 * 发起人id取得
	 *
	 * @return 发起人id
	 */
	public String getTpuserid() {
		return tpuserid;
	}

	/**
	 * 发起人id设定
	 *
	 * @param tpuserid 发起人id
	 */
	public void setTpuserid(String tpuserid) {
		this.tpuserid = tpuserid;
	}

	/**
	 * 发起人姓名取得
	 *
	 * @return 发起人姓名
	 */
	public String getTpusername() {
		return tpusername;
	}

	/**
	 * 发起人姓名设定
	 *
	 * @param tpusername 发起人姓名
	 */
	public void setTpusername(String tpusername) {
		this.tpusername = tpusername;
	}

	/**
	 * 发起部门id取得
	 *
	 * @return 发起部门id
	 */
	public String getPtorgid() {
		return ptorgid;
	}

	/**
	 * 发起部门id设定
	 *
	 * @param ptorgid 发起部门id
	 */
	public void setPtorgid(String ptorgid) {
		this.ptorgid = ptorgid;
	}

	/**
	 * 发起部门名称取得
	 *
	 * @return 发起部门名称
	 */
	public String getTporgname() {
		return tporgname;
	}

	/**
	 * 发起部门名称设定
	 *
	 * @param tporgname 发起部门名称
	 */
	public void setTporgname(String tporgname) {
		this.tporgname = tporgname;
	}

	/**
	 * 发起日期取得
	 *
	 * @return 发起日期
	 */
	public String getTptime() {
		return tptime;
	}

	/**
	 * 发起日期设定
	 *
	 * @param tptime 发起日期
	 */
	public void setTptime(String tptime) {
		this.tptime = tptime;
	}

	/**
	 * 计划状态取得
	 *
	 * @return 计划状态
	 */
	public String getTpstatus() {
		return tpstatus;
	}

	/**
	 * 计划状态设定
	 *
	 * @param tpstatus 计划状态
	 */
	public void setTpstatus(String tpstatus) {
		this.tpstatus = tpstatus;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return tpid;
	}

}
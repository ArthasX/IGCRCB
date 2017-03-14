/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.mnt.model.SOC0304Info;

/**
  * 概述: 监控任务主表实体 MONITORTASK
  * 功能描述: 监控任务主表实体 MONITORTASK
  * 创建记录: 2012/05/10
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0304")
public class SOC0304TB extends BaseEntity implements Serializable,
		Cloneable, SOC0304Info {

	/** 任务ID */
	@Id
	@TableGenerator(
		name="MONITORTASK_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MONITORTASK_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MONITORTASK_TABLE_GENERATOR")
	protected Integer mtId;

	/** 存储序列号 */
	protected String mtSsn;

	/** 组件名称 */
	protected String mtCname;

	/** kpi */
	protected String mtKpi;

	/** 采集间隔 */
	protected Integer mtInterval;
	/**对象名称字符串*/
	protected String mtObjNames;
	/** 采集次数 */
	protected Integer mtNum;

	/** 开始时间 */
	protected String mtStartTime;

	/** 结束时间 */
	protected String mtStopTime;

	/** 预计结束时间 */
	protected String mtPStopTime;

	/** 任务状态  0为运行 1为关闭*/
	protected String mtStatus;

	/** 记录时间 */
	protected String mtRecordTime;

	/** 记录用户id */
	protected String mtUserId;

	/** 用户部门ID */
	protected String mtOrgId;

	/**
	 * 任务ID取得
	 *
	 * @return 任务ID
	 */
	public Integer getMtId() {
		return mtId;
	}

	/**
	 * 任务ID设定
	 *
	 * @param mtId 任务ID
	 */
	public void setMtId(Integer mtId) {
		this.mtId = mtId;
	}

	/**
	 * 存储序列号取得
	 *
	 * @return 存储序列号
	 */
	public String getMtSsn() {
		return mtSsn;
	}

	/**
	 * 存储序列号设定
	 *
	 * @param mtSsn 存储序列号
	 */
	public void setMtSsn(String mtSsn) {
		this.mtSsn = mtSsn;
	}

	/**
	 * 组件名称取得
	 *
	 * @return 组件名称
	 */
	public String getMtCname() {
		return mtCname;
	}

	/**
	 * 组件名称设定
	 *
	 * @param mtCname 组件名称
	 */
	public void setMtCname(String mtCname) {
		this.mtCname = mtCname;
	}

	/**
	 * kpi取得
	 *
	 * @return kpi
	 */
	public String getMtKpi() {
		return mtKpi;
	}

	/**
	 * kpi设定
	 *
	 * @param mtKpi kpi
	 */
	public void setMtKpi(String mtKpi) {
		this.mtKpi = mtKpi;
	}

	/**
	 * 采集间隔取得
	 *
	 * @return 采集间隔
	 */
	public Integer getMtInterval() {
		return mtInterval;
	}

	/**
	 * 采集间隔设定
	 *
	 * @param mtInterval 采集间隔
	 */
	public void setMtInterval(Integer mtInterval) {
		this.mtInterval = mtInterval;
	}

	/**
	 * 采集次数取得
	 *
	 * @return 采集次数
	 */
	public Integer getMtNum() {
		return mtNum;
	}

	/**
	 * 采集次数设定
	 *
	 * @param mtNum 采集次数
	 */
	public void setMtNum(Integer mtNum) {
		this.mtNum = mtNum;
	}

	/**
	 * 开始时间取得
	 *
	 * @return 开始时间
	 */
	public String getMtStartTime() {
		return mtStartTime;
	}

	/**
	 * 开始时间设定
	 *
	 * @param mtStartTime 开始时间
	 */
	public void setMtStartTime(String mtStartTime) {
		this.mtStartTime = mtStartTime;
	}

	/**
	 * 结束时间取得
	 *
	 * @return 结束时间
	 */
	public String getMtStopTime() {
		return mtStopTime;
	}

	/**
	 * 结束时间设定
	 *
	 * @param mtStopTime 结束时间
	 */
	public void setMtStopTime(String mtStopTime) {
		this.mtStopTime = mtStopTime;
	}

	/**
	 * 预计结束时间取得
	 *
	 * @return 预计结束时间
	 */
	public String getMtPStopTime() {
		return mtPStopTime;
	}

	/**
	 * 预计结束时间设定
	 *
	 * @param mtPStopTime 预计结束时间
	 */
	public void setMtPStopTime(String mtPStopTime) {
		this.mtPStopTime = mtPStopTime;
	}

	/**
	 * 任务状态取得
	 *
	 * @return 任务状态
	 */
	public String getMtStatus() {
		return mtStatus;
	}

	/**
	 * 任务状态设定
	 *
	 * @param mtStatus 任务状态
	 */
	public void setMtStatus(String mtStatus) {
		this.mtStatus = mtStatus;
	}

	/**
	 * 记录时间取得
	 *
	 * @return 记录时间
	 */
	public String getMtRecordTime() {
		return mtRecordTime;
	}

	/**
	 * 记录时间设定
	 *
	 * @param mtRecordTime 记录时间
	 */
	public void setMtRecordTime(String mtRecordTime) {
		this.mtRecordTime = mtRecordTime;
	}

	/**
	 * 记录用户id取得
	 *
	 * @return 记录用户id
	 */
	public String getMtUserId() {
		return mtUserId;
	}

	/**
	 * 记录用户id设定
	 *
	 * @param mtUserId 记录用户id
	 */
	public void setMtUserId(String mtUserId) {
		this.mtUserId = mtUserId;
	}

	/**
	 * 用户部门ID取得
	 *
	 * @return 用户部门ID
	 */
	public String getMtOrgId() {
		return mtOrgId;
	}

	/**
	 * 用户部门ID设定
	 *
	 * @param mtOrgId 用户部门ID
	 */
	public void setMtOrgId(String mtOrgId) {
		this.mtOrgId = mtOrgId;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return mtId;
	}

	/**
	 * 对象名称字符串取得
	 *
	 * @return mtObjNames 对象名称字符串
	 */
	public String getMtObjNames() {
		return mtObjNames;
	}

	/**
	 * 对象名称字符串设定
	 *
	 * @param mtObjNames 对象名称字符串
	 */
	public void setMtObjNames(String mtObjNames) {
		this.mtObjNames = mtObjNames;
	}

}
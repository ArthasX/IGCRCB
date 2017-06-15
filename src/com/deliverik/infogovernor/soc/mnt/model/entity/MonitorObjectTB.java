/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.dbs.model.entity.Collect_Symmetrix_InfoTB;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectInfo;

/**
  * 概述: 监控对象信息实体
  * 功能描述: 监控对象信息实体
  * 创建记录: 2012/02/07
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="monitorObject", schema="cst")
public class MonitorObjectTB extends BaseEntity implements Serializable,
		Cloneable, MonitorObjectInfo {

	/** 主键Id */
	@Id
	@TableGenerator(
		name="MONITOROBJECT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MONITOROBJECT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MONITOROBJECT_TABLE_GENERATOR")
	protected Integer moId;

	/** 监控对象名称 */
	protected String moName;
	
	/** ip地址 */
	protected String ip;

	/** 创建时间 */
	protected String moCreateTime;

	/** 监控类型层次码 */
	protected String mtSyscoding;

	/** 状态 */
	protected String deleteFlag;
	
	/**MonitorTypeTB 实体*/
	@OneToOne
	@JoinColumn(name="mtSyscoding", referencedColumnName="mtSyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected MonitorTypeTB monitorTypeTB;
	
	/**Collect_Symmetrix_InfoTB 实体*/
	@OneToOne
	@JoinColumn(name="moName", referencedColumnName="symm_id", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected Collect_Symmetrix_InfoTB collect_Symmetrix_InfoTB;

	/**
	 * 主键Id取得
	 *
	 * @return 主键Id
	 */
	public Integer getMoId() {
		return moId;
	}

	/**
	 * 主键Id设定
	 *
	 * @param moId 主键Id
	 */
	public void setMoId(Integer moId) {
		this.moId = moId;
	}

	/**
	 * 监控对象名称取得
	 *
	 * @return 监控对象名称
	 */
	public String getMoName() {
		return moName;
	}

	/**
	 * 监控对象名称设定
	 *
	 * @param moName 监控对象名称
	 */
	public void setMoName(String moName) {
		this.moName = moName;
	}

	/**
	 * 创建时间取得
	 *
	 * @return 创建时间
	 */
	public String getMoCreateTime() {
		return moCreateTime;
	}

	/**
	 * 创建时间设定
	 *
	 * @param moCreateTime 创建时间
	 */
	public void setMoCreateTime(String moCreateTime) {
		this.moCreateTime = moCreateTime;
	}

	/**
	 * 监控类型层次码取得
	 *
	 * @return 监控类型层次码
	 */
	public String getMtSyscoding() {
		return mtSyscoding;
	}

	/**
	 * 监控类型层次码设定
	 *
	 * @param mtSyscoding 监控类型层次码
	 */
	public void setMtSyscoding(String mtSyscoding) {
		this.mtSyscoding = mtSyscoding;
	}

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * 状态设定
	 *
	 * @param deleteFlag 状态
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return moId;
	}

	/**
	 * ip地址获取
	 * @return
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * ip地址设定
	 * @param ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * MonitorTypeTB 实体获取
	 * @return
	 */
	public MonitorTypeTB getMonitorTypeTB() {
		return monitorTypeTB;
	}

	/**
	 * MonitorTypeTB 实体设定
	 * @param monitorTypeTB
	 */
	public void setMonitorTypeTB(MonitorTypeTB monitorTypeTB) {
		this.monitorTypeTB = monitorTypeTB;
	}

	/**
	 * Collect_Symmetrix_InfoTB 实体取得
	 * @return
	 */
	public Collect_Symmetrix_InfoTB getCollect_Symmetrix_InfoTB() {
		return collect_Symmetrix_InfoTB;
	}

	/**
	 * Collect_Symmetrix_InfoTB 实体设定
	 * @param collect_Symmetrix_InfoTB
	 */
	public void setCollect_Symmetrix_InfoTB(
			Collect_Symmetrix_InfoTB collect_Symmetrix_InfoTB) {
		this.collect_Symmetrix_InfoTB = collect_Symmetrix_InfoTB;
	}

}
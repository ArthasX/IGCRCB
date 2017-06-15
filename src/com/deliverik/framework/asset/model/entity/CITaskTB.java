/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.asset.model.CITaskInfo;
import com.deliverik.framework.base.BaseEntity;

/**
  * 概述: CI变更任务表实体
  * 功能描述: CI变更任务表实体
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CITask")
public class CITaskTB extends BaseEntity implements Serializable,
		Cloneable, CITaskInfo {

	/** 逻辑主键 */
	@Id
	@TableGenerator(
		name="CITASK_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CITASK_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CITASK_TABLE_GENERATOR")
	protected Integer citid;

	/** CI变更任务描述 */
	protected String citdesc;

	/** CI变更时间戳 */
	protected String cittime;
	
	/** 状态 */
	protected String citstatus;
	
	/** 最后更新时间 */
	protected String citupdtime;
	
	/** 最后对比时间 */
	protected String citcomptime;

	/**
	 * 逻辑主键取得
	 *
	 * @return 逻辑主键
	 */
	public Integer getCitid() {
		return citid;
	}

	/**
	 * 逻辑主键设定
	 *
	 * @param citid 逻辑主键
	 */
	public void setCitid(Integer citid) {
		this.citid = citid;
	}

	/**
	 * CI变更任务描述取得
	 *
	 * @return CI变更任务描述
	 */
	public String getCitdesc() {
		return citdesc;
	}

	/**
	 * CI变更任务描述设定
	 *
	 * @param citdesc CI变更任务描述
	 */
	public void setCitdesc(String citdesc) {
		this.citdesc = citdesc;
	}

	/**
	 * CI变更时间戳取得
	 *
	 * @return CI变更时间戳
	 */
	public String getCittime() {
		return cittime;
	}

	/**
	 * CI变更时间戳设定
	 *
	 * @param cittime CI变更时间戳
	 */
	public void setCittime(String cittime) {
		this.cittime = cittime;
	}
	
	
	/**
	 * 状态取得
	 * 
	 * @return 状态
	 */
	public String getCitstatus() {
		return citstatus;
	}

	/**
	 * 状态设定
	 * 
	 * @param citstatus 状态
	 */
	public void setCitstatus(String citstatus) {
		this.citstatus = citstatus;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return citid;
	}
	
	/**
	 * 最后更新时间取得
	 * @return 最后更新时间
	 */
	public String getCitupdtime() {
		return citupdtime;
	}

	/**
	 * 最后更新时间设定
	 * @param citupdtime 最后更新时间
	 */ 
	public void setCitupdtime(String citupdtime) {
		this.citupdtime = citupdtime;
	}

	/**
	 * 最后对比时间取得
	 * @return 最后对比时间
	 */
	public String getCitcomptime() {
		return citcomptime;
	}

	/**
	 * 最后对比时间设定
	 * @param citcomptime 最后对比时间
	 */
	public void setCitcomptime(String citcomptime) {
		this.citcomptime = citcomptime;
	}


}
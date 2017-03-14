/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0104Info;

/**
  * 概述: 审计任务表实体
  * 功能描述: 审计任务表实体
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0104")
public class SOC0104TB extends BaseEntity implements Serializable,
		Cloneable, SOC0104Info {

	/** 逻辑主键 */
	@Id
	@TableGenerator(
		name="SOC0104_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="SOC0104_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SOC0104_TABLE_GENERATOR")
	protected Integer autid;

	/** 审计任务描述 */
	protected String autdesc;

	/** 审计时间戳 */
	protected String auttime;
	
	/** 状态 */
	protected String autstatus;
	
	/** 最后更新时间 */
	protected String autupdtime;
	
	/** 最后对比时间 */
	protected String autcomptime;

	/**
	 * 逻辑主键取得
	 *
	 * @return 逻辑主键
	 */
	public Integer getAutid() {
		return autid;
	}

	/**
	 * 逻辑主键设定
	 *
	 * @param autid 逻辑主键
	 */
	public void setAutid(Integer autid) {
		this.autid = autid;
	}

	/**
	 * 审计任务描述取得
	 *
	 * @return 审计任务描述
	 */
	public String getAutdesc() {
		return autdesc;
	}

	/**
	 * 审计任务描述设定
	 *
	 * @param autdesc 审计任务描述
	 */
	public void setAutdesc(String autdesc) {
		this.autdesc = autdesc;
	}

	/**
	 * 审计时间戳取得
	 *
	 * @return 审计时间戳
	 */
	public String getAuttime() {
		return auttime;
	}

	/**
	 * 审计时间戳设定
	 *
	 * @param auttime 审计时间戳
	 */
	public void setAuttime(String auttime) {
		this.auttime = auttime;
	}
	
	/**
	 * 状态取得
	 * 
	 * @return 状态
	 */
	public String getAutstatus() {
		return autstatus;
	}

	/**
	 * 状态设定
	 * 
	 * @param autstatus 状态
	 */
	public void setAutstatus(String autstatus) {
		this.autstatus = autstatus;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return autid;
	}

	/**
	 * 最后更新时间取得
	 * @return 最后更新时间
	 */
	public String getAutupdtime() {
		return autupdtime;
	}

	/**
	 * 最后更新时间设定
	 * @param autupdtime 最后更新时间
	 */ 
	public void setAutupdtime(String autupdtime) {
		this.autupdtime = autupdtime;
	}

	/**
	 * 最后对比时间取得
	 * @return 最后对比时间
	 */
	public String getAutcomptime() {
		return autcomptime;
	}

	/**
	 * 最后对比时间设定
	 * @param autcomptime 最后对比时间
	 */
	public void setAutcomptime(String autcomptime) {
		this.autcomptime = autcomptime;
	}

}
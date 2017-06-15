/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG992Info;

/**
  * 概述: 流程外部调用定义表实体
  * 功能描述: 流程外部调用定义表实体
  * 创建记录: 2012/04/20
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG992")
public class IG992TB extends BaseEntity implements Serializable,
		Cloneable, IG992Info {

	/** 主键 */
	@Id
	@TableGenerator(
		name="IG992_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IG992_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG992_TABLE_GENERATOR")
	protected Integer pedid;

	/** 事件ID */
	protected String pedeventid;

	/** 调用BL */
	protected String pedaction;

	/** 描述 */
	protected String peddesc;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPedid() {
		return pedid;
	}

	/**
	 * 主键设定
	 *
	 * @param pedid 主键
	 */
	public void setPedid(Integer pedid) {
		this.pedid = pedid;
	}

	/**
	 * 事件ID取得
	 *
	 * @return 事件ID
	 */
	public String getPedeventid() {
		return pedeventid;
	}

	/**
	 * 事件ID设定
	 *
	 * @param pedeventid 事件ID
	 */
	public void setPedeventid(String pedeventid) {
		this.pedeventid = pedeventid;
	}

	/**
	 * 调用BL取得
	 *
	 * @return 调用BL
	 */
	public String getPedaction() {
		return pedaction;
	}

	/**
	 * 调用BL设定
	 *
	 * @param pedaction 调用BL
	 */
	public void setPedaction(String pedaction) {
		this.pedaction = pedaction;
	}

	/**
	 * 描述取得
	 *
	 * @return 描述
	 */
	public String getPeddesc() {
		return peddesc;
	}

	/**
	 * 描述设定
	 *
	 * @param peddesc 描述
	 */
	public void setPeddesc(String peddesc) {
		this.peddesc = peddesc;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return pedid;
	}

}
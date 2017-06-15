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
import com.deliverik.framework.workflow.prd.model.IG256Info;

/**
  * 概述: 流程策略提醒实体
  * 功能描述: 流程策略提醒实体
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG256")
public class IG256TB extends BaseEntity implements Serializable,
		Cloneable, IG256Info {

	/** 主键 */
	@Id
	@TableGenerator(
		name="IG256_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IG256_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG256_TABLE_GENERATOR")
	protected Integer fnid;

	/** 流程表主键 */
	protected Integer prid;

	/** 流程类型表主键 */
	protected String pdid;

	/** 流程记录状态 */
	protected String prstatus;

	/** 当前流程参与人id */
	protected String ppuserid;
	
	/** 当前流程参与人名称 */
	protected String ppusername;

	/** 标识 */
	protected String flag;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getFnid() {
		return fnid;
	}

	/**
	 * 主键设定
	 *
	 * @param fnid 主键
	 */
	public void setFnid(Integer fnid) {
		this.fnid = fnid;
	}

	/**
	 * 流程表主键取得
	 *
	 * @return 流程表主键
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程表主键设定
	 *
	 * @param prid 流程表主键
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 流程类型表主键取得
	 *
	 * @return 流程类型表主键
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程类型表主键设定
	 *
	 * @param pdid 流程类型表主键
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程记录状态取得
	 *
	 * @return 流程记录状态
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 流程记录状态设定
	 *
	 * @param prstatus 流程记录状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * 当前流程参与人id取得
	 *
	 * @return 当前流程参与人id
	 */
	public String getPpuserid() {
		return ppuserid;
	}

	/**
	 * 当前流程参与人id设定
	 *
	 * @param ppuserid 当前流程参与人id
	 */
	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}

	/**
	 * 当前流程参与人名称取得
	 *
	 * @return 当前流程参与人名称
	 */
	public String getPpusername() {
		return ppusername;
	}

	/**
	 * 当前流程参与人名称设定
	 *
	 * @param ppuserid 当前流程参与人名称
	 */
	public void setPpusername(String ppusername) {
		this.ppusername = ppusername;
	}

	/**
	 * 标识取得
	 *
	 * @return 标识
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * 标识设定
	 *
	 * @param flag 标识
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return fnid;
	}

}
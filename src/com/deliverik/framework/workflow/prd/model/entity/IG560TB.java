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
import com.deliverik.framework.workflow.prd.model.IG560Info;

/**
  * 概述: 流程状态级私有表单默认值表实体
  * 功能描述: 流程状态级私有表单默认值表实体
  * 创建记录: 2015/02/07
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="ig560")
public class IG560TB extends BaseEntity implements Serializable,
		Cloneable, IG560Info {

	/** dvid */
	@Id
	@TableGenerator(
		name="IG560_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IG560_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG560_TABLE_GENERATOR")
	protected Integer dvid;

	/** 表单id */
	protected String pidid;

	/** 状态id */
	protected String psdid;

	/** 默认值 */
	protected String dfvalue;

	/** 是否应用到整个流程T/F */
	protected String usedtoall;

	/**
	 * dvid取得
	 *
	 * @return dvid
	 */
	public Integer getDvid() {
		return dvid;
	}

	/**
	 * dvid设定
	 *
	 * @param dvid dvid
	 */
	public void setDvid(Integer dvid) {
		this.dvid = dvid;
	}

	/**
	 * 表单id取得
	 *
	 * @return 表单id
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 表单id设定
	 *
	 * @param pidid 表单id
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 状态id取得
	 *
	 * @return 状态id
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 状态id设定
	 *
	 * @param psdid 状态id
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 默认值取得
	 *
	 * @return 默认值
	 */
	public String getDfvalue() {
		return dfvalue;
	}

	/**
	 * 默认值设定
	 *
	 * @param dfvalue 默认值
	 */
	public void setDfvalue(String dfvalue) {
		this.dfvalue = dfvalue;
	}

	/**
	 * 是否应用到整个流程T/F取得
	 *
	 * @return 是否应用到整个流程T/F
	 */
	public String getUsedtoall() {
		return usedtoall;
	}

	/**
	 * 是否应用到整个流程T/F设定
	 *
	 * @param usedtoall 是否应用到整个流程T/F
	 */
	public void setUsedtoall(String usedtoall) {
		this.usedtoall = usedtoall;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return dvid;
	}

}
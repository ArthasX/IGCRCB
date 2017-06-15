/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.risk.model.CheckworkInfoResultInfo;

/**
  * 概述: 检查工作检查任务关联表实体
  * 功能描述: 检查工作检查任务关联表实体
  * 创建记录: 2014/09/02
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CheckworkInfoResult")
public class CheckworkInfoResultTB extends BaseEntity implements Serializable,
		Cloneable, CheckworkInfoResultInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="CHECKWORKINFORESULT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CHECKWORKINFORESULT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CHECKWORKINFORESULT_TABLE_GENERATOR")
	protected Integer cwirid;

	/** 检查任务id */
	protected Integer cwrid;

	/** 检查工作id */
	protected Integer rcrid;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getCwirid() {
		return cwirid;
	}

	/**
	 * 主键设定
	 *
	 * @param cwirid 主键
	 */
	public void setCwirid(Integer cwirid) {
		this.cwirid = cwirid;
	}

	/**
	 * 检查任务id取得
	 *
	 * @return 检查任务id
	 */
	public Integer getCwrid() {
		return cwrid;
	}

	/**
	 * 检查任务id设定
	 *
	 * @param cwrid 检查任务id
	 */
	public void setCwrid(Integer cwrid) {
		this.cwrid = cwrid;
	}

	/**
	 * 检查工作id取得
	 *
	 * @return 检查工作id
	 */
	public Integer getRcrid() {
		return rcrid;
	}

	/**
	 * 检查工作id设定
	 *
	 * @param rcrid 检查工作id
	 */
	public void setRcrid(Integer rcrid) {
		this.rcrid = rcrid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return cwirid;
	}

}
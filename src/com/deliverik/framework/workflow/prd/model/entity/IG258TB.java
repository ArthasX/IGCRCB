/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG258Info;

/**
  * 概述: 流程状态参与者调整实体
  * 功能描述: 流程状态参与者调整实体
  * 创建记录: 2012/05/09
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG258")
public class IG258TB extends BaseEntity implements Serializable,
		Cloneable, IG258Info {

	/** 主键 */
	@Id
	protected String pspcdid;

	/** 当前状态ID */
	protected String psdid;

	/** 可改变状态id */
	protected String pspcdpsdid;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getPspcdid() {
		return pspcdid;
	}

	/**
	 * 主键设定
	 *
	 * @param pspcdid 主键
	 */
	public void setPspcdid(String pspcdid) {
		this.pspcdid = pspcdid;
	}

	/**
	 * 当前状态ID取得
	 *
	 * @return 当前状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 当前状态ID设定
	 *
	 * @param psdid 当前状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 可改变状态id取得
	 *
	 * @return 可改变状态id
	 */
	public String getPspcdpsdid() {
		return pspcdpsdid;
	}

	/**
	 * 可改变状态id设定
	 *
	 * @param pspcdpsdid 可改变状态id
	 */
	public void setPspcdpsdid(String pspcdpsdid) {
		this.pspcdpsdid = pspcdpsdid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return pspcdid;
	}

}
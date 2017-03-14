/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG233Info;

/**
  * 概述: 自定义流程分派定义表实体
  * 功能描述: 自定义流程分派定义表实体
  * 创建记录: 2013/03/12
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG233PK.class)
@Table(name="IG233")
public class IG233TB extends BaseEntity implements Serializable,
		Cloneable, IG233Info {

	/** 被分派节点主键 */
	@Id
	protected String psdid;

	/** 分派节点主键 */
	@Id
	protected String assignpsdid;

	/** 分派按钮主键 */
	protected String assignpbdid;

	/** 是否必须分派标识 */
	protected String assignflag;

	/**
	 * 被分派节点主键取得
	 *
	 * @return 被分派节点主键
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 被分派节点主键设定
	 *
	 * @param psdid 被分派节点主键
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 分派节点主键取得
	 *
	 * @return 分派节点主键
	 */
	public String getAssignpsdid() {
		return assignpsdid;
	}

	/**
	 * 分派节点主键设定
	 *
	 * @param assignpsdid 分派节点主键
	 */
	public void setAssignpsdid(String assignpsdid) {
		this.assignpsdid = assignpsdid;
	}

	/**
	 * 分派按钮主键取得
	 *
	 * @return 分派按钮主键
	 */
	public String getAssignpbdid() {
		return assignpbdid;
	}

	/**
	 * 分派按钮主键设定
	 *
	 * @param assignpbdid 分派按钮主键
	 */
	public void setAssignpbdid(String assignpbdid) {
		this.assignpbdid = assignpbdid;
	}

	/**
	 * 是否必须分派标识取得
	 *
	 * @return 是否必须分派标识
	 */
	public String getAssignflag() {
		return assignflag;
	}

	/**
	 * 是否必须分派标识设定
	 *
	 * @param assignflag 是否必须分派标识
	 */
	public void setAssignflag(String assignflag) {
		this.assignflag = assignflag;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new IG233PK(psdid, assignpsdid);
	}

}
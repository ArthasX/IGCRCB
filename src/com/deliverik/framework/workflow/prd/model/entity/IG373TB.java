/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG373Info;

/**
  * 概述: 流程表单初始化事件定义表实体
  * 功能描述: 流程表单初始化事件定义表实体
  * 创建记录: 2012/07/03
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG373")
public class IG373TB extends BaseEntity implements Serializable,
		Cloneable, IG373Info {

	/** 主键 */
	@Id
	protected String piidid;

	/** 流程定义ID */
	protected String pdid;

	/** 状态ID */
	protected String psdid;

	/** BL名称 */
	protected String piidblid;

	/** 描述 */
	protected String piiddec;

	/** 流程状态信息 */
	@ManyToOne
	@JoinColumn(name="psdid", referencedColumnName="psdid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG333TB ig333Info;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getPiidid() {
		return piidid;
	}

	/**
	 * 主键设定
	 *
	 * @param piidid 主键
	 */
	public void setPiidid(String piidid) {
		this.piidid = piidid;
	}

	/**
	 * 流程定义ID取得
	 *
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 *
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 状态ID取得
	 *
	 * @return 状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 状态ID设定
	 *
	 * @param psdid 状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * BL名称取得
	 *
	 * @return BL名称
	 */
	public String getPiidblid() {
		return piidblid;
	}

	/**
	 * BL名称设定
	 *
	 * @param piidblid BL名称
	 */
	public void setPiidblid(String piidblid) {
		this.piidblid = piidblid;
	}

	/**
	 * 描述取得
	 *
	 * @return 描述
	 */
	public String getPiiddec() {
		return piiddec;
	}

	/**
	 * 描述设定
	 *
	 * @param piiddec 描述
	 */
	public void setPiiddec(String piiddec) {
		this.piiddec = piiddec;
	}
	
	/**
	 * 流程状态信息取得
	 * 
	 * @return 流程状态信息
	 */
	public IG333TB getIg333Info() {
		return ig333Info;
	}

	/**
	 * 流程状态信息设定
	 * 
	 * @param ig333Info 流程状态信息
	 */
	public void setIg333Info(IG333TB ig333Info) {
		this.ig333Info = ig333Info;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return piidid;
	}

}
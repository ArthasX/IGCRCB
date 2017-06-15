/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG243Info;

/**
  * 概述: 流程标题定义表实体
  * 功能描述: 流程标题定义表实体
  * 创建记录: 2012/03/30
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG243")
public class IG243TB extends BaseEntity implements Serializable,
		Cloneable, IG243Info {

	/** 主键 */
	@Id
	protected String ptdid;

	/** 流程定义ID */
	protected String pdid;

	/** 主题名称定义 */
	protected String ptitlename;

	/** 主题名称权限 0可见；1不可见 */
	protected String ptitleaccess;

	/** 描述字段名称 */
	protected String pdescname;

	/** 描述字段权限 0：可见，1不可见 */
	protected String pdescaccess;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getPtdid() {
		return ptdid;
	}

	/**
	 * 主键设定
	 *
	 * @param ptdid 主键
	 */
	public void setPtdid(String ptdid) {
		this.ptdid = ptdid;
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
	 * 主题名称定义取得
	 *
	 * @return 主题名称定义
	 */
	public String getPtitlename() {
		return ptitlename;
	}

	/**
	 * 主题名称定义设定
	 *
	 * @param ptitlename 主题名称定义
	 */
	public void setPtitlename(String ptitlename) {
		this.ptitlename = ptitlename;
	}

	/**
	 * 主题名称权限 0可见；1不可见取得
	 *
	 * @return 主题名称权限 0可见；1不可见
	 */
	public String getPtitleaccess() {
		return ptitleaccess;
	}

	/**
	 * 主题名称权限 0可见；1不可见设定
	 *
	 * @param ptitleaccess 主题名称权限 0可见；1不可见
	 */
	public void setPtitleaccess(String ptitleaccess) {
		this.ptitleaccess = ptitleaccess;
	}

	/**
	 * 描述字段名称取得
	 *
	 * @return 描述字段名称
	 */
	public String getPdescname() {
		return pdescname;
	}

	/**
	 * 描述字段名称设定
	 *
	 * @param pdescname 描述字段名称
	 */
	public void setPdescname(String pdescname) {
		this.pdescname = pdescname;
	}

	/**
	 * 描述字段权限 0：可见，1不可见取得
	 *
	 * @return 描述字段权限 0：可见，1不可见
	 */
	public String getPdescaccess() {
		return pdescaccess;
	}

	/**
	 * 描述字段权限 0：可见，1不可见设定
	 *
	 * @param pdescaccess 描述字段权限 0：可见，1不可见
	 */
	public void setPdescaccess(String pdescaccess) {
		this.pdescaccess = pdescaccess;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return ptdid;
	}

}
/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.IG037Info;

/**
  * 概述: 流程导入日志表实体
  * 功能描述: 流程导入日志表实体
  * 创建记录: 2014/11/14
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="iG037")
public class IG037TB extends BaseEntity implements Serializable,
		Cloneable, IG037Info {

	/** 流程导入主键 */
	@Id
	@TableGenerator(
		name="IG037_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IG037_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG037_TABLE_GENERATOR")
	protected Integer irid;

	/** 流程主键 */
	protected Integer prid;

	/** 导入时间 */
	protected String irtime;

	/** 导入用户ID */
	protected String iruserid;

	/** 导入用户名称 */
	protected String irusername;

	/** 导入部门id */
	protected String irorgid;

	/** 导入部门名称 */
	protected String irorgname;

	/** 导入日志描述 */
	protected String irdesc;

	/** 导入日志内容 */
	protected String ircomment;

	/**
	 * 流程导入主键取得
	 *
	 * @return 流程导入主键
	 */
	public Integer getIrid() {
		return irid;
	}

	/**
	 * 流程导入主键设定
	 *
	 * @param irid 流程导入主键
	 */
	public void setIrid(Integer irid) {
		this.irid = irid;
	}

	/**
	 * 流程主键取得
	 *
	 * @return 流程主键
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程主键设定
	 *
	 * @param prid 流程主键
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 导入时间取得
	 *
	 * @return 导入时间
	 */
	public String getIrtime() {
		return irtime;
	}

	/**
	 * 导入时间设定
	 *
	 * @param irtime 导入时间
	 */
	public void setIrtime(String irtime) {
		this.irtime = irtime;
	}

	/**
	 * 导入用户ID取得
	 *
	 * @return 导入用户ID
	 */
	public String getIruserid() {
		return iruserid;
	}

	/**
	 * 导入用户ID设定
	 *
	 * @param iruserid 导入用户ID
	 */
	public void setIruserid(String iruserid) {
		this.iruserid = iruserid;
	}

	/**
	 * 导入用户名称取得
	 *
	 * @return 导入用户名称
	 */
	public String getIrusername() {
		return irusername;
	}

	/**
	 * 导入用户名称设定
	 *
	 * @param irusername 导入用户名称
	 */
	public void setIrusername(String irusername) {
		this.irusername = irusername;
	}

	/**
	 * 导入部门id取得
	 *
	 * @return 导入部门id
	 */
	public String getIrorgid() {
		return irorgid;
	}

	/**
	 * 导入部门id设定
	 *
	 * @param irorgid 导入部门id
	 */
	public void setIrorgid(String irorgid) {
		this.irorgid = irorgid;
	}

	/**
	 * 导入部门名称取得
	 *
	 * @return 导入部门名称
	 */
	public String getIrorgname() {
		return irorgname;
	}

	/**
	 * 导入部门名称设定
	 *
	 * @param irorgname 导入部门名称
	 */
	public void setIrorgname(String irorgname) {
		this.irorgname = irorgname;
	}

	/**
	 * 导入日志描述取得
	 *
	 * @return 导入日志描述
	 */
	public String getIrdesc() {
		return irdesc;
	}

	/**
	 * 导入日志描述设定
	 *
	 * @param irdesc 导入日志描述
	 */
	public void setIrdesc(String irdesc) {
		this.irdesc = irdesc;
	}

	/**
	 * 导入日志内容取得
	 *
	 * @return 导入日志内容
	 */
	public String getIrcomment() {
		return ircomment;
	}

	/**
	 * 导入日志内容设定
	 *
	 * @param ircomment 导入日志内容
	 */
	public void setIrcomment(String ircomment) {
		this.ircomment = ircomment;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return irid;
	}

}
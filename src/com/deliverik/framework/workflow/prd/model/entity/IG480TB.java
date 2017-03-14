/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG480Info;

/**
  * 概述: 流程组定义表实体
  * 功能描述: 流程组定义表实体
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG480")
public class IG480TB extends BaseEntity implements Serializable,
		Cloneable, IG480Info {

	/** 主键 */
	@Id
	protected String pgdid;

	/** 名称 */
	protected String pgdname;

	/** 描述 */
	protected String pgddesc;

	/** 状态 */
	protected String pgdstatus;

	/** 流程图xml */
	protected String pgdxml;

	/** 创建时间 */
	protected String pgdcrtime;

	/** 序列号生成处理类 */
	protected String serialGenerator;

	/** 模板类型 */
	protected Integer ptid;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getPgdid() {
		return pgdid;
	}

	/**
	 * 主键设定
	 *
	 * @param pgdid 主键
	 */
	public void setPgdid(String pgdid) {
		this.pgdid = pgdid;
	}

	/**
	 * 名称取得
	 *
	 * @return 名称
	 */
	public String getPgdname() {
		return pgdname;
	}

	/**
	 * 名称设定
	 *
	 * @param pgdname 名称
	 */
	public void setPgdname(String pgdname) {
		this.pgdname = pgdname;
	}

	/**
	 * 描述取得
	 *
	 * @return 描述
	 */
	public String getPgddesc() {
		return pgddesc;
	}

	/**
	 * 描述设定
	 *
	 * @param pgddesc 描述
	 */
	public void setPgddesc(String pgddesc) {
		this.pgddesc = pgddesc;
	}

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getPgdstatus() {
		return pgdstatus;
	}

	/**
	 * 状态设定
	 *
	 * @param pgdstatus 状态
	 */
	public void setPgdstatus(String pgdstatus) {
		this.pgdstatus = pgdstatus;
	}

	/**
	 * 流程图xml取得
	 *
	 * @return 流程图xml
	 */
	public String getPgdxml() {
		return pgdxml;
	}

	/**
	 * 流程图xml设定
	 *
	 * @param pgdxml 流程图xml
	 */
	public void setPgdxml(String pgdxml) {
		this.pgdxml = pgdxml;
	}

	/**
	 * 创建时间取得
	 *
	 * @return 创建时间
	 */
	public String getPgdcrtime() {
		return pgdcrtime;
	}

	/**
	 * 创建时间设定
	 *
	 * @param pgdcrtime 创建时间
	 */
	public void setPgdcrtime(String pgdcrtime) {
		this.pgdcrtime = pgdcrtime;
	}

	/**
	 * 序列号生成处理类取得
	 *
	 * @return 序列号生成处理类
	 */
	public String getSerialGenerator() {
		return serialGenerator;
	}

	/**
	 * 序列号生成处理类设定
	 *
	 * @param serialGenerator 序列号生成处理类
	 */
	public void setSerialGenerator(String serialGenerator) {
		this.serialGenerator = serialGenerator;
	}

	/**
	 * 模板类型取得
	 *
	 * @return 模板类型
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * 模板类型设定
	 *
	 * @param ptid 模板类型
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	@Override
	public Serializable getPK() {
		return pgdid;
	}

}
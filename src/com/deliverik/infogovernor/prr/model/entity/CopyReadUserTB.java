/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.prr.model.CopyReadUserInfo;

/**
  * 概述: 抄阅人表实体
  * 功能描述: 抄阅人表实体
  * 创建记录: 2013/02/25
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CopyReadUser")
public class CopyReadUserTB extends BaseEntity implements Serializable,
		Cloneable, CopyReadUserInfo {

	/** 无意义自增主键 */
	@Id
	@TableGenerator(
		name="COPYREADUSER_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="COPYREADUSER_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="COPYREADUSER_TABLE_GENERATOR")
	protected Integer cruid;

	/** 流程id */
	protected Integer prid;

	/** 流程编号 */
	protected String prserialnum;

	/** 流程名称 */
	protected String prtitle;

	/** 流程类型 */
	protected String prpdname ;

	/** 处理人角色 */
	protected String prrolename;

	/** 处理人姓名 */
	protected String prusername ;

	/** 处理状态 */
	protected String crustatus ;

	/** 分派时间 */
	protected String prassigntime;

	/** 查看时间 */
	protected String prlooktime;

	/** 是否查看标识 */
	protected String islook;

	/** 处理人id */
	protected String pruserid ;
	
	/** 流程开始时间 */
	protected String prstarttime;

	/** 流程定义id */
	protected String prpdid ;
	
	/** 流程子状态 */
	protected String prsubstatus;
	/**
	 * 无意义自增主键取得
	 *
	 * @return 无意义自增主键
	 */
	public Integer getCruid() {
		return cruid;
	}

	/**
	 * 无意义自增主键设定
	 *
	 * @param cruid 无意义自增主键
	 */
	public void setCruid(Integer cruid) {
		this.cruid = cruid;
	}

	/**
	 * 流程id取得
	 *
	 * @return 流程id
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程id设定
	 *
	 * @param prid 流程id
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 流程编号取得
	 *
	 * @return 流程编号
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * 流程编号设定
	 *
	 * @param prserialnum 流程编号
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	/**
	 * 流程名称取得
	 *
	 * @return 流程名称
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * 流程名称设定
	 *
	 * @param prtitle 流程名称
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * 流程类型取得
	 *
	 * @return 流程类型
	 */
	public String getPrpdname () {
		return prpdname ;
	}

	/**
	 * 流程类型设定
	 *
	 * @param prpdname  流程类型
	 */
	public void setPrpdname (String prpdname ) {
		this.prpdname  = prpdname ;
	}

	/**
	 * 处理人角色取得
	 *
	 * @return 处理人角色
	 */
	public String getPrrolename() {
		return prrolename;
	}

	/**
	 * 处理人角色设定
	 *
	 * @param prrolename 处理人角色
	 */
	public void setPrrolename(String prrolename) {
		this.prrolename = prrolename;
	}

	/**
	 * 处理人姓名取得
	 *
	 * @return 处理人姓名
	 */
	public String getPrusername () {
		return prusername ;
	}

	/**
	 * 处理人姓名设定
	 *
	 * @param prusername  处理人姓名
	 */
	public void setPrusername (String prusername ) {
		this.prusername  = prusername ;
	}

	/**
	 * 处理状态取得
	 *
	 * @return 处理状态
	 */
	public String getCrustatus () {
		return crustatus ;
	}

	/**
	 * 处理状态设定
	 *
	 * @param crustatus  处理状态
	 */
	public void setCrustatus (String crustatus ) {
		this.crustatus  = crustatus ;
	}

	/**
	 * 分派时间取得
	 *
	 * @return 分派时间
	 */
	public String getPrassigntime() {
		return prassigntime;
	}

	/**
	 * 分派时间设定
	 *
	 * @param prassigntime 分派时间
	 */
	public void setPrassigntime(String prassigntime) {
		this.prassigntime = prassigntime;
	}

	/**
	 * 查看时间取得
	 *
	 * @return 查看时间
	 */
	public String getPrlooktime() {
		return prlooktime;
	}

	/**
	 * 查看时间设定
	 *
	 * @param prlooktime 查看时间
	 */
	public void setPrlooktime(String prlooktime) {
		this.prlooktime = prlooktime;
	}

	/**
	 * 是否查看标识取得
	 *
	 * @return 是否查看标识
	 */
	public String getIslook() {
		return islook;
	}

	/**
	 * 是否查看标识设定
	 *
	 * @param islook 是否查看标识
	 */
	public void setIslook(String islook) {
		this.islook = islook;
	}

	/**
	 * 处理人id取得
	 *
	 * @return 处理人id
	 */
	public String getPruserid () {
		return pruserid ;
	}

	/**
	 * 处理人id设定
	 *
	 * @param pruserid  处理人id
	 */
	public void setPruserid (String pruserid ) {
		this.pruserid  = pruserid ;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return cruid;
	}
	/**
	 * 流程开始时间取得
	 *
	 * @return 流程开始时间
	 */
	public String getPrstarttime() {
		return prstarttime;
	}

	/**
	 * 流程开始时间设定
	 *
	 * @param prstarttime  流程开始时间
	 */
	public void setPrstarttime(String prstarttime) {
		this.prstarttime = prstarttime;
	}
	/**
	 * 流程定义id取得
	 *
	 * @return 流程定义id
	 */
	public String getPrpdid() {
		return prpdid;
	}
	/**
	 * 流程定义id设定
	 *
	 * @param prpdid  流程定义id
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * 流程子状态取得
	 *
	 * @return 流程子状态
	 */
	public String getPrsubstatus() {
		return prsubstatus;
	}

	/**
	 * 流程子状态设定
	 *
	 * @param prsubstatus  流程子状态
	 */
	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}

	
	
}
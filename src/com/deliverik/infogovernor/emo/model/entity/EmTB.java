/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.emo.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.emo.model.EmInfo;

/**
  * 概述: oracle性能采集实体
  * 功能描述: oracle性能采集实体
  * 创建记录: 2014/03/05
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="em")
public class EmTB extends BaseEntity implements Serializable,
		Cloneable, EmInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="EM_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="EM_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="EM_TABLE_GENERATOR")
	protected Integer em_id;

	/** 类型 */
	protected String em_type;

	/** 顶级sql的ID */
	protected String em_sqlid;

	/** 顶级会话的ID */
	protected String em_sessionid;

	/** SQL类型 */
	protected String em_sqltype;

	/** SQL内容 */
	protected String em_sqlcontent;

	/** 用户名 */
	protected String em_username;

	/** 程序 */
	protected String em_program;

	/** 指标名称 */
	protected String em_other;

	/** 指标名称 */
	protected String em_network;

	/** 指标名称 */
	protected String em_Queueing;

	/** 指标名称 */
	protected String em_Idle;

	/** 指标名称 */
	protected String em_Cluster;

	/** 指标名称 */
	protected String em_administrative;

	/** 指标名称 */
	protected String em_configuraction;

	/** 指标名称 */
	protected String em_commit;

	/** 指标名称 */
	protected String em_application;

	/** 指标名称 */
	protected String em_concurrency;

	/** 指标名称 */
	protected String em_systemIO;

	/** 指标名称 */
	protected String em_userIO;

	/** 指标名称 */
	protected String em_scheduler;

	/** 指标名称 */
	protected String em_cpu;

	/** 指标总和 */
	protected String em_Totail;

	/** 采集时间 */
	protected String em_Collecttime;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getEm_id() {
		return em_id;
	}

	/**
	 * 主键设定
	 *
	 * @param em_id 主键
	 */
	public void setEm_id(Integer em_id) {
		this.em_id = em_id;
	}

	/**
	 * 类型取得
	 *
	 * @return 类型
	 */
	public String getEm_type() {
		return em_type;
	}

	/**
	 * 类型设定
	 *
	 * @param em_type 类型
	 */
	public void setEm_type(String em_type) {
		this.em_type = em_type;
	}

	/**
	 * 顶级sql的ID取得
	 *
	 * @return 顶级sql的ID
	 */
	public String getEm_sqlid() {
		return em_sqlid;
	}

	/**
	 * 顶级sql的ID设定
	 *
	 * @param em_sqlid 顶级sql的ID
	 */
	public void setEm_sqlid(String em_sqlid) {
		this.em_sqlid = em_sqlid;
	}

	/**
	 * 顶级会话的ID取得
	 *
	 * @return 顶级会话的ID
	 */
	public String getEm_sessionid() {
		return em_sessionid;
	}

	/**
	 * 顶级会话的ID设定
	 *
	 * @param em_sessionid 顶级会话的ID
	 */
	public void setEm_sessionid(String em_sessionid) {
		this.em_sessionid = em_sessionid;
	}

	/**
	 * SQL类型取得
	 *
	 * @return SQL类型
	 */
	public String getEm_sqltype() {
		return em_sqltype;
	}

	/**
	 * SQL类型设定
	 *
	 * @param em_sqltype SQL类型
	 */
	public void setEm_sqltype(String em_sqltype) {
		this.em_sqltype = em_sqltype;
	}

	/**
	 * SQL内容取得
	 *
	 * @return SQL内容
	 */
	public String getEm_sqlcontent() {
		return em_sqlcontent;
	}

	/**
	 * SQL内容设定
	 *
	 * @param em_sqlcontent SQL内容
	 */
	public void setEm_sqlcontent(String em_sqlcontent) {
		this.em_sqlcontent = em_sqlcontent;
	}

	/**
	 * 用户名取得
	 *
	 * @return 用户名
	 */
	public String getEm_username() {
		return em_username;
	}

	/**
	 * 用户名设定
	 *
	 * @param em_username 用户名
	 */
	public void setEm_username(String em_username) {
		this.em_username = em_username;
	}

	/**
	 * 程序取得
	 *
	 * @return 程序
	 */
	public String getEm_program() {
		return em_program;
	}

	/**
	 * 程序设定
	 *
	 * @param em_program 程序
	 */
	public void setEm_program(String em_program) {
		this.em_program = em_program;
	}

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_other() {
		return em_other;
	}

	/**
	 * 指标名称设定
	 *
	 * @param em_other 指标名称
	 */
	public void setEm_other(String em_other) {
		this.em_other = em_other;
	}

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_network() {
		return em_network;
	}

	/**
	 * 指标名称设定
	 *
	 * @param em_network 指标名称
	 */
	public void setEm_network(String em_network) {
		this.em_network = em_network;
	}

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_Queueing() {
		return em_Queueing;
	}

	/**
	 * 指标名称设定
	 *
	 * @param em_Queueing 指标名称
	 */
	public void setEm_Queueing(String em_Queueing) {
		this.em_Queueing = em_Queueing;
	}

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_Idle() {
		return em_Idle;
	}

	/**
	 * 指标名称设定
	 *
	 * @param em_Idle 指标名称
	 */
	public void setEm_Idle(String em_Idle) {
		this.em_Idle = em_Idle;
	}

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_Cluster() {
		return em_Cluster;
	}

	/**
	 * 指标名称设定
	 *
	 * @param em_Cluster 指标名称
	 */
	public void setEm_Cluster(String em_Cluster) {
		this.em_Cluster = em_Cluster;
	}

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_administrative() {
		return em_administrative;
	}

	/**
	 * 指标名称设定
	 *
	 * @param em_administrative 指标名称
	 */
	public void setEm_administrative(String em_administrative) {
		this.em_administrative = em_administrative;
	}

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_configuraction() {
		return em_configuraction;
	}

	/**
	 * 指标名称设定
	 *
	 * @param em_configuraction 指标名称
	 */
	public void setEm_configuraction(String em_configuraction) {
		this.em_configuraction = em_configuraction;
	}

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_commit() {
		return em_commit;
	}

	/**
	 * 指标名称设定
	 *
	 * @param em_commit 指标名称
	 */
	public void setEm_commit(String em_commit) {
		this.em_commit = em_commit;
	}

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_application() {
		return em_application;
	}

	/**
	 * 指标名称设定
	 *
	 * @param em_application 指标名称
	 */
	public void setEm_application(String em_application) {
		this.em_application = em_application;
	}

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_concurrency() {
		return em_concurrency;
	}

	/**
	 * 指标名称设定
	 *
	 * @param em_concurrency 指标名称
	 */
	public void setEm_concurrency(String em_concurrency) {
		this.em_concurrency = em_concurrency;
	}

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_systemIO() {
		return em_systemIO;
	}

	/**
	 * 指标名称设定
	 *
	 * @param em_systemIO 指标名称
	 */
	public void setEm_systemIO(String em_systemIO) {
		this.em_systemIO = em_systemIO;
	}

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_userIO() {
		return em_userIO;
	}

	/**
	 * 指标名称设定
	 *
	 * @param em_userIO 指标名称
	 */
	public void setEm_userIO(String em_userIO) {
		this.em_userIO = em_userIO;
	}

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_scheduler() {
		return em_scheduler;
	}

	/**
	 * 指标名称设定
	 *
	 * @param em_scheduler 指标名称
	 */
	public void setEm_scheduler(String em_scheduler) {
		this.em_scheduler = em_scheduler;
	}

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_cpu() {
		return em_cpu;
	}

	/**
	 * 指标名称设定
	 *
	 * @param em_cpu 指标名称
	 */
	public void setEm_cpu(String em_cpu) {
		this.em_cpu = em_cpu;
	}

	/**
	 * 指标总和取得
	 *
	 * @return 指标总和
	 */
	public String getEm_Totail() {
		return em_Totail;
	}

	/**
	 * 指标总和设定
	 *
	 * @param em_Totail 指标总和
	 */
	public void setEm_Totail(String em_Totail) {
		this.em_Totail = em_Totail;
	}

	/**
	 * 采集时间取得
	 *
	 * @return 采集时间
	 */
	public String getEm_Collecttime() {
		return em_Collecttime;
	}

	/**
	 * 采集时间设定
	 *
	 * @param em_Collecttime 采集时间
	 */
	public void setEm_Collecttime(String em_Collecttime) {
		this.em_Collecttime = em_Collecttime;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return em_id;
	}

}
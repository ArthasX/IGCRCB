/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.kgm.model.KnowLogInfo;

/**
  * 概述: knowLog实体
  * 功能描述: knowLog实体
  * 创建记录: 2011/05/30
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="knowLog")
public class KnowLogTB extends BaseEntity implements Serializable,
		Cloneable, KnowLogInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="KNOWLOG_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="KNOWLOG_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="KNOWLOG_TABLE_GENERATOR")
	protected Integer klid;

	/** 知识ID */
	protected Integer klkid;

	/** 创建时间 */
	protected String kltime;

	/** 创建日志角色ID */
	protected String klroleid;

	/** 创建日子角色名字 */
	protected String klrolename;

	/** 用户ID */
	protected String kluserid;

	/** 用户名称 */
	protected String klusername;

	/** 日志描述 */
	protected String kldesc;

	/** 备注信息 */
	protected String klcommend;

	/** 机构ID */
	protected String klorgid;

	/** 机构名词 */
	protected String klorgname;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getKlid() {
		return klid;
	}

	/**
	 * 主键设定
	 *
	 * @param klid 主键
	 */
	public void setKlid(Integer klid) {
		this.klid = klid;
	}

	/**
	 * 知识ID取得
	 *
	 * @return 知识ID
	 */
	public Integer getKlkid() {
		return klkid;
	}

	/**
	 * 知识ID设定
	 *
	 * @param klkid 知识ID
	 */
	public void setKlkid(Integer klkid) {
		this.klkid = klkid;
	}

	/**
	 * 创建时间取得
	 *
	 * @return 创建时间
	 */
	public String getKltime() {
		return kltime;
	}

	/**
	 * 创建时间设定
	 *
	 * @param kltime 创建时间
	 */
	public void setKltime(String kltime) {
		this.kltime = kltime;
	}

	/**
	 * 创建日志角色ID取得
	 *
	 * @return 创建日志角色ID
	 */
	public String getKlroleid() {
		return klroleid;
	}

	/**
	 * 创建日志角色ID设定
	 *
	 * @param klroleid 创建日志角色ID
	 */
	public void setKlroleid(String klroleid) {
		this.klroleid = klroleid;
	}

	/**
	 * 创建日子角色名字取得
	 *
	 * @return 创建日子角色名字
	 */
	public String getKlrolename() {
		return klrolename;
	}

	/**
	 * 创建日子角色名字设定
	 *
	 * @param klrolename 创建日子角色名字
	 */
	public void setKlrolename(String klrolename) {
		this.klrolename = klrolename;
	}

	/**
	 * 用户ID取得
	 *
	 * @return 用户ID
	 */
	public String getKluserid() {
		return kluserid;
	}

	/**
	 * 用户ID设定
	 *
	 * @param kluserid 用户ID
	 */
	public void setKluserid(String kluserid) {
		this.kluserid = kluserid;
	}

	/**
	 * 用户名称取得
	 *
	 * @return 用户名称
	 */
	public String getKlusername() {
		return klusername;
	}

	/**
	 * 用户名称设定
	 *
	 * @param klusername 用户名称
	 */
	public void setKlusername(String klusername) {
		this.klusername = klusername;
	}

	/**
	 * 日志描述取得
	 *
	 * @return 日志描述
	 */
	public String getKldesc() {
		return kldesc;
	}

	/**
	 * 日志描述设定
	 *
	 * @param kldesc 日志描述
	 */
	public void setKldesc(String kldesc) {
		this.kldesc = kldesc;
	}

	/**
	 * 备注信息取得
	 *
	 * @return 备注信息
	 */
	public String getKlcommend() {
		return klcommend;
	}

	/**
	 * 备注信息设定
	 *
	 * @param klcommend 备注信息
	 */
	public void setKlcommend(String klcommend) {
		this.klcommend = klcommend;
	}

	/**
	 * 机构ID取得
	 *
	 * @return 机构ID
	 */
	public String getKlorgid() {
		return klorgid;
	}

	/**
	 * 机构ID设定
	 *
	 * @param klorgid 机构ID
	 */
	public void setKlorgid(String klorgid) {
		this.klorgid = klorgid;
	}

	/**
	 * 机构名词取得
	 *
	 * @return 机构名词
	 */
	public String getKlorgname() {
		return klorgname;
	}

	/**
	 * 机构名词设定
	 *
	 * @param klorgname 机构名词
	 */
	public void setKlorgname(String klorgname) {
		this.klorgname = klorgname;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return klid;
	}

}
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
import com.deliverik.framework.workflow.prr.model.IG506Info;

/**
  * 概述: 人员类表单值表实体
  * 功能描述: 人员类表单值表实体
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG506")
public class IG506TB extends BaseEntity implements Serializable,
		Cloneable, IG506Info {

	/** 主键 */
	@Id
	@TableGenerator(
		name="IG506_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IG506_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG506_TABLE_GENERATOR")
	protected Integer piuid;

	/** 流程主键 */
	protected Integer prid;

	/** 用户id */
	protected String piuserid;

	/** 用户名 */
	protected String piusername;

	/** 机构码 */
	protected String piorgid;

	/** 机构名称 */
	protected String piorgname;

	/** 角色id */
	protected Integer piroleid;

	/** 角色名称 */
	protected String pirolename;
	
	/** 电话 */
	protected String piphone;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPiuid() {
		return piuid;
	}

	/**
	 * 主键设定
	 *
	 * @param piuid 主键
	 */
	public void setPiuid(Integer piuid) {
		this.piuid = piuid;
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
	 * 用户id取得
	 *
	 * @return 用户id
	 */
	public String getPiuserid() {
		return piuserid;
	}

	/**
	 * 用户id设定
	 *
	 * @param piuserid 用户id
	 */
	public void setPiuserid(String piuserid) {
		this.piuserid = piuserid;
	}

	/**
	 * 用户名取得
	 *
	 * @return 用户名
	 */
	public String getPiusername() {
		return piusername;
	}

	/**
	 * 用户名设定
	 *
	 * @param piusername 用户名
	 */
	public void setPiusername(String piusername) {
		this.piusername = piusername;
	}

	/**
	 * 机构码取得
	 *
	 * @return 机构码
	 */
	public String getPiorgid() {
		return piorgid;
	}

	/**
	 * 机构码设定
	 *
	 * @param piorgid 机构码
	 */
	public void setPiorgid(String piorgid) {
		this.piorgid = piorgid;
	}

	/**
	 * 机构名称取得
	 *
	 * @return 机构名称
	 */
	public String getPiorgname() {
		return piorgname;
	}

	/**
	 * 机构名称设定
	 *
	 * @param piorgname 机构名称
	 */
	public void setPiorgname(String piorgname) {
		this.piorgname = piorgname;
	}

	/**
	 * 角色id取得
	 *
	 * @return 角色id
	 */
	public Integer getPiroleid() {
		return piroleid;
	}

	/**
	 * 角色id设定
	 *
	 * @param piroleid 角色id
	 */
	public void setPiroleid(Integer piroleid) {
		this.piroleid = piroleid;
	}

	/**
	 * 角色名称取得
	 *
	 * @return 角色名称
	 */
	public String getPirolename() {
		return pirolename;
	}

	/**
	 * 角色名称设定
	 *
	 * @param pirolename 角色名称
	 */
	public void setPirolename(String pirolename) {
		this.pirolename = pirolename;
	}

	/**
	 * 电话取得
	 * @return piphone 电话
	 */
	public String getPiphone() {
		return piphone;
	}

	/**
	 * 电话设定
	 * @param piphone 电话
	 */
	public void setPiphone(String piphone) {
		this.piphone = piphone;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return piuid;
	}

}
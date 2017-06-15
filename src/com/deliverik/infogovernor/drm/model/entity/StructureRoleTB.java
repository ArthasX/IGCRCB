/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.drm.model.StructureRoleInfo;

/**
  * 概述: 组织架构关联表实体
  * 功能描述: 组织架构关联表实体
  * 创建记录: 2015/03/09
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="StructureRole")
public class StructureRoleTB extends BaseEntity implements Serializable,
		Cloneable, StructureRoleInfo {

	/** 流水号 */
	@Id
	@TableGenerator(
		name="STRUCTUREROLE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="STRUCTUREROLE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="STRUCTUREROLE_TABLE_GENERATOR")
	protected Integer srid;

	/** 组织架构层次码 */
	protected String syscoding;

	/** 组织架构cid */
	protected String cid;

	/** 组织架构名称 */
	protected String sname;

	/** 角色id */
	protected Integer roleid;

	/** 角色名称 */
	protected String rolename;

	/** 组织架构类型 Y应急组织架构，R日常组织架构 */
	protected String srtype;

	/**
	 * 流水号取得
	 *
	 * @return 流水号
	 */
	public Integer getSrid() {
		return srid;
	}

	/**
	 * 流水号设定
	 *
	 * @param srid 流水号
	 */
	public void setSrid(Integer srid) {
		this.srid = srid;
	}

	/**
	 * 组织架构层次码取得
	 *
	 * @return 组织架构层次码
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * 组织架构层次码设定
	 *
	 * @param syscoding 组织架构层次码
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	/**
	 * 组织架构cid取得
	 *
	 * @return 组织架构cid
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * 组织架构cid设定
	 *
	 * @param cid 组织架构cid
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * 组织架构名称取得
	 *
	 * @return 组织架构名称
	 */
	public String getSname() {
		return sname;
	}

	/**
	 * 组织架构名称设定
	 *
	 * @param sname 组织架构名称
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}

	/**
	 * 角色id取得
	 *
	 * @return 角色id
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 角色id设定
	 *
	 * @param roleid 角色id
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 角色名称取得
	 *
	 * @return 角色名称
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * 角色名称设定
	 *
	 * @param rolename 角色名称
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * 组织架构类型 Y应急组织架构，R日常组织架构取得
	 *
	 * @return 组织架构类型 Y应急组织架构，R日常组织架构
	 */
	public String getSrtype() {
		return srtype;
	}

	/**
	 * 组织架构类型 Y应急组织架构，R日常组织架构设定
	 *
	 * @param srtype 组织架构类型 Y应急组织架构，R日常组织架构
	 */
	public void setSrtype(String srtype) {
		this.srtype = srtype;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	@Override
    public Serializable getPK() {
		return srid;
	}

}
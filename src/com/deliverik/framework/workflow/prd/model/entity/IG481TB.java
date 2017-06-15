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
import com.deliverik.framework.workflow.prd.model.IG481Info;

/**
  * 概述: 流程组成员表实体
  * 功能描述: 流程组成员表实体
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG481PK.class)
@Table(name="IG481")
public class IG481TB extends BaseEntity implements Serializable,
		Cloneable, IG481Info {

	/** 流程组id */
	@Id
	protected String pgdid;

	/** 单体流程id */
	@Id
	protected String pdid;

	/** 发起方式 */
	protected String createType;

	/** 流程版本 */
	protected String pdversion;

	/**
	 * 流程组id取得
	 *
	 * @return 流程组id
	 */
	public String getPgdid() {
		return pgdid;
	}

	/**
	 * 流程组id设定
	 *
	 * @param pgdid 流程组id
	 */
	public void setPgdid(String pgdid) {
		this.pgdid = pgdid;
	}

	/**
	 * 单体流程id取得
	 *
	 * @return 单体流程id
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 单体流程id设定
	 *
	 * @param pdid 单体流程id
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 发起方式取得
	 *
	 * @return 发起方式
	 */
	public String getCreateType() {
		return createType;
	}

	/**
	 * 发起方式设定
	 *
	 * @param createType 发起方式
	 */
	public void setCreateType(String createType) {
		this.createType = createType;
	}

	/**
	 * 流程版本取得
	 *
	 * @return 流程版本
	 */
	public String getPdversion() {
		return pdversion;
	}

	/**
	 * 流程版本设定
	 *
	 * @param pdversion 流程版本
	 */
	public void setPdversion(String pdversion) {
		this.pdversion = pdversion;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new IG481PK(pgdid, pdid);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pdid == null) ? 0 : pdid.hashCode());
		result = prime * result + ((pgdid == null) ? 0 : pgdid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IG481TB other = (IG481TB) obj;
		if (pdid == null) {
			if (other.pdid != null)
				return false;
		} else if (!pdid.equals(other.pdid))
			return false;
		if (pgdid == null) {
			if (other.pgdid != null)
				return false;
		} else if (!pgdid.equals(other.pgdid))
			return false;
		return true;
	}
	
}
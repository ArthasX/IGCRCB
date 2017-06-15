/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.IG484Info;

/**
  * 概述: 流程组成员实例实体
  * 功能描述: 流程组成员实例实体
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG484PK.class)
@Table(name="IG484")
public class IG484TB extends BaseEntity implements Serializable,
		Cloneable, IG484Info {

	/** 流程组实例ID */
	@Id
	protected Integer pgrid;
	
	/** 流程实例ID */
	@Id
	protected Integer prid;
	
	/** 流程定义ID */
	protected String pdid;

	/**
	 * 流程组实例ID取得
	 * @return 流程组实例ID
	 */
	public Integer getPgrid() {
		return pgrid;
	}

	/**
	 * 流程组实例ID设定
	 * @param pgrid 流程组实例ID
	 */
	public void setPgrid(Integer pgrid) {
		this.pgrid = pgrid;
	}

	/**
	 * 流程实例ID取得
	 * @return 流程实例ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程实例ID设定
	 * @param prid 流程实例ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	/**
	 * 流程定义ID取得
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new IG484PK(pgrid, prid);
	}

}
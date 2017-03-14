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
import com.deliverik.framework.workflow.prr.model.IG485Info;

/**
  * 概述: 流程组关联关系实例表实体
  * 功能描述: 流程组关联关系实例表实体
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG485PK.class)
@Table(name="IG485")
public class IG485TB extends BaseEntity implements Serializable,
		Cloneable, IG485Info {

	/** 流程组关联关系主键 */
	@Id
	protected String pgreid;

	/**  流程组实例ID */
	@Id
	protected Integer pgrid;

	/** 参考流程实例ID */
	@Id
	protected Integer prid;

	/** 状态 */
	protected String pgrrstatus;

	/** 完成时间 */
	protected String pgrtime;

	/**
	 * 流程组关联关系主键取得
	 *
	 * @return 流程组关联关系主键
	 */
	public String getPgreid() {
		return pgreid;
	}

	/**
	 * 流程组关联关系主键设定
	 *
	 * @param pgreid 流程组关联关系主键
	 */
	public void setPgreid(String pgreid) {
		this.pgreid = pgreid;
	}

	/**
	 *  流程组实例id取得
	 *
	 * @return  流程组实例id
	 */
	public Integer getPgrid() {
		return pgrid;
	}

	/**
	 *  流程组实例id设定
	 *
	 * @param pgrid  流程组实例id
	 */
	public void setPgrid(Integer pgrid) {
		this.pgrid = pgrid;
	}

	/**
	 * 参考流程实例ID取得
	 *
	 * @return 参考流程实例ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 参考流程实例ID设定
	 *
	 * @param prid 参考流程实例ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getPgrrstatus() {
		return pgrrstatus;
	}

	/**
	 * 状态设定
	 *
	 * @param pgrrstatus 状态
	 */
	public void setPgrrstatus(String pgrrstatus) {
		this.pgrrstatus = pgrrstatus;
	}

	/**
	 * 完成时间取得
	 *
	 * @return 完成时间
	 */
	public String getPgrtime() {
		return pgrtime;
	}

	/**
	 * 完成时间设定
	 *
	 * @param pgrtime 完成时间
	 */
	public void setPgrtime(String pgrtime) {
		this.pgrtime = pgrtime;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new IG485PK(pgreid, pgrid, prid);
	}
	
	

}
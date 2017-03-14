/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG482Info;

/**
  * 概述: 流程组关联关系定义表实体
  * 功能描述: 流程组关联关系定义表实体
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG482")
public class IG482TB extends BaseEntity implements Serializable,
		Cloneable, IG482Info {

	/** 主键 */
	@Id
	protected String pgreid;

	/** 流程组id */
	protected String pgdid;

	/** 参考流程定义 */
	protected String rpdid;

	/** 影响流程定义 */
	protected String ipdid;

	/** 跃迁规则 */
	protected String pgrerule;

	/** 参考流程状态 */
	protected String rpsdid;
	
	/** 参考流程目的状态 */
	protected String rtpsdid;

	/** 影响流程状态 */
	protected String ipsdid;

	/** 传递特殊处理 */
	protected String transferHandler;


	/**
	 * @return the 主键
	 */
	public String getPgreid() {
		return pgreid;
	}

	/**
	 * @param 主键 the pgreid to set
	 */
	public void setPgreid(String pgreid) {
		this.pgreid = pgreid;
	}

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
	 * 参考流程定义取得
	 *
	 * @return 参考流程定义
	 */
	public String getRpdid() {
		return rpdid;
	}

	/**
	 * 参考流程定义设定
	 *
	 * @param rpdid 参考流程定义
	 */
	public void setRpdid(String rpdid) {
		this.rpdid = rpdid;
	}

	/**
	 * 影响流程定义取得
	 *
	 * @return 影响流程定义
	 */
	public String getIpdid() {
		return ipdid;
	}

	/**
	 * 影响流程定义设定
	 *
	 * @param ipdid 影响流程定义
	 */
	public void setIpdid(String ipdid) {
		this.ipdid = ipdid;
	}

	/**
	 * 跃迁规则取得
	 *
	 * @return 跃迁规则
	 */
	public String getPgrerule() {
		return pgrerule;
	}

	/**
	 * 跃迁规则设定
	 *
	 * @param pgrerule 跃迁规则
	 */
	public void setPgrerule(String pgrerule) {
		this.pgrerule = pgrerule;
	}

	/**
	 * 参考流程状态取得
	 *
	 * @return 参考流程状态
	 */
	public String getRpsdid() {
		return rpsdid;
	}

	/**
	 * 参考流程状态设定
	 *
	 * @param rpsdid 参考流程状态
	 */
	public void setRpsdid(String rpsdid) {
		this.rpsdid = rpsdid;
	}

	/**
	 * 影响流程状态取得
	 *
	 * @return 影响流程状态
	 */
	public String getIpsdid() {
		return ipsdid;
	}

	/**
	 * 影响流程状态设定
	 *
	 * @param ipsdid 影响流程状态
	 */
	public void setIpsdid(String ipsdid) {
		this.ipsdid = ipsdid;
	}

	/**
	 * 传递特殊处理取得
	 *
	 * @return 传递特殊处理
	 */
	public String getTransferHandler() {
		return transferHandler;
	}

	/**
	 * 传递特殊处理设定
	 *
	 * @param transferHandler 传递特殊处理
	 */
	public void setTransferHandler(String transferHandler) {
		this.transferHandler = transferHandler;
	}
	
	/**
	 * 参考流程目的状态取得
	 * @return 参考流程目的状态
	 */
	public String getRtpsdid() {
		return rtpsdid;
	}

	/**
	 * 参考流程目的状态设定
	 * @param rtpsdid 参考流程目的状态
	 */
	public void setRtpsdid(String rtpsdid) {
		this.rtpsdid = rtpsdid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return pgreid;
	}

}
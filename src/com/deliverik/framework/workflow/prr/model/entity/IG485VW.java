/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
  * 概述: 流程组关联关系实例表实体
  * 功能描述: 流程组关联关系实例表实体
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG485PK.class)
public class IG485VW implements Serializable, Cloneable {

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
	
	/** 参考流程目的状态ID */
	protected String rtpsdid;
	
	/** 影响流程定义ID */
	protected String ipdid;
	
	/** 影响流程状态ID */
	protected String ipsdid;
	
	/** 影响流程跃迁处理BL */
	protected String transferhandler;

	

	/**
	 * @return the 流程组关联关系主键
	 */
	public String getPgreid() {
		return pgreid;
	}

	/**
	 * @param 流程组关联关系主键 the pgreid to set
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
	 * 参考流程目的状态ID取得
	 * @return 参考流程目的状态ID
	 */
	public String getRtpsdid() {
		return rtpsdid;
	}

	/**
	 * 参考流程目的状态ID设定
	 * @param rtpsdid 参考流程目的状态ID
	 */
	public void setRtpsdid(String rtpsdid) {
		this.rtpsdid = rtpsdid;
	}

	/**
	 * 影响流程定义ID取得
	 * @return 影响流程定义ID
	 */
	public String getIpdid() {
		return ipdid;
	}

	/**
	 * 影响流程定义ID设定
	 * @param ipdid 影响流程定义ID
	 */
	public void setIpdid(String ipdid) {
		this.ipdid = ipdid;
	}
	
	/**
	 * 影响流程状态ID取得
	 * @return 影响流程状态ID
	 */
	public String getIpsdid() {
		return ipsdid;
	}
	
	/**
	 * 影响流程状态ID设定
	 * @param ipsdid 影响流程状态ID
	 */
	public void setIpsdid(String ipsdid) {
		this.ipsdid = ipsdid;
	}

	/**
	 * 影响流程跃迁处理BL取得
	 * @return 影响流程跃迁处理BL
	 */
	public String getTransferhandler() {
		return transferhandler;
	}

	/**
	 * 影响流程跃迁处理BL设定
	 * @param transferhandler 影响流程跃迁处理BL
	 */
	public void setTransferhandler(String transferhandler) {
		this.transferhandler = transferhandler;
	}
	
}
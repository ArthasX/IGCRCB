/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rdp.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rdp.model.ExcuteResultInfo;

/**
  * 概述: ExcuteResult实体
  * 功能描述: ExcuteResult实体
  * 创建记录: 2014/04/16
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(ExcuteResultPK.class)
@Table(name="ExcuteResult")
public class ExcuteResultTB extends BaseEntity implements Serializable,
		Cloneable, ExcuteResultInfo {

	/** hostid */
	@Id
	protected String hostid;

	/** taskid */
	@Id
	protected Integer taskid;

	/** result */
	protected String result;

	/** resultDetail */
	protected String resultDetail;
	
	protected Integer state;
	
	protected String realtimedetail;



	public String getHostid() {
		return hostid;
	}

	public void setHostid(String hostid) {
		this.hostid = hostid;
	}

	/**
	 * taskid取得
	 *
	 * @return taskid
	 */
	public Integer getTaskid() {
		return taskid;
	}

	/**
	 * taskid设定
	 *
	 * @param taskid taskid
	 */
	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	/**
	 * result取得
	 *
	 * @return result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * result设定
	 *
	 * @param result result
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * resultDetail取得
	 *
	 * @return resultDetail
	 */
	public String getResultDetail() {
		return resultDetail;
	}

	/**
	 * resultDetail设定
	 *
	 * @param resultDetail resultDetail
	 */
	public void setResultDetail(String resultDetail) {
		this.resultDetail = resultDetail;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new ExcuteResultPK(hostid, taskid);
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getRealtimedetail() {
		return realtimedetail;
	}

	public void setRealtimedetail(String realtimedetail) {
		this.realtimedetail = realtimedetail;
	}

}
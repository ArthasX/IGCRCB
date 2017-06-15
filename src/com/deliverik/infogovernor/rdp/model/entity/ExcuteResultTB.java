/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
  * ����: ExcuteResultʵ��
  * ��������: ExcuteResultʵ��
  * ������¼: 2014/04/16
  * �޸ļ�¼: 
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
	 * taskidȡ��
	 *
	 * @return taskid
	 */
	public Integer getTaskid() {
		return taskid;
	}

	/**
	 * taskid�趨
	 *
	 * @param taskid taskid
	 */
	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	/**
	 * resultȡ��
	 *
	 * @return result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * result�趨
	 *
	 * @param result result
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * resultDetailȡ��
	 *
	 * @return resultDetail
	 */
	public String getResultDetail() {
		return resultDetail;
	}

	/**
	 * resultDetail�趨
	 *
	 * @param resultDetail resultDetail
	 */
	public void setResultDetail(String resultDetail) {
		this.resultDetail = resultDetail;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
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
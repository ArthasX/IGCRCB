/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: ExcuteResultʵ������
  * ��������: ExcuteResultʵ������
  * ������¼: 2014/04/16
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class ExcuteResultPK extends BasePK implements Serializable {

	/** hostid */
	protected String hostid;

	/** taskid */
	protected Integer taskid;

	/**
	 * ���캯��
	 */
	public ExcuteResultPK() {

	}

	/**
	 * ���캯��
	 */
	public ExcuteResultPK(String hostid,Integer  taskid) {
		super();
		this.hostid = hostid;
		this.taskid = taskid;
	}

	/**
	 * hostidȡ��
	 *
	 * @return hostid
	 */
	public String getHostid() {
		return hostid;
	}

	/**
	 * hostid�趨
	 *
	 * @param hostid hostid
	 */
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

}
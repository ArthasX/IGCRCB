/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rdp.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: ExcuteResult实体主键
  * 功能描述: ExcuteResult实体主键
  * 创建记录: 2014/04/16
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class ExcuteResultPK extends BasePK implements Serializable {

	/** hostid */
	protected String hostid;

	/** taskid */
	protected Integer taskid;

	/**
	 * 构造函数
	 */
	public ExcuteResultPK() {

	}

	/**
	 * 构造函数
	 */
	public ExcuteResultPK(String hostid,Integer  taskid) {
		super();
		this.hostid = hostid;
		this.taskid = taskid;
	}

	/**
	 * hostid取得
	 *
	 * @return hostid
	 */
	public String getHostid() {
		return hostid;
	}

	/**
	 * hostid设定
	 *
	 * @param hostid hostid
	 */
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

}
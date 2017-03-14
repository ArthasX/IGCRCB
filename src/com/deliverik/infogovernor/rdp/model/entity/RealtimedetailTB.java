/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rdp.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rdp.model.RealtimedetailInfo;

/**
  * 概述: 日志信息实体
  * 功能描述: 日志信息实体
  * 创建记录: 2014/05/06
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="realtimedetail")
public class RealtimedetailTB extends BaseEntity implements Serializable,
		Cloneable, RealtimedetailInfo {

	/** 主键 */
	@Id
	protected Integer id;

	/** 任务主键 */
	protected Integer taskid;

	/** 主机ip */
	protected String hostip;

	/** 内容 */
	protected String content;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 主键设定
	 *
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 任务主键取得
	 *
	 * @return 任务主键
	 */
	public Integer getTaskid() {
		return taskid;
	}

	/**
	 * 任务主键设定
	 *
	 * @param taskid 任务主键
	 */
	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	/**
	 * 主机ip取得
	 *
	 * @return 主机ip
	 */
	public String getHostip() {
		return hostip;
	}

	/**
	 * 主机ip设定
	 *
	 * @param hostip 主机ip
	 */
	public void setHostip(String hostip) {
		this.hostip = hostip;
	}

	/**
	 * 内容取得
	 *
	 * @return 内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 内容设定
	 *
	 * @param content 内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return id;
	}

}
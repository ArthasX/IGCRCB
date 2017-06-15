/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.drm.model.EventssInfo;

/**
  * 概述: 事件级别表实体
  * 功能描述: 事件级别表实体
  * 创建记录: 2015/03/18
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="eventss")
public class EventssTB extends BaseEntity implements Serializable,
		Cloneable, EventssInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="EVENTSS_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="EVENTSS_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="EVENTSS_TABLE_GENERATOR")
	protected Integer eventid;

	/** 事件名称 */
	protected String eventname;

	/** 事件等级 */
	protected Integer labels;
	
	/** 事件描述 */
	protected String eventdes;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getEventid() {
		return eventid;
	}

	/**
	 * 主键设定
	 *
	 * @param eventid 主键
	 */
	public void setEventid(Integer eventid) {
		this.eventid = eventid;
	}

	/**
	 * 事件名称取得
	 *
	 * @return 事件名称
	 */
	public String getEventname() {
		return eventname;
	}

	/**
	 * 事件名称设定
	 *
	 * @param eventname 事件名称
	 */
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	/**
	 * 事件等级取得
	 *
	 * @return 事件等级
	 */
	public Integer getLabels() {
		return labels;
	}

	/**
	 * 事件等级设定
	 *
	 * @param labels 事件等级
	 */
	public void setLabels(Integer labels) {
		this.labels = labels;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return eventid;
	}

	/**
	 * 事件描述取得
	 *
	 * @param eventdes 事件描述
	 */
	public String getEventdes() {
		return eventdes;
	}

	/**
	 * 事件描述设定
	 *
	 * @param eventdes 事件描述
	 */
	public void setEventdes(String eventdes) {
		this.eventdes = eventdes;
	}
}
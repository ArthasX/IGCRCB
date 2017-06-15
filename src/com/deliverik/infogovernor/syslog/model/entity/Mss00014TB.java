/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.syslog.model.Mss00014Info;

/**
  * 概述: mss00014实体
  * 功能描述: mss00014实体
  * 创建记录: 2014/01/21
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="mss00014")
public class Mss00014TB extends BaseEntity implements Serializable,
		Cloneable, Mss00014Info {

	/** id */
	@Id
	protected Integer id;

	/** alarmip */
	protected String alarmip;

	/** happentime */
	protected String happentime;

	/** count */
	protected Integer count;

	/**
	 * id取得
	 *
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * id设定
	 *
	 * @param id id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * alarmip取得
	 *
	 * @return alarmip
	 */
	public String getAlarmip() {
		return alarmip;
	}

	/**
	 * alarmip设定
	 *
	 * @param alarmip alarmip
	 */
	public void setAlarmip(String alarmip) {
		this.alarmip = alarmip;
	}

	/**
	 * happentime取得
	 *
	 * @return happentime
	 */
	public String getHappentime() {
		return happentime;
	}

	/**
	 * happentime设定
	 *
	 * @param happentime happentime
	 */
	public void setHappentime(String happentime) {
		this.happentime = happentime;
	}

	/**
	 * count取得
	 *
	 * @return count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * count设定
	 *
	 * @param count count
	 */
	public void setCount(Integer count) {
		this.count = count;
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
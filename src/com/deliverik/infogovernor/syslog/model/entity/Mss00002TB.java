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
import com.deliverik.infogovernor.syslog.model.Mss00002Info;

/**
  * 概述: 告警规则表实体
  * 功能描述: 告警规则表实体
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="mss00002")
public class Mss00002TB extends BaseEntity implements Serializable,
		Cloneable, Mss00002Info {

	/** ruleid */
	@Id
	@TableGenerator(
		name="MSS00002_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MSS00002_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MSS00002_TABLE_GENERATOR")
	protected Integer relationid;
	
	/** 设备IP */
	protected Integer deviceid;
	
	/** maxalarmnum */
	protected Integer maxalarmnum;

	/** maxalarmtime */
	protected Integer maxalarmtime;

	/** rulestate */
	protected Integer ruletempid;
	
	/** 创建时间 */
	protected String createtime;

	public Integer getRelationid() {
		return relationid;
	}

	public void setRelationid(Integer relationid) {
		this.relationid = relationid;
	}

	public Integer getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(Integer deviceid) {
		this.deviceid = deviceid;
	}

	public Integer getMaxalarmnum() {
		return maxalarmnum;
	}

	public void setMaxalarmnum(Integer maxalarmnum) {
		this.maxalarmnum = maxalarmnum;
	}

	public Integer getMaxalarmtime() {
		return maxalarmtime;
	}

	public void setMaxalarmtime(Integer maxalarmtime) {
		this.maxalarmtime = maxalarmtime;
	}

	public Integer getRuletempid() {
		return ruletempid;
	}

	public void setRuletempid(Integer ruletempid) {
		this.ruletempid = ruletempid;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public Serializable getPK() {
		return relationid;
	}
	

}
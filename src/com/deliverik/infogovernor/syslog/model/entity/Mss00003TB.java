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
import com.deliverik.infogovernor.syslog.model.Mss00003Info;

/**
  * 概述: 告警规则条件表实体
  * 功能描述: 告警规则条件表实体
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="mss00003")
public class Mss00003TB extends BaseEntity implements Serializable,
		Cloneable, Mss00003Info {

	/** ruleconditionid */
	@Id
	@TableGenerator(
		name="MSS00003_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MSS00003_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MSS00003_TABLE_GENERATOR")
	protected Integer ruleconditionid;

	/** 比对内容 */
	protected String alarmmsg;

	/** 比对条件 */
	protected Integer alarmcondition;
	
	/** 规则模板id */
	protected Integer ruletempid;
	
	/** 创建时间 */
	protected String createtime;
	
	/** 告警级别 */
	protected Integer alarmlevel;
	
	

	public Integer getAlarmlevel() {
		return alarmlevel;
	}

	public void setAlarmlevel(Integer alarmlevel) {
		this.alarmlevel = alarmlevel;
	}

	/**
	 * ruleconditionid取得
	 */
	public Integer getRuleconditionid() {
		return ruleconditionid;
	}

	/**
	 * ruleconditionid设定
	 */
	public void setRuleconditionid(Integer ruleconditionid) {
		this.ruleconditionid = ruleconditionid;
	}

	/**
	 * 比对内容取得
	 */
	public String getAlarmmsg() {
		return alarmmsg;
	}

	/**
	 * 比对内容设定
	 */
	public void setAlarmmsg(String alarmmsg) {
		this.alarmmsg = alarmmsg;
	}

	/**
	 * 比对条件取得
	 */
	public Integer getAlarmcondition() {
		return alarmcondition;
	}

	/**
	 * 比对条件设定
	 */
	public void setAlarmcondition(Integer alarmcondition) {
		this.alarmcondition = alarmcondition;
	}

	/**
	 * 规则模板id取得
	 */
	public Integer getRuletempid() {
		return ruletempid;
	}

	/**
	 * 规则模板id设定
	 */
	public void setRuletempid(Integer ruletempid) {
		this.ruletempid = ruletempid;
	}

	/**
	 * 创建时间取得
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * 创建时间设定
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	@Override
	public Serializable getPK() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
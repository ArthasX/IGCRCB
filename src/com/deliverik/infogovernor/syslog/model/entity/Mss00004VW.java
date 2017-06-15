/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.syslog.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.deliverik.infogovernor.syslog.model.Mss00004VWInfo;

/**
 * 
 * 规则模板视图
 *
 */
@SuppressWarnings("serial")
@Entity
public class Mss00004VW implements Serializable, Cloneable,Mss00004VWInfo{
	@Id
	protected Integer ruletempid;

	/** 模板名称 */
	protected String ruletempname;

	/** 设备类型 */
	protected String typeid;
	
	/** 规则条件 */
	protected Integer rulecondition;
	
	/** 模板状态 */
	protected Integer tempstate;
	
	/** 创建时间 */
	protected String createtime;
	
	/** 描述 */
	protected String tempdesc;
	
	/** 条件个数 */
	protected String conditionCount;
	
	/** 概述 */
	protected String summary;
	

	/**
	 * ruletempid取得
	 */
	public Integer getRuletempid() {
		return ruletempid;
	}

	/**
	 * ruletempid设定
	 */
	public void setRuletempid(Integer ruletempid) {
		this.ruletempid = ruletempid;
	}

	/**
	 * 模板名称取得
	 */
	public String getRuletempname() {
		return ruletempname;
	}

	/**
	 * 模板名称设定
	 */
	public void setRuletempname(String ruletempname) {
		this.ruletempname = ruletempname;
	}

	/**
	 * 设备类型取得
	 */
	public String getTypeid() {
		return typeid;
	}

	/**
	 * 设备类型设定
	 */
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	/**
	 * 规则条件取得
	 */
	public Integer getRulecondition() {
		return rulecondition;
	}

	/**
	 * 规则条件设定
	 */
	public void setRulecondition(Integer rulecondition) {
		this.rulecondition = rulecondition;
	}

	/**
	 * 模板状态取得
	 */
	public Integer getTempstate() {
		return tempstate;
	}

	/**
	 * 模板状态设定
	 */
	public void setTempstate(Integer tempstate) {
		this.tempstate = tempstate;
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

	/**
	 * 描述取得
	 */
	public String getTempdesc() {
		return tempdesc;
	}

	/**
	 * 描述设定
	 */
	public void setTempdesc(String tempdesc) {
		this.tempdesc = tempdesc;
	}

	/**
	 * 条件个数取得
	 */
	public String getConditionCount() {
		return conditionCount;
	}

	/**
	 * 条件个数设定
	 */
	public void setConditionCount(String conditionCount) {
		this.conditionCount = conditionCount;
	}
	
	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}
	
}

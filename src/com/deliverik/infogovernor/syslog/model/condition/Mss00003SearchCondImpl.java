/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.condition;

/**
  * 概述: 告警规则条件表检索条件实现
  * 功能描述: 告警规则条件表检索条件实现
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public class Mss00003SearchCondImpl implements
		Mss00003SearchCond {
	/** 条件id */
	protected Integer ruleconditionid;

	/** 比对内容 */
	protected String alarmmsg;

	/** 比对条件 */
	protected Integer alarmcondition;
	
	/** 规则模板id */
	protected Integer ruletempid;
	
	/** 创建时间 */
	protected String createtime;
	
	/** 是否是模板标示 */
	protected String isTemp;

	/**
	 * 条件id取得
	 */
	public Integer getRuleconditionid() {
		return ruleconditionid;
	}

	/**
	 * 条件id设定
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

	/**
	 * 是否是模板标示取得
	 */
	public String getIsTemp() {
		return isTemp;
	}

	/**
	 * 是否是模板标示设定
	 */
	public void setIsTemp(String isTemp) {
		this.isTemp = isTemp;
	}
	
	
	

}
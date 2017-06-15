package com.deliverik.infogovernor.syslog.form;

import com.deliverik.framework.base.BaseForm;
/**
 * 
 * 规则模板新增form
 *
 * @作者 zhaoyong
 *
 * 2013-4-2
 */
@SuppressWarnings("serial")
public class IGLOG0042Form extends BaseForm{

	/** 模板id */
	protected Integer ruletempid;

	/** 模板名称 */
	protected String ruletempname;

	/** 模板状态 */
	protected Integer tempstate;
	
	/** 设备类型id */
	protected String typeid;
	
	/** 创建时间 */
	protected String createtime;
	
	/** 规则条件集合 */
	protected String[] alarmconditions;
	
	/** 条件内容集合 */
	protected String[] alarmmsgs;
	
	/** 条件 */
	protected Integer rulecondition;
	
	/** 描述 */
	protected String tempdesc;
	
	/** 告警级别 */
	protected String[] priority;
	
	/** 汇总实时告警信息标识 */
	protected String isRealTimeCollect;
	
	public String[] getPriority() {
		return priority;
	}

	public void setPriority(String[] priority) {
		this.priority = priority;
	}

	/**
	 * 模板id取得
	 */
	public Integer getRuletempid() {
		return ruletempid;
	}

	/**
	 * 模板id设定
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
	 * 设备类型id取得
	 */
	public String getTypeid() {
		return typeid;
	}

	/**
	 * 设备类型id设定
	 */
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	/**
	 * 规则条件集合取得
	 */
	public String[] getAlarmconditions() {
		return alarmconditions;
	}

	/**
	 * 规则条件集合设定
	 */
	public void setAlarmconditions(String[] alarmconditions) {
		this.alarmconditions = alarmconditions;
	}

	/**
	 * 条件内容集合取得
	 */
	public String[] getAlarmmsgs() {
		return alarmmsgs;
	}

	/**
	 * 条件内容集合设定
	 */
	public void setAlarmmsgs(String[] alarmmsgs) {
		this.alarmmsgs = alarmmsgs;
	}

	/**
	 * 条件取得
	 */
	public Integer getRulecondition() {
		return rulecondition;
	}

	/**
	 * 条件设定
	 */
	public void setRulecondition(Integer rulecondition) {
		this.rulecondition = rulecondition;
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
	 * 汇总实时告警信息标识取得
	 *
	 * @return bname_like 汇总实时告警信息标识
	 */
	public String getIsRealTimeCollect() {
		return isRealTimeCollect;
	}
	
	/**
	 * 汇总实时告警信息标识设定
	 *
	 * @param isRealTimeCollect 汇总实时告警信息标识
	 */
	public void setIsRealTimeCollect(String isRealTimeCollect) {
		this.isRealTimeCollect = isRealTimeCollect;
	}
	
}

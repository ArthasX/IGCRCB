/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.alarm.form;


import com.deliverik.framework.base.BaseForm;

/**
 * 
 * @author wangxing@deliverik.com
 */
@SuppressWarnings("serial")
public class IGALM0201Form extends BaseForm {
	
	protected String ruletempid;//主键
	
	protected String ruletempname;//规则模板名称
	
	protected String typeid;//监控对象类型
	
	protected String categoryid;//指标
	
	protected String[] alarmconditions;//条件选项
	
	protected String[] alarmmsgs;//告警对比内容
	
	protected String tempdesc;//模板描述
	
	protected String rulecondition;//规则条件逻辑关系（与、或）
	
	protected String tempstate;//规则状态
	
	protected String level;//规则触发告警级别
	
	

	public String getRuletempname() {
		return ruletempname;
	}

	public void setRuletempname(String ruletempname) {
		this.ruletempname = ruletempname;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	public String[] getAlarmconditions() {
		return alarmconditions;
	}

	public void setAlarmconditions(String[] alarmconditions) {
		this.alarmconditions = alarmconditions;
	}

	public String[] getAlarmmsgs() {
		return alarmmsgs;
	}

	public void setAlarmmsgs(String[] alarmmsgs) {
		this.alarmmsgs = alarmmsgs;
	}

	public String getTempdesc() {
		return tempdesc;
	}

	public void setTempdesc(String tempdesc) {
		this.tempdesc = tempdesc;
	}

	public String getRulecondition() {
		return rulecondition;
	}

	public void setRulecondition(String rulecondition) {
		this.rulecondition = rulecondition;
	}

	public String getTempstate() {
		return tempstate;
	}

	public void setTempstate(String tempstate) {
		this.tempstate = tempstate;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getRuletempid() {
		return ruletempid;
	}

	public void setRuletempid(String ruletempid) {
		this.ruletempid = ruletempid;
	}
	
}

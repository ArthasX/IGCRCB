/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
	
	protected String ruletempid;//����
	
	protected String ruletempname;//����ģ������
	
	protected String typeid;//��ض�������
	
	protected String categoryid;//ָ��
	
	protected String[] alarmconditions;//����ѡ��
	
	protected String[] alarmmsgs;//�澯�Ա�����
	
	protected String tempdesc;//ģ������
	
	protected String rulecondition;//���������߼���ϵ���롢��
	
	protected String tempstate;//����״̬
	
	protected String level;//���򴥷��澯����
	
	

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

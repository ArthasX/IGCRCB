/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.alarm.model.CRM07Info;

/**
  * ����: CRM07ʵ��
  * ��������: CRM07ʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CRM07")
public class CRM07TB extends BaseEntity implements Serializable,
		Cloneable, CRM07Info {

	/** RULECONDITIONID */
	@Id
	@GeneratedValue(generator = "RULECONDITIONID")
	@GenericGenerator(name = "RULECONDITIONID", strategy = "sequence", 
			parameters = { @Parameter(name = "sequence", 
						value = "crm07_seq") })
	protected Integer ruleconditionid;

	/** RULETEMPID */
	protected Integer ruletempid;

	/** ALARMMSG */
	protected String alarmmsg;

	/** ALARMCONDITION */
	protected Integer alarmcondition;
	
	protected String createtime;

	public Integer getRuleconditionid() {
		return ruleconditionid;
	}

	public void setRuleconditionid(Integer ruleconditionid) {
		this.ruleconditionid = ruleconditionid;
	}

	public Integer getRuletempid() {
		return ruletempid;
	}

	public void setRuletempid(Integer ruletempid) {
		this.ruletempid = ruletempid;
	}

	public String getAlarmmsg() {
		return alarmmsg;
	}

	public void setAlarmmsg(String alarmmsg) {
		this.alarmmsg = alarmmsg;
	}

	public Integer getAlarmcondition() {
		return alarmcondition;
	}

	public void setAlarmcondition(Integer alarmcondition) {
		this.alarmcondition = alarmcondition;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	@Override
	public Serializable getPK() {
		return ruleconditionid;
	}

}
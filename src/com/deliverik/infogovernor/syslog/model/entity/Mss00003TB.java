/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
  * ����: �澯����������ʵ��
  * ��������: �澯����������ʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
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

	/** �ȶ����� */
	protected String alarmmsg;

	/** �ȶ����� */
	protected Integer alarmcondition;
	
	/** ����ģ��id */
	protected Integer ruletempid;
	
	/** ����ʱ�� */
	protected String createtime;
	
	/** �澯���� */
	protected Integer alarmlevel;
	
	

	public Integer getAlarmlevel() {
		return alarmlevel;
	}

	public void setAlarmlevel(Integer alarmlevel) {
		this.alarmlevel = alarmlevel;
	}

	/**
	 * ruleconditionidȡ��
	 */
	public Integer getRuleconditionid() {
		return ruleconditionid;
	}

	/**
	 * ruleconditionid�趨
	 */
	public void setRuleconditionid(Integer ruleconditionid) {
		this.ruleconditionid = ruleconditionid;
	}

	/**
	 * �ȶ�����ȡ��
	 */
	public String getAlarmmsg() {
		return alarmmsg;
	}

	/**
	 * �ȶ������趨
	 */
	public void setAlarmmsg(String alarmmsg) {
		this.alarmmsg = alarmmsg;
	}

	/**
	 * �ȶ�����ȡ��
	 */
	public Integer getAlarmcondition() {
		return alarmcondition;
	}

	/**
	 * �ȶ������趨
	 */
	public void setAlarmcondition(Integer alarmcondition) {
		this.alarmcondition = alarmcondition;
	}

	/**
	 * ����ģ��idȡ��
	 */
	public Integer getRuletempid() {
		return ruletempid;
	}

	/**
	 * ����ģ��id�趨
	 */
	public void setRuletempid(Integer ruletempid) {
		this.ruletempid = ruletempid;
	}

	/**
	 * ����ʱ��ȡ��
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * ����ʱ���趨
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
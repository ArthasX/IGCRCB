/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
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
 * ����ģ����ͼ
 *
 */
@SuppressWarnings("serial")
@Entity
public class Mss00004VW implements Serializable, Cloneable,Mss00004VWInfo{
	@Id
	protected Integer ruletempid;

	/** ģ������ */
	protected String ruletempname;

	/** �豸���� */
	protected String typeid;
	
	/** �������� */
	protected Integer rulecondition;
	
	/** ģ��״̬ */
	protected Integer tempstate;
	
	/** ����ʱ�� */
	protected String createtime;
	
	/** ���� */
	protected String tempdesc;
	
	/** �������� */
	protected String conditionCount;
	
	/** ���� */
	protected String summary;
	

	/**
	 * ruletempidȡ��
	 */
	public Integer getRuletempid() {
		return ruletempid;
	}

	/**
	 * ruletempid�趨
	 */
	public void setRuletempid(Integer ruletempid) {
		this.ruletempid = ruletempid;
	}

	/**
	 * ģ������ȡ��
	 */
	public String getRuletempname() {
		return ruletempname;
	}

	/**
	 * ģ�������趨
	 */
	public void setRuletempname(String ruletempname) {
		this.ruletempname = ruletempname;
	}

	/**
	 * �豸����ȡ��
	 */
	public String getTypeid() {
		return typeid;
	}

	/**
	 * �豸�����趨
	 */
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	/**
	 * ��������ȡ��
	 */
	public Integer getRulecondition() {
		return rulecondition;
	}

	/**
	 * ���������趨
	 */
	public void setRulecondition(Integer rulecondition) {
		this.rulecondition = rulecondition;
	}

	/**
	 * ģ��״̬ȡ��
	 */
	public Integer getTempstate() {
		return tempstate;
	}

	/**
	 * ģ��״̬�趨
	 */
	public void setTempstate(Integer tempstate) {
		this.tempstate = tempstate;
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

	/**
	 * ����ȡ��
	 */
	public String getTempdesc() {
		return tempdesc;
	}

	/**
	 * �����趨
	 */
	public void setTempdesc(String tempdesc) {
		this.tempdesc = tempdesc;
	}

	/**
	 * ��������ȡ��
	 */
	public String getConditionCount() {
		return conditionCount;
	}

	/**
	 * ���������趨
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

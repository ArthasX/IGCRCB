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
import com.deliverik.infogovernor.syslog.model.Mss00004Info;

/**
  * ����: �澯����ģ���ʵ��
  * ��������: �澯����ģ���ʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="mss00004")
public class Mss00004TB extends BaseEntity implements Serializable,
		Cloneable, Mss00004Info {

	/** ruletempid */
	@Id
	@TableGenerator(
		name="MSS00004_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MSS00004_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MSS00004_TABLE_GENERATOR")
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
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return ruletempid;
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


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}
	

}
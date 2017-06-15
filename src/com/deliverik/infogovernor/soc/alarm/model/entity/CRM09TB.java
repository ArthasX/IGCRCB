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
import com.deliverik.infogovernor.soc.alarm.model.CRM09Info;

/**
  * ����: CRM09ʵ��
  * ��������: CRM09ʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CRM09")
public class CRM09TB extends BaseEntity implements Serializable,
		Cloneable, CRM09Info {

	/** RELATIONID */
	@Id
	@GeneratedValue(generator = "relationid")
	@GenericGenerator(name = "relationid", strategy = "sequence", 
			parameters = { @Parameter(name = "sequence", 
						value = "crm09_seq") })
	protected Integer relationid;

	/** SERVERID */
	protected Integer serverid;

	/** RULETEMPID */
	protected Integer ruletempid;

	/** MAXALARMNUM */
	protected Integer maxalarmnum;

	/** MAXALARMTIME */
	protected Integer maxalarmtime;
	
	protected String createtime;

	
	public Integer getRelationid() {
		return relationid;
	}


	public void setRelationid(Integer relationid) {
		this.relationid = relationid;
	}


	public Integer getServerid() {
		return serverid;
	}


	public void setServerid(Integer serverid) {
		this.serverid = serverid;
	}


	public Integer getRuletempid() {
		return ruletempid;
	}


	public void setRuletempid(Integer ruletempid) {
		this.ruletempid = ruletempid;
	}


	public Integer getMaxalarmnum() {
		return maxalarmnum;
	}


	public void setMaxalarmnum(Integer maxalarmnum) {
		this.maxalarmnum = maxalarmnum;
	}


	public Integer getMaxalarmtime() {
		return maxalarmtime;
	}


	public void setMaxalarmtime(Integer maxalarmtime) {
		this.maxalarmtime = maxalarmtime;
	}


	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return relationid;
	}


	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

}
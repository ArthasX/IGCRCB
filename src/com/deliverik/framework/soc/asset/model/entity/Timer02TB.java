/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.Timer02Info;

/**
  * ����: timer02ʵ��
  * ��������: timer02ʵ��
  * ������¼: 2013/07/04
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="timer02")
public class Timer02TB extends BaseEntity implements Serializable,
		Cloneable, Timer02Info {
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "sequence", 
			parameters = { @Parameter(name = "sequence", 
						value = "timer02_seq") })
	protected Integer id;

	/** uuid */
	protected String uuid;

	/** name */
	protected String name;

	/** type */
	protected String typename;

	/** collectdate */
	protected String collectdate;

	/** executrule */
	protected String executrule;

	/** periodtype */
	protected String periodtype;

	/** executstatus */
	protected String executstatus;
	
	private String executmessage;

	/**
	 * uuidȡ��
	 *
	 * @return uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * uuid�趨
	 *
	 * @param uuid uuid
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * nameȡ��
	 *
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * name�趨
	 *
	 * @param name name
	 */
	public void setName(String name) {
		this.name = name;
	}

	

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	/**
	 * collectdateȡ��
	 *
	 * @return collectdate
	 */
	public String getCollectdate() {
		return collectdate;
	}

	/**
	 * collectdate�趨
	 *
	 * @param collectdate collectdate
	 */
	public void setCollectdate(String collectdate) {
		this.collectdate = collectdate;
	}

	/**
	 * executruleȡ��
	 *
	 * @return executrule
	 */
	public String getExecutrule() {
		return executrule;
	}

	/**
	 * executrule�趨
	 *
	 * @param executrule executrule
	 */
	public void setExecutrule(String executrule) {
		this.executrule = executrule;
	}

	/**
	 * periodtypeȡ��
	 *
	 * @return periodtype
	 */
	public String getPeriodtype() {
		return periodtype;
	}

	/**
	 * periodtype�趨
	 *
	 * @param periodtype periodtype
	 */
	public void setPeriodtype(String periodtype) {
		this.periodtype = periodtype;
	}

	/**
	 * executstatusȡ��
	 *
	 * @return executstatus
	 */
	public String getExecutstatus() {
		return executstatus;
	}

	/**
	 * executstatus�趨
	 *
	 * @param executstatus executstatus
	 */
	public void setExecutstatus(String executstatus) {
		this.executstatus = executstatus;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return uuid;
	}

	public void setExecutmessage(String executmessage) {
		this.executmessage = executmessage;
	}

	public String getExecutmessage() {
		return executmessage;
	}

}
/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.io.Serializable;


/**
  * ����: timer02��������ʵ��
  * ��������: timer02��������ʵ��
  * ������¼: 2013/07/04
  * �޸ļ�¼: 
  */
public class Timer02SearchCondImpl implements
		Timer02SearchCond {
	/** uuid */
	protected String uuid;

	/** name */
	protected String name;

	/** type */
	protected String type;

	/** collectdate */
	protected String collectdate;

	/** executrule */
	protected String executrule;

	/** periodtype */
	protected String periodtype;

	/** executstatus */
	protected String executstatus;

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

	/**
	 * typeȡ��
	 *
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * type�趨
	 *
	 * @param type type
	 */
	public void setType(String type) {
		this.type = type;
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
}
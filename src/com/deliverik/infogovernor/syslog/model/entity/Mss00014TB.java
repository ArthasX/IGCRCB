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
import com.deliverik.infogovernor.syslog.model.Mss00014Info;

/**
  * ����: mss00014ʵ��
  * ��������: mss00014ʵ��
  * ������¼: 2014/01/21
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="mss00014")
public class Mss00014TB extends BaseEntity implements Serializable,
		Cloneable, Mss00014Info {

	/** id */
	@Id
	protected Integer id;

	/** alarmip */
	protected String alarmip;

	/** happentime */
	protected String happentime;

	/** count */
	protected Integer count;

	/**
	 * idȡ��
	 *
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * id�趨
	 *
	 * @param id id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * alarmipȡ��
	 *
	 * @return alarmip
	 */
	public String getAlarmip() {
		return alarmip;
	}

	/**
	 * alarmip�趨
	 *
	 * @param alarmip alarmip
	 */
	public void setAlarmip(String alarmip) {
		this.alarmip = alarmip;
	}

	/**
	 * happentimeȡ��
	 *
	 * @return happentime
	 */
	public String getHappentime() {
		return happentime;
	}

	/**
	 * happentime�趨
	 *
	 * @param happentime happentime
	 */
	public void setHappentime(String happentime) {
		this.happentime = happentime;
	}

	/**
	 * countȡ��
	 *
	 * @return count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * count�趨
	 *
	 * @param count count
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return id;
	}

}
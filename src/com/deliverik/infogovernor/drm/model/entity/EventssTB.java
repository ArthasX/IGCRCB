/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.drm.model.EventssInfo;

/**
  * ����: �¼������ʵ��
  * ��������: �¼������ʵ��
  * ������¼: 2015/03/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="eventss")
public class EventssTB extends BaseEntity implements Serializable,
		Cloneable, EventssInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="EVENTSS_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="EVENTSS_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="EVENTSS_TABLE_GENERATOR")
	protected Integer eventid;

	/** �¼����� */
	protected String eventname;

	/** �¼��ȼ� */
	protected Integer labels;
	
	/** �¼����� */
	protected String eventdes;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getEventid() {
		return eventid;
	}

	/**
	 * �����趨
	 *
	 * @param eventid ����
	 */
	public void setEventid(Integer eventid) {
		this.eventid = eventid;
	}

	/**
	 * �¼�����ȡ��
	 *
	 * @return �¼�����
	 */
	public String getEventname() {
		return eventname;
	}

	/**
	 * �¼������趨
	 *
	 * @param eventname �¼�����
	 */
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	/**
	 * �¼��ȼ�ȡ��
	 *
	 * @return �¼��ȼ�
	 */
	public Integer getLabels() {
		return labels;
	}

	/**
	 * �¼��ȼ��趨
	 *
	 * @param labels �¼��ȼ�
	 */
	public void setLabels(Integer labels) {
		this.labels = labels;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return eventid;
	}

	/**
	 * �¼�����ȡ��
	 *
	 * @param eventdes �¼�����
	 */
	public String getEventdes() {
		return eventdes;
	}

	/**
	 * �¼������趨
	 *
	 * @param eventdes �¼�����
	 */
	public void setEventdes(String eventdes) {
		this.eventdes = eventdes;
	}
}
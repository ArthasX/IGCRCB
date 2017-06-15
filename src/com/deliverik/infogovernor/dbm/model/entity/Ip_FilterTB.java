/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.dbm.model.Ip_FilterInfo;

/**
  * ����: ȫ��IP����ʵ��
  * ��������: ȫ��IP����ʵ��
  * ������¼: 2012/11/07
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="Hq_Ip_Filter")
public class Ip_FilterTB extends BaseEntity implements Serializable,
		Cloneable, Ip_FilterInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="IP_FILTER_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IP_FILTER_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IP_FILTER_TABLE_GENERATOR")
	protected Integer id;

	/** IP��ַ */
	protected String ip;

	/** ���ʱ�� */
	protected String addtime;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * �����趨
	 *
	 * @param id ����
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * IP��ַȡ��
	 *
	 * @return IP��ַ
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * IP��ַ�趨
	 *
	 * @param ip IP��ַ
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * ���ʱ��ȡ��
	 *
	 * @return ���ʱ��
	 */
	public String getAddtime() {
		return addtime;
	}

	/**
	 * ���ʱ���趨
	 *
	 * @param addtime ���ʱ��
	 */
	public void setAddtime(String addtime) {
		this.addtime = addtime;
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
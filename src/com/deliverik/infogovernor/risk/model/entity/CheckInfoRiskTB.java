/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.risk.model.CheckInfoRiskInfo;

/**
  * ����: �����Թ���������ʵ��
  * ��������: �����Թ���������ʵ��
  * ������¼: 2014/09/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CheckInfoRisk")
public class CheckInfoRiskTB extends BaseEntity implements Serializable,
		Cloneable, CheckInfoRiskInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="CHECKINFORISK_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CHECKINFORISK_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CHECKINFORISK_TABLE_GENERATOR")
	protected Integer cieid;

	/** ������id */
	protected Integer csid;

	/** �����id */
	protected Integer rcid;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getCieid() {
		return cieid;
	}

	/**
	 * �����趨
	 *
	 * @param cieid ����
	 */
	public void setCieid(Integer cieid) {
		this.cieid = cieid;
	}

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public Integer getCsid() {
		return csid;
	}

	/**
	 * ������id�趨
	 *
	 * @param csid ������id
	 */
	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	/**
	 * �����idȡ��
	 *
	 * @return �����id
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * �����id�趨
	 *
	 * @param rcid �����id
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return cieid;
	}

}
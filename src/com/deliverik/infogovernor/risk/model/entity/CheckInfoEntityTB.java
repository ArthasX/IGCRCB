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
import com.deliverik.infogovernor.risk.model.CheckInfoEntityInfo;

/**
  * ����: �����Թ����ʲ���ʵ��
  * ��������: �����Թ����ʲ���ʵ��
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CheckInfoEntity")
public class CheckInfoEntityTB extends BaseEntity implements Serializable,
		Cloneable, CheckInfoEntityInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="CHECKINFOENTITY_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CHECKINFOENTITY_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CHECKINFOENTITY_TABLE_GENERATOR")
	protected Integer cieid;

	/** ������id */
	protected Integer csid;

	/** �ʲ�id */
	protected Integer eiid;

	/** �ʲ��汾 */
	protected Integer eiversion;

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
	 * �ʲ�idȡ��
	 *
	 * @return �ʲ�id
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�id�趨
	 *
	 * @param eiid �ʲ�id
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * �ʲ��汾ȡ��
	 *
	 * @return �ʲ��汾
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * �ʲ��汾�趨
	 *
	 * @param eiversion �ʲ��汾
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
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
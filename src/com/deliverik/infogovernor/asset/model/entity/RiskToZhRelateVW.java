/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.asset.model.RiskToZhRelateVWInfo;

/**
  * ����: ���յ�ָ���ϵʵ��
  * ��������: ���յ�ָ���ϵʵ��
  * ������¼: 2014/07/24
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="RiskToZhRelateVW")
public class RiskToZhRelateVW extends BaseEntity implements Serializable,
		Cloneable, RiskToZhRelateVWInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="RISKTOZHRELATEVW_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="RISKTOZHRELATEVW_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKTOZHRELATEVW_TABLE_GENERATOR")
	protected Integer eiid;

	/** eid */
	protected String eid;

	/** ��� */
	protected String eilabel;

	/** ��ֵ */
	protected String threshold;

	/** ����ָ������ */
	protected String einame;

	/** �Ƿ�ؼ�ָ�� */
	protected String keyindex;

	/** ����ָ��˵�� */
	protected String eidesc;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �����趨
	 *
	 * @param eiid ����
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * eidȡ��
	 *
	 * @return eid
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * eid�趨
	 *
	 * @param eid eid
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * ���ȡ��
	 *
	 * @return ���
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * ����趨
	 *
	 * @param eilabel ���
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * ��ֵȡ��
	 *
	 * @return ��ֵ
	 */
	public String getThreshold() {
		return threshold;
	}

	/**
	 * ��ֵ�趨
	 *
	 * @param threshold ��ֵ
	 */
	public void setThreshold(String threshold) {
		this.threshold = threshold;
	}

	/**
	 * ����ָ������ȡ��
	 *
	 * @return ����ָ������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ����ָ�������趨
	 *
	 * @param einame ����ָ������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * �Ƿ�ؼ�ָ��ȡ��
	 *
	 * @return �Ƿ�ؼ�ָ��
	 */
	public String getKeyindex() {
		return keyindex;
	}

	/**
	 * �Ƿ�ؼ�ָ���趨
	 *
	 * @param keyindex �Ƿ�ؼ�ָ��
	 */
	public void setKeyindex(String keyindex) {
		this.keyindex = keyindex;
	}

	/**
	 * ����ָ��˵��ȡ��
	 *
	 * @return ����ָ��˵��
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * ����ָ��˵���趨
	 *
	 * @param eidesc ����ָ��˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return eiid;
	}

}
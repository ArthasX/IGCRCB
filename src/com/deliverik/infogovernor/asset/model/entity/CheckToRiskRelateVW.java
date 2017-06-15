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
import com.deliverik.infogovernor.asset.model.CheckToRiskRelateVWInfo;

/**
  * ����: �������յ��ϵģ��ʵ��
  * ��������: �������յ��ϵģ��ʵ��
  * ������¼: 2014/07/23
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CheckToRiskRelateVW")
public class CheckToRiskRelateVW extends BaseEntity implements Serializable,
		Cloneable, CheckToRiskRelateVWInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="CHECKTORISKRELATEVW_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CHECKTORISKRELATEVW_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CHECKTORISKRELATEVW_TABLE_GENERATOR")
	protected Integer eiid;

	/** eid */
	protected String eid;

	/** ��� */
	protected String eilabel;

	/** ���ռ��� */
	protected String levels;

	/** �������صȼ� */
	protected String grad;

	/** ��������� */
	protected String einame;

	/** ���յ��־ */
	protected String risksign;

	/** ���շ������� */
	protected String poss;

	/** �����˵�� */
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
	 * ���ռ���ȡ��
	 *
	 * @return ���ռ���
	 */
	public String getLevels() {
		return levels;
	}

	/**
	 * ���ռ����趨
	 *
	 * @param levels ���ռ���
	 */
	public void setLevels(String levels) {
		this.levels = levels;
	}

	/**
	 * �������صȼ�ȡ��
	 *
	 * @return �������صȼ�
	 */
	public String getGrad() {
		return grad;
	}

	/**
	 * �������صȼ��趨
	 *
	 * @param grad �������صȼ�
	 */
	public void setGrad(String grad) {
		this.grad = grad;
	}

	/**
	 * ���������ȡ��
	 *
	 * @return ���������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ����������趨
	 *
	 * @param einame ���������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ���յ��־ȡ��
	 *
	 * @return ���յ��־
	 */
	public String getRisksign() {
		return risksign;
	}

	/**
	 * ���յ��־�趨
	 *
	 * @param risksign ���յ��־
	 */
	public void setRisksign(String risksign) {
		this.risksign = risksign;
	}

	/**
	 * ���շ�������ȡ��
	 *
	 * @return ���շ�������
	 */
	public String getPoss() {
		return poss;
	}

	/**
	 * ���շ��������趨
	 *
	 * @param poss ���շ�������
	 */
	public void setPoss(String poss) {
		this.poss = poss;
	}

	/**
	 * �����˵��ȡ��
	 *
	 * @return �����˵��
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * �����˵���趨
	 *
	 * @param eidesc �����˵��
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
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
import com.deliverik.infogovernor.asset.model.RiskCheckVWInfo;

/**
  * ����: ��鹤��ͳ�Ʊ���ʵ��
  * ��������: ��鹤��ͳ�Ʊ���ʵ��
  * ������¼: 2014/07/22
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="RiskCheckVW")
public class RiskCheckVW extends BaseEntity implements Serializable,
		Cloneable, RiskCheckVWInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="RISKCHECKVW_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="RISKCHECKVW_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKCHECKVW_TABLE_GENERATOR")
	protected Integer eiid;

	/** eid */
	protected String eid;

	/** ��� */
	protected String eilabel;

	/** �Ǽ���id */
	protected String eiuserid;

	/** �Ǽ������� */
	protected String eiusername;

	/** ��������� */
	protected String einame;

	/** ���Ƶ�� */
	protected String checkpd;

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
	 * �Ǽ���idȡ��
	 *
	 * @return �Ǽ���id
	 */
	public String getEiuserid() {
		return eiuserid;
	}

	/**
	 * �Ǽ���id�趨
	 *
	 * @param eiuserid �Ǽ���id
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}

	/**
	 * �Ǽ�������ȡ��
	 *
	 * @return �Ǽ�������
	 */
	public String getEiusername() {
		return eiusername;
	}

	/**
	 * �Ǽ��������趨
	 *
	 * @param eiusername �Ǽ�������
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
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
	 * ���Ƶ��ȡ��
	 *
	 * @return ���Ƶ��
	 */
	public String getCheckpd() {
		return checkpd;
	}

	/**
	 * ���Ƶ���趨
	 *
	 * @param checkpd ���Ƶ��
	 */
	public void setCheckpd(String checkpd) {
		this.checkpd = checkpd;
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
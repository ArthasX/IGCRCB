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
import com.deliverik.infogovernor.asset.model.RiskIndexContextVWInfo;

/**
  * ����: ����ָ��չʾ���ݲ�ѯʵ��
  * ��������: ����ָ��չʾ���ݲ�ѯʵ��
  * ������¼: 2014/07/26
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="RiskIndexContextVW")
public class RiskIndexContextVW extends BaseEntity implements Serializable,
		Cloneable, RiskIndexContextVWInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="RISKINDEXCONTEXTVW_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="RISKINDEXCONTEXTVW_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKINDEXCONTEXTVW_TABLE_GENERATOR")
	protected Integer rimid;

	/** ָ������ */
	protected Integer eiid;

	/** ���㷽ʽ */
	protected String rimtype;

	/** �洢sql */
	protected String rimsql;

	/** �������� */
	protected String einame;

	/** ���ձ�� */
	protected String eilabel;

	/** ���� */
	protected String rimdesc;
	
	/**����*/
	protected String esyscoding;

	/**
	 * ����ȡ��
	 * @return esyscoding ����
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �����趨
	 * @param esyscoding ����
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getRimid() {
		return rimid;
	}

	/**
	 * �����趨
	 *
	 * @param rimid ����
	 */
	public void setRimid(Integer rimid) {
		this.rimid = rimid;
	}

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * ָ�������趨
	 *
	 * @param eiid ָ������
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * ���㷽ʽȡ��
	 *
	 * @return ���㷽ʽ
	 */
	public String getRimtype() {
		return rimtype;
	}

	/**
	 * ���㷽ʽ�趨
	 *
	 * @param rimtype ���㷽ʽ
	 */
	public void setRimtype(String rimtype) {
		this.rimtype = rimtype;
	}

	/**
	 * �洢sqlȡ��
	 *
	 * @return �洢sql
	 */
	public String getRimsql() {
		return rimsql;
	}

	/**
	 * �洢sql�趨
	 *
	 * @param rimsql �洢sql
	 */
	public void setRimsql(String rimsql) {
		this.rimsql = rimsql;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ���������趨
	 *
	 * @param einame ��������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ���ձ��ȡ��
	 *
	 * @return ���ձ��
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * ���ձ���趨
	 *
	 * @param eilabel ���ձ��
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getRimdesc() {
		return rimdesc;
	}

	/**
	 * �����趨
	 *
	 * @param rimdesc ����
	 */
	public void setRimdesc(String rimdesc) {
		this.rimdesc = rimdesc;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return rimid;
	}

}
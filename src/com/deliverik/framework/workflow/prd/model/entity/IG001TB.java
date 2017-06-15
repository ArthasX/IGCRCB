/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG001Info;

/**
  * ����: OA��ɫ���ñ�ʵ��
  * ��������: OA��ɫ���ñ�ʵ��
  * ������¼: 2013/02/26
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG001")
public class IG001TB extends BaseEntity implements Serializable,
		Cloneable, IG001Info {

	/** ���� */
	@Id
	@TableGenerator(
		name="IG001_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IG001_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG001_TABLE_GENERATOR")
	protected Integer proid;

	/** ���� */
	protected String protype;

	/** ��ɫID */
	protected Integer proroleid;

	/** ��ɫ���� */
	protected String prorolename;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getProid() {
		return proid;
	}

	/**
	 * �����趨
	 *
	 * @param proid ����
	 */
	public void setProid(Integer proid) {
		this.proid = proid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getProtype() {
		return protype;
	}

	/**
	 * �����趨
	 *
	 * @param protype ����
	 */
	public void setProtype(String protype) {
		this.protype = protype;
	}

	/**
	 * ��ɫIDȡ��
	 *
	 * @return ��ɫID
	 */
	public Integer getProroleid() {
		return proroleid;
	}

	/**
	 * ��ɫID�趨
	 *
	 * @param proroleid ��ɫID
	 */
	public void setProroleid(Integer proroleid) {
		this.proroleid = proroleid;
	}

	/**
	 * ��ɫ����ȡ��
	 *
	 * @return ��ɫ����
	 */
	public String getProrolename() {
		return prorolename;
	}

	/**
	 * ��ɫ�����趨
	 *
	 * @param prorolename ��ɫ����
	 */
	public void setProrolename(String prorolename) {
		this.prorolename = prorolename;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return proid;
	}

}
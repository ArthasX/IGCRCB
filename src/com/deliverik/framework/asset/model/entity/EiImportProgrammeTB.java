/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.asset.model.EiImportProgrammeInfo;
import com.deliverik.framework.base.BaseEntity;

/**
  * ����: �����������ʵ��
  * ��������: �����������ʵ��
  * ������¼: 2011/05/05
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="EiImportProgramme")
public class EiImportProgrammeTB extends BaseEntity implements Serializable,
		Cloneable, EiImportProgrammeInfo {

	/** ����ID */
	@Id
	@TableGenerator(
		name="EIIMPORTPROGRAMME_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="EIIMPORTPROGRAMME_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="EIIMPORTPROGRAMME_TABLE_GENERATOR")
	protected Integer impTypeid;

	/** �������� */
	protected String impTypename;

	/** ����bat���� */
	protected String impProgramme;
	
	/** ���bat���� */
	protected String impProgrammeAudit;
	
	/** ����bat���� */
	protected String impProgrammeUpdate;
	
	
	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getImpTypeid() {
		return impTypeid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param impTypeid ����ID
	 */
	public void setImpTypeid(Integer impTypeid) {
		this.impTypeid = impTypeid;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getImpTypename() {
		return impTypename;
	}

	/**
	 * ���������趨
	 *
	 * @param impTypename ��������
	 */
	public void setImpTypename(String impTypename) {
		this.impTypename = impTypename;
	}

	/**
	 * ����bat����ȡ��
	 *
	 * @return ����bat����
	 */
	public String getImpProgramme() {
		return impProgramme;
	}

	/**
	 * ����bat�����趨
	 *
	 * @param impProgramme ����bat����
	 */
	public void setImpProgramme(String impProgramme) {
		this.impProgramme = impProgramme;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return impTypeid;
	}

	/**
	 * ���bat����ȡ��
	 * @return ���bat����
	 */
	public String getImpProgrammeAudit() {
		return impProgrammeAudit;
	}

	/**
	 * ���bat�����趨
	 * @param impProgrammeAudit���bat����
	 */
	public void setImpProgrammeAudit(String impProgrammeAudit) {
		this.impProgrammeAudit = impProgrammeAudit;
	}

	/**
	 * ����bat����ȡ��
	 * @return ����bat����
	 */
	public String getImpProgrammeUpdate() {
		return impProgrammeUpdate;
	}

	/**
	 * ����bat�����趨
	 * @param impProgrammeUpdate����bat����
	 */
	public void setImpProgrammeUpdate(String impProgrammeUpdate) {
		this.impProgrammeUpdate = impProgrammeUpdate;
	}

	
	
}
/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0113Info;

/**
  * ����: �����������ʵ��
  * ��������: �����������ʵ��
  * ������¼: 2011/05/05
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0113")
public class SOC0113TB extends BaseEntity implements Serializable,
		Cloneable, SOC0113Info {

	/** ����ID */
	@Id
	@TableGenerator(
		name="SOC0113_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="SOC0113_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SOC0113_TABLE_GENERATOR")
	protected Integer impTypeid;

	/** �������� */
	protected String impTypename;

	/** ����bat���� */
	protected String impProgramme;
	
	/** ���bat���� */
	protected String impProgrammeAudit;
	
	/** ����bat���� */
	protected String impProgrammeUpdate;
	
	/**��Ӧ�ɼ��ű�����*/
	protected String shellname;
	
	/**
	 * �ű�����ȡ��
	 *
	 * @return  �ű�����
	 */
	public String getShellname()
	{
		return shellname;
	}
	/**
	 * �ű������趨
	 *
	 * @param shellname �ű�����
	 */
	public void setShellname(String shellname)
	{
		this.shellname = shellname;
	}

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
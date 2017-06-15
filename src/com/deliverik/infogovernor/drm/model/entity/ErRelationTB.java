/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.drm.model.ErRelationInfo;

/**
  * ����: Ӧ����Դ��ϵʵ��
  * ��������: Ӧ����Դ��ϵʵ��
  * ������¼: 2016/06/14
  * �޸ļ�¼: 2017��3��16��15:48:17  ʹ��fingerprint��Դ��¼ ��Դ����(1:Ӧ����Դ,0������Դ)
  */
@SuppressWarnings("serial")
@Entity
@Table(name="ErRelation")
public class ErRelationTB extends BaseEntity implements Serializable,
		Cloneable, ErRelationInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="ERRELATION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="ERRELATION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="ERRELATION_TABLE_GENERATOR")
	protected Integer errid;

	/** Ӧ����Դ���� */
	protected Integer erid;

	/** ��Դ���� */
	protected String ercode;

	/** �ʲ�id */
	protected String eiid;

	/** ɾ����־ */
	protected String deleteflag;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getErrid() {
		return errid;
	}

	/**
	 * �����趨
	 *
	 * @param errid ����
	 */
	public void setErrid(Integer errid) {
		this.errid = errid;
	}

	/**
	 * Ӧ����Դ����ȡ��
	 *
	 * @return Ӧ����Դ����
	 */
	public Integer getErid() {
		return erid;
	}

	/**
	 * Ӧ����Դ�����趨
	 *
	 * @param erid Ӧ����Դ����
	 */
	public void setErid(Integer erid) {
		this.erid = erid;
	}

	/**
	 * ��Դ����ȡ��
	 *
	 * @return ��Դ����
	 */
	public String getErcode() {
		return ercode;
	}

	/**
	 * ��Դ�����趨
	 *
	 * @param ercode ��Դ����
	 */
	public void setErcode(String ercode) {
		this.ercode = ercode;
	}


	/**
	 * �ʲ�idȡ��
	 *
	 * @return �ʲ�id
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�id�趨
	 *
	 * @param eiid �ʲ�id
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}



	/**
	 * ɾ����־ȡ��
	 *
	 * @return ɾ����־
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * ɾ����־�趨
	 *
	 * @param deleteflag ɾ����־
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return errid;
	}

}
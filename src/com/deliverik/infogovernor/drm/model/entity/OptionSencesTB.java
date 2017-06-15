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
import com.deliverik.infogovernor.drm.model.OptionSencesInfo;

/**
  * ����: ��ѡ����ʵ��
  * ��������: ��ѡ����ʵ��
  * ������¼: 2016/10/09
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="OptionSences")
public class OptionSencesTB extends BaseEntity implements Serializable,
		Cloneable, OptionSencesInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="OPTIONSENCES_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="OPTIONSENCES_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="OPTIONSENCES_TABLE_GENERATOR")
	protected Integer osid;

	/** Ӧ������prid */
	protected Integer prid;

	/** ����eiid */
	protected Integer senceEiid;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getOsid() {
		return osid;
	}

	/**
	 * �����趨
	 *
	 * @param osid ����
	 */
	public void setOsid(Integer osid) {
		this.osid = osid;
	}

	/**
	 * Ӧ������pridȡ��
	 *
	 * @return Ӧ������prid
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * Ӧ������prid�趨
	 *
	 * @param prid Ӧ������prid
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ����eiidȡ��
	 *
	 * @return ����eiid
	 */
	public Integer getSenceEiid() {
		return senceEiid;
	}

	/**
	 * ����eiid�趨
	 *
	 * @param senceEiid ����eiid
	 */
	public void setSenceEiid(Integer senceEiid) {
		this.senceEiid = senceEiid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return osid;
	}

}
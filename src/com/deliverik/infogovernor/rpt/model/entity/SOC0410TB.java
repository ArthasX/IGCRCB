/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rpt.model.SOC0410Info;

/**
  * ����: �洢lunʵʱ��ʵ��
  * ��������: �洢lunʵʱ��ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��PVStorageRealTimeTB������ΪSOC0410TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0410")
public class SOC0410TB extends BaseEntity implements Serializable,
		Cloneable, SOC0410Info {

	/** ���� */
	@Id
	@TableGenerator(
		name="PVSTORAGEREALTIME_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="PVSTORAGEREALTIME_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="PVSTORAGEREALTIME_TABLE_GENERATOR")
	protected Integer psId;

	/** �洢���к� */
	protected String sName;

	/** lunid */
	protected String lunid;

	/** pv��С */
	protected Integer pvSize;

	/** �Ƿ񱻷��� */
	protected String isUsed;

	/** ���� */
	protected String createDate;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPsId() {
		return psId;
	}

	/**
	 * �����趨
	 *
	 * @param psId ����
	 */
	public void setPsId(Integer psId) {
		this.psId = psId;
	}

	/**
	 * �洢���к�ȡ��
	 *
	 * @return �洢���к�
	 */
	public String getSName() {
		return sName;
	}

	/**
	 * �洢���к��趨
	 *
	 * @param sName �洢���к�
	 */
	public void setSName(String sName) {
		this.sName = sName;
	}

	/**
	 * lunidȡ��
	 *
	 * @return lunid
	 */
	public String getLunid() {
		return lunid;
	}

	/**
	 * lunid�趨
	 *
	 * @param lunid lunid
	 */
	public void setLunid(String lunid) {
		this.lunid = lunid;
	}

	/**
	 * pv��Сȡ��
	 *
	 * @return pv��С
	 */
	public Integer getPvSize() {
		return pvSize;
	}

	/**
	 * pv��С�趨
	 *
	 * @param pvSize pv��С
	 */
	public void setPvSize(Integer pvSize) {
		this.pvSize = pvSize;
	}

	/**
	 * �Ƿ񱻷���ȡ��
	 *
	 * @return �Ƿ񱻷���
	 */
	public String getIsUsed() {
		return isUsed;
	}

	/**
	 * �Ƿ񱻷����趨
	 *
	 * @param isUsed �Ƿ񱻷���
	 */
	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * �����趨
	 *
	 * @param createDate ����
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return psId;
	}

}
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
import com.deliverik.framework.soc.asset.model.SOC0106Info;

/**
  * ����: ��ƴ�����������ʱʵ��
  * ��������: ��ƴ�����������ʱʵ��
  * ������¼: 2012/07/31
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0106")
public class SOC0106TB extends BaseEntity implements Serializable,
		Cloneable, SOC0106Info {

	/** awtId */
	@Id
	@TableGenerator(
		name="SOC0106_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="SOC0106_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SOC0106_TABLE_GENERATOR")
	protected Integer awtId;

	/** �ļ����� */
	protected String fileName;

	/** batName */
	protected String batName;

	/** ʵ������ */
	protected String eiName;

	/** ʵ��Id */
	protected String auwtId;

	/**
	 * awtIdȡ��
	 *
	 * @return awtId
	 */
	public Integer getAwtId() {
		return awtId;
	}

	/**
	 * awtId�趨
	 *
	 * @param awtId awtId
	 */
	public void setAwtId(Integer awtId) {
		this.awtId = awtId;
	}

	/**
	 * �ļ�����ȡ��
	 *
	 * @return �ļ�����
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * �ļ������趨
	 *
	 * @param fileName �ļ�����
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * batNameȡ��
	 *
	 * @return batName
	 */
	public String getBatName() {
		return batName;
	}

	/**
	 * batName�趨
	 *
	 * @param batName batName
	 */
	public void setBatName(String batName) {
		this.batName = batName;
	}

	/**
	 * ʵ������ȡ��
	 *
	 * @return ʵ������
	 */
	public String getEiName() {
		return eiName;
	}

	/**
	 * ʵ�������趨
	 *
	 * @param eiName ʵ������
	 */
	public void setEiName(String eiName) {
		this.eiName = eiName;
	}

	/**
	 * ʵ��Idȡ��
	 *
	 * @return ʵ��Id
	 */
	public String getAuwtId() {
		return auwtId;
	}

	/**
	 * ʵ��Id�趨
	 *
	 * @param auwtId ʵ��Id
	 */
	public void setAuwtId(String auwtId) {
		this.auwtId = auwtId;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return awtId;
	}

}
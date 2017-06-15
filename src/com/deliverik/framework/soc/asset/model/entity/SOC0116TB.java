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
import com.deliverik.framework.soc.asset.model.SOC0116Info;

/**
  * ����: EiWaitTaskTempʵ��
  * ��������: EiWaitTaskTempʵ��
  * ������¼: 2012/07/30
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0116")
public class SOC0116TB extends BaseEntity implements Serializable,
		Cloneable, SOC0116Info {

	/** ewtId */
	@Id
	@TableGenerator(
		name="SOC0116_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="SOC0116_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SOC0116_TABLE_GENERATOR")
	protected Integer ewtId;

	/** �ļ����� */
	protected String fileName;

	/** userId */
	protected String userId;

	/** ʵ������ */
	protected String eiName;

	/** ʵ��Id */
	protected String eitId;

	/**
	 * ewtIdȡ��
	 *
	 * @return ewtId
	 */
	public Integer getEwtId() {
		return ewtId;
	}

	/**
	 * ewtId�趨
	 *
	 * @param ewtId ewtId
	 */
	public void setEwtId(Integer ewtId) {
		this.ewtId = ewtId;
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
	 * userIdȡ��
	 *
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * userId�趨
	 *
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setEitId(String eitId) {
		this.eitId = eitId;
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
	public String getEitId() {
		return eitId;
	}

	/**
	 * ʵ��Id�趨
	 *
	 * @param eiId ʵ��Id
	 */
	public void setEiId(String eitId) {
		this.eitId = eitId;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return ewtId;
	}

}
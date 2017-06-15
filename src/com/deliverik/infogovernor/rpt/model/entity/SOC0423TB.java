/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rpt.model.SOC0423Info;

/**
  * ����: ���������ʵ��
  * ��������: ���������ʵ��
  * ������¼: 2012/08/09
  * �޸ļ�¼: ��CapacityObjectListTB������ΪSOC0423TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0423")
public class SOC0423TB extends BaseEntity implements Serializable,
		Cloneable, SOC0423Info {

	/** ���� */
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "identity")
	protected Integer id;

	/** ���� */
	protected String name;

	/** �������� */
	protected String objectType;

	/** �������� */
	protected String objectName;
	
	/** ������� */
	protected Integer errorNum;
	
	/** �澯���� */
	protected Integer warningNum;
	
	/** ״̬ */
	protected Integer status;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * �����趨
	 *
	 * @param id ����
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getName() {
		return name;
	}

	/**
	 * �����趨
	 *
	 * @param name ����
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getObjectType() {
		return objectType;
	}

	/**
	 * ���������趨
	 *
	 * @param objectType ��������
	 */
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getObjectName() {
		return objectName;
	}

	/**
	 * ���������趨
	 *
	 * @param objectName ��������
	 */
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return id;
	}

	/**
	 * �������ȡ��
	 *
	 * @return errorNum �������
	 */
	public Integer getErrorNum() {
		return errorNum;
	}

	/**
	 * ��������趨
	 *
	 * @param errorNum �������
	 */
	public void setErrorNum(Integer errorNum) {
		this.errorNum = errorNum;
	}

	/**
	 * �澯����ȡ��
	 *
	 * @return warningNum �澯����
	 */
	public Integer getWarningNum() {
		return warningNum;
	}

	/**
	 * �澯�����趨
	 *
	 * @param warningNum �澯����
	 */
	public void setWarningNum(Integer warningNum) {
		this.warningNum = warningNum;
	}

	/**
	 * ״̬ȡ��
	 *
	 * @return status ״̬
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * ״̬�趨
	 *
	 * @param status ״̬
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

}
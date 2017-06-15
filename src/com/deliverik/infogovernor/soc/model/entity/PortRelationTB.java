/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.infogovernor.soc.model.PortRelationInfo;
import com.deliverik.framework.base.BaseEntity;

/**
  * ����: �˵��˹�ϵ��ʵ��
  * ��������: �˵��˹�ϵ��ʵ��
  * ������¼: 2013/01/17
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(PortRelationPK.class)
@Table(name="PortRelation")
public class PortRelationTB extends BaseEntity implements Serializable,
		Cloneable, PortRelationInfo {

	/** HBAPort_WWN */
	@Id
	protected String HBAPort_WWN;

	/** DevicesName */
	@Id
	protected String DevicesName;

	/** SymmetrixID */
	@Id
	protected String SymmetrixID;

	/** FAName */
	@Id
	protected String FAName;

	/** FAPortName */
	@Id
	protected String FAPortName;

	/** HyperType */
	protected String HyperType;

	/**
	 * HBAPort_WWNȡ��
	 *
	 * @return HBAPort_WWN
	 */
	public String getHBAPort_WWN() {
		return HBAPort_WWN;
	}

	/**
	 * HBAPort_WWN�趨
	 *
	 * @param HBAPort_WWN HBAPort_WWN
	 */
	public void setHBAPort_WWN(String HBAPort_WWN) {
		this.HBAPort_WWN = HBAPort_WWN;
	}

	/**
	 * DevicesNameȡ��
	 *
	 * @return DevicesName
	 */
	public String getDevicesName() {
		return DevicesName;
	}

	/**
	 * DevicesName�趨
	 *
	 * @param DevicesName DevicesName
	 */
	public void setDevicesName(String DevicesName) {
		this.DevicesName = DevicesName;
	}

	/**
	 * SymmetrixIDȡ��
	 *
	 * @return SymmetrixID
	 */
	public String getSymmetrixID() {
		return SymmetrixID;
	}

	/**
	 * SymmetrixID�趨
	 *
	 * @param SymmetrixID SymmetrixID
	 */
	public void setSymmetrixID(String SymmetrixID) {
		this.SymmetrixID = SymmetrixID;
	}

	/**
	 * FANameȡ��
	 *
	 * @return FAName
	 */
	public String getFAName() {
		return FAName;
	}

	/**
	 * FAName�趨
	 *
	 * @param FAName FAName
	 */
	public void setFAName(String FAName) {
		this.FAName = FAName;
	}

	/**
	 * FAPortNameȡ��
	 *
	 * @return FAPortName
	 */
	public String getFAPortName() {
		return FAPortName;
	}

	/**
	 * FAPortName�趨
	 *
	 * @param FAPortName FAPortName
	 */
	public void setFAPortName(String FAPortName) {
		this.FAPortName = FAPortName;
	}

	/**
	 * HyperTypeȡ��
	 *
	 * @return HyperType
	 */
	public String getHyperType() {
		return HyperType;
	}

	/**
	 * HyperType�趨
	 *
	 * @param HyperType HyperType
	 */
	public void setHyperType(String HyperType) {
		this.HyperType = HyperType;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new PortRelationPK(HBAPort_WWN, DevicesName, SymmetrixID, FAName, FAPortName);
	}

}
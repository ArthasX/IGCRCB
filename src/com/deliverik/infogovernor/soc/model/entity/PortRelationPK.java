/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: �˵��˹�ϵ��ʵ������
  * ��������: �˵��˹�ϵ��ʵ������
  * ������¼: 2013/01/17
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class PortRelationPK extends BasePK implements Serializable {

	/** HBAPort_WWN */
	protected String HBAPort_WWN;

	/** DevicesName */
	protected String DevicesName;

	/** SymmetrixID */
	protected String SymmetrixID;

	/** FAName */
	protected String FAName;

	/** FAPortName */
	protected String FAPortName;

	/**
	 * ���캯��
	 */
	public PortRelationPK() {

	}

	/**
	 * ���캯��
	 */
	public PortRelationPK(String HBAPort_WWN, String DevicesName, String SymmetrixID, String FAName, String FAPortName) {
		super();
		this.HBAPort_WWN = HBAPort_WWN;
		this.DevicesName = DevicesName;
		this.SymmetrixID = SymmetrixID;
		this.FAName = FAName;
		this.FAPortName = FAPortName;
	}

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

}
/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
  * 概述: 端到端关系表实体
  * 功能描述: 端到端关系表实体
  * 创建记录: 2013/01/17
  * 修改记录: 
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
	 * HBAPort_WWN取得
	 *
	 * @return HBAPort_WWN
	 */
	public String getHBAPort_WWN() {
		return HBAPort_WWN;
	}

	/**
	 * HBAPort_WWN设定
	 *
	 * @param HBAPort_WWN HBAPort_WWN
	 */
	public void setHBAPort_WWN(String HBAPort_WWN) {
		this.HBAPort_WWN = HBAPort_WWN;
	}

	/**
	 * DevicesName取得
	 *
	 * @return DevicesName
	 */
	public String getDevicesName() {
		return DevicesName;
	}

	/**
	 * DevicesName设定
	 *
	 * @param DevicesName DevicesName
	 */
	public void setDevicesName(String DevicesName) {
		this.DevicesName = DevicesName;
	}

	/**
	 * SymmetrixID取得
	 *
	 * @return SymmetrixID
	 */
	public String getSymmetrixID() {
		return SymmetrixID;
	}

	/**
	 * SymmetrixID设定
	 *
	 * @param SymmetrixID SymmetrixID
	 */
	public void setSymmetrixID(String SymmetrixID) {
		this.SymmetrixID = SymmetrixID;
	}

	/**
	 * FAName取得
	 *
	 * @return FAName
	 */
	public String getFAName() {
		return FAName;
	}

	/**
	 * FAName设定
	 *
	 * @param FAName FAName
	 */
	public void setFAName(String FAName) {
		this.FAName = FAName;
	}

	/**
	 * FAPortName取得
	 *
	 * @return FAPortName
	 */
	public String getFAPortName() {
		return FAPortName;
	}

	/**
	 * FAPortName设定
	 *
	 * @param FAPortName FAPortName
	 */
	public void setFAPortName(String FAPortName) {
		this.FAPortName = FAPortName;
	}

	/**
	 * HyperType取得
	 *
	 * @return HyperType
	 */
	public String getHyperType() {
		return HyperType;
	}

	/**
	 * HyperType设定
	 *
	 * @param HyperType HyperType
	 */
	public void setHyperType(String HyperType) {
		this.HyperType = HyperType;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new PortRelationPK(HBAPort_WWN, DevicesName, SymmetrixID, FAName, FAPortName);
	}

}
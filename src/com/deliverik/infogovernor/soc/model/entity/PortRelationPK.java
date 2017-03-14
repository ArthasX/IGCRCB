/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: 端到端关系表实体主键
  * 功能描述: 端到端关系表实体主键
  * 创建记录: 2013/01/17
  * 修改记录: 
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
	 * 构造函数
	 */
	public PortRelationPK() {

	}

	/**
	 * 构造函数
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

}
/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.condition;

/**
 * 概述:3D机房支持IP查询 功能描述：3D机房支持IP查询 创建人：赵梓廷 创建记录： 2013-01-31 修改记录：
 */
public class EquipmentInquireVWSearchCondImpl implements
		EquipmentInquireVWSearchCond {

	/** 业务系统 */
	protected String businesssys;

	/** IP地址 */
	protected String ip;

	/** 所属机柜 */
	protected String computerContainer;

	/** 设备名称 */
	protected String einame;

	/** 设备编号 */
	protected String eilabel;

	/** 所属机柜Id */
	protected Integer computerContainerId;

	/**
	 * 业务系统取得
	 * 
	 * @return 业务系统
	 */
	public String getBusinesssys() {
		return businesssys;
	}

	/**
	 * 业务系统设定
	 * 
	 * @param businesssys
	 *            业务系统
	 */
	public void setBusinesssys(String businesssys) {
		this.businesssys = businesssys;
	}

	/**
	 * IP地址取得
	 * 
	 * @return IP地址
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * IP地址设定
	 * 
	 * @param ip
	 *            IP地址
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 所属机柜取得
	 * 
	 * @return 所属机柜
	 */
	public String getComputerContainer() {
		return computerContainer;
	}

	/**
	 * 所属机柜设定
	 * 
	 * @param computerContainer
	 *            所属机柜
	 */
	public void setComputerContainer(String computerContainer) {
		this.computerContainer = computerContainer;
	}

	/**
	 * 所属机柜Id取得
	 * 
	 * @return 所属机柜Id
	 */
	public Integer getComputerContainerId() {
		return computerContainerId;
	}

	/**
	 * 所属机柜Id设定
	 * 
	 * @param computerContainerId
	 *            所属机柜Id
	 */
	public void setComputerContainerId(Integer computerContainerId) {
		this.computerContainerId = computerContainerId;
	}

	/**
	 * 设备名称取得
	 * 
	 * @return einame 设备名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 设备编号取得
	 * 
	 * @return eilabel 设备编号
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 设备名称设定
	 * 
	 * @param einame
	 *            设备名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 设备编号设定
	 * 
	 * @param eilabel
	 *            设备编号
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}
}

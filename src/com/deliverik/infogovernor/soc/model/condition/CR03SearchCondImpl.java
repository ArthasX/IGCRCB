/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model.condition;

/**
  * 概述: 配置原数据与主机关系表检索条件实现
  * 功能描述: 配置原数据与主机关系表检索条件实现
  * 创建记录: 2013/04/08
  * 修改记录: 
  */
public class CR03SearchCondImpl implements CR03SearchCond {
	
	/** 设备标识 */
	protected String host;
	
	/** 表名 */
	protected String tablename;
	
	/** 采集时间 */
	protected String collecttime;
	
	/** 排序标识 */
	protected String orderFlag;
	
	/** 历史版本开始时间 */
	protected String collecttimeFrom;
	
	/** 历史版本结束时间 */
	protected String collecttimeTo;

	/**查询esyscoding*/
	protected String esyscoding;
	
	/** 状态*/
	protected String status;
	
	/** IP */
	protected String ip;
	
	/** server类型 */
	protected String type;
	
	/** 脚本名 */
	protected String servername;
	
	
	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}

	/**
	 * server类型取得
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * server类型设定
	 * @return
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * IP取得
	 * @return
	 */
	public String getIp() {
		return ip;
	}
	
	/**
	 * IP设定
	 * @param ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 设备标识取得
	 * @return 设备标识
	 */
	public String getHost() {
		return host;
	}

	/**
	 * 设备标识设定
	 * @param host 设备标识
	 */
	public void setHost(String host) {
		this.host = host;
	}
	
	/**
	 * 表名取得
	 * @return 表名
	 */
	public String getTablename() {
		return tablename;
	}

	/**
	 * 表名设定
	 * @param tablename 表名
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	
	/**
	 * 采集时间取得
	 *
	 * @return 采集时间
	 */
	public String getCollecttime() {
		return collecttime;
	}

	/**
	 * 采集时间设定
	 *
	 * @param collecttime 采集时间
	 */
	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}

	/**
	 * 排序标识取得
	 * @return 排序标识
	 */
	public String getOrderFlag() {
		return orderFlag;
	}

	/**
	 * 排序标识设定
	 * @param orderFlag 排序标识
	 */
	public void setOrderFlag(String orderFlag) {
		this.orderFlag = orderFlag;
	}
	
	/**
	 * 历史版本开始时间取得
	 * @return 历史版本开始时间
	 */
	public String getCollecttimeFrom() {
		return collecttimeFrom;
	}

	/**
	 * 历史版本开始时间设定
	 * @param vdatestart 历史版本开始时间
	 */
	public void setCollecttimeFrom(String collecttimeFrom) {
		this.collecttimeFrom = collecttimeFrom;
	}

	/**
	 * 历史版本结束时间取得
	 * @return 历史版本结束时间
	 */
	public String getCollecttimeTo() {
		return collecttimeTo;
	}

	/**
	 * 历史版本结束时间设定
	 * @param vdatestart 历史版本结束时间
	 */
	public void setCollecttimeTo(String collecttimeTo) {
		this.collecttimeTo = collecttimeTo;
	}

	/**
	 * 查询esyscoding取得
	 * @return esyscoding 查询esyscoding
	 */
	
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 查询esyscoding设定
	 * @param esyscoding 查询esyscoding
	 */
	
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 状态取得
	 * @return 状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 状态设定
	 * @param status 状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
}
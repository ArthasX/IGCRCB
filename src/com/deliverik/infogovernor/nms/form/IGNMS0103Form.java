/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.nms.model.NMS03Info;

/**
 * 概述: 任务配置Form
 * 功能描述: 任务配置Form
 * 创建记录: 2013/12/20
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGNMS0103Form extends BaseForm implements NMS03Info {
	
	/** 主键 */
	protected Integer id;
	
	/** 组ID */
	protected Integer gid;
	
	/** 任务版本 */
	protected Integer version;
	
	/** 任务类型 */
	protected String type;
	
	/** 是否启用PING */
	protected String isEnablePing;
	
	/** 是否启用ARP */
	protected String isEnableArp;
	
	/** 起始IP */
	protected String fromIP;
	
	/** 结束IP */
	protected String toIP;
	
	/** 子网 */
	protected String subNet;
	
	/** 创建时间 */
	protected String instime;
	
	/** 记录时间戳 */
	protected String fingerPrint;
	
	/** 删除标识 */
	protected String deleteflag;

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 主键设定
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 组ID取得
	 * @return 组ID
	 */
	public Integer getGid() {
		return gid;
	}

	/**
	 * 组ID设定
	 * @param gid 组ID
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	/**
	 * 任务版本取得
	 * @return 任务版本
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * 任务版本设定
	 * @param version 组版本
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * 任务类型取得
	 * @return 任务类型
	 */
	public String getType() {
		return type;
	}

	/**
	 * 任务类型设定
	 * @param type 任务类型
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 是否启用PING取得
	 * @return 是否启用PING
	 */
	public String getIsEnablePing() {
		return isEnablePing;
	}

	/**
	 * 是否启用PING设定
	 * @param isEnablePing 是否启用PING
	 */
	public void setIsEnablePing(String isEnablePing) {
		this.isEnablePing = isEnablePing;
	}

	/**
	 * 是否启用ARP取得
	 * @return 是否启用ARP
	 */
	public String getIsEnableArp() {
		return isEnableArp;
	}

	/**
	 * 是否启用ARP设定
	 * @param isEnableArp 是否启用ARP
	 */
	public void setIsEnableArp(String isEnableArp) {
		this.isEnableArp = isEnableArp;
	}

	/**
	 * 起始IP取得
	 * @return 起始IP
	 */
	public String getFromIP() {
		return fromIP;
	}

	/**
	 * 起始IP设定
	 * @param fromIP 起始IP
	 */
	public void setFromIP(String fromIP) {
		this.fromIP = fromIP;
	}

	/**
	 * 结束IP取得
	 * @return 结束IP
	 */
	public String getToIP() {
		return toIP;
	}

	/**
	 * 结束IP设定
	 * @param toIP 结束IP
	 */
	public void setToIP(String toIP) {
		this.toIP = toIP;
	}

	/**
	 * 子网取得
	 * @return 子网
	 */
	public String getSubNet() {
		return subNet;
	}

	/**
	 * 子网设定
	 * @param subNet 子网
	 */
	public void setSubNet(String subNet) {
		this.subNet = subNet;
	}

	/**
	 * 创建时间取得
	 * @return 创建时间
	 */
	public String getInstime() {
		return instime;
	}

	/**
	 * 创建时间设定
	 * @param instime 创建时间
	 */
	public void setInstime(String instime) {
		this.instime = instime;
	}

	/**
	 * 记录时间戳取得
	 * @return 记录时间戳
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * 记录时间戳设定
	 * @param fingerPrint 记录时间戳
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	/**
	 * 删除标识取得
	 * @return 删除标识
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * 删除标识设定
	 * @param deleteflag 删除标识
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
	
}

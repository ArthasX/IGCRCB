/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.nms.model.NMS06Info;
import com.deliverik.infogovernor.nms.model.dao.annotation.TableSpace;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 设备MAC/IP信息实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="NMS06")
@TableSpace(name="IG_SPACE")
public class NMS06TB extends BaseEntity implements NMS06Info {

	/** 主键 */
	@Id
	protected String id;
	
	/** 设备ID */
	protected String did;
	
	/** IP */
	protected String ip;
	
	/**  MAC地址*/
	protected String mac;
	
	/** 创建时间 */
	protected String instime;
	
	/**
	 * 主键取得
	 * @return id 主键
	 */
	public String getId() {
		return id;
	}

	/**
	 * 主键设定
	 * @param id 主键
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 设备ID取得
	 * @return did 设备ID
	 */
	public String getDid() {
		return did;
	}

	/**
	 * 设备ID设定
	 * @param did 设备ID
	 */
	public void setDid(String did) {
		this.did = did;
	}

	/**
	 * IP取得
	 * @return ip IP
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * IP设定
	 * @param ip IP
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * MAC地址取得
	 * @return mac MAC地址
	 */
	public String getMac() {
		return mac;
	}

	/**
	 * MAC地址设定
	 * @param mac MAC地址
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}

	/**
	 * 创建时间取得
	 * @return instime 创建时间
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
	 * 主键取得
	 * @return 主键
	 */
	public Serializable getPK() {
		return this.id;
	}

}

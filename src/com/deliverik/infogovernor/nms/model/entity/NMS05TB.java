/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.nms.model.NMS05Info;
import com.deliverik.infogovernor.nms.model.dao.annotation.FieldType;
import com.deliverik.infogovernor.nms.model.dao.annotation.Fk;
import com.deliverik.infogovernor.nms.model.dao.annotation.TableSpace;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 设备组关系信息实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@IdClass(NMS05PK.class)
@Table(name="NMS05")
@TableSpace(name="IG_SPACE")
public class NMS05TB extends BaseEntity implements NMS05Info {

	/** 组ID */
	@Id
	@FieldType(value="INTEGER")
	@Fk(tablename="NMS01",fkfield="ID",deleteCascade=true,updateCascade=true)
	protected Integer gid;
	
	/** 设备ID */
	@Id
	@FieldType(value="VARCHAR(128)")
	@Fk(tablename="NMS04",fkfield="ID",deleteCascade=true,updateCascade=true)
	protected String did;
	
	/** 组版本 */
	@Id
	@FieldType(value="INTEGER")
	protected Integer gversion;
	
	/** 显示IP */
	@FieldType(value="VARCHAR(64)")
	protected String ip;
	
	/** 显示MAC地址 */
	@FieldType(value="VARCHAR(32)")
	protected String mac;
	
	/** SNMP信息 */
	@FieldType(value="VARCHAR(512)")
	protected String snmpid;
	
	/** 创建时间 */
	@FieldType(value="CHAR(16)")
	protected String instime;
	
	/**
	 * 组ID取得
	 * @return gid 组ID
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
	 * 组版本取得
	 * @return gversion 组版本
	 */
	public Integer getGversion() {
		return gversion;
	}

	/**
	 * 组版本设定
	 * @param gversion 组版本
	 */
	public void setGversion(Integer gversion) {
		this.gversion = gversion;
	}

	/**
	 * 显示IP取得
	 * @return ip 显示IP
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * 显示IP设定
	 * @param ip 显示IP
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 显示MAC地址取得
	 * @return mac 显示MAC地址
	 */
	public String getMac() {
		return mac;
	}

	/**
	 * 显示MAC地址设定
	 * @param mac 显示MAC地址
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}

	/**
	 * SNMP信息取得
	 * @return snmpid SNMP信息
	 */
	public String getSnmpid() {
		return snmpid;
	}

	/**
	 * SNMP信息设定
	 * @param snmpid SNMP信息
	 */
	public void setSnmpid(String snmpid) {
		this.snmpid = snmpid;
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
		return new NMS05PK(gid, did, gversion);
	}

}

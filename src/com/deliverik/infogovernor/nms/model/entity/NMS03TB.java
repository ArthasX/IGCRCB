/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.dao.hibernate.LogicalDelete;
import com.deliverik.infogovernor.nms.model.NMS03Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 发现任务信息实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="NMS03")
public class NMS03TB extends BaseEntity implements NMS03Info ,LogicalDelete{
	
	/** 主键 */
	@Id
	@TableGenerator(
			name="NMS03_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="NMS03_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE,generator="NMS03_TABLE_GENERATOR")
	protected Integer id;
	
	/** 组ID */
	protected Integer gid;
	
	/** 版本 */
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
	
	/** 删除标识 */
	protected String deleteflag;

	/**
	 * 主键取得
	 * @return id 主键
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
	 * 版本取得
	 * @return version 版本
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * 版本设定
	 * @param version 版本
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * 任务类型取得
	 * @return type 任务类型
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
	 * @return isEnablePing 是否启用PING
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
	 * @return isEnableArp 是否启用ARP
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
	 * @return fromIP 起始IP
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
	 * @return toIP 结束IP
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
	 * @return subNet 子网
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

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Serializable getPK() {
		return this.id;
	}

}

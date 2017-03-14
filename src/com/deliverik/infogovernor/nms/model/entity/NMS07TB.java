/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.nms.model.NMS07Info;
import com.deliverik.infogovernor.nms.model.dao.annotation.FieldType;
import com.deliverik.infogovernor.nms.model.dao.annotation.Fk;
import com.deliverik.infogovernor.nms.model.dao.annotation.TableSpace;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 链路信息实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="NMS07")
@TableSpace(name="IG_SPACE")
public class NMS07TB extends BaseEntity implements NMS07Info {
	
	/** 主键 */
	@Id
	@FieldType(value="VARCHAR(64)")
	protected String id;

	/** 源设备ID */
	@FieldType(value="VARCHAR(128)")
	@Fk(tablename="NMS04",fkfield="ID",deleteCascade=true,updateCascade=true)
	protected String fromdid;

	/** 目标设备ID */
	@FieldType(value="VARCHAR(128)")
	@Fk(tablename="NMS04",fkfield="ID",deleteCascade=true,updateCascade=true)
	protected String todid;

	/** 组ID */
	@FieldType(value="INTEGER")
	@Fk(tablename="NMS01",fkfield="ID",deleteCascade=true,updateCascade=true)
	protected Integer gid;

	/** 组版本 */
	@FieldType(value="INTEGER")
	protected Integer gversion;

	/** 源设备物理端口 */
	@FieldType(value="INTEGER")
	protected Integer fromPhysicalPort;

	/** 源设备IFINDEX */
	@FieldType(value="INTEGER")
	protected Integer fromNodeIfIndex;

	/** 源设备IFNAME */
	@FieldType(value="VARCHAR(128)")
	protected String fromNodeIfName;

	/** 目标设备物理端口 */
	@FieldType(value="INTEGER")
	protected Integer topHysicalPort;

	/** 目标设备IFINDEX */
	@FieldType(value="INTEGER")
	protected Integer toNodeIfIndex;

	/** 目标设备IFNAME */
	@FieldType(value="VARCHAR(128)")
	protected String toNodeIfName;

	/** 创建时间 */
	@FieldType(value="CHAR(16)")
	protected String instime;
	
	/**
	 * 主键曲的
	 * @return 主键
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
	 * 源设备ID取得
	 * @return fromdid 源设备ID
	 */
	public String getFromdid() {
		return fromdid;
	}

	/**
	 * 源设备ID设定
	 * @param fromdid 源设备ID
	 */
	public void setFromdid(String fromdid) {
		this.fromdid = fromdid;
	}

	/**
	 * 目标设备ID取得
	 * @return todid 目标设备ID
	 */
	public String getTodid() {
		return todid;
	}

	/**
	 * 目标设备ID设定
	 * @param todid 目标设备ID
	 */
	public void setTodid(String todid) {
		this.todid = todid;
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
	 * 源设备物理端口取得
	 * @return fromPhysicalPort 源设备物理端口
	 */
	public Integer getFromPhysicalPort() {
		return fromPhysicalPort;
	}

	/**
	 * 源设备物理端口设定
	 * @param fromPhysicalPort 源设备物理端口
	 */
	public void setFromPhysicalPort(Integer fromPhysicalPort) {
		this.fromPhysicalPort = fromPhysicalPort;
	}

	/**
	 * 源设备IFINDEX取得
	 * @return fromNodeIfIndex 源设备IFINDEX
	 */
	public Integer getFromNodeIfIndex() {
		return fromNodeIfIndex;
	}

	/**
	 * 源设备IFINDEX设定
	 * @param fromNodeIfIndex 源设备IFINDEX
	 */
	public void setFromNodeIfIndex(Integer fromNodeIfIndex) {
		this.fromNodeIfIndex = fromNodeIfIndex;
	}

	/**
	 * 源设备IFNAME取得
	 * @return fromNodeIfName 源设备IFNAME
	 */
	public String getFromNodeIfName() {
		return fromNodeIfName;
	}

	/**
	 * 源设备IFNAME设定
	 * @param fromNodeIfName 源设备IFNAME
	 */
	public void setFromNodeIfName(String fromNodeIfName) {
		this.fromNodeIfName = fromNodeIfName;
	}

	/**
	 * 目标设备物理端口取得
	 * @return topHysicalPort 目标设备物理端口
	 */
	public Integer getTopHysicalPort() {
		return topHysicalPort;
	}

	/**
	 * 目标设备物理端口设定
	 * @param topHysicalPort 目标设备物理端口
	 */
	public void setTopHysicalPort(Integer topHysicalPort) {
		this.topHysicalPort = topHysicalPort;
	}

	/**
	 * 目标设备IFINDEX取得
	 * @return toNodeIfIndex 目标设备IFINDEX
	 */
	public Integer getToNodeIfIndex() {
		return toNodeIfIndex;
	}

	/**
	 * 目标设备IFINDEX设定
	 * @param toNodeIfIndex 目标设备IFINDEX
	 */
	public void setToNodeIfIndex(Integer toNodeIfIndex) {
		this.toNodeIfIndex = toNodeIfIndex;
	}

	/**
	 * 目标设备IFNAME取得
	 * @return toNodeIfName 目标设备IFNAME
	 */
	public String getToNodeIfName() {
		return toNodeIfName;
	}

	/**
	 * 目标设备IFNAME设定
	 * @param toNodeIfName 目标设备IFNAME
	 */
	public void setToNodeIfName(String toNodeIfName) {
		this.toNodeIfName = toNodeIfName;
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

/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.nms.model.NMS10Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 链路黑名单信息实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="NMS10")
public class NMS10TB extends BaseEntity implements NMS10Info {
    
    /** 主键 */
    @Id
    protected String id;

    /** 源设备ID */
    protected String fromdid;

    /** 目标设备ID */
    protected String todid;

    /** 组ID */
    protected Integer gid;
    
    /** 用户id */
    protected String userid;

    /** 组版本 */
    protected Integer gversion;

    /** 源设备物理端口 */
    protected Integer fromPhysicalPort;

    /** 源设备IFINDEX */
    protected Integer fromNodeIfIndex;

    /** 源设备IFNAME */
    protected String fromNodeIfName;

    /** 目标设备物理端口 */
    protected Integer topHysicalPort;

    /** 目标设备IFINDEX */
    protected Integer toNodeIfIndex;

    /** 目标设备IFNAME */
    protected String toNodeIfName;

    /** 创建时间 */
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
     * 获取用户id
     * @return 用户id 
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置用户id
     * @param userid 用户id
     */
    public void setUserid(String userid) {
        this.userid = userid;
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

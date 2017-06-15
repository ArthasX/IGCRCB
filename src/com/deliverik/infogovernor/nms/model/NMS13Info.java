/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 链路白名单信息实体接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS13Info extends BaseModel {
    
    /**
     * 主键曲的
     * @return 主键
     */
    public String getId();

    /**
     * 源设备ID取得
     * @return fromdid 源设备ID
     */
    public String getFromdid();

    /**
     * 目标设备ID取得
     * @return todid 目标设备ID
     */
    public String getTodid();

    /**
     * 组ID取得
     * @return gid 组ID
     */
    public Integer getGid();

    /**
     * 组版本取得
     * @return gversion 组版本
     */
    public Integer getGversion();

    /**
     * 源设备物理端口取得
     * @return fromPhysicalPort 源设备物理端口
     */
    public Integer getFromPhysicalPort();

    /**
     * 源设备IFINDEX取得
     * @return fromNodeIfIndex 源设备IFINDEX
     */
    public Integer getFromNodeIfIndex();

    /**
     * 源设备IFNAME取得
     * @return fromNodeIfName 源设备IFNAME
     */
    public String getFromNodeIfName();

    /**
     * 目标设备物理端口取得
     * @return topHysicalPort 目标设备物理端口
     */
    public Integer getTopHysicalPort();

    /**
     * 目标设备IFINDEX取得
     * @return toNodeIfIndex 目标设备IFINDEX
     */
    public Integer getToNodeIfIndex();

    /**
     * 目标设备IFNAME取得
     * @return toNodeIfName 目标设备IFNAME
     */
    public String getToNodeIfName();

    /**
     * 创建时间取得
     * @return instime 创建时间
     */
    public String getInstime();

}

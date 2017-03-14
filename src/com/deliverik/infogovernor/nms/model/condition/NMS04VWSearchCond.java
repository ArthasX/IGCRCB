/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 设备信息实体查询条件接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS04VWSearchCond {
    
    /**
     * 获取组ID
     * @return 组ID 
     */
    public Integer getGid();

    /**
     * 获取组版本
     * @return 组版本 
     */
    public Integer getGversion();
    
    /**
     * 获取用户id
     * @return 用户id 
     */
    public String getUserid();
    
    /**
     * 获取拓扑展现类型（1：全网拓扑图2：网络设备拓扑图）
     * @return 拓扑展现类型（1：全网拓扑图2：网络设备拓扑图） 
     */
    public String getShowType();
}

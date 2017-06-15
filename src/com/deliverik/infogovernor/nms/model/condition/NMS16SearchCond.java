/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 组设备坐标查询条件接口
 * </p>
 * 
 * @version 1.0
 */
public interface NMS16SearchCond {


    /**
     * 获取组ID
     * @return 组ID 
     */
    public Integer getGid();

    /**
     * 获取设备ID
     * @return 设备ID 
     */
    public String getDid();
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
     * 获取用户id为空（查询全网拓扑时用）
     * @return 用户id为空（查询全网拓扑时用） 
     */
    public boolean isUseridEmpty();
    
    /**
     * 获取拓扑展现类型（1：全网拓扑图2：网络设备拓扑图）
     * @return 拓扑展现类型（1：全网拓扑图2：网络设备拓扑图） 
     */
    public String getType();
}

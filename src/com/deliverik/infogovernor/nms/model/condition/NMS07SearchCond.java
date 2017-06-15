/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 链路信息实体查询条件接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS07SearchCond {
    
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
     * 获取过滤黑名单
     * @return 过滤黑名单 
     */
    public boolean isFilterBlacklist();

    /**
     * 获取合并白名单
     * @return 合并白名单 
     */
    public boolean isMergeWhitelist();
    
    /**
     * 获取用户id
     * @return 用户id 
     */
    public String getUserid();
}

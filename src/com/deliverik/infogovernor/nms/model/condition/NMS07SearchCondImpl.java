/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 链路信息实体查询条件实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS07SearchCondImpl implements NMS07SearchCond{


    /** 组ID */
    protected Integer gid;

    /** 组版本 */
    protected Integer gversion;

    /** 过滤黑名单 */
    protected boolean filterBlacklist;
    
    /** 合并白名单 */
    protected boolean mergeWhitelist;
    
    /** 用户id */
    protected String userid;
    
    /**
     * 获取组ID
     * @return 组ID 
     */
    public Integer getGid() {
        return gid;
    }

    /**
     * 设置组ID
     * @param gid 组ID
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * 获取组版本
     * @return 组版本 
     */
    public Integer getGversion() {
        return gversion;
    }

    /**
     * 设置组版本
     * @param gversion 组版本
     */
    public void setGversion(Integer gversion) {
        this.gversion = gversion;
    }

    /**
     * 获取过滤黑名单
     * @return 过滤黑名单 
     */
    public boolean isFilterBlacklist() {
        return filterBlacklist;
    }

    /**
     * 设置过滤黑名单
     * @param filterBlacklist 过滤黑名单
     */
    public void setFilterBlacklist(boolean filterBlacklist) {
        this.filterBlacklist = filterBlacklist;
    }

    /**
     * 获取合并白名单
     * @return 合并白名单 
     */
    public boolean isMergeWhitelist() {
        return mergeWhitelist;
    }

    /**
     * 设置合并白名单
     * @param mergeWhitelist 合并白名单
     */
    public void setMergeWhitelist(boolean mergeWhitelist) {
        this.mergeWhitelist = mergeWhitelist;
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
    

}

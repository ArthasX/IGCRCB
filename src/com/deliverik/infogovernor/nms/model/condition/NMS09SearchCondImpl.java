/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 用户拓扑视图信息实体查询条件实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS09SearchCondImpl implements NMS09SearchCond{

    /** 组ID */
    protected Integer gid_eq;
    
    /** 组版本 */
    protected Integer gversion_eq;
    
    /** 用户ID */
    protected String userid_eq;
    
    /** 用户ID为空 */
    protected boolean useridEmpty =  false;

    /** 拓扑展现类型（1：全网拓扑图 2：网络设备拓扑图） */
    protected String showtype;
    
    /**
     * 获取组ID
     * @return 组ID 
     */
    public Integer getGid_eq() {
        return gid_eq;
    }

    /**
     * 设置组ID
     * @param gid_eq 组ID
     */
    public void setGid_eq(Integer gid_eq) {
        this.gid_eq = gid_eq;
    }

    /**
     * 获取组版本
     * @return 组版本 
     */
    public Integer getGversion_eq() {
        return gversion_eq;
    }

    /**
     * 设置组版本
     * @param gversion_eq 组版本
     */
    public void setGversion_eq(Integer gversion_eq) {
        this.gversion_eq = gversion_eq;
    }

    /**
     * 获取用户ID
     * @return 用户ID 
     */
    public String getUserid_eq() {
        return userid_eq;
    }

    /**
     * 设置用户ID
     * @param userid_eq 用户ID
     */
    public void setUserid_eq(String userid_eq) {
        this.userid_eq = userid_eq;
    }

    /**
     * 获取用户ID为空
     * @return 用户ID为空 
     */
    public boolean isUseridEmpty() {
        return useridEmpty;
    }

    /**
     * 设置用户ID为空
     * @param useridEmpty 用户ID为空
     */
    public void setUseridEmpty(boolean useridEmpty) {
        this.useridEmpty = useridEmpty;
    }

    /**
     * 获取拓扑展现类型（1：全网拓扑图2：网络设备拓扑图）
     * @return 拓扑展现类型（1：全网拓扑图2：网络设备拓扑图） 
     */
    public String getShowtype() {
        return showtype;
    }

    /**
     * 设置拓扑展现类型（1：全网拓扑图2：网络设备拓扑图）
     * @param showtype 拓扑展现类型（1：全网拓扑图2：网络设备拓扑图）
     */
    public void setShowtype(String showtype) {
        this.showtype = showtype;
    }
    
}

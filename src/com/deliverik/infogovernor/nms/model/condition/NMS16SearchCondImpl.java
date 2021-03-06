/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.condition;



/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 组设备坐标查询条件实现
 * </p>
 * 
 * @version 1.0
 */
public class NMS16SearchCondImpl implements NMS16SearchCond{

    /** 组ID */
    protected Integer gid;
    
    /** 设备ID */
    protected String did;
    
    /** 组版本 */
    protected Integer gversion;
    
    /** 用户id */
    protected String userid;

    /** 用户id为空（查询全网拓扑时用） */
    protected boolean useridEmpty;
    
    /** 拓扑展现类型（1：全网拓扑图 2：网络设备拓扑图） */
    protected String type;
    
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
     * 获取设备ID
     * @return 设备ID 
     */
    public String getDid() {
        return did;
    }

    /**
     * 设置设备ID
     * @param did 设备ID
     */
    public void setDid(String did) {
        this.did = did;
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
     * 获取用户id为空（查询全网拓扑时用）
     * @return 用户id为空（查询全网拓扑时用） 
     */
    public boolean isUseridEmpty() {
        return useridEmpty;
    }

    /**
     * 设置用户id为空（查询全网拓扑时用）
     * @param useridEmpty 用户id为空（查询全网拓扑时用）
     */
    public void setUseridEmpty(boolean useridEmpty) {
        this.useridEmpty = useridEmpty;
    }

    /**
     * 获取拓扑展现类型（1：全网拓扑图2：网络设备拓扑图）
     * @return 拓扑展现类型（1：全网拓扑图2：网络设备拓扑图） 
     */
    public String getType() {
        return type;
    }

    /**
     * 设置拓扑展现类型（1：全网拓扑图2：网络设备拓扑图）
     * @param type 拓扑展现类型（1：全网拓扑图2：网络设备拓扑图）
     */
    public void setType(String type) {
        this.type = type;
    }
}

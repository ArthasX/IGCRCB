/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.nms.model.NMS16Info;
import com.deliverik.infogovernor.nms.model.dao.annotation.FieldType;
import com.deliverik.infogovernor.nms.model.dao.annotation.Fk;
import com.deliverik.infogovernor.nms.model.dao.annotation.TableSpace;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 组设备坐标信息实体
 * </p>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="NMS16")
@TableSpace(name="ig_space")
public class NMS16TB extends BaseEntity implements NMS16Info {

    /** 主键 */
    @FieldType(value="VARCHAR(36)")
    @Id
    protected String id;
    
	/** 组ID */
	@FieldType(value="INTEGER")
	@Fk(tablename="NMS01",fkfield="ID",deleteCascade=true,updateCascade=true)
	protected Integer gid;
	
	/** 设备ID */
	@FieldType(value="VARCHAR(128)")
	@Fk(tablename="NMS04",fkfield="ID",deleteCascade=true,updateCascade=true)
	protected String did;
	
	/** 组版本 */
	@FieldType(value="INTEGER")
	protected Integer gversion;
	
	/** 用户id */
	@FieldType(value="VARCHAR(16)")
	protected String userid;
	
	/** X坐标 */
	@FieldType(value="VARCHAR(16)")
	protected String x;
	
	/** Y坐标 */
	@FieldType(value="VARCHAR(16)")
	protected String y;

    /** 拓扑展现类型（1：全网拓扑图 2：网络设备拓扑图） */
	@FieldType(value="VARCHAR(2)")
    protected String showtype;
    
    /**
     * 获取主键
     * @return 主键 
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id;
    }

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
     * 获取X坐标
     * @return X坐标 
     */
    public String getX() {
        return x;
    }

    /**
     * 设置X坐标
     * @param x X坐标
     */
    public void setX(String x) {
        this.x = x;
    }

    /**
     * 获取Y坐标
     * @return Y坐标 
     */
    public String getY() {
        return y;
    }

    /**
     * 设置Y坐标
     * @param y Y坐标
     */
    public void setY(String y) {
        this.y = y;
    }
    
    public Serializable getPK() {
        return this.id;
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

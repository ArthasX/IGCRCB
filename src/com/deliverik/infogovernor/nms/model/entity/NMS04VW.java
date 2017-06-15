/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.nms.model.NMS04VWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 设备信息实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
public class NMS04VW extends BaseEntity implements NMS04VWInfo {
	
	/** 主键 */
	@Id
	protected String id;
	
	/** 设备名称 */
	protected String name;
	
	/** 显示IP */
	protected String ip;
	
	/** 显示MAC地址 */
	protected String mac;
	
	/** 设备类型 */
	protected String type;
	
	/** 资产ID */
	protected Integer eiid;
	
	/** 资产大版本 */
	protected Integer eiversion;
	
	/** 资产小版本 */
	protected Integer eismallVersion;
	
	/** 创建时间 */
	protected String instime;
	
	/** 更新时间 */
	protected String updtime;
	
	/** 组id */
	protected Integer gid;
	
	/** 组版本 */
	protected Integer gversion;
	
	/** x坐标 */
	protected String x;
	
	/** y坐标 */
	protected String y;
	
    /** 设备别名 */
    protected String dispname;
    
	/**
	 * 主键取得
	 * @return id 主键
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
	 * 设备名称取得
	 * @return name 设备名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设备名称设定
	 * @param name 设备名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 显示IP取得
	 * @return ip 显示IP
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * 显示IP设定
	 * @param ip 显示IP
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 显示MAC地址取得
	 * @return mac 显示MAC地址
	 */
	public String getMac() {
		return mac;
	}

	/**
	 * 显示MAC地址设定
	 * @param mac 显示MAC地址
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}

	/**
	 * 设备类型取得
	 * @return type 设备类型
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设备类型设定
	 * @param type 设备类型
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 资产ID取得
	 * @return eiid 资产ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 资产ID设定
	 * @param eiid 资产ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 资产大版本取得
	 * @return eiversion 资产大版本
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 资产大版本设定
	 * @param eiversion 资产大版本
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 资产小版本取得
	 * @return eismallVersion 资产小版本
	 */
	public Integer getEismallVersion() {
		return eismallVersion;
	}

	/**
	 * 资产小版本设定
	 * @param eismallVersion 资产小版本
	 */
	public void setEismallVersion(Integer eismallVersion) {
		this.eismallVersion = eismallVersion;
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
	 * 更新时间取得
	 * @return updtime 更新时间
	 */
	public String getUpdtime() {
		return updtime;
	}

	/**
	 * 更新时间设定
	 * @param updtime 更新时间
	 */
	public void setUpdtime(String updtime) {
		this.updtime = updtime;
	}

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Serializable getPK() {
		return this.id;
	}

    /**
     * 获取组id
     * @return 组id 
     */
    public Integer getGid() {
        return gid;
    }

    /**
     * 设置组id
     * @param gid 组id
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
     * 获取x坐标
     * @return x坐标 
     */
    public String getX() {
        return x;
    }

    /**
     * 设置x坐标
     * @param x x坐标
     */
    public void setX(String x) {
        this.x = x;
    }

    /**
     * 获取y坐标
     * @return y坐标 
     */
    public String getY() {
        return y;
    }

    /**
     * 设置y坐标
     * @param y y坐标
     */
    public void setY(String y) {
        this.y = y;
    }

    /**
     * 获取设备别名
     * @return 设备别名 
     */
    public String getDispname() {
        return dispname;
    }

    /**
     * 设置设备别名
     * @param dispname 设备别名
     */
    public void setDispname(String dispname) {
        this.dispname = dispname;
    }

}

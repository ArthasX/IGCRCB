/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.nms.model.NMS09Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 用户拓扑视图信息实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="NMS09")
public class NMS09TB extends BaseEntity implements NMS09Info {

	/** 主键 */
	@Id
	@TableGenerator(
			name="NMS09_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="NMS09_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE,generator="NMS09_TABLE_GENERATOR")
	protected Integer id;
	
	/** 组ID */
	protected Integer gid;
	
	/** 组版本 */
	protected Integer gversion;
	
	/** 用户ID */
	protected String userid;
	
	/** 拓扑图 */
	protected String xml;
	
	/** 面板宽度 */
	protected String width;
	
	/** 面板高度 */
	protected String height;
	
	/** 创建时间 */
	protected String instime;
	
	/** 拓扑展现类型（1：全网拓扑图 2：网络设备拓扑图） */
	protected String showtype;
	
	/**
	 * 主键取得
	 * @return id 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 主键设定
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * 用户ID取得
	 * @return userid 用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 用户ID设定
	 * @param userid 用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 拓扑图取得
	 * @return xml 拓扑图
	 */
	public String getXml() {
		return xml;
	}

	/**
	 * 拓扑图设定
	 * @param xml 拓扑图
	 */
	public void setXml(String xml) {
		this.xml = xml;
	}

	/**
     * 获取面板宽度
     * @return 面板宽度 
     */
    public String getWidth() {
        return width;
    }

    /**
     * 设置面板宽度
     * @param width 面板宽度
     */
    public void setWidth(String width) {
        this.width = width;
    }

    /**
     * 获取面板高度
     * @return 面板高度 
     */
    public String getHeight() {
        return height;
    }

    /**
     * 设置面板高度
     * @param height 面板高度
     */
    public void setHeight(String height) {
        this.height = height;
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

    /**
	 * 主键取得
	 * @return 主键
	 */
	public Serializable getPK() {
		return this.id;
	}

}

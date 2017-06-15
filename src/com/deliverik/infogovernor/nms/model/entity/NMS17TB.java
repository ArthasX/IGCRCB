/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.nms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.nms.model.NMS17Info;

/**
  * 概述: 子网区域信息实体
  * 功能描述: 子网区域信息实体
  * 创建记录: 2014/01/07
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="NMS17")
public class NMS17TB extends BaseEntity implements Serializable,
		Cloneable, NMS17Info {

	/** 主键 */
	@Id
	protected String id;

	/** 所属组主键 */
	protected Integer gid;

	/** 所属组版本 */
	protected Integer gversion;

	/** 所属用户（全网时为空） */
	protected String userid;

	/** x坐标 */
	protected String x;

	/** y坐标 */
	protected String y;

	/** 宽度 */
	protected String width;

	/** 高度 */
	protected String height;
	
	/** 区域标题 */
	protected String title;
	
	/** 旋转角度 */
	protected String rotation;

    /** 拓扑展现类型（1：全网拓扑图 2：网络设备拓扑图） */
//    protected String showtype;
    
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getId() {
		return id;
	}

	/**
	 * 主键设定
	 *
	 * @param id 主键
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 所属组主键取得
	 *
	 * @return 所属组主键
	 */
	public Integer getGid() {
		return gid;
	}

	/**
	 * 所属组主键设定
	 *
	 * @param gid 所属组主键
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	/**
	 * 所属组版本取得
	 *
	 * @return 所属组版本
	 */
	public Integer getGversion() {
		return gversion;
	}

	/**
	 * 所属组版本设定
	 *
	 * @param gversion 所属组版本
	 */
	public void setGversion(Integer gversion) {
		this.gversion = gversion;
	}

	/**
	 * 所属用户（全网时为空）取得
	 *
	 * @return 所属用户（全网时为空）
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 所属用户（全网时为空）设定
	 *
	 * @param userid 所属用户（全网时为空）
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * x坐标取得
	 *
	 * @return x坐标
	 */
	public String getX() {
		return x;
	}

	/**
	 * x坐标设定
	 *
	 * @param x x坐标
	 */
	public void setX(String x) {
		this.x = x;
	}

	/**
	 * y坐标取得
	 *
	 * @return y坐标
	 */
	public String getY() {
		return y;
	}

	/**
	 * y坐标设定
	 *
	 * @param y y坐标
	 */
	public void setY(String y) {
		this.y = y;
	}

	/**
	 * 宽度取得
	 *
	 * @return 宽度
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * 宽度设定
	 *
	 * @param width 宽度
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * 高度取得
	 *
	 * @return 高度
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * 高度设定
	 *
	 * @param height 高度
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return id;
	}

    /**
     * 区域标题取得
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 区域标题设定
     * @param title title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取旋转角度
     * @return 旋转角度 
     */
    public String getRotation() {
        return rotation;
    }

    /**
     * 设置旋转角度
     * @param rotation 旋转角度
     */
    public void setRotation(String rotation) {
        this.rotation = rotation;
    }

}
/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG110Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 查询显示列定义实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IG110")
public class IG110TB extends BaseEntity implements IG110Info{
	
	/** 主键 */
	@Id
	protected String sid;
	
	/** 流程定义ID */
	protected String pdid;
	
	/** 显示列类型 */
	protected String stype;
	
	/** 显示列标识 */
	protected String sflag;
	
	/** 标识名称 */
	protected String sname;
	
	/** 宽度 */
	protected Integer width;

	/**
	 * 主键取得
	 * @return sid 主键
	 */
	public String getSid() {
		return sid;
	}

	/**
	 * 主键设定
	 * @param sid 主键
	 */
	public void setSid(String sid) {
		this.sid = sid;
	}

	/**
	 * 流程定义ID取得
	 * @return pdid 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 显示列类型取得
	 * @return stype 显示列类型
	 */
	public String getStype() {
		return stype;
	}

	/**
	 * 显示列类型设定
	 * @param stype 显示列类型
	 */
	public void setStype(String stype) {
		this.stype = stype;
	}

	/**
	 * 显示列标识取得
	 * @return sflag 显示列标识
	 */
	public String getSflag() {
		return sflag;
	}

	/**
	 * 显示列标识设定
	 * @param sflag 显示列标识
	 */
	public void setSflag(String sflag) {
		this.sflag = sflag;
	}

	/**
	 * 标识名称取得
	 * @return sname 标识名称
	 */
	public String getSname() {
		return sname;
	}

	/**
	 * 标识名称设定
	 * @param sname 标识名称
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}

	/**
	 * 宽度取得
	 * @return width 宽度
	 */
	public Integer getWidth() {
		return width;
	}

	/**
	 * 宽度设定
	 * @param width 宽度
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Serializable getPK() {
		return this.sid;
	}

}

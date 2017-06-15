/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.soc.asset.model.SOC0125Info;

/**
 * 概述: 最新版本域信息
 * 功能描述: 最新版本域信息
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
@Entity
@SuppressWarnings("serial")
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "SOC0125")
@IdClass(SOC0125PK.class)
public class SOC0125VW implements Serializable,Cloneable,SOC0125Info{
	
	/** 主键 */
	@Id
	protected Integer eiddid;

	/** 名称 */
	protected String name;

	/** 版本号 */
	@Id
	protected Integer version;

	/** 描述 */
	protected String description;
	/**
	 * 创建时间
	 */
	protected String createtime;
	/**
	 * 更新时间
	 */
	protected String updatetime;
	

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getEiddid() {
		return eiddid;
	}

	/**
	 * 主键设定
	 *
	 * @param eiddid主键
	 */
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}

	/**
	 * 名称取得
	 *
	 * @return 名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 名称设定
	 *
	 * @param name名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 版本号取得
	 *
	 * @return 版本号
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * 版本号设定
	 *
	 * @param version版本号
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * 描述取得
	 *
	 * @return 描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 描述设定
	 *
	 * @param description描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return  new SOC0111PK(eiddid,version);
	}
	/**
	 * 创建时间取得
	 * @return 创建时间
	 */
	public String getCreatetime() {
		return createtime;
	}
	/**
	 * 创建时间设置
	 * @param createtime创建时间
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	/**
	 * 更新时间取得
	 * @return 更新时间
	 */
	public String getUpdatetime() {
		return updatetime;
	}
	/**
	 * 更新时间设置
	 * @param updatetime更新时间
	 */
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

}

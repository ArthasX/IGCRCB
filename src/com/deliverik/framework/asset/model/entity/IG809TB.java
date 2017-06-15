/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.asset.model.IG809Info;
import com.deliverik.framework.base.BaseEntity;

/**
 * 资产关系图文件信息实体
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG809")
public class IG809TB extends BaseEntity implements Serializable, Cloneable, IG809Info {

	/** 主键 */
	@Id
	@TableGenerator(
		    name="IG809_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG809_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG809_TABLE_GENERATOR")
	protected Integer eirfid;
	
	/** 资产ID */
	protected Integer eiid;
	
	/** 关系图类型 */
	protected String eirftype;
	
	/** 关系图文件名 */
	protected String eirfname;
	
	/** 更新时间 */
	protected String eirfupdtime;
	
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return eirfid;
	}

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Integer getEirfid() {
		return eirfid;
	}

	/**
	 * 主键设定
	 * @return 主键
	 */
	public void setEirfid(Integer eirfid) {
		this.eirfid = eirfid;
	}

	/**
	 * 资产ID取得
	 * @return 资产ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 资产ID设定
	 * @return 资产ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 关系图类型取得
	 * @return 关系图类型
	 */
	public String getEirftype() {
		return eirftype;
	}

	/**
	 * 关系图类型设定
	 * @return 关系图类型
	 */
	public void setEirftype(String eirftype) {
		this.eirftype = eirftype;
	}

	/**
	 * 关系图文件名取得
	 * @return 关系图文件名
	 */
	public String getEirfname() {
		return eirfname;
	}

	/**
	 * 关系图文件名设定
	 * @return 关系图文件名
	 */
	public void setEirfname(String eirfname) {
		this.eirfname = eirfname;
	}

	/**
	 * 更新时间取得
	 * @return 更新时间
	 */
	public String getEirfupdtime() {
		return eirfupdtime;
	}

	/**
	 * 更新时间设定
	 * @return 更新时间
	 */
	public void setEirfupdtime(String eirfupdtime) {
		this.eirfupdtime = eirfupdtime;
	}

	
}

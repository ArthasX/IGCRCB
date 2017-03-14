/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.cic.model.CompareobjectInfo;

/**
  * 概述: 对比对象实体
  * 功能描述: 对比对象实体
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="compareobject")
public class CompareobjectTB extends BaseEntity implements Serializable,
		Cloneable, CompareobjectInfo {

	/** 主键 */
	@Id

	@GeneratedValue(generator = "coid")
	@GenericGenerator(name = "coid", strategy = "sequence", 
			parameters = { @Parameter(name = "sequence", 
						value = "compareobject_seq") })
	protected Integer coid;

	/** 名称 */
	protected String coname;

	/** 对比源主机id */
	protected Integer cosource;
	

	/** 对比目标主机id */
	protected Integer cotarget;

	@Column(name="fkcrid")
	/** 对比规则外键 */
	protected Integer fkCrid;
	

	/** 源主机IP */
	protected String sourceIP;

	/** targetIP */
	protected String targetIP;

	/** 对比规则版本 */
	protected Integer crversion;
	
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getCoid() {
		return coid;
	}

	/**
	 * 主键设定
	 *
	 * @param coid 主键
	 */
	public void setCoid(Integer coid) {
		this.coid = coid;
	}

	/**
	 * 名称取得
	 *
	 * @return 名称
	 */
	public String getConame() {
		return coname;
	}

	/**
	 * 名称设定
	 *
	 * @param coname 名称
	 */
	public void setConame(String coname) {
		this.coname = coname;
	}

	/**
	 * 对比源主机id取得
	 *
	 * @return 对比源主机id
	 */
	public Integer getCosource() {
		return cosource;
	}

	/**
	 * 对比源主机id设定
	 *
	 * @param cosource 对比源主机id
	 */
	public void setCosource(Integer cosource) {
		this.cosource = cosource;
	}

	/**
	 * 对比目标主机id取得
	 *
	 * @return 对比目标主机id
	 */
	public Integer getCotarget() {
		return cotarget;
	}

	/**
	 * 对比目标主机id设定
	 *
	 * @param cotarget 对比目标主机id
	 */
	public void setCotarget(Integer cotarget) {
		this.cotarget = cotarget;
	}

	/**
	 * 对比规则外键取得
	 *
	 * @return 对比规则外键
	 */
	public Integer getFkCrid() {
		return fkCrid;
	}

	/**
	 * 对比规则外键设定
	 *
	 * @param fk_crid 对比规则外键
	 */
	public void setFkCrid(Integer fkCrid) {
		this.fkCrid = fkCrid;
	}

	/**
	 * 源主机IP取得
	 *
	 * @return 源主机IP
	 */
	public String getSourceIP() {
		return sourceIP;
	}

	/**
	 * 源主机IP设定
	 *
	 * @param sourceIP 源主机IP
	 */
	public void setSourceIP(String sourceIP) {
		this.sourceIP = sourceIP;
	}

	/**
	 * targetIP取得
	 *
	 * @return targetIP
	 */
	public String getTargetIP() {
		return targetIP;
	}

	/**
	 * targetIP设定
	 *
	 * @param targetIP targetIP
	 */
	public void setTargetIP(String targetIP) {
		this.targetIP = targetIP;
	}

	/** 
     * 对比规则版本 取得
     * @return crversion 对比规则版本 
     */
    public Integer getCrversion() {
        return crversion;
    }

    /** 
     * 对比规则版本 设定
     * @param crversion 对比规则版本 
     */
    public void setCrversion(Integer crversion) {
        this.crversion = crversion;
    }

    /**
	 * 主键取得
	 *
	 * @return 主键
	 */
	@Override
	public Serializable getPK() {
		return coid;
	}



	
}
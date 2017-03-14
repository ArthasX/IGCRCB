/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.asset.model.IgdocdownInfo;

/**
  * 概述: 下载记录表实体
  * 功能描述: 下载记录表实体
  * 创建记录: 2014/07/24
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="igdocdown")
public class IgdocdownTB extends BaseEntity implements Serializable,
		Cloneable, IgdocdownInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="IGDOCDOWN_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IGDOCDOWN_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IGDOCDOWN_TABLE_GENERATOR")
	protected Integer ddid;

	/** 文档资产ID */
	protected Integer eiid;

	/** 下载人 */
	protected String userid;

	/** 下载时间 */
	protected String downtime;

	/** 下载位置 */
	protected String downlocation;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getDdid() {
		return ddid;
	}

	/**
	 * 主键设定
	 *
	 * @param ddid 主键
	 */
	public void setDdid(Integer ddid) {
		this.ddid = ddid;
	}

	/**
	 * 文档资产ID取得
	 *
	 * @return 文档资产ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 文档资产ID设定
	 *
	 * @param eiid 文档资产ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 下载人取得
	 *
	 * @return 下载人
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 下载人设定
	 *
	 * @param userid 下载人
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 下载时间取得
	 *
	 * @return 下载时间
	 */
	public String getDowntime() {
		return downtime;
	}

	/**
	 * 下载时间设定
	 *
	 * @param downtime 下载时间
	 */
	public void setDowntime(String downtime) {
		this.downtime = downtime;
	}

	/**
	 * 下载位置取得
	 *
	 * @return 下载位置
	 */
	public String getDownlocation() {
		return downlocation;
	}

	/**
	 * 下载位置设定
	 *
	 * @param downlocation 下载位置
	 */
	public void setDownlocation(String downlocation) {
		this.downlocation = downlocation;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return ddid;
	}

	public void setFingerprint(String fingerprint) {
		// TODO Auto-generated method stub
		this.fingerPrint = fingerprint;
	}

}
/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.sym.model.ReportFileVersion;

/**
 * 报表版本实体
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="ReportFileVersion")
public class ReportFileVersionTB extends BaseEntity implements Serializable, Cloneable, ReportFileVersion {

	/** 主键 */
	@Id
	@TableGenerator(
		    name="REPORTFILEVERSION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="REPORTFILEVERSION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="REPORTFILEVERSION_TABLE_GENERATOR")
	protected Integer rfvid;

	/** 报表主键 */
	protected Integer rfdid;
	
	/** 版本号 */
	protected Integer rfvversion;
	
	/** 创建时间 */
	protected String rfvinstime;
	
	/**
	 * 获取主键
	 * @return 
	 */
	public Serializable getPK() {
		return rfvid;
	}

	/**
	 * 比较
	 * @return 
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof ReportFileVersionTB))
			return false;
		ReportFileVersion target = (ReportFileVersion) obj;
		if (!(getRfvid()==target.getRfvid()))
			return false;

		return true;
	}

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Integer getRfvid() {
		return rfvid;
	}
	
	/**
	 * 主键设定
	 * @param rfvid 主键
	 */
	public void setRfvid(Integer rfvid) {
		this.rfvid = rfvid;
	}
	
	/**
	 * 报表主键取得
	 * @return 报表主键
	 */
	public Integer getRfdid() {
		return rfdid;
	}

	/**
	 * 报表主键设定
	 * @param rfdid 报表主键
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}

	/**
	 * 版本号取得
	 * @return 版本号
	 */
	public Integer getRfvversion() {
		return rfvversion;
	}

	/**
	 * 版本号设定
	 * @param rfdid 版本号
	 */
	public void setRfvversion(Integer rfvversion) {
		this.rfvversion = rfvversion;
	}

	/**
	 * 创建时间取得
	 * @return 创建时间
	 */
	public String getRfvinstime() {
		return rfvinstime;
	}

	/**
	 * 创建时间设定
	 * @param rfvinstime 创建时间
	 */
	public void setRfvinstime(String rfvinstime) {
		this.rfvinstime = rfvinstime;
	}
	
}

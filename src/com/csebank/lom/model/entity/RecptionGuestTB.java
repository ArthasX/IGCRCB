/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.csebank.lom.model.RecptionGuest;
import com.deliverik.framework.base.BaseEntity;

/**
 * 
 * 接待客人实体
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="RecptionGuest")
public class RecptionGuestTB extends BaseEntity implements Serializable, Cloneable, RecptionGuest {
	
	/** 接待客人ID */
	@Id
	@TableGenerator(
		    name="RECPTIONGUEST_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="RECPTIONGUEST_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RECPTIONGUEST_TABLE_GENERATOR")
	protected Integer rgid;

	/** 接待工作ID */
	public Integer rid;
	
	/** 接待客人姓名 */
	public String rgname;
	
	/** 接待客人职务 */
	public String rgpost;
	
	/** 接待客人单位 */
	public String rgunit;
	
	/** 接待客人联系方式 */
	public String rgtel;
	
	/** 登记日期 */
	public String rgdate;

	
	
	
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return rgid;
	}

	/**
	 * 接待客人ID取得
	 * @return 接待工作ID
	 */
	public Integer getRgid() {
		return rgid;
	}

	/**
	 * 接待客人ID设定
	 * @param rgid 接待工作ID
	 */
	public void setRgid(Integer rgid) {
		this.rgid = rgid;
	}

	/**
	 * 接待工作ID取得
	 * @return 接待工作ID
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * 接待工作ID设定
	 * @param rgid 接待工作ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	/**
	 * 接待客人姓名取得
	 * @return 接待客人姓名
	 */
	public String getRgname() {
		return rgname;
	}

	/**
	 * 接待客人姓名设定
	 * @param rgname 接待客人姓名
	 */
	public void setRgname(String rgname) {
		this.rgname = rgname;
	}

	/**
	 * 接待客人职务取得
	 * @return 接待客人职务
	 */
	public String getRgpost() {
		return rgpost;
	}

	/**
	 * 接待客人职务设定
	 * @param rgpost 接待客人职务
	 */
	public void setRgpost(String rgpost) {
		this.rgpost = rgpost;
	}

	/**
	 * 接待客人单位取得
	 * @return 接待客人单位
	 */
	public String getRgunit() {
		return rgunit;
	}

	/**
	 * 接待客人单位设定
	 * @param rgunit 接待客人单位
	 */
	public void setRgunit(String rgunit) {
		this.rgunit = rgunit;
	}

	/**
	 * 接待客人联系方式取得
	 * @return 接待客人联系方式
	 */
	public String getRgtel() {
		return rgtel;
	}

	/**
	 * 接待客人联系方式设定
	 * @param rgtel 接待客人联系方式
	 */
	public void setRgtel(String rgtel) {
		this.rgtel = rgtel;
	}

	/**
	 * 登记日期取得
	 * @return 登记日期
	 */
	public String getRgdate() {
		return rgdate;
	}

	/**
	 * 登记日期设定
	 * @param rgdate 登记日期
	 */
	public void setRgdate(String rgdate) {
		this.rgdate = rgdate;
	}


}

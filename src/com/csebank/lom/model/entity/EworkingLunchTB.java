/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.csebank.lom.model.EworkingLunch;
import com.deliverik.framework.base.BaseEntity;

/**
 * 
 * 食堂工作餐信息实体
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="EworkingLunch")
public class EworkingLunchTB extends BaseEntity implements Serializable, Cloneable, EworkingLunch {
	
	/** 自增无意义主键 */
	
	@TableGenerator(
		    name="EWORKINGLUNCH_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="EWORKINGLUNCH_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="EWORKINGLUNCH_TABLE_GENERATOR")
	@Id
	protected Integer ewlid;

	/** 日期 */
	protected String ewldate;
	
	/** 餐卡名称 */
	protected String lunchcardname;
	
	/** 餐卡数量 */
	protected Integer lunchcardnum;
	
	/** 餐卡价钱 */
	protected BigDecimal lunchcardprince;
	
	/** 餐卡编号 */
	protected Integer icid;
	
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return ewlid;
	}
	
	/**
	 * 自增无意义主键
	 * @return 自增无意义主键
	 */
	public Integer getEwlid() {
		return ewlid;
	}
	
	/**
	 * 自增无意义主键
	 * @return 自增无意义主键
	 */
	public void setEwlid(Integer ewlid) {
		this.ewlid = ewlid;
	}
	
	/**
	 * 日期
	 * @return 日期
	 */
	public String getEwldate() {
		return ewldate;
	}
	/**
	 * 日期
	 * @param ewldate 日期
	 */
	public void setEwldate(String ewldate) {
		this.ewldate = ewldate;
	}

	public String getLunchcardname() {
		return lunchcardname;
	}

	public void setLunchcardname(String lunchcardname) {
		this.lunchcardname = lunchcardname;
	}

	public Integer getLunchcardnum() {
		return lunchcardnum;
	}

	public void setLunchcardnum(Integer lunchcardnum) {
		this.lunchcardnum = lunchcardnum;
	}

	public BigDecimal getLunchcardprince() {
		return lunchcardprince;
	}

	public void setLunchcardprince(BigDecimal lunchcardprince) {
		this.lunchcardprince = lunchcardprince;
	}

	public Integer getIcid() {
		return icid;
	}

	public void setIcid(Integer icid) {
		this.icid = icid;
	}
	
}

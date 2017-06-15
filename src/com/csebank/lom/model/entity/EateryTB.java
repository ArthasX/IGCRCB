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

import com.csebank.lom.model.Eatery;
import com.deliverik.framework.base.BaseEntity;

/**
 * 
 * 食堂成本实体
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="Eatery")
public class EateryTB extends BaseEntity implements Serializable, Cloneable, Eatery {
	
	/** 自增无意义主键 */
	
	@TableGenerator(
		    name="EATERY_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="EATERY_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="EATERY_TABLE_GENERATOR")
	@Id
	protected Integer eid;

	/** 日期 */
	protected String edate;
	
	/** 采购原料成本 */
	protected BigDecimal estaplecost;
	
	/** 调味品成本 */
	protected BigDecimal eflavouringcost;
	
	/** 其他成本 */
	protected BigDecimal eothercost;
	
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return eid;
	}
	
	/**
	 * 自增无意义主键
	 * @return 自增无意义主键
	 */
	public Integer getEid() {
		return eid;
	}
	
	/**
	 * 自增无意义主键
	 * @param eid 自增无意义主键
	 */
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	
	/**
	 * 日期
	 * @return 日期
	 */
	public String getEdate() {
		return edate;
	}
	
	/**
	 * 日期
	 * @param edate  日期
	 */
	public void setEdate(String edate) {
		this.edate = edate;
	}
	
	/**
	 * 采购原料成本
	 * @return 采购原料成本
	 */
	public BigDecimal getEstaplecost() {
		return estaplecost;
	}
	
	/**
	 * 采购原料成本
	 * @param estaplecost 采购原料成本
	 */
	public void setEstaplecost(BigDecimal estaplecost) {
		this.estaplecost = estaplecost;
	}
	
	/**
	 * 调味品成本
	 * @return 调味品成本
	 */
	public BigDecimal getEflavouringcost() {
		return eflavouringcost;
	}
	
	/**
	 * 调味品成本
	 * @param eflavouringcost 调味品成本
	 */
	public void setEflavouringcost(BigDecimal eflavouringcost) {
		this.eflavouringcost = eflavouringcost;
	}
	
	/**
	 * 其他成本
	 * @return 其他成本
	 */
	public BigDecimal getEothercost() {
		return eothercost;
	}
	
	/**
	 * 其他成本
	 * @param eothercost 其他成本
	 */
	public void setEothercost(BigDecimal eothercost) {
		this.eothercost = eothercost;
	}
	
}

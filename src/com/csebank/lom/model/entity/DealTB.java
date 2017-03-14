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
import javax.persistence.Transient;

import com.csebank.lom.model.Deal;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 模块：后勤管理 -接待管理-外出就餐管理实体TB类
 * 说明：外出就餐管理entity
 * 作者：唐晓娜
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="DEAL")
public class DealTB extends BaseEntity implements Serializable, Cloneable, Deal {
	
	/** 
	 * 
	 * 外出就餐管理ID
	 * 配置hibernate实体对应
	 * 
	 * */
	@Id
	@TableGenerator(
		    name="DEAL_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="DEAL_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="DEAL_TABLE_GENERATOR")
	protected Integer rid;
	
	/** 申请部门名称 */
	protected String deptName;
	
	

	/** 主要申请部门层次码 */
	protected String rapporgid;
	
	
	/** 申请时间  */
	protected String dealTime;
	
	

	/** 申请人数规模  */
	protected String dealScale;
	
	

	/** 申请金额  */
	protected BigDecimal dealCash;
	
	/** 发票编号 */
	protected String invoiceNumber;
	
	/** 其他参与者  */
	protected String otherJoiner;
	
	/** 其他内容描述  */
	protected String dealDesc;
	
	
	
	/** 状态（1进行中，2结束） */
	protected String rstatus;
	
	  /** 机构信息实体 */
	@Transient
	protected OrganizationTB organizationTB;

	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return rid;
	}
	
	/**
	 * 接待管理ID
	 * @return 接待管理ID
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * 接待管理ID
	 * @param rid 接待管理ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	

	/**
	 * 状态
	 * @return 状态
	 */
	public String getRstatus() {
		return rstatus;
	}

	/**
	 * 状态
	 * @param rstatus 状态
	 */
	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getRapporgid() {
		return rapporgid;
	}

	public void setRapporgid(String rapporgid) {
		this.rapporgid = rapporgid;
	}
	public String getDealTime() {
		return dealTime;
	}

	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}
	public String getDealScale() {
		return dealScale;
	}

	public void setDealScale(String dealScale) {
		this.dealScale = dealScale;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getOtherJoiner() {
		return otherJoiner;
	}

	public void setOtherJoiner(String otherJoiner) {
		this.otherJoiner = otherJoiner;
	}

	public String getDealDesc() {
		return dealDesc;
	}

	public void setDealDesc(String dealDesc) {
		this.dealDesc = dealDesc;
	}

	public OrganizationTB getOrganizationTB() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * dealCash取得
	 *
	 * @return dealCash dealCash
	 */
	public BigDecimal getDealCash() {
		return dealCash;
	}

	/**
	 * dealCash设定
	 *
	 * @param dealCash dealCash
	 */
	public void setDealCash(BigDecimal dealCash) {
		this.dealCash = dealCash;
	}
	
}

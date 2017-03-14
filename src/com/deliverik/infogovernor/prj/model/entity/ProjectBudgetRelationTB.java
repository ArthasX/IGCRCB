/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prj.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.prj.model.ProjectBudgetRelationInfo;

/**
 * 概述:预算与项目关系表实体 
 * 功能描述：预算与项目关系表实体
 * 创建人：王廷志
 * 创建记录： 2012-5-17
 * 修改记录：
 */
@Entity
@Table(name="ProjectBudgetRelation")
@SuppressWarnings("serial")
public class ProjectBudgetRelationTB extends BaseEntity implements ProjectBudgetRelationInfo{
	@Id
	@TableGenerator(
			name="PROJECTBUDGETRELATION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
			pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
			pkColumnValue="PROJECTBUDGETRELATION_SEQUENCE", initialValue=1, allocationSize=1
		)
		@GeneratedValue(strategy = GenerationType.TABLE, generator="PROJECTBUDGETRELATION_TABLE_GENERATOR")
	/** 关系表主键 */
	protected Integer pbid;
	/** 项目ID */
	protected Integer pid;
	/** 预算ID */
	protected Integer bid;
	/** 预算 资本金 开发*/
	protected Double bzdevelop;
	/** 预算 资本金 硬件*/
	protected Double bzhardware;
	/** 预算 资本金 软件*/
	protected Double bzsoftware;
	/** 预算 资本金 工程*/
	protected Double bzproject;
	/** 预算 资本金 其他*/
	protected Double bzelse;
	/** 预算 成本金 实施*/
	protected Double bcimplement;
	/** 预算 成本金 其他*/
	protected Double bcelse;
	/** 更新时间 */
	protected String pbdatetime;
	/**
	 * 关系表主键取得
	 * @return pbid 关系表主键
	 */
	public Integer getPbid() {
		return pbid;
	}
	/**
	 * 关系表主键设定
	 * @param pbid 关系表主键
	 */
	public void setPbid(Integer pbid) {
		this.pbid = pbid;
	}
	/**
	 * 项目ID取得
	 * @return pid 项目ID
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * 项目ID设定
	 * @param pid 项目ID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 预算ID取得
	 * @return bid 预算ID
	 */
	public Integer getBid() {
		return bid;
	}
	/**
	 * 预算ID设定
	 * @param bid 预算ID
	 */
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	/**
	 * 预算资本金开发取得
	 * @return bzdevelop 预算资本金开发
	 */
	public Double getBzdevelop() {
		return bzdevelop;
	}
	/**
	 * 预算资本金开发设定
	 * @param bzdevelop 预算资本金开发
	 */
	public void setBzdevelop(Double bzdevelop) {
		this.bzdevelop = bzdevelop;
	}
	/**
	 * 预算资本金硬件取得
	 * @return bzhardware 预算资本金硬件
	 */
	public Double getBzhardware() {
		return bzhardware;
	}
	/**
	 * 预算资本金硬件设定
	 * @param bzhardware 预算资本金硬件
	 */
	public void setBzhardware(Double bzhardware) {
		this.bzhardware = bzhardware;
	}
	/**
	 * 预算资本金软件取得
	 * @return bzsoftware 预算资本金软件
	 */
	public Double getBzsoftware() {
		return bzsoftware;
	}
	/**
	 * 预算资本金软件设定
	 * @param bzsoftware 预算资本金软件
	 */
	public void setBzsoftware(Double bzsoftware) {
		this.bzsoftware = bzsoftware;
	}
	/**
	 * 预算资本金工程取得
	 * @return bzproject 预算资本金工程
	 */
	public Double getBzproject() {
		return bzproject;
	}
	/**
	 * 预算资本金工程设定
	 * @param bzproject 预算资本金工程
	 */
	public void setBzproject(Double bzproject) {
		this.bzproject = bzproject;
	}
	/**
	 * 预算资本金其他取得
	 * @return bzelse 预算资本金其他
	 */
	public Double getBzelse() {
		return bzelse;
	}
	/**
	 * 预算资本金其他设定
	 * @param bzelse 预算资本金其他
	 */
	public void setBzelse(Double bzelse) {
		this.bzelse = bzelse;
	}
	/**
	 * 预算成本金实施取得
	 * @return bcimplement 预算成本金实施
	 */
	public Double getBcimplement() {
		return bcimplement;
	}
	/**
	 * 预算成本金实施设定
	 * @param bcimplement 预算成本金实施
	 */
	public void setBcimplement(Double bcimplement) {
		this.bcimplement = bcimplement;
	}
	/**
	 * 预算成本金其他取得
	 * @return bcelse 预算成本金其他
	 */
	public Double getBcelse() {
		return bcelse;
	}
	/**
	 * 预算成本金其他设定
	 * @param bcelse 预算成本金其他
	 */
	public void setBcelse(Double bcelse) {
		this.bcelse = bcelse;
	}
	/**
	 * 更新时间取得
	 * @return pbdatetime 更新时间
	 */
	public String getPbdatetime() {
		return pbdatetime;
	}
	/**
	 * 更新时间设定
	 * @param pbdatetime 更新时间
	 */
	public void setPbdatetime(String pbdatetime) {
		this.pbdatetime = pbdatetime;
	}
	/***
	 * 主键取得
	 * @return 主键
	 */
	public Serializable getPK() {
		return this.pbid;
	}
	
}

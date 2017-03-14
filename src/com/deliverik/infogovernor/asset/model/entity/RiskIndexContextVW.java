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
import com.deliverik.infogovernor.asset.model.RiskIndexContextVWInfo;

/**
  * 概述: 风险指标展示内容查询实体
  * 功能描述: 风险指标展示内容查询实体
  * 创建记录: 2014/07/26
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="RiskIndexContextVW")
public class RiskIndexContextVW extends BaseEntity implements Serializable,
		Cloneable, RiskIndexContextVWInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="RISKINDEXCONTEXTVW_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="RISKINDEXCONTEXTVW_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKINDEXCONTEXTVW_TABLE_GENERATOR")
	protected Integer rimid;

	/** 指标主键 */
	protected Integer eiid;

	/** 计算方式 */
	protected String rimtype;

	/** 存储sql */
	protected String rimsql;

	/** 风险名称 */
	protected String einame;

	/** 风险标号 */
	protected String eilabel;

	/** 描述 */
	protected String rimdesc;
	
	/**分类*/
	protected String esyscoding;

	/**
	 * 分类取得
	 * @return esyscoding 分类
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 分类设定
	 * @param esyscoding 分类
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getRimid() {
		return rimid;
	}

	/**
	 * 主键设定
	 *
	 * @param rimid 主键
	 */
	public void setRimid(Integer rimid) {
		this.rimid = rimid;
	}

	/**
	 * 指标主键取得
	 *
	 * @return 指标主键
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 指标主键设定
	 *
	 * @param eiid 指标主键
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 计算方式取得
	 *
	 * @return 计算方式
	 */
	public String getRimtype() {
		return rimtype;
	}

	/**
	 * 计算方式设定
	 *
	 * @param rimtype 计算方式
	 */
	public void setRimtype(String rimtype) {
		this.rimtype = rimtype;
	}

	/**
	 * 存储sql取得
	 *
	 * @return 存储sql
	 */
	public String getRimsql() {
		return rimsql;
	}

	/**
	 * 存储sql设定
	 *
	 * @param rimsql 存储sql
	 */
	public void setRimsql(String rimsql) {
		this.rimsql = rimsql;
	}

	/**
	 * 风险名称取得
	 *
	 * @return 风险名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 风险名称设定
	 *
	 * @param einame 风险名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 风险标号取得
	 *
	 * @return 风险标号
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 风险标号设定
	 *
	 * @param eilabel 风险标号
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 描述取得
	 *
	 * @return 描述
	 */
	public String getRimdesc() {
		return rimdesc;
	}

	/**
	 * 描述设定
	 *
	 * @param rimdesc 描述
	 */
	public void setRimdesc(String rimdesc) {
		this.rimdesc = rimdesc;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return rimid;
	}

}
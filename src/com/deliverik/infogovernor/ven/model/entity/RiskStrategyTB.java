/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.ven.model.RiskStrategyInfo;

/**
  * 概述: 风险策略表实体
  * 功能描述: 风险策略表实体
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="RiskStrategy")
public class RiskStrategyTB extends BaseEntity implements Serializable,
		Cloneable, RiskStrategyInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="RISKSTRATEGY_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="RISKSTRATEGY_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKSTRATEGY_TABLE_GENERATOR")
	protected Integer rsid;

	/** 风险策略名称 */
	protected String rsname;

	/** 风险策略描述 */
	protected String rsdesc;

	/** 策略开始时间 */
	protected String rsstartdate;

	/** 策略结束时间 */
	protected String rsenddate;

	/** 状态(1.启用2.停用) */
	protected String rsstatus;

	/** 风险监测频率 */
	protected String rsfrequency;

	/** 风险检查频率内容 */
	protected String rsfrequencydesc;

	/** 风险策略指标关系表id */
	protected Integer sirid;

	/** 附件 */
	protected String rsattachkey;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getRsid() {
		return rsid;
	}

	/**
	 * 主键设定
	 *
	 * @param rsid 主键
	 */
	public void setRsid(Integer rsid) {
		this.rsid = rsid;
	}

	/**
	 * 风险策略名称取得
	 *
	 * @return 风险策略名称
	 */
	public String getRsname() {
		return rsname;
	}

	/**
	 * 风险策略名称设定
	 *
	 * @param rsname 风险策略名称
	 */
	public void setRsname(String rsname) {
		this.rsname = rsname;
	}

	/**
	 * 风险策略描述取得
	 *
	 * @return 风险策略描述
	 */
	public String getRsdesc() {
		return rsdesc;
	}

	/**
	 * 风险策略描述设定
	 *
	 * @param rsdesc 风险策略描述
	 */
	public void setRsdesc(String rsdesc) {
		this.rsdesc = rsdesc;
	}

	/**
	 * 策略开始时间取得
	 *
	 * @return 策略开始时间
	 */
	public String getRsstartdate() {
		return rsstartdate;
	}

	/**
	 * 策略开始时间设定
	 *
	 * @param rsstartdate 策略开始时间
	 */
	public void setRsstartdate(String rsstartdate) {
		this.rsstartdate = rsstartdate;
	}

	/**
	 * 策略结束时间取得
	 *
	 * @return 策略结束时间
	 */
	public String getRsenddate() {
		return rsenddate;
	}

	/**
	 * 策略结束时间设定
	 *
	 * @param rsenddate 策略结束时间
	 */
	public void setRsenddate(String rsenddate) {
		this.rsenddate = rsenddate;
	}

	/**
	 * 状态(1.启用2.停用)取得
	 *
	 * @return 状态(1.启用2.停用)
	 */
	public String getRsstatus() {
		return rsstatus;
	}

	/**
	 * 状态(1.启用2.停用)设定
	 *
	 * @param rsstatus 状态(1.启用2.停用)
	 */
	public void setRsstatus(String rsstatus) {
		this.rsstatus = rsstatus;
	}

	/**
	 * 风险监测频率取得
	 *
	 * @return 风险监测频率
	 */
	public String getRsfrequency() {
		return rsfrequency;
	}

	/**
	 * 风险监测频率设定
	 *
	 * @param rsfrequency 风险监测频率
	 */
	public void setRsfrequency(String rsfrequency) {
		this.rsfrequency = rsfrequency;
	}

	/**
	 * 风险检查频率内容取得
	 *
	 * @return 风险检查频率内容
	 */
	public String getRsfrequencydesc() {
		return rsfrequencydesc;
	}

	/**
	 * 风险检查频率内容设定
	 *
	 * @param rsfrequencydesc 风险检查频率内容
	 */
	public void setRsfrequencydesc(String rsfrequencydesc) {
		this.rsfrequencydesc = rsfrequencydesc;
	}

	/**
	 * 风险策略指标关系表id取得
	 *
	 * @return 风险策略指标关系表id
	 */
	public Integer getSirid() {
		return sirid;
	}

	/**
	 * 风险策略指标关系表id设定
	 *
	 * @param sirid 风险策略指标关系表id
	 */
	public void setSirid(Integer sirid) {
		this.sirid = sirid;
	}

	/**
	 * 附件取得
	 *
	 * @return 附件
	 */
	public String getRsattachkey() {
		return rsattachkey;
	}

	/**
	 * 附件设定
	 *
	 * @param rsattachkey 附件
	 */
	public void setRsattachkey(String rsattachkey) {
		this.rsattachkey = rsattachkey;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return rsid;
	}

}
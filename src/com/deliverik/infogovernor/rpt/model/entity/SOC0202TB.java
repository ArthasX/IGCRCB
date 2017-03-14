/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rpt.model.SOC0202Info;

/**
  * 概述: 附加报表实体
  * 功能描述: 附加报表实体
  * 创建记录: 2012/06/06
  * 修改记录: 2012/08/09 将ReportAnnexationTB表名改为SOC0202TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0202")
public class SOC0202TB extends BaseEntity implements Serializable,
		Cloneable, SOC0202Info {

	/** 附加ID */
	@Id
	@TableGenerator(
		name="REPORTANNEXATION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="REPORTANNEXATION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="REPORTANNEXATION_TABLE_GENERATOR")
	protected Integer raId;

	/** 附加报表名字 */
	protected String raName;

	/** 存储序列号 */
	protected String raSsn;

	/** kpi */
	protected String raKpi;

	/** 生成时间 */
	protected String raCreateDate;

	/**用户名字*/
	protected String raUserName;
	/**Word文档名称*/
	protected String raRealName;
	/**是否被使用*/
	@Transient
	protected String isUsed;
	/**
	 * 附加ID取得
	 *
	 * @return 附加ID
	 */
	public Integer getRaId() {
		return raId;
	}

	/**
	 * 附加ID设定
	 *
	 * @param raId 附加ID
	 */
	public void setRaId(Integer raId) {
		this.raId = raId;
	}

	
	/**
	 * 附加报表名字取得
	 *
	 * @return raName 附加报表名字
	 */
	public String getRaName() {
		return raName;
	}

	/**
	 * 附加报表名字设定
	 *
	 * @param raName 附加报表名字
	 */
	public void setRaName(String raName) {
		this.raName = raName;
	}

	/**
	 * 存储序列号取得
	 *
	 * @return raSsn 存储序列号
	 */
	public String getRaSsn() {
		return raSsn;
	}

	/**
	 * 存储序列号设定
	 *
	 * @param raSsn 存储序列号
	 */
	public void setRaSsn(String raSsn) {
		this.raSsn = raSsn;
	}

	/**
	 * kpi取得
	 *
	 * @return raKpi kpi
	 */
	public String getRaKpi() {
		return raKpi;
	}

	/**
	 * kpi设定
	 *
	 * @param raKpi kpi
	 */
	public void setRaKpi(String raKpi) {
		this.raKpi = raKpi;
	}


	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return raId;
	}

	/**
	 * 用户名字取得
	 *
	 * @return raUserName 用户名字
	 */
	public String getRaUserName() {
		return raUserName;
	}

	/**
	 * 用户名字设定
	 *
	 * @param raUserName 用户名字
	 */
	public void setRaUserName(String raUserName) {
		this.raUserName = raUserName;
	}

	/**
	 * Word文档名称取得
	 *
	 * @return raRealName Word文档名称
	 */
	public String getRaRealName() {
		return raRealName;
	}

	/**
	 * 生成时间取得
	 *
	 * @return raCreateDate 生成时间
	 */
	public String getRaCreateDate() {
		return raCreateDate;
	}

	/**
	 * 生成时间设定
	 *
	 * @param raCreateDate 生成时间
	 */
	public void setRaCreateDate(String raCreateDate) {
		this.raCreateDate = raCreateDate;
	}

	/**
	 * Word文档名称设定
	 *
	 * @param raRealName Word文档名称
	 */
	public void setRaRealName(String raRealName) {
		this.raRealName = raRealName;
	}

	/**
	 * 是否被使用取得
	 *
	 * @return isUsed 是否被使用
	 */
	public String getIsUsed() {
		return isUsed;
	}

	/**
	 * 是否被使用设定
	 *
	 * @param isUsed 是否被使用
	 */
	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}



}
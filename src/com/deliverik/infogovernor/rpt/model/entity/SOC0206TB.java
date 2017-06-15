/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rpt.model.SOC0206Info;

/**
  * 概述: 模板映射表实体
  * 功能描述: 模板映射表实体
  * 创建记录: 2012/06/06
  * 修改记录: 2012/08/09 将ReportTemplateMappingTB表名改为SOC0206TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0206")
public class SOC0206TB extends BaseEntity implements Serializable,
		Cloneable, SOC0206Info {

	/** 流水ID */
	@Id
	@TableGenerator(
		name="REPORTTEMPLATEMAPPING_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="REPORTTEMPLATEMAPPING_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="REPORTTEMPLATEMAPPING_TABLE_GENERATOR")
	protected Integer rtmId;

	/** 模板位置序号 */
	protected Integer rtNumber;

	/** 存储序列号 */
	protected String rtmSsn;
	
	/** 标识 */
	protected String rtmFlag;
	/** 是否启用 */
	protected String rtmUsed;
	/** 存储类型 */
	protected String rtmSsnType;
	/** KPI */
	protected String rtmKpi;
	
	/** Word文档对象图片位置 */
	protected Integer rtmImgNumber;
	/**模板id*/
	protected Integer rtId;
	/**对应模板*/
	@ManyToOne
	@JoinColumn(name="rtId", referencedColumnName="rtId",updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)

	protected SOC0207TB reportTemplateTB;
	/**
	 * 流水ID取得
	 *
	 * @return 流水ID
	 */
	public Integer getRtmId() {
		return rtmId;
	}

	/**
	 * 流水ID设定
	 *
	 * @param rtmId 流水ID
	 */
	public void setRtmId(Integer rtmId) {
		this.rtmId = rtmId;
	}

	/**
	 * 模板位置序号取得
	 *
	 * @return 模板位置序号
	 */
	public Integer getRtNumber() {
		return rtNumber;
	}

	/**
	 * 模板位置序号设定
	 *
	 * @param rtNumber 模板位置序号
	 */
	public void setRtNumber(Integer rtNumber) {
		this.rtNumber = rtNumber;
	}

	/**
	 * 存储序列号取得
	 *
	 * @return 存储序列号
	 */
	public String getRtmSsn() {
		return rtmSsn;
	}

	/**
	 * 存储序列号设定
	 *
	 * @param rtmSsn 存储序列号
	 */
	public void setRtmSsn(String rtmSsn) {
		this.rtmSsn = rtmSsn;
	}

	/**
	 * KPI取得
	 *
	 * @return KPI
	 */
	public String getRtmKpi() {
		return rtmKpi;
	}

	/**
	 * KPI设定
	 *
	 * @param rtmKpi KPI
	 */
	public void setRtmKpi(String rtmKpi) {
		this.rtmKpi = rtmKpi;
	}

	/**
	 * Word文档对象图片位置取得
	 *
	 * @return Word文档对象图片位置
	 */
	public Integer getRtmImgNumber() {
		return rtmImgNumber;
	}

	/**
	 * Word文档对象图片位置设定
	 *
	 * @param rtmImgNumber Word文档对象图片位置
	 */
	public void setRtmImgNumber(Integer rtmImgNumber) {
		this.rtmImgNumber = rtmImgNumber;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return rtmId;
	}

	/**
	 * 对应模板取得
	 *
	 * @return reportTemplateTB 对应模板
	 */
	public SOC0207TB getReportTemplateTB() {
		return reportTemplateTB;
	}

	/**
	 * 对应模板设定
	 *
	 * @param reportTemplateTB 对应模板
	 */
	public void setReportTemplateTB(SOC0207TB reportTemplateTB) {
		this.reportTemplateTB = reportTemplateTB;
	}

	/**
	 * 模板id取得
	 *
	 * @return rtId 模板id
	 */
	public Integer getRtId() {
		return rtId;
	}

	/**
	 * 模板id设定
	 *
	 * @param rtId 模板id
	 */
	public void setRtId(Integer rtId) {
		this.rtId = rtId;
	}

	/**
	 * 标识取得
	 *
	 * @return rtmFlag 标识
	 */
	public String getRtmFlag() {
		return rtmFlag;
	}

	/**
	 * 标识设定
	 *
	 * @param rtmFlag 标识
	 */
	public void setRtmFlag(String rtmFlag) {
		this.rtmFlag = rtmFlag;
	}

	/**
	 * 是否启用取得
	 *
	 * @return rtmUsed 是否启用
	 */
	public String getRtmUsed() {
		return rtmUsed;
	}

	/**
	 * 是否启用设定
	 *
	 * @param rtmUsed 是否启用
	 */
	public void setRtmUsed(String rtmUsed) {
		this.rtmUsed = rtmUsed;
	}

	/**
	 * 存储类型取得
	 *
	 * @return rtmSsnType 存储类型
	 */
	public String getRtmSsnType() {
		return rtmSsnType;
	}

	/**
	 * 存储类型设定
	 *
	 * @param rtmSsnType 存储类型
	 */
	public void setRtmSsnType(String rtmSsnType) {
		this.rtmSsnType = rtmSsnType;
	}
	
}
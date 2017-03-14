/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rpt.model.SOC0207Info;

/**
  * 概述: 报告模板实体
  * 功能描述: 报告模板实体
  * 创建记录: 2012/06/06
  * 修改记录: 2012/08/09 将ReportTemplateTB表名改为SOC0207TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0207")
public class SOC0207TB extends BaseEntity implements Serializable,
		Cloneable, SOC0207Info {

	/** ID */
	@Id
	@TableGenerator(
		name="REPORTTEMPLATE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="REPORTTEMPLATE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="REPORTTEMPLATE_TABLE_GENERATOR")
	protected Integer rtId;

	/** 模板名称 */
	protected String rtName;

	/** 可修改位置数 */
	protected Integer rtSum;

	/** 时间类型 */
	protected String rtDateType;

	/** 模板真实名字 */
	protected String rtRealName;

	/** 模板上传时间 */
	protected String rtUploadTime;

	/** 模板类型 */
	protected String rtType;
	/**
	 * 模板映射
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,targetEntity = SOC0206TB.class,mappedBy="reportTemplateTB")
	@NotFound(action = NotFoundAction.IGNORE)
	protected List<SOC0206TB> rtmList;

	/**
	 * ID取得
	 *
	 * @return ID
	 */
	public Integer getRtId() {
		return rtId;
	}

	/**
	 * ID设定
	 *
	 * @param rtId ID
	 */
	public void setRtId(Integer rtId) {
		this.rtId = rtId;
	}

	/**
	 * 模板名称取得
	 *
	 * @return 模板名称
	 */
	public String getRtName() {
		return rtName;
	}

	/**
	 * 模板名称设定
	 *
	 * @param rtName 模板名称
	 */
	public void setRtName(String rtName) {
		this.rtName = rtName;
	}

	/**
	 * 可修改位置数取得
	 *
	 * @return 可修改位置数
	 */
	public Integer getRtSum() {
		return rtSum;
	}

	/**
	 * 可修改位置数设定
	 *
	 * @param rtSum 可修改位置数
	 */
	public void setRtSum(Integer rtSum) {
		this.rtSum = rtSum;
	}

	/**
	 * 时间类型取得
	 *
	 * @return 时间类型
	 */
	public String getRtDateType() {
		return rtDateType;
	}

	/**
	 * 时间类型设定
	 *
	 * @param rtDateType 时间类型
	 */
	public void setRtDateType(String rtDateType) {
		this.rtDateType = rtDateType;
	}

	/**
	 * 模板真实名字取得
	 *
	 * @return 模板真实名字
	 */
	public String getRtRealName() {
		return rtRealName;
	}

	/**
	 * 模板真实名字设定
	 *
	 * @param rtRealName 模板真实名字
	 */
	public void setRtRealName(String rtRealName) {
		this.rtRealName = rtRealName;
	}

	/**
	 * 模板上传时间取得
	 *
	 * @return 模板上传时间
	 */
	public String getRtUploadTime() {
		return rtUploadTime;
	}

	/**
	 * 模板上传时间设定
	 *
	 * @param rtUploadTime 模板上传时间
	 */
	public void setRtUploadTime(String rtUploadTime) {
		this.rtUploadTime = rtUploadTime;
	}

	/**
	 * 模板类型取得
	 *
	 * @return 模板类型
	 */
	public String getRtType() {
		return rtType;
	}

	/**
	 * 模板类型设定
	 *
	 * @param rtType 模板类型
	 */
	public void setRtType(String rtType) {
		this.rtType = rtType;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return rtId;
	}

	/**
	 * 模板映射取得
	 *
	 * @return rtmList 模板映射
	 */
	public List<SOC0206TB> getRtmList() {
		return rtmList;
	}

	/**
	 * 模板映射设定
	 *
	 * @param rtmList 模板映射
	 */
	public void setRtmList(List<SOC0206TB> rtmList) {
		this.rtmList = rtmList;
	}

}
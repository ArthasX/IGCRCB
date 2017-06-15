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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rpt.model.SOC0205Info;
import com.deliverik.infogovernor.rpt.model.entity.SOC0207TB;

/**
  * 概述: 报告管理表实体
  * 功能描述: 报告管理表实体
  * 创建记录: 2012/06/06
  * 修改记录: 2012/08/09 将ReportManageTB表名改为SOC0205TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0205")
public class SOC0205TB extends BaseEntity implements Serializable,
		Cloneable, SOC0205Info {

	/** 报告ID */
	@Id
	@TableGenerator(
		name="REPORTMANAGE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="REPORTMANAGE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="REPORTMANAGE_TABLE_GENERATOR")
	protected Integer rmId;

	/** 报告名称 */
	protected String rmName;

	/** 年 */
	protected String rmYear;

	/** 季度 */
	protected String rmQuarter;

	/** 月 */
	protected String rmMonth;
	/** 类型 */
	protected String rmDateType;
	/** 最后一天 */
	protected String rmLastDay;
	/**模板名字*/
	protected String rtName;
	/**后缀名字*/
	protected String rmSuffix;

	/** 创建时间 */
	protected String createDate;
	/**最后添加附加报表时间*/
	protected String lastAnnexationDate;
	/**存放附加报表ID,以逗号为分隔符*/
	protected String raStr;
	/**模板对象*/
	@OneToOne
	@JoinColumn(name="rtId", referencedColumnName = "rtId", updatable = true, insertable = true)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0207TB reportTemplateTB;
	
	/**
	 * 报告ID取得
	 *
	 * @return 报告ID
	 */
	public Integer getRmId() {
		return rmId;
	}

	/**
	 * 报告ID设定
	 *
	 * @param rmId 报告ID
	 */
	public void setRmId(Integer rmId) {
		this.rmId = rmId;
	}

	/**
	 * 报告名称取得
	 *
	 * @return 报告名称
	 */
	public String getRmName() {
		return rmName;
	}

	/**
	 * 报告名称设定
	 *
	 * @param rmName 报告名称
	 */
	public void setRmName(String rmName) {
		this.rmName = rmName;
	}


	/**
	 * 年取得
	 *
	 * @return 年
	 */
	public String getRmYear() {
		return rmYear;
	}

	/**
	 * 年设定
	 *
	 * @param rmYear 年
	 */
	public void setRmYear(String rmYear) {
		this.rmYear = rmYear;
	}

	/**
	 * 季度取得
	 *
	 * @return 季度
	 */
	public String getRmQuarter() {
		return rmQuarter;
	}

	/**
	 * 季度设定
	 *
	 * @param rmQuarter 季度
	 */
	public void setRmQuarter(String rmQuarter) {
		this.rmQuarter = rmQuarter;
	}

	/**
	 * 月取得
	 *
	 * @return 月
	 */
	public String getRmMonth() {
		return rmMonth;
	}

	/**
	 * 月设定
	 *
	 * @param rmMonth 月
	 */
	public void setRmMonth(String rmMonth) {
		this.rmMonth = rmMonth;
	}

	/**
	 * 创建时间取得
	 *
	 * @return 创建时间
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * 创建时间设定
	 *
	 * @param createDate 创建时间
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return rmId;
	}

	/**
	 * 模板对象取得
	 *
	 * @return reportTemplateTB 模板对象
	 */
	public SOC0207TB getReportTemplateTB() {
		return reportTemplateTB;
	}

	/**
	 * 模板对象设定
	 *
	 * @param reportTemplateTB 模板对象
	 */
	public void setReportTemplateTB(SOC0207TB reportTemplateTB) {
		this.reportTemplateTB = reportTemplateTB;
	}

	/**
	 * 最后添加附加报表时间取得
	 *
	 * @return lastAnnexationDate 最后添加附加报表时间
	 */
	public String getLastAnnexationDate() {
		return lastAnnexationDate;
	}

	/**
	 * 最后添加附加报表时间设定
	 *
	 * @param lastAnnexationDate 最后添加附加报表时间
	 */
	public void setLastAnnexationDate(String lastAnnexationDate) {
		this.lastAnnexationDate = lastAnnexationDate;
	}

	/**
	 * 类型取得
	 *
	 * @return rmDateType 类型
	 */
	public String getRmDateType() {
		return rmDateType;
	}

	/**
	 * 类型设定
	 *
	 * @param rmDateType 类型
	 */
	public void setRmDateType(String rmDateType) {
		this.rmDateType = rmDateType;
	}

	/**
	 * 最后一天取得
	 *
	 * @return rmLastDay 最后一天
	 */
	public String getRmLastDay() {
		return rmLastDay;
	}

	/**
	 * 最后一天设定
	 *
	 * @param rmLastDay 最后一天
	 */
	public void setRmLastDay(String rmLastDay) {
		this.rmLastDay = rmLastDay;
	}

	/**
	 * 模板名字取得
	 *
	 * @return rtName 模板名字
	 */
	public String getRtName() {
		return rtName;
	}

	/**
	 * 模板名字设定
	 *
	 * @param rtName 模板名字
	 */
	public void setRtName(String rtName) {
		this.rtName = rtName;
	}

	/**
	 * 存放附加报表ID以逗号为分隔符取得
	 *
	 * @return raStr 存放附加报表ID以逗号为分隔符
	 */
	public String getRaStr() {
		return raStr;
	}

	/**
	 * 存放附加报表ID以逗号为分隔符设定
	 *
	 * @param raStr 存放附加报表ID以逗号为分隔符
	 */
	public void setRaStr(String raStr) {
		this.raStr = raStr;
	}

	/**
	 * 后缀名字取得
	 *
	 * @return rmSuffix 后缀名字
	 */
	public String getRmSuffix() {
		return rmSuffix;
	}

	/**
	 * 后缀名字设定
	 *
	 * @param rmSuffix 后缀名字
	 */
	public void setRmSuffix(String rmSuffix) {
		this.rmSuffix = rmSuffix;
	}
	
	

}
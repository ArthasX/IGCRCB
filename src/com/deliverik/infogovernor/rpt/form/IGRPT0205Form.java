/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.rpt.model.SOC0205Info;
import com.deliverik.infogovernor.rpt.model.entity.SOC0207TB;

/**
 * 概述: 报告添加修改Form
 * 功能描述: 
 * 创建记录: 2012/06/13
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGRPT0205Form extends BaseForm implements SOC0205Info{
	
	/**页面select*/
	protected String selRmYear;
	protected String selRmQuarter;
	protected String selRmMonth;
	protected String selTemplate;
	
	/**记录日期类型*/
	protected String dateType;
	/**新增0 修改1*/
	protected String mode;

	
	/**id*/
	protected Integer rmId;

	/** 报告名称 */
	protected String rmName;

	/** 年 */
	protected String rmYear;

	/** 季度 */
	protected String rmQuarter;
	/**模板名字取得*/
	protected String rtName;
	
	/** 月 */
	protected String rmMonth;

	/** 创建时间 */
	protected String createDate;
	/**模板对象*/
	protected String rtId;
	
	/** 类型 */
	protected String rmDateType;
	/** 最后一天 */
	protected String rmLastDay;
	
	/** 附件IDS */
	protected String[] anIds;
	
	/**确认删除吗*/
	protected String isDel;
	/**
	 * rmId取得
	 *
	 * @return rmId rmId
	 */
	public Integer getRmId() {
		return rmId;
	}
	/**
	 * rmId设定
	 *
	 * @param rmId rmId
	 */
	public void setRmId(Integer rmId) {
		this.rmId = rmId;
	}
	/**
	 * 报告名称取得
	 *
	 * @return rmName 报告名称
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
	 * @return rmYear 年
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
	 * @return rmQuarter 季度
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
	 * @return rmMonth 月
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
	 * @return createDate 创建时间
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
	 * 模板对象取得
	 *
	 * @return rtId 模板对象
	 */
	public String getRtId() {
		return rtId;
	}
	/**
	 * 模板对象设定
	 *
	 * @param rtId 模板对象
	 */
	public void setRtId(String rtId) {
		this.rtId = rtId;
	}
	/**
	 * 新增0修改1取得
	 *
	 * @return mode 新增0修改1
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * 新增0修改1设定
	 *
	 * @param mode 新增0修改1
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * 记录日期类型取得
	 *
	 * @return dateType 记录日期类型
	 */
	public String getDateType() {
		return dateType;
	}
	/**
	 * 记录日期类型设定
	 *
	 * @param dateType 记录日期类型
	 */
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	/**
	 * 页面select取得
	 *
	 * @return selRmYear 页面select
	 */
	public String getSelRmYear() {
		return selRmYear;
	}
	/**
	 * selRmQuarter取得
	 *
	 * @return selRmQuarter selRmQuarter
	 */
	public String getSelRmQuarter() {
		return selRmQuarter;
	}
	/**
	 * selRmMonth取得
	 *
	 * @return selRmMonth selRmMonth
	 */
	public String getSelRmMonth() {
		return selRmMonth;
	}
	/**
	 * selTemplate取得
	 *
	 * @return selTemplate selTemplate
	 */
	public String getSelTemplate() {
		return selTemplate;
	}
	/**
	 * 页面select设定
	 *
	 * @param selRmYear 页面select
	 */
	public void setSelRmYear(String selRmYear) {
		this.selRmYear = selRmYear;
	}
	/**
	 * selRmQuarter设定
	 *
	 * @param selRmQuarter selRmQuarter
	 */
	public void setSelRmQuarter(String selRmQuarter) {
		this.selRmQuarter = selRmQuarter;
	}
	/**
	 * selRmMonth设定
	 *
	 * @param selRmMonth selRmMonth
	 */
	public void setSelRmMonth(String selRmMonth) {
		this.selRmMonth = selRmMonth;
	}
	/**
	 * selTemplate设定
	 *
	 * @param selTemplate selTemplate
	 */
	public void setSelTemplate(String selTemplate) {
		this.selTemplate = selTemplate;
	}
	//
	public String getLastAnnexationDate() {
		//
		return null;
	}
	//
	public SOC0207TB getReportTemplateTB() {
		//
		return null;
	}
	//
	public String getFingerPrint() {
		//
		return null;
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
	 * 模板名字取得取得
	 *
	 * @return rtName 模板名字取得
	 */
	public String getRtName() {
		return rtName;
	}
	/**
	 * 模板名字取得设定
	 *
	 * @param rtName 模板名字取得
	 */
	public void setRtName(String rtName) {
		this.rtName = rtName;
	}
	/**
	 * 附件IDS取得
	 *
	 * @return anIds 附件IDS
	 */
	public String[] getAnIds() {
		return anIds;
	}
	/**
	 * 附件IDS设定
	 *
	 * @param anIds 附件IDS
	 */
	public void setAnIds(String[] anIds) {
		this.anIds = anIds;
	}
	/**
	 * 确认删除吗取得
	 *
	 * @return isDel 确认删除吗
	 */
	public String getIsDel() {
		return isDel;
	}
	/**
	 * 确认删除吗设定
	 *
	 * @param isDel 确认删除吗
	 */
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.rpt.model.ReportManageInfo#getRaStr()
	 */
	public String getRaStr() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.rpt.model.ReportManageInfo#getRmSuffix()
	 */
	public String getRmSuffix() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
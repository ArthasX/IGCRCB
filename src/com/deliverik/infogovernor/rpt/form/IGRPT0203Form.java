/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 自动报告模板CRUD Form
 * 功能描述: 自动报告模板CRUD Form
 * 创建记录: 2012/06/07
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGRPT0203Form extends BaseForm {
  	
	/** mapid*/
	protected String[] mapid;
	/** ssn_list */
	protected String[] ssn_select_list1;
	/** dmx_list */
	protected String[] dmx_select_list1;
	/** ibm_list */
	protected String[] ibm_select_list1;
	/** cx_list */
	protected String[] cx_select_list1;
	/** real_kpi_list*/
	protected String[] real_kpi_list;
	
	/** ssn_type_list*/
	protected String[] ssn_type_list;
	
	/**默认KPI*/
	protected String syscoding;
	/** real_ssn_list_ssn*/
	protected String[] real_ssn_list_ssn;
	/** real_ssn_list_type*/
	protected String[] real_ssn_list_type;
	
	/** 模板主键 */
	protected Integer rtId;

	/** 模板名称 */
	protected String rtName;

	/** 时间类型 */
	protected String rtDateType;

	/** 模板真实名字 */
	protected String rtRealName;

	/** 模板上传时间 */
	protected String rtUploadTime;

	/** 模板类型 */
	protected String rtType;
	
	
	protected Integer rtmId;
	
	/** 模板位置序号 */
	protected Integer rtNumber;

	/** 存储序列号 */
	protected String rtmSsn;

	/** KPI */
	protected String rtmKpi;
	
	/** Word文档对象图片位置 */
	protected Integer rtmImgNumber;
	
	protected String mode;
	/**
	 * 模板主键取得
	 *
	 * @return rtId 模板主键
	 */
	public Integer getRtId() {
		return rtId;
	}
	/**
	 * 模板名称取得
	 *
	 * @return rtName 模板名称
	 */
	public String getRtName() {
		return rtName;
	}
	/**
	 * 时间类型取得
	 *
	 * @return rtDateType 时间类型
	 */
	public String getRtDateType() {
		return rtDateType;
	}
	/**
	 * 模板真实名字取得
	 *
	 * @return rtRealName 模板真实名字
	 */
	public String getRtRealName() {
		return rtRealName;
	}
	/**
	 * 模板上传时间取得
	 *
	 * @return rtUploadTime 模板上传时间
	 */
	public String getRtUploadTime() {
		return rtUploadTime;
	}
	/**
	 * 模板类型取得
	 *
	 * @return rtType 模板类型
	 */
	public String getRtType() {
		return rtType;
	}
	/**
	 * 模板主键设定
	 *
	 * @param rtId 模板主键
	 */
	public void setRtId(Integer rtId) {
		this.rtId = rtId;
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
	 * 时间类型设定
	 *
	 * @param rtDateType 时间类型
	 */
	public void setRtDateType(String rtDateType) {
		this.rtDateType = rtDateType;
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
	 * 模板上传时间设定
	 *
	 * @param rtUploadTime 模板上传时间
	 */
	public void setRtUploadTime(String rtUploadTime) {
		this.rtUploadTime = rtUploadTime;
	}
	/**
	 * 模板类型设定
	 *
	 * @param rtType 模板类型
	 */
	public void setRtType(String rtType) {
		this.rtType = rtType;
	}
	//
	public String getFingerPrint() {
		//
		return null;
	}

	/**
	 * rtmId取得
	 *
	 * @return rtmId rtmId
	 */
	public Integer getRtmId() {
		return rtmId;
	}
	/**
	 * 模板位置序号取得
	 *
	 * @return rtNumber 模板位置序号
	 */
	public Integer getRtNumber() {
		return rtNumber;
	}
	/**
	 * 存储序列号取得
	 *
	 * @return rtmSsn 存储序列号
	 */
	public String getRtmSsn() {
		return rtmSsn;
	}
	/**
	 * KPI取得
	 *
	 * @return rtmKpi KPI
	 */
	public String getRtmKpi() {
		return rtmKpi;
	}
	/**
	 * Word文档对象图片位置取得
	 *
	 * @return rtmImgNumber Word文档对象图片位置
	 */
	public Integer getRtmImgNumber() {
		return rtmImgNumber;
	}
	/**
	 * rtmId设定
	 *
	 * @param rtmId rtmId
	 */
	public void setRtmId(Integer rtmId) {
		this.rtmId = rtmId;
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
	 * 存储序列号设定
	 *
	 * @param rtmSsn 存储序列号
	 */
	public void setRtmSsn(String rtmSsn) {
		this.rtmSsn = rtmSsn;
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
	 * Word文档对象图片位置设定
	 *
	 * @param rtmImgNumber Word文档对象图片位置
	 */
	public void setRtmImgNumber(Integer rtmImgNumber) {
		this.rtmImgNumber = rtmImgNumber;
	}

	/**
	 * ssn_list取得
	 *
	 * @return ssn_select_list1 ssn_list
	 */
	public String[] getSsn_select_list1() {
		return ssn_select_list1;
	}
	/**
	 * dmx_list取得
	 *
	 * @return dmx_select_list1 dmx_list
	 */
	public String[] getDmx_select_list1() {
		return dmx_select_list1;
	}
	/**
	 * ibm_list取得
	 *
	 * @return ibm_select_list1 ibm_list
	 */
	public String[] getIbm_select_list1() {
		return ibm_select_list1;
	}
	/**
	 * cx_list取得
	 *
	 * @return cx_select_list1 cx_list
	 */
	public String[] getCx_select_list1() {
		return cx_select_list1;
	}
	/**
	 * ssn_list设定
	 *
	 * @param ssn_select_list1 ssn_list
	 */
	public void setSsn_select_list1(String[] ssn_select_list1) {
		this.ssn_select_list1 = ssn_select_list1;
	}
	/**
	 * dmx_list设定
	 *
	 * @param dmx_select_list1 dmx_list
	 */
	public void setDmx_select_list1(String[] dmx_select_list1) {
		this.dmx_select_list1 = dmx_select_list1;
	}
	/**
	 * ibm_list设定
	 *
	 * @param ibm_select_list1 ibm_list
	 */
	public void setIbm_select_list1(String[] ibm_select_list1) {
		this.ibm_select_list1 = ibm_select_list1;
	}
	/**
	 * cx_list设定
	 *
	 * @param cx_select_list1 cx_list
	 */
	public void setCx_select_list1(String[] cx_select_list1) {
		this.cx_select_list1 = cx_select_list1;
	}
	/**
	 * real_kpi_list取得
	 *
	 * @return real_kpi_list real_kpi_list
	 */
	public String[] getReal_kpi_list() {
		return real_kpi_list;
	}
	/**
	 * real_kpi_list设定
	 *
	 * @param real_kpi_list real_kpi_list
	 */
	public void setReal_kpi_list(String[] real_kpi_list) {
		this.real_kpi_list = real_kpi_list;
	}
	/**
	 * real_ssn_list_ssn取得
	 *
	 * @return real_ssn_list_ssn real_ssn_list_ssn
	 */
	public String[] getReal_ssn_list_ssn() {
		return real_ssn_list_ssn;
	}
	/**
	 * real_ssn_list_type取得
	 *
	 * @return real_ssn_list_type real_ssn_list_type
	 */
	public String[] getReal_ssn_list_type() {
		return real_ssn_list_type;
	}
	/**
	 * real_ssn_list_ssn设定
	 *
	 * @param real_ssn_list_ssn real_ssn_list_ssn
	 */
	public void setReal_ssn_list_ssn(String[] real_ssn_list_ssn) {
		this.real_ssn_list_ssn = real_ssn_list_ssn;
	}
	/**
	 * real_ssn_list_type设定
	 *
	 * @param real_ssn_list_type real_ssn_list_type
	 */
	public void setReal_ssn_list_type(String[] real_ssn_list_type) {
		this.real_ssn_list_type = real_ssn_list_type;
	}
	/**
	 * 默认KPI取得
	 *
	 * @return syscoding 默认KPI
	 */
	public String getSyscoding() {
		return syscoding;
	}
	/**
	 * 默认KPI设定
	 *
	 * @param syscoding 默认KPI
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}
	/**
	 * ssn_type_list取得
	 *
	 * @return ssn_type_list ssn_type_list
	 */
	public String[] getSsn_type_list() {
		return ssn_type_list;
	}
	/**
	 * ssn_type_list设定
	 *
	 * @param ssn_type_list ssn_type_list
	 */
	public void setSsn_type_list(String[] ssn_type_list) {
		this.ssn_type_list = ssn_type_list;
	}
	/**
	 * mapid取得
	 *
	 * @return mapid mapid
	 */
	public String[] getMapid() {
		return mapid;
	}
	/**
	 * mapid设定
	 *
	 * @param mapid mapid
	 */
	public void setMapid(String[] mapid) {
		this.mapid = mapid;
	}
	/**
	 * mode取得
	 *
	 * @return mode mode
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * mode设定
	 *
	 * @param mode mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	
}

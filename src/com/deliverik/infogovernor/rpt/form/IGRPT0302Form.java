/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 报表查询参数Form
 * 功能描述: 
 * 创建记录:杨龙全 2012/07/03
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGRPT0302Form extends BaseForm{
	/**时间类型*/
	protected String dateTypeSel;
	/**年*/
	protected String yearSel;
	/**季*/
	protected String quarterSel;
	/**月*/
	protected String monthSel;
	/**存储类型*/
	protected String mode;
	/**对象类型*/
	protected String objType;
	/**存储名称*/
	protected String storageName;
	/**业务系统名称*/
	protected String businessName;
	/**主机名称*/
	protected String hostName;
	/**数据库名称*/
	protected String dbName;
	/**VG名称*/
	protected String vgName;
	/**FS名称*/
	protected String fsName;
	/**TS名称*/
	protected String tsName;
	/**卷组名称数组*/
	protected String[] vgNameArr;
	/**文件系统名称*/
	protected String[] fsNameArr;
	/**表空间名称*/
	protected String[] tsNameArr;
	/**资产id*/
	protected String eiid;
	/**对象名字*/
	protected String objName;
	//-----------
	/**模板路径*/
	protected String reportPath;
	/**时间类型*/
	protected String timeType;
	/**时间*/
	protected String dateTime;
	/**模板名字*/
	protected String templateName;
	/**自定义类型*/
	protected String rclCaType;
	
	/**
	 * 时间类型取得
	 *
	 * @return dateTypeSel 时间类型
	 */
	public String getDateTypeSel() {
		return dateTypeSel;
	}
	/**
	 * 时间类型设定
	 *
	 * @param dateTypeSel 时间类型
	 */
	public void setDateTypeSel(String dateTypeSel) {
		this.dateTypeSel = dateTypeSel;
	}
	/**
	 * 年取得
	 *
	 * @return yearSel 年
	 */
	public String getYearSel() {
		return yearSel;
	}
	/**
	 * 年设定
	 *
	 * @param yearSel 年
	 */
	public void setYearSel(String yearSel) {
		this.yearSel = yearSel;
	}
	/**
	 * 季取得
	 *
	 * @return quarterSel 季
	 */
	public String getQuarterSel() {
		return quarterSel;
	}
	/**
	 * 季设定
	 *
	 * @param quarterSel 季
	 */
	public void setQuarterSel(String quarterSel) {
		this.quarterSel = quarterSel;
	}
	/**
	 * 月取得
	 *
	 * @return monthSel 月
	 */
	public String getMonthSel() {
		return monthSel;
	}
	/**
	 * 月设定
	 *
	 * @param monthSel 月
	 */
	public void setMonthSel(String monthSel) {
		this.monthSel = monthSel;
	}
	/**
	 * 存储类型取得
	 *
	 * @return mode 存储类型
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * 存储类型设定
	 *
	 * @param mode 存储类型
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * 对象类型取得
	 *
	 * @return objType 对象类型
	 */
	public String getObjType() {
		return objType;
	}
	/**
	 * 对象类型设定
	 *
	 * @param objType 对象类型
	 */
	public void setObjType(String objType) {
		this.objType = objType;
	}
	/**
	 * 存储名称取得
	 *
	 * @return storageName 存储名称
	 */
	public String getStorageName() {
		return storageName;
	}
	/**
	 * 存储名称设定
	 *
	 * @param storageName 存储名称
	 */
	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}
	/**
	 * 业务系统名称取得
	 *
	 * @return businessName 业务系统名称
	 */
	public String getBusinessName() {
		return businessName;
	}
	/**
	 * 业务系统名称设定
	 *
	 * @param businessName 业务系统名称
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	/**
	 * 主机名称取得
	 *
	 * @return hostName 主机名称
	 */
	public String getHostName() {
		return hostName;
	}
	/**
	 * 主机名称设定
	 *
	 * @param hostName 主机名称
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	/**
	 * 卷组名称取得
	 *
	 * @return vgNameArr 卷组名称
	 */
	public String[] getVgNameArr() {
		return vgNameArr;
	}
	/**
	 * 卷组名称设定
	 *
	 * @param vgNameArr 卷组名称
	 */
	public void setVgNameArr(String[] vgNameArr) {
		this.vgNameArr = vgNameArr;
	}
	/**
	 * 文件系统名称取得
	 *
	 * @return fsNameArr 文件系统名称
	 */
	public String[] getFsNameArr() {
		return fsNameArr;
	}
	/**
	 * 文件系统名称设定
	 *
	 * @param fsNameArr 文件系统名称
	 */
	public void setFsNameArr(String[] fsNameArr) {
		this.fsNameArr = fsNameArr;
	}
	/**
	 * 表空间名称取得
	 *
	 * @return tsNameArr 表空间名称
	 */
	public String[] getTsNameArr() {
		return tsNameArr;
	}
	/**
	 * 表空间名称设定
	 *
	 * @param tsNameArr 表空间名称
	 */
	public void setTsNameArr(String[] tsNameArr) {
		this.tsNameArr = tsNameArr;
	}
	/**
	 * 数据库名称取得
	 *
	 * @return dbName 数据库名称
	 */
	public String getDbName() {
		return dbName;
	}
	/**
	 * 数据库名称设定
	 *
	 * @param dbName 数据库名称
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	/**
	 * 资产id取得
	 *
	 * @return eiid 资产id
	 */
	public String getEiid() {
		return eiid;
	}
	/**
	 * 资产id设定
	 *
	 * @param eiid 资产id
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}
	/**
	 * 对象名字取得
	 *
	 * @return objName 对象名字
	 */
	public String getObjName() {
		return objName;
	}
	/**
	 * 对象名字设定
	 *
	 * @param objName 对象名字
	 */
	public void setObjName(String objName) {
		this.objName = objName;
	}
	/**
	 * --------取得
	 *
	 * @return reportPath --------
	 */
	public String getReportPath() {
		return reportPath;
	}
	/**
	 * --------设定
	 *
	 * @param reportPath --------
	 */
	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}
	/**
	 * 时间类型取得
	 *
	 * @return timeType 时间类型
	 */
	public String getTimeType() {
		return timeType;
	}
	/**
	 * 时间类型设定
	 *
	 * @param timeType 时间类型
	 */
	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}
	/**
	 * 时间取得
	 *
	 * @return dateTime 时间
	 */
	public String getDateTime() {
		return dateTime;
	}
	/**
	 * 时间设定
	 *
	 * @param dateTime 时间
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	/**
	 * VG名称取得
	 *
	 * @return vgName VG名称
	 */
	public String getVgName() {
		return vgName;
	}
	/**
	 * VG名称设定
	 *
	 * @param vgName VG名称
	 */
	public void setVgName(String vgName) {
		this.vgName = vgName;
	}
	/**
	 * FS名称取得
	 *
	 * @return fsName FS名称
	 */
	public String getFsName() {
		return fsName;
	}
	/**
	 * FS名称设定
	 *
	 * @param fsName FS名称
	 */
	public void setFsName(String fsName) {
		this.fsName = fsName;
	}
	/**
	 * TS名称取得
	 *
	 * @return tsName TS名称
	 */
	public String getTsName() {
		return tsName;
	}
	/**
	 * TS名称设定
	 *
	 * @param tsName TS名称
	 */
	public void setTsName(String tsName) {
		this.tsName = tsName;
	}
	/**
	 * 模板名字取得
	 *
	 * @return templateName 模板名字
	 */
	public String getTemplateName() {
		return templateName;
	}
	/**
	 * 模板名字设定
	 *
	 * @param templateName 模板名字
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	/**
	 * 自定义类型取得
	 *
	 * @return rclCaType 自定义类型
	 */
	public String getRclCaType() {
		return rclCaType;
	}
	/**
	 * 自定义类型设定
	 *
	 * @param rclCaType 自定义类型
	 */
	public void setRclCaType(String rclCaType) {
		this.rclCaType = rclCaType;
	}
	
	
}

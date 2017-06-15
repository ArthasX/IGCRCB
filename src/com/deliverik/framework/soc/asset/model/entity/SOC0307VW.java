package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.soc.asset.model.SOC0307Info;

/**
 * 告警信息视图实体STORAGEEVENTVW
 * @author Administrator
 *
 */
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "SOC0307")
@SuppressWarnings("serial")
public class SOC0307VW implements Serializable, Cloneable, SOC0307Info{
	
	/** id */
	@Id
	protected Integer id;
	
	/** 日志记录时间 */
	protected String detectiontime;
	
	/** dir */
	protected String dir;
	
	/** src */
	protected String src;
	
	/** 种类 */
	protected String category;
	
	/** 级别 */
	protected String severity;
	
	/** 错误号 */
	protected String errornum;
	
	/** 信息描述 */
	protected String errordesc;
	
	/**eirootmark	 */
	protected String eirootmark;
	
	/**状态	 */
	protected String state;
	
	/**一级种类	 */
	protected String sort;
	
	/**查询类型*/
	protected String imptypeid;
	
	/**名称*/
	protected String lparnam;
	
	/**IP*/
	protected String ip;
	
	/** reportingmtms */
	protected String reportingMTMS;
	
	/** fru1Loc */
	protected String fru1Loc;
	
	/** fru2Loc */
	protected String fru2Loc;
	
	/** fru3Loc */
	protected String fru3Loc;
	
	/** failingenclosuremtms */
	protected String failingEnclosureMTMS;
	
	/**报警类型*/
	protected String alarmType ;
	
	/** 对象类型*/
	protected String imptypename;
	
	/** 对象实体id*/
	protected Integer eiid;
	
	/** 处理状态*/
	protected String status;
	
	/**
	 * 报警类型取得
	 * @return
	 */
	public String getAlarmType() {
		return alarmType;
	}

	/**
	 * 报警类型设定
	 * @param alarmType
	 */
	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}


	public String getReportingMTMS()
	{
		return reportingMTMS;
	}


	public void setReportingMTMS(String reportingmtms)
	{
		this.reportingMTMS = reportingmtms;
	}


	public String getFru1Loc()
	{
		return fru1Loc;
	}


	public void setFru1Loc(String fru1Loc)
	{
		this.fru1Loc = fru1Loc;
	}


	public String getFru2Loc()
	{
		return fru2Loc;
	}


	public void setFru2Loc(String fru2Loc)
	{
		this.fru2Loc = fru2Loc;
	}


	public String getFru3Loc()
	{
		return fru3Loc;
	}


	public void setFru3Loc(String fru3Loc)
	{
		this.fru3Loc = fru3Loc;
	}


	public String getFailingEnclosureMTMS()
	{
		return failingEnclosureMTMS;
	}


	public void setFailingEnclosureMTMS(String failingenclosuremtms)
	{
		this.failingEnclosureMTMS = failingenclosuremtms;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLparnam() {
		return lparnam;
	}


	public void setLparnam(String lparnam) {
		this.lparnam = lparnam;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getImptypeid() {
		return imptypeid;
	}


	public void setImptypeid(String imptypeid) {
		this.imptypeid = imptypeid;
	}


	/**
	 * 日志记录时间取得
	 *
	 * @return 日志记录时间
	 */
	public String getDetectiontime() {
		return detectiontime;
	}
	

	/**
	 * 日志记录时间设定
	 *
	 * @param detectiontime日志记录时间
	 */
	public void setDetectiontime(String detectiontime) {
		this.detectiontime = detectiontime;
	}

	/**
	 * dir取得
	 *
	 * @return dir
	 */
	public String getDir() {
		return dir;
	}

	/**
	 * dir设定
	 *
	 * @param dirdir
	 */
	public void setDir(String dir) {
		this.dir = dir;
	}

	/**
	 * src取得
	 *
	 * @return src
	 */
	public String getSrc() {
		return src;
	}

	/**
	 * src设定
	 *
	 * @param srcsrc
	 */
	public void setSrc(String src) {
		this.src = src;
	}

	/**
	 * 种类取得
	 *
	 * @return 种类
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * 种类设定
	 *
	 * @param category种类
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * 级别取得
	 *
	 * @return 级别
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * 级别设定
	 *
	 * @param severity级别
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * 错误号取得
	 *
	 * @return 错误号
	 */
	public String getErrornum() {
		return errornum;
	}

	/**
	 * 错误号设定
	 *
	 * @param errornum错误号
	 */
	public void setErrornum(String errornum) {
		this.errornum = errornum;
	}

	/**
	 * 信息描述取得
	 *
	 * @return 信息描述
	 */
	public String getErrordesc() {
		return errordesc;
	}

	/**
	 * 信息描述设定
	 *
	 * @param errordesc信息描述
	 */
	public void setErrordesc(String errordesc) {
		this.errordesc = errordesc;
	}

	/**
	 * eirootmark取得
	 * @return eirootmark
	 */
	public String getEirootmark() {
		return eirootmark;
	}

	/**
	 * eirootmark设置
	 * @param eirootmark
	 */
	public void setEirootmark(String eirootmark) {
		this.eirootmark = eirootmark;
	}

	/**
	 * 状态取得
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * 状态设置
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 一级种类取得
	 * @return sort
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * 一级种类设置
	 * @param sort
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	public String getImptypename() {
		return imptypename;
	}
	public void setImptypename(String imptypename) {
		this.imptypename = imptypename;
	}
	public Integer getEiid() {
		return eiid;
	}
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

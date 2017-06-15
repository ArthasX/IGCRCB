/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.model.condition;

import com.deliverik.infogovernor.crc.form.IGCRC0203Form;

/**
  * 概述: 集成告警表检索条件实现
  * 功能描述: 集成告警表检索条件实现
  * 创建记录: 2014/06/21
  * 修改记录: 
  */
public class IgalarmSearchCondImpl implements
		IgalarmSearchCond {
	
	public IgalarmSearchCondImpl(){
		super();
	}
	
	public IgalarmSearchCondImpl(IGCRC0203Form form){
		startDate = form.getStartDate() == null ? null : form.getStartDate();
		endDate = form.getEndDate() == null ? null : form.getEndDate();
		appname = form.getAppname() == null ? null : form.getAppname();
		summary = form.getSummary() == null ? null : form.getSummary();
		status = form.getStatus() == null ? null : form.getStatus();
		lasttime = form.getLasttime()==null?null : form.getLasttime();
		isShow = form.getIsShow()==null?null : form.getIsShow();
		pedeventid = form.getPedeventid()==null?null : form.getPedeventid();
	}

	private String serial;//比对集成告警表序号
	
	/**IPd地址*/
	private String ipaddr;
	
	/** 
	 * 是否处于应急演练屏蔽状态的标识	2016.09.02 by wangxing
	 *  0:正常状态
	 *  1:屏蔽状态
	 **/
	protected String shieldflag;
	
	public String getIpaddr() {
		return ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	public String getShieldflag() {
		return shieldflag;
	}

	public void setShieldflag(String shieldflag) {
		this.shieldflag = shieldflag;
	}

	/**  起始时间 */
	private String startDate;
	
	/** 结束时间 */
	private String endDate;
	
	/** 主机名称 */
	private String appname;
	
	/** 时间内容 */
	private String summary;
	
	/** 告警id组 */
	private String[] alarmIds;
	
	/** 状态(0:告警;1:恢复;2:关闭) */
	private String status;
	
	/** 触发/恢复时间 */
	protected String lasttime;
	
	/** 是否显示标识(0显示，1不显示)  */	
	protected String isShow;
	
	/** 事件单编号 */
	protected String pedeventid;
	
	/** 2016/10/14修改   功能：添加排序升序或者降序(1.触发事件/恢复事件 2.ip地址 3.主机名称)    gongyunpeng */
	
	/** 主机名称排序状态码 */
	private String appnamestatus;
	
	/** ip地址排序状态码 */
	private String ipaddrstatus;
	
	/** 触发时间排序状态码 */
	private String lasttimestatus;
	
	/** 恢复时间排序状态码 */
	private String recoverytimestatus;
	
	
	
	/**
	 * 比对集成告警表序号获取
	 * @return 比对集成告警表序号
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * 比对集成告警表序号设置
	 * @param serial 比对集成告警表序号
	 */
	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String[] getAlarmIds() {
		return alarmIds;
	}

	public void setAlarmIds(String[] alarmIds) {
		this.alarmIds = alarmIds;
	}

	/**
	 * 状态(0:告警;1:恢复;2:关闭)取得
	 * @return status  状态(0:告警;1:恢复;2:关闭)
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 状态(0:告警;1:恢复;2:关闭)设定
	 * @param status  状态(0:告警;1:恢复;2:关闭)
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 触发/恢复时间取得
	 *
	 * @return 触发/恢复时间
	 */
	public String getLasttime() {
		return lasttime;
	}

	/**
	 * 触发/恢复时间设定
	 *
	 * @param lasttime 触发/恢复时间
	 */
	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}
	
	/**
	 * 是否显示标识(0显示，1不显示)取得
	 * @return isShow  是否显示标识
	 */
	public String getIsShow() {
		return isShow;
	}

	/**
	 * 是否显示标识(0显示，1不显示)设定
	 * @param isShow  是否显示标识
	 */
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	
	/**
	 * 事件单编号取得
	 *
	 * @return 事件单编号
	 */
	public String getPedeventid() {
		return pedeventid;
	}

	/**
	 * 事件单编号设定
	 *
	 * @param pedeventid 事件单编号
	 */
	public void setPedeventid(String pedeventid) {
		this.pedeventid = pedeventid;
	}
	

	/**
	 * 主机名称排序状态码(1为降序 2为升序)取得
	 * 
	 * @return 主机名称排序状态码
	 */
	public String getAppnamestatus() {
		return appnamestatus;
	}

	/**
	 * 主机名称排序状态码(1为降序 2为升序)设置
	 * 
	 * @param 主机名称排序状态码
	 */
	public void setAppnamestatus(String appnamestatus) {
		this.appnamestatus = appnamestatus;
	}

	/**
	 * ip地址排序状态码(1为降序 2为升序)取得
	 * 
	 * @return ip地址排序状态码(1为降序 2为升序)
	 */
	public String getIpaddrstatus() {
		return ipaddrstatus;
	}

	/**
	 * ip地址排序状态码(1为降序 2为升序)设置
	 * 
	 * @param  ip地址排序状态码(1为降序 2为升序)
	 */
	public void setIpaddrstatus(String ipaddrstatus) {
		this.ipaddrstatus = ipaddrstatus;
	}

	/**
	 * 触发时间排序状态码(1为降序 2为升序)取得
	 * 
	 * @return 触发时间排序状态码(1为降序 2为升序)
	 */
	public String getLasttimestatus() {
		return lasttimestatus;
	}

	/**
	 * 触发时间排序状态码(1为降序 2为升序)设置
	 * 
	 * @param 触发时间排序状态码(1为降序 2为升序)
	 */
	public void setLasttimestatus(String lasttimestatus) {
		this.lasttimestatus = lasttimestatus;
	}

	/**
	 * 恢复时间排序状态码(1为降序 2为升序)取得
	 * 
	 * @return 恢复时间排序状态码(1为降序 2为升序)
	 */
	public String getRecoverytimestatus() {
		return recoverytimestatus;
	}

	/**
	 * 恢复时间排序状态码(1为降序 2为升序)设置
	 * 
	 * @param 恢复时间排序状态码(1为降序 2为升序)
	 */
	public void setRecoverytimestatus(String recoverytimestatus) {
		this.recoverytimestatus = recoverytimestatus;
	}

	
	
	
	
	
}
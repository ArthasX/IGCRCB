/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.crc.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 告警信息查询Form
 * </p>
 * 
 * @author changhao@deliverik.com
 * @version 1.0
 */


@SuppressWarnings("serial")
public class IGCRC0203Form extends BaseForm{
	
	/** 起始时间 */
	private String startDate;
	
	/** 结束时间 */
	private String endDate;
	
	/** 主机名称 */
	private String appname;
	
	/** 事件内容 */
	private String summary;
	
	/** 处理人 */
	private String fingerPrint;
	
	/** 故障联系人  */	
	protected String faultContact;
	
	/** 多选款 告警Id*/
	private String[] alarmId;

	/** 状态(0:未处理;1:已处理)  */	
	private String status;
	
	/** 序号 */
	private String serial;
	
	/** 事件单编号 */
	private String pedeventid;
	
	/** IP地址 */
	private String ipaddr;
	
	/** 触发时间 */
	private String lasttime;
	
	/** 恢复时间  */	
	private String recoveryTime; 
	
	/** 描述  */	
	private String description;
	
	/** 是否生成工单  */	
	private String isCreateOrder;
	
	/** 主键  */	
	private Integer pk;
	
	/** 是否显示标识(0显示，1不显示)  */	
	protected String isShow;
	
	/** 主机名称排序状态码 */
	private String appnamestatus;
	
	/** ip地址排序状态码 */
	private String ipaddrstatus;
	
	/** 触发时间排序状态码 */
	private String lasttimestatus;
	
	/** 恢复时间排序状态码 */
	private String recoverytimestatus;
	
	/** 排序字段类型(appname,ipaddr,lasttime) */
	private String type;
	
    /**
     * 起始时间获取
     * @return 起始时间
     */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * 起始时间设置
	 * @param startDate 起始时间
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
     * 结束时间获取
     * @return 起始时间
     */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * 结束时间设置
	 * @param endDate 结束时间
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
     * 主机名称获取
     * @return 主机名称
     */
	public String getAppname() {
		return appname;
	}

	/**
	 * 主机名称设置
	 * @param appname 主机名称
	 */
	public void setAppname(String appname) {
		this.appname = appname;
	}

	/**
     * 时间内容获取
     * @return 时间内容
     */
	public String getSummary() {
		return summary;
	}

	/**
	 * 时间内容设置
	 * @param summary 时间内容
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * 获取告警ID
	 * @return 告警信息列表
	 */
	public String[] getAlarmId() {
		return alarmId;
	}

	/**
	 * 设置告警Id
	 */
	public void setAlarmId(String[] alarmId) {
		this.alarmId = alarmId;
	}

	/**
	 * 状态(0:未处理;1:已处理)取得
	 * @return status  状态(0:未处理;1:已处理)
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 状态(0:未处理;1:已处理)设定
	 * @param status  状态(0:未处理;1:已处理)
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 恢复时间取得
	 * @return recoveryTime  恢复时间
	 */
	public String getRecoveryTime() {
		return recoveryTime;
	}

	/**
	 * 恢复时间设定
	 * @param recoveryTime  恢复时间
	 */
	public void setRecoveryTime(String recoveryTime) {
		this.recoveryTime = recoveryTime;
	}

	/**
	 * 描述取得
	 * @return description  描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 描述设定
	 * @param description  描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 是否生成工单取得
	 * @return isCreateOrder  是否生成工单
	 */
	public String getIsCreateOrder() {
		return isCreateOrder;
	}

	/**
	 * 是否生成工单设定
	 * @param isCreateOrder  是否生成工单
	 */
	public void setIsCreateOrder(String isCreateOrder) {
		this.isCreateOrder = isCreateOrder;
	}

	/**
	 * 主键取得
	 * @return pk  主键
	 */
	public Integer getPk() {
		return pk;
	}

	/**
	 * 主键设定
	 * @param pk  主键
	 */
	public void setPk(Integer pk) {
		this.pk = pk;
	}

	/**
	 * 事件单编号取得
	 * @return pedeventid  事件单编号
	 */
	public String getPedeventid() {
		return pedeventid;
	}

	/**
	 * 事件单编号设定
	 * @param pedeventid  事件单编号
	 */
	public void setPedeventid(String pedeventid) {
		this.pedeventid = pedeventid;
	}

	/**
	 * 序号取得
	 * @return serial  序号
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * 序号设定
	 * @param serial  序号
	 */
	public void setSerial(String serial) {
		this.serial = serial;
	}

	/**
	 * IP地址取得
	 * @return ipaddr  IP地址
	 */
	public String getIpaddr() {
		return ipaddr;
	}

	/**
	 * IP地址设定
	 * @param ipaddr  IP地址
	 */
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	/**
	 * 处理人取得
	 * @return fingerPrint  处理人
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * 处理人设定
	 * @param fingerPrint  处理人
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	/**
	 * 触发时间取得
	 * @return lasttime  触发时间
	 */
	public String getLasttime() {
		return lasttime;
	}

	/**
	 * 触发时间设定
	 * @param lasttime  触发时间
	 */
	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}
	/**
	 * 故障联系人取得
	 * @return faultContact  故障联系人
	 */
	public String getFaultContact() {
		return faultContact;
	}

	/**
	 * 故障联系人设定
	 * @param faultContact  故障联系人
	 */
	public void setFaultContact(String faultContact) {
		this.faultContact = faultContact;
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
	 * 排序字段类型(appname,ipaddr,lasttime)取得
	 * 
	 * @return 排序字段类型(appname,ipaddr,lasttime)
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * 排序字段类型(appname,ipaddr,lasttime)设置
	 * 
	 * @param 排序字段类型(appname,ipaddr,lasttime)
	 */
	public void setType(String type) {
		this.type = type;
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

/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;

/**
  * 概述: 集成告警表实体
  * 功能描述: 集成告警表实体
  * 创建记录: 2014/06/21
  * 修改记录: 1.集成告警表增加3个字段分别为：恢复时间（时间控件）RecoveryTime、
  * 			描述（文本域）description、是否生成工单（下拉）isCreateOrder 2014-8-25 13:30:14
  * 	   2.集成告警表增加2个字段分别为：最后一次告警的发生时间prealarmtime、
  * 			该告警（即同一序列号的告警）发生的次数、alarmcount 
  * 		  新增这两个字段是因为同一序列号的告警压缩为一条  2015-11-17 11:00:39 by wangxing
  */
@SuppressWarnings("serial")
@Entity
@Table(name="igalarm")
public class IgalarmTB extends BaseEntity implements Serializable,
		Cloneable, IgalarmInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="IGALARM_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IGALARM_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IGALARM_TABLE_GENERATOR")
	protected Integer pk;

	/** 序号 */
	protected String serial;

	/** 主机名称 */
	protected String appname;

	/** IP地址 */
	protected String ipaddr;

	/** 事件等级 */
	protected String severity;

	/** 事件内容 */
	protected String summary;

	/** 触发/恢复时间 */
	protected String lasttime;

	/** 状态(0:未处理;1:已处理;2:关闭) */
	protected String status;

	/** 事件单编号 */
	protected String pedeventid;
	
	/** 恢复时间  */	
	protected String recoveryTime; 

	/** 描述  */	
	protected String description;
	
	/** 是否生成工单  */	
	protected String isCreateOrder;
	
	/** 故障联系人  */	
	protected String faultContact;
	
	/** 是否显示标识(0显示，1不显示)  */	
	protected String isShow;
	
	/** 最后一次告警的发生时间  2015.11.17 by wangxing */
	protected String prealarmtime;
	
	/** 该告警（即同一序列号的告警）发生的次数    2015.11.17 by wangxing */
	protected Integer alarmcount;
	
	/** 
	 * 是否处于应急演练屏蔽状态的标识	2016.09.02 by wangxing
	 *  0:正常状态
	 *  1:屏蔽状态
	 **/
	protected String shieldflag;
	
	/**
	 * 应急演练屏蔽描述
	 */
	protected String shielddesc;
	
	
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPk() {
		return pk;
	}

	/**
	 * 主键设定
	 *
	 * @param pk 主键
	 */
	public void setPk(Integer pk) {
		this.pk = pk;
	}

	/**
	 * 序号取得
	 *
	 * @return 序号
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * 序号设定
	 *
	 * @param serial 序号
	 */
	public void setSerial(String serial) {
		this.serial = serial;
	}

	/**
	 * 主机名称取得
	 *
	 * @return 主机名称
	 */
	public String getAppname() {
		return appname;
	}

	/**
	 * 主机名称设定
	 *
	 * @param appname 主机名称
	 */
	public void setAppname(String appname) {
		this.appname = appname;
	}

	/**
	 * IP地址取得
	 *
	 * @return IP地址
	 */
	public String getIpaddr() {
		return ipaddr;
	}

	/**
	 * IP地址设定
	 *
	 * @param ipaddr IP地址
	 */
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	/**
	 * 事件等级取得
	 *
	 * @return 事件等级
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * 事件等级设定
	 *
	 * @param severity 事件等级
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * 事件内容取得
	 *
	 * @return 事件内容
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * 事件内容设定
	 *
	 * @param summary 事件内容
	 */
	public void setSummary(String summary) {
		this.summary = summary;
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
	 * 状态(0:未处理;1:已处理)取得
	 *
	 * @return 状态(0:未处理;1:已处理)
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 状态(0:未处理;1:已处理)设定
	 *
	 * @param status 状态(0:未处理;1:已处理)
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return pk;
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
	 * 最后一次告警时间取得
	 * @return prealarmtime 最后一次告警时间
	 */
	public String getPrealarmtime() {
		return prealarmtime;
	}

	/**
	 * 最后一次告警时间设定
	 * @param prealarmtime 最后一次告警时间
	 */
	public void setPrealarmtime(String prealarmtime) {
		this.prealarmtime = prealarmtime;
	}

	/**
	 * 该告警发生的次数取得
	 * @return alarmcount 该告警发生的次数
	 */
	public Integer getAlarmcount() {
		return alarmcount;
	}

	/**
	 * 该告警发生的次数设定
	 * @param alarmcount 该告警发生的次数
	 */
	public void setAlarmcount(Integer alarmcount) {
		this.alarmcount = alarmcount;
	}

	public String getShieldflag() {
		return shieldflag;
	}

	public void setShieldflag(String shieldflag) {
		this.shieldflag = shieldflag;
	}

	public String getShielddesc() {
		return shielddesc;
	}

	public void setShielddesc(String shielddesc) {
		this.shielddesc = shielddesc;
	}

	@Override
	public String toString() {
		return "IgalarmTB [pk=" + pk + ", serial=" + serial + ", appname="
				+ appname + ", ipaddr=" + ipaddr + ", severity=" + severity
				+ ", summary=" + summary + ", lasttime=" + lasttime
				+ ", status=" + status + ", pedeventid=" + pedeventid
				+ ", recoveryTime=" + recoveryTime + ", description="
				+ description + ", isCreateOrder=" + isCreateOrder
				+ ", faultContact=" + faultContact + ", isShow=" + isShow
				+ ", prealarmtime=" + prealarmtime + ", alarmcount="
				+ alarmcount + ", shieldflag=" + shieldflag + ", shielddesc="
				+ shielddesc + "]";
	}

}
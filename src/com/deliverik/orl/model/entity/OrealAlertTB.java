/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.orl.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.orl.model.OrealAlertInfo;
import com.ibm.icu.text.SimpleDateFormat;

/**
 * 概述：欧莱雅告警表实体
 * 功能描述： 欧莱雅告警表实体
 * 创建人：Lu Jiayuan
 * 创建记录： 2014/02/26
 * 修改记录：
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "oreal_alert")
public class OrealAlertTB extends BaseEntity implements Serializable, Cloneable, OrealAlertInfo {
	/**告警ID(主键)*/
	@Id
	protected Integer id;
	/**IP*/
	protected String ip;
	/**平台ID*/
	protected Integer platform_id;
	/**平台名称*/
	protected String platform_name;
	/**告警名称*/
	protected String defname;
	/**告警发生时间*/
	protected Long ctime;
	/**告警指标数值*/
	protected String value;
	/**是否修复(标识)*/
	protected Integer fixed;
	/**告警优先级(标识)*/
	protected Integer priority;
	/**业务系统ID*/
	protected Integer bid;
	/**业务系统名称*/
	protected String bname;
	
	/**
	 * getter and setter
	 */
	/**
	 * 告警ID(主键)取得
	 * @return id 告警ID(主键)
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 告警ID(主键)设定
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * IP取得
	 * @return ip IP
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * IP设定
	 * @param ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * 平台ID取得
	 * @return platform_id 平台ID
	 */
	public Integer getPlatform_id() {
		return platform_id;
	}
	/**
	 * 平台ID设定
	 * @param platform_id
	 */
	public void setPlatform_id(Integer platform_id) {
		this.platform_id = platform_id;
	}
	
	/**
	 * 平台名称取得
	 * @return platform_name 平台名称
	 */
	public String getPlatform_name() {
		return platform_name;
	}
	/**
	 * 平台名称设定
	 * @param platform_name
	 */
	public void setPlatform_name(String platform_name) {
		this.platform_name = platform_name;
	}
	
	/**
	 * 告警名称取得
	 * @return defname 告警名称
	 */
	public String getDefname() {
		return defname;
	}
	/**
	 * 告警名称设定
	 * @param defname
	 */
	public void setDefname(String defname) {
		this.defname = defname;
	}
	
	/**
	 * 告警发生时间取得
	 * @return ctime 告警发生时间
	 */
	public Long getCtime() {
		return ctime;
	}
	/**
	 * 告警发生时间设定
	 * @param ctime
	 */
	public void setCtime(Long ctime) {
		this.ctime = ctime;
	}
	
	/**
	 * 告警指标数值取得
	 * @return value 告警指标数值
	 */
	public String getValue() {
		return value;
	}
	/**
	 * 告警指标数值设定
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * 是否修复(标识)取得
	 * @return fixed 是否修复(标识)
	 */
	public Integer getFixed() {
		return fixed;
	}
	/**
	 * 是否修复(标识)设定
	 * @param fixed
	 */
	public void setFixed(Integer fixed) {
		this.fixed = fixed;
	}
	
	/**
	 * 告警优先级(标识)取得
	 * @return priority 告警优先级(标识)
	 */
	public Integer getPriority() {
		return priority;
	}
	/**
	 * 告警优先级(标识)设定
	 * @param priority
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	/**
	 * 业务系统ID取得
	 * @return bid 业务系统ID
	 */
	public Integer getBid() {
		return bid;
	}
	/**
	 * 业务系统ID设定
	 * @param bid
	 */
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	
	/**
	 * 业务系统名称取得
	 * @return bname 业务系统名称
	 */
	public String getBname() {
		return bname;
	}
	/**
	 * 业务系统名称设定
	 * @param bname
	 */
	public void setBname(String bname) {
		this.bname = bname;
	}
	/**
	 * 主键获取
	 */
	@Override
	public Serializable getPK() {
		return id;
	}	
	
	/**
	 * Tools方法集
	 */
	/**
	 * Long类型时间转换为yyyy/mm/dd hh:mi格式
	 */
	public String getLong2SDF() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date date = new Date();
		date.setTime(ctime);
		return sdf.format(date);
	}
}

/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.orl.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.orl.model.OrealPMVWInfo;

/**
 * 概述：欧莱雅监控指标视图实体
 * 功能描述： 欧莱雅监控指标视图实体
 * 创建人：Lu Jiayuan
 * 创建记录： 2014/02/26
 * 修改记录：
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "oreal_p_m_view")
public class OrealPMVW implements Serializable, Cloneable, OrealPMVWInfo {
	@Id
	/**监控指标ID(主键)*/
	protected Integer id;
	/**Agent的ID*/
	protected Integer agent_id;
	/**IP*/
	protected String ip;
	/**平台ID*/
	protected Integer platform_id;
	/**平台名称*/
	protected String platform_name;
	/**指标单位*/
	protected String units;
	/**监控类型*/
	protected String typename;
	/**资源ID*/
	protected Integer resource_id;
	/**是否监控(标识)*/
	protected Integer enabled;
	/**监控指标值*/
	protected Double value;
	
	/**
	 * Getter and Setter
	 */
	/**
	 * 监控指标ID(主键)取得
	 * @return id 监控指标ID(主键)
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 监控指标ID(主键)设定
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Agent的ID取得
	 * @return agent_id Agent的ID
	 */
	public Integer getAgent_id() {
		return agent_id;
	}
	/**
	 * Agent的ID设定
	 * @param agent_id Agent的ID
	 */
	public void setAgent_id(Integer agent_id) {
		this.agent_id = agent_id;
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
	 * 指标单位取得
	 * @return units 指标单位
	 */
	public String getUnits() {
		return units;
	}
	/**
	 * 指标单位设定
	 * @param units
	 */
	public void setUnits(String units) {
		this.units = units;
	}
	
	/**
	 * 监控类型取得
	 * @return typename 监控类型
	 */
	public String getTypename() {
		return typename;
	}
	/**
	 * 监控类型设定
	 * @param typename
	 */
	public void setTypename(String typename) {
		this.typename = typename;
	}
	
	/**
	 * 资源ID取得
	 * @return resource_id 资源ID
	 */
	public Integer getResource_id() {
		return resource_id;
	}
	/**
	 * 资源ID设定
	 * @param resource_id
	 */
	public void setResource_id(Integer resource_id) {
		this.resource_id = resource_id;
	}
	
	/**
	 * 是否监控(标识)取得
	 * @return enabled 是否监控(标识)
	 */
	public Integer getEnabled() {
		return enabled;
	}
	/**
	 * 是否监控(标识)设定
	 * @param enabled
	 */
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	
	/**
	 * 监控指标值取得
	 * @return value 监控指标值
	 */
	public Double getValue() {
		return value;
	}
	/**
	 * 监控指标值设定
	 * @param value
	 */
	public void setValue(Double value) {
		this.value = value;
	}
}

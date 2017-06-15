/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.orl.model;

/**
 * 概述：欧莱雅监控指标视图接口
 * 功能描述：欧莱雅监控指标视图接口
 * 创建人：Lu Jiayuan
 * 创建记录： 2014/02/26
 * 修改记录：
 */
public interface OrealPMVWInfo{
	/**
	 * 监控指标ID(主键)取得
	 * @return id 监控指标ID(主键)
	 */
	public Integer getId();
	/**
	 * Agent的ID取得
	 * @return agent_id Agent的ID
	 */
	public Integer getAgent_id();
	/**
	 * IP取得
	 * @return ip IP
	 */
	public String getIp();
	/**
	 * 平台ID取得
	 * @return platform_id 平台ID
	 */
	public Integer getPlatform_id();
	/**
	 * 平台名称取得
	 * @return platform_name 平台名称
	 */
	public String getPlatform_name();
	/**
	 * 指标单位取得
	 * @return units 指标单位
	 */
	public String getUnits();
	/**
	 * 监控类型取得
	 * @return typename 监控类型
	 */
	public String getTypename();
	/**
	 * 资源ID取得
	 * @return resource_id 资源ID
	 */
	public Integer getResource_id();
	/**
	 * 是否监控(标识)取得
	 * @return enabled 是否监控(标识)
	 */
	public Integer getEnabled();
	/**
	 * 监控指标值取得
	 * @return id 监控指标值
	 */
	public Double getValue();
}

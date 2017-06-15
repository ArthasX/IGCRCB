/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.orl.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 概述：欧莱雅告警表实体接口
 * 功能描述：欧莱雅告警表实体接口
 * 创建人：Lu Jiayuan
 * 创建记录： 2014/02/26
 * 修改记录：
 */
public interface OrealAlertInfo extends BaseModel{
	/**
	 * 告警ID取得
	 * @return id 告警ID
	 */
	public Integer getId();
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
	 * 告警名称取得
	 * @return defname 告警名称
	 */
	public String getDefname();
	/**
	 * 告警发生时间取得
	 * @return ctime 告警发生时间
	 */
	public Long getCtime();
	/**
	 * 告警指标数值取得
	 * @return value 告警指标数值
	 */
	public String getValue();
	/**
	 * 是否修复(标识)取得
	 * @return fixed 是否修复(标识)
	 */
	public Integer getFixed() ;
	/**
	 * 告警优先级(标识)取得
	 * @return priority 告警优先级(标识)
	 */
	public Integer getPriority();
	/**
	 * 业务系统ID取得
	 * @return bid 业务系统ID
	 */
	public Integer getBid() ;
	/**
	 * 业务系统名称取得
	 * @return bname 业务系统名称
	 */
	public String getBname() ;
	
	/**
	 * Tools方法集
	 */
	/**
	 * Long类型时间转换为yyyy/mm/dd hh:mi格式
	 */
	public String getLong2SDF() ;
}

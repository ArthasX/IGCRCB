/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.model;

import java.io.Serializable;

/**
 * 概述:年报视图
 * 功能描述：年报视图
 * 创建人：赵梓廷
 * 创建记录： 2013-07-29
 * 修改记录：
 */
public interface AnnualReportVWInfo extends Serializable{

	public Integer getPrid();
	
	/**
	 * 自增ID取得
	 *
	 * @return 自增ID
	 */
	public Integer getInstanceID();
	
	/**
	 * 组类型取得
	 *
	 * @return 组类型
	 */
	public String getPrtype();
	
	/**
	 * 组标识取得
	 *
	 * @return 组标识
	 */
	public String getKey();
	
	/**
	 * 填报发起时间取得
	 *
	 * @return 填报发起时间
	 */
	public String getInittime();
	
	/**
	 * 填报结束时间取得
	 *
	 * @return 填报结束时间
	 */
	public String getEndtime();
	
	/**
	 * 填报限制时间取得
	 *
	 * @return 填报限制时间
	 */
	public String getLimittime();
	
	/**
	 * 备注取得
	 *
	 * @return 备注
	 */
	public String getRemark();
	
	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getStatus();
	
	/**
	 * 发起人ID
	 * 
	 * @return 发起人ID
	 */
	public String getUserid();
	
	/**
	 * 发起人姓名
	 * @return 发起人姓名
	 */
	public String getUsername();
	
	/**
	 * 年报说明
	 * @return 年报说明
	 */
	public String getReportdesc() ;
	
	/**
	 * 流程名
	 * @return 流程名
	 */
	public String getPrtitle();
	
	/**
	 * 流程状态名取得
	 *
	 * @return psdname 流程状态名
	 */
	public String getPsdname();
	
	/**
	 * 当前状态取得
	 *
	 * @return prstatus 当前状态
	 */
	public String getPrstatus();
	
	/**
	 * 是否报送空表标识取得
	 *
	 * @return flag 是否报送空表标识
	 */
	public String getFlag();
	
	/**
	 * 上报报表年份取得
	 *
	 * @return year 上报报表年份
	 */
	public String getYear();
	
	/**
	 * 上报报表季度取得
	 *
	 * @return quarter 上报报表季度
	 */
	public String getQuarter();
}

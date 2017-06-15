/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 报表填报实例表接口
  * 功能描述: 报表填报实例表接口
  * 创建记录: 2013/07/18
  * 修改记录: 
  */
public interface RegulatoryReportInstanceInfo extends BaseModel {

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
	public String getReportdesc();
	
	/**
	 * 年取得
	 * @return 年
	 */
	public String getYear();

	/**
	 * 季度取得
	 * @return 季度
	 */
	public String getQuarter();

}
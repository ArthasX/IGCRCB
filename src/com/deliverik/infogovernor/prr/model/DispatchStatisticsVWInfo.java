/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.model;


/**
  * 概述: 发文流程统计接口
  * 功能描述: 发文流程统计接口
  * 创建记录: 2013/02/27
  * 修改记录: 
  */
public interface DispatchStatisticsVWInfo {

	/**
	 * 主键用户ID取得
	 *
	 * @return 主键用户ID
	 */
	public String getDsuserid();

	/**
	 * 用户名取得
	 *
	 * @return 用户名
	 */
	public String getDsusername();

	/**
	 * 正常完成数量取得
	 *
	 * @return 正常完成数量
	 */
	public Integer getSumzc();

	/**
	 * 延时完成数量取得
	 *
	 * @return 延时完成数量
	 */
	public Integer getSumys();

	/**
	 * 未完成数量取得
	 *
	 * @return 未完成数量
	 */
	public Integer getSumwwc();

	/**
	 * 合计数量取得
	 *
	 * @return 合计数量
	 */
	public Integer getSumnum();

}
/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model.condition;

/**
  * 概述: 配置原数据与主机关系表检索条件接口
  * 功能描述: 配置原数据与主机关系表检索条件接口
  * 创建记录: 2013/04/08
  * 修改记录: 
  */
public interface CR03SearchCond {
	
	/**
	 * 设备标识取得
	 * @return 设备标识
	 */
	public String getHost();
	
	/**
	 * 表名取得
	 * @return 表名
	 */
	public String getTablename();
	
	/**
	 * 采集时间取得
	 *
	 * @return 采集时间
	 */
	public String getCollecttime();
	
	/**
	 * 排序标识取得
	 * @return 排序标识
	 */
	public String getOrderFlag();
	
	/**
	 * 历史版本开始时间取得
	 * @return 历史版本开始时间
	 */
	public String getCollecttimeFrom();

	/**
	 * 历史版本结束时间取得
	 * @return 历史版本结束时间
	 */
	public String getCollecttimeTo();
	
	/**
	 * 查询esyscoding取得
	 * @return esyscoding 查询esyscoding
	 */
	
	public String getEsyscoding();
	
	/**
	 * 状态取得
	 * @return 状态
	 */
	public String getStatus();
	
	/**
	 * IP取得
	 * @return
	 */
	public String getIp();
	
	/**
	 * server类型取得
	 * @return
	 */
	public String getType();
	
	/**
	 * 脚本名取得
	 * @return
	 */
	public String getServername();
}
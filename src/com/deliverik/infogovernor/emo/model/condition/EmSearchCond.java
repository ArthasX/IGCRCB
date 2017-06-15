/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.emo.model.condition;

/**
  * 概述: oracle性能采集检索条件接口
  * 功能描述: oracle性能采集检索条件接口
  * 创建记录: 2014/03/05
  * 修改记录: 
  */
public interface EmSearchCond {
	/**
	 * 类型取得
	 * @return em_type 类型
	 */
	public String getEm_type();
	/**
	 * 最大时间取得
	 * @return max_collecttime 最大时间
	 */
	public String getMax_collecttime();
	/**
	 * 总和倒序取得
	 * @return order_Totail_desc 总和倒序
	 */
	public String getOrder_Totail_desc();
	/**
	 * 实例名
	 * @return fingerprint 
	 */
	public String getFingerprint();
}
/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model;

/**
  * 概述: 流程来源视图接口
  * 功能描述: 流程来源视图接口
  * 创建记录: 2011/11/24
  * 修改记录: 2012/08/09 将ProcessRecordInfoVWInfo表名改为SOC0209Info
  */
public interface SOC0209Info {

	/**
	 * 流程ID取得
	 *
	 * @return 流程ID
	 */
	public Integer getPrid();

	/**
	 * 流程类型取得
	 *
	 * @return 流程类型
	 */
	public String getPrtype();

	/**
	 * 流程来源取得
	 *
	 * @return 流程来源
	 */
	public String getPivarvalue();

	/**
	 * 流程发起时间取得
	 *
	 * @return 流程发起时间
	 */
	public String getPropentime();

	/**
	 * 流程处理用时取得
	 *
	 * @return 流程处理用时
	 */
	public Integer getPrfacttime();

}
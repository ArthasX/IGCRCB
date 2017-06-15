/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model;


/**
  * 概述: IG343Info接口
  * 功能描述: IG343Info接口
  * 创建记录: 2012/07/12
  * 修改记录: 
  */
public interface IG343Info {

	/**
	 * 服务商id取得
	 *
	 * @return 服务商id
	 */
	public Integer getEiid();

	/**
	 * 服务商名称取得
	 *
	 * @return 服务商名称
	 */
	public String getEiname();

	/**
	 * 设备资产取得
	 *
	 * @return 设备资产
	 */
	public Integer getCivalue();

	/**
	 * 设备资产评分取得
	 *
	 * @return 设备资产评分
	 */
	public Double getCivalue1();

	/**
	 * 应用资产取得
	 *
	 * @return 应用资产
	 */
	public Integer getCivalue2();

	/**
	 * 应用资产评分取得
	 *
	 * @return 应用资产评分
	 */
	public Double getCivalue3();

	/**
	 * 培训记录取得
	 *
	 * @return 培训记录
	 */
	public Integer getEiname3();

	/**
	 * 培训记录评分取得
	 *
	 * @return 培训记录评分
	 */
	public Double getCivalue4();

	/**
	 * 获取合计次数
	 * @return 合计次数
	 */
	public Integer getSumcount();
	
	/**
	 * 获取合计平均分
	 * @return 合计平均分
	 */
	public Double getSumstore();
}
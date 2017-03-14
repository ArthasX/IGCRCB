/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 报表填报明细表接口
  * 功能描述: 报表填报明细表接口
  * 创建记录: 2013/07/18
  * 修改记录: 
  */
public interface RegulatoryReportDetailInfo extends BaseModel {

	/**
	 * 自增ID取得
	 *
	 * @return 自增ID
	 */
	public Integer getDetailID();

	/**
	 * 填报实例ID取得
	 *
	 * @return 填报实例ID
	 */
	public Integer getInstanceID();

	/**
	 * 流程ID取得
	 *
	 * @return 流程ID
	 */
	public Integer getPrid();
	

}
/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 风险指标维护接口
  * 功能描述: 风险指标维护接口
  * 创建记录: 2014/07/25
  * 修改记录: 
  */
public interface MaintenanceInfo extends BaseModel {

	/**
	 * 风险指标维护ID取得
	 *
	 * @return 风险指标维护ID
	 */
	public Integer getRIMID();

	/**
	 * 风险指标ID取得
	 *
	 * @return 风险指标ID
	 */
	public Integer getRIID();

	/**
	 * 风险指标分类取得
	 *
	 * @return 风险指标分类
	 */
	public String getRIMTYPE();

	/**
	 * 风险指标说明取得
	 *
	 * @return 风险指标说明
	 */
	public String getRIMDESC();

	/**
	 * 指标维护语句取得
	 *
	 * @return 指标维护语句
	 */
	public String getRIMSQL();

}
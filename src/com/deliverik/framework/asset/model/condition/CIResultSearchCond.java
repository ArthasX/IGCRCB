/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.condition;

/**
  * 概述: 对比结果信息表检索条件接口
  * 功能描述: 对比结果信息表检索条件接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface CIResultSearchCond {

	/**
	 * 时间戳 开始取得
	 * @return 时间戳 开始
	 */
	public String getCitime_from();

	/**
	 * 时间戳 结束取得
	 * @return 时间戳 结束
	 */
	public String getCitime_to();
	
	/**
	 * 任务描述取得
	 * @return 任务描述
	 */
	public String getCitdesc();
	
	/**
	 * 资产层次码取得
	 * @return 资产层次码
	 */
	public String getEsyscoding();

}
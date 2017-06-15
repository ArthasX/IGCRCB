/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: 风险事件检索条件接口
  * 功能描述: 风险事件检索条件接口
  * 创建记录: 2014/07/18
  * 修改记录: 
  */
public interface RiskcaseVWSearchCond {
	public String getFcname();
	public String getFcorigin();
	public String getFccategory();
	public String getRiskcatchtime_from();
	public String getRiskcatchtime_to();
	public String getRiskid();
	public String getFcpolicy();
	public String getRiskreviewresult();
	public Integer getEiid();
	public String getVersion();
	/**
	 * 风险事件状态取得
	 *
	 * @return 风险事件状态
	 */
	public String getEISTATUS();
}
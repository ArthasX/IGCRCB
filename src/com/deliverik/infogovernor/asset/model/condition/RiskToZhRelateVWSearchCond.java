/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: 风险到指标关系检索条件接口
  * 功能描述: 风险到指标关系检索条件接口
  * 创建记录: 2014/07/24
  * 修改记录: 
  */
public interface RiskToZhRelateVWSearchCond {
	/**
	 * 主键取得
	 * @return eiid 主键
	 */
	public String getEiid();
	/**
	 * 标识：1风险，0检查项取得
	 * @return sign 标识：1风险，0检查项
	 */
	public String getSign() ;
}
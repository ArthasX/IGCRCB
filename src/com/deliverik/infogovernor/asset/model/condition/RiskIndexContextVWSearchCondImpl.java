/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: 风险指标展示内容查询检索条件实现
  * 功能描述: 风险指标展示内容查询检索条件实现
  * 创建记录: 2014/07/26
  * 修改记录: 
  */
public class RiskIndexContextVWSearchCondImpl implements
		RiskIndexContextVWSearchCond {

	/**分类*/
	protected String esyscoding;

	/**
	 * 分类取得
	 * @return esyscoding 分类
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 分类设定
	 * @param esyscoding 分类
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
}
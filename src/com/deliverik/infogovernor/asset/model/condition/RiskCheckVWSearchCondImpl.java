/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: 检查工作统计报表检索条件实现
  * 功能描述: 检查工作统计报表检索条件实现
  * 创建记录: 2014/07/22
  * 修改记录: 
  */
public class RiskCheckVWSearchCondImpl implements
		RiskCheckVWSearchCond {
	/**风险点ID*/
	protected String eiid;

	/**
	 * 风险点ID取得
	 * @return eiid 风险点ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 风险点ID设定
	 * @param eiid 风险点ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}
}
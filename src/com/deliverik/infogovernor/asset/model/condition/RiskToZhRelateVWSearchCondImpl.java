/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: 风险到指标关系检索条件实现
  * 功能描述: 风险到指标关系检索条件实现
  * 创建记录: 2014/07/24
  * 修改记录: 
  */
public class RiskToZhRelateVWSearchCondImpl implements
		RiskToZhRelateVWSearchCond {

	/**主键*/
	protected String eiid;
	
	/**标识：1 风险，0 检查项*/
	protected String sign;

	/**
	 * 标识：1风险，0检查项取得
	 * @return sign 标识：1风险，0检查项
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * 标识：1风险，0检查项设定
	 * @param sign 标识：1风险，0检查项
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * 主键取得
	 * @return eiid 主键
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 主键设定
	 * @param eiid 主键
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}
}
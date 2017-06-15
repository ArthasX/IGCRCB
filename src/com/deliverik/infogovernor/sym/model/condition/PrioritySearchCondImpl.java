/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.sym.model.condition;

/**
 * 概述:优先级查询实现类
 * 功能描述：1.影响度值取得
 * 			2.优先级值取得
 * 			3.紧急度值取得
 * 			4.流程类型取得
 * 创建记录：fangyunlong@deliverik.com    2010/12/14
 */

public class PrioritySearchCondImpl implements PrioritySearchCond {

	/**影响度值*/
	protected String ivalue;
	/**流程类型*/
	protected String pprtype;
	/**优先级值*/
	protected String pvalue;
	/**紧急度值*/
	protected String uvalue;

	/**
	 *影响度值取得
	 * 
	 * @return 影响度值
	 */
	public String getIvalue() {
		return ivalue;
	}
	/**
	 *影响度值设定
	 * 
	 * @param 影响度值
	 */
	public void setIvalue(String ivalue) {
		this.ivalue = ivalue;
	}
	/**
	 *优先级值取得
	 * 
	 * @return 优先级值
	 */
	public String getPvalue() {
		return pvalue;
	}
	/**
	 *优先级值设定
	 * 
	 * @param 优先级值
	 */
	public void setPvalue(String pvalue) {
		this.pvalue = pvalue;
	}
	/**
	 *紧急度值取得
	 * 
	 * @return 紧急度值
	 */
	public String getUvalue() {
		return uvalue;
	}
	/**
	 *紧急度值设定
	 * 
	 * @param 紧急度值
	 */
	public void setUvalue(String uvalue) {
		this.uvalue = uvalue;
	}
	/**
	 *流程类型取得
	 * 
	 * @return 流程类型
	 */
	public String getPprtype() {
		return pprtype;
	}
	/**
	 *流程类型设定
	 * 
	 * @param 流程类型
	 */
	public void setPprtype(String pprtype) {
		this.pprtype = pprtype;
	}

}

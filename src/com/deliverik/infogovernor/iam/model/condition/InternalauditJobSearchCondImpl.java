/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.iam.model.condition;

/**
  * 概述: 内置工作表检索条件实现
  * 功能描述: 内置工作表检索条件实现
  * 创建记录: 2012/07/25
  * 修改记录: 
  */

public class InternalauditJobSearchCondImpl implements
		InternalauditJobSearchCond {

	/**
	 * 年度计划
	 */
	private String iajYear_q;
	/**
	 * 工作名称
	 */
	private String iajName_like;
	/**
	 * 内审项目ID
	 */
	private Integer iajIapId_q;
	/**
	 * 获取iajYear_q
	 * @return fiajYear_q iajYear_q
	 */
	public String getIajYear_q() {
		return iajYear_q;
	}
	/**
	 * 设置iajYear_q
	 * @param iajYear_q  iajYear_q
	 */
	public void setIajYear_q(String iajYear_q) {
		this.iajYear_q = iajYear_q;
	}
	/**
	 * 获取iajName_like
	 * @return fiajName_like iajName_like
	 */
	public String getIajName_like() {
		return iajName_like;
	}
	/**
	 * 设置iajName_like
	 * @param iajName_like  iajName_like
	 */
	public void setIajName_like(String iajName_like) {
		this.iajName_like = iajName_like;
	}
	/**
	 * 获取iajIapId_q
	 * @return fiajIapId_q iajIapId_q
	 */
	public Integer getIajIapId_q() {
		return iajIapId_q;
	}
	/**
	 * 设置iajIapId_q
	 * @param iajIapId_q  iajIapId_q
	 */
	public void setIajIapId_q(Integer iajIapId_q) {
		this.iajIapId_q = iajIapId_q;
	}
	
}
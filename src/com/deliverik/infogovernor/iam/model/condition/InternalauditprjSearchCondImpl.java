/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.iam.model.condition;

/**
  * 概述: 内审项目检索条件实现
  * 功能描述: 内审项目检索条件实现
  * 创建记录: 2012/07/19
  * 修改记录: 
  */
public class InternalauditprjSearchCondImpl implements
		InternalauditprjSearchCond {
	
	/** 年度 */
	private String iapYear_eq;
	
	/** 内审项目名称 */
	private String iapName_like;
	
	/** 状态 */
	private String iapStatus_eq;
	
	/** 审计开始日期从 */
	private String iapOpenTimeFrom_ge;
	
	/** 审计开始日期到 */
	private String iapOpenTimeTo_le;
	
	/** 审计类型 */
	private String iapType_eq;

	/**
	 * iapYear_eq取得
	 *
	 * @return iapYear_eq iapYear_eq
	 */
	public String getIapYear_eq() {
		return iapYear_eq;
	}

	/**
	 * iapYear_eq设定
	 *
	 * @param iapYear_eq iapYear_eq
	 */
	public void setIapYear_eq(String iapYear_eq) {
		this.iapYear_eq = iapYear_eq;
	}

	/**
	 * iapName_like取得
	 *
	 * @return iapName_like iapName_like
	 */
	public String getIapName_like() {
		return iapName_like;
	}

	/**
	 * iapName_like设定
	 *
	 * @param iapName_like iapName_like
	 */
	public void setIapName_like(String iapName_like) {
		this.iapName_like = iapName_like;
	}

	/**
	 * iapStatus_eq取得
	 *
	 * @return iapStatus_eq iapStatus_eq
	 */
	public String getIapStatus_eq() {
		return iapStatus_eq;
	}

	/**
	 * iapStatus_eq设定
	 *
	 * @param iapStatus_eq iapStatus_eq
	 */
	public void setIapStatus_eq(String iapStatus_eq) {
		this.iapStatus_eq = iapStatus_eq;
	}

	/**
	 * iapOpenTimeFrom_ge取得
	 *
	 * @return iapOpenTimeFrom_ge iapOpenTimeFrom_ge
	 */
	public String getIapOpenTimeFrom_ge() {
		return iapOpenTimeFrom_ge;
	}

	/**
	 * iapOpenTimeFrom_ge设定
	 *
	 * @param iapOpenTimeFrom_ge iapOpenTimeFrom_ge
	 */
	public void setIapOpenTimeFrom_ge(String iapOpenTimeFrom_ge) {
		this.iapOpenTimeFrom_ge = iapOpenTimeFrom_ge;
	}

	/**
	 * iapOpenTimeTo_le取得
	 *
	 * @return iapOpenTimeTo_le iapOpenTimeTo_le
	 */
	public String getIapOpenTimeTo_le() {
		return iapOpenTimeTo_le;
	}

	/**
	 * iapOpenTimeTo_le设定
	 *
	 * @param iapOpenTimeTo_le iapOpenTimeTo_le
	 */
	public void setIapOpenTimeTo_le(String iapOpenTimeTo_le) {
		this.iapOpenTimeTo_le = iapOpenTimeTo_le;
	}

	/**
	 * iapType_eq取得
	 *
	 * @return iapType_eq iapType_eq
	 */
	public String getIapType_eq() {
		return iapType_eq;
	}

	/**
	 * iapType_eq设定
	 *
	 * @param iapType_eq iapType_eq
	 */
	public void setIapType_eq(String iapType_eq) {
		this.iapType_eq = iapType_eq;
	}

	
}
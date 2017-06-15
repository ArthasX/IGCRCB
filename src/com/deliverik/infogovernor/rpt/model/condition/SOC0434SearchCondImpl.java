/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: PVVIO检索条件实现
  * 功能描述: PVVIO检索条件实现
  * 创建记录: 2012/08/20
  * 修改记录: 
  */
public class SOC0434SearchCondImpl implements
		SOC0434SearchCond {
	protected String sName;
	protected String isUsed;
	protected String sN;
	/**
	 * sName取得
	 *
	 * @return sName sName
	 */
	public String getSName() {
		return sName;
	}
	/**
	 * sName设定
	 *
	 * @param name sName
	 */
	public void setSName(String name) {
		sName = name;
	}
	/**
	 * isUsed取得
	 *
	 * @return isUsed isUsed
	 */
	public String getIsUsed() {
		return isUsed;
	}
	/**
	 * isUsed设定
	 *
	 * @param isUsed isUsed
	 */
	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}
	/**
	 * sN取得
	 *
	 * @return sN sN
	 */
	public String getSN() {
		return sN;
	}
	/**
	 * sN设定
	 *
	 * @param sn sN
	 */
	public void setSN(String sn) {
		sN = sn;
	}
}
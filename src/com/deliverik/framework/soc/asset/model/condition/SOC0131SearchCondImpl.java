/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.condition;

/**
 * 概述: 设备关系信息条件实现(VG-PV-Meta)
 * 功能描述: 设备关系信息条件实现(VG-PV-Meta)
 * 创建记录: 2011/05/13
 * 修改记录: 
 */
public class SOC0131SearchCondImpl implements SOC0131SearchCond{
	/**源资产ID*/
	protected String srpareiid_eq;
	
	/**DomainID*/
	protected String srdomainid_eq;
	
	/**Domain版本*/
	protected String srdomainversion_eq;
	
	/**源资产大版本*/
	protected String srparversion_eq;
	
	/**源资产小版本*/
	protected String srparsmallversion_eq;
	
	/**创建时间*/
	protected String srcreatetime_eq;
	
	/**
	 * 源资产ID取得
	 * @return 源资产ID
	 */
	public String getSrpareiid_eq() {
		return srpareiid_eq;
	}

	/**
	 * 源资产ID设定
	 * @param srpareiid源资产ID
	 */
	public void setSrpareiid_eq(String srpareiid_eq) {
		this.srpareiid_eq = srpareiid_eq;
	}

	/**
	 * DomainID取得
	 * @return DomainID
	 */
	public String getSrdomainid_eq() {
		return srdomainid_eq;
	}

	/**
	 * DomainID设定
	 * @param srdomainidDomainID
	 */
	public void setSrdomainid_eq(String srdomainid_eq) {
		this.srdomainid_eq = srdomainid_eq;
	}

	/**
	 * Domain版本取得
	 * @return Domain版本
	 */
	public String getSrdomainversion_eq() {
		return srdomainversion_eq;
	}

	/**
	 * Domain版本设定
	 * @param srdomainversionDomain版本
	 */
	public void setSrdomainversion_eq(String srdomainversion_eq) {
		this.srdomainversion_eq = srdomainversion_eq;
	}

	/**
	 * 源资产大版本取得
	 * @return 源资产大版本
	 */
	public String getSrparversion_eq() {
		return srparversion_eq;
	}

	/**
	 * 源资产大版本设定
	 * @param srparversion源资产大版本
	 */
	public void setSrparversion_eq(String srparversion_eq) {
		this.srparversion_eq = srparversion_eq;
	}

	/**
	 * 源资产小版本取得
	 * @return 源资产小版本
	 */
	public String getSrparsmallversion_eq() {
		return srparsmallversion_eq;
	}

	/**
	 * 源资产小版本设定
	 * @param srparsmallversion源资产小版本
	 */
	public void setSrparsmallversion_eq(String srparsmallversion_eq) {
		this.srparsmallversion_eq = srparsmallversion_eq;
	}

	/**
	 * 创建时间取得
	 * @return 创建时间
	 */
	public String getSrcreatetime_eq() {
		return srcreatetime_eq;
	}

	/**
	 * 创建时间设定
	 * @param srcreatetime创建时间
	 */
	public void setSrcreatetime_eq(String srcreatetime_eq) {
		this.srcreatetime_eq = srcreatetime_eq;
	}

}

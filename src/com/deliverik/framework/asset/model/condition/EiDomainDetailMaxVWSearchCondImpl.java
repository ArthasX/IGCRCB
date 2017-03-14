/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset.model.condition;

/**
 * 概述: 资产域明细表检索条件实现
 * 功能描述: 资产域明细表检索条件实现
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
public class EiDomainDetailMaxVWSearchCondImpl implements
		EiDomainDetailMaxVWSearchCond {
	
	/** 域ID */
	protected String eiddid;
	
	/** 查询类型 */
	protected String typeId;
	
	/** 影响CI */
	protected String eilabel;
	
	/** 资产域版本 **/
	private String  eiddversion;
	
	protected String einame;
	
	protected String eiid;
	
	
	/**
	 * 域ID取得
	 * @return 域ID
	 */
	public String getEiddid() {
		return eiddid;
	}

	/**
	 * 域ID设定
	 * @param eiddid域ID
	 */
	public void setEiddid(String eiddid) {
		this.eiddid = eiddid;
	}

	/**
	 * 查询类型取得
	 * @return 查询类型
	 */
	public String getTypeId() {
		return typeId;
	}

	/**
	 * 查询类型设定
	 * @param typeId查询类型
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	/**
	 * 影响CI取得
	 */
	public String getEilabel() {
		return eilabel;
	}
	
	/**
	 * 影响CI设定
	 * @param eilabel影响CI
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}
	/**
	 * 资产域版本取得
	 */

	public String getEiddversion() {
		return eiddversion;
	}

	/**
	 * 资产域版本设定
	 * @param eiddversion资产域版本
	 */
	public void setEiddversion(String eiddversion) {
		this.eiddversion = eiddversion;
	}

	public String getEiname() {
		return einame;
	}

	public void setEiname(String einame) {
		this.einame = einame;
	}

	public String getEiid() {
		return eiid;
	}

	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	
}

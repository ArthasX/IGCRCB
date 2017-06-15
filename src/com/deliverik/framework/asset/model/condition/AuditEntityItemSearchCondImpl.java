/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.condition;

import java.util.List;

/**
  * 概述: 审计资产表检索条件实现
  * 功能描述: 审计资产表检索条件实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class AuditEntityItemSearchCondImpl implements
		AuditEntityItemSearchCond {
	
	/** 审计资产类型(1:新增, 2:修改) */
	protected String aucmptype;
	
	/** 顶级CI标识 */
	public List<String> topCIList;

	/**
	 * 审计资产类型取得
	 * @return 审计资产类型
	 */
	public String getAucmptype() {
		return aucmptype;
	}

	/**
	 * 审计资产类型设定
	 * @param aucmptype 审计资产类型
	 */
	public void setAucmptype(String aucmptype) {
		this.aucmptype = aucmptype;
	}

	/**
	 * 顶级CI标识取得
	 * @return 顶级CI标识
	 */
	public List<String> getTopCIList() {
		return topCIList;
	}

	/**
	 * 顶级CI标识设定
	 * @param topCIList 顶级CI标识
	 */
	public void setTopCIList(List<String> topCIList) {
		this.topCIList = topCIList;
	}
	
}
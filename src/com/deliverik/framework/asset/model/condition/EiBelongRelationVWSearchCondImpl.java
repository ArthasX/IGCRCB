/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.condition;

/**
  * 概述: 配置所属关系视图检索条件实现
  * 功能描述: 配置所属关系视图检索条件实现
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public class EiBelongRelationVWSearchCondImpl implements
	EiBelongRelationVWSearchCond {
	
	/** 源资产大版本 */
	protected Integer brparversion;

	/** 目的资产大版本 */
	protected Integer brcldversion;

	/** 资产所属树根节点实体标识 */
	protected Integer eirootmark;
	
	/**
	 * 目的资产大版本取得
	 *
	 * @return 目的资产大版本
	 */
	public Integer getBrcldversion() {
		return brcldversion;
	}

	/**
	 * 目的资产大版本设定
	 *
	 * @param brcldversion目的资产大版本
	 */
	public void setBrcldversion(Integer brcldversion) {
		this.brcldversion = brcldversion;
	}

	/**
	 * 源资产大版本取得
	 *
	 * @return 源资产大版本
	 */
	public Integer getBrparversion() {
		return brparversion;
	}

	/**
	 * 源资产大版本设定
	 *
	 * @param brparversion源资产大版本
	 */
	public void setBrparversion(Integer brparversion) {
		this.brparversion = brparversion;
	}

	/**
	 * 资产所属树根节点实体标识取得
	 * @return 资产所属树根节点实体标识
	 */
	public Integer getEirootmark() {
		return eirootmark;
	}
	
	/**
	 * 资产所属树根节点实体标识设定
	 *
	 * @param eirootmark 资产所属树根节点实体标识
	 */
	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}
}
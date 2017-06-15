/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * 概述: 配置所属关系表检索条件实现
  * 功能描述: 配置所属关系表检索条件实现
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public class SOC0110SearchCondImpl implements
		SOC0110SearchCond {
	/** 源资产ID */
	protected String brpareiid;

	/** 源资产大版本 */
	protected String brparversion;

	/** 源资产小版本 */
	protected String brparsmallversion;
	
	/** 逻辑删除标识 */
	protected String deleteflag;
	
	/** 目的资产ID */
	protected String brcldeiid;

	/** 目的资产大版本 */
	protected String brcldversion;

	/** 目的资产小版本 */
	protected String brcldsmallversion;
	
	/** 资产所属树根节点实体标识 */
	protected String eirootmark;
	/**资产关系码*/
	protected String brassetrelation;
	
	/**资产关系码_in*/
	protected String brassetrelation_in;
	
	protected String brassetrelation_not;
	
	/**
	 * 目的资产ID取得
	 *
	 * @return 目的资产ID
	 */
	public String getBrcldeiid() {
		return brcldeiid;
	}

	/**
	 * 目的资产ID设定
	 *
	 * @param brcldeiid目的资产ID
	 */
	public void setBrcldeiid(String brcldeiid) {
		this.brcldeiid = brcldeiid;
	}

	/**
	 * 目的资产大版本取得
	 *
	 * @return 目的资产大版本
	 */
	public String getBrcldversion() {
		return brcldversion;
	}

	/**
	 * 目的资产大版本设定
	 *
	 * @param brcldversion目的资产大版本
	 */
	public void setBrcldversion(String brcldversion) {
		this.brcldversion = brcldversion;
	}

	/**
	 * 目的资产小版本取得
	 *
	 * @return 目的资产小版本
	 */
	public String getBrcldsmallversion() {
		return brcldsmallversion;
	}

	/**
	 * 目的资产小版本设定
	 *
	 * @param brcldsmallversion目的资产小版本
	 */
	public void setBrcldsmallversion(String brcldsmallversion) {
		this.brcldsmallversion = brcldsmallversion;
	}

	
	/**
	 * 逻辑删除标识取得
	 *
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * 逻辑删除标识设定
	 *
	 * @param deleteflag逻辑删除标识
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
	
	/**
	 * 源资产ID取得
	 *
	 * @return 源资产ID
	 */
	public String getBrpareiid() {
		return brpareiid;
	}

	/**
	 * 源资产ID设定
	 *
	 * @param brpareiid源资产ID
	 */
	public void setBrpareiid(String brpareiid) {
		this.brpareiid = brpareiid;
	}

	/**
	 * 源资产大版本取得
	 *
	 * @return 源资产大版本
	 */
	public String getBrparversion() {
		return brparversion;
	}

	/**
	 * 源资产大版本设定
	 *
	 * @param brparversion源资产大版本
	 */
	public void setBrparversion(String brparversion) {
		this.brparversion = brparversion;
	}

	/**
	 * 源资产小版本取得
	 *
	 * @return 源资产小版本
	 */
	public String getBrparsmallversion() {
		return brparsmallversion;
	}

	/**
	 * 源资产小版本设定
	 *
	 * @param brparsmallversion源资产小版本
	 */
	public void setBrparsmallversion(String brparsmallversion) {
		this.brparsmallversion = brparsmallversion;
	}
	
	/**
	 * 资产所属树根节点实体标识取得
	 * @return 资产所属树根节点实体标识
	 */
	public String getEirootmark() {
		return eirootmark;
	}
	
	/**
	 * 资产所属树根节点实体标识设定
	 *
	 * @param eirootmark 资产所属树根节点实体标识
	 */
	public void setEirootmark(String eirootmark) {
		this.eirootmark = eirootmark;
	}

	/**
	 * 资产关系码取得
	 *
	 * @return brassetrelation 资产关系码
	 */
	public String getBrassetrelation() {
		return brassetrelation;
	}

	/**
	 * 资产关系码设定
	 *
	 * @param brassetrelation 资产关系码
	 */
	public void setBrassetrelation(String brassetrelation) {
		this.brassetrelation = brassetrelation;
	}

	/**
	 * 资产关系码_in取得
	 *
	 * @return brassetrelation_in 资产关系码_in
	 */
	
	public String getBrassetrelation_in() {
		return brassetrelation_in;
	}

	/**
	 * 资产关系码_in设定
	 *
	 * @param brassetrelation_in 资产关系码_in
	 */
	
	public void setBrassetrelation_in(String brassetrelation_in) {
		this.brassetrelation_in = brassetrelation_in;
	}

	public String getBrassetrelation_not() {
		return brassetrelation_not;
	}

	public void setBrassetrelation_not(String brassetrelation_not) {
		this.brassetrelation_not = brassetrelation_not;
	}
	
	
}
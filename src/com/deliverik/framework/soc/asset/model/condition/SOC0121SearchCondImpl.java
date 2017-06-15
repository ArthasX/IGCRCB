/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * 概述: 快照关系表检索条件实现
  * 功能描述: 快照关系表检索条件实现
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public class SOC0121SearchCondImpl implements
		SOC0121SearchCond {
	
	/** 域ID */
	protected String srdomainid_eq;
	
	/** 域版本 */
	protected String srdomainversion_eq;
	
	/** 逻辑删除标识 */
	protected String deleteflag_eq;
	
	/**源资产ID*/
	protected String srpareiid_eq;
	
	/**源资产大版本*/
	protected String srparversion_eq;
	
	/**源资产小版本*/
	protected String srparsmallversion_eq;
	
	/**创建时间*/
	protected String srcreatetime_eq;
	
	/** 关系跳转地址*/
	private String forword;
	
	/**关系分类*/
	protected String srassetrelation_eq;
	
	/** 扩展算法类型*/
	protected String srarithmetictype_eq;
	
	/** 目的资产ID */
	protected String srcldeiid_eq;

	/** 目的资产大版本 */
	protected String srcldversion_eq;

	/** 目的资产小版本 */
	protected String srcldsmallversion_eq;
	
	/**存储EIname*/
	private String srcStorageEiname;
	
	private Integer[] srpareiids;
	
	private Integer[] srcldeiids;
	

	/**
	 * srpareiids取得
	 *
	 * @return srpareiids srpareiids
	 */
	
	public Integer[] getSrpareiids() {
		return srpareiids;
	}

	/**
	 * srpareiids设定
	 *
	 * @param srpareiids srpareiids
	 */
	
	public void setSrpareiids(Integer[] srpareiids) {
		this.srpareiids = srpareiids;
	}

	/**
	 * srcldeiids取得
	 *
	 * @return srcldeiids srcldeiids
	 */
	
	public Integer[] getSrcldeiids() {
		return srcldeiids;
	}

	/**
	 * srcldeiids设定
	 *
	 * @param srcldeiids srcldeiids
	 */
	
	public void setSrcldeiids(Integer[] srcldeiids) {
		this.srcldeiids = srcldeiids;
	}

	/**
	 * 关系跳转地址取得
	 * @return 关系跳转地址
	 */
	public String getForword() {
		return forword;
	}

	/**
	 * 关系跳转地址设定
	 * @param forword关系跳转地址
	 */
	public void setForword(String forword) {
		this.forword = forword;
	}
	
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
	/**
	 * 关系类型获取
	 * @param srcreatetime关系类型
	 */
	public String getSrassetrelation_eq() {
		return srassetrelation_eq;
	}
	/**
	 * 关系类型设定
	 * @param srcreatetime关系类型
	 */
	public void setSrassetrelation_eq(String srassetrelation_eq) {
		this.srassetrelation_eq = srassetrelation_eq;
	}
	/**
	 * 域ID取得
	 * 
	 * @return 域ID
	 */
	public String getSrdomainid_eq() {
		return srdomainid_eq;
	}

	/**
	 * 域ID设定
	 * 
	 * @param srdomainid_eq 域ID
	 */
	public void setSrdomainid_eq(String srdomainid_eq) {
		this.srdomainid_eq = srdomainid_eq;
	}

	/**
	 * 域版本取得
	 * 
	 * @return 域版本
	 */
	public String getSrdomainversion_eq() {
		return srdomainversion_eq;
	}

	/**
	 * 域版本设定
	 * 
	 * @param srdomainversion_eq 域版本
	 */
	public void setSrdomainversion_eq(String srdomainversion_eq) {
		this.srdomainversion_eq = srdomainversion_eq;
	}
	
	/**
	 * 逻辑删除标识取得
	 *
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag_eq() {
		return deleteflag_eq;
	}

	/**
	 * 逻辑删除标识设定
	 *
	 * @param brdeleteflag_eq逻辑删除标识
	 */
	public void setDeleteflag_eq(String deleteflag_eq) {
		this.deleteflag_eq = deleteflag_eq;
	}
	/**
	 *  扩展算法类型取得
	 * @return 扩展算法类型 srarithmetictype_eq
	 */
	public String getSrarithmetictype_eq() {
		return srarithmetictype_eq;
	}
	/**
	 *  扩展算法类型设定
	 * @param srarithmetictype_eq 扩展算法类型
	 */
	public void setSrarithmetictype_eq(String srarithmetictype_eq) {
		this.srarithmetictype_eq = srarithmetictype_eq;
	}
	/**
	 *  目的资产ID取得
	 * @return 目的资产ID srcldeiid_eq
	 */
	public String getSrcldeiid_eq() {
		return srcldeiid_eq;
	}
	/**
	 *  目的资产ID设定
	 * @param srcldeiid_eq 目的资产ID
	 */
	public void setSrcldeiid_eq(String srcldeiid_eq) {
		this.srcldeiid_eq = srcldeiid_eq;
	}
	/**
	 *  目的资产大版本取得
	 * @return 目的资产大版本 srcldversion_eq
	 */
	public String getSrcldversion_eq() {
		return srcldversion_eq;
	}
	/**
	 *  目的资产大版本设定
	 * @param srcldversion_eq 目的资产大版本
	 */
	public void setSrcldversion_eq(String srcldversion_eq) {
		this.srcldversion_eq = srcldversion_eq;
	}
	/**
	 *  目的资产小版本取得
	 * @return 目的资产小版本 srcldsmallversion_eq
	 */
	public String getSrcldsmallversion_eq() {
		return srcldsmallversion_eq;
	}
	/**
	 *  目的资产小版本设定
	 * @param srcldsmallversion_eq 目的资产小版本
	 */
	public void setSrcldsmallversion_eq(String srcldsmallversion_eq) {
		this.srcldsmallversion_eq = srcldsmallversion_eq;
	}
    /**
     * 获取查询用的存储einame
     * @return
     */
	public String getSrcStorageEiname() {
		return srcStorageEiname;
	}

	public void setSrcStorageEiname(String srcStorageEiname) {
		this.srcStorageEiname = srcStorageEiname;
	}	
}
/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.condition;

/**
  * 概述: 快照关系表检索条件接口
  * 功能描述: 快照关系表检索条件接口
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public interface SnapshotRelationSearchCond {
	
	/**
	 * 域ID取得
	 * 
	 * @return 域ID
	 */
	public String getSrdomainid_eq();

	/**
	 * 域版本取得
	 * 
	 * @return 域版本
	 */
	public String getSrdomainversion_eq();
	
	/**
	 * 逻辑删除标识取得
	 *
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag_eq();
	
	/**
	 * 源资产ID取得
	 * @return 源资产ID
	 */
	public String getSrpareiid_eq() ;
	
	
	/**
	 * 源资产大版本取得
	 * @return 源资产大版本
	 */
	public String getSrparversion_eq();
	
	/**
	 * 源资产小版本取得
	 * @return 源资产小版本
	 */
	public String getSrparsmallversion_eq() ;
	
	/**
	 * 创建时间取得
	 * @return 创建时间
	 */
	public String getSrcreatetime_eq();
	
	/**
	 * 关系类型获取
	 * @param srcreatetime关系类型
	 */
	public String getSrassetrelation_eq();
	
	/**
	 *  扩展算法类型取得
	 * @return 扩展算法类型 srarithmetictype_eq
	 */
	public String getSrarithmetictype_eq();
	
	/**
	 *  目的资产ID取得
	 * @return 目的资产ID srcldeiid_eq
	 */
	public String getSrcldeiid_eq();
	
	/**
	 *  目的资产大版本取得
	 * @return 目的资产大版本 srcldversion_eq
	 */
	public String getSrcldversion_eq();
	
	/**
	 *  目的资产小版本取得
	 * @return 目的资产小版本 srcldsmallversion_eq
	 */
	public String getSrcldsmallversion_eq();
	
	 /**
     * 获取查询用的存储einame
     * @return
     */
	public String getSrcStorageEiname();
}
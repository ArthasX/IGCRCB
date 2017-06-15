/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.fxk.model.condition;

/**
  * 概述: 风险管理提示数据表检索条件接口
  * 功能描述: 风险管理提示数据表检索条件接口
  * 创建记录: 2014/06/17
  * 修改记录: 
  */
public interface RiskmanagerwaringSearchCond {

	/**
	 * 风险提示名称取得
	 * @return rwname 风险提示名称
	 */
	
	public String getRwname();

	/**
	 * 下发起者id取得
	 * @return nuserid 下发起者id
	 */
	
	public String getNuserid();

	/**
	 * 下发起者名字取得
	 * @return nusername 下发起者名字
	 */
	
	public String getNusername();

	/**
	 * 下发者机构名取得
	 * @return norgname 下发者机构名
	 */
	
	public String getNorgname();

	/**
	 * 下发者机构码取得
	 * @return norgid 下发者机构码
	 */
	
	public String getNorgid();

	/**
	 * 下发时间取得
	 * @return ntime 下发时间
	 */
	
	public String getNtime();
	
	/**
	 * 被下发用户用户ID取得
	 * @return userid 被下发用户用户ID
	 */
	public String getUserid();
	public String getUsername_s();

}
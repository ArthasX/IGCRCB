/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.fxk.model.condition;

/**
  * 概述: 风险管理提示接收者数据表检索条件接口
  * 功能描述: 风险管理提示接收者数据表检索条件接口
  * 创建记录: 2014/06/17
  * 修改记录: 
  */
public interface AcceptuserSearchCond {

	/**
	 * 接收人员部门、接收取得
	 * @return apuserid 接收人员部门、接收
	 */
	
	public String getApuserid();

	/**
	 * 接收者名字取得
	 * @return apusername 接收者名字
	 */
	
	public String getApusername();

	/**
	 * 接收机构码取得
	 * @return aporgid 接收机构码
	 */
	
	public String getAporgid();

	/**
	 * 接收机构名称取得
	 * @return aporgname 接收机构名称
	 */
	
	public String getAporgname();

	/**
	 * 风险提示主键取得
	 * @return rwid 风险提示主键
	 */
	
	public Integer getRwid();

}
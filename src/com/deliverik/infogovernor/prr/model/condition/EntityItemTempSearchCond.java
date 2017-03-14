/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.model.condition;

/**
  * 概述: 放置临时设备信息表检索条件接口
  * 功能描述: 放置临时设备信息表检索条件接口
  * 创建记录: 2013/08/29
  * 修改记录: 
  */
public interface EntityItemTempSearchCond {
	/**
	 * 对应的合同编号取得
	 *
	 * @return eitConNum 对应的合同编号
	 */
	public String getEitConNum();
	
	/**
	 * 流程id取得
	 *
	 * @return prid 流程id
	 */
	public Integer getPrid();
	
	/**
	 * 设备类型取得
	 *
	 * @return eitBClass 设备类型
	 */
	public String getEitBClass();
	
//	/**
//	 * 设备小类取得
//	 *
//	 * @return eitSClass 设备小类
//	 */
//	public String getEitSClass();
	
	/**
	 * 设备品牌取得
	 *
	 * @return eitBrand 设备品牌
	 */
	public String getEitBrand();
	/** 类别 -例如设备，软件，耗材，备件*/
	public  String getType();
	
}
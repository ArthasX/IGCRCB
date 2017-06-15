/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.room.model.condition;


/**
  * 概述: compareTemplate检索条件接口
  * 功能描述: compareTemplate检索条件接口
  * 创建记录: 2011/05/23
  * 修改记录: 
  */
public interface CompareTemplateSearchCond {

	/**
	 * 类别ID取得
	 *
	 * @return 类别ID
	 */
	public String getCategory();

	/**
	 * 类型取得
	 *
	 * @return 类型
	 */
	public String getType();

	/**
	 * 横向宽度取得
	 *
	 * @return 横向宽度
	 */
	public String getXwidth();

	/**
	 * 纵向宽度取得
	 *
	 * @return 纵向宽度
	 */
	public String getYwidth();

	/**
	 * 值取得
	 *
	 * @return 值
	 */
	public String getValue();
	
	/**
	 * 机柜类型取得
	 *
	 * @return 机柜类型
	 */
	public String getCabtype();
	
	/**
	 * 图例数组取得
	 *
	 * @return 图例数组
	 */
	public String[] getLegendArray();

	/**
	 * cteiid取得
	 *
	 * @return cteiid cteiid
	 */
	public String getCteiid();
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getCtid();
	/**
	 * netype取得
	 *
	 * @return netype netype
	 */
	public String getNetype();
	/**
	 * ctZoneId取得
	 *
	 * @return ctZoneId ctZoneId
	 */
	public String getCtZoneId();
	/**
	 * type不为zone和naf标识 取得
	 *
	 * @return notZoneAndNotNafFlag
	 */
	public String getNotZoneAndNotNafFlag();
	
	public String getCtfloorx();
	
	public String getCtfloory();
}
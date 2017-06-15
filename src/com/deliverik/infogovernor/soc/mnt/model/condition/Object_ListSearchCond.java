/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * 概述: 对象集合表检索条件接口
  * 功能描述: 对象集合表检索条件接口
  * 创建记录: 2012/05/11
  * 修改记录: 
  */
public interface Object_ListSearchCond {
	/**
	 * 序列号取得
	 *
	 * @return dataId 序列号
	 */
	public String getDataId() ;
	/**
	 * 组件类型取得
	 *
	 * @return object_Type 组件类型
	 */
	public String getObject_Type();
}
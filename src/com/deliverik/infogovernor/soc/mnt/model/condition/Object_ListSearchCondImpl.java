/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * 概述: 对象集合表检索条件实现
  * 功能描述: 对象集合表检索条件实现
  * 创建记录: 2012/05/11
  * 修改记录: 
  */
public class Object_ListSearchCondImpl implements
		Object_ListSearchCond {
	/** 序列号 */
	protected String dataId;

	/** 组件类型 */
	protected String object_Type;

	/**
	 * 序列号取得
	 *
	 * @return dataId 序列号
	 */
	public String getDataId() {
		return dataId;
	}

	/**
	 * 序列号设定
	 *
	 * @param dataId 序列号
	 */
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}

	/**
	 * 组件类型取得
	 *
	 * @return object_Type 组件类型
	 */
	public String getObject_Type() {
		return object_Type;
	}

	/**
	 * 组件类型设定
	 *
	 * @param object_Type 组件类型
	 */
	public void setObject_Type(String object_Type) {
		this.object_Type = object_Type;
	}
	
	
}
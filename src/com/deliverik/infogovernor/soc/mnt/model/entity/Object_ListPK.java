/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;


/**
 * 概述: 对象集合实体主键
 * 功能描述: 对象集合实体主键
 * 创建记录: 2011/05/24
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class Object_ListPK extends BasePK implements Serializable{
	
	/** 序列号 */
	protected String dataId;
	/** 组件类型 */
	protected String object_Type;
	
	/** 对象名字 */
	protected String object_Name;
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
	/**
	 * 对象名字取得
	 *
	 * @return object_Name 对象名字
	 */
	public String getObject_Name() {
		return object_Name;
	}
	/**
	 * 对象名字设定
	 *
	 * @param object_Name 对象名字
	 */
	public void setObject_Name(String object_Name) {
		this.object_Name = object_Name;
	}
	
	
}

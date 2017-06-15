/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.infogovernor.soc.mnt.model.Object_ListInfo;

/**
  * 概述: 对象集合表实体
  * 功能描述: 对象集合表实体
  * 创建记录: 2012/05/11
  * 修改记录: 
  */
@Entity
@IdClass(Object_ListPK.class)
@Table(name="collect_Object_List", schema="cst")
public class Object_ListTB implements Object_ListInfo {

	@Id
	/** 序列号 */
	protected String dataId;
	@Id
	/** 组件类型 */
	protected String object_Type;
	@Id
	/** 对象名字 */
	protected String object_Name;

	/**
	 * 序列号取得
	 *
	 * @return 序列号
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
	 * @return 组件类型
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
	 * @return 对象名字
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
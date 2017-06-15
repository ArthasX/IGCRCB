/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 容量对象表检索条件实现
  * 功能描述: 容量对象表检索条件实现
  * 创建记录: 2012/07/17
  * 修改记录: 2012/08/09 将CapacityObjectListSearchCondImpl表名改为SOC0423SearchCondImpl
  */
public class SOC0423SearchCondImpl implements
		SOC0423SearchCond {
	/**
	 * 名称eq
	 */
	private String name;
	/**
	 * 名称like 
	 */
	private String name_like;
	
	/**
	 * 对象类型
	 */
	private String objectType;
	
	/**
	 * 对象名称
	 */
	private String objectName;
	
	/**
	 * 对象名称取得
	 * @return
	 */
	public String getObjectName() {
		return objectName;
	}

	/**
	 * 对象名称设定
	 * @param objectName
	 */
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	/**
	 * 修改状态 0：未修改 1：已修改
	 */
	private Integer status;

	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	/**
	 * 名称like取得
	 *
	 * @return name_like 名称like
	 */
	public String getName_like() {
		return name_like;
	}

	/**
	 * 名称like设定
	 *
	 * @param name_like 名称like
	 */
	public void setName_like(String name_like) {
		this.name_like = name_like;
	}
}
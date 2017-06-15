/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: OA角色配置表检索条件实现
  * 功能描述: OA角色配置表检索条件实现
  * 创建记录: 2013/02/26
  * 修改记录: 
  */
public class IG001SearchCondImpl implements
		IG001SearchCond {

	/** 指定机构相关的角色类型 */
	protected String protype_eq;

	/**
	 * 指定机构相关的角色类型取得
	 *
	 * @return protype_eq 指定机构相关的角色类型
	 */
	public String getProtype_eq() {
		return protype_eq;
	}

	/**
	 * 指定机构相关的角色类型设定
	 *
	 * @param protype_eq 指定机构相关的角色类型
	 */
	public void setProtype_eq(String protype_eq) {
		this.protype_eq = protype_eq;
	}
	
}
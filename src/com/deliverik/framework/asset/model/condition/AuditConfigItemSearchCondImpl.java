/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.condition;

/**
  * 概述: 审计资产属性表检索条件实现
  * 功能描述: 审计资产属性表检索条件实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class AuditConfigItemSearchCondImpl implements
		AuditConfigItemSearchCond {
	
	/** 资产ID */
	protected Integer eiid;

	/**
	 * 资产ID取得
	 * @return 资产ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 资产ID设定
	 * @param eiid 资产ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
}
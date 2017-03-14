/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
  * 概述: knowLog检索条件实现
  * 功能描述: knowLog检索条件实现
  * 创建记录: 2011/05/30
  * 修改记录: 
  */
public class KnowLogSearchCondImpl implements
		KnowLogSearchCond {

	/** 知识ID */
	protected Integer klkid;

	/**
	 * 知识ID设定
	 * @param klkid 知识ID
	 */
	public void setKlkid(Integer klkid) {
		this.klkid = klkid;
	}

	/**
	 * 知识ID取得
	 * @return klkid 知识ID
	 */
	public Integer getKlkid() {
		return klkid;
	}
}
/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.model.condition;

/**
  * 概述: TOPOXML检索条件实现
  * 功能描述: TOPOXML检索条件实现
  * 创建记录: 2012/10/31
  * 修改记录: 
  */
public class TOPOXMLSearchCondImpl implements
		TOPOXMLSearchCond {
	/** 是否为缩略图 0:否  1:是*/
	protected String isellipsis;
	
	protected String userid;

	/**
	 * isellipsis取得
	 *
	 * @return isellipsis isellipsis
	 */
	public String getIsellipsis() {
		return isellipsis;
	}

	/**
	 * isellipsis设定
	 *
	 * @param isellipsis isellipsis
	 */
	public void setIsellipsis(String isellipsis) {
		this.isellipsis = isellipsis;
	}

	/**
	 * userid取得
	 *
	 * @return userid userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * userid设定
	 *
	 * @param userid userid
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
}
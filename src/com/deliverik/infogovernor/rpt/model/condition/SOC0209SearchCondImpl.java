/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 流程来源视图检索条件实现
  * 功能描述: 流程来源视图检索条件实现
  * 创建记录: 2011/11/24
  * 修改记录: 2012/08/09 将ProcessRecordInfoVWSearchCondImpl表名改为SOC0209SearchCondImpl
  */
public class SOC0209SearchCondImpl implements
		SOC0209SearchCond {
	

	/** 流程类型 */
	protected String prtype;
	
	/** 流程发起时间 */
	protected String propentime;
	
	/**
	 * 流程发起时间取得
	 *
	 * @return 流程发起时间
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * 流程发起时间设定
	 *
	 * @param propentime 流程发起时间
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}
	
	/**
	 * 流程类型取得
	 *
	 * @return 流程类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 流程类型设定
	 *
	 * @param prtype 流程类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

}
/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: 风险相关检索条件实现
  * 功能描述: 风险相关检索条件实现
  * 创建记录: 2014/08/16
  * 修改记录: 
  */
public class RehearseSearchCondImpl implements RehearseSearchCond {
	
	/** 问题整改流程中各领域名称 */
	protected String pivarvalue;
	
	/** 问题&&增改区分状态 */
	protected String prstatus;

	public String getPrstatus() {
		return prstatus;
	}

	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	public String getPivarvalue() {
		return pivarvalue;
	}

	public void setPivarvalue(String pivarvalue) {
		this.pivarvalue = pivarvalue;
	}


}
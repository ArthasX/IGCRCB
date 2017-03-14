/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.condition;


/**
  * 概述: soc0154检索条件实现
  * 功能描述: soc0154检索条件实现
  * 创建记录: 2013/12/29
  * 修改记录: 
  */
public class SOC0154SearchCondImpl implements
		SOC0154SearchCond {
	
	/** fromid */
	protected String fromid;

	/** isellipsis */
	protected String isellipsis;

	public String getFromid() {
		return fromid;
	}

	public void setFromid(String fromid) {
		this.fromid = fromid;
	}

	public String getIsellipsis() {
		return isellipsis;
	}

	public void setIsellipsis(String isellipsis) {
		this.isellipsis = isellipsis;
	}

	
	
}
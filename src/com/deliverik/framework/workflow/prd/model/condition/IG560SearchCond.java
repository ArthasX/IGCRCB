/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
 * 概述: 流程状态级私有表单默认值表检索条件接口 功能描述: 流程状态级私有表单默认值表检索条件接口 创建记录: 2015/02/07 修改记录:
 */
public interface IG560SearchCond {
	public String getPidid_q();

	public String getPsdid_q();

	public String getPidid_l();

	public String getPsdid_l();

	public String getUsedToAll();
	public String gettOrpsdid();
	/**  
	 * 获取psdid  
	 * @return psdid 
	 */
	public String getPsdid();
}
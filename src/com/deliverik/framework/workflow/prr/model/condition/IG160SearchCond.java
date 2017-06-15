/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>概述:流程相关人员汇总统计查询条件接口</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
public interface IG160SearchCond {

	/**
	 * 功能：机构ID取得
	 * @return orgid 机构ID
	 */
	public String getOrgid();
	
	/**
	 * 功能：结束日期取得
	 * @return propentime_to 结束日期
	 */
	public String getPropentime_to();
	
	/**
	 * 功能：开始日期取得
	 * @return propentime_from 开始日期
	 */
	public String getPropentime_from();
	
}

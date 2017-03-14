/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
 * 服务工单查询条件接口
 * @author masai@deliverik.com
 */
public interface IG692SearchCond {
	
	/**
	 * 查询时间开始
	 */
	public String getDate_from();
	
	/**
	 * 查询时间结束
	 */
	public String getDate_to();
	
	/**
	 * 资产查询
	 * @return
	 */
	public String getSfcid();
}

/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
 * 服务工单查询条件接口
 */
public interface IG933SearchCond {
	
	/**
	 * 服务工单ID取得
	 * 
	 * @return 服务工单ID
	 */
	public Integer getSfid();
	
	/**
	 * 服务工单编码取得
	 * 
	 * @return 服务工单编码
	 */
	public String getSfcode();
	
	/**
	 * 服务工单部门ID取得
	 * 
	 * @return 服务工单部门ID
	 */
	public String getSforgid();
	
	/**
	 * 服务工单记录人ID取得
	 * 
	 * @return 服务工单记录人ID
	 */
	public String getSfregisterid();
	
	/**
	 * 服务工单记录人NAME取得
	 * 
	 * @return 服务工单记录人NAME
	 */
	public String getSfregistername();

	/**
	 * 服务工单记录开始时间取得
	 * 
	 * @return 服务工单记录开始时间
	 */
	public String getSfinstimebegin();


	/**
	 * 服务工单记录结束时间取得
	 * 
	 * @return 服务工单记录结束时间
	 */
	public String getSfinstimeend();
	
	/**
	 * 服务工单记录时间取得
	 * 
	 * @return 服务工单记录时间
	 */
	public String getSftype();
	
	/**
	 * 服务工单记录名称取得
	 * 
	 * @return 服务工单记录名称
	 */
	public String getSftitle();
	
	
	/**
	 * 服务工单记录状态取得
	 * 
	 * @return 服务工单记录状态
	 */
	public String getSfstatus();
	
	/**
	 * 服务工单报告人NAME取得
	 * 
	 * @return 服务工单报告人NAME
	 */
	public String getSfreportname();
	
	/**
	 * 服务工单登记人NAME取得
	 * 
	 * @return 服务工单报告人NAME
	 */
	public String getSfusername();
}

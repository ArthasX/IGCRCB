package com.deliverik.framework.workflow.prr.model;

/**
 * <p>
 * 工作上报统计信息（平台保留）
 * </p>
 */

public interface IG019Info {
	
	/**
	 * 机构层次码取得（事件流程取上报人机构，服务请求流程取发起人机构）
	 * @return 机构层次码
	 */
	public String getOrgsyscoding();
	
	/**
	 * 机构名称取得
	 * @return 机构名称
	 */
	public String getOrgname();
	
	/**
	 * 事件流程个数取得
	 * @return 事件流程个数
	 */
	public Integer getIncident();
	
	/**
	 * 服务请求个数取得
	 * @return 服务请求个数
	 */
	public Integer getServiceRequest();
	
	/**
	 * 流程总数取得
	 * @return 流程总数
	 */
	public Integer getCount();
	
}

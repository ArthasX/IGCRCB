/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.model;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 部门服务统计实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface OrganizationServiceVWInfo {

	/**
	 * 部门名称取得
	 * @return orgname 部门名称
	 */
	public String getOrgname();

	/**
	 * incidentCount取得
	 * @return incidentCount incidentCount
	 */
	public Integer getIncidentCount();

	/**
	 * 服务请求数量取得
	 * @return serviceCount 服务请求数量
	 */
	public Integer getServiceCount();

	/**
	 * 总数取得
	 * @return totalCount 总数
	 */
	public Integer getTotalCount();
	
	/**
	 * 工单数量取得
	 * @return
	 */
	public Integer getGdCount();
}

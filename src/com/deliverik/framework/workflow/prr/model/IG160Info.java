/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model;

/**
 * <p>概述:流程相关人员汇总统计视图接口</p>
 * <p>功能描述：1.流程初始化</p>
 * <p>          2.流程查询</p>
 * <p>创建记录：</p>
 */
public interface IG160Info {
	
	/**
	 * 功能：用户ID取得
	 * @return ppuserid 用户ID
	 */
	public abstract String getPpuserid();

	/**
	 * 功能：用户名称取得
	 * @return ppusername 用户名称
	 */
	public abstract String getPpusername();
	
	/**
	 * 功能：机构ID取得
	 * @return orgid 机构ID
	 */
	public abstract String getOrgid();
	
	/**
	 * 功能：机构名称取得
	 * @return orgname 机构名称
	 */
	public abstract String getOrgname();

	/**
	 * 功能：事件取得
	 * @return incident 事件
	 */
	public abstract Integer getIncident();

	/**
	 * 功能：问题取得
	 * @return problem 问题
	 */
	public abstract Integer getProblem();

	/**
	 * 功能：变更取得
	 * @return change 变更
	 */
	public abstract Integer getChange();

	/**
	 * 功能：更新取得
	 * @return deployment 更新
	 */
	public abstract Integer getDeployment();

	/**
	 * 功能：工作取得
	 * @return work 工作
	 */
	public abstract Integer getWork();
	/**
	 * 功能：请求取得
	 * @return ask 请求  
	 */
	public abstract Integer getAsk();
}
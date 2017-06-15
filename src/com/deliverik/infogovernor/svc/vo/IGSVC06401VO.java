/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.vo;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 年度工作趋势统计vo
 * </p>
 * 
 * @author wanglei@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSVC06401VO extends BaseVO{
	
	/** 事件统计数量 */
	private String incidentnum;
	
	/** 问题统计数量 */
	private String problemnum;
	
	/** 变更统计数量 */
	private String changenum;
	
	/** 服务请求统计数量 */
	private String servicenum;
	
	/** 服务工单统计数量 */
	private String sfnum;

	/**
	 * 事件统计数量取得
	 * @return incidentnum 事件统计数量
	 */
	public String getIncidentnum() {
		return incidentnum;
	}
	
	/**
	 * 事件统计数量设定
	 * @param incidentnum 事件统计数量
	 */
	public void setIncidentnum(String incidentnum) {
		this.incidentnum = incidentnum;
	}

	/**
	 * 问题统计数量取得
	 * @return problemnum 问题统计数量
	 */
	public String getProblemnum() {
		return problemnum;
	}

	/**
	 * 问题统计数量设定
	 * @param problemnum 问题统计数量
	 */
	public void setProblemnum(String problemnum) {
		this.problemnum = problemnum;
	}

	/**
	 * 变更统计数量取得
	 * @return changenum 变更统计数量
	 */
	public String getChangenum() {
		return changenum;
	}

	/**
	 * 变更统计数量设定
	 * @param changenum 变更统计数量
	 */
	public void setChangenum(String changenum) {
		this.changenum = changenum;
	}

	/**
	 * 服务请求统计数量取得
	 * @return servicenum 服务请求统计数量
	 */
	public String getServicenum() {
		return servicenum;
	}
	
	/**
	 * 服务请求统计数量设定
	 * @param servicenum 服务请求统计数量
	 */
	public void setServicenum(String servicenum) {
		this.servicenum = servicenum;
	}

	/**
	 * 服务工单统计数量取得
	 * @return sfnum 服务工单统计数量
	 */
	public String getSfnum() {
		return sfnum;
	}
	
	/**
	 * 服务工单统计数量设定
	 * @param sfnum 服务工单统计数量
	 */
	public void setSfnum(String sfnum) {
		this.sfnum = sfnum;
	}
}

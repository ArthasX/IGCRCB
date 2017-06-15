/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.svc.model.AnnualTrendVWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 年度工作趋势统计实体
 * </p>
 * 
 * @author wanglei@deliverik.com
 * @version 1.0
 */
@Entity
public class AnnualTrendVW implements AnnualTrendVWInfo{

	/** 主键 */
	/** 日期 */
	@Id
	protected String propentime;
	
	/** 事件统计数量 */
	protected Integer incidentnum;
	
	/** 问题统计数量 */
	protected Integer problemnum;
	
	/** 变更统计数量 */
	protected Integer changenum;
	
	/** 服务请求统计数量 */
	protected Integer servicenum;
	
	/** 服务工单统计数量 */
	protected Integer sfnum;
	
	/**
	 * 事件统计数量取得
	 * @return incidentnum 事件统计数量
	 */
	public Integer getIncidentnum() {
		return incidentnum;
	}

	/**
	 * 事件统计数量设定
	 * @param incidentnum 事件统计数量
	 */
	public void setIncidentnum(Integer incidentnum) {
		this.incidentnum = incidentnum;
	}

	/**
	 * 问题统计数量取得
	 * @return problemnum 问题统计数量
	 */
	public Integer getProblemnum() {
		return problemnum;
	}

	/**
	 * 问题统计数量设定
	 * @param problemnum 问题统计数量
	 */
	public void setProblemnum(Integer problemnum) {
		this.problemnum = problemnum;
	}

	/**
	 * 变更统计数量取得
	 * @return changenum 变更统计数量
	 */
	public Integer getChangenum() {
		return changenum;
	}

	/**
	 * 变更统计数量设定
	 * @param changenum 变更统计数量
	 */
	public void setChangenum(Integer changenum) {
		this.changenum = changenum;
	}

	/**
	 * 服务请求统计数量取得
	 * @return servicenum 服务请求统计数量
	 */
	public Integer getServicenum() {
		return servicenum;
	}

	/**
	 * 服务请求统计数量设定
	 * @param servicenum 服务请求统计数量
	 */
	public void setServicenum(Integer servicenum) {
		this.servicenum = servicenum;
	}

	/**
	 * 服务工单统计数量取得
	 * @return sfnum 服务工单统计数量
	 */
	public Integer getSfnum() {
		return sfnum;
	}

	/**
	 * 服务工单统计数量设定
	 * @param sfnum 服务工单统计数量
	 */
	public void setSfnum(Integer sfnum) {
		this.sfnum = sfnum;
	}

	/**
	 * 日期取得
	 * @return propentime 日期
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * 日期设定
	 * @param propentime 日期
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}
	
}

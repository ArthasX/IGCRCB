/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.svc.model.OrganizationServiceVWInfo;

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
@Entity
public class OrganizationServiceVW implements OrganizationServiceVWInfo{

	/** 部门名称 */
	@Id
	protected String orgname;
	
	/** 事件数量 */
	protected Integer incidentCount;
	
	/** 服务请求数量 */
	protected Integer serviceCount;
	
	/** 工单数量 */
	protected Integer gdCount;
	
	/** 总数 */
	protected Integer totalCount;

	/**
	 * 部门名称取得
	 * @return orgname 部门名称
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 部门名称设定
	 * @param orgname 部门名称
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * 事件数量取得
	 * @return incidentCount 事件数量
	 */
	public Integer getIncidentCount() {
		return incidentCount;
	}

	/**
	 * 事件数量设定
	 * @param incidentCount 事件数量
	 */
	public void setIncidentCount(Integer incidentCount) {
		this.incidentCount = incidentCount;
	}

	/**
	 * 服务请求数量取得
	 * @return serviceCount 服务请求数量
	 */
	public Integer getServiceCount() {
		return serviceCount;
	}

	/**
	 * 服务请求数量设定
	 * @param serviceCount 服务请求数量
	 */
	public void setServiceCount(Integer serviceCount) {
		this.serviceCount = serviceCount;
	}

	/**
	 * 总数取得
	 * @return totalCount 总数
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * 总数设定
	 * @param totalCount 总数
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getGdCount() {
		return gdCount;
	}

	public void setGdCount(Integer gdCount) {
		this.gdCount = gdCount;
	}
	
	
}

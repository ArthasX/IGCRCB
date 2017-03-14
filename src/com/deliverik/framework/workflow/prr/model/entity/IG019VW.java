package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.workflow.prr.model.IG019Info;

/**
 * <p>
 * 工作上报统计信息实体（平台保留）
 * </p>
 */
@SuppressWarnings("serial")
@Entity
public class IG019VW implements Serializable,
	Cloneable, IG019Info {
	@Id
	/** 机构层次码（事件流程取上报人机构，服务请求流程取发起人机构） */
	protected String orgsyscoding;
	
	/** 机构名称 */
	protected String orgname;

	/** 事件流程个数 */
	protected Integer incident;

	/** 服务请求流程个数 */
	protected Integer serviceRequest;
	
	/** 流程总数 */
	protected Integer count;
	
	/**
	 * 机构层次码取得
	 * @return 机构层次码
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * 机构层次码设定
	 *
	 * @param orgsyscoding 机构层次码
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * 机构名称取得
	 * @return 机构名称
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 机构名称设定
	 *
	 * @param orgname 机构名称
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * 事件流程个数取得
	 * @return 事件流程个数
	 */
	public Integer getIncident() {
		return incident;
	}

	/**
	 * 事件流程个数设定
	 *
	 * @param incident 事件流程个数
	 */
	public void setIncident(Integer incident) {
		this.incident = incident;
	}

	/**
	 * 服务请求个数取得
	 * @return 服务请求个数
	 */
	public Integer getServiceRequest() {
		return serviceRequest;
	}

	/**
	 * 服务请求个数设定
	 *
	 * @param serviceRequest 服务请求个数
	 */
	public void setServiceRequest(Integer serviceRequest) {
		this.serviceRequest = serviceRequest;
	}

	/**
	 * 流程总数取得
	 * @return 流程总数
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * 流程总数设定
	 *
	 * @param count 流程总数
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * 比较两个对象是否相同
	 * @param obj
	 * @return 比较结果（true相同，false不同）
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof IG019VW))
			return false;
		IG019Info target = (IG019Info) obj;
		if (!(getOrgsyscoding() == target.getOrgsyscoding()))
			return false;

		return true;
	}

}

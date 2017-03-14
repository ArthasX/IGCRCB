/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.crc.model.IGCRC2001VWInfo;

/**	
 * 概述:年度工作查询伪视图
 * 创建记录：lianghongyang    2014-8-7 16:16:51	
 * 修改记录：null
 */	
@Entity
public class IGCRC2001VW implements IGCRC2001VWInfo{
	@Id
//	protected Integer id;
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
	
	/**查询年份*/
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

	public String getPropentime() {
		return propentime;
	}

	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	public Integer getIncidentnum() {
		return incidentnum;
	}

	public void setIncidentnum(Integer incidentnum) {
		this.incidentnum = incidentnum;
	}

	public Integer getProblemnum() {
		return problemnum;
	}

	public void setProblemnum(Integer problemnum) {
		this.problemnum = problemnum;
	}

	public Integer getChangenum() {
		return changenum;
	}

	public void setChangenum(Integer changenum) {
		this.changenum = changenum;
	}

	public Integer getServicenum() {
		return servicenum;
	}

	public void setServicenum(Integer servicenum) {
		this.servicenum = servicenum;
	}

	public Integer getSfnum() {
		return sfnum;
	}

	public void setSfnum(Integer sfnum) {
		this.sfnum = sfnum;
	}
}

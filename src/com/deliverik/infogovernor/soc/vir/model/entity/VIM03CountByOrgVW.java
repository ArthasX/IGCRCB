/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.model.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Transient;

import com.deliverik.infogovernor.soc.vir.model.VIM03CountByOrgVWInfo;
/**
 * 概述:虚拟资源统计视图实体(按机构)
 * 功能描述:虚拟资源统计视图实体(按机构) 
 * 创建记录: 2014/02/19
 * 修改记录: 
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class VIM03CountByOrgVW implements Serializable, Cloneable,
		VIM03CountByOrgVWInfo {

	/**机构名  */
	protected String orgname;
	/**机构码  */
	@Id
	protected String orgsyscoding;
	/**虚机数量  */
	protected String count;
	/**CPU总数 */
	protected Integer totalcpu;
	/**内存总数 */
	protected Integer totalmem;
	/**硬盘总数 */
	protected Integer totaldisk;
	
	/** 总费用 */
	@Transient
	protected Integer cost;
	
	public Integer getCost() {
		return cost;
	}
	
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
	/**
	 * 机构名取得
	 * @return orgname 机构名
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 机构名设定
	 * @param orgname 机构名
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * 机构码取得
	 * @return orgsyscoding 机构码
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * 机构码设定
	 * @param orgsyscoding 机构码
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * 虚机数量取得
	 * @return count 虚机数量
	 */
	public String getCount() {
		return count;
	}

	/**
	 * 虚机数量设定
	 * @param count 虚机数量
	 */
	public void setCount(String count) {
		this.count = count;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return orgsyscoding;
	}

	public Integer getTotalcpu() {
		return totalcpu;
	}

	public void setTotalcpu(Integer totalcpu) {
		this.totalcpu = totalcpu;
	}

	public Integer getTotalmem() {
		return totalmem;
	}

	public void setTotalmem(Integer totalmem) {
		this.totalmem = totalmem;
	}

	public Integer getTotaldisk() {
		return totaldisk;
	}

	public void setTotaldisk(Integer totaldisk) {
		this.totaldisk = totaldisk;
	}
	
	
}

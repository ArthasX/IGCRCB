/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.model.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Transient;

import com.deliverik.infogovernor.soc.vir.model.VIM03CountByProjVWInfo;
/**
 * 概述:虚拟资源统计视图实体(按项目)
 * 功能描述:虚拟资源统计视图实体(按项目) 
 * 创建记录: 2014/02/19
 * 修改记录: 
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class VIM03CountByProjVW implements Serializable, Cloneable,
		VIM03CountByProjVWInfo {

	/**项目名  */
	protected String pname;
	/**项目ID  */
	@Id
	protected String pid;
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
	 * 项目名取得
	 * @return pname 项目名
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * 项目名设定
	 * @param pname 项目名
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * 项目ID取得
	 * @return pid 项目ID
	 */
	public String getPid() {
		return pid;
	}

	/**
	 * 项目ID设定
	 * @param pid 项目ID
	 */
	public void setPid(String pid) {
		this.pid = pid;
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
		return pid;
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

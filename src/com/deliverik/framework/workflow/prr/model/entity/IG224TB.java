/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.IG224Info;

/**
 * 流程状态日志实体接口
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG224")
public class IG224TB extends BaseEntity implements Serializable, Cloneable, IG224Info {

	/** 流程状态日志ID */
	@Id
	@TableGenerator(
		    name="IG224_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG224_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG224_TABLE_GENERATOR")
	protected Integer rslid;
	
	/** 流程ID */
	protected Integer prid;
	
	/** 自定义流程类型ID */
	protected String prpdid;
	
	/** 流程类型 */
	protected String prtype;

	/** 流程状态 */
	protected String prstatus;
	
	/** 开始时间 */
	@Temporal(value = TemporalType.TIMESTAMP)
	protected Date rslOpenTime;
	
	/** 结束时间 */
	@Temporal(value = TemporalType.TIMESTAMP)
	protected Date rslCloseTime;
	
	/** 是否超时 */
	protected String rslExpect;
	
	/** 流程状态定义ID */
	protected String psdid;
	
	/** 上级流程状态定义ID */
	protected String ppsdid;
	
	/** 虚拟节点状态 */
	protected String virtualstatus;
	
	/** 动态分支编号 */
	protected Integer psdnum;
	
	/** 挂起开始时间 */
	@Temporal(value = TemporalType.TIMESTAMP)
	protected Date pendOpenTime;
	
	/** 挂起结束时间 */
	@Temporal(value = TemporalType.TIMESTAMP)
	protected Date pendCloseTime;
	
	/** 是否挂起 */
	protected String pend;
	
	/** 引发挂起的状态ID */
	protected String pendpsdid;
	
	/** 引发挂起的状态ID对应的NUM */
	protected Integer pendpsdnum;
	
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return rslid;
	}

	/**
	 * 流程状态日志ID取得
	 * @return 流程状态日志ID
	 */
	public Integer getRslid() {
		return rslid;
	}

	/**
	 * 流程状态日志ID设定
	 * @param rslid 流程状态日志ID
	 */
	public void setRslid(Integer rslid) {
		this.rslid = rslid;
	}

	/**
	 * 流程ID取得
	 * @return 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 * @param prid 流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	/**
	 * 自定义流程类型ID取得
	 * @return 自定义流程类型ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * 自定义流程类型ID设定
	 * @param prpdid 自定义流程类型ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * 流程类型取得
	 * @return 流程类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 流程类型设定
	 * @param prtype 流程类型设定
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 流程状态取得
	 * @return 流程状态
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 流程状态设定
	 * @param prstatus 流程状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}
	
	/**
	 * 开始时间取得
	 * @return 开始时间
	 */
	public Date getRslOpenTime() {
		return rslOpenTime;
	}

	/**
	 * 开始时间设定
	 * @param rslOpenTime 开始时间
	 */
	public void setRslOpenTime(Date rslOpenTime) {
		this.rslOpenTime = rslOpenTime;
	}

	/**
	 * 结束时间取得
	 * @return 结束时间
	 */
	public Date getRslCloseTime() {
		return rslCloseTime;
	}

	/**
	 * 结束时间设定
	 * @param rslCloseTime 结束时间
	 */
	public void setRslCloseTime(Date rslCloseTime) {
		this.rslCloseTime = rslCloseTime;
	}

	/**
	 * 是否超时取得
	 * @return 是否超时
	 */
	public String getRslExpect() {
		return rslExpect;
	}

	/**
	 * 是否超时设定
	 * @param rslExpect 是否超时
	 */
	public void setRslExpect(String rslExpect) {
		this.rslExpect = rslExpect;
	}

	/**
	 * 流程状态定义ID取得
	 * @return 流程状态定义ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程状态定义ID设定
	 * @param psdid 流程状态定义ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 上级流程状态定义ID取得
	 * @return 上级流程状态定义ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * 上级流程状态定义ID设定
	 * @param ppsdid 上级流程状态定义ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}

	/**
	 * 虚拟节点状态取得
	 * @return 虚拟节点状态
	 */
	public String getVirtualstatus() {
		return virtualstatus;
	}

	/**
	 * 虚拟节点状态设定
	 * @param virtualstatus 虚拟节点状态
	 */
	public void setVirtualstatus(String virtualstatus) {
		this.virtualstatus = virtualstatus;
	}

	/**
	 * 动态分支编号取得
	 * @return 动态分支编号
	 */
	public Integer getPsdnum() {
		return psdnum;
	}

	/**
	 * 动态分支编号设定
	 * @param psdnum 动态分支编号
	 */
	public void setPsdnum(Integer psdnum) {
		this.psdnum = psdnum;
	}

	/**
	 * @return the pendOpenTime
	 */
	public Date getPendOpenTime() {
		return pendOpenTime;
	}

	/**
	 * @param pendOpenTime the pendOpenTime to set
	 */
	public void setPendOpenTime(Date pendOpenTime) {
		this.pendOpenTime = pendOpenTime;
	}

	/**
	 * @return the pendCloseTime
	 */
	public Date getPendCloseTime() {
		return pendCloseTime;
	}

	/**
	 * @param pendCloseTime the pendCloseTime to set
	 */
	public void setPendCloseTime(Date pendCloseTime) {
		this.pendCloseTime = pendCloseTime;
	}

	/**
	 * @return the pend
	 */
	public String getPend() {
		return pend;
	}

	/**
	 * @param pend the pend to set
	 */
	public void setPend(String pend) {
		this.pend = pend;
	}

	/**
	 * @return the pendpsdid
	 */
	public String getPendpsdid() {
		return pendpsdid;
	}

	/**
	 * @param pendpsdid the pendpsdid to set
	 */
	public void setPendpsdid(String pendpsdid) {
		this.pendpsdid = pendpsdid;
	}

	/**
	 * @return the pendpsdnum
	 */
	public Integer getPendpsdnum() {
		return pendpsdnum;
	}

	/**
	 * @param pendpsdnum the pendpsdnum to set
	 */
	public void setPendpsdnum(Integer pendpsdnum) {
		this.pendpsdnum = pendpsdnum;
	}
	
}

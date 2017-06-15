/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.dwp.model.IGDWP0001Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IGDWP0001")
public class IGDWP0001TB extends BaseEntity implements IGDWP0001Info{
	
	/** 主键 */
	@Id
	@TableGenerator(
		    name="IGDWP0001_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IGDWP0001_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IGDWP0001_TABLE_GENERATOR")
	protected Integer id;
	
	/** 计划名称 */
	protected String pname;
	
	/** 计划描述 */
	protected String pdesc;
	
	/** 发起人ID */
	protected String puserid;
	
	/** 发起人姓名 */
	protected String pusername;
	
	/** 流程定义ID */
	protected String pdid;
	
	/** 流程名称 */
	protected String pdname;
	
	/** 短信内容 */
	protected String smscontent;
	
	/** 开始时间 */
	protected String startdate;
	
	/** 结束时间 */
	protected String enddate;
	
	/** 计划模式 */
	protected String pmode;
	
	/** 计划类型 */
	protected String ptype;
	
	/** 计划执行时间：小时 */
	protected String phour;
	
	/** 计划执行时间：分钟 */
	protected String pminute;
	
	/** 是否添加JOB */
	protected String isAddJob;

	/**
	 * 主键取得
	 * @return id 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 主键设定
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 计划名称取得
	 * @return pname 计划名称
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * 计划名称设定
	 * @param pname 计划名称
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * 计划描述取得
	 * @return pdesc 计划描述
	 */
	public String getPdesc() {
		return pdesc;
	}

	/**
	 * 计划描述设定
	 * @param pdesc 计划描述
	 */
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	/**
	 * 发起人ID取得
	 * @return puserid 发起人ID
	 */
	public String getPuserid() {
		return puserid;
	}

	/**
	 * 发起人ID设定
	 * @param puserid 发起人ID
	 */
	public void setPuserid(String puserid) {
		this.puserid = puserid;
	}

	/**
	 * 发起人姓名取得
	 * @return pusername 发起人姓名
	 */
	public String getPusername() {
		return pusername;
	}

	/**
	 * 发起人姓名设定
	 * @param pusername 发起人姓名
	 */
	public void setPusername(String pusername) {
		this.pusername = pusername;
	}

	/**
	 * 流程定义ID取得
	 * @return pdid 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程名称取得
	 * @return pdname 流程名称
	 */
	public String getPdname() {
		return pdname;
	}

	/**
	 * 流程名称设定
	 * @param pdname 流程名称
	 */
	public void setPdname(String pdname) {
		this.pdname = pdname;
	}

	/**
	 * 短信内容取得
	 * @return smscontent 短信内容
	 */
	public String getSmscontent() {
		return smscontent;
	}

	/**
	 * 短信内容设定
	 * @param smscontent 短信内容
	 */
	public void setSmscontent(String smscontent) {
		this.smscontent = smscontent;
	}

	/**
	 * 开始时间取得
	 * @return startdate 开始时间
	 */
	public String getStartdate() {
		return startdate;
	}

	/**
	 * 开始时间设定
	 * @param startdate 开始时间
	 */
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	/**
	 * 结束时间取得
	 * @return enddate 结束时间
	 */
	public String getEnddate() {
		return enddate;
	}

	/**
	 * 结束时间设定
	 * @param enddate 结束时间
	 */
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	/**
	 * 计划模式取得
	 * @return pmode 计划模式
	 */
	public String getPmode() {
		return pmode;
	}

	/**
	 * 计划模式设定
	 * @param pmode 计划模式
	 */
	public void setPmode(String pmode) {
		this.pmode = pmode;
	}

	/**
	 * 计划类型取得
	 * @return ptype 计划类型
	 */
	public String getPtype() {
		return ptype;
	}

	/**
	 * 计划类型设定
	 * @param ptype 计划类型
	 */
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	/**
	 * 计划执行时间：小时取得
	 * @return hour 计划执行时间：小时
	 */
	public String getPhour() {
		return phour;
	}

	/**
	 * 计划执行时间：小时设定
	 * @param hour 计划执行时间：小时
	 */
	public void setPhour(String phour) {
		this.phour = phour;
	}

	/**
	 * 计划执行时间：分钟取得
	 * @return pminute 计划执行时间：分钟
	 */
	public String getPminute() {
		return pminute;
	}

	/**
	 * 计划执行时间：分钟设定
	 * @param pminute 计划执行时间：分钟
	 */
	public void setPminute(String pminute) {
		this.pminute = pminute;
	}

	/**
	 * 是否添加JOB取得
	 * @return isAddJob 是否添加JOB
	 */
	public String getIsAddJob() {
		return isAddJob;
	}

	/**
	 * 是否添加JOB设定
	 * @param isAddJob 是否添加JOB
	 */
	public void setIsAddJob(String isAddJob) {
		this.isAddJob = isAddJob;
	}

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Serializable getPK() {
		return this.id;
	}

}

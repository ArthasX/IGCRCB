/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.csebank.lom.model.GuestRecption;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 *  接待客人查询实体接口
 * 
 * @author songhaiyang@deliverik.com
 * 
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class GuestRecptionVW  implements Serializable, Cloneable, GuestRecption {
	
	/** 接待客人ID */
	@Id
	protected Integer rgid;
	
	/** 接待工作ID */
	public Integer rid;
	
	/** 接待工作名称 */
	protected String rname;
	
	/** 主要申请部门层次码 */
	protected String rapporgid;
	
	/** 接待结束日期 */
	protected String retime;
	
	/** 接待开始日期 */
	protected String rstime;
	
	/**  接待客人单位 */
	protected String rgunit;
	
	/** 接待客人姓名 */
	protected String rgname;
	
	/** 状态（1进行中，2结束） */
	protected String rstatus;

	/** 机构信息实体 */
	@OneToOne
	@JoinColumn(name="rapporgid", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB organizationTB;

	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return rgid;
	}

	/**
	 * 接待客人ID取得
	 * @return 接待工作ID
	 */
	public Integer getRgid() {
		return rgid;
	}

	/**
	 * 接待客人ID设定
	 * @param rgid 接待客人ID
	 */
	public void setRgid(Integer rgid) {
		this.rgid = rgid;
	}
	
	/**
	 * 接待工作ID取得
	 * @return 接待工作ID
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * 接待工作ID设定
	 * @param rgid 接待工作ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	/**
	 * 接待工作名称
	 * @return 接待工作名称
	 */
	public String getRname() {
		return rname;
	}

	/**
	 * 接待工作名称
	 * @param rname 接待工作名称
	 */
	public void setRname(String rname) {
		this.rname = rname;
	}

	/**
	 * 接待结束日期 
	 * @return 接待结束日期 
	 */
	public String getRetime() {
		return retime;
	}

	/**
	 * 接待结束日期 
	 * @param retime 接待结束日期 
	 */
	public void setRetime(String retime) {
		this.retime = retime;
	}

	/**
	 * 接待开始日期 
	 * @return 接待开始日期 
	 */
	public String getRstime() {
		return rstime;
	}

	/**
	 * 接待开始日期
	 * @param rstime 接待开始日期
	 */
	public void setRstime(String rstime) {
		this.rstime = rstime;
	}

	/**
	 * 主要申请部门层次码
	 * @return 主要申请部门层次码
	 */
	public String getRapporgid() {
		return rapporgid;
	}

	/**
	 * 主要申请部门层次码
	 * @param rapporgid 主要申请部门层次码
	 */
	public void setRapporgid(String rapporgid) {
		this.rapporgid = rapporgid;
	}

	/**
	 * 接待客人单位取得
	 * @param rgunit 接待客人单位
	 */
	public String getRgunit() {
		return rgunit;
	}
	/**
	 * 接待客人单位设定
	 * @param rgunit 接待客人单位
	 */
	public void setRgunit(String rgunit) {
		this.rgunit = rgunit;
	}

	/**
	 * 接待客人姓名取得
	 * @param rapporgid 主接待客人姓名
	 */
	public String getRgname() {
		return rgname;
	}
	
	/**
	 * 接待客人姓名设定
	 * @param rgname 接待客人姓名
	 */
	public void setRgname(String rgname) {
		this.rgname = rgname;
	}
	
	/**
	 * 状态
	 * @return 状态
	 */
	public String getRstatus() {
		return rstatus;
	}

	/**
	 * 状态
	 * @param rstatus 状态
	 */
	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}
	
	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}
	
	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}
}

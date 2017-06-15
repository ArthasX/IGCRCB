/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.model.entity;

import java.io.Serializable;


import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.sym.model.RoleReport;

/**
 * 报表授权信息实体
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="RoleReport")
public class RoleReportTB extends BaseEntity implements Serializable, Cloneable, RoleReport {

	/** 主键 */
	@Id
	@TableGenerator(
		    name="ROLEREPORT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="ROLEREPORT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="ROLEREPORT_TABLE_GENERATOR")
	protected Integer rrid;

	/**
	 * 角色ID
	 */
	
	protected Integer roleid;
	
	/**
	 * 报表ID
	 */
	
	protected Integer rfdid;
	
	protected String rrperm;
	
	protected String rrdesc;
	
	/**
	 * 报表信息
	 */
	@ManyToOne
	@JoinColumn(name="rfdid", referencedColumnName="rfdid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected ReportFileDefinitionTB reportFileDefinitionTB;
	
	
	public Integer getRrid() {
		return rrid;
	}


	public void setRrid(Integer rrid) {
		this.rrid = rrid;
	}


	/**
	 * 获取主键
	 * @return 
	 */
	public Serializable getPK() {
		return rrid;
	}


	public Integer getRoleid() {
		return roleid;
	}


	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}


	public Integer getRfdid() {
		return rfdid;
	}


	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}


	public String getRrperm() {
		return rrperm;
	}


	public void setRrperm(String rrperm) {
		this.rrperm = rrperm;
	}


	public String getRrdesc() {
		return rrdesc;
	}


	public void setRrdesc(String rrdesc) {
		this.rrdesc = rrdesc;
	}


	public ReportFileDefinitionTB getReportFileDefinitionTB() {
		return reportFileDefinitionTB;
	}


	public void setReportFileDefinitionTB(
			ReportFileDefinitionTB reportFileDefinitionTB) {
		this.reportFileDefinitionTB = reportFileDefinitionTB;
	}


	
	
	
	
}

/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.csebank.lom.model.Recption;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 * 接待管理实体
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="Recption")
public class RecptionTB extends BaseEntity implements Serializable, Cloneable, Recption {
	
	/** 接待管理ID */
	@Id
	@TableGenerator(
		    name="RECPTION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="RECPTION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RECPTION_TABLE_GENERATOR")
	protected Integer rid;
	
	/** 接待工作名称 */
	protected String rname;
	
	/** 主要申请部门层次码 */
	protected String rapporgid;
	
	/** 接待结束日期 */
	protected String retime;
	
	/** 接待开始日期 */
	protected String rstime;
	
	/** 接待人数规模 */
	protected String rscale;
	
	/** 接待标准 */
	protected String rstandard;
	
	/** 其他参与部门名称 */
	protected String rpporg;
	
	/** 接待内容描述 */
	protected String rdescription;
	
	/** 登记日期 */
	protected String rdate;
	
	/** 状态（1进行中，2结束） */
	protected String rstatus;
	
	/** 住宿费用 */
	protected BigDecimal rlodgecost;

	/** 住宿标准 */
	protected String rlodgestandard;
	
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
		return rid;
	}
	
	/**
	 * 接待管理ID
	 * @return 接待管理ID
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * 接待管理ID
	 * @param rid 接待管理ID
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
	 * 接待人数规模
	 * @return 接待人数规模
	 */
	public String getRscale() {
		return rscale;
	}

	/**
	 * 接待人数规模
	 * @param rscale 接待人数规模
	 */
	public void setRscale(String rscale) {
		this.rscale = rscale;
	}

	/**
	 * 接待标准
	 * @return 接待标准
	 */
	public String getRstandard() {
		return rstandard;
	}

	/**
	 * 接待标准
	 * @param rstandard接待标准
	 */
	public void setRstandard(String rstandard) {
		this.rstandard = rstandard;
	}

	/**
	 * 其他参与部门名称
	 * @return 其他参与部门名称
	 */
	public String getRpporg() {
		return rpporg;
	}

	/**
	 * 其他参与部门名称
	 * @param rpporg 其他参与部门名称
	 */
	public void setRpporg(String rpporg) {
		this.rpporg = rpporg;
	}

	/**
	 * 接待内容描述
	 * @return 接待内容描述
	 */
	public String getRdescription() {
		return rdescription;
	}

	/**
	 * 接待内容描述
	 * @param rdescription 接待内容描述
	 */
	public void setRdescription(String rdescription) {
		this.rdescription = rdescription;
	}

	/**
	 * 登记日期
	 * @return 登记日期
	 */
	public String getRdate() {
		return rdate;
	}

	/**
	 * 登记日期
	 * @param rdate 登记日期
	 */
	public void setRdate(String rdate) {
		this.rdate = rdate;
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
	
	/**
	 * 住宿费用
	 * @return 住宿费用
	 */
	public BigDecimal getRlodgecost() {
		return rlodgecost;
	}
	
	/**
	 * 住宿费用
	 * @param rlodgecost 住宿费用
	 */
	public void setRlodgecost(BigDecimal rlodgecost) {
		this.rlodgecost = rlodgecost;
	}
	
	/**
	 * 住宿标准
	 * @return 住宿标准
	 */
	public String getRlodgestandard() {
		return rlodgestandard;
	}
	
	/**
	 * 住宿标准
	 * @param rlodgestandard 住宿标准
	 */
	public void setRlodgestandard(String rlodgestandard) {
		this.rlodgestandard = rlodgestandard;
	}
}

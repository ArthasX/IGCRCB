/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import java.math.BigDecimal;

import com.csebank.lom.model.Recption;
import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 * 接待工作登记变更Form
 *
 */
public class IGLOM0101Form extends BaseForm  implements Recption {


	private static final long serialVersionUID = 1L;

	/** 接待管理ID */
	protected Integer rid;
	
	/** 接待工作名称 */
	protected String rname;
	
	/** 主要申请部门层次码 */
	protected String rapporgid;
	
	/** 主要申请部门名称 */
	protected String rapporgname;
	
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

	/**
	 * 页面标题显示标志0-新增,1-变更
	 */
	protected String mode = "0";

	
	/** 机构信息实体 */
	protected OrganizationTB organizationTB;

	/** 住宿费用 */
	protected BigDecimal rlodgecost;

	/** 住宿标准 */
	protected String rlodgestandard;
	

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


	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 机构信息实体
	 * @return 机构信息实体
	 */
	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}

	/**
	 * 机构信息实体
	 * @param organizationTB 机构信息实体
	 */
	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}

	/**
	 * 页面标题显示取得
	 * @return 页面标题显示
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 页面标题显示设定
	 * @param mode 页面标题显示
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * 主要申请部门名称取得
	 * @return 主要申请部门名称
	 */
	public String getRapporgname() {
		return rapporgname;
	}

	/**
	 * 主要申请部门名称设定
	 * @param rapporgname 主要申请部门名称
	 */
	public void setRapporgname(String rapporgname) {
		this.rapporgname = rapporgname;
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

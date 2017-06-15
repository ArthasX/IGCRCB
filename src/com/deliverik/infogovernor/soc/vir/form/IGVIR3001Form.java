/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: vCloud虚拟化资源申请发起form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR3001Form extends BaseForm{

	/** vCloud组织名称 */
	protected String vorg;
	
	/** vCloud链接ID */
	protected Integer vcid;
	
	/** vCloud名称 */
	protected String vcname;
	
	/** 机构码 */
	protected String orgid;
	
	/** 机构名称 */
	protected String orgname;
	
	/** 目录名称 */
	protected String catalog;
	
	/** 项目名称 */
    protected String projectName;

    /** 期望部署时间 */
    protected String expectDeployTime;

    /** 项目到期时间 */
    protected String projectExpireTime;

    /** 项目类别 */
    protected String projectType;

    /** 项目说明 */
    protected String projectDesc;

    /** 申请说明 */
    protected String projectApplyReason;

	/** 虚机模板  */
	protected String templates[];
	
	/** 虚机名称 */
	protected String vmnames[];
	
	/** 虚机cpu个数 */
	protected String vmcpus[];
	
	/** 虚机内存大小 */
	protected String vmmems[];
	
	/** 虚拟硬盘大小 */
	protected String vmdisks[];

	/** 申请时间 */
    protected String applyTime[];
    
    /** 到期时间 */
    protected String expiryTime[];
    
    /** 选择的项目id */
    protected Integer hpid;

	/**
	 * vCloud组织名称取得
	 * @return vorg vCloud组织名称
	 */
	public String getVorg() {
		return vorg;
	}

	/**
	 * vCloud组织名称设定
	 * @param vorg vCloud组织名称
	 */
	public void setVorg(String vorg) {
		this.vorg = vorg;
	}

	/**
	 * vCloud链接ID取得
	 * @return vcid vCloud链接ID
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * vCloud链接ID设定
	 * @param vcid vCloud链接ID
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * vCloud名称取得
	 * @return vcname vCloud名称
	 */
	public String getVcname() {
		return vcname;
	}

	/**
	 * vCloud名称设定
	 * @param vcname vCloud名称
	 */
	public void setVcname(String vcname) {
		this.vcname = vcname;
	}

	/**
	 * 机构码取得
	 * @return orgid 机构码
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * 机构码设定
	 * @param orgid 机构码
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * 机构名称取得
	 * @return orgname 机构名称
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 机构名称设定
	 * @param orgname 机构名称
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * 目录名称取得
	 * @return catalog 目录名称
	 */
	public String getCatalog() {
		return catalog;
	}

	/**
	 * 目录名称设定
	 * @param catalog 目录名称
	 */
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	/**
	 * 项目名称取得
	 * @return projectName 项目名称
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * 项目名称设定
	 * @param projectName 项目名称
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * 期望部署时间取得
	 * @return expectDeployTime 期望部署时间
	 */
	public String getExpectDeployTime() {
		return expectDeployTime;
	}

	/**
	 * 期望部署时间设定
	 * @param expectDeployTime 期望部署时间
	 */
	public void setExpectDeployTime(String expectDeployTime) {
		this.expectDeployTime = expectDeployTime;
	}

	/**
	 * 项目到期时间取得
	 * @return projectExpireTime 项目到期时间
	 */
	public String getProjectExpireTime() {
		return projectExpireTime;
	}

	/**
	 * 项目到期时间设定
	 * @param projectExpireTime 项目到期时间
	 */
	public void setProjectExpireTime(String projectExpireTime) {
		this.projectExpireTime = projectExpireTime;
	}

	/**
	 * 项目类别取得
	 * @return projectType 项目类别
	 */
	public String getProjectType() {
		return projectType;
	}

	/**
	 * 项目类别设定
	 * @param projectType 项目类别
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	/**
	 * 项目说明取得
	 * @return projectDesc 项目说明
	 */
	public String getProjectDesc() {
		return projectDesc;
	}

	/**
	 * 项目说明设定
	 * @param projectDesc 项目说明
	 */
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	/**
	 * 申请说明取得
	 * @return projectApplyReason 申请说明
	 */
	public String getProjectApplyReason() {
		return projectApplyReason;
	}

	/**
	 * 申请说明设定
	 * @param projectApplyReason 申请说明
	 */
	public void setProjectApplyReason(String projectApplyReason) {
		this.projectApplyReason = projectApplyReason;
	}

	/**
	 * 虚机模板取得
	 * @return templates 虚机模板
	 */
	public String[] getTemplates() {
		return templates;
	}

	/**
	 * 虚机模板设定
	 * @param templates 虚机模板
	 */
	public void setTemplates(String[] templates) {
		this.templates = templates;
	}

	/**
	 * 虚机名称取得
	 * @return vmnames 虚机名称
	 */
	public String[] getVmnames() {
		return vmnames;
	}

	/**
	 * 虚机名称设定
	 * @param vmnames 虚机名称
	 */
	public void setVmnames(String[] vmnames) {
		this.vmnames = vmnames;
	}

	/**
	 * 虚机cpu个数取得
	 * @return vmcpus 虚机cpu个数
	 */
	public String[] getVmcpus() {
		return vmcpus;
	}

	/**
	 * 虚机cpu个数设定
	 * @param vmcpus 虚机cpu个数
	 */
	public void setVmcpus(String[] vmcpus) {
		this.vmcpus = vmcpus;
	}

	/**
	 * 虚机内存大小取得
	 * @return vmmems 虚机内存大小
	 */
	public String[] getVmmems() {
		return vmmems;
	}

	/**
	 * 虚机内存大小设定
	 * @param vmmems 虚机内存大小
	 */
	public void setVmmems(String[] vmmems) {
		this.vmmems = vmmems;
	}

	/**
	 * 虚拟硬盘大小取得
	 * @return vmdisks 虚拟硬盘大小
	 */
	public String[] getVmdisks() {
		return vmdisks;
	}

	/**
	 * 虚拟硬盘大小设定
	 * @param vmdisks 虚拟硬盘大小
	 */
	public void setVmdisks(String[] vmdisks) {
		this.vmdisks = vmdisks;
	}

	/**
	 * 申请时间取得
	 * @return applyTime 申请时间
	 */
	public String[] getApplyTime() {
		return applyTime;
	}

	/**
	 * 申请时间设定
	 * @param applyTime 申请时间
	 */
	public void setApplyTime(String[] applyTime) {
		this.applyTime = applyTime;
	}

	/**
	 * 到期时间取得
	 * @return expiryTime 到期时间
	 */
	public String[] getExpiryTime() {
		return expiryTime;
	}

	/**
	 * 到期时间设定
	 * @param expiryTime 到期时间
	 */
	public void setExpiryTime(String[] expiryTime) {
		this.expiryTime = expiryTime;
	}

	/**
	 * 选择的项目id取得
	 * @return hpid 选择的项目id
	 */
	public Integer getHpid() {
		return hpid;
	}

	/**
	 * 选择的项目id设定
	 * @param hpid 选择的项目id
	 */
	public void setHpid(Integer hpid) {
		this.hpid = hpid;
	}
}

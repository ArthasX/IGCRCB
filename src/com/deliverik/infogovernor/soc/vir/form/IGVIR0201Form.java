/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 资源申请画面FORM
 * 
 */
public class IGVIR0201Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
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
     * 获取项目名称
     * @return 项目名称 
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置项目名称
     * @param projectName 项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 获取期望部署时间
     * @return 期望部署时间 
     */
    public String getExpectDeployTime() {
        return expectDeployTime;
    }

    /**
     * 设置期望部署时间
     * @param expectDeployTime 期望部署时间
     */
    public void setExpectDeployTime(String expectDeployTime) {
        this.expectDeployTime = expectDeployTime;
    }

    /**
     * 获取项目到期时间
     * @return 项目到期时间 
     */
    public String getProjectExpireTime() {
        return projectExpireTime;
    }

    /**
     * 设置项目到期时间
     * @param projectExpireTime 项目到期时间
     */
    public void setProjectExpireTime(String projectExpireTime) {
        this.projectExpireTime = projectExpireTime;
    }

    /**
     * 获取项目类别
     * @return 项目类别 
     */
    public String getProjectType() {
        return projectType;
    }

    /**
     * 设置项目类别
     * @param projectType 项目类别
     */
    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    /**
     * 获取项目说明
     * @return 项目说明 
     */
    public String getProjectDesc() {
        return projectDesc;
    }

    /**
     * 设置项目说明
     * @param projectDesc 项目说明
     */
    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    /**
     * 获取申请说明
     * @return 申请说明 
     */
    public String getProjectApplyReason() {
        return projectApplyReason;
    }

    /**
     * 设置申请说明
     * @param projectApplyReason 申请说明
     */
    public void setProjectApplyReason(String projectApplyReason) {
        this.projectApplyReason = projectApplyReason;
    }

    /**
     * 获取虚机模板
     * @return 虚机模板 
     */
    public String[] getTemplates() {
        return templates;
    }

    /**
     * 设置虚机模板
     * @param templates 虚机模板
     */
    public void setTemplates(String[] templates) {
        this.templates = templates;
    }

    /**
     * 获取虚机名称
     * @return 虚机名称 
     */
    public String[] getVmnames() {
        return vmnames;
    }

    /**
     * 设置虚机名称
     * @param vmnames 虚机名称
     */
    public void setVmnames(String[] vmnames) {
        this.vmnames = vmnames;
    }

    /**
     * 获取虚机cpu个数
     * @return 虚机cpu个数 
     */
    public String[] getVmcpus() {
        return vmcpus;
    }

    /**
     * 设置虚机cpu个数
     * @param vmcpus 虚机cpu个数
     */
    public void setVmcpus(String[] vmcpus) {
        this.vmcpus = vmcpus;
    }

    /**
     * 获取虚机内存大小
     * @return 虚机内存大小 
     */
    public String[] getVmmems() {
        return vmmems;
    }

    /**
     * 设置虚机内存大小
     * @param vmmems 虚机内存大小
     */
    public void setVmmems(String[] vmmems) {
        this.vmmems = vmmems;
    }

    /**
     * 获取虚拟硬盘大小
     * @return 虚拟硬盘大小 
     */
    public String[] getVmdisks() {
        return vmdisks;
    }

    /**
     * 设置虚拟硬盘大小
     * @param vmdisks 虚拟硬盘大小
     */
    public void setVmdisks(String[] vmdisks) {
        this.vmdisks = vmdisks;
    }

    /**
     * 获取申请时间
     * @return 申请时间 
     */
    public String[] getApplyTime() {
        return applyTime;
    }

    /**
     * 设置申请时间
     * @param applyTime 申请时间
     */
    public void setApplyTime(String[] applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 获取到期时间
     * @return 到期时间 
     */
    public String[] getExpiryTime() {
        return expiryTime;
    }

    /**
     * 设置到期时间
     * @param expiryTime 到期时间
     */
    public void setExpiryTime(String[] expiryTime) {
        this.expiryTime = expiryTime;
    }

    /**
     * 获取选择的项目id
     * @return 选择的项目id 
     */
    public Integer getHpid() {
        return hpid;
    }

    /**
     * 设置选择的项目id
     * @param hpid 选择的项目id
     */
    public void setHpid(Integer hpid) {
        this.hpid = hpid;
    }
	
}

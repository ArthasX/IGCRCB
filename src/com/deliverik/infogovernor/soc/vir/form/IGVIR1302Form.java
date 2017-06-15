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
 * Description: 虚机配置修改Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR1302Form extends BaseForm {

	/** 主键 */
	protected Integer id;

	/** 项目主键 */
	protected Integer pid;

	/** 项目名称 */
	protected String pname;
	
	/** vcenter主键 */
	protected Integer vcid;

	/** vCenter名称 */
	protected String vcName;
	
	/** 模板名称 */
	protected String templateName;

	/** 虚机所在主机名称 */
	protected String hostName;
	
	/** IP地址 */
	protected String ip;

	/** 网络名 */
	protected String networkName;

	/** 虚机名称 */
	protected String vmName;

	/** 虚机CPU个数 */
	protected Integer vmCpus;

	/** 虚机内存大小 */
	protected Integer vmMem;

	/** 虚机硬盘大小 */
	protected Integer vmDisk;

	/** 自动部署进度 */
	protected String progress;
	
	/** 数据中心名称 */
	protected String datacenterName;
	
	/** 资源池名称 */
	protected String resourcePoolName;
	
    /** 机构层次码 */
    protected String orgsyscoding;
    
    /** 机构名称 */
    protected String orgname;
    
    /** 用户id */
    protected String userid;
    
    /** 用户名称 */
    protected String userName;
    
    /** 申请时间 */
    protected String applyTime;
    
    /** 到期时间 */
    protected String expiryTime;
    
    /** 所属申请流程id */
    protected Integer prid;
    
    /** 状态 */
    protected String status;

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
	 * 项目主键取得
	 * @return pid 项目主键
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * 项目主键设定
	 * @param pid 项目主键
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * 项目名称取得
	 * @return pname 项目名称
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * 项目名称设定
	 * @param pname 项目名称
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * vcenter主键取得
	 * @return vcid vcenter主键
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * vcenter主键设定
	 * @param vcid vcenter主键
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * vCenter名称取得
	 * @return vcName vCenter名称
	 */
	public String getVcName() {
		return vcName;
	}

	/**
	 * vCenter名称设定
	 * @param vcName vCenter名称
	 */
	public void setVcName(String vcName) {
		this.vcName = vcName;
	}

	/**
	 * 模板名称取得
	 * @return templateName 模板名称
	 */
	public String getTemplateName() {
		return templateName;
	}

	/**
	 * 模板名称设定
	 * @param templateName 模板名称
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
	 * 虚机所在主机名称取得
	 * @return hostName 虚机所在主机名称
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * 虚机所在主机名称设定
	 * @param hostName 虚机所在主机名称
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	/**
	 * IP地址取得
	 * @return ip IP地址
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * IP地址设定
	 * @param ip IP地址
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 网络名取得
	 * @return networkName 网络名
	 */
	public String getNetworkName() {
		return networkName;
	}

	/**
	 * 网络名设定
	 * @param networkName 网络名
	 */
	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}

	/**
	 * 虚机名称取得
	 * @return vmName 虚机名称
	 */
	public String getVmName() {
		return vmName;
	}

	/**
	 * 虚机名称设定
	 * @param vmName 虚机名称
	 */
	public void setVmName(String vmName) {
		this.vmName = vmName;
	}

	/**
	 * 虚机CPU个数取得
	 * @return vmCpus 虚机CPU个数
	 */
	public Integer getVmCpus() {
		return vmCpus;
	}

	/**
	 * 虚机CPU个数设定
	 * @param vmCpus 虚机CPU个数
	 */
	public void setVmCpus(Integer vmCpus) {
		this.vmCpus = vmCpus;
	}

	/**
	 * 虚机内存大小取得
	 * @return vmMem 虚机内存大小
	 */
	public Integer getVmMem() {
		return vmMem;
	}

	/**
	 * 虚机内存大小设定
	 * @param vmMem 虚机内存大小
	 */
	public void setVmMem(Integer vmMem) {
		this.vmMem = vmMem;
	}

	/**
	 * 虚机硬盘大小取得
	 * @return vmDisk 虚机硬盘大小
	 */
	public Integer getVmDisk() {
		return vmDisk;
	}

	/**
	 * 虚机硬盘大小设定
	 * @param vmDisk 虚机硬盘大小
	 */
	public void setVmDisk(Integer vmDisk) {
		this.vmDisk = vmDisk;
	}

	/**
	 * 自动部署进度取得
	 * @return progress 自动部署进度
	 */
	public String getProgress() {
		return progress;
	}

	/**
	 * 自动部署进度设定
	 * @param progress 自动部署进度
	 */
	public void setProgress(String progress) {
		this.progress = progress;
	}

	/**
	 * 数据中心名称取得
	 * @return datacenterName 数据中心名称
	 */
	public String getDatacenterName() {
		return datacenterName;
	}

	/**
	 * 数据中心名称设定
	 * @param datacenterName 数据中心名称
	 */
	public void setDatacenterName(String datacenterName) {
		this.datacenterName = datacenterName;
	}

	/**
	 * 资源池名称取得
	 * @return resourcePoolName 资源池名称
	 */
	public String getResourcePoolName() {
		return resourcePoolName;
	}

	/**
	 * 资源池名称设定
	 * @param resourcePoolName 资源池名称
	 */
	public void setResourcePoolName(String resourcePoolName) {
		this.resourcePoolName = resourcePoolName;
	}

	/**
	 * 机构层次码取得
	 * @return orgsyscoding 机构层次码
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * 机构层次码设定
	 * @param orgsyscoding 机构层次码
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
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
	 * 用户id取得
	 * @return userid 用户id
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 用户id设定
	 * @param userid 用户id
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 用户名称取得
	 * @return userName 用户名称
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 用户名称设定
	 * @param userName 用户名称
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 申请时间取得
	 * @return applyTime 申请时间
	 */
	public String getApplyTime() {
		return applyTime;
	}

	/**
	 * 申请时间设定
	 * @param applyTime 申请时间
	 */
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	/**
	 * 到期时间取得
	 * @return expiryTime 到期时间
	 */
	public String getExpiryTime() {
		return expiryTime;
	}

	/**
	 * 到期时间设定
	 * @param expiryTime 到期时间
	 */
	public void setExpiryTime(String expiryTime) {
		this.expiryTime = expiryTime;
	}

	/**
	 * 所属申请流程id取得
	 * @return prid 所属申请流程id
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 所属申请流程id设定
	 * @param prid 所属申请流程id
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 状态取得
	 * @return status 状态
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 状态设定
	 * @param status 状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}

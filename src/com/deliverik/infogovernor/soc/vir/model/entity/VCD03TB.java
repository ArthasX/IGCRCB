/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.vir.model.VCD03Info;

/**
  * 概述: 资源申请虚机信息实体
  * 功能描述: 资源申请虚机信息实体
  * 创建记录: 2014/02/25
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="VCD03")
public class VCD03TB extends BaseEntity implements Serializable,
		Cloneable, VCD03Info {

	/** 主键 */
	@Id
	@TableGenerator(
		name="VCD03_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VCD03_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VCD03_TABLE_GENERATOR")
	protected Integer id;

	/** 项目主键 */
	protected Integer pid;

	/** vcloud主键 */
	protected Integer vcid;
	
	/** vcloud名称 */
	protected String vcname;

	/** 模板ID */
	protected Integer templateid;
	
	/** 模板名称 */
	protected String templateName;

	/** 虚机所在主机名称 */
	protected String hostName;

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

	/** 网络池 */
	protected String netWork;

	/** 存储策略 */
	protected String storageProfile;

	/** 机构层次码 */
	protected String orgsyscoding;

	/** 机构名称 */
	protected String orgname;

	/** 自动部署进度 */
	protected String progress;

	/** 用户ID */
	protected String userid;

	/** 用户名称 */
	protected String userName;

	/** 申请时间 */
	protected String applyTime;

	/** 到期时间 */
	protected String expiryTime;
	
	/** 所属申请流程id */
    protected Integer prid;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 主键设定
	 *
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 项目主键取得
	 *
	 * @return 项目主键
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * 项目主键设定
	 *
	 * @param pid 项目主键
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * vcloud主键取得
	 *
	 * @return vcloud主键
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * vcloud主键设定
	 *
	 * @param vcid vcloud主键
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * vcloud名称取得
	 * @return vcname vcloud名称
	 */
	public String getVcname() {
		return vcname;
	}

	/**
	 * vcloud名称设定
	 * @param vcname vcloud名称
	 */
	public void setVcname(String vcname) {
		this.vcname = vcname;
	}

	/**
	 * 模板ID取得
	 *
	 * @return 模板ID
	 */
	public Integer getTemplateid() {
		return templateid;
	}

	/**
	 * 模板ID设定
	 *
	 * @param templateid 模板ID
	 */
	public void setTemplateid(Integer templateid) {
		this.templateid = templateid;
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
	 *
	 * @return 虚机所在主机名称
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * 虚机所在主机名称设定
	 *
	 * @param hostName 虚机所在主机名称
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	/**
	 * 网络名取得
	 *
	 * @return 网络名
	 */
	public String getNetworkName() {
		return networkName;
	}

	/**
	 * 网络名设定
	 *
	 * @param networkName 网络名
	 */
	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}

	/**
	 * 虚机名称取得
	 *
	 * @return 虚机名称
	 */
	public String getVmName() {
		return vmName;
	}

	/**
	 * 虚机名称设定
	 *
	 * @param vmName 虚机名称
	 */
	public void setVmName(String vmName) {
		this.vmName = vmName;
	}

	/**
	 * 虚机CPU个数取得
	 *
	 * @return 虚机CPU个数
	 */
	public Integer getVmCpus() {
		return vmCpus;
	}

	/**
	 * 虚机CPU个数设定
	 *
	 * @param vmCpus 虚机CPU个数
	 */
	public void setVmCpus(Integer vmCpus) {
		this.vmCpus = vmCpus;
	}

	/**
	 * 虚机内存大小取得
	 *
	 * @return 虚机内存大小
	 */
	public Integer getVmMem() {
		return vmMem;
	}

	/**
	 * 虚机内存大小设定
	 *
	 * @param vmMem 虚机内存大小
	 */
	public void setVmMem(Integer vmMem) {
		this.vmMem = vmMem;
	}

	/**
	 * 虚机硬盘大小取得
	 *
	 * @return 虚机硬盘大小
	 */
	public Integer getVmDisk() {
		return vmDisk;
	}

	/**
	 * 虚机硬盘大小设定
	 *
	 * @param vmDisk 虚机硬盘大小
	 */
	public void setVmDisk(Integer vmDisk) {
		this.vmDisk = vmDisk;
	}

	/**
	 * 网络池取得
	 *
	 * @return 网络池
	 */
	public String getNetWork() {
		return netWork;
	}

	/**
	 * 网络池设定
	 *
	 * @param netWork 网络池
	 */
	public void setNetWork(String netWork) {
		this.netWork = netWork;
	}

	/**
	 * 存储策略取得
	 *
	 * @return 存储策略
	 */
	public String getStorageProfile() {
		return storageProfile;
	}

	/**
	 * 存储策略设定
	 *
	 * @param storageProfile 存储策略
	 */
	public void setStorageProfile(String storageProfile) {
		this.storageProfile = storageProfile;
	}

	/**
	 * 机构层次码取得
	 *
	 * @return 机构层次码
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * 机构层次码设定
	 *
	 * @param orgsyscoding 机构层次码
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * 机构名称取得
	 *
	 * @return 机构名称
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 机构名称设定
	 *
	 * @param orgname 机构名称
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * 自动部署进度取得
	 *
	 * @return 自动部署进度
	 */
	public String getProgress() {
		return progress;
	}

	/**
	 * 自动部署进度设定
	 *
	 * @param progress 自动部署进度
	 */
	public void setProgress(String progress) {
		this.progress = progress;
	}

	/**
	 * 用户ID取得
	 *
	 * @return 用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 用户ID设定
	 *
	 * @param userid 用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 用户名称取得
	 *
	 * @return 用户名称
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 用户名称设定
	 *
	 * @param userName 用户名称
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 申请时间取得
	 *
	 * @return 申请时间
	 */
	public String getApplyTime() {
		return applyTime;
	}

	/**
	 * 申请时间设定
	 *
	 * @param applyTime 申请时间
	 */
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	/**
	 * 到期时间取得
	 *
	 * @return 到期时间
	 */
	public String getExpiryTime() {
		return expiryTime;
	}

	/**
	 * 到期时间设定
	 *
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
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return id;
	}

}
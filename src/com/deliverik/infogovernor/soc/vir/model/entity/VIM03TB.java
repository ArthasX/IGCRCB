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
import javax.persistence.Transient;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;

/**
  * 概述: 资源申请虚机信息表实体
  * 功能描述: 资源申请虚机信息表实体
  * 创建记录: 2014/02/13
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="vim03")
public class VIM03TB extends BaseEntity implements Serializable,
		Cloneable, VIM03Info {

	/** 主键 */
	@Id
	@TableGenerator(
		name="VIM03_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VIM03_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VIM03_TABLE_GENERATOR")
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
    
    /** CPU费用 */
    @Transient
    protected String cpucost;
    
    /** 内存费用 */
    @Transient
    protected String memcost;
    
    /** 硬盘费用 */
    @Transient
    protected String diskcost;
    
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
     * 获取项目名称
     * @return 项目名称 
     */
    public String getPname() {
        return pname;
    }

    /**
     * 设置项目名称
     * @param pname 项目名称
     */
    public void setPname(String pname) {
        this.pname = pname;
    }

    /**
     * 获取vcenter主键
     * @return vcenter主键 
     */
    public Integer getVcid() {
        return vcid;
    }

    /**
     * 设置vcenter主键
     * @param vcid vcenter主键
     */
    public void setVcid(Integer vcid) {
        this.vcid = vcid;
    }

    /**
     * 获取vCenter名称
     * @return vCenter名称 
     */
    public String getVcName() {
        return vcName;
    }

    /**
     * 设置vCenter名称
     * @param vcName vCenter名称
     */
    public void setVcName(String vcName) {
        this.vcName = vcName;
    }

    /**
	 * 模板名称取得
	 *
	 * @return 模板名称
	 */
	public String getTemplateName() {
		return templateName;
	}

	/**
	 * 模板名称设定
	 *
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
     * 获取自动部署进度
     * @return 自动部署进度 
     */
    public String getProgress() {
        return progress;
    }

    /**
     * 设置自动部署进度
     * @param progress 自动部署进度
     */
    public void setProgress(String progress) {
        this.progress = progress;
    }

    /**
     * 获取数据中心名称
     * @return 数据中心名称 
     */
    public String getDatacenterName() {
        return datacenterName;
    }

    /**
     * 设置数据中心名称
     * @param datacenterName 数据中心名称
     */
    public void setDatacenterName(String datacenterName) {
        this.datacenterName = datacenterName;
    }

    /**
     * 获取资源池名称
     * @return 资源池名称 
     */
    public String getResourcePoolName() {
        return resourcePoolName;
    }

    /**
     * 设置资源池名称
     * @param resourcePoolName 资源池名称
     */
    public void setResourcePoolName(String resourcePoolName) {
        this.resourcePoolName = resourcePoolName;
    }

    /**
     * 获取机构层次码
     * @return 机构层次码 
     */
    public String getOrgsyscoding() {
        return orgsyscoding;
    }

    /**
     * 设置机构层次码
     * @param orgsyscoding 机构层次码
     */
    public void setOrgsyscoding(String orgsyscoding) {
        this.orgsyscoding = orgsyscoding;
    }

    /**
     * 获取机构名称
     * @return 机构名称 
     */
    public String getOrgname() {
        return orgname;
    }

    /**
     * 设置机构名称
     * @param orgname 机构名称
     */
    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    /**
     * 获取用户id
     * @return 用户id 
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置用户id
     * @param userid 用户id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取用户名称
     * @return 用户名称 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取申请时间
     * @return 申请时间 
     */
    public String getApplyTime() {
        return applyTime;
    }

    /**
     * 设置申请时间
     * @param applyTime 申请时间
     */
    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 获取到期时间
     * @return 到期时间 
     */
    public String getExpiryTime() {
        return expiryTime;
    }

    /**
     * 设置到期时间
     * @param expiryTime 到期时间
     */
    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    /**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return id;
	}

	/**
     * 获取所属申请流程id
     * @return 所属申请流程id 
     */
    public Integer getPrid() {
        return prid;
    }

    /**
     * 设置所属申请流程id
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

	public String getCpucost() {
		return cpucost;
	}

	public void setCpucost(String cpucost) {
		this.cpucost = cpucost;
	}

	public String getMemcost() {
		return memcost;
	}

	public void setMemcost(String memcost) {
		this.memcost = memcost;
	}

	public String getDiskcost() {
		return diskcost;
	}

	public void setDiskcost(String diskcost) {
		this.diskcost = diskcost;
	}

}
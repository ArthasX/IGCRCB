/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.condition;

import java.util.List;

/**
  * 概述: 资源申请虚机信息表检索条件实现
  * 功能描述: 资源申请虚机信息表检索条件实现
  * 创建记录: 2014/02/13
  * 修改记录: 
  */
public class Vim03SearchCondImpl implements Vim03SearchCond {

    /** 项目主键 */
    protected Integer pid_eq;
    
    /** 用户id */
    protected String userid_eq;
    
	/** 自动部署进度 */
	protected String progress_eq;
	
    /** 机构层次码 */
    protected String orgsyscoding_eq;

    /** 未部署 */
    protected boolean progressIsNull = false;
    
    /** 流程主键 */
    protected Integer prid;
    
    /** 状态 */
    protected String status;
    
    /** 连接ID */
    protected Integer vcid;
    
    /** 主机名称 */
    protected String hostname;
    
    /** 状态 */
    protected String status_nq;
    
    /** 流程ID集合 */
    protected List<Integer> prid_in;
    
    /** 虚机名称 */
    protected String vmName;
    
    /**
     * 获取项目主键
     * @return 项目主键 
     */
    public Integer getPid_eq() {
        return pid_eq;
    }

    /**
     * 设置项目主键
     * @param pid_eq 项目主键
     */
    public void setPid_eq(Integer pid_eq) {
        this.pid_eq = pid_eq;
    }

	/**
	 * 用户id取得
	 * @return userid_eq 用户id
	 */
	public String getUserid_eq() {
		return userid_eq;
	}

	/**
	 * 用户id设定
	 * @param userid_eq 用户id
	 */
	public void setUserid_eq(String userid_eq) {
		this.userid_eq = userid_eq;
	}

	/**
	 * 自动部署进度取得
	 * @return progress_eq 自动部署进度
	 */
	public String getProgress_eq() {
		return progress_eq;
	}

	/**
	 * 自动部署进度设定
	 * @param progress_eq 自动部署进度
	 */
	public void setProgress_eq(String progress_eq) {
		this.progress_eq = progress_eq;
	}

	/**
	 * 机构层次码取得
	 * @return orgsyscoding_eq 机构层次码
	 */
	public String getOrgsyscoding_eq() {
		return orgsyscoding_eq;
	}

	/**
	 * 机构层次码设定
	 * @param orgsyscoding_eq 机构层次码
	 */
	public void setOrgsyscoding_eq(String orgsyscoding_eq) {
		this.orgsyscoding_eq = orgsyscoding_eq;
	}

    /**
     * 获取未部署
     * @return 未部署 
     */
    public boolean isProgressIsNull() {
        return progressIsNull;
    }

    /**
     * 设置未部署
     * @param progressIsNull 未部署
     */
    public void setProgressIsNull(boolean progressIsNull) {
        this.progressIsNull = progressIsNull;
    }

    /**
     * 获取流程主键
     * @return 流程主键 
     */
    public Integer getPrid() {
        return prid;
    }

    /**
     * 设置流程主键
     * @param prid 流程主键
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

	/**
	 * 连接ID取得
	 * @return vcid 连接ID
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * 连接ID设定
	 * @param vcid 连接ID
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * 主机名称取得
	 * @return hostname 主机名称
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * 主机名称设定
	 * @param hostname 主机名称
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	/**
	 * 状态取得
	 * @return status_nq 状态
	 */
	public String getStatus_nq() {
		return status_nq;
	}

	/**
	 * 状态设定
	 * @param status_nq 状态
	 */
	public void setStatus_nq(String status_nq) {
		this.status_nq = status_nq;
	}

	/**
	 * 流程ID集合取得
	 * @return prid_in 流程ID集合
	 */
	public List<Integer> getPrid_in() {
		return prid_in;
	}

	/**
	 * 流程ID集合设定
	 * @param prid_in 流程ID集合
	 */
	public void setPrid_in(List<Integer> prid_in) {
		this.prid_in = prid_in;
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
}
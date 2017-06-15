/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 资源申请虚机信息表接口
  * 功能描述: 资源申请虚机信息表接口
  * 创建记录: 2014/02/13
  * 修改记录: 
  */
public interface VIM03Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId();

    
	/**
	 * 项目主键取得
	 *
	 * @return 项目主键
	 */
	public Integer getPid();

	/**
     * 获取项目名称
     * @return 项目名称 
     */
    public String getPname();
    
	/**
     * 获取vcenter主键
     * @return vcenter主键 
     */
    public Integer getVcid();

    /**
     * 获取vCenter名称
     * @return vCenter名称 
     */
    public String getVcName();

	/**
	 * 模板名称取得
	 *
	 * @return 模板名称
	 */
	public String getTemplateName();

	/**
	 * 虚机所在主机名称取得
	 *
	 * @return 虚机所在主机名称
	 */
	public String getHostName();
	
	/**
	 * IP地址取得
	 * @return ip IP地址
	 */
	public String getIp();

	/**
	 * 网络名取得
	 *
	 * @return 网络名
	 */
	public String getNetworkName();

	/**
	 * 虚机名称取得
	 *
	 * @return 虚机名称
	 */
	public String getVmName();

	/**
	 * 虚机CPU个数取得
	 *
	 * @return 虚机CPU个数
	 */
	public Integer getVmCpus();

	/**
	 * 虚机内存大小取得
	 *
	 * @return 虚机内存大小
	 */
	public Integer getVmMem();

	/**
	 * 虚机硬盘大小取得
	 *
	 * @return 虚机硬盘大小
	 */
	public Integer getVmDisk();
	
	/**
     * 获取自动部署进度
     * @return 自动部署进度 
     */

	public String getProgress();
	
	/**
     * 获取数据中心名称
     * @return 数据中心名称 
     */
    public String getDatacenterName();

    /**
     * 获取资源池名称
     * @return 资源池名称 
     */
    public String getResourcePoolName();
    
    /**
     * 获取机构层次码
     * @return 机构层次码 
     */
    public String getOrgsyscoding();

    /**
     * 获取机构名称
     * @return 机构名称 
     */
    public String getOrgname();
    /**
     * 获取用户id
     * @return 用户id 
     */
    public String getUserid();
    
    /**
     * 获取用户名称
     * @return 用户名称 
     */
    public String getUserName();
    
    /**
     * 获取申请时间
     * @return 申请时间 
     */
    public String getApplyTime();
    
    /**
     * 获取到期时间
     * @return 到期时间 
     */
    public String getExpiryTime();
 
    /**
     * 获取所属申请流程id
     * @return 所属申请流程id 
     */
    public Integer getPrid();
    
    /**
	 * 状态取得
	 * @return status 状态
	 */
	public String getStatus();
    
	public String getCpucost();

	public String getMemcost();

	public String getDiskcost();
}
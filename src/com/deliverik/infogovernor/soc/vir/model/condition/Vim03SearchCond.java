/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.condition;

import java.util.List;

/**
  * 概述: 资源申请虚机信息表检索条件接口
  * 功能描述: 资源申请虚机信息表检索条件接口
  * 创建记录: 2014/02/13
  * 修改记录: 
  */
public interface Vim03SearchCond {

    /**
     * 获取项目主键
     * @return 项目主键 
     */
    public Integer getPid_eq();
    
	/**
	 * 用户id取得
	 * @return userid_eq 用户id
	 */
	public String getUserid_eq();

	/**
	 * 自动部署进度取得
	 * @return progress_eq 自动部署进度
	 */
	public String getProgress_eq();

	/**
	 * 机构层次码取得
	 * @return orgsyscoding_eq 机构层次码
	 */
	public String getOrgsyscoding_eq();
	
	/**
     * 获取未部署
     * @return 未部署 
     */
    public boolean isProgressIsNull();
    
    /**
     * 获取流程主键
     * @return 流程主键 
     */
    public Integer getPrid();
    
    /**
	 * 状态取得
	 * @return status 状态
	 */
	public String getStatus();
	


	/**
	 * 连接ID取得
	 * @return vcid 连接ID
	 */
	public Integer getVcid();

	/**
	 * 主机名称取得
	 * @return hostname 主机名称
	 */
	public String getHostname();
	
	/**
	 * 状态取得
	 * @return status_nq 状态
	 */
	public String getStatus_nq();
	
	/**
	 * 流程ID集合取得
	 * @return prid_in 流程ID集合
	 */
	public List<Integer> getPrid_in();
	
	/**
	 * 虚机名称取得
	 * @return vmName 虚机名称
	 */
	public String getVmName();
}
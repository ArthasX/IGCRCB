/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 资源申请虚机信息接口
  * 功能描述: 资源申请虚机信息接口
  * 创建记录: 2014/02/25
  * 修改记录: 
  */
public interface VCD03Info extends BaseModel {

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
	 * vcloud主键取得
	 *
	 * @return vcloud主键
	 */
	public Integer getVcid();
	
	/**
	 * vcloud名称取得
	 * @return vcname vcloud名称
	 */
	public String getVcname();

	/**
	 * 模板ID取得
	 *
	 * @return 模板ID
	 */
	public Integer getTemplateid();
	
	/**
	 * 模板名称取得
	 * @return templateName 模板名称
	 */
	public String getTemplateName();

	/**
	 * 虚机所在主机名称取得
	 *
	 * @return 虚机所在主机名称
	 */
	public String getHostName();

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
	 * 网络池取得
	 *
	 * @return 网络池
	 */
	public String getNetWork();

	/**
	 * 存储策略取得
	 *
	 * @return 存储策略
	 */
	public String getStorageProfile();

	/**
	 * 机构层次码取得
	 *
	 * @return 机构层次码
	 */
	public String getOrgsyscoding();

	/**
	 * 机构名称取得
	 *
	 * @return 机构名称
	 */
	public String getOrgname();

	/**
	 * 自动部署进度取得
	 *
	 * @return 自动部署进度
	 */
	public String getProgress();

	/**
	 * 用户ID取得
	 *
	 * @return 用户ID
	 */
	public String getUserid();

	/**
	 * 用户名称取得
	 *
	 * @return 用户名称
	 */
	public String getUserName();

	/**
	 * 申请时间取得
	 *
	 * @return 申请时间
	 */
	public String getApplyTime();

	/**
	 * 到期时间取得
	 *
	 * @return 到期时间
	 */
	public String getExpiryTime();

}
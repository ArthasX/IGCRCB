/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.model;

import java.io.Serializable;

/**
 * 概述:虚拟资源统计视图接口(按用户)
 * 功能描述:虚拟资源统计视图接口(按用户) 
 * 创建记录: 2014/02/19
 * 修改记录: 
 */

public interface VIM03CountByUserVWInfo {

	/**
	 * 主键取得
	 * @return id 主键
	 */
	public String getId();

	/**
	 * 用户名取得
	 * @return username 用户名
	 */
	public String getUsername();

	/**
	 * 用户id取得
	 * @return userid 用户id
	 */
	public String getUserid();

	/**
	 * 机构名取得
	 * @return orgname 机构名
	 */
	public String getOrgname();

	/**
	 * 机构码取得
	 * @return orgsyscoding 机构码
	 */
	public String getOrgsyscoding();

	/**
	 * 虚机数量取得
	 * @return count 虚机数量
	 */
	public String getCount();

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK();
	
	public Integer getTotalcpu();

	public Integer getTotalmem();

	public Integer getTotaldisk();
	
	public Integer getCost();

}
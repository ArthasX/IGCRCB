/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 虚拟资源项目信息接口
  * 功能描述: 虚拟资源项目信息接口
  * 创建记录: 2014/02/25
  * 修改记录: 
  */
public interface VCD02Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId();

	/**
	 * 项目名称取得
	 *
	 * @return 项目名称
	 */
	public String getProjectName();

	/**
	 * 期望部署时间取得
	 *
	 * @return 期望部署时间
	 */
	public String getExpectDeployTime();

	/**
	 * 项目到期时间取得
	 *
	 * @return 项目到期时间
	 */
	public String getProjectExpireTime();

	/**
	 * 项目类别取得
	 *
	 * @return 项目类别
	 */
	public String getProjectType();

	/**
	 * 项目说明取得
	 *
	 * @return 项目说明
	 */
	public String getProjectDesc();

	/**
	 * 申请说明取得
	 *
	 * @return 申请说明
	 */
	public String getProjectApplyReason();

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

}
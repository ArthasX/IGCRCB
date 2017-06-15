/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model;


/**
  * 概述: 签到表接口
  * 功能描述: 签到表接口
  * 创建记录: 2015/03/12
  * 修改记录: 
  */
public interface SigninInfo{

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getSiid();

	/**
	 * 演练流程id取得
	 *
	 * @return 演练流程id
	 */
	public Integer getDrillprid();

	/**
	 * 应急指挥流程id取得
	 *
	 * @return 应急指挥流程id
	 */
	public Integer getEcprid();

	/**
	 * 场景流程id取得
	 *
	 * @return 场景流程id
	 */
	public Integer getSceneprid();

	/**
	 * 用户id取得
	 *
	 * @return 用户id
	 */
	public String getSiuserid();
	
	/**
	 * 用户名取得
	 *
	 * @return 用户名
	 */
	public String getSiusername();

	/**
	 * 角色id取得
	 *
	 * @return 角色id
	 */
	public Integer getSiroleid();

	/**
	 * 是否应急指挥参与人取得
	 *
	 * @return 是否应急指挥参与人
	 */
	public Integer getWdc();

	/**
	 * 是否场景参与人取得
	 *
	 * @return 是否场景参与人
	 */
	public Integer getWdp();

	/**
	 * 是否签到取得
	 *
	 * @return 是否签到
	 */
	public Integer getSignined();

	/**
	 * 签到时间取得
	 *
	 * @return 签到时间
	 */
	public String getSitime();

}
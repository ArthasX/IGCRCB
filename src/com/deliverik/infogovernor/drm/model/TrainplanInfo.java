/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 培训计划表接口
  * 功能描述: 培训计划表接口
  * 创建记录: 2015/04/10
  * 修改记录: 
  */
public interface TrainplanInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getTpid();

	/**
	 * 计划名称取得
	 *
	 * @return 计划名称
	 */
	public String getTpname();

	/**
	 * 发起人id取得
	 *
	 * @return 发起人id
	 */
	public String getTpuserid();

	/**
	 * 发起人姓名取得
	 *
	 * @return 发起人姓名
	 */
	public String getTpusername();

	/**
	 * 发起部门id取得
	 *
	 * @return 发起部门id
	 */
	public String getPtorgid();

	/**
	 * 发起部门名称取得
	 *
	 * @return 发起部门名称
	 */
	public String getTporgname();

	/**
	 * 发起日期取得
	 *
	 * @return 发起日期
	 */
	public String getTptime();

	/**
	 * 计划状态取得
	 *
	 * @return 计划状态
	 */
	public String getTpstatus();

}
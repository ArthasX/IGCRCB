/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 演练计划条目接口
  * 功能描述: 演练计划条目接口
  * 创建记录: 2015/03/02
  * 修改记录: 
  */
public interface DrillplanitemInfo extends BaseModel {

	/**
	 * 演练计划条目id取得
	 *
	 * @return 演练计划条目id
	 */
	public Integer getDiid();

	/**
	 * 演练计划id取得
	 *
	 * @return 演练计划id
	 */
	public Integer getDid();

	/**
	 * 演练流程prid取得
	 *
	 * @return 演练流程prid
	 */
	public Integer getPrid();

	/**
	 * 演练状态 已演练/未演练取得
	 *
	 * @return 演练状态 已演练/未演练
	 */
	public String getStatus();

	/**
	 * 演练预期开始时间取得
	 *
	 * @return 演练预期开始时间
	 */
	public String getExpecttime();

	/**
	 * 演练实际开始时间取得
	 *
	 * @return 演练实际开始时间
	 */
	public String getActstarttime();

	/**
	 * 演练名称取得
	 *
	 * @return 演练名称
	 */
	public String getDiname();

	/**
	 * 演练内容取得
	 *
	 * @return 演练内容
	 */
	public String getDicontant();

	/**
	 * 演练目的取得
	 *
	 * @return 演练目的
	 */
	public String getDidestination();

	/**
	 * 演练场景取得
	 *
	 * @return 演练场景
	 */
	public String getDiscene();

	/**
	 * 影响范围取得
	 *
	 * @return 影响范围
	 */
	public String getDiscope();

	/**
	 * 演练负责部门取得
	 *
	 * @return 演练负责部门
	 */
	public String getDidutyorg();

	/**
	 * 参与部门取得
	 *
	 * @return 参与部门
	 */
	public String getPartorg();

}
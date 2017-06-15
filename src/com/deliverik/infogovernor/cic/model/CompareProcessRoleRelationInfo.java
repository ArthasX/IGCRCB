/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 关系表接口
  * 功能描述: 关系表接口
  * 创建记录: 2014/04/24
  * 修改记录: 
  */
public interface CompareProcessRoleRelationInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId();

	/**
	 * 比对任务表主键取得
	 *
	 * @return 比对任务表主键
	 */
	public Integer getCpid();

	/**
	 * 对比规则表主键取得
	 *
	 * @return 对比规则表主键
	 */
	public Integer getCrid();

	/**
	 * 比对规则表版本取得
	 *
	 * @return 比对规则表版本
	 */
	public Integer getCrversion();

}
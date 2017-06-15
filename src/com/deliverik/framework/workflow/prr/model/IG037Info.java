/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 流程导入日志表接口
  * 功能描述: 流程导入日志表接口
  * 创建记录: 2014/11/14
  * 修改记录: 
  */
public interface IG037Info extends BaseModel {

	/**
	 * 流程导入主键取得
	 *
	 * @return 流程导入主键
	 */
	public Integer getIrid();

	/**
	 * 流程主键取得
	 *
	 * @return 流程主键
	 */
	public Integer getPrid();

	/**
	 * 导入时间取得
	 *
	 * @return 导入时间
	 */
	public String getIrtime();

	/**
	 * 导入用户ID取得
	 *
	 * @return 导入用户ID
	 */
	public String getIruserid();

	/**
	 * 导入用户名称取得
	 *
	 * @return 导入用户名称
	 */
	public String getIrusername();

	/**
	 * 导入部门id取得
	 *
	 * @return 导入部门id
	 */
	public String getIrorgid();

	/**
	 * 导入部门名称取得
	 *
	 * @return 导入部门名称
	 */
	public String getIrorgname();

	/**
	 * 导入日志描述取得
	 *
	 * @return 导入日志描述
	 */
	public String getIrdesc();

	/**
	 * 导入日志内容取得
	 *
	 * @return 导入日志内容
	 */
	public String getIrcomment();

}
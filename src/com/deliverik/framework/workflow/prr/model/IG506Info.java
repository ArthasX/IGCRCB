/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 人员类表单值表接口
  * 功能描述: 人员类表单值表接口
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
public interface IG506Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPiuid();

	/**
	 * 流程主键取得
	 *
	 * @return 流程主键
	 */
	public Integer getPrid();

	/**
	 * 用户id取得
	 *
	 * @return 用户id
	 */
	public String getPiuserid();

	/**
	 * 用户名取得
	 *
	 * @return 用户名
	 */
	public String getPiusername();

	/**
	 * 机构码取得
	 *
	 * @return 机构码
	 */
	public String getPiorgid();

	/**
	 * 机构名称取得
	 *
	 * @return 机构名称
	 */
	public String getPiorgname();

	/**
	 * 角色id取得
	 *
	 * @return 角色id
	 */
	public Integer getPiroleid();

	/**
	 * 角色名称取得
	 *
	 * @return 角色名称
	 */
	public String getPirolename();
	
	/**
	 * 电话取得
	 * @return piphone 电话
	 */
	public String getPiphone();

}
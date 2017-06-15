/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 参与者按钮定义信息表视图检索条件接口
  * 功能描述: 参与者按钮定义信息表视图检索条件接口
  * 创建记录: 2012/04/19
  * 修改记录: 
  */
public interface IG221SearchCond {
	
	public String getPbdname();
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getPpbdid();

	/**
	 * 参与者定义ID取得
	 *
	 * @return 参与者定义ID
	 */
	public String getPpdid();

	/**
	 * 按钮定义ID取得
	 *
	 * @return 按钮定义ID
	 */
	public String getPbdid();

	/**
	 * 按钮显示名称取得
	 *
	 * @return 按钮显示名称
	 */
	public String getPpbdname();

	/**
	 * 按钮提示信息取得
	 *
	 * @return 按钮提示信息
	 */
	public String getPpbddesc();

	/**
	 * 提交权限（0同角色所有人提交跃迁，1同角色有一人提交跃迁）默认0取得
	 *
	 * @return 提交权限（0同角色所有人提交跃迁，1同角色有一人提交跃迁）默认0
	 */
	public String getPpbdauth();
	
	/**
	 * 节点信息取得
	 *
	 * @return 按钮提示信息
	 */
	public String getPsdid();
}
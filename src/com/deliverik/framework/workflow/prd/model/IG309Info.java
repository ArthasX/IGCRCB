/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;


/**
  * 概述: 参与者可视按钮实体接口
  * 功能描述: 参与者可视按钮实体接口
  * 创建记录: 2012/04/18
  * 修改记录: 
  */
public interface IG309Info {


	/**
	 * 按钮定义ID取得
	 *
	 * @return 按钮定义ID
	 */
	public String getVbid();

	/**
	 * 按钮显示名称取得
	 *
	 * @return 按钮显示名称
	 */
	public String getVbname();

	/**
	 * 按钮提示信息取得
	 *
	 * @return 按钮提示信息
	 */
	public String getVbdesc();

	/**
	 * 提交权限（0同角色所有人提交跃迁，1同角色有一人提交跃迁）默认0取得
	 *
	 * @return 提交权限（0同角色所有人提交跃迁，1同角色有一人提交跃迁）默认0
	 */
	public String getVbauth();
	
	/**
	 * 图片名取得
	 * 
	 * @return 图片名
	 */
	public String getVbimage();
	
	/**
	 *校验记录是否必填取得
	 */
	public String getVbrecord();
	
	/**
	 *弹出页js名称取得
	 */
	public String getVbacturl();

}
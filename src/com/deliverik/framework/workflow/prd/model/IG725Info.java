/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.workflow.prd.model.entity.IG900TB;

/**
  * 概述: 缺省参与者按钮定义表接口
  * 功能描述: 缺省参与者按钮定义表接口
  * 创建记录: 2012/04/18
  * 修改记录: 
  */
public interface IG725Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getPdbdid();

	/**
	 * 外键状态ID取得
	 *
	 * @return 外键状态ID
	 */
	public String getPsdid();

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
	public String getPdbdname();

	/**
	 * 按钮提示信息取得
	 *
	 * @return 按钮提示信息
	 */
	public String getPdbddesc();

	/**
	 * 提交权限（0同角色所有人提交跃迁，1同角色有一人提交跃迁）默认0取得
	 *
	 * @return 提交权限（0同角色所有人提交跃迁，1同角色有一人提交跃迁）默认0
	 */
	public String getPdbdauth();
	
	/**
	 *是否校验表单必填项0不校验1校验取得
	 */
	public String getCheckrequired();
	
	/**
	 *是否处理记录必填取得
	 */
	public String getCheckrecord();
	
	/**
	 *弹出页js名称取得
	 */
	public String getActurl();
	
	public IG900TB getProcessButtonDefTB();

}
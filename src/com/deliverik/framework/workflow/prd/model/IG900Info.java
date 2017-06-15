/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 流程按钮定义表接口
  * 功能描述: 流程按钮定义表接口
  * 创建记录: 2012/04/18
  * 修改记录: 
  */
public interface IG900Info extends BaseModel {

	/**
	 * 主键（01更新，02确认）确认，其余已1开头取得
	 *
	 * @return 主键（01更新，02确认）确认，其余已1开头
	 */
	public String getPbdid();

	/**
	 * 按钮默认名称取得
	 *
	 * @return 按钮默认名称
	 */
	public String getPbdname();

	/**
	 * 是否系统保留按钮（1是0否）取得
	 *
	 * @return 是否系统保留按钮（1是0否）
	 */
	public String getPbdflag();
	
	/**
	 * 按钮显示图片名称取得
	 * 
	 * @return 按钮显示图片名称
	 */
	public String getPbdimage();

}
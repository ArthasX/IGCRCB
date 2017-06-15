/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 日志表接口
  * 功能描述: 日志表接口
  * 创建记录: 2014/02/19
  * 修改记录: 
  */
public interface VIM04Info extends BaseModel {

	/**
	 * 自增主键取得
	 *
	 * @return 自增主键
	 */
	public Integer getId();

	/**
	 * 项目主键取得
	 *
	 * @return 项目主键
	 */
	public Integer getPid();

	/**
	 * 虚机名称取得
	 *
	 * @return 虚机名称
	 */
	public String getVmName();

	/**
	 * 日志内容取得
	 *
	 * @return 日志内容
	 */
	public String getContent();

	/**
     * 获取发生时间
     * @return 发生时间 
     */
    public String getUpdateTime();

	/**
     * 获取标志（0：失败1：成功）
     * @return 标志（0：失败1：成功） 
     */
    public String getFlag();
}
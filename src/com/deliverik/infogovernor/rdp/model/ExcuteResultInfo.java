/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rdp.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: ExcuteResult接口
  * 功能描述: ExcuteResult接口
  * 创建记录: 2014/04/16
  * 修改记录: 
  */
public interface ExcuteResultInfo extends BaseModel {

	/**
	 * hostid取得
	 *
	 * @return hostid
	 */
	public String getHostid();

	/**
	 * taskid取得
	 *
	 * @return taskid
	 */
	public Integer getTaskid();

	/**
	 * result取得
	 *
	 * @return result
	 */
	public String getResult();

	/**
	 * resultDetail取得
	 *
	 * @return resultDetail
	 */
	public String getResultDetail();
	
	public Integer getState();
	
	public String getRealtimedetail();

}
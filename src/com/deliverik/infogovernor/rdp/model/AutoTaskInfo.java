/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rdp.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: AutoTask接口
  * 功能描述: AutoTask接口
  * 创建记录: 2014/04/16
  * 修改记录: 
  */
public interface AutoTaskInfo extends BaseModel {

	/**
	 * id取得
	 *
	 * @return id
	 */
	public Integer getId();

	/**
	 * taskName取得
	 *
	 * @return taskName
	 */
	public String getTaskName();

	/**
	 * businessSystemid取得
	 *
	 * @return businessSystemid
	 */
	public Integer getBusinessSystemid();

	/**
	 * hosts取得
	 *
	 * @return hosts
	 */
	public String getHosts();

	/**
	 * excutetime取得
	 *
	 * @return excutetime
	 */
	public String getExcutetime();

	/**
	 * scriptPath取得
	 *
	 * @return scriptPath
	 */
	public String getScriptPath();

	/**
	 * version取得
	 *
	 * @return version
	 */
	public String getVersion();
	
	
	public String getScriptParam();
	
	public String getRdpFilePath();
	
	public String getResultLogPath();
	
	public String getCurrentFilePath();
	
	public Integer getState();
	
	public String getScriptname();
	
	public String getBsmname();
	
}
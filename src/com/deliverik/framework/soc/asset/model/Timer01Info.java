/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: timer01接口
  * 功能描述: timer01接口
  * 创建记录: 2013/07/04
  * 修改记录: 
  */
public interface Timer01Info extends BaseModel {

	/**
	 * uuid取得
	 *
	 * @return uuid
	 */
	public String getUuid();

	/**
	 * name取得
	 *
	 * @return name
	 */
	public String getTypename();


	/**
	 * strartrule取得
	 *
	 * @return strartrule
	 */
	public String getStartrule();

	/**
	 * stoprule取得
	 *
	 * @return stoprule
	 */
	public String getStoprule();

	/**
	 * starttime取得
	 *
	 * @return starttime
	 */
	public String getStarttime();

	/**
	 * stoptime取得
	 *
	 * @return stoptime
	 */
	public String getStoptime();

	/**
	 * newstarttime取得
	 *
	 * @return newstarttime
	 */
	public String getNewstarttime();

	/**
	 * newstoptime取得
	 *
	 * @return newstoptime
	 */
	public String getNewstoptime();

	/**
	 * executstatus取得
	 *
	 * @return executstatus
	 */
	public String getExecutstatus();

	/**
	 * periodtype取得
	 *
	 * @return periodtype
	 */
	public String getPeriodtype();
	
	public String getCollecttype();
	
	public String getName();
	
	public Integer getResourceid();

}
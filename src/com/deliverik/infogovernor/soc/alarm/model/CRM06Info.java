/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: CRM06接口
  * 功能描述: CRM06接口
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public interface CRM06Info extends BaseModel {

	/**
	 * serverid取得
	 *
	 * @return serverid
	 */
	public Integer getServerid();

	/**
	 * fileid取得
	 *
	 * @return fileid
	 */
	public Integer getFileid();

	/**
	 * servername取得
	 *
	 * @return servername
	 */
	public String getServername();

	/**
	 * servertype取得
	 *
	 * @return servertype
	 */
	public String getServertype();

	/**
	 * ip取得
	 *
	 * @return ip
	 */
	public String getIp();

	/**
	 * status取得
	 *
	 * @return status
	 */
	public String getStatus();
	
	public String getIp2();
	
	public String getHost();
	
	public String getAlarmstatus();
	
	public String getCreatemessage();
	public Integer getHqserverid();
	public String getHqservername();
	
	/**
	 * 将毫秒转换成相应格式时间的方法
	 */
	public String getTranToTime();

}
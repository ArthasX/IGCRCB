/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 告警规则表接口
  * 功能描述: 告警规则表接口
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public interface Mss00002Info extends BaseModel {

	public Integer getRelationid();

	public Integer getDeviceid();

	public Integer getMaxalarmnum();

	public Integer getMaxalarmtime();

	public Integer getRuletempid();

	public String getCreatetime();

}
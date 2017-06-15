/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: vim06接口
  * 功能描述: vim06接口
  * 创建记录: 2014/02/21
  * 修改记录: 
  */
public interface VIM06Info extends BaseModel {

	public Integer getId();

	public String getResourceitem();

	public Integer getPrice();

	public String getVersion();

	public Integer getStrategyid();
}
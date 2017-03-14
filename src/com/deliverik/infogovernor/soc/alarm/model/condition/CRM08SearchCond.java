/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.condition;

import java.util.List;


/**
  * 概述: CRM08检索条件接口
  * 功能描述: CRM08检索条件接口
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public interface CRM08SearchCond {
	
	public String getTypeccid_eq();
	
	public String getTypecid_eq();
	
	public List<Integer> getRuletempids();
	
	public String getRuletempname();

	public Integer getTempstate();

}
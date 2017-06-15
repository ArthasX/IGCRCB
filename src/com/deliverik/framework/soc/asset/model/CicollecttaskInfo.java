/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model;


/**
  * 概述: cicollecttask接口
  * 功能描述: cicollecttask接口
  * 创建记录: 2013/07/05 王省
  * 修改记录: 
  */
public interface CicollecttaskInfo{

	public String getTypename();

	public String getUuid();

	public String getName();

	public String getStartrule();

	public String getStoprule();

	public String getStarttime();

	public String getStoptime();

	public String getNewstarttime();

	public String getNewstoptime();

	public String getExecutstatus();

	public String getPeriodtype();
	
	public String getPlatformname();
	
	public String getServername();
	
	public Integer getResourceid();

}
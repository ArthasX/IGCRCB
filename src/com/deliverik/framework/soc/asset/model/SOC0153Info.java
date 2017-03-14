/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.soc.asset.model.entity.SOC0113TB;


/**
  * 概述: 表空间伐值设定表接口
  * 功能描述: 表空间伐值设定表接口
  * 创建记录: 
  * 修改记录: 
  */
public interface SOC0153Info{

	public Integer getLid() ;
	public String getLogName();
	public String getWarnType() ;
	public Integer getCiType() ;
	public String getLogStatus() ;
	public String getLogContent() ;
	public String getLogDate();
	public String getTotalSize();
	public String getUserSize() ;
	public String getSurplusSize() ;
	public String getUserRatio() ;
	public String getServerIP() ;
	public SOC0113TB getSoc0113TB();
	

}
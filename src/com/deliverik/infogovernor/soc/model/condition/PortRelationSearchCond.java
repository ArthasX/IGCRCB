/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model.condition;

/**
  * 概述: 端到端关系表检索条件接口
  * 功能描述: 端到端关系表检索条件接口
  * 创建记录: 2013/01/17
  * 修改记录: 
  */
public interface PortRelationSearchCond {
	public String getSymmetrixid();
	
	public String getEiid();
	
	public String getEiname();
	
	public String getWwn();
	
	public String getHba();
	
	public boolean isFlag();
	
	public String getStyle();
	
	public String getBrpareiid();
	
	public String getTempid();
}
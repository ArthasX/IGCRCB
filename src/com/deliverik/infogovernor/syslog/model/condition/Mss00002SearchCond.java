/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.condition;

import com.deliverik.infogovernor.syslog.vo.IGLOG0041VO;

/**
  * 概述: 告警规则表检索条件接口
  * 功能描述: 告警规则表检索条件接口
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public interface Mss00002SearchCond {

	public String getName_like();
	
//	public String getIp_like();
	
	
	public String getEsyscoding();
	
	public IGLOG0041VO getVo();

	public String[] getDeleteId();
	
	public String getDeviceid();
	/**
	 * 规则模板id取得
	 */
	public Integer getRuletempid();
}
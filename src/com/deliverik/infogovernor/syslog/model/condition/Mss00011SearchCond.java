/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.condition;

import com.deliverik.infogovernor.syslog.vo.IGLOG0041VO;

/**
  * 概述: mss00011检索条件接口
  * 功能描述: mss00011检索条件接口
  * 创建记录: 2013/04/16
  * 修改记录: 
  */
public interface Mss00011SearchCond {
	public String getName_like();

	public String getType_eq();

	public String getEsyscoding();

	public IGLOG0041VO getVo();

	public String[] getDeleteId();
	public String getRuleid();

	public String getTypeid();

	public String getDeviceid();

	public String getDevicestate();

}
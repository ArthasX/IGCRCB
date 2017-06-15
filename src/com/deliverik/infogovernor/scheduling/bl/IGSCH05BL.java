/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.scheduling.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.scheduling.dto.IGSCH05DTO;

/**
 *	<p>概述: 日常运维计划定时发起接口</p>
 * 
 *	<p>创建记录: 杨盛楠	2010-12-9</p>
 */
public interface IGSCH05BL extends BaseBL {
	
	public String getPeriodInfo(String periodType, String CustomDate, 
			String exeHour, String exeMinute,String startDate);
	
	public void init(IGSCH05DTO dto) throws BLException;
	
}

/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.bl;


import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC2001DTO;

/**
 * 概述: 年度工作统计BL接口
 * 创建记录:  lianghongyang 2014-8-7 09:34:11
 * 修改记录: 
 */

public interface IGCRC20BL  extends BaseBL{
	/**
	 * 服务商资源池统计处理
	 *
	 * @param dto IGCRC2001DTO
	 * @return IGCRC2001DTO
	 */
	public IGCRC2001DTO getFindStatistics(IGCRC2001DTO dto);

}

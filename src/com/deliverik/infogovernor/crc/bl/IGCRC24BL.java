/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.bl;


import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC2401DTO;

public interface IGCRC24BL  extends BaseBL{
	/**
	 * 事件平均解决时间处理
	 *
	 * @param dto IGCRC2401DTO
	 * @return IGCRC2401DTO
	 */
	public IGCRC2401DTO getFindStatistics(IGCRC2401DTO dto);
	
	
	/**
	 * 事件平均解决时间处理
	 * 开始时间-确认时间
	 * zhangq
	 * @param dto IGCRC2401DTO
	 * @return IGCRC2401DTO
	 */
	public IGCRC2401DTO getFindStatisticsConfirm(IGCRC2401DTO dto);
	
	
	
	
	

}

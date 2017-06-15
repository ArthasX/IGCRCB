/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.alarm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM04DTO;



/**
 * 告警信息查询逻辑接口
 *
 *	@author liupeng@deliverik.com
 */
public interface IGALM04BL extends BaseBL {
	
	/**
	 * 告警信息查询
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGALM04DTO searchCRM04Action(IGALM04DTO dto) throws BLException;
	
	/**
	 * 获取告警级别
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGALM04DTO getAlarmPriority(IGALM04DTO dto) throws BLException;
	
	/**
	 * 获取实时数据刷新频率
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGALM04DTO getRefreshRate(IGALM04DTO dto) throws BLException;
}

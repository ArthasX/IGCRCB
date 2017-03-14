/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.syslog.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.syslog.dto.IGLOG00DTO;

/**
 * 设备实时、历史日志告警业务逻辑接口
 * @author 王省
 *
 */
public interface IGLOG00BL extends BaseBL{
	
	/**
	 * 设备实时告警查询处理
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws Exception
	 */
	public IGLOG00DTO searchSysLogAlarmListAction(IGLOG00DTO dto) throws BLException, Exception;
	
	/**
	 * 设备历史告警查询处理
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws Exception
	 */
	public IGLOG00DTO searchHistorySysLogAlarmListAction(IGLOG00DTO dto) throws BLException, Exception;
	
	/**
	 * 设备实时日志修复处理
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws Exception
	 */
	public IGLOG00DTO FixSysLogAlarmsAction(IGLOG00DTO dto) throws BLException, Exception;
	
	/**
	 * 不带分页的设备历史告警查询处理，用于Excel导出
	 * @return
	 * @throws BLException
	 * @throws Exception
	 */
	public IGLOG00DTO searchHistorySysLogAlarmListNopageAction(IGLOG00DTO dto) throws BLException, Exception;
	
	/**
	 * 获取告警级别列表
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGLOG00DTO getAlarmPriority(IGLOG00DTO dto) throws Exception;
	
	/**
	 * 设备告警带流程的列表
	 * @作者 zhaoyong
	 */
	public IGLOG00DTO searchSysLogAlarmListActionWithProcess(IGLOG00DTO dto)throws BLException;
	
	/**
	 * 获取实时数据刷新频率
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG00DTO getRefreshRate(IGLOG00DTO dto) throws BLException;

	
	

}

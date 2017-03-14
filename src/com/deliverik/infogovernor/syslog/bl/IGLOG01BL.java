/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.syslog.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.syslog.dto.IGLOG01DTO;

/**
 * 设备实时、历史日志业务逻辑接口
 * @author 王省
 *
 */
public interface IGLOG01BL extends BaseBL{
	
	public IGLOG01DTO searchUserRole(IGLOG01DTO dto) throws BLException, Exception;
	
	/**
	 * 设备实时日志查询处理
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws Exception
	 */
	public IGLOG01DTO searchSysLogListAction(IGLOG01DTO dto) throws BLException, Exception;
	
	/**
	 * 设备历史日志查询处理
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws Exception
	 */
	public IGLOG01DTO searchHistorySysLogListAction(IGLOG01DTO dto) throws BLException, Exception;
	
	/**
	 * 不带分页的设备历史日志查询处理，用于Excel导出
	 * @return
	 * @throws BLException
	 * @throws Exception
	 */
	public IGLOG01DTO searchHistorySysLogListNopageAction(IGLOG01DTO dto) throws BLException, Exception;
	
	/**
	 * 获取告警级别
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGLOG01DTO getAlarmPriority(IGLOG01DTO dto) throws Exception;
	
	/**
	 * 获取实时数据刷新频率
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG01DTO getRefreshRate(IGLOG01DTO dto) throws BLException;
	
	
	public IGLOG01DTO getCodeList(IGLOG01DTO dto) throws BLException;

	public IGLOG01DTO echoData(IGLOG01DTO dto) throws BLException;

	public void deleteData(IGLOG01DTO dto) throws BLException;

	public IGLOG01DTO searchHistoryChecked(IGLOG01DTO dto) throws BLException,
			Exception;

	public void delete00013TB(IGLOG01DTO dto) throws BLException;

	public IGLOG01DTO findAllMS00013(IGLOG01DTO dto);

	public boolean SearchCount(IGLOG01DTO dto);
	/**
	 * 设备告警带流程的列表
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG01DTO searchSysLogAlarmListActionWithProcess(IGLOG01DTO dto) throws BLException;
	
	/**
	 * 告警修复
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG01DTO FixSysLogAlarmsAction(IGLOG01DTO dto) throws BLException;
	
	/**
	 * 获取设备日志实体
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG01DTO getSysLogBean(IGLOG01DTO dto) throws BLException;
	
	/**
	 * 设备日志屏蔽逻辑处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG01DTO doFilter(IGLOG01DTO dto) throws BLException;
	
	/**
	 * 把IG库实时表（MSS00008）中屏蔽状态的数据移动到HQ库历史表中（MSS00009）
	 * @throws Exception
	 */
	public void moveFilterSyslogToHistoryDB() throws Exception;
	
	
	/**
	 * 获取syslog告警总数
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGLOG01DTO getAlarmTotalcount(IGLOG01DTO dto) throws Exception;
	
	
	/**
	 * 设备历史告警带流程的列表
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG01DTO searchSysLogHistoryAlarmListActionWithProcess(IGLOG01DTO dto)
			throws BLException;
}

package com.deliverik.infogovernor.syslog.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.syslog.dto.IGLOG0021DTO;

public interface IGLOG002BL extends BaseBL{

	/**
	 * 
	 * 设备列表查询
	 *
	 * @作者 zhaoyong
	 */
	public IGLOG0021DTO searchDeviceTemps(IGLOG0021DTO dto) throws Exception;
	
	/**
	 * 告警模板列表查询
	 * @param dto 
	 *
	 * @作者 zhaoyong
	 */
	public IGLOG0021DTO searchAllTemp(IGLOG0021DTO dto) throws BLException;
	
	/**
	 * 
	 * 更改规则的状态
	 * @throws BLException 
	 *
	 * @作者 zhaoyong
	 */
	public IGLOG0021DTO changeTempstate(IGLOG0021DTO dto) throws BLException;
	
	/**
	 * 获取当前告警规则模板
	 * @param dto
	 * @return
	 */
	public IGLOG0021DTO getAlarmRule(IGLOG0021DTO dto) throws BLException;
	
	/**
	 * 删除选定告警规则
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG0021DTO deleteAlarmRule(IGLOG0021DTO dto) throws BLException;
	

	/**
	 * 
	 * 告警规则录入
	 *
	 * @作者 zhaoyong
	 */
	public IGLOG0021DTO insertDeviceAndRules(IGLOG0021DTO dto)throws BLException;
	
	/**
	 * 告警规则修改
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG0021DTO updateDeviceAndRules(IGLOG0021DTO dto)throws BLException;
	
	/**
	 * 通过设备类型获取该类型设备列表
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG0021DTO getDevicesByTypeid(IGLOG0021DTO dto) throws BLException; 
	
	/**
	 * 通过设备类型获取改类型规则列表
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG0021DTO getRuleTempsByTypeid(IGLOG0021DTO dto) throws BLException;
	
	/**
	 * 根据设备ID获取设备信息
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGLOG0021DTO getDevice(IGLOG0021DTO dto) throws Exception;
	
	/**
	 * 通过IP获取设备信息
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGLOG0021DTO getDeviceByIp(IGLOG0021DTO dto) throws Exception;
	
	/**
	 * 根据设备ID获取所属规则列表
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGLOG0021DTO getRuleTempsByDeviceid(IGLOG0021DTO dto) throws Exception;
	
	/**
	 * 根据设备ID取得关系实体（Mss00002）
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGLOG0021DTO getRelationEntityByDeviceid(IGLOG0021DTO dto) throws Exception;
	
	/**
	 * 快速配置告警规则
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGLOG0021DTO fastConfigAlarmRule(IGLOG0021DTO dto) throws Exception;
	
	
}

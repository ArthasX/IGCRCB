package com.deliverik.infogovernor.syslog.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.syslog.dto.IGLOG0041DTO;

public interface IGLOG004BL extends BaseBL{
	/**
	 * 
	 * 查询规则模板
	 *
	 * @作者 zhaoyong
	 */
	public IGLOG0041DTO searchMss00004(IGLOG0041DTO dto);
	
	/**
	 * 
	 * 更改模板的状态
	 * @throws BLException 
	 *
	 * @作者 zhaoyong
	 */
	public IGLOG0041DTO changeTempstate(IGLOG0041DTO dto) throws BLException;

	/**
	 * 
	 * 录入规则条件模板
	 * @throws BLException 
	 *
	 * @作者 zhaoyong
	 */
	public IGLOG0041DTO insertMss0004(IGLOG0041DTO dto) throws BLException;
	
	/**
	 * 修改规则条件模板
	 * @作者 zhaoyong
	 */
	public IGLOG0041DTO updateMss0004(IGLOG0041DTO dto)throws BLException;
	
	/**
	 * 
	 * 获得当前规则条件模板
	 *
	 * @作者 zhaoyong
	 */
	public IGLOG0041DTO getMss0004(IGLOG0041DTO dto)throws BLException;

	/**
	 * 删除当前模板
	 * @作者 zhaoyong
	 */
	public void deleteTemp(IGLOG0041DTO dto)throws BLException;
	
	/**
	 * 从基础数据表（codedetail）获取告警级别
	 * @return
	 * @throws Exception
	 */
	public IGLOG0041DTO getAlarmPriority(IGLOG0041DTO dto) throws Exception;
	
	
	/**
	 * 获取某个模板的设备列表（字符串形式）
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGLOG0041DTO getDeviceListString(IGLOG0041DTO dto) throws Exception;
}

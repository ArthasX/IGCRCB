package com.deliverik.infogovernor.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dto.IGCOM04DTO;
/**
 * 修改记录：yangliang 2010/12/01 增加全部工作
 * 修改记录：LuJiayuan 2013/01/31 版本迁移SOC原功能由原来的IGCOM04BL更名为IGCOM07BL
 */
public interface IGCOM07BL extends BaseBL {
	public IGCOM04DTO getWorkAssigned(IGCOM04DTO dto) throws BLException;
	public IGCOM04DTO getProcessRecordList(IGCOM04DTO dto) throws BLException;
	/**
	 * 获取全部工作 
	 * @param dto
	 * @return IGCOM04DTO
	 * @throws BLException
	 */
	public IGCOM04DTO getProcessRecordListALL(IGCOM04DTO dto) throws BLException;
}
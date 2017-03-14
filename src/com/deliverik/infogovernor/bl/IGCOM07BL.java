package com.deliverik.infogovernor.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dto.IGCOM04DTO;
/**
 * �޸ļ�¼��yangliang 2010/12/01 ����ȫ������
 * �޸ļ�¼��LuJiayuan 2013/01/31 �汾Ǩ��SOCԭ������ԭ����IGCOM04BL����ΪIGCOM07BL
 */
public interface IGCOM07BL extends BaseBL {
	public IGCOM04DTO getWorkAssigned(IGCOM04DTO dto) throws BLException;
	public IGCOM04DTO getProcessRecordList(IGCOM04DTO dto) throws BLException;
	/**
	 * ��ȡȫ������ 
	 * @param dto
	 * @return IGCOM04DTO
	 * @throws BLException
	 */
	public IGCOM04DTO getProcessRecordListALL(IGCOM04DTO dto) throws BLException;
}
/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.crc.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.crc.dto.IGCRC2301DTO;


/**	
 * ����:���򿪷���ѯcontrolBL�ӿ�
 * ����������1.��ѯ��Ա������Ϣ�б�	
 * ������¼��yukexin    2014-8-12 10:52:29
 *         	
 */
public interface IGCRC23BL {
	/**
	 * ��Ա������Ϣ��ѯ����
	 *
	 * @param dto IGCRC2101DTO
	 * @return IGCRC2101DTO
	 */
	public IGCRC2301DTO searchEntityItemAction(IGCRC2301DTO dto) throws BLException;
	
	
	
	public IGCRC2301DTO searchIG500ItemAction(IGCRC2301DTO dto) throws BLException;
	
}

/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC2201DTO;

/**	
 * ����:�������ͳ���߼��ӿ�
 * ������¼��yukexin    2014-8-15 ����5:11:05	
 * �޸ļ�¼��null
 */	
public interface IGCRC22BL extends BaseBL {

	/**
	 * �������ͳ�Ʋ�ѯ����
	 * 
	 * @param igcrc22dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC2201DTO searchEntityItemAction(IGCRC2201DTO dto) throws BLException;
}

package com.deliverik.infogovernor.soc.cim.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM09DTO;


/**
 * �������BL
 * @author Administrator
 *
 */
public interface IGCIM09BL {
	
	/**
	 * �豸��Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM09DTO searchEntityItemAction(IGCIM09DTO dto) throws BLException;
	
}

package com.deliverik.infogovernor.soc.aff.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.aff.dto.IGAFF01DTO;

/**
 * �豸Ӱ�����ҵ���߼��ӿ�
 *
 * 
 */
public interface IGAFF01BL extends BaseBL {

	public IGAFF01DTO searchEntityItems(IGAFF01DTO dto) throws BLException;
	
}

package com.deliverik.infogovernor.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dto.IGCOM04DTO;

public interface IGCOM06BL extends BaseBL {
	public IGCOM04DTO getWorkAssigned(IGCOM04DTO dto) throws BLException;

}

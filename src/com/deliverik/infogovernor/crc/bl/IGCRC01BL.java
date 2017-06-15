package com.deliverik.infogovernor.crc.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.wkm.dto.IGWKM01DTO;

public interface IGCRC01BL {
	public IGWKM01DTO searchWorkList(IGWKM01DTO dto) throws BLException;
}

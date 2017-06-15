package com.deliverik.infogovernor.soc.aff.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.aff.dto.IGAFF01DTO;

/**
 * 设备影响分析业务逻辑接口
 *
 * 
 */
public interface IGAFF00BL extends BaseBL {

	public IGAFF01DTO searchEntityItems(IGAFF01DTO dto) throws BLException;
	
}

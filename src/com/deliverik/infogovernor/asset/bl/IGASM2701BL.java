package com.deliverik.infogovernor.asset.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM2701DTO;

public interface IGASM2701BL extends BaseBL{
	
	/**
	 * 系统信息查询处理
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM2701DTO searchRiskPointManagerAction(IGASM2701DTO dto) throws BLException;

	
	public IGASM2701DTO searchRiskPropertyActioin(IGASM2701DTO dto) throws BLException;
}

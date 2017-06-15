package com.deliverik.infogovernor.soc.cim.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM17DTO;

public interface IGCIM17BL extends BaseBL{
	

	/**
	 * ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM17DTO searchSoc0153List(IGCIM17DTO dto)throws BLException;
	
	/**
	 * ��ѯ������Ϣ
	 * @param dto
	 * @return
	 */
	public IGCIM17DTO searchSoc0113Info(IGCIM17DTO dto);
}

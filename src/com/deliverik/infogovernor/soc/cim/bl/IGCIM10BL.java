package com.deliverik.infogovernor.soc.cim.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM10DTO;

/**
 * ��ռ䷥ֵ�趨ҵ���߼��ӿ�
 *
 * 
 */
public interface IGCIM10BL extends BaseBL {


	/**
	 * ��ռ䷥ֵ�趨��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM10DTO searchCutItemAction(IGCIM10DTO dto) throws BLException;
	
	public IGCIM10DTO updateCutValueAction(IGCIM10DTO dto) throws BLException;
	
}

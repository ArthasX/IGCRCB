/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.ram.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.ram.dto.IGRAM01DTO;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;

/**
 * ��������ҵ���߼��ӿ�
 *
 *	@author tangzhen@deliverik.com
 */
public interface IGRAM01BL extends BaseBL {
	
	//-----------------------------------------------------------��ư汾----------------------------------------------------------------------
	
	/**
	 * ���������������̶����ѯ����
	 *
	 * @param dto IGRAM01DTO
	 * @return IGRAM01DTO
	 */
	public IGRAM01DTO searchWD4typeProcessDef(IGRAM01DTO dto) throws BLException;
	
	
}

/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.smr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.dto.IGSMR01DTO;

/**
 * �걨�ҵ���߼��ӿ�
 *
 */
public interface IGSMR01BL extends BaseBL {
	
	/**
	 * �걨������
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR01DTO insertSMR0101Action(IGSMR01DTO dto) throws BLException;
	
}

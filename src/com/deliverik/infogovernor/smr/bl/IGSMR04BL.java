/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.dto.IGSMR04DTO;

/**
 * �걨����ҵ���߼��ӿ�
 *
 */
public interface IGSMR04BL extends BaseBL {

	/**
	 * �걨��ϸ�б��ѯ����
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR04DTO initIGSMR0402Action(IGSMR04DTO dto) throws BLException;
	
	/**
	 * �걨��������
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR04DTO managerIGSMR0402Action (IGSMR04DTO dto) throws BLException;
	
}

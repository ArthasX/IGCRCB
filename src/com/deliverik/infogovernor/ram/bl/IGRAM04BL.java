package com.deliverik.infogovernor.ram.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.ram.dto.IGRAM04DTO;


/**
 * �������� ҵ���߼��ӿ�
 *
 *
 */
public interface IGRAM04BL extends BaseBL {

	/**
	 * <p>
	 * Description: �����������������ͳ��
	 * </p>
	 * 
	 * @param dto IGSVC13DTO
	 * @return IGSVC13DTO
	 * @throws BLException
	 * @author tangzhen@deliverik.com
	 */
	
	public IGRAM04DTO getAssessmentYearReport(IGRAM04DTO dto)throws BLException;
	
}

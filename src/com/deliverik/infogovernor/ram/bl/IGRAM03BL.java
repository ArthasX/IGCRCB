package com.deliverik.infogovernor.ram.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.ram.dto.IGRAM03DTO;


/**
 * ����������������ͳ�� ҵ���߼��ӿ�
 *
 *
 */
public interface IGRAM03BL extends BaseBL {

	/**
	 * <p>
	 * Description: ������������������ͳ��
	 * </p>
	 * 
	 * @param dto IGSVC13DTO
	 * @return IGSVC13DTO
	 * @throws BLException
	 * @author tangzhen@deliverik.com
	 */
	
	public IGRAM03DTO getAssessmentOrgReport(IGRAM03DTO dto)throws BLException;
	
}

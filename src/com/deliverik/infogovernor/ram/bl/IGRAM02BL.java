package com.deliverik.infogovernor.ram.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.ram.dto.IGRAM02DTO;


/**
 * �������� ҵ���߼��ӿ�
 *
 *
 */
public interface IGRAM02BL extends BaseBL {

	/**
	 * <p>
	 * Description: ����������ʷ���ֲ�ѯ
	 * </p>
	 */
	public IGRAM02DTO searchAssessmentScoreHistory(IGRAM02DTO dto) throws BLException;
	
}

package com.deliverik.infogovernor.ram.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.ram.dto.IGRAM03DTO;


/**
 * 风险评估部门评估统计 业务逻辑接口
 *
 *
 */
public interface IGRAM03BL extends BaseBL {

	/**
	 * <p>
	 * Description: 服务商评估部门评估统计
	 * </p>
	 * 
	 * @param dto IGSVC13DTO
	 * @return IGSVC13DTO
	 * @throws BLException
	 * @author tangzhen@deliverik.com
	 */
	
	public IGRAM03DTO getAssessmentOrgReport(IGRAM03DTO dto)throws BLException;
	
}

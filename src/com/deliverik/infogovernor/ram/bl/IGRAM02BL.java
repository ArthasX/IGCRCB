package com.deliverik.infogovernor.ram.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.ram.dto.IGRAM02DTO;


/**
 * 风险评估 业务逻辑接口
 *
 *
 */
public interface IGRAM02BL extends BaseBL {

	/**
	 * <p>
	 * Description: 风险评估历史评分查询
	 * </p>
	 */
	public IGRAM02DTO searchAssessmentScoreHistory(IGRAM02DTO dto) throws BLException;
	
}

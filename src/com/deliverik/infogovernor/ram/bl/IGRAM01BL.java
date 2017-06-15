/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.ram.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.ram.dto.IGRAM01DTO;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;

/**
 * 风险评估业务逻辑接口
 *
 *	@author tangzhen@deliverik.com
 */
public interface IGRAM01BL extends BaseBL {
	
	//-----------------------------------------------------------审计版本----------------------------------------------------------------------
	
	/**
	 * 风险评估类型流程定义查询处理
	 *
	 * @param dto IGRAM01DTO
	 * @return IGRAM01DTO
	 */
	public IGRAM01DTO searchWD4typeProcessDef(IGRAM01DTO dto) throws BLException;
	
	
}

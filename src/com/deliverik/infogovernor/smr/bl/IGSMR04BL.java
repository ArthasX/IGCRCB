/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.dto.IGSMR04DTO;

/**
 * 年报审批业务逻辑接口
 *
 */
public interface IGSMR04BL extends BaseBL {

	/**
	 * 年报明细列表查询处理
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR04DTO initIGSMR0402Action(IGSMR04DTO dto) throws BLException;
	
	/**
	 * 年报审批处理
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR04DTO managerIGSMR0402Action (IGSMR04DTO dto) throws BLException;
	
}

/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.smr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.dto.IGSMR01DTO;

/**
 * 年报填报业务逻辑接口
 *
 */
public interface IGSMR01BL extends BaseBL {
	
	/**
	 * 年报发起处理
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR01DTO insertSMR0101Action(IGSMR01DTO dto) throws BLException;
	
}

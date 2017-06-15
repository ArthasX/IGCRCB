/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.wim.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.wim.dto.IGWIM01DTO;

/**
 * @Description 工作项管理BL接口
 * 
 * @date 2017年6月9日16:12:59
 * 
 * @author WangLiang
 *
 */
public interface IGWIM01BL extends BaseBL{

	/**
	 * @Description 工作项登记
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO insertWorkDefinitionAction(IGWIM01DTO dto) throws BLException;
}

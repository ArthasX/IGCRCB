/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prr.dto.IGPRR05DTO;

/**
 * 概述: 流程组BL
 * 功能描述: 流程组BL
 * 创建记录: 2015/02/03
 * 修改记录: 
 */
public interface IGPRR05BL extends BaseBL{

	/**
	 * 流程组查询
	 * @param dto IGPRR05DTO
	 * @return IGPRR05DTO
	 * @throws BLException
	 */
	public IGPRR05DTO searchGroupAction(IGPRR05DTO dto) throws BLException;
	
	/**
	 * 流程组成员查询
	 * @param dto IGPRR05DTO
	 * @return IGPRR05DTO
	 * @throws BLException
	 */
	public IGPRR05DTO searchProcessAction(IGPRR05DTO dto) throws BLException;

}

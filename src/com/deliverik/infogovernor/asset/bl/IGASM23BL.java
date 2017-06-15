/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM23DTO;
/**
 * 概述: 资产域定义业务逻辑接口
 * 功能描述: 资产域定义业务逻辑接口
 * 创建记录: 2311/04/25
 * 修改记录: 
 */
public interface IGASM23BL extends BaseBL{

	/**
	 * 采集控制台查询处理
	 * @param dto IGASM23DTO
	 * @throws BLException
	 */
	public IGASM23DTO initIGASM2301Action(IGASM23DTO dto) throws BLException;
	
	/**
	 * 采集处理
	 * @param dto IGASM23DTO
	 * @throws BLException
	 */
	public IGASM23DTO collectIGASM2301Action(IGASM23DTO dto) throws BLException;
	
}

/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM17DTO;

/**
 * 概述: 流程策略设定查询Action处理
 * 功能描述：流程策略设定查询Action处理
 * 创建记录：刘鹏    2010/11/26
 * 修改记录：
 */
public interface IGSYM17BL extends BaseBL {
	
	/**
	 * 功能：流程定义信息查询处理
	 * 
	 * @param dto IGSYM17DTO
	 * @return IGSYM17DTO
	 */
	public IGSYM17DTO searchProcessDefinitionAction(IGSYM17DTO dto) throws BLException;
	
	/**
	 * 功能：流程策略设定查询处理
	 * 
	 * @param dto IGSYM17DTO
	 * @return IGSYM17DTO
	 */
	public IGSYM17DTO initIGSYM1702Action(IGSYM17DTO dto) throws BLException;
	
	/**
	 * 功能：流程策略设定编辑处理
	 * 
	 * @param dto IGSYM17DTO
	 * @return IGSYM17DTO
	 */
	public IGSYM17DTO editIGSYM1702Action(IGSYM17DTO dto) throws BLException;
	
}

/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.soc.prm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.prm.dto.IGPRM00DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_流程发起_选择流程类型业务接口
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface IGPRM00BL extends BaseBL {

	/**
	 * 查询流程类型
	 * @param dto IGPRM00DTO
	 * @return IGPRM00DTO
	 * @throws BLException
	 */
	
	public IGPRM00DTO searchProcessDefinitionAction(IGPRM00DTO dto) throws BLException;
	
	/**
	 * 查询工作类型
	 * @param dto IGPRM00DTO
	 * @return IGPRM00DTO
	 * @throws BLException
	 */
	
	public IGPRM00DTO searchWorkDefinitionAction(IGPRM00DTO dto) throws BLException;
	
	/**
	 * 查询工作类型
	 * @param dto IGPRM00DTO
	 * @return IGPRM00DTO
	 * @throws BLException
	 */
	
	public IGPRM00DTO searchWorkDefinitionTreeAction(IGPRM00DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 查询可快捷发起流程类型
	 * </p>
	 * 
	 * @param dto IGPRM00DTO
	 * @return IGPRM00DTO
	 * @throws BLException
	 */
	
	public IGPRM00DTO searchQuickProcessDefinitionAction(IGPRM00DTO dto) throws BLException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException;
	
	
}

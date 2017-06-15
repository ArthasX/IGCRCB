/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.prm.dto.IGPRM00DTO;

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
	 * 查询流程类型
	 * @param dto IGPRM00DTO
	 * @return IGPRM00DTO
	 * @throws BLException
	 */
	public IGPRM00DTO searchProcessDefinition(User user,UserPermission up,IGPRM00DTO dto) throws BLException;
	
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
	
	/**
     * <p>
     * 查询流程定义中相关发起按钮定义的可发起流程类型
     * </p>
     * 
     * @param dto IGPRM00DTO
     * @return IGPRM00DTO
     * @throws BLException
     * @throws NoSuchFieldException 
     * @throws SecurityException 
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    
    public IGPRM00DTO searchRelevantProcessAction(IGPRM00DTO dto) throws BLException	;
}

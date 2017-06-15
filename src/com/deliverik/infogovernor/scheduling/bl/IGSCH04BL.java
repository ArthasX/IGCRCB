/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.scheduling.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.scheduling.dto.IGSCH04DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务策略_事件监督接口
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface IGSCH04BL extends BaseBL {
	
	/**
	 * 查询事件经理
	 * 
	 * @param dto IGSCH04DTO
	 * @return IGSCH04DTO
	 * @throws BLException
	 */
	public IGSCH04DTO searchRoleAction(IGSCH04DTO dto) throws BLException;
	
	/**
	 * 查询工作
	 * @param dto IGSCH04DTO
	 * @return IGSCH04DTO
	 * @throws BLException
	 */
	
	public IGSCH04DTO searchQuartzJobsAction(IGSCH04DTO dto) throws BLException;
	
	/**
	 * 保存工作
	 * @param dto IGSCH04DTO
	 * @return IGSCH04DTO
	 * @throws BLException
	 */
	
	public IGSCH04DTO saveQuartzJobsAction(IGSCH04DTO dto) throws BLException;
	
	/**
	 * 中止工作
	 * 
	 * @param dto IGSCH04DTO
	 * @return IGSCH04DTO
	 * @throws BLException
	 */
	public IGSCH04DTO removeQuartzJobsAction(IGSCH04DTO dto) throws BLException;
	
	/**
	 * 删除工作
	 * 
	 * @param dto IGSCH04DTO
	 * @return IGSCH04DTO
	 * @throws BLException
	 */
	public IGSCH04DTO deleteQuartzJobsAction(IGSCH04DTO dto) throws BLException;
}

/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sdl.dto.IGSDL06DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_变更KPI统计业务逻辑接口
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */
public interface IGSDL06BL extends BaseBL {


	/**
	 * 变更KPI统计查询处理
	 *
	 * @param dto IGSDL06DTO
	 * @return IGSDL06DTO
	 */
	public IGSDL06DTO searchChangeKpiAction(IGSDL06DTO dto) throws BLException;
		
}
	

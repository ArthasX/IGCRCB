/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sdl.dto.IGSDL07DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_事件KPI统计业务逻辑接口
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */
public interface IGSDL07BL extends BaseBL {


	/**
	 * 事件KPI统计查询处理
	 *
	 * @param dto IGSDL07DTO
	 * @return IGSDL07DTO
	 */
	public IGSDL07DTO searchIncidentKpiListAction(IGSDL07DTO dto) throws BLException;
	
	/**
	 * 事件KPI统计信息事件类别Map查询处理
	 *
	 * @param dto IGSDL07DTO
	 * @return IGSDL07DTO
	 */
	public IGSDL07DTO searchTypeMapAction(IGSDL07DTO dto) throws BLException;
	
	/**
	 * 事件KPI统计信息紧急程度Map查询处理
	 *
	 * @param dto IGSDL07DTO
	 * @return IGSDL07DTO
	 */
	public IGSDL07DTO searchUrgencyMapAction(IGSDL07DTO dto) throws BLException;
		
}
	

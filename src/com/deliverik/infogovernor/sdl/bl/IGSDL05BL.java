/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sdl.dto.IGSDL05DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_统计业务逻辑接口
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public interface IGSDL05BL extends BaseBL {


	/**
	 * 统计查询处理
	 *
	 * @param dto IGSDL05DTO
	 * @return IGSDL05DTO
	 */
	public IGSDL05DTO searchSdlSummaryAction(IGSDL05DTO dto) throws BLException;
	
	/**
	 * 信息查询处理
	 *
	 * @param dto IGSDL05DTO
	 * @return IGSDL05DTO
	 */
	public IGSDL05DTO searchSdlInfoAction(IGSDL05DTO dto) throws BLException;
	
	/**
	 * 信息详细信息处理
	 *
	 * @param dto IGSDL05DTO
	 * @return IGSDL05DTO
	 */
	public IGSDL05DTO searchSdlInfoDetailAction(IGSDL05DTO dto) throws BLException;

/**
	 * 统计查询处理
	 *
	 * @param dto IGSDL05DTO
	 * @return IGSDL05DTO
	 */
	public IGSDL05DTO searchSdlYearSummaryAction(IGSDL05DTO dto) throws BLException;
}
	

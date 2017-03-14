/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sdl.dto.IGSDL03DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_标准业务逻辑接口
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public interface IGSDL03BL extends BaseBL {


	/**
	 * 标准查询处理
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGSDL03DTO searchSdlDefineInfoAction(IGSDL03DTO dto) throws BLException;
	
	/**
	 * 标准登记处理
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGSDL03DTO insertSdlDefineInfoAction(IGSDL03DTO dto) throws BLException;
	
	/**
	 * 标准编辑画面初期显示处理
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGSDL03DTO initSdlDefineInfoAction(IGSDL03DTO dto) throws BLException;

	/**
	 * 标准更新处理
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGSDL03DTO updateSdlDefineInfoAction(IGSDL03DTO dto) throws BLException;

	/**
	 * 标准删除处理
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGSDL03DTO deleteSdlDefineInfoAction(IGSDL03DTO dto) throws BLException;

}
	

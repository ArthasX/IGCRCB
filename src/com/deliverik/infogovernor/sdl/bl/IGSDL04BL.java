/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sdl.dto.IGSDL04DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_信息业务逻辑接口
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public interface IGSDL04BL extends BaseBL {


	/**
	 * 信息查询处理
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO searchSdlInfoAction(IGSDL04DTO dto) throws BLException;
	
	/**
	 * 信息处理
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO insertSdlInfoAction(IGSDL04DTO dto) throws BLException;
	
	/**
	 * 信息编辑画面初期显示处理
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO initSdlInfoAction(IGSDL04DTO dto) throws BLException;

	/**
	 * 信息更新处理
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO updateSdlInfoAction(IGSDL04DTO dto) throws BLException;

	/**
	 * 信息删除处理
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO deleteSdlInfoAction(IGSDL04DTO dto) throws BLException;
	
	/**
	 * 信息详细信息处理
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO searchSdlInfoDetailAction(IGSDL04DTO dto) throws BLException;

}
	

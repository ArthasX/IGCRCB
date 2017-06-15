package com.deliverik.infogovernor.soc.vir.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR08DTO;

/**
 * 概述: 虚拟资源统计
 * 功能描述: 虚拟资源统计
 * 创建记录: 2014/02/12
 * 修改记录:
 */
public interface IGVIR08BL extends BaseBL {
	/**
	 * 虚拟资源统计(按用户)
	 *
	 * @param dto IGVIR08DTO
	 * @return IGVIR08DTO
	 */
	public IGVIR08DTO getVim03CountByUser(IGVIR08DTO dto) throws BLException;
	/**
	 * 虚拟资源统计(按用户)
	 *
	 * @param dto IGVIR08DTO
	 * @return IGVIR08DTO
	 */
	public IGVIR08DTO searchVim03ByUser(IGVIR08DTO dto) throws BLException;
	/**
	 * 虚拟资源统计(按机构)
	 *
	 * @param dto IGVIR08DTO
	 * @return IGVIR08DTO
	 */
	public IGVIR08DTO searchVim03ByOrg(IGVIR08DTO dto) throws BLException;
	/**
	 * 虚拟资源统计(按机构)
	 *
	 * @param dto IGVIR07DTO
	 * @return IGVIR07DTO
	 */
	public IGVIR08DTO getVim03CountByOrg(IGVIR08DTO dto) throws BLException;
	/**
	 * 虚拟资源统计
	 *
	 * @param dto IGVIR08DTO
	 * @return IGVIR08DTO
	 */
	public IGVIR08DTO searchVim03(IGVIR08DTO dto) throws BLException;
	/**
	 * 虚拟资源统计(按项目)
	 *
	 * @param dto IGVIR08DTO
	 * @return IGVIR08DTO
	 */
	public IGVIR08DTO getVim03CountByProj(IGVIR08DTO dto) throws BLException;
}

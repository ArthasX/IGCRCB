/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prr.dto.IGPRR02DTO;

/**
 * 概述:抄阅人 
 * 功能描述：抄阅人
 * 创建人：赵梓廷
 * 创建记录： 2013-02-25
 * 修改记录：
 */
public interface IGPRR02BL extends BaseBL {

	/**
	 * 查询抄阅人角色下的所有人
	 * @param dto
	 * @return IGPRR02DTO
	 * @throws BLException
	 */
	public IGPRR02DTO getPeopleUnderRoleAction(IGPRR02DTO dto) throws BLException;
	
	/**
	 * 根据流程id查询流程信息
	 * @param dto
	 * @return IGPRR02DTO
	 * @throws BLException
	 */
//	public IGPRR02DTO getProcessInfoByPkAction(IGPRR02DTO dto) throws BLException;
	
	/**
	 * 根据条件查询抄阅人信息
	 * @param dto
	 * @return IGPRR02DTO
	 * @throws BLException
	 */
	public IGPRR02DTO getCopyReadInfoByCondAction(IGPRR02DTO dto) throws BLException;
	/**
	 * 保存抄阅人信息
	 * @param dto
	 * @return IGPRR02DTO
	 * @throws BLException
	 */
	public IGPRR02DTO saveCopyReadInfoByPkAction(IGPRR02DTO dto) throws BLException;
	
	/**
	 * 点击确认按钮修改查看时间
	 * @param dto
	 * @return IGPRR02DTO
	 * @throws BLException
	 */
	public IGPRR02DTO updateIsLookAction(IGPRR02DTO dto) throws BLException;
	
	/**
     * 生成影像文件
     *
     * @param dto IGPRR01DTO
     * @return IGPRR01DTO
     */
    public IGPRR02DTO generateImageAction(IGPRR02DTO dto)throws BLException;

}

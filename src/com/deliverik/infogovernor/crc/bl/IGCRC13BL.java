/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.crc.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.crc.dto.IGCRC1301DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC1302DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC1303DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC1304DTO;


/**	
 * 概述:文档查询controlBL接口
 * 功能描述：1.查询文档信息列表	
 * 创建记录：shenbing    2014/7/15	
 *         	
 */
public interface IGCRC13BL {
	/**
	 * 文档信息查询处理
	 *
	 * @param dto IGCRC1301DTO
	 * @return IGCRC1301DTO
	 */
	public IGCRC1301DTO searchEntityItemAction(IGCRC1301DTO dto) throws BLException;
	
	/**
	 * 文档信息查询处理
	 *
	 * @param dto IGCRC1301DTO
	 * @return IGCRC1301DTO
	 */
	public IGCRC1301DTO openSearchEntityItemAction(IGCRC1301DTO dto) throws BLException;

	/**
	 * 按文档类型统计处理
	 *
	 * @param dto IGCRC1301DTO
	 * @return IGCRC1301DTO
	 */
	public IGCRC1303DTO searchEntitySumAction(IGCRC1303DTO dto) throws BLException;
	
	/**
	 * 按部门统计文档处理
	 *
	 * @param dto IGCRC1301DTO
	 * @return IGCRC1301DTO
	 */
	public IGCRC1304DTO searchDepartSumAction(IGCRC1304DTO dto) throws BLException;
	/**
	 * <p>
	 * 我的借阅，获取用户发起的文档借阅
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	public IGCRC1302DTO getWorkInitByMe(IGCRC1302DTO dto) throws BLException;
	
	/**
	 * 文档存量统计详细查询
	 * 
	 * @param dto
	 * @return
	 */
	public IGCRC1301DTO searchItemAction(IGCRC1301DTO dto) throws BLException;
	
	
	/**
	 * 文档存量统计关联流程查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC1304DTO searchIG500ItemAction(IGCRC1304DTO dto)throws BLException;
	
}

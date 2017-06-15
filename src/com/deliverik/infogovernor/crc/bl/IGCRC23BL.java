/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.crc.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.crc.dto.IGCRC2301DTO;


/**	
 * 概述:程序开发查询controlBL接口
 * 功能描述：1.查询人员工作信息列表	
 * 创建记录：yukexin    2014-8-12 10:52:29
 *         	
 */
public interface IGCRC23BL {
	/**
	 * 人员工作信息查询处理
	 *
	 * @param dto IGCRC2101DTO
	 * @return IGCRC2101DTO
	 */
	public IGCRC2301DTO searchEntityItemAction(IGCRC2301DTO dto) throws BLException;
	
	
	
	public IGCRC2301DTO searchIG500ItemAction(IGCRC2301DTO dto) throws BLException;
	
}

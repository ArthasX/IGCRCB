/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC2201DTO;

/**	
 * 概述:变更总体统计逻辑接口
 * 创建记录：yukexin    2014-8-15 下午5:11:05	
 * 修改记录：null
 */	
public interface IGCRC22BL extends BaseBL {

	/**
	 * 变更总体统计查询处理
	 * 
	 * @param igcrc22dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC2201DTO searchEntityItemAction(IGCRC2201DTO dto) throws BLException;
}

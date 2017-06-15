package com.deliverik.infogovernor.asset.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM25DTO;

/**
 *  服务记录统计业务逻辑接口
 *
 * 
 */
public interface IGASM25BL extends BaseBL {


	/**
	 * 服务记录统计信息查询处理
	 *
	 * @param dto IGASM21DTO
	 * @return IGASM21DTO
	 */
	public IGASM25DTO searchEntityItemRelationVW(IGASM25DTO dto) throws BLException;
	
	/**
	 * 服务记录明细信息查询处理
	 *
	 * @param dto IGASM21DTO
	 * @return IGASM21DTO
	 */
	public IGASM25DTO searchEntityItemRelationDetailVW(IGASM25DTO dto) throws BLException;
	
}

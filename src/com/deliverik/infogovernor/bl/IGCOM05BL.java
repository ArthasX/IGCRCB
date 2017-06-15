package com.deliverik.infogovernor.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dto.IGCOM05DTO;

/**
 * portal页通知接口
 *
 *
 */
public interface IGCOM05BL extends BaseBL {


	/**
	 * 查询存在的通知
	 */
	public IGCOM05DTO getNotice(IGCOM05DTO dto) throws BLException;


	
}

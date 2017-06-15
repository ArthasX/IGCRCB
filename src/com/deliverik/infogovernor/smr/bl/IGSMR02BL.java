/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.smr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.dto.IGSMR02DTO;

/**
 * 审批意见业务逻辑接口
 *
 */
public interface IGSMR02BL  extends BaseBL  {

	/**
	 * 表单中有效审批意见信息查询方法
	 * 
	 * @param dto 
	 * @return IGSMR02DTO
	 */
	public IGSMR02DTO searchApproveSuggestion(IGSMR02DTO dto) throws BLException;
	
	/**
	 * 表单所有审批意见信息查询方法
	 * 
	 * @param dto 
	 * @return IGSMR02DTO
	 */
	public IGSMR02DTO searchApproveSuggestionAllByPidid(IGSMR02DTO dto) throws BLException;
	
	/**
	 * 审批意见保存方法
	 * 
	 * @param dto 
	 * @return IGSMR02DTO
	 */
	public IGSMR02DTO saveApproveSuggestion(IGSMR02DTO dto) throws BLException;
}

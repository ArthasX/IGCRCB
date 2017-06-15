/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.emo.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.emo.dto.IGEMO01DTO;
/**
 * <p>
 * Title : InfoGovernor oracle性能监控
 * </p>
 * <p>
 * Description: oracle性能监控_BL
 * </p>
 * 
 * @version 
 */
public interface IGEMO01BL extends BaseBL{

	/**
	 * oracle性能监控处理
	 *
	 * @param dto IGDUT01DTO
	 * @return IGDUT01DTO
	 */
	public IGEMO01DTO getEmData(IGEMO01DTO dto) throws BLException;
}
/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.bl;

import com.deliverik.framework.base.BaseBL;



import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.prr.dto.IGPRR0702DTO;



public interface IGPRR07BL extends BaseBL {
	/**
	 * 设备信息登记处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGPRR0702DTO insertEntityItemAction(IGPRR0702DTO dto) throws BLException;
	/**
	 * 资产联动菜单,查询资产属性信息和资产模型属性信息
	 * 
	 * @param dto
	 * @return IGPRR0601DTO
	 */
	public IGPRR0702DTO getJsonString(IGPRR0702DTO dto);
	
}

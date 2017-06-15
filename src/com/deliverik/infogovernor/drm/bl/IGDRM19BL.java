/**
 * 
 */
package com.deliverik.infogovernor.drm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM19DTO;

/**
 * @author Administrator
 *
 */
public interface IGDRM19BL extends BaseBL{

	/**
	 * <p>
	 * Description: 查询工作记录
	 * </p>
	 * 
	 * @param dto IGWKM01DTO
	 * @return IGWKM01DTO
	 * @throws BLException
	 * @update sunkaiyu@deliverik.com
	 */
	
	public IGDRM19DTO getProcessRecords(IGDRM19DTO dto) throws BLException;
}

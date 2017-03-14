package com.deliverik.infogovernor.wki.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.wki.dto.IGWKI01DTO;

/**
 * 工作信息CRUD
 * @author KJB-001064
 *
 */
public interface IGWKI01BL extends BaseBL {
	
	/**
	 * 查询工作信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWKI01DTO searchWorkInfos(IGWKI01DTO dto)throws BLException;
	/**
	 * 新增
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWKI01DTO addWorkInfos(IGWKI01DTO dto)throws BLException;
	/**
	 * 更新
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWKI01DTO updateWorkInfos(IGWKI01DTO dto)throws BLException;
	
	
}

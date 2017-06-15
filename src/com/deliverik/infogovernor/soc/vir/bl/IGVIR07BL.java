package com.deliverik.infogovernor.soc.vir.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR07DTO;

/**
 * 设备配置管理业务逻辑接口
 *
 * 
 */
public interface IGVIR07BL extends BaseBL {
	
	/**
	 * vCenter信息新增
	 *
	 * @param dto IGVIR07DTO
	 * @return IGVIR07DTO
	 */
	public IGVIR07DTO registVIM01(IGVIR07DTO dto) throws BLException;
	/**
	 * vCenter信息新增
	 *
	 * @param dto IGVIR07DTO
	 * @return IGVIR07DTO
	 */
	public IGVIR07DTO searchVIM01(IGVIR07DTO dto) throws BLException;
	/**
	 * vCenter信息新增
	 *
	 * @param dto IGVIR07DTO
	 * @return IGVIR07DTO
	 */
	public IGVIR07DTO searchVIM01ByPK(IGVIR07DTO dto) throws BLException;
	/**
	 * vCenter信息主键删除
	 *
	 * @param dto IGVIR07DTO
	 * @return IGVIR07DTO
	 */
	public IGVIR07DTO deleteVIM01ByPK(IGVIR07DTO dto) throws BLException;
	/**
	 * vCenter信息主键删除
	 *
	 * @param dto IGVIR07DTO
	 * @return IGVIR07DTO
	 */
	public IGVIR07DTO checkVIM01ByURL(IGVIR07DTO dto) throws BLException;
}

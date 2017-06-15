package com.deliverik.infogovernor.soc.iop.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.iop.dto.IGIOP02DTO;

/**
 * 设备影响分析业务逻辑接口
 *
 * 
 */
public interface IGIOP02BL extends BaseBL {


	/**
	 * 根据IP资产的eiid 查询
	 * @param dto
	 * @return
	 */
	public IGIOP02DTO searchIPByEiids(IGIOP02DTO dto)throws BLException;
	/**
	 * IP资产查询
	 * @param dto
	 * @return
	 */
	public IGIOP02DTO searchIP(IGIOP02DTO dto)throws BLException;
	
	/**
	 * IP回收
	 * @param dto
	 * @return
	 */
	public IGIOP02DTO recoveryIP(IGIOP02DTO dto)throws BLException;
	
	/**
	 * 根据eiid 查询IP
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIOP02DTO getIPByEiid(IGIOP02DTO dto)throws BLException;
	
	/**
	 * IP分配
	 * @param dto
	 * @return
	 */
	public IGIOP02DTO allotIP(IGIOP02DTO dto)throws BLException;
	
}

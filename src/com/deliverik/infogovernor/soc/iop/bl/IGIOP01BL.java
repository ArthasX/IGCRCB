package com.deliverik.infogovernor.soc.iop.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.iop.dto.IGIOP01DTO;

/**
 * IP段登记业务逻辑接口
 *
 * 
 */
public interface IGIOP01BL extends BaseBL {

	/**
	 * 登记IP段
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIOP01DTO regIP(IGIOP01DTO dto)throws BLException;
	
	
	/**
	 * 查找子网信息
	 * @param dto
	 * @return
	 */
	public IGIOP01DTO searchIPS(IGIOP01DTO dto)throws BLException;
	
	/**
	 * 回收子网内的所有IP
	 * @param dto
	 * @return
	 * @throws BLException 
	 */
	public IGIOP01DTO recoveryAllIP(IGIOP01DTO dto) throws BLException;
	
	/**
	 * 查看段内IP
	 * @param dto
	 * @return
	 */
	public IGIOP01DTO showIP(IGIOP01DTO dto)throws BLException;
	
	/**
	 * 保存IP
	 * @param dto
	 * @return
	 */
	public IGIOP01DTO saveIP(IGIOP01DTO dto)throws BLException;
	
	/**
	 * 删除子网并删除子网内的IP
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIOP01DTO delSubNet(IGIOP01DTO dto)throws BLException;
	
	/**
	 * 根据IP资产的eiid 查询
	 * @param dto
	 * @return
	 */
	public IGIOP01DTO searchIPByEiids(IGIOP01DTO dto);
	
	/**
	 * IP分配
	 * @param dto
	 * @return
	 */
	public IGIOP01DTO allotIP(IGIOP01DTO dto)throws BLException;
	
	/**
	 * 登记子网
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIOP01DTO regSubNet(IGIOP01DTO dto) throws BLException;
	
	/**
	 * 分配子网
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIOP01DTO updateSubNet(IGIOP01DTO dto) throws BLException;
	
}

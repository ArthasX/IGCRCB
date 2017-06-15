package com.deliverik.infogovernor.soc.vir.bl;


import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR09DTO;

public interface IGVIR09BL extends BaseBL {
	
	/**
	 * 获取虚拟资源项
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR09DTO getConfigItemList(IGVIR09DTO dto) throws BLException;
	
	/**
	 * 添加虚拟资源计费策略
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR09DTO insertBillingStrategy(IGVIR09DTO dto) throws BLException;
	
	/**
	 * 虚拟资源计费策略查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR09DTO searchBillingStrategy(IGVIR09DTO dto) throws BLException;
	
	/**
	 * 通过id获取计费策略
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR09DTO getBillingStrategyByID(IGVIR09DTO dto) throws BLException;
	
	/**
	 * 修改计费策略
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR09DTO updateBillingStrategy(IGVIR09DTO dto) throws BLException;
	
	/**
	 * 删除计费策略
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR09DTO deleteBillingStrategy(IGVIR09DTO dto) throws BLException;
}

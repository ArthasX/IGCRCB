package com.deliverik.infogovernor.asset.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM32DTO;

/**
 * 风险事件管理业务逻辑接口
 *
 * 
 */
public interface IGASM32BL extends BaseBL {


	/**
	 * 风险事件查询处理
	 *
	 * @param dto IGASM32DTO
	 * @return IGASM32DTO
	 */
	public IGASM32DTO searchEntityItemAction(IGASM32DTO dto) throws BLException;
	
	/**
	 * 风险事件历史版本查询处理
	 *
	 * @param dto IGASM32DTO
	 * @return IGASM32DTO
	 */
	public IGASM32DTO searchEntityItemByVersion(IGASM32DTO dto) throws BLException;
	
	/**
	 * 风险事件应对策略
	 *
	 * @param dto IGASM32DTO
	 * @return IGASM32DTO
	 */
	public IGASM32DTO searchRiskPolicyAction(IGASM32DTO dto) throws BLException;
	
	/**
	 * 风险事件登记处理
	 *
	 * @param dto IGASM32DTO
	 * @return IGASM32DTO
	 */
	public IGASM32DTO insertEntityItemAction(IGASM32DTO dto) throws BLException;

	/**
	 * 风险事件修改处理
	 *
	 * @param dto IGASM32DTO
	 * @return IGASM32DTO
	 */
	public IGASM32DTO updateEntityItem(IGASM32DTO dto) throws BLException;
}

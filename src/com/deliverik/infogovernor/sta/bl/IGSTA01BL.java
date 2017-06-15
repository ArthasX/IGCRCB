/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sta.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sta.dto.IGSTA01DTO;

/**
 * 工作监督业务逻辑接口
 *
 *	@author liupeng@deliverik.com
 */
public interface IGSTA01BL extends BaseBL {
	
	/**
	 * 问题整改监督查询处理
	 *
	 * @param dto IGSTA01DTO
	 * @return IGSTA01DTO
	 */
	public IGSTA01DTO searchRiskcheckproblemsuperviseAction(IGSTA01DTO dto) throws BLException;
	
	/**
     * 合同统计查询处理
     *
     * @param dto IGSTA01DTO
     * @return IGSTA01DTO
     */
    public IGSTA01DTO searchContractAmountAction(IGSTA01DTO dto) throws BLException;
    
    /**
     * 项目统计查询处理
     *
     * @param dto IGSTA01DTO
     * @return IGSTA01DTO
     */
    public IGSTA01DTO searchPrjRecAction(IGSTA01DTO dto) throws BLException;
    
    /**
     * 合同模型labelvaluebean查询处理
     *
     * @param dto IGSTA01DTO
     * @return IGSTA01DTO
     */
    public IGSTA01DTO getContractLabel(IGSTA01DTO dto) throws BLException ;
    
    /**
     * 合同信息查询处理
     *
     * @param dto IGASM04DTO
     * @return IGASM04DTO
     */
    public IGSTA01DTO searchEntityItemAction(IGSTA01DTO dto) throws BLException;
}

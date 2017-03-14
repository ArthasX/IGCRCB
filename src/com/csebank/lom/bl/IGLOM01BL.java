/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl;

import com.csebank.lom.dto.IGLOM01DTO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 接待管理_接待管理设定_BL
 * </p>
 * 
 * @version 
 */
public interface IGLOM01BL extends BaseBL {
	
	/**
	 * 
	 * Description: 接待信息查询
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM01DTO searchRecptionAction(IGLOM01DTO dto) throws BLException;
	/**
	 * 外出就餐管理信息查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOM01DTO  searchDealInfo(IGLOM01DTO dto)throws BLException;
	
	/**
	 * 
	 * Description: 接待信息设定
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM01DTO insertRecptionAction(IGLOM01DTO dto) throws BLException;
	/**
	 * 外出就餐信息登记入库处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOM01DTO insetDealInfo(IGLOM01DTO dto)throws BLException;
	
	/**
	 * 
	 * Description: 接待信息变更
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM01DTO updateRecptionAction(IGLOM01DTO dto) throws BLException ;
	public IGLOM01DTO updateDealAction(IGLOM01DTO dto) throws BLException ;
	
	/**
	 * 状态更新初期显示
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO initRecption(IGLOM01DTO dto) throws BLException ;
	/**
	 * 状态更新初期显示
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO initDeal(IGLOM01DTO dto) throws BLException ;

	/**
	 * 状态更新处理
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO changeRecptionAction(IGLOM01DTO dto) throws BLException ;
	/**
	 * 外出就餐状态更新处理
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO changeDealAction(IGLOM01DTO dto) throws BLException ;
	/**
	 * 删除处理
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO deleteRecptionAction(IGLOM01DTO dto) throws BLException ;
	
	/**
	 * 删除处理
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO deleteDealAction(IGLOM01DTO dto) throws BLException ;

	
	/**
	 * 
	 * Description: 接待客人信息查询
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM01DTO searchRecptionGuestAction(IGLOM01DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: 接待客人信息设定
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM01DTO insertRecptionGuestAction(IGLOM01DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: 接待客人信息变更
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM01DTO updateRecptionGuestAction(IGLOM01DTO dto) throws BLException ;
	
	/**
	 * 接待客人初期显示
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO initRecptionGuest(IGLOM01DTO dto) throws BLException ;

	/**
	 * 接待客人删除处理
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO deleteRecptionGuestAction(IGLOM01DTO dto) throws BLException ;
	
	/**
	 * 
	 * 接待统计信息查询
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM01DTO searchRecptionVWAction(IGLOM01DTO dto) throws BLException;
	/**
	 * 
	 * 外出就餐统计信息查询
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM01DTO searchDealVWAction(IGLOM01DTO dto) throws BLException;
	
	/**
	 * 
	 * 部门接待统计信息查询
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM01DTO searchRecptionOrgVWAction(IGLOM01DTO dto) throws BLException;
	/**
	 * 
	 * 部门外出就餐统计信息查询
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM01DTO searchDealOrgVWAction(IGLOM01DTO dto) throws BLException;
	/**
	 * 
	 * Description: 接待客人查询画面
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM01DTO searchRecptionGuestInfoAction(IGLOM01DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: 根据客户信息查询接待工作信息画面
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 */
	public IGLOM01DTO searchRecptionByGusetAction(IGLOM01DTO dto) throws BLException;
	
	/**
	 * Description:接待工作费用信息查询处理
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 */
	public IGLOM01DTO searchRecptionCostAction(IGLOM01DTO dto) throws BLException;

}

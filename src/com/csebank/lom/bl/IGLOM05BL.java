/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl;

import com.csebank.lom.dto.IGLOM05DTO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 食堂管理_食堂管理设定_BL
 * </p>
 * 
 * @version 
 */
public interface IGLOM05BL extends BaseBL {
	
	//成本
	/**
	 * 
	 * Description: 食堂成本信息查询
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM05DTO searchEateryAction(IGLOM05DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: 食堂成本信息登记
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO insertEateryAction(IGLOM05DTO dto) throws BLException;
	
	/**
	 * 食堂成本信息变更初期显示处理
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO initEateryAction(IGLOM05DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: 食堂成本信息变更
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO updateEateryAction(IGLOM05DTO dto) throws BLException ;
	
	//工作餐
	/**
	 * 
	 * Description: 食堂工作餐信息查询
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM05DTO searchEworkingLunchAction(IGLOM05DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: 食堂工作餐信息登记
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO insertEworkingLunchAction(IGLOM05DTO dto) throws BLException;
	
	/**
	 * 食堂工作餐信息变更初期显示处理
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO initEworkingLunchAction(IGLOM05DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: 食堂工作餐信息变更
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO updateEworkingLunchAction(IGLOM05DTO dto) throws BLException ;
	
	//接待
	/**
	 * 
	 * Description: 食堂接待信息查询
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM05DTO searchEentertainmentAction(IGLOM05DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: 食堂接待信息登记
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO insertEentertainmentAction(IGLOM05DTO dto) throws BLException;
	
	/**
	 * 食堂接待信息变更初期显示处理
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO initEentertainmentAction(IGLOM05DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: 食堂接待信息变更
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO updateEentertainmentAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * 
	 * Description: 食堂接待信息删除
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO deleteEentertainmentAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * 
	 * Description: 工作餐成本统计查询
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO searchWorkLunchEateryAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * 
	 * Description: 接待统计查询
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO searchEentertainmentStatisticsAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * 
	 * Description: 部门接待统计查询
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO searchDeptEentertainmentAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * 
	 * Description: 库存统计查询
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO searchGoodsStockAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * 
	 * Description: 单一物品库存统计查询
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO searchSingleGoodsStockAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * 
	 * Description: 物品库存统计明细查询
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO searchGoodsStockDetailAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * 餐卡信息登记
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO insertLunchCardAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * 餐卡信息查询
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchLunchCardAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * 工作餐_餐卡信息查询
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchELunchCardAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * 餐卡状态更改处理
	 * 
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO changeLunchCardAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * 餐卡信息变更初期显示处理
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO initLunchCardAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * 餐卡信息设定
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO updateLunchCardAction(IGLOM05DTO dto) throws BLException ;
	/**
	 * 食堂招待部门汇总查询
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchEEOrgVWAction(IGLOM05DTO dto) throws BLException;
	/**
	 * 食堂招待部门汇总明细查询
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchEEOrgVWDetail(IGLOM05DTO dto) throws BLException;
	/**
	 * 食堂物品消耗明细查询
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchGoutDetailInfo(IGLOM05DTO dto) throws BLException;

}

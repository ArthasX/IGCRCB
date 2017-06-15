/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl;

import com.csebank.lom.dto.IGLOM02DTO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 物品信息_物品信息设定_BL
 * </p>
 * 
 * @version 
 */
public interface IGLOM02BL extends BaseBL {
	
	/**
	 * 
	 * Description: 物品信息设定
	 * @param dto IGLOM02DTO
	 * @return IGLOM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM02DTO insertGoodsAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: 物品信息查询
	 * @param dto IGLOM02DTO
	 * @return IGLOM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM02DTO searchGoodsAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 查询与指定接待管理记录相关的领用物品信息ACTION
	 */
	public IGLOM02DTO searchGoodsForRecptionAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 领用页面查询ACTION
	 */
	public IGLOM02DTO searchGoodsForApplyAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 食堂领用页面查询ACTION
	 */
	public IGLOM02DTO searchGoodsForSTAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 调剂页面查询ACTION
	 */
	public IGLOM02DTO searchGoodsForEditAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 库存预警查询ACTION
	 */
	public IGLOM02DTO searchGstockWarningAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 库存统计查询ACTION
	 */
	public IGLOM02DTO searchGstockAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 库存统计导出ACTION
	 */
	public IGLOM02DTO searchGstockForExcelAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: 物品信息查询
	 * @param dto IGLOM02DTO
	 * @return IGLOM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM02DTO searchGoodsByKey(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: 物品信息删除
	 * @param dto IGLOM02DTO
	 * @return IGLOM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM02DTO deleteGoodsAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: 操作库存
	 * @param dto IGLOM02DTO
	 * @return IGLOM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM02DTO searchGIOStockDetailAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: 操作库存
	 * @param dto IGLOM02DTO
	 * @return IGLOM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM02DTO searchGoutStockAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 核销管理查询申请核销的记录
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOM02DTO searchGoutStockVWForDestroyAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: 操作库存
	 * @param dto IGLOM02DTO
	 * @return IGLOM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM02DTO searchIODetailAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: 操作库存
	 * @param dto IGLOM02DTO
	 * @return IGLOM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM02DTO searchGoodsIODetailAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: 操作库存
	 * @param dto IGLOM02DTO
	 * @return IGLOM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM02DTO searchGoodsIODetail0218Action(IGLOM02DTO dto) throws BLException;
	/**
	 * 
	 * Description: 操作库存
	 * @param dto IGLOM02DTO
	 * @return IGLOM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM02DTO doStock(IGLOM02DTO dto, String methodName) throws BLException;
	
	public String getCodeValue(String code) throws BLException;
	
	public String searchGoodsCodeAction(String gcategory) throws BLException;
	
	/**
	 * 
	 * Description: 每月盘点
	 * @param dto
	 * @return IGLOM02DTO
	 * @throws BLException
	 * 
	 */
	public IGLOM02DTO searchInventoryAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 每月盘点自动增加数据
	 * 
	 * @throws BLException
	 */
	public void insertInventoryInfoAction() throws BLException;
}

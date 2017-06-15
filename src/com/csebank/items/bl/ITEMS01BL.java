/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.bl;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.csebank.items.dto.ITEMS01DTO;
import com.csebank.items.model.condition.InStockSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

public interface ITEMS01BL extends BaseBL {
	
	public ITEMS01DTO searchItemsCategoryAction(ITEMS01DTO dto) throws BLException;
	
	public ITEMS01DTO insertItemsCategoryAction(ITEMS01DTO dto) throws BLException;
	
	public ITEMS01DTO findItemsCategoryByPkAction(ITEMS01DTO dto) throws BLException;
	public ITEMS01DTO searchStockAction(ITEMS01DTO dto, String temp) throws BLException;
	/**
	 * 查询stock表中的物品
	 */
	public ITEMS01DTO searchStockAction(ITEMS01DTO dto) throws BLException;
	public ITEMS01DTO statStockAction(ITEMS01DTO dto) throws BLException;
	
	/**
	 * 查询stock表中的物品(申领使用)
	 */
	public ITEMS01DTO searchStockForInsertOutStockAction(ITEMS01DTO dto) throws BLException;
	
	/**
	 * 查询stock表中指定物品的详细信息
	 */
	public ITEMS01DTO searchStockDetailAction(ITEMS01DTO dto) throws BLException;
	
	/**
	 * 查询outstock表中指定记录的详细信息
	 */
	public ITEMS01DTO searchOutStockDetailAction(ITEMS01DTO dto) throws BLException;
	
	/**
	 * 查询outstock表中的记录(VW)
	 */
	public ITEMS01DTO searchOutStockVWAction(ITEMS01DTO dto) throws BLException;
	
	/**
	 * 查询outstockVW视图中的记录(配送清单)
	 */
	public ITEMS01DTO searchOutStockBy0148Action(ITEMS01DTO dto) throws BLException;
	
	/**
	 * 查询outstockVW视图中的记录(配送清单明细)
	 */
	public ITEMS01DTO searchOutStockDetailBy0148Action(ITEMS01DTO dto) throws BLException;
	
	/**
	 * 查询outstockVW视图中的记录(配送清单明细Excel导出)
	 */
	public ITEMS01DTO searchExcelDataBy0148Action(ITEMS01DTO dto) throws BLException;
	
	/**
	 * 根据用户ID判断当前用户是否可以管理总行库存
	 * @param ITEMS01DTO
	 * @return boolean true:可以 false:不可以
	 */
	public boolean checkRoleManagerByUserID(ITEMS01DTO dto) throws BLException;
	
	/**
	 * 查询outstock表中的待审批记录
	 */
	public ITEMS01DTO searchOutStockAction(ITEMS01DTO dto) throws BLException;
	
	/**
	 * 查询耗材通知
	 *   总行显示：支行接收情况（显示未接收的支行）
	 *   支行显示：总行有下拨物品/配送物品，请接收 显示新增物品情况
	 */
	public ITEMS01DTO searchOutStockForNoticeAction(ITEMS01DTO dto) throws BLException;
	
	/**
	 * 物品申领（即在outstock表中增加一条申领记录）
	 */
	public ITEMS01DTO insertOutStockAction(ITEMS01DTO dto) throws BLException;

	/**
	 * 申领审批
	 */
	public ITEMS01DTO approveOutStockAction(ITEMS01DTO dto) throws BLException;
	
	/**
	 * 接收
	 */
	public ITEMS01DTO receiveOutStockAction(ITEMS01DTO dto) throws BLException;
	
	/**
	 * 根据传入参数获取其部分的下拉列表(申领审批页，'状态'用)
	 */
	public List<LabelValueBean> getPartItemsCodes(String selectid);
	
	/**
	 * 根据传入参数获取其部分的下拉列表(我的申领页，'状态'用)
	 */
	public List<LabelValueBean> getPartItemsCodesFor0144(String selectid);
	
	/**
	 * 根据传入参数获取其部分的下拉列表('下拨查询'页，'状态'用)
	 */
	public List<LabelValueBean> getPartItemsCodesFor0147(String selectid);
	
	/**
	 * 根据传入参数获取其全部的下拉列表
	 */
	public List<LabelValueBean> getItemsCodes(String selectid);
	
	/**
	 * 根据传入参数获取其全部的下拉列表
	 */
	public List<LabelValueBean> getItemsCodesFor0129Action(String selectid);
	
	/**
	 * 根据传入参数获取其结账清单
	 */
	public ITEMS01DTO searchPaymentItems(ITEMS01DTO dto);
	
	public ITEMS01DTO searchInStockAction(ITEMS01DTO dto) throws BLException;

	public List<LabelValueBean> getPartOutStockTypeCodes(String selectid);

	public ITEMS01DTO reportInStockAction(ITEMS01DTO dto) throws BLException;

	public ITEMS01DTO doStock(ITEMS01DTO dto,String methodName) throws BLException;
	
	public String getRequsetStatus(String selectid) throws BLException;
	
	public ITEMS01DTO reportOutStockAction(ITEMS01DTO dto) throws BLException;
	
	public ITEMS01DTO searchPaymentDetail(ITEMS01DTO dto) throws BLException;
	
	public void changeRequsetStatus(String selectid,String requestStatus) throws BLException;
	
	public String getOutTypeName(String selectid,String typecode) throws BLException;
	
	/**
	 * 查询仓库收益
	 */
	public ITEMS01DTO searchITEMS0169Action(ITEMS01DTO dto) throws BLException;
	
	/**
	 * 查询物品收益
	 */
	public ITEMS01DTO searchITEMS0171Action(ITEMS01DTO dto) throws BLException;
	
	public ITEMS01DTO changeCategoryStatusAction(ITEMS01DTO dto) throws BLException;
	
	/**
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public ITEMS01DTO searchOrganizationAction(ITEMS01DTO dto)  throws BLException;
	
	/**
	 * 机构下拨 物品查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public ITEMS01DTO searchStockForOrgAction(ITEMS01DTO dto)  throws BLException;
	
	/**
	 * 查询最后一次入库物品信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public String searchOldStockAction(InStockSearchCond cond)  throws BLException;
}

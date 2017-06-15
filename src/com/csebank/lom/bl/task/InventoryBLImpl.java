/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Inventory;
import com.csebank.lom.model.InventoryInfo;
import com.csebank.lom.model.condition.InventoryInfoSearchCond;
import com.csebank.lom.model.condition.InventorySearchCond;
import com.csebank.lom.model.dao.InventoryDAO;
import com.csebank.lom.model.dao.InventoryInfoDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 每月盘点业务逻辑接口实现
 */
public class InventoryBLImpl extends BaseBLImpl implements InventoryBL {
	
	/** Inventory DAO */
	protected InventoryDAO inventoryDAO;
	
	public void setInventoryDAO(
			InventoryDAO inventoryDAO) {
		this.inventoryDAO = inventoryDAO;
	}
	
	/** InventoryInfo DAO */
	protected InventoryInfoDAO inventoryInfoDAO;
	
	public void setInventoryInfoDAO(
			InventoryInfoDAO inventoryInfoDAO) {
		this.inventoryInfoDAO = inventoryInfoDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(InventorySearchCond cond){
		
		return inventoryDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param lpdid 
	 * @return 
	 */
	public Inventory searchInventoryByKey(Integer inid) throws BLException{
		
		return checkExistInventory(inid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部借还款明细信息
	 */
	public List<Inventory> searchInventoryAll(){
		
		return inventoryDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Inventory> searchInventory(InventorySearchCond cond, int start, int count){
		
		return inventoryDAO.findByCond(cond,start,count);
	}

	/**
	 * 信息存在检查
	 * 
	 * @param inid 
	 * @return 
	 * @throws BLException 
	 */
	protected Inventory checkExistInventory(Integer inid) throws BLException{
		Inventory info = inventoryDAO.findByPK(inid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","每月盘点");
		}
		return info;
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<InventoryInfo> searchInventoryInfo(InventoryInfoSearchCond cond, int start, int count){
		
		return inventoryInfoDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param Inventory 登录数据
	 * @return 
	 */
	public Inventory registInventory(Inventory inventory) throws BLException{
		
		return inventoryDAO.save(inventory);
	}
}

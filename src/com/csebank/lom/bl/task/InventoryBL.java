/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Inventory;
import com.csebank.lom.model.InventoryInfo;
import com.csebank.lom.model.condition.InventoryInfoSearchCond;
import com.csebank.lom.model.condition.InventorySearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 每月盘点业务逻辑接口
 */
public interface InventoryBL extends BaseBL {

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(InventorySearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param lpdid 
	 * @return 
	 */
	public Inventory searchInventoryByKey(Integer inid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 
	 */
	public List<Inventory> searchInventoryAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Inventory> searchInventory(InventorySearchCond cond, int start, int count);

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<InventoryInfo> searchInventoryInfo(InventoryInfoSearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param Inventory 登录数据
	 * @return 
	 */
	public Inventory registInventory(Inventory inventory) throws BLException;
}

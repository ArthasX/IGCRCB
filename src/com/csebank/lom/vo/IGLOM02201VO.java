/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.lom.vo;

import java.util.List;

import com.csebank.lom.model.Inventory;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 每月盘点VO
 *
 */
public class IGLOM02201VO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	/** 每月盘点查询结果集 */
	private List<Inventory> inventoryList;

	/**
	 * 每月盘点查询结果集取得
	 * @return 每月盘点查询结果集
	 */
	public List<Inventory> getInventoryList() {
		return inventoryList;
	}

	/**
	 * 每月盘点查询结果集设定
	 * @param inventoryList 每月盘点查询结果集
	 */
	public void setInventoryList(List<Inventory> inventoryList) {
		this.inventoryList = inventoryList;
	}

	
}

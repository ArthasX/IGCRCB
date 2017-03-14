/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.vo;

import java.util.List;
import java.util.Map;

import com.csebank.items.model.InStock;
import com.csebank.items.model.ItemsCategory;
import com.csebank.items.model.ItemsPay;
import com.csebank.items.model.OutStock;
import com.csebank.items.model.Stock;
import com.deliverik.framework.base.BaseVO;

/**
 * @author sunkaiyu
 *
 */
public class ITEMS01011VO extends BaseVO {

	private static final long serialVersionUID = 1L;
	private List<ItemsCategory> itemsCategoryList;
	private ItemsCategory itemsCategory;
	private Stock stock;
	private List<Stock> stockList;
	private List<InStock> inStockList;
	private List<OutStock> outStockList;
	private Map<String,String> editMap;//入库调整使用
	
	private List<ItemsPay> paymentList;
	protected List<String> editList;//类别管理是否可见修改按钮（0不可见，1可见）
	
	
	/**
	 * @return the editList
	 */
	public List<String> getEditList() {
		return editList;
	}
	/**
	 * @param editList the editList to set
	 */
	public void setEditList(List<String> editList) {
		this.editList = editList;
	}
	public List<ItemsPay> getPaymentList() {
		return paymentList;
	}
	public void setPaymentList(List<ItemsPay> paymentList) {
		this.paymentList = paymentList;
	}
	
	/**
	 * @return the editMap
	 */
	public Map<String, String> getEditMap() {
		return editMap;
	}
	/**
	 * @param editMap the editMap to set
	 */
	public void setEditMap(Map<String, String> editMap) {
		this.editMap = editMap;
	}
	public List<InStock> getInStockList() {
		return inStockList;
	}
	public void setInStockList(List<InStock> inStockList) {
		this.inStockList = inStockList;
	}
	public ItemsCategory getItemsCategory() {
		return itemsCategory;
	}
	public void setItemsCategory(ItemsCategory itemsCategory) {
		this.itemsCategory = itemsCategory;
	}
	public List<ItemsCategory> getItemsCategoryList() {
		return itemsCategoryList;
	}
	public void setItemsCategoryList(List<ItemsCategory> itemsCategoryList) {
		this.itemsCategoryList = itemsCategoryList;
	}
	public List<Stock> getStockList() {
		return stockList;
	}
	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public List<OutStock> getOutStockList() {
		return outStockList;
	}
	public void setOutStockList(List<OutStock> outStockList) {
		this.outStockList = outStockList;
	}
	
}

/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.vo;

import java.util.List;
import java.util.Map;

import com.csebank.items.model.ItemsCategory;
import com.csebank.items.model.OutStock;
import com.csebank.items.model.OutStockVWInfo;
import com.csebank.items.model.Stock;
import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Organization;

/**
 * @author duchong
 *
 */
public class ITEMS01081VO extends BaseVO {

	private static final long serialVersionUID = 1L;
	private List<OutStockVWInfo> outStockList;
	private List<OutStock> outStocktbList;
	private List<Stock> stockList;
	private OutStock outStock;
	private Stock stock;
	private List<Organization> orgList;
	private List<Stock> exstockList;//保存被申领并且库存中存在的耗材
	private List<ItemsCategory> itemsCategoryList;
	Map<String,Map<String,String>> outmap;
	
	
	/**
	 * @return the outStocktbList
	 */
	public List<OutStock> getOutStocktbList() {
		return outStocktbList;
	}
	/**
	 * @param outStocktbList the outStocktbList to set
	 */
	public void setOutStocktbList(List<OutStock> outStocktbList) {
		this.outStocktbList = outStocktbList;
	}
	/**
	 * @return the outmap
	 */
	public Map<String, Map<String, String>> getOutmap() {
		return outmap;
	}
	/**
	 * @param outmap the outmap to set
	 */
	public void setOutmap(Map<String, Map<String, String>> outmap) {
		this.outmap = outmap;
	}
	public List<OutStockVWInfo> getOutStockList() {
		return outStockList;
	}
	public void setOutStockList(List<OutStockVWInfo> outStockList) {
		this.outStockList = outStockList;
	}
	public List<ItemsCategory> getItemsCategoryList() {
		return itemsCategoryList;
	}
	public void setItemsCategoryList(List<ItemsCategory> itemsCategoryList) {
		this.itemsCategoryList = itemsCategoryList;
	}
	public List<Stock> getExstockList() {
		return exstockList;
	}
	public void setExstockList(List<Stock> exstockList) {
		this.exstockList = exstockList;
	}
	public List<Organization> getOrgList() {
		return orgList;
	}
	public void setOrgList(List<Organization> orgList) {
		this.orgList = orgList;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public List<Stock> getStockList() {
		return stockList;
	}
	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}
	public OutStock getOutStock() {
		return outStock;
	}
	public void setOutStock(OutStock outStock) {
		this.outStock = outStock;
	}
	
	
	
}

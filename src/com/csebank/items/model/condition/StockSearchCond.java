package com.csebank.items.model.condition;

public interface StockSearchCond {

	public Integer getStockid();//id
	public String getStockorg();//库存机构
	public String getCategory();//物品种类
	public String getType();//物品类型
	public Integer getStocknum();//实际库存数量
	public String getSeqcode();
	public String getStockorg_q();
	/**
	 * @return the itemsname
	 */
	public String getItemsname();
	public String getSeqcode_q();
	public String getItemsname_q();
}

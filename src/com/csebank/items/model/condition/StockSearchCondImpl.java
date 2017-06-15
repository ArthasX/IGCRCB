package com.csebank.items.model.condition;

public class StockSearchCondImpl implements StockSearchCond {

	protected Integer stockid;
	protected String stockorg;
	protected String category;
	protected String type;
	protected Integer stocknum;
	protected String seqcode;
	protected String stockorg_q;
	protected String seqcode_q;//物品编号,统计中的模糊查询
	protected String itemsname_q;//物品名称,统计中的模糊查询
	/**
	 * 物品名称
	 */
	protected String itemsname;
	
	
	/**
	 * @return the itemsname
	 */
	public String getItemsname() {
		return itemsname;
	}
	/**
	 * @param itemsname the itemsname to set
	 */
	public void setItemsname(String itemsname) {
		this.itemsname = itemsname;
	}
	public String getStockorg_q() {
		return stockorg_q;
	}
	public void setStockorg_q(String stockorg_q) {
		this.stockorg_q = stockorg_q;
	}
	public Integer getStockid() {
		return stockid;
	}
	public String getStockorg() {
		return stockorg;
	}
	public String getCategory() {
		return category;
	}
	public String getType() {
		return type;
	}
	public Integer getStocknum() {
		return stocknum;
	}
	
	
	public void setStockid(Integer stockid) {
		this.stockid = stockid;
	}
	public void setStockorg(String stockorg) {
		this.stockorg = stockorg;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setStocknum(Integer stocknum) {
		this.stocknum = stocknum;
	}
	public String getSeqcode() {
		return seqcode;
	}
	public void setSeqcode(String seqcode) {
		this.seqcode = seqcode;
	}
	public String getSeqcode_q() {
		return seqcode_q;
	}
	public void setSeqcode_q(String seqcode_q) {
		this.seqcode_q = seqcode_q;
	}
	public String getItemsname_q() {
		return itemsname_q;
	}
	public void setItemsname_q(String itemsname_q) {
		this.itemsname_q = itemsname_q;
	}

}

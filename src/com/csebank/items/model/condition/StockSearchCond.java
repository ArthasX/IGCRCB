package com.csebank.items.model.condition;

public interface StockSearchCond {

	public Integer getStockid();//id
	public String getStockorg();//������
	public String getCategory();//��Ʒ����
	public String getType();//��Ʒ����
	public Integer getStocknum();//ʵ�ʿ������
	public String getSeqcode();
	public String getStockorg_q();
	/**
	 * @return the itemsname
	 */
	public String getItemsname();
	public String getSeqcode_q();
	public String getItemsname_q();
}

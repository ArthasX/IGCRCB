package com.csebank.items.model;

import com.deliverik.framework.base.BaseModel;

public interface Stock extends BaseModel{

	public Integer getStockid();

	public String getStockorg();

	public String getCategory();

	public String getSeqcode();

	public String getTypecode();

	public String getType();

	public String getStatus();

	public Integer getStocknum();

	public Integer getLostnum();

	public Integer getPrenum();

	public Double getInamount();

	public Double getOutamount();

	public String getUptime();

	public String getUserid();

	public String getUsername();

	public String getItemsname();
	
	public Double getPrice();
	
	public Double getAmount();
	
}
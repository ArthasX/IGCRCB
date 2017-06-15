package com.csebank.items.model;

import com.deliverik.framework.base.BaseModel;

public interface InStock extends BaseModel {
	
	public Integer getInstockid();

	public String getInstockorg();

	public String getCategory();

	public String getSeqcode();

	public String getIntime();

	public String getSeqno();

	public String getTypecode();

	public String getType();

	public String getStatus();

	public Double getInprice();

	public Double getInamount();

	public Double getOutprice();

	public Double getOutamount();

	public Integer getPacknum();

	public Integer getBigpacknum();

	public Integer getInnum();

	public Integer getOutnum();

	public Integer getLossnum();

	public Integer getHavocnum();

	public String getNature();

	public String getItemversion();

	public String getPrintinside();

	public String getPrintexternal();

	public String getPrintcompany();

	public String getUserid();

	public String getUsername();
	public String getItemsname();
	
	public Integer getOutstockid();
}
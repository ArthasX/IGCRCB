package com.csebank.items.model;

import com.deliverik.framework.base.BaseModel;

public interface ItemsCodes extends BaseModel{

	public Integer getIcid();
	public String getSelectid();
	public String getSelectname();
	public String getTypecode();
	public String getTypename();
	public String getIdesc();
	public String getStatus();
	
}
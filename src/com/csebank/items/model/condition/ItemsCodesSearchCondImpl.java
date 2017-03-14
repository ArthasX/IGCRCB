package com.csebank.items.model.condition;

public class ItemsCodesSearchCondImpl implements ItemsCodesSearchCond {

	protected String selectid;
	protected String typename;
	protected String typecode;
	protected String status;
	
	public String getSelectid() {
		return selectid;
	}
	public String getTypename() {
		return typename;
	}
	public String getTypecode() {
		return typecode;
	}
	public String getStatus() {
		return status;
	}
	
	public void setSelectid(String selectid) {
		this.selectid = selectid;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}

package com.csebank.items.model.condition;

import java.util.List;

public interface InStockSearchCond {

	public Integer getInstockid();
	public String getInstockorg();
	public String getCategory();
	public String getType();
	public String getSeqcode();
	public String getSeqcode_q();
	public String getItemsname_q();
	public String getIntime_f();
	public String getIntime_t();
	public String getSeqno();
	public String getTypecode();
	public String getStatus();
	public List<String> getStatus_q();
	public String getIntime();
	public boolean isLossnumIsNotZero();
	public String getInstockorg_q();
	public boolean isShowNoneStock();
	public String getInstock_sort();
	public Integer getOutstockid();
}

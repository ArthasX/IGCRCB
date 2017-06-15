package com.csebank.items.model.condition;

import java.util.ArrayList;
import java.util.List;

public interface OutStockDetailSearchCond {

	public Integer getOutstockid();
	
	public Integer getStockid();
	public String getOutstockorg();
	public String getCategory(); 
	public String getOuttype(); 
	public String getSeqcode(); 
	public String getReqorg(); 
	public String getOuttime_f();
	public String getOuttime_t();
	public String getReqstatus();
	public String getAccountstatus();
	public String getItemsname(); 
	public String getType();
	public ArrayList<String> getOuttypelist();
	public String getRcvtime();
	public String getSerachtype();
	public String getOutstockorg_q();
	public List<String> getReqstatusList();
	public String getIntime_f();
	public String getIntime_t();

	public String getReqorg_q();
	
	public String getCategory_q();

	public String getReqstatus_q();

	public String getOuttype_q();

	public String getStockorg();
	public String getReqtime_f();

	public String getReqtime_t();

	public String getSortType();

	public String getInstockid();

	public String getInseqno();
	
}

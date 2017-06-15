package com.csebank.items.model.condition;

import java.util.List;

public interface OutStockSearchVWCond {

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
	public String getReqorg_q();
	public String getCategory_q();
	public String getReqstatus_q();
	public String getOuttype_q();
	public String getStockorg();
	public String getReqtime_f();
	public String getReqtime_t();
	public String getSortType();

	/**
	 * @return the chktime_f
	 */
	public String getChktime_f();

	/**
	 * @return the chktime_t
	 */
	public String getChktime_t();
	
	/**
	 * @return the rcvtime_f
	 */
	public String getRcvtime_f();
	
	/**
	 * @return the rcvtime_t
	 */
	public String getRcvtime_t();
	
	/**
	 * @return the outTypeList
	 */
	public List<String> getOutTypeList();
	
}

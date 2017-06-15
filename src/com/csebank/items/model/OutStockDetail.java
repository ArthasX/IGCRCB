package com.csebank.items.model;

import com.deliverik.framework.base.BaseModel;

public interface OutStockDetail extends BaseModel{

	public Integer getOutstockid();
	
	public Integer getInstockid();
	
	public String getOutstockorg();

	public String getCategory();

	public String getSeqcode();

	public String getTypecode();

	public String getSeqno();

	public String getOuttype();

	public String getReqorg();

	public String getReqid();

	public String getReqname();

	public String getReqtime();

	public Integer getReqnum();

	public Integer getChknum();

	public Integer getOutnum();

	public String getChkreason();

	public String getPakreason();

	public String getPackno();

	public String getChkid();

	public String getChkname();

	public String getChktime();

	public String getStockuserid();

	public String getStockname();

	public String getOuttime();

	public String getRcvid();

	public String getRcvname();

	public String getRcvtime();

	public String getReqstatus();

	public String getAccountstatus();

	public Double getInprice();

	public Double getOutprice();

	public Double getOutamount();

	public Integer getBigpacknum();

	public Integer getSmallpacknum();

	public String getItemversion();

	public Integer getStockid();
	public String getItemsname();
	public Integer getStocknum();
	public String getType();
	public String getPaytime();
	
	public String getInseqno();
	
	public Integer getId();
}
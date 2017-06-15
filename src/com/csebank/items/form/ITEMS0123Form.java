/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.form;

import java.util.ArrayList;
import java.util.List;

import com.csebank.items.model.condition.OutStockSearchCond;
import com.deliverik.framework.base.BaseForm;

public class ITEMS0123Form extends BaseForm implements OutStockSearchCond {

	private static final long serialVersionUID = 1L;
	protected String reqstatusa;
	protected String category;
	protected String reqstatus;
	protected String outtype;
	protected ArrayList<String> outtypelist;//出库类型
	protected String serachtype;//排序方式
	private String outstockorg_q;
	private String outstockorg;
	
	
	
	public String getOutstockorg() {
		return outstockorg;
	}
	public void setOutstockorg(String outstockorg) {
		this.outstockorg = outstockorg;
	}
	public String getOutstockorg_q() {
		return outstockorg_q;
	}
	public void setOutstockorg_q(String outstockorg_q) {
		this.outstockorg_q = outstockorg_q;
	}
	public String getSerachtype() {
		return serachtype;
	}
	public void setSerachtype(String serachtype) {
		this.serachtype = serachtype;
	}
	
	public ArrayList<String> getOuttypelist() {
		return outtypelist;
	}
	public void setOuttypelist(ArrayList<String> outtypelist) {
		this.outtypelist = outtypelist;
	}	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getReqstatus() {
		return reqstatus;
	}
	public void setReqstatus(String reqstatus) {
		this.reqstatus = reqstatus;
	}
	public String getOuttype() {
		return outtype;
	}
	public void setOuttype(String outtype) {
		this.outtype = outtype;
	}
	public String getAccountstatus() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getItemsname() {
		// TODO Auto-generated method stub
		return null;
	}
	public Integer getOutstockid() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getOuttime_f() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getOuttime_t() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getReqorg() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getSeqcode() {
		// TODO Auto-generated method stub
		return null;
	}
	public Integer getStockid() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getRcvtime() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<String> getReqstatusList() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getIntime_f() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getIntime_t() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getCategory_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getOuttype_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getReqorg_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getReqstatus_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getReqtime_f() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getReqtime_t() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getSortType() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getStockorg() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean isCanPayment() {
		// TODO Auto-generated method stub
		return false;
	}
	public String getAccountstatus_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getItemsname_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getSeqcode_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getReqstatusa() {
		return reqstatusa;
	}
	public void setReqstatusa(String reqstatusa) {
		this.reqstatusa = reqstatusa;
	}

	
}
/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.form;

import java.util.ArrayList;
import java.util.List;

import com.csebank.items.model.condition.OutStockSearchCond;
import com.deliverik.framework.base.BaseForm;

public class ITEMS0115Form extends BaseForm implements OutStockSearchCond {

	private static final long serialVersionUID = 1L;
	private String reqstatusa;
	private String category;
	private String seqcode;
	private String type;
	private String outstockorg;
	protected ArrayList<String> outtypelist;//出库类型
	protected String serachtype;//排序方式
	private String outstockorg_q;
	private List<String> reqstatusList;
	
	public List<String> getReqstatusList() {
		return reqstatusList;
	}
	public void setReqstatusList(List<String> reqstatusList) {
		this.reqstatusList = reqstatusList;
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
	
	public String getOutstockorg() {
		return outstockorg;
	}
	public void setOutstockorg(String outstockorg) {
		this.outstockorg = outstockorg;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSeqcode() {
		return seqcode;
	}
	public void setSeqcode(String seqcode) {
		this.seqcode = seqcode;
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
	public String getOuttype() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getReqorg() {
		return null;
	}
	public Integer getStockid() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getReqstatus() {
		return null;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRcvtime() {
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

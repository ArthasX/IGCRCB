/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.form;

import java.util.ArrayList;
import java.util.List;

import com.csebank.items.model.condition.OutStockSearchCond;
import com.deliverik.framework.base.BaseForm;

public class ITEMS0126Form extends BaseForm implements OutStockSearchCond {

	private static final long serialVersionUID = 1L;

	protected String reqorg_name;
	protected String category;
	protected String reqorg;
	protected String accountstatus;
	protected String outtype;
	protected String reqstatus;
	protected String reqstatusa;
	protected ArrayList<String> outtypelist;//出库类型
	protected Integer[] outstockids;
	protected String serachtype;//排序方式
	protected String intime_f;
	protected String intime_t;
	protected String outstockorg;//库存机构
	protected String accountstatus_q;//结账状态不为空
	protected String outtime_f;//出库时间从
	protected String outtime_t;//出库时间至
	
	public void setOuttime_f(String outtime_f) {
		this.outtime_f = outtime_f;
	}
	public void setOuttime_t(String outtime_t) {
		this.outtime_t = outtime_t;
	}
	/**
	 * @return the accountstatus_q
	 */
	public String getAccountstatus_q() {
		return accountstatus_q;
	}
	/**
	 * @param accountstatus_q the accountstatus_q to set
	 */
	public void setAccountstatus_q(String accountstatus_q) {
		this.accountstatus_q = accountstatus_q;
	}
	/**
	 * @param outstockorg the outstockorg to set
	 */
	public void setOutstockorg(String outstockorg) {
		this.outstockorg = outstockorg;
	}
	public String getIntime_f() {
		return intime_f;
	}
	public void setIntime_f(String intime_f) {
		this.intime_f = intime_f;
	}
	public String getIntime_t() {
		return intime_t;
	}
	public void setIntime_t(String intime_t) {
		this.intime_t = intime_t;
	}
	public String getSerachtype() {
		return serachtype;
	}
	public void setSerachtype(String serachtype) {
		this.serachtype = serachtype;
	}
	
	public Integer[] getOutstockids() {
		return outstockids;
	}
	public void setOutstockids(Integer[] outstockids) {
		this.outstockids = outstockids;
	}
	public ArrayList<String> getOuttypelist() {
		return outtypelist;
	}
	public void setOuttypelist(ArrayList<String> outtypelist) {
		this.outtypelist = outtypelist;
	}	
	
	public String getOuttype() {
		return outtype;
	}

	public void setOuttype(String outtype) {
		this.outtype = outtype;
	}

	public String getReqstatus() {
		return reqstatus;
	}

	public void setReqstatus(String reqstatus) {
		this.reqstatus = reqstatus;
	}

	public String getAccountstatus() {
		return accountstatus;
	}

	public void setAccountstatus(String accountstatus) {
		this.accountstatus = accountstatus;
	}

	public String getReqorg_name() {
		return reqorg_name;
	}

	public void setReqorg_name(String reqorg_name) {
		this.reqorg_name = reqorg_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getReqorg() {
		return reqorg;
	}

	public void setReqorg(String reqorg) {
		this.reqorg = reqorg;
	}

	public String getItemsname() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getOutstockid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOutstockorg() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOuttime_f() {
		// TODO Auto-generated method stub
		return outtime_f;
	}

	public String getOuttime_t() {
		// TODO Auto-generated method stub
		return outtime_t;
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
	public String getOutstockorg_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<String> getReqstatusList() {
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
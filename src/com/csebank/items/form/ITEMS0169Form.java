/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.form;

import java.util.ArrayList;
import java.util.List;

import com.csebank.items.model.condition.OutStockSearchCond;
import com.csebank.items.util.DefineUtils;
import com.deliverik.framework.base.BaseForm;

@SuppressWarnings("serial")
public class ITEMS0169Form extends BaseForm implements OutStockSearchCond{
	
	protected String reqtime_f;

	protected String reqtime_t;
	
	protected String category;
	
	protected String reqorg;
	
	protected String reqorgname;
	
	protected String reqstatus_q;
	
	protected String sortType = DefineUtils.OUTSTOCK_SORTTYPE_0169;
	
	protected String outstockorg;
	protected String reqstatusa;
	protected String outtime_f;
	protected String outtime_t;
	/**
	 * @return the outstockorg
	 */
	public String getOutstockorg() {
		return outstockorg;
	}

	public void setOuttime_f(String outtime_f) {
		this.outtime_f = outtime_f;
	}

	public void setOuttime_t(String outtime_t) {
		this.outtime_t = outtime_t;
	}
	/**
	 * @param outstockorg the outstockorg to set
	 */
	public void setOutstockorg(String outstockorg) {
		this.outstockorg = outstockorg;
	}

	public String getReqtime_f() {
		return reqtime_f;
	}

	public void setReqtime_f(String reqtime_f) {
		this.reqtime_f = reqtime_f;
	}

	public String getReqtime_t() {
		return reqtime_t;
	}

	public void setReqtime_t(String reqtime_t) {
		this.reqtime_t = reqtime_t;
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

	public String getReqorgname() {
		return reqorgname;
	}

	public void setReqorgname(String reqorgname) {
		this.reqorgname = reqorgname;
	}

	public String getReqstatus_q() {
		return reqstatus_q;
	}

	public void setReqstatus_q(String reqstatus_q) {
		this.reqstatus_q = reqstatus_q;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public String getAccountstatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCategory_q() {
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

	public String getItemsname() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getOutstockid() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getOutstockorg_q() {
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

	public String getOuttype() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOuttype_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getOuttypelist() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRcvtime() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getReqorg_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getReqstatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getReqstatusList() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSeqcode() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSerachtype() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getStockid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getStockorg() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getType() {
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

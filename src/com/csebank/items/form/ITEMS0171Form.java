/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.form;

import java.util.ArrayList;
import java.util.List;

import com.csebank.items.model.condition.OutStockDetailSearchCond;
import com.csebank.items.util.DefineUtils;
import com.deliverik.framework.base.BaseForm;

@SuppressWarnings("serial")
public class ITEMS0171Form extends BaseForm implements OutStockDetailSearchCond{

	protected String outtime_f;

	protected String outtime_t;
	
	protected String category;
	
	protected String seqcode;
	
	protected String itemsname;
	
	protected String typecode;
	
	protected String outstockorg = DefineUtils.DEFAULT_ORGNO;
	
	protected String sortType = DefineUtils.OUTSTOCKDETAIL_SORTTYPE_0171;

	public String getOuttime_f() {
		return outtime_f;
	}

	public void setOuttime_f(String outtime_f) {
		this.outtime_f = outtime_f;
	}

	public String getOuttime_t() {
		return outtime_t;
	}

	public void setOuttime_t(String outtime_t) {
		this.outtime_t = outtime_t;
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

	public String getItemsname() {
		return itemsname;
	}

	public void setItemsname(String itemsname) {
		this.itemsname = itemsname;
	}

	public String getTypecode() {
		return typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	public String getOutstockorg() {
		return outstockorg;
	}

	public void setOutstockorg(String outstockorg) {
		this.outstockorg = outstockorg;
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

	public String getInseqno() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getInstockid() {
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

	public Integer getOutstockid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOutstockorg_q() {
		// TODO Auto-generated method stub
		return null;
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

	public String getReqorg() {
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

	
}

package com.csebank.items.model.condition;

import java.util.ArrayList;
import java.util.List;

public class OutStockSearchCondImpl implements OutStockSearchCond {

	protected Integer outstockid;
	protected Integer stockid;//stock库存静态信息表的主键ID
	protected String outstockorg;//库存机构
	protected String category;//物品种类
	protected String outtype;//出库类型
	protected String seqcode;//物品编号
	protected String seqcode_q;//物品编号,统计中的模糊查询
	protected String itemsname_q;//物品名称,统计中的模糊查询
	protected String reqorg;//领用机构
	protected String reqstatusa;
	protected String outtime_f;//出库时间从
	protected String outtime_t;//出库时间至
	protected String reqstatus;//出库状态
	protected String accountstatus;//结账状态
	protected String accountstatus_q;//结账状态不为空
	
	protected String itemsname;//物品名称
	protected String type;//物品类型
	
	protected ArrayList<String> outtypelist;//出库类型
	protected String rcvtime;
	
	protected String serachtype;//排序方式
	
	protected String outstockorg_q;//机构号
	protected List<String> reqstatusList;
	protected String intime_f;
	protected String intime_t;

	protected String reqorg_q;//申领机构
	protected String category_q;//物品种类
	protected String reqstatus_q;//状态
	protected String outtype_q;//出库类型
	protected String stockorg;//stock表机构号
	protected String reqtime_f;
	protected String reqtime_t;
	
	protected String sortType;//排序方式
	
	protected boolean canPayment = false;
	
	
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
	public boolean isCanPayment() {
		return canPayment;
	}
	public void setCanPayment(boolean canPayment) {
		this.canPayment = canPayment;
	}
	/**
	 * @return the reqorg_q
	 */
	public String getReqorg_q() {
		return reqorg_q;
	}
	/**
	 * @return the category_q
	 */
	public String getCategory_q() {
		return category_q;
	}
	/**
	 * @return the reqstatus_q
	 */
	public String getReqstatus_q() {
		return reqstatus_q;
	}
	/**
	 * @return the outtype_q
	 */
	public String getOuttype_q() {
		return outtype_q;
	}
	/**
	 * @return the stockorg
	 */
	public String getStockorg() {
		return stockorg;
	}
	/**
	 * @return the reqtime_f
	 */
	public String getReqtime_f() {
		return reqtime_f;
	}
	/**
	 * @return the reqtime_t
	 */
	public String getReqtime_t() {
		return reqtime_t;
	}
	/**
	 * @return the sortType
	 */
	public String getSortType() {
		return sortType;
	}
	/**
	 * @param reqorg_q the reqorg_q to set
	 */
	public void setReqorg_q(String reqorg_q) {
		this.reqorg_q = reqorg_q;
	}
	/**
	 * @param category_q the category_q to set
	 */
	public void setCategory_q(String category_q) {
		this.category_q = category_q;
	}
	/**
	 * @param reqstatus_q the reqstatus_q to set
	 */
	public void setReqstatus_q(String reqstatus_q) {
		this.reqstatus_q = reqstatus_q;
	}
	/**
	 * @param outtype_q the outtype_q to set
	 */
	public void setOuttype_q(String outtype_q) {
		this.outtype_q = outtype_q;
	}
	/**
	 * @param stockorg the stockorg to set
	 */
	public void setStockorg(String stockorg) {
		this.stockorg = stockorg;
	}
	/**
	 * @param reqtime_f the reqtime_f to set
	 */
	public void setReqtime_f(String reqtime_f) {
		this.reqtime_f = reqtime_f;
	}
	/**
	 * @param reqtime_t the reqtime_t to set
	 */
	public void setReqtime_t(String reqtime_t) {
		this.reqtime_t = reqtime_t;
	}
	/**
	 * @param sortType the sortType to set
	 */
	public void setSortType(String sortType) {
		this.sortType = sortType;
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
	public String getRcvtime() {
		return rcvtime;
	}
	public void setRcvtime(String rcvtime) {
		this.rcvtime = rcvtime;
	}
	public ArrayList<String> getOuttypelist() {
		return outtypelist;
	}
	public void setOuttypelist(ArrayList<String> outtypelist) {
		this.outtypelist = outtypelist;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getItemsname() {
		return itemsname;
	}
	public void setItemsname(String itemsname) {
		this.itemsname = itemsname;
	}
	public Integer getOutstockid() {
		return outstockid;
	}
	public Integer getStockid() {
		return stockid;
	}
	public String getOutstockorg() {
		return outstockorg;
	}
	public String getCategory() {
		return category;
	}
	public String getOuttype() {
		return outtype;
	}
	public String getSeqcode() {
		return seqcode;
	}
	public String getReqorg() {
		return reqorg;
	}
	public String getOuttime_f() {
		return outtime_f;
	}
	public String getOuttime_t() {
		return outtime_t;
	}
	public String getReqstatus() {
		return reqstatus;
	}
	public String getAccountstatus() {
		return accountstatus;
	}
	
	
	
	public void setOutstockid(Integer outstockid) {
		this.outstockid = outstockid;
	}
	public void setStockid(Integer stockid) {
		this.stockid = stockid;
	}
	public void setOutstockorg(String outstockorg) {
		this.outstockorg = outstockorg;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setOuttype(String outtype) {
		this.outtype = outtype;
	}
	public void setSeqcode(String seqcode) {
		this.seqcode = seqcode;
	}
	public void setReqorg(String reqorg) {
		this.reqorg = reqorg;
	}
	public void setOuttime_f(String outtime_f) {
		this.outtime_f = outtime_f;
	}
	public void setOuttime_t(String outtime_t) {
		this.outtime_t = outtime_t;
	}
	public void setReqstatus(String reqstatus) {
		this.reqstatus = reqstatus;
	}
	public void setAccountstatus(String accountstatus) {
		this.accountstatus = accountstatus;
	}
	public String getSeqcode_q() {
		return seqcode_q;
	}
	public void setSeqcode_q(String seqcode_q) {
		this.seqcode_q = seqcode_q;
	}
	public String getItemsname_q() {
		return itemsname_q;
	}
	public void setItemsname_q(String itemsname_q) {
		this.itemsname_q = itemsname_q;
	}
	public String getReqstatusa() {
		return reqstatusa;
	}
	public void setReqstatusa(String reqstatusa) {
		this.reqstatusa = reqstatusa;
	}
	

	
}

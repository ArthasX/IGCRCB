package com.csebank.items.model.condition;

import java.util.List;

public class OutStockSearchVWCondImpl implements OutStockSearchVWCond {

	protected Integer outstockid;
	protected Integer stockid;//stock库存静态信息表的主键ID
	protected String outstockorg;//库存机构
	protected String category;//物品种类
	protected String outtype;//出库类型
	protected String seqcode;//物品编号
	protected String reqorg;//领用机构
	
	protected String outtime_f;//出库时间从
	protected String outtime_t;//出库时间至
	protected String reqstatus;//出库状态
	protected String accountstatus;//结账状态
	
	protected String itemsname;//物品名称
	protected String reqorg_q;//申领机构
	protected String category_q;//物品种类
	protected String reqstatus_q;//状态
	protected String outtype_q;//出库类型
	protected String stockorg;//stock表机构号
	protected String reqtime_f;
	protected String reqtime_t;
	protected String chktime_f;
	protected String chktime_t;
	protected String rcvtime_f;
	protected String rcvtime_t;
	
	protected String sortType;//排序方式
	
	/**
	 * 出库类型集合
	 */
	protected List<String> outTypeList;
	
	
	
	
	
	/**
	 * @return the outTypeList
	 */
	public List<String> getOutTypeList() {
		return outTypeList;
	}
	/**
	 * @param outTypeList the outTypeList to set
	 */
	public void setOutTypeList(List<String> outTypeList) {
		this.outTypeList = outTypeList;
	}
	/**
	 * @return the rcvtime_f
	 */
	public String getRcvtime_f() {
		return rcvtime_f;
	}
	/**
	 * @param rcvtime_f the rcvtime_f to set
	 */
	public void setRcvtime_f(String rcvtime_f) {
		this.rcvtime_f = rcvtime_f;
	}
	/**
	 * @return the rcvtime_t
	 */
	public String getRcvtime_t() {
		return rcvtime_t;
	}
	/**
	 * @param rcvtime_t the rcvtime_t to set
	 */
	public void setRcvtime_t(String rcvtime_t) {
		this.rcvtime_t = rcvtime_t;
	}
	/**
	 * @return the chktime_f
	 */
	public String getChktime_f() {
		return chktime_f;
	}
	/**
	 * @param chktime_f the chktime_f to set
	 */
	public void setChktime_f(String chktime_f) {
		this.chktime_f = chktime_f;
	}
	/**
	 * @return the chktime_t
	 */
	public String getChktime_t() {
		return chktime_t;
	}
	/**
	 * @param chktime_t the chktime_t to set
	 */
	public void setChktime_t(String chktime_t) {
		this.chktime_t = chktime_t;
	}
	/**
	 * @return the sortType
	 */
	public String getSortType() {
		return sortType;
	}
	/**
	 * @param sortType the sortType to set
	 */
	public void setSortType(String sortType) {
		this.sortType = sortType;
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
	public String getStockorg() {
		return stockorg;
	}
	public void setStockorg(String stockorg) {
		this.stockorg = stockorg;
	}
	public String getOuttype_q() {
		return outtype_q;
	}
	public void setOuttype_q(String outtype_q) {
		this.outtype_q = outtype_q;
	}
	public String getReqstatus_q() {
		return reqstatus_q;
	}
	public void setReqstatus_q(String reqstatus_q) {
		this.reqstatus_q = reqstatus_q;
	}
	public String getReqorg_q() {
		return reqorg_q;
	}
	public String getCategory_q() {
		return category_q;
	}
	public void setReqorg_q(String reqorg_q) {
		this.reqorg_q = reqorg_q;
	}
	public void setCategory_q(String category_q) {
		this.category_q = category_q;
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
	

	
	
	
	
}

/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.form;

import com.csebank.items.model.InStock;
import com.csebank.items.model.Stock;
import com.csebank.items.util.CSEHelper;
import com.deliverik.framework.base.BaseForm;

public class ITEMS0106Form extends BaseForm implements InStock, Stock{

	private static final long serialVersionUID = 1L;

	protected Integer instockid;
	protected String instockorg;
	protected String category;
	protected String seqcode;
	protected String intime;
	protected String seqno;
	protected String typecode;
	
	protected String type;
	protected String status;
	protected Double inprice;
	protected Double inamount;
	protected Double outprice;
	protected Double outamount;
	protected Integer packnum;
	protected Integer bigpacknum;
	
	protected Integer innum;
	protected Integer outnum;
	protected Integer lossnum;
	protected Integer havocnum;
	protected String nature;
	protected String itemversion;
	protected String printinside;
	protected String printexternal;
	protected String printcompany;
	protected String userid;
	protected String username;
	protected String itemsname;
	
	protected Integer stockid;
	protected String stockorg;
	
	protected Integer stocknum;
	protected Integer lostnum;
	protected Integer prenum;
	protected String uptime;
	
	//物品申领使用
	protected Integer sid;
	
	protected String editAble;//是否可以修改入库单价或出库单价
	
	protected Integer outstockid;
	
	protected Double price;

	protected Double amount;
	
	protected String typecode_q;
	
	/**
	 * 下拨分类
	 *        0512: 下拨全部
	 *        0512001: 下拨总行
	 *        0512002: 下拨支行
	 */
	protected String selectorg;
	
	
	
	/**
	 * @return the selectorg
	 */
	public String getSelectorg() {
		return selectorg;
	}
	/**
	 * @param selectorg the selectorg to set
	 */
	public void setSelectorg(String selectorg) {
		this.selectorg = selectorg;
	}
	/**
	 * @return the typecode_q
	 */
	public String getTypecode_q() {
		return typecode_q;
	}
	/**
	 * @param typecode_q the typecode_q to set
	 */
	public void setTypecode_q(String typecode_q) {
		this.typecode_q = typecode_q;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	/**
	 * @return the outstockid
	 */
	public Integer getOutstockid() {
		return outstockid;
	}
	/**
	 * @param outstockid the outstockid to set
	 */
	public void setOutstockid(Integer outstockid) {
		this.outstockid = outstockid;
	}
	/**
	 * @return the editAble
	 */
	public String getEditAble() {
		return editAble;
	}
	/**
	 * @param editAble the editAble to set
	 */
	public void setEditAble(String editAble) {
		this.editAble = editAble;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getStockid() {
		return stockid;
	}
	public void setStockid(Integer stockid) {
		this.stockid = stockid;
	}
	public String getStockorg() {
		return stockorg;
	}
	public void setStockorg(String stockorg) {
		this.stockorg = stockorg;
	}
	public Integer getStocknum() {
		return stocknum;
	}
	public void setStocknum(Integer stocknum) {
		this.stocknum = stocknum;
	}
	public Integer getLostnum() {
		return lostnum;
	}
	public void setLostnum(Integer lostnum) {
		this.lostnum = lostnum;
	}
	public Integer getPrenum() {
		return prenum;
	}
	public void setPrenum(Integer prenum) {
		this.prenum = prenum;
	}
	public String getUptime() {
		return CSEHelper.getCurrentTime();
	}
	public void setUptime(String uptime) {
		this.uptime = uptime;
	}
	public String getItemsname() {
		return itemsname;
	}
	public void setItemsname(String itemsname) {
		this.itemsname = itemsname;
	}
	public Integer getInstockid() {
		return instockid;
	}
	public void setInstockid(Integer instockid) {
		this.instockid = instockid;
	}
	public String getInstockorg() {
		return instockorg;
	}
	public void setInstockorg(String instockorg) {
		this.instockorg = instockorg;
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
	public String getIntime() {
		return CSEHelper.getCurrentTime();
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	public String getSeqno() {
		return seqno;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	public String getTypecode() {
		return typecode;
	}
	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getInprice() {
		return inprice;
	}
	public void setInprice(Double inprice) {
		this.inprice = inprice;
	}
	public Double getInamount() {
		return inamount;
	}
	public void setInamount(Double inamount) {
		this.inamount = inamount;
	}
	public Double getOutprice() {
		return outprice;
	}
	public void setOutprice(Double outprice) {
		this.outprice = outprice;
	}
	public Double getOutamount() {
		return outamount;
	}
	public void setOutamount(Double outamount) {
		this.outamount = outamount;
	}
	public Integer getPacknum() {
		return packnum;
	}
	public void setPacknum(Integer packnum) {
		this.packnum = packnum;
	}
	public Integer getBigpacknum() {
		return bigpacknum;
	}
	public void setBigpacknum(Integer bigpacknum) {
		this.bigpacknum = bigpacknum;
	}
	public Integer getInnum() {
		return innum;
	}
	public void setInnum(Integer innum) {
		this.innum = innum;
	}
	public Integer getOutnum() {
		return outnum;
	}
	public void setOutnum(Integer outnum) {
		this.outnum = outnum;
	}
	public Integer getLossnum() {
		return lossnum;
	}
	public void setLossnum(Integer lossnum) {
		this.lossnum = lossnum;
	}
	public Integer getHavocnum() {
		return havocnum;
	}
	public void setHavocnum(Integer havocnum) {
		this.havocnum = havocnum;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getItemversion() {
		return itemversion;
	}
	public void setItemversion(String itemversion) {
		this.itemversion = itemversion;
	}
	public String getPrintinside() {
		return printinside;
	}
	public void setPrintinside(String printinside) {
		this.printinside = printinside;
	}
	public String getPrintexternal() {
		return printexternal;
	}
	public void setPrintexternal(String printexternal) {
		this.printexternal = printexternal;
	}
	public String getPrintcompany() {
		return printcompany;
	}
	public void setPrintcompany(String printcompany) {
		this.printcompany = printcompany;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

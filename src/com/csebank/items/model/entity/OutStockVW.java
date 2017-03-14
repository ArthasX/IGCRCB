package com.csebank.items.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.csebank.items.model.OutStockVWInfo;

/**
 * OutStock_StockVW
 * 
 */
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "OutStockVW")
@SuppressWarnings("serial")
public class OutStockVW implements Serializable, OutStockVWInfo {
	@Id
	protected Integer outstockid;
	protected String outstockorg;
	protected String category;
	protected String seqcode;
	protected String typecode;
	protected String seqno;
	protected String outtype;
	
	protected String reqorg;
	protected String reqid;
	protected String reqname;
	protected String reqtime;
	protected Integer reqnum;
	protected Integer chknum;
	protected Integer outnum;
	
	protected String chkreason;
	protected String pakreason;
	protected String packno;
	protected String chkid;
	protected String chkname;
	protected String chktime;
	protected String stockuserid;
	
	protected String stockname;
	protected String outtime;
	protected String rcvid;
	protected String rcvname;
	protected String rcvtime;
	protected String reqstatus;
	protected String accountstatus;
	
	protected Double inprice;
	protected Double outprice;
	protected Double outamount;
	protected Integer bigpacknum;
	protected Integer smallpacknum;
	protected String itemversion;
	protected Integer stockid;
	
	protected String itemsname;//物品名称
	protected Integer stocknum;//当前库存数量
	protected String type;//物品类型
	
	protected Integer sid;//stock表主键id
	protected String stockorg;//stock表库存机构号
	
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return outstockid;
	}
	
	
	public Integer getSid() {
		return sid;
	}


	public void setSid(Integer sid) {
		this.sid = sid;
	}


	public String getStockorg() {
		return stockorg;
	}


	public void setStockorg(String stockorg) {
		this.stockorg = stockorg;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getOutstockid() {
		return outstockid;
	}
	public String getOutstockorg() {
		return outstockorg;
	}
	public String getCategory() {
		return category;
	}
	public String getSeqcode() {
		return seqcode;
	}
	public String getTypecode() {
		return typecode;
	}
	public String getSeqno() {
		return seqno;
	}
	public String getOuttype() {
		return outtype;
	}
	public String getReqorg() {
		return reqorg;
	}
	public String getReqid() {
		return reqid;
	}
	public String getReqname() {
		return reqname;
	}
	public String getReqtime() {
		return reqtime;
	}
	public Integer getReqnum() {
		return reqnum;
	}
	public Integer getChknum() {
		return chknum;
	}
	public Integer getOutnum() {
		return outnum;
	}
	public String getChkreason() {
		return chkreason;
	}
	public String getPakreason() {
		return pakreason;
	}
	public String getPackno() {
		return packno;
	}
	public String getChkid() {
		return chkid;
	}
	public String getChkname() {
		return chkname;
	}
	public String getChktime() {
		return chktime;
	}
	public String getStockuserid() {
		return stockuserid;
	}
	public String getStockname() {
		return stockname;
	}
	public String getOuttime() {
		return outtime;
	}
	public String getRcvid() {
		return rcvid;
	}
	public String getRcvname() {
		return rcvname;
	}
	public String getRcvtime() {
		return rcvtime;
	}
	public String getReqstatus() {
		return reqstatus;
	}
	public String getAccountstatus() {
		return accountstatus;
	}
	public Double getInprice() {
		return inprice;
	}
	public Double getOutprice() {
		return outprice;
	}
	public Double getOutamount() {
		return outamount;
	}
	public Integer getBigpacknum() {
		return bigpacknum;
	}
	public Integer getSmallpacknum() {
		return smallpacknum;
	}
	public String getItemversion() {
		return itemversion;
	}
	public Integer getStockid() {
		return stockid;
	}
	public String getItemsname() {
		return itemsname;
	}
	public Integer getStocknum() {
		return stocknum;
	}
	
	
	public void setOutstockid(Integer outstockid) {
		this.outstockid = outstockid;
	}
	public void setOutstockorg(String outstockorg) {
		this.outstockorg = outstockorg;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setSeqcode(String seqcode) {
		this.seqcode = seqcode;
	}
	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	public void setOuttype(String outtype) {
		this.outtype = outtype;
	}
	public void setReqorg(String reqorg) {
		this.reqorg = reqorg;
	}
	public void setReqid(String reqid) {
		this.reqid = reqid;
	}
	public void setReqname(String reqname) {
		this.reqname = reqname;
	}
	public void setReqtime(String reqtime) {
		this.reqtime = reqtime;
	}
	public void setReqnum(Integer reqnum) {
		this.reqnum = reqnum;
	}
	public void setChknum(Integer chknum) {
		this.chknum = chknum;
	}
	public void setOutnum(Integer outnum) {
		this.outnum = outnum;
	}
	public void setChkreason(String chkreason) {
		this.chkreason = chkreason;
	}
	public void setPakreason(String pakreason) {
		this.pakreason = pakreason;
	}
	public void setPackno(String packno) {
		this.packno = packno;
	}
	public void setChkid(String chkid) {
		this.chkid = chkid;
	}
	public void setChkname(String chkname) {
		this.chkname = chkname;
	}
	public void setChktime(String chktime) {
		this.chktime = chktime;
	}
	public void setStockuserid(String stockuserid) {
		this.stockuserid = stockuserid;
	}
	public void setStockname(String stockname) {
		this.stockname = stockname;
	}
	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}
	public void setRcvid(String rcvid) {
		this.rcvid = rcvid;
	}
	public void setRcvname(String rcvname) {
		this.rcvname = rcvname;
	}
	public void setRcvtime(String rcvtime) {
		this.rcvtime = rcvtime;
	}
	public void setReqstatus(String reqstatus) {
		this.reqstatus = reqstatus;
	}
	public void setAccountstatus(String accountstatus) {
		this.accountstatus = accountstatus;
	}
	public void setInprice(Double inprice) {
		this.inprice = inprice;
	}
	public void setOutprice(Double outprice) {
		this.outprice = outprice;
	}
	public void setOutamount(Double outamount) {
		this.outamount = outamount;
	}
	public void setBigpacknum(Integer bigpacknum) {
		this.bigpacknum = bigpacknum;
	}
	public void setSmallpacknum(Integer smallpacknum) {
		this.smallpacknum = smallpacknum;
	}
	public void setItemversion(String itemversion) {
		this.itemversion = itemversion;
	}
	public void setStockid(Integer stockid) {
		this.stockid = stockid;
	}
	public void setItemsname(String itemsname) {
		this.itemsname = itemsname;
	}
	public void setStocknum(Integer stocknum) {
		this.stocknum = stocknum;
	}

	
	

	
}

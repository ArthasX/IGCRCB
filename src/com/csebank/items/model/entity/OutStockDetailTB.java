package com.csebank.items.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.csebank.items.model.OutStockDetail;
import com.deliverik.framework.base.BaseEntity;


@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="OutStockDetail")
public class OutStockDetailTB extends BaseEntity implements Serializable, Cloneable, OutStockDetail {

	@Id
	@TableGenerator(
		    name="OUTSTOCKDETAIL_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="OUTSTOCKDETAIL_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="OUTSTOCKDETAIL_TABLE_GENERATOR")
	protected Integer id;
	protected Integer outstockid;
	protected Integer instockid;
	protected String outstockorg;
	protected String category;
	protected String seqcode;
	protected String typecode;
	protected String inseqno;//入库信息表--批次号
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
	protected String paytime;//结账时间
	
	
	public OutStockDetailTB clone(OutStockDetail os){
		this.outstockid = os.getOutstockid();
		this.instockid = os.getInstockid();
		this.outstockorg = os.getOutstockorg();
		this.category = os.getCategory();
		this.seqcode = os.getSeqcode();
		this.typecode = os.getTypecode();
		this.seqno = os.getSeqno();
		this.inseqno = os.getInseqno();
		this.outtype = os.getOuttype();
		
		this.reqorg = os.getReqorg();
		this.reqid = os.getReqid();
		this.reqname = os.getReqname();
		this.reqtime = os.getReqtime();
		this.reqnum = os.getReqnum();
		this.chknum = os.getChknum();
		this.outnum = os.getOutnum();
		
		this.chkreason = os.getChkreason();
		this.pakreason = os.getPakreason();
		this.packno = os.getPackno();
		this.chkid = os.getChkid();
		this.chkname = os.getChkname();
		this.chktime=os.getChktime();
		this.stockuserid=os.getStockuserid();
		
		this.stockname=os.getStockname();
		this.outtime=os.getOuttime();
		this.rcvid=os.getRcvid();
		this.rcvname=os.getRcvname();
		this.rcvtime = os.getRcvtime();
		this.reqstatus = os.getReqstatus();
		this.accountstatus = os.getAccountstatus();
		
		this.inprice = os.getInprice();
		this.outprice=os.getOutprice();
		this.outamount=os.getOutamount();
		this.bigpacknum=os.getBigpacknum();
		this.smallpacknum=os.getSmallpacknum();
		this.itemversion=os.getItemversion();
		this.stockid=os.getStockid();
		
		this.itemsname=os.getItemsname();
		this.stocknum=os.getStocknum();
		this.type=os.getType();
		this.paytime = os.getPaytime();
		return this;
	}
	
	
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return id;
	}

	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return the inseqno
	 */
	public String getInseqno() {
		return inseqno;
	}


	/**
	 * @param inseqno the inseqno to set
	 */
	public void setInseqno(String inseqno) {
		this.inseqno = inseqno;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Integer getInstockid() {
		return instockid;
	}


	public void setInstockid(Integer instockid) {
		this.instockid = instockid;
	}


	public Integer getStocknum() {
		return stocknum;
	}


	public void setStocknum(Integer stocknum) {
		this.stocknum = stocknum;
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
	
	public void setItemsname(String itemsname) {
		this.itemsname = itemsname;
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


	public String getPaytime() {
		return paytime;
	}


	public void setPaytime(String paytime) {
		this.paytime = paytime;
	}
	
	

}

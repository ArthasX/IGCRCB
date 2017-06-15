package com.csebank.items.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.csebank.items.model.InStock;
import com.deliverik.framework.base.BaseEntity;


@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="InStock")
public class InStockTB extends BaseEntity implements Serializable, Cloneable, InStock {

	@Id
	@TableGenerator(
		    name="INSTOCK_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="INSTOCK_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="INSTOCK_TABLE_GENERATOR")
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
	
	protected String itemsname;//物品名称
	protected Integer outstockid;//出库表主键
	
	public InStockTB clone(InStock is){
		
		this.instockorg = is.getInstockorg();
		this.category = is.getCategory();
		this.seqcode = is.getSeqcode();
		this.intime = is.getIntime();
		this.seqno = is.getSeqno();
		this.typecode = is.getTypecode();
		this.type = is.getType();
		this.status = is.getStatus();
		this.inprice = is.getInprice();
		this.inamount = is.getInamount();
		this.outprice = is.getOutprice();
		this.outamount = is.getOutamount();
		this.packnum = is.getPacknum();
		this.bigpacknum = is.getBigpacknum();
		this.innum = is.getInnum();
		this.outnum = is.getOutnum();
		this.lossnum = is.getLossnum();
		this.havocnum = is.getHavocnum();
		this.nature = is.getNature();
		this.itemversion=is.getItemversion();
		this.printinside=is.getPrintinside();
		this.printexternal=is.getPrintexternal();
		this.printcompany=is.getPrintcompany();
		this.userid=is.getUserid();
		this.username=is.getUsername();
		this.itemsname=is.getItemsname();
		this.outstockid=is.getOutstockid();
		
		return this;
	}
	
	
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return instockid;
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


	public Integer getInstockid() {
		return instockid;
	}


	public String getInstockorg() {
		return instockorg;
	}


	public String getCategory() {
		return category;
	}


	public String getSeqcode() {
		return seqcode;
	}


	public String getIntime() {
		return intime;
	}


	public String getSeqno() {
		return seqno;
	}


	public String getTypecode() {
		return typecode;
	}


	public String getType() {
		return type;
	}


	public String getStatus() {
		return status;
	}


	public Double getInprice() {
		return inprice;
	}


	public Double getInamount() {
		return inamount;
	}


	public Double getOutprice() {
		return outprice;
	}


	public Double getOutamount() {
		return outamount;
	}


	public Integer getPacknum() {
		return packnum;
	}


	public Integer getBigpacknum() {
		return bigpacknum;
	}


	public Integer getInnum() {
		return innum;
	}


	public Integer getOutnum() {
		return outnum;
	}


	public Integer getLossnum() {
		return lossnum;
	}


	public Integer getHavocnum() {
		return havocnum;
	}


	public String getNature() {
		return nature;
	}


	public String getItemversion() {
		return itemversion;
	}


	public String getPrintinside() {
		return printinside;
	}


	public String getPrintexternal() {
		return printexternal;
	}


	public String getPrintcompany() {
		return printcompany;
	}


	public String getUserid() {
		return userid;
	}


	public String getUsername() {
		return username;
	}

	
	

	public String getItemsname() {
		return itemsname;
	}


	public void setItemsname(String itemsname) {
		this.itemsname = itemsname;
	}


	public void setInstockid(Integer instockid) {
		this.instockid = instockid;
	}


	public void setInstockorg(String instockorg) {
		this.instockorg = instockorg;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public void setSeqcode(String seqcode) {
		this.seqcode = seqcode;
	}


	public void setIntime(String intime) {
		this.intime = intime;
	}


	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}


	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}


	public void setType(String type) {
		this.type = type;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public void setInprice(Double inprice) {
		this.inprice = inprice;
	}


	public void setInamount(Double inamount) {
		this.inamount = inamount;
	}


	public void setOutprice(Double outprice) {
		this.outprice = outprice;
	}


	public void setOutamount(Double outamount) {
		this.outamount = outamount;
	}


	public void setPacknum(Integer packnum) {
		this.packnum = packnum;
	}


	public void setBigpacknum(Integer bigpacknum) {
		this.bigpacknum = bigpacknum;
	}


	public void setInnum(Integer innum) {
		this.innum = innum;
	}


	public void setOutnum(Integer outnum) {
		this.outnum = outnum;
	}


	public void setLossnum(Integer lossnum) {
		this.lossnum = lossnum;
	}


	public void setHavocnum(Integer havocnum) {
		this.havocnum = havocnum;
	}


	public void setNature(String nature) {
		this.nature = nature;
	}


	public void setItemversion(String itemversion) {
		this.itemversion = itemversion;
	}


	public void setPrintinside(String printinside) {
		this.printinside = printinside;
	}


	public void setPrintexternal(String printexternal) {
		this.printexternal = printexternal;
	}


	public void setPrintcompany(String printcompany) {
		this.printcompany = printcompany;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	

}

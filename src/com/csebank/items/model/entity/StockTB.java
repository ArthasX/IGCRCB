package com.csebank.items.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import com.csebank.items.model.Stock;
import com.deliverik.framework.base.BaseEntity;


@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="Stock")
public class StockTB extends BaseEntity implements Serializable, Cloneable, Stock {

	@Id
	@TableGenerator(
		    name="STOCK_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="STOCK_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="STOCK_TABLE_GENERATOR")
	protected Integer stockid;
	protected String stockorg;
	protected String category;
	protected String seqcode;
	protected String typecode;
	protected String type;
	protected String status;
	
	protected Integer stocknum;
	protected Integer lostnum;
	protected Integer prenum;
	protected Double inamount;
	protected Double outamount;
	protected String uptime;
	protected String userid;
	protected String username;
	
	protected String itemsname;//物品名称
	
	@Transient
	protected Double price;
	@Transient
	protected Double amount;
	
	public StockTB clone(Stock st){
		
		this.stockorg = st.getStockorg();
		this.category = st.getCategory();
		this.seqcode = st.getSeqcode();
		this.typecode = st.getTypecode();
		this.type = st.getType();
		this.status = st.getStatus();
		
		this.stocknum = st.getStocknum();
		this.lostnum = st.getLostnum();
		this.prenum = st.getPrenum();
		this.inamount = st.getInamount();
		this.outamount = st.getOutamount();
		this.uptime = st.getUptime();
		this.userid = st.getUserid();
		this.username = st.getUsername();
		
		this.itemsname = st.getItemsname();
		
		return this;
	}
	
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return stockid;
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

	public Integer getStockid() {
		return stockid;
	}


	public String getStockorg() {
		return stockorg;
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


	public String getType() {
		return type;
	}


	public String getStatus() {
		return status;
	}


	public Integer getStocknum() {
		return stocknum;
	}


	public Integer getLostnum() {
		return lostnum;
	}


	public Integer getPrenum() {
		return prenum;
	}


	public Double getInamount() {
		return inamount;
	}


	public Double getOutamount() {
		return outamount;
	}


	public String getUptime() {
		return uptime;
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

	public void setStockid(Integer stockid) {
		this.stockid = stockid;
	}


	public void setStockorg(String stockorg) {
		this.stockorg = stockorg;
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


	public void setType(String type) {
		this.type = type;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public void setStocknum(Integer stocknum) {
		this.stocknum = stocknum;
	}


	public void setLostnum(Integer lostnum) {
		this.lostnum = lostnum;
	}


	public void setPrenum(Integer prenum) {
		this.prenum = prenum;
	}


	public void setInamount(Double inamount) {
		this.inamount = inamount;
	}


	public void setOutamount(Double outamount) {
		this.outamount = outamount;
	}


	public void setUptime(String uptime) {
		this.uptime = uptime;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public void setUsername(String username) {
		this.username = username;
	}
	
	

}

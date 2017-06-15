package com.csebank.items.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.csebank.items.model.ItemsCodes;
import com.deliverik.framework.base.BaseEntity;


@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="ItemsCodes")
public class ItemsCodesTB extends BaseEntity implements Serializable, Cloneable, ItemsCodes {

	@Id
	@TableGenerator(
		    name="ITEMSCODES_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="ITEMSCODES_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="ITEMSCODES_TABLE_GENERATOR")
	protected Integer icid;
	protected String selectid;
	protected String selectname;
	protected String typecode;
	protected String typename;
	protected String idesc;
	protected String status;
	
	
	/**
	 * Ö÷¼üÈ¡µÃ
	 * @return 
	 */
	public Serializable getPK() {
		return icid;
	}
	
	public Integer getIcid() {
		return icid;
	}
	public void setIcid(Integer icid) {
		this.icid = icid;
	}
	public String getSelectid() {
		return selectid;
	}
	public void setSelectid(String selectid) {
		this.selectid = selectid;
	}
	public String getSelectname() {
		return selectname;
	}
	public void setSelectname(String selectname) {
		this.selectname = selectname;
	}
	public String getTypecode() {
		return typecode;
	}
	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public String getIdesc() {
		return idesc;
	}
	public void setIdesc(String idesc) {
		this.idesc = idesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	

}

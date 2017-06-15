package com.csebank.items.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.csebank.items.model.ItemsCategory;
import com.deliverik.framework.base.BaseEntity;

@Entity
@Table(name="ItemsCategory")
public class ItemsCategoryTB extends BaseEntity implements Serializable, Cloneable, ItemsCategory {

	private static final long serialVersionUID = 6048532624180275272L;
	@Id
	@TableGenerator(
		    name="ITEMSCATEGORY_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="ITEMSCATEGORY_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="ITEMSCATEGORY_TABLE_GENERATOR")
	protected Integer icid;
	protected String category;
	protected String seqcode;
	protected String typecode;
	protected String type;
	@Column(name="idesc")
	protected String desc;
	protected String status;

	public boolean equals(Object obj) {
		if (!(obj instanceof ItemsCategoryTB))
			return false;
		ItemsCategory target = (ItemsCategory) obj;
		if (!(getIcid()==target.getIcid()))
			return false;
		return true;
	}
	
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

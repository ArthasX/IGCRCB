/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.csebank.lom.model.ItemsCodesSt;
import com.deliverik.framework.base.BaseEntity;

/**
 * 
 * ʳ�óɱ�ʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="ITEMSCODES")
public class ItemsCodesStTB extends BaseEntity implements Serializable, Cloneable, ItemsCodesSt {
	
	/** �������������� */
	
	@TableGenerator(
		    name="ITEMSCODES_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="ITEMSCODES_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="ITEMSCODES_TABLE_GENERATOR")
	@Id
	protected Integer icid;

	/** �������� */
	protected String selectid;
	
	/** �������� */
	protected String selectname;
	
	/** �Ϳ���� */
	protected String typecode;
	
	/** �Ϳ����� */
	protected String typename;
	
	/** ������ */
	protected String type;
	
	/** ������ */
	@Column(name="idesc")
	protected String desc;
	
	/** ������ */
	protected String status;
	
	/**
	 * ����ȡ��
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

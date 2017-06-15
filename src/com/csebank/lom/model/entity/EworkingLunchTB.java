/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.csebank.lom.model.EworkingLunch;
import com.deliverik.framework.base.BaseEntity;

/**
 * 
 * ʳ�ù�������Ϣʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="EworkingLunch")
public class EworkingLunchTB extends BaseEntity implements Serializable, Cloneable, EworkingLunch {
	
	/** �������������� */
	
	@TableGenerator(
		    name="EWORKINGLUNCH_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="EWORKINGLUNCH_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="EWORKINGLUNCH_TABLE_GENERATOR")
	@Id
	protected Integer ewlid;

	/** ���� */
	protected String ewldate;
	
	/** �Ϳ����� */
	protected String lunchcardname;
	
	/** �Ϳ����� */
	protected Integer lunchcardnum;
	
	/** �Ϳ���Ǯ */
	protected BigDecimal lunchcardprince;
	
	/** �Ϳ���� */
	protected Integer icid;
	
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return ewlid;
	}
	
	/**
	 * ��������������
	 * @return ��������������
	 */
	public Integer getEwlid() {
		return ewlid;
	}
	
	/**
	 * ��������������
	 * @return ��������������
	 */
	public void setEwlid(Integer ewlid) {
		this.ewlid = ewlid;
	}
	
	/**
	 * ����
	 * @return ����
	 */
	public String getEwldate() {
		return ewldate;
	}
	/**
	 * ����
	 * @param ewldate ����
	 */
	public void setEwldate(String ewldate) {
		this.ewldate = ewldate;
	}

	public String getLunchcardname() {
		return lunchcardname;
	}

	public void setLunchcardname(String lunchcardname) {
		this.lunchcardname = lunchcardname;
	}

	public Integer getLunchcardnum() {
		return lunchcardnum;
	}

	public void setLunchcardnum(Integer lunchcardnum) {
		this.lunchcardnum = lunchcardnum;
	}

	public BigDecimal getLunchcardprince() {
		return lunchcardprince;
	}

	public void setLunchcardprince(BigDecimal lunchcardprince) {
		this.lunchcardprince = lunchcardprince;
	}

	public Integer getIcid() {
		return icid;
	}

	public void setIcid(Integer icid) {
		this.icid = icid;
	}
	
}

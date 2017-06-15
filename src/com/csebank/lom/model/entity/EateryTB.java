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

import com.csebank.lom.model.Eatery;
import com.deliverik.framework.base.BaseEntity;

/**
 * 
 * ʳ�óɱ�ʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="Eatery")
public class EateryTB extends BaseEntity implements Serializable, Cloneable, Eatery {
	
	/** �������������� */
	
	@TableGenerator(
		    name="EATERY_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="EATERY_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="EATERY_TABLE_GENERATOR")
	@Id
	protected Integer eid;

	/** ���� */
	protected String edate;
	
	/** �ɹ�ԭ�ϳɱ� */
	protected BigDecimal estaplecost;
	
	/** ��ζƷ�ɱ� */
	protected BigDecimal eflavouringcost;
	
	/** �����ɱ� */
	protected BigDecimal eothercost;
	
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return eid;
	}
	
	/**
	 * ��������������
	 * @return ��������������
	 */
	public Integer getEid() {
		return eid;
	}
	
	/**
	 * ��������������
	 * @param eid ��������������
	 */
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	
	/**
	 * ����
	 * @return ����
	 */
	public String getEdate() {
		return edate;
	}
	
	/**
	 * ����
	 * @param edate  ����
	 */
	public void setEdate(String edate) {
		this.edate = edate;
	}
	
	/**
	 * �ɹ�ԭ�ϳɱ�
	 * @return �ɹ�ԭ�ϳɱ�
	 */
	public BigDecimal getEstaplecost() {
		return estaplecost;
	}
	
	/**
	 * �ɹ�ԭ�ϳɱ�
	 * @param estaplecost �ɹ�ԭ�ϳɱ�
	 */
	public void setEstaplecost(BigDecimal estaplecost) {
		this.estaplecost = estaplecost;
	}
	
	/**
	 * ��ζƷ�ɱ�
	 * @return ��ζƷ�ɱ�
	 */
	public BigDecimal getEflavouringcost() {
		return eflavouringcost;
	}
	
	/**
	 * ��ζƷ�ɱ�
	 * @param eflavouringcost ��ζƷ�ɱ�
	 */
	public void setEflavouringcost(BigDecimal eflavouringcost) {
		this.eflavouringcost = eflavouringcost;
	}
	
	/**
	 * �����ɱ�
	 * @return �����ɱ�
	 */
	public BigDecimal getEothercost() {
		return eothercost;
	}
	
	/**
	 * �����ɱ�
	 * @param eothercost �����ɱ�
	 */
	public void setEothercost(BigDecimal eothercost) {
		this.eothercost = eothercost;
	}
	
}

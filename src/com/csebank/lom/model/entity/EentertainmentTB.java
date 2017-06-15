/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.csebank.lom.model.Eentertainment;
import com.deliverik.framework.base.BaseEntity;

/**
 * 
 * ʳ���д���Ϣʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="Eentertainment")
public class EentertainmentTB extends BaseEntity implements Serializable, Cloneable, Eentertainment {
	
	/** �������������� */
	
	@TableGenerator(
		    name="EENTERTAINMENT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="EENTERTAINMENT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="EENTERTAINMENT_TABLE_GENERATOR")
	@Id
	protected Integer eeid;

	/** �Ӵ�����ID */
	protected Integer rid;
	
	/** ������ */
	protected String eeuser;
	
	/** ÿ���˼۸� */
	protected BigDecimal eetableprice;

	/** ���� */
	protected Integer eetablenum;
	
	/** �Ƽ� */
	protected BigDecimal eedrinkprice;
	
	/** �̼� */
	protected BigDecimal eesmokeprice;
	
	/** ������Ʒ�۸� */
	protected BigDecimal eeotherprice;
	
	/** ���� */
	protected String eedate;
	
	/** �Ӵ�����ʵ�� */
	@OneToOne
	@JoinColumn(name="rid", referencedColumnName="rid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected RecptionTB recptionTB;
	
	
	
	
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return eeid;
	}
	
	/**
	 * ��������������
	 * @return ��������������
	 */
	public Integer getEeid() {
		return eeid;
	}
	
	/**
	 * ��������������
	 * @param eid ��������������
	 */
	public void setEeid(Integer eeid) {
		this.eeid = eeid;
	}
	
	/**
	 * �Ӵ�����ID
	 * @return �Ӵ�����ID
	 */
	public Integer getRid() {
		return rid;
	}
	
	/**
	 * �Ӵ�����ID
	 * @param rid �Ӵ�����ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	
	/**
	 * ������
	 * @return ������
	 */
	public String getEeuser() {
		return eeuser;
	}
	
	/**
	 * ������
	 * @param eeuser ������
	 */
	public void setEeuser(String eeuser) {
		this.eeuser = eeuser;
	}
	
	/**
	 * ÿ���˼۸�
	 * @return ÿ���˼۸�
	 */
	public BigDecimal getEetableprice() {
		return eetableprice;
	}
	
	/**
	 * ÿ���˼۸�
	 * @param eetableprice ÿ���˼۸�
	 */
	public void setEetableprice(BigDecimal eetableprice) {
		this.eetableprice = eetableprice;
	}
	
	/**
	 * ����
	 * @return ����
	 */
	public Integer getEetablenum() {
		return eetablenum;
	}
	
	/**
	 * ����
	 * @param eetablenum ����
	 */
	public void setEetablenum(Integer eetablenum) {
		this.eetablenum = eetablenum;
	}
	
	/**
	 * �Ƽ�
	 * @return �Ƽ�
	 */
	public BigDecimal getEedrinkprice() {
		return eedrinkprice;
	}
	
	/**
	 * �Ƽ�
	 * @param eedrinkprice �Ƽ�
	 */
	public void setEedrinkprice(BigDecimal eedrinkprice) {
		this.eedrinkprice = eedrinkprice;
	}
	
	/**
	 * �̼�
	 * @return �̼�
	 */
	public BigDecimal getEesmokeprice() {
		return eesmokeprice;
	}
	
	/**
	 * �̼�
	 * @param eesmokeprice �̼�
	 */
	public void setEesmokeprice(BigDecimal eesmokeprice) {
		this.eesmokeprice = eesmokeprice;
	}
	
	/**
	 * ������Ʒ�۸�
	 * @return ������Ʒ�۸�
	 */
	public BigDecimal getEeotherprice() {
		return eeotherprice;
	}
	
	/**
	 * ������Ʒ�۸�
	 * @param eeotherprice ������Ʒ�۸�
	 */
	public void setEeotherprice(BigDecimal eeotherprice) {
		this.eeotherprice = eeotherprice;
	}
	
	/**
	 * ����
	 * @return ����
	 */
	public String getEedate() {
		return eedate;
	}
	
	/**
	 * ����
	 * @param eedate ����
	 */
	public void setEedate(String eedate) {
		this.eedate = eedate;
	}

	public RecptionTB getRecptionTB() {
		return recptionTB;
	}
	
}

/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.csebank.lom.model.DeptEentertainment;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ʳ�ù���_ͳ�ƻ���_�д�ͳ����Ϣ
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
//public class ChangeKpiVW extends BaseEntity implements Serializable, Cloneable, ChangeKpi {
public class DeptEentertainmentVW implements Serializable, Cloneable, DeptEentertainment {

	@Id
	/**���� */
	protected Integer rid;
	protected String edept;
	
	/** �д�����*/
	protected BigDecimal enumber;
	
	/** �˼�*/
	protected BigDecimal eefoodprice;

	/**�Ƽ�*/
	protected BigDecimal eedrinkprice;
	
	/**�̼�*/
	protected BigDecimal eesmokeprice;
	
	protected BigDecimal eeotherprice;
	
	/**�ϼ� */
	protected BigDecimal etotal;
	
	/** �Ӵ�����ʵ�� */
	@OneToOne
	@JoinColumn(name="rid", referencedColumnName="rid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected RecptionTB recptionTB;
	
	public Serializable getPK() {
		return edept;
	}
	
	/**
	 * ����
	 * @return ����
	 */
	public String getEdept() {
		return edept;
	}
	
	/**
	 * ����
	 * @param edept ����
	 */
	public void setEdept(String edept) {
		this.edept = edept;
	}
	
	/**
	 * �д�����
	 * @return �д�����
	 */
	public BigDecimal getEnumber() {
		return enumber;
	}
	
	/**
	 * �д�����
	 * @param enumber �д�����
	 */
	public void setEnumber(BigDecimal enumber) {
		this.enumber = enumber;
	}
	
	/**
	 * �˼�
	 * @return �˼�
	 */
	public BigDecimal getEefoodprice() {
		return eefoodprice;
	}
	
	/**
	 * �˼�
	 * @param eefoodprice �˼�
	 */
	public void setEefoodprice(BigDecimal eefoodprice) {
		this.eefoodprice = eefoodprice;
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
	 * �ϼ�
	 * @return �ϼ�
	 */
	public BigDecimal getEtotal() {
		return etotal;
	}
	
	/**
	 * �ϼ�
	 * @param etotal �ϼ�
	 */
	public void setEtotal(BigDecimal etotal) {
		this.etotal = etotal;
	}

	public RecptionTB getRecptionTB() {
		return recptionTB;
	}

	public void setRecptionTB(RecptionTB recptionTB) {
		this.recptionTB = recptionTB;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public BigDecimal getEeotherprice() {
		return eeotherprice;
	}

	public void setEeotherprice(BigDecimal eeotherprice) {
		this.eeotherprice = eeotherprice;
	}

}

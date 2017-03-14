/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.csebank.lom.model.EentertainmentStatistics;


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
public class EentertainmentStatisticsVW implements Serializable, Cloneable, EentertainmentStatistics {

	@Id
	/**���� */
	protected String edate;
	
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
	
	public Serializable getPK() {
		return edate;
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
	 * @param wldate ����
	 */
	public void setEdate(String edate) {
		this.edate = edate;
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

	public BigDecimal getEeotherprice() {
		return eeotherprice;
	}

	public void setEeotherprice(BigDecimal eeotherprice) {
		this.eeotherprice = eeotherprice;
	}

}

/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.csebank.lom.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.csebank.lom.model.WorkLunchEatery;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ʳ�ù���_ͳ�ƻ���_����������ͳ����Ϣ
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@IdClass(WorkLunchEateryVWPK.class)
@Entity
//public class ChangeKpiVW extends BaseEntity implements Serializable, Cloneable, ChangeKpi {
public class WorkLunchEateryVW implements Serializable, Cloneable, WorkLunchEatery {

	@Id

	/**���� */
	protected String wldate;
	
	/** �ɱ��ϼ�*/
	protected String allcost;
	
	/** ��ζƷ�ɱ�*/
	protected String eflavouringcost;

	/**�ɹ�ԭ�ϳɱ�*/
	protected String estaplecost;
	
	/**�����ɱ�*/
	protected String eothercost;
	
	@Id
	protected String lunchcardname;
	
	protected String lunchcardnum;
	
	protected String lunchcardprice;
	
	/** ����ϼ� */
	protected String incost;
	
	/** ����ϼ� */
	protected String outcost;
	
	/**
	 * ����
	 * @return ����
	 */
	public String getWldate() {
		return wldate;
	}
	
	/**
	 * ����
	 * @param wldate ����
	 */
	public void setWldate(String wldate) {
		this.wldate = wldate;
	}
	
	/**
	 * �ɱ��ϼ�
	 * @return �ɱ��ϼ�
	 */
	public String getAllcost() {
		return allcost;
	}
	
	/**
	 * �ɱ��ϼ�
	 * @param allcost�ɱ��ϼ�
	 */
	public void setAllcost(String allcost) {
		this.allcost = allcost;
	}
	
	/**
	 * ��ζƷ�ɱ�
	 * @return eflavouringcost ��ζƷ�ɱ�
	 */
	public String getEflavouringcost() {
		return eflavouringcost;
	}
	
	/**
	 * ��ζƷ�ɱ�
	 * @param eflavouringcost ��ζƷ�ɱ�
	 */
	public void setEflavouringcost(String eflavouringcost) {
		this.eflavouringcost = eflavouringcost;
	}
	
	/**
	 * �ɹ�ԭ�ϳɱ�
	 * @return �ɹ�ԭ�ϳɱ�
	 */
	public String getEstaplecost() {
		return estaplecost;
	}
	
	/**
	 * �ɹ�ԭ�ϳɱ�
	 * @param estaplecost �ɹ�ԭ�ϳɱ�
	 */
	public void setEstaplecost(String estaplecost) {
		this.estaplecost = estaplecost;
	}
	
	/**
	 * �����ɱ�
	 * @return �����ɱ�
	 */
	public String getEothercost() {
		return eothercost;
	}
	
	/**
	 * �����ɱ�
	 * @param eothercost �����ɱ�
	 */
	public void setEothercost(String eothercost) {
		this.eothercost = eothercost;
	}

	public String getIncost() {
		return incost;
	}

	public void setIncost(String incost) {
		this.incost = incost;
	}

	public String getOutcost() {
		return outcost;
	}

	public void setOutcost(String outcost) {
		this.outcost = outcost;
	}

	public String getLunchcardname() {
		return lunchcardname;
	}

	public void setLunchcardname(String lunchcardname) {
		this.lunchcardname = lunchcardname;
	}

	public String getLunchcardnum() {
		return lunchcardnum;
	}

	public void setLunchcardnum(String lunchcardnum) {
		this.lunchcardnum = lunchcardnum;
	}

	public String getLunchcardprice() {
		return lunchcardprice;
	}

	public void setLunchcardprice(String lunchcardprice) {
		this.lunchcardprice = lunchcardprice;
	}
}

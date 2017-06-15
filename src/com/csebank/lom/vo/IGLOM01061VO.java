/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import com.csebank.lom.model.DealVWInfo;
import com.csebank.lom.model.RecptionVWInfo;
import com.csebank.lom.util.LOMHelper;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * �Ӵ���������VO
 *
 */
public class IGLOM01061VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * �Ӵ���������������
	 */
	protected List<RecptionVWInfo> recptionVWList;
	/**
	 * ����Ͳ͹�������������
	 */
	protected List<DealVWInfo> dealVWList;
	
	/** �����ܽ�� */
	protected BigDecimal sumamount;
	
	/** �Ӵ������� */
	protected Integer sumrnum;

	/**
	 * �Ӵ���������������ȡ��
	 * @return �Ӵ���������������
	 */
	public List<RecptionVWInfo> getRecptionVWList() {
		return recptionVWList;
	}

	/**
	 * �Ӵ���������������
	 * @param recptionList �Ӵ���������������
	 */
	public void setRecptionVWList(List<RecptionVWInfo> recptionVWList) {
		this.recptionVWList = recptionVWList;
		//�ϼ�
		RecptionVWInfo ro = null;
		BigDecimal dbamount = new BigDecimal(0);
		Integer dbrnum = 0;
		
		Iterator<RecptionVWInfo> it = recptionVWList.iterator();
		while(it.hasNext()){
				ro = it.next();
				dbamount = LOMHelper.getAdd(dbamount, ro.getAmount());
				dbrnum += ro.getRnum();
		}	
		sumamount = dbamount;
		sumrnum = dbrnum;
	}

	/**
	 * �����ܽ��ȡ��
	 * @return �����ܽ��
	 */
	public BigDecimal getSumamount() {
		return sumamount;
	}

	/**
	 * �Ӵ�������ȡ��
	 * @return �Ӵ�������
	 */
	public Integer getSumrnum() {
		return sumrnum;
	}

	public List<DealVWInfo> getDealVWList() {
		return dealVWList;
	}

	public void setDealVWList(List<DealVWInfo> dealVWList) {
		this.dealVWList = dealVWList;
		//�ϼ�
		DealVWInfo ro = null;
		BigDecimal dbamount = new BigDecimal(0);
		Integer dbrnum = 0;
		
		Iterator<DealVWInfo> it = dealVWList.iterator();
		while(it.hasNext()){
				ro = it.next();
				dbamount = LOMHelper.getAdd(dbamount, ro.getAmount());
				dbrnum += ro.getRnum();
		}	
		sumamount = dbamount;
		sumrnum = dbrnum;
	}

}

/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Deal;
import com.csebank.lom.model.DealAmount;
import com.csebank.lom.model.Recption;
import com.csebank.lom.model.RecptionAmount;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * �Ӵ���������VO
 *
 */
public class IGLOM01031VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * �Ӵ���������������
	 */
	protected List<Recption> recptionList;
	protected List<Deal> dealList;

	/**
	 * �Ӵ���������������(����)
	 */
	protected List<RecptionAmount> recptionAmountList;
	protected List<DealAmount> dealAmountList;

	/**
	 * �Ӵ���������������ȡ��
	 * @return �Ӵ���������������
	 */
	public List<Recption> getRecptionList() {
		return recptionList;
	}

	/**
	 * �Ӵ���������������
	 * @param recptionList �Ӵ���������������
	 */
	public void setRecptionList(List<Recption> recptionList) {
		this.recptionList = recptionList;
	}
	public void setDealList(List<Deal> dealList) {
		this.dealList = dealList;
	}

	public List<Deal> getDealList() {
		return dealList;
	}


	/**
	 * �Ӵ���������������ȡ��
	 * @return �Ӵ���������������
	 */
	public List<RecptionAmount> getRecptionAmountList() {
		return recptionAmountList;
	}

	/**
	 * �Ӵ���������������
	 * @param recptionList �Ӵ���������������
	 */
	public void setRecptionAmountList(List<RecptionAmount> recptionAmountList) {
		this.recptionAmountList = recptionAmountList;
	}

	public List<DealAmount> getDealAmountList() {
		return dealAmountList;
	}

	public void setDealAmountList(List<DealAmount> dealAmountList) {
		this.dealAmountList = dealAmountList;
	}

}

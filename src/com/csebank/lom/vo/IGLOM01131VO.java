/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Deal;
import com.csebank.lom.model.GuestRecption;
import com.csebank.lom.model.Recption;
import com.csebank.lom.model.RecptionCost;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * ���ŽӴ�����ͳ����ϸ����VO
 *
 */
public class IGLOM01131VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * ���ŽӴ���������������
	 */
	protected List<Recption> recptionList;
	protected List<Deal> dealList;
	/**
	 * ���ŽӴ������ͷ�����Ϣ�������
	 */
	protected List<RecptionCost> recptionCostList;
	
	/** �Ӵ����˺ͽӴ�������������� */
	protected List<GuestRecption> guestRecptionList;
	
	/**
	 * �Ӵ����˺ͽӴ��������������ȡ��
	 * @return �Ӵ����˺ͽӴ��������������
	 */
	public List<GuestRecption> getGuestRecptionList() {
		return guestRecptionList;
	}
	
	/**
	 * �Ӵ����˺ͽӴ���������������趨
	 * @param guestRecptionList �Ӵ����˺ͽӴ��������������
	 */
	public void setGuestRecptionList(List<GuestRecption> guestRecptionList) {
		this.guestRecptionList = guestRecptionList;
	}
	/**
	 * ���ŽӴ������ͷ�����Ϣ�������ȡ��
	 * @return ���ŽӴ������ͷ�����Ϣ�������
	 */
	public List<RecptionCost> getRecptionCostList() {
		return recptionCostList;
	}
	
	/**
	 * ���ŽӴ������ͷ�����Ϣ��������趨
	 * @param recptionCostList ���ŽӴ������ͷ�����Ϣ�������
	 */
	public void setRecptionCostList(List<RecptionCost> recptionCostList) {
		this.recptionCostList = recptionCostList;
	}

	/**
	 * ���ŽӴ���������������ȡ��
	 * @return ���ŽӴ���������������
	 */
	public List<Recption> getRecptionList() {
		return recptionList;
	}

	/**
	 * ���ŽӴ���������������
	 * @param recptionList ���ŽӴ���������������
	 */
	public void setRecptionList(List<Recption> recptionList) {
		this.recptionList = recptionList;
	}

	public List<Deal> getDealList() {
		return dealList;
	}

	public void setDealList(List<Deal> dealList) {
		this.dealList = dealList;
	}

}

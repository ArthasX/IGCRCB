/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Deal;
import com.csebank.lom.model.Recption;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * �Ӵ�����ͳ����ϸ����VO
 *
 */
public class IGLOM01111VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * �Ӵ���������������
	 */
	protected List<Recption> recptionList;
	protected List<Deal> dealList;

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

	public List<Deal> getDealList() {
		return dealList;
	}

	public void setDealList(List<Deal> dealList) {
		this.dealList = dealList;
	}

}

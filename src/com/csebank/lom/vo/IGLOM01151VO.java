/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Deal;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * �Ӵ���������VO
 *
 */
public class IGLOM01151VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * �Ӵ���������������
	 */
	protected List<Deal> dealList;

	/**
	 * �Ӵ���������������ȡ��
	 * @return �Ӵ���������������
	 */
	public List<Deal> getDealList() {
		return dealList;
	}

	/**
	 * �Ӵ���������������
	 * @param recptionList �Ӵ���������������
	 */
	public void setDealList(List<Deal> dealList) {
		this.dealList = dealList;
	}

}

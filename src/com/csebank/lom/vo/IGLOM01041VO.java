/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Recption;
import com.csebank.lom.model.RecptionGuest;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * �Ӵ����˹���VO
 *
 */
public class IGLOM01041VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/** �Ӵ�������������� */
	protected List<RecptionGuest> recptionGuestList;
	
	/** �Ӵ�������Ϣ */
	protected Recption recptionData;

	/**
	 * �Ӵ��������������ȡ��
	 * @return �Ӵ��������������
	 */
	public List<RecptionGuest> getRecptionGuestList() {
		return recptionGuestList;
	}

	/**
	 * �Ӵ���������������趨
	 * @param recptionGuestList �Ӵ��������������
	 */
	public void setRecptionGuestList(List<RecptionGuest> recptionGuestList) {
		this.recptionGuestList = recptionGuestList;
	}

	/**
	 * �Ӵ�������Ϣȡ��
	 * @return �Ӵ�������Ϣ
	 */
	public Recption getRecptionData() {
		return recptionData;
	}

	/**
	 * �Ӵ�������Ϣ�趨
	 * @param recptionData �Ӵ�������Ϣ
	 */
	public void setRecptionData(Recption recptionData) {
		this.recptionData = recptionData;
	}

}

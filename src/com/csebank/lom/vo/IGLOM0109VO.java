/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.RecptionGuestInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * �Ӵ����˲�ѯVO
 *
 */
public class IGLOM0109VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**�Ӵ����˲�ѯList*/
	protected List<RecptionGuestInfo> recptionguestInfoList;

	/**
	 * ���캯��
	 * @param invoiceVWList List<ChangeKpi>
	 * 
	 */
	
	public IGLOM0109VO(List<RecptionGuestInfo> recptionguestInfoList) {
		this.recptionguestInfoList = recptionguestInfoList;
	}

	public List<RecptionGuestInfo> getRecptionguestInfoList() {
		return recptionguestInfoList;
	}

	public void setRecptionguestInfoList(
			List<RecptionGuestInfo> recptionguestInfoList) {
		this.recptionguestInfoList = recptionguestInfoList;
	}

	/**
	 * ��ȡ�Ӵ����˲�ѯͳ����ϢLis
	 * @return �Ӵ����˲�ѯ��ϢLis
	 */
	
	

	
}

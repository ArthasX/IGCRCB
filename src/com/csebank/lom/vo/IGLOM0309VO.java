/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.AdvanceSummary;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * �Ӵ���������VO
 *
 */
public class IGLOM0309VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * Ԥ֧�¶�ͳ�Ƽ������
	 */
	protected List<AdvanceSummary> summaryList;

	/**
	 * Ԥ֧�¶�ͳ�Ƽ������ȡ��
	 * @return Ԥ֧�¶�ͳ�Ƽ������
	 */
	public List<AdvanceSummary> getSummaryList() {
		return summaryList;
	}

	/**
	 * Ԥ֧�¶�ͳ�Ƽ������
	 * @param recptionList Ԥ֧�¶�ͳ�Ƽ������
	 */
	public void setSummaryList(List<AdvanceSummary> summaryList) {
		this.summaryList = summaryList;
	}

}

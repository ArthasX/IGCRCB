/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.LoanPayDetail;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * ���������ȷ��VO
 *
 */
public class IGLOM03041VO extends BaseVO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	/** ���������ȷ�ϼ������ */
	protected List<LoanPayDetail> loanPayDetailList;

	/**
	 * ���������ȷ��ȡ��
	 * @return ���������ȷ��
	 */
	public List<LoanPayDetail> getLoanPayDetailList() {
		return loanPayDetailList;
	}

	/**
	 * ���������ȷ���趨
	 * @param loanPayDetailList ���������ȷ��
	 */
	public void setLoanPayDetailList(List<LoanPayDetail> loanPayDetailList) {
		this.loanPayDetailList = loanPayDetailList;
	}

}

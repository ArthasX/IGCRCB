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
 * ������VO
 *
 */
public class IGLOM03061VO extends BaseVO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	/** ���������� */
	protected List<LoanPayDetail> loanPayDetailList;

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public List<LoanPayDetail> getLoanPayDetailList() {
		return loanPayDetailList;
	}

	/**
	 * �����������趨
	 * @param loanPayDetailList ����������
	 */
	public void setLoanPayDetailList(List<LoanPayDetail> loanPayDetailList) {
		this.loanPayDetailList = loanPayDetailList;
	}

}

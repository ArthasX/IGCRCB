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
 * ��ּƲƲ����VO
 *
 */
public class IGLOM03071VO extends BaseVO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	/** ��ּƲƲ���������� */
	protected List<LoanPayDetail> loanPayDetailList;

	/**
	 * ��ּƲƲ����ȡ��
	 * @return ��ּƲƲ����
	 */
	public List<LoanPayDetail> getLoanPayDetailList() {
		return loanPayDetailList;
	}

	/**
	 * ��ּƲƲ�����趨
	 * @param loanPayDetailList ��ּƲƲ����
	 */
	public void setLoanPayDetailList(List<LoanPayDetail> loanPayDetailList) {
		this.loanPayDetailList = loanPayDetailList;
	}

}

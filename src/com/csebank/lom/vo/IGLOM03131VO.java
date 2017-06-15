/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.csebank.lom.model.LoanPayDetail;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * ����Ǽǹ���VO
 *
 */
public class IGLOM03131VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/** ����Ǽ���������� */
	protected List<LoanPayDetail> loanPayDetailList;
	
	/** ����Ǽ���Ϣ */
	protected LoanPayDetail loanPayDetailData;
	
	/** �����ܶ� */
	protected BigDecimal[] db;

	/**
	 * ����Ǽ����������ȡ��
	 * @return ����Ǽ����������
	 */
	public List<LoanPayDetail> getLoanPayDetailList() {
		return loanPayDetailList;
	}

	/**
	 * ����Ǽ�����������趨
	 * @param loanPayDetailList ����Ǽ����������
	 */
	public void setLoanPayDetailList(List<LoanPayDetail> loanPayDetailList) {
		this.loanPayDetailList = loanPayDetailList;
	}

	/**
	 * ����Ǽ���Ϣȡ��
	 * @return ����Ǽ���Ϣ
	 */
	public LoanPayDetail getLoanPayDetailData() {
		return loanPayDetailData;
	}

	/**
	 * ����Ǽ���Ϣ�趨
	 * @param loanPayDetailData ����Ǽ���Ϣ
	 */
	public void setLoanPayDetailData(LoanPayDetail loanPayDetailData) {
		this.loanPayDetailData = loanPayDetailData;
	}

	/**
	 * �����ܶ�ȡ��
	 * @return �����ܶ�
	 */
	public BigDecimal[] getDb() {
		return db;
	}

	/**
	 * �����ܶ��趨
	 * @param db �����ܶ�
	 */
	public void setDb(BigDecimal[] db) {
		this.db = db;
	}

}

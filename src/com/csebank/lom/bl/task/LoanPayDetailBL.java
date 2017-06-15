/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.math.BigDecimal;
import java.util.List;

import com.csebank.lom.model.LoanPayDetail;
import com.csebank.lom.model.condition.LoanPayDetailSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * �軹����ϸҵ���߼��ӿ�
 */
public interface LoanPayDetailBL extends BaseBL {

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(LoanPayDetailSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param lpdid �軹����ϸID
	 * @return �軹����ϸID
	 */
	public LoanPayDetail searchLoanPayDetailByKey(Integer lpdid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ���軹����ϸ��Ϣ
	 */
	public List<LoanPayDetail> searchLoanPayDetailAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<LoanPayDetail> searchLoanPayDetail(LoanPayDetailSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param LoanPayDetail ��¼����
	 * @return �軹����ϸ��Ϣ
	 */
	public LoanPayDetail registLoanPayDetail(LoanPayDetail loanPayDetail) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param lpdid �軹����ϸID
	 * @throws BLException
	 */
	public void deleteLoanPayDetail(Integer lpdid) throws BLException;

	/**
	 * �������
	 * 
	 * @param loanPayDetail �������
	 * @return �軹����ϸ��Ϣ
	 */
	public LoanPayDetail updateLoanPayDetail(LoanPayDetail loanPayDetail) throws BLException;
	
	/**
	 * ��ȡ�ѻ����ֽ������ѻ��Ʊ��
	 * 
	 * @param lpdid ����¼ID
	 * @return �ѻ����ֽ������ѻ��Ʊ��
	 */
	
	public BigDecimal[] searchAmountdAndInvoice(Integer lpdid);

}

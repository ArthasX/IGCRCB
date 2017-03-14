/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.math.BigDecimal;
import java.util.List;

import com.csebank.lom.model.AdvanCescost;
import com.csebank.lom.model.AdvanceSummary;
import com.csebank.lom.model.LoanPayDetail;
import com.csebank.lom.model.condition.AdvanceSummarySearchCond;
import com.csebank.lom.model.condition.AdvancesummaryCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * Ԥ֧����ҵ���߼��ӿ�
 */
public interface AdvanceSummaryBL extends BaseBL {

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(AdvanceSummarySearchCond cond);

	/**
	 * ������������
	 * 
	 * @param year ���
	 * @param month �·�
	 * @return Ԥ֧������Ϣ
	 */
	public AdvanceSummary searchAdvanceSummaryByKey(String year, String month) throws BLException;
	
	/**
	 * ����Ԥ֧���ܼ�������
	 * 
	 * @return Ԥ֧������Ϣ
	 */
	public AdvanceSummary searchCurrentAdvanceSummary() throws BLException;
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AdvanceSummary> searchAdvanceSummary(AdvanceSummarySearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param AdvanceSummary ��¼����
	 * @return ֵ��Ԥ֧������Ϣ
	 */
	public AdvanceSummary registAdvanceSummary(AdvanceSummary advanceSummary) throws BLException;

	/**
	 * �������
	 * 
	 * @param advanceSummary �������
	 * @return ֵ��Ԥ֧������Ϣ
	 */
	public AdvanceSummary updateAdvanceSummary(AdvanceSummary advanceSummary) throws BLException;
	
	/**
	 * Ԥ֧��������
	 * 
	 * ����Ԥ֧��� = ����Ԥ֧��� + ����Ԥ֧���
	 * ������� = ������� + ����Ԥ֧���		
	 * 
	 * @param advanCescost ����Ԥ֧������Ϣ
	 */
	public void insertAdvanCescost(AdvanCescost advanCescost) throws BLException;
	
	/**
	 * ������봦��
	 * 
	 * ������ = ������ + ��������		
	 * 
	 * @param loanPayDetail �����Ϣ
	 */
	public void loan(LoanPayDetail loanPayDetail) throws BLException;
	
	/**
	 * ���ɾ������
	 * 
	 * �������� = ������ - ����¼���		
	 * 
	 * @param loanPayDetail �����Ϣ
	 */
	public void deleteLoan(LoanPayDetail loanPayDetail) throws BLException;
	
	/**
	 * �������ͨ������
	 * 
	 * ������ = ������ - ������¼�Ľ����		
	 * ����� = ����� + ������¼�Ľ����		
	 * ������� = ������� - ������¼�Ľ����		
	 * 
	 * @param loanPayDetail �����Ϣ
	 */
	public void approveYes(LoanPayDetail loanPayDetail) throws BLException;
	
	/**
	 * ���������ͨ������
	 * 
	 * ������ = ������ - ������¼�Ľ����		
	 * 
	 * @param loanPayDetail �����Ϣ
	 */
	public void approveNo(LoanPayDetail loanPayDetail) throws BLException;
	
	/**
	 * ����ȷ�ϴ���,����¼������Ѹ���
	 * 	
	 * �ֽ𣺱��»����� = ���»����� + �����ֽ���		
	 *       ������� = ������� + �����ֽ���		
	 *       ����� = ����� - �����ֽ���		
	 * 
	 * @param loanPayDetail �����Ϣ
	 * 
	 */
	public void payConfirm(LoanPayDetail loanPayDetail) throws BLException;
	
	/**
	 * ���������,����¼������Ѹ���(���ϣ���Ϊ����ȷ��ʱ����payConfirmͳһ����)
	 * 	
	 * �ֽ𣺱��»����� = ���»����� + �����ֽ���		
	 *       ������� = ������� + �����ֽ���		
	 *       ����� = ����� - �����ֽ���		
	 * 
	 * @param loanPayDetail ������Ϣ
	 * 
	 */
	public void addPayByCash(LoanPayDetail loanPayDetail) throws BLException;
	
	/**
	 * ���������,����¼������Ѹ���(���ϣ���Ϊ����ȷ��ʱ����payConfirmͳһ����)
	 * 
	 * ��Ʊ�����·�Ʊ�� = ���·�Ʊ�� + ���Ʊ��		
	 *       ����� = ����� - ���Ʊ���			
	 * 
	 * @param loanPayDetail ������Ϣ
	 */
	public void addPayByInvoice(LoanPayDetail loanPayDetail) throws BLException;
	
	/**
	 * ɾ�������,����¼������Ѹ���(���ϣ���Ϊ����ȷ��ʱ����payConfirmͳһ����)
	 * 	
	 * �ֽ𣺱��»����� = ���»����� - �����ֽ���		
	 * 		������� = ������� - �����ֽ���		
	 * 		����� = ����� + �����ֽ���		
	 * 
	 * @param loanPayDetail ������Ϣ
	 * 
	 */
	public void delPayByCash(LoanPayDetail loanPayDetail) throws BLException;
	
	/**
	 * ɾ�������,����¼������Ѹ���(���ϣ���Ϊ����ȷ��ʱ����payConfirmͳһ����)
	 * 
	 * ��Ʊ�����·�Ʊ�� = ���·�Ʊ�� - ���Ʊ��		
	 * 		 ����� = ����� + ���Ʊ���		
	 * 
	 * @param loanPayDetail ������Ϣ
	 */
	public void delPayByInvoice(LoanPayDetail loanPayDetail) throws BLException;
	
	/**
	 * ��ֽ���
	 * 
	 * ��Ʊ���С��Ԥ֧���ʱ���ÿ������	
	 * 
	 * @param advanCescost Ԥ֧��Ϣ
	 * 
	 */
	public void credit(AdvanCescost advanCescost) throws BLException;
	
	/**
	 * ���ý��ȡ��
	 * 
	 * ���ý�� = ������� - ������
	 * 
	 * @return ���ý��
	 */
	public BigDecimal searchAvailableAmount() throws BLException;
	
	/**
	 * �����ȡ��
	 * 
	 * ����� = �������	
	 * 
	 * @return �����
	 */
	public BigDecimal searchStockAmount() throws BLException;
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AdvanceSummary> searchAdvanceSummaryByEmp(AdvancesummaryCond cond, int start, int count);

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(AdvancesummaryCond cond);
}

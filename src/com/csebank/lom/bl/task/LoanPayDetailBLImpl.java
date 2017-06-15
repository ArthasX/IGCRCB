/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.math.BigDecimal;
import java.util.List;

import com.csebank.lom.model.LoanPayDetail;
import com.csebank.lom.model.condition.LoanPayDetailSearchCond;
import com.csebank.lom.model.dao.LoanPayDetailDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * �軹����ϸҵ���߼��ӿ�ʵ��
 */
public class LoanPayDetailBLImpl extends BaseBLImpl implements LoanPayDetailBL {
	
	/** LoanPayDetail DAO */
	protected LoanPayDetailDAO loanPayDetailDAO;
	
	public void setLoanPayDetailDAO(
			LoanPayDetailDAO loanPayDetailDAO) {
		this.loanPayDetailDAO = loanPayDetailDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(LoanPayDetailSearchCond cond){
		
		return loanPayDetailDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param lpdid �軹����ϸID
	 * @return �軹����ϸID
	 */
	public LoanPayDetail searchLoanPayDetailByKey(Integer lpdid) throws BLException{
		
		return checkExistLoanPayDetail(lpdid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ���軹����ϸ��Ϣ
	 */
	public List<LoanPayDetail> searchLoanPayDetailAll(){
		
		return loanPayDetailDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<LoanPayDetail> searchLoanPayDetail(LoanPayDetailSearchCond cond, int start, int count){
		
		return loanPayDetailDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param loanPayDetail ��¼����
	 * @return �軹����ϸ��Ϣ
	 */
	public LoanPayDetail registLoanPayDetail(LoanPayDetail loanPayDetail) throws BLException{
		
		return loanPayDetailDAO.save(loanPayDetail);
	}

	/**
	 * ɾ������
	 * 
	 * @param lpdid �軹����ϸID
	 * @return
	 */
	public void deleteLoanPayDetail(Integer lpdid) throws BLException{
		
		LoanPayDetail loanPayDetail = checkExistLoanPayDetail(lpdid);
		
		loanPayDetailDAO.delete(loanPayDetail);
	}

	/**
	 * �������
	 * 
	 * @param loanPayDetail �������
	 * @return �軹����ϸ��Ϣ
	 */
	public LoanPayDetail updateLoanPayDetail(LoanPayDetail loanPayDetail) throws BLException{
		
		checkExistLoanPayDetail(loanPayDetail.getLpdid());
		return loanPayDetailDAO.save(loanPayDetail);
	}

	/**
	 * �軹����ϸ��Ϣ���ڼ��
	 * 
	 * @param lpdid �軹����ϸID
	 * @return �軹����ϸ��Ϣ
	 * @throws BLException 
	 */
	protected LoanPayDetail checkExistLoanPayDetail(Integer lpdid) throws BLException{
		LoanPayDetail info = loanPayDetailDAO.findByPK(lpdid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","�軹����ϸ����");
		}
		return info;
	}
	
	/**
	 * ��ȡ�ѻ����ֽ������ѻ��Ʊ��
	 * 
	 * @param lpdid ����¼ID
	 * @return �ѻ����ֽ������ѻ��Ʊ��
	 */
	
	public BigDecimal[] searchAmountdAndInvoice(Integer lpdid) {
		return loanPayDetailDAO.searchAmountdAndInvoice(lpdid);
	}

}

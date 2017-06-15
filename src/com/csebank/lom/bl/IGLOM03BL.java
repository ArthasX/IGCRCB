/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl;

import com.csebank.lom.dto.IGLOM03DTO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: Ԥ֧���ù���_Ԥ֧���ù����趨_BL
 * </p>
 * 
 * @version 
 */
public interface IGLOM03BL extends BaseBL {
	
	/**
	 * 
	 * Description: Ԥ֧������Ϣ��ѯ
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM03DTO searchAdvanCescostAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: Ԥ֧������Ϣ�趨
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM03DTO insertAdvanCescostAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: Ԥ֧������Ϣ���
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM03DTO updateAdvanCescostAction(IGLOM03DTO dto) throws BLException ;
	
	/**
	 * ״̬���³�����ʾ
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGLOM03DTO initAdvanCescostAction(IGLOM03DTO dto) throws BLException ;

	/**
	 * ɾ������
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGLOM03DTO deleteAdvanCescostAction(IGLOM03DTO dto) throws BLException ;
	
	/**
	 * ���ý��ȡ��
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchAvailableAmountAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: �����Ϣ�趨
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM03DTO insertLoanPayDetailAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * �����³�����ʾ
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO initLoanPayDetailAction(IGLOM03DTO dto) throws BLException ;

	/**
	 * ���ȷ�ϴ���
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO changeLoanPayDetailAction(IGLOM03DTO dto) throws BLException ;

	/**
	 * ���ɾ������
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO deleteLoanPayDetailAction(IGLOM03DTO dto) throws BLException ;
	
	/**
	 * 
	 * �����Ϣ��ѯ
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	
	public IGLOM03DTO searchLoanPayDetailAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * �����Ϣ��ѯ����
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchLoanPayDetailNoPagingAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * ��ּƲƲ������ܴ���
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchLoanPayDetailSummaryAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * ��ּƲƲ�����
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO loanPayDetailCredit(IGLOM03DTO dto) throws BLException;
	
	/**
	 * Ԥ֧��Աͳ�Ʋ�ѯ����
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchPersonLoanSummaryAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * Ԥ֧��Աͳ�Ƶ�������
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO exportPersonLoanSummaryAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * ��Ա�����ϸͳ�Ʋ�ѯ����
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchPersonLoanDetailAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * ��Ա�����ϸͳ�Ƶ�������
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO exportPersonLoanDetailAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * Ԥ֧��ϸͳ�Ʋ�ѯ����
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchAdvanceDetailAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * Ԥ֧��ϸͳ�Ƶ�������
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO exportAdvanceDetailAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * Ԥ֧�¶�ͳ�ƴ���
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchAdvancesummaryAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * ���Ʊ��ѯ����
	 * 
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 * @throws BLException
	 */
	public IGLOM03DTO searchLoanPayInvoiceAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * ���Ʊȷ�ϻ����
	 * 
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 * @throws BLException
	 */
	public IGLOM03DTO changeLoanPayInvoiceAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * ���Ʊɾ������
	 * 
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 * @throws BLException
	 */
	public IGLOM03DTO deleteLoanPayInvoiceAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * ���Ʊ��������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOM03DTO insertPayInvioceAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * Ԥ֧���ܶ�ʱ������
	 * 
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO advanceSummaryJob(IGLOM03DTO dto) throws BLException;

}

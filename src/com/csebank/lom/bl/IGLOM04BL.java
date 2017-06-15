/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl;

import com.csebank.lom.dto.IGLOM04DTO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��Ʊ��Ϣ_��Ʊ�����趨_BL
 * </p>
 * 
 * @version 
 */
public interface IGLOM04BL extends BaseBL {
	
	/**
	 * 
	 * Description: ��Ʊ��Ϣ��ѯ
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM04DTO searchInvoiceAction(IGLOM04DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: ��Ʊ��Ϣ�趨
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM04DTO insertInvoiceAction(IGLOM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��Ʊ���
	 * </p>
	 * 
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 * @throws BLException
	 * @author piaowei@deliverik.com
	 * @update
	 */
	public IGLOM04DTO updateInvoiceAction(IGLOM04DTO dto) throws BLException ;
	
	/**
	 * <p>
	 * Description: ֪ͨɾ��
	 * </p>
	 * 
	 * @param dto IGLOM04DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author piaowei@deliverik.com
	 * @update
	 */
	
	public IGLOM04DTO deleteNoticeAction(IGLOM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: ��Ʊ�����ʼ��
	 * </p>
	 * 
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 * @throws BLException
	 * @author piaowei@deliverik.com
	 * @update
	 */
	
	public IGLOM04DTO initIGLOM0402Action(IGLOM04DTO dto) throws BLException;
	
	/**
	 * ��ѯinvoice����ָ����Ʊ����ϸ��Ϣ
	 */
	public IGLOM04DTO searchStockDetailAction(IGLOM04DTO dto) throws BLException;
	
	/**
	 * ��Ʊ����ͳ�Ʋ�ѯ����
	 *
	 * @param dto IGSDL06DTO
	 * @return IGSDL06DTO
	 */
	public IGLOM04DTO searchInvoiceVWAction(IGLOM04DTO dto) throws BLException;
	
	/**
	 * ��Ʊ���ͳ����Ϣ��ѯ����
	 *
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 */
	public IGLOM04DTO searchInvoiceYearVWAction(IGLOM04DTO dto) throws BLException;
}

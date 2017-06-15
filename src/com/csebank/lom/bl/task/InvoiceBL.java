/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Invoice;
import com.csebank.lom.model.InvoiceTj;
import com.csebank.lom.model.condition.InvoiceInfoSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * ��Ʊ����ҵ���߼��ӿ�
 */
public interface InvoiceBL extends BaseBL {

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(InvoiceInfoSearchCond cond);

	/**
	 * ��¼����
	 * 
	 * @param Recption ��¼����
	 * @return ��Ʊ�������Ϣ
	 */
	public Invoice registInvoice(Invoice invoice) throws BLException;

	/**
	 * ��ѯ����
	 * 
	 * @param Invoice ��ѯ����
	 * @return ��Ʊ�������Ϣ
	 */
	public List<Invoice> searchInvoiceAction(InvoiceInfoSearchCond cond, int start, int count) throws BLException;
	
	/**
	 * ɾ������
	 * Description: ɾ��֪ͨ
	 * </p>
	 */
	
	public void deleteNotice(Integer nid) throws BLException;
	
	/**
	 * <p>
	 * Description: ͨ��������ѯ��Ӧ��¼
	 * </p>
	 */
	
	public Invoice searchInvoiceByKey(Integer iid);
	
	/**
	 * <p>
	 * Description: ��Ʊ���
	 * </p>
	 */
	
	public Invoice updateNotice(Invoice invoice) throws BLException;
	
	/**
	 * <p>
	 * Description: ��Ʊ����ͳ�Ʋ�ѯ
	 * </p>
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return List<ChangeKpi>
	 * @author piaowei@deliverik.com
	 */
	public List<InvoiceTj> searchInvoiceVW(InvoiceInfoSearchCond cond,int start, int count);
	/**
	 * <p>
	 * Description: ��Ʊ����ͳ�Ƽ���ȡ��
	 * </p>
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return int
	 * @author piaowei@deliverik.com
	 */
	public int getCountInvoiceVW(InvoiceInfoSearchCond cond,int start, int count);
	
	
}

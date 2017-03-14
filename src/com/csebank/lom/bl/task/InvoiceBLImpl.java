/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csebank.lom.bl.IGLOM04BLImpl;
import com.csebank.lom.model.Invoice;
import com.csebank.lom.model.InvoiceTj;
import com.csebank.lom.model.condition.InvoiceInfoSearchCond;
import com.csebank.lom.model.dao.InvoiceDAO;
import com.csebank.lom.model.dao.InvoiceVWDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * �Ӵ�����ҵ���߼��ӿ�ʵ��
 */
public class InvoiceBLImpl extends BaseBLImpl implements InvoiceBL {
	static Log log = LogFactory.getLog(IGLOM04BLImpl.class);


	/** Invoice DAO */
	protected InvoiceDAO InvoiceDAO;
    
	public void setInvoiceDAO(InvoiceDAO invoiceDAO) {
		InvoiceDAO = invoiceDAO;
	}
	protected InvoiceVWDAO invoiceVWDAO;
	
	

	public void setInvoiceVWDAO(InvoiceVWDAO invoiceVWDAO) {
		this.invoiceVWDAO = invoiceVWDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(InvoiceInfoSearchCond cond) {
		return InvoiceDAO.getSearchCount(cond);
		
	}
   
	/**
	 * ��¼����
	 * 
	 * @param recption ��¼����
	 * @return ��Ʊ��Ϣ
	 */
	public Invoice registInvoice(Invoice invoice) throws BLException {
		
		return InvoiceDAO.save(invoice);
	}
   
	/**
	 * <p>
	 * Description: ��Ʊ��ѯ
	 * </p>
	 * 
	 * @param dto IGLOM04DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author piaowei@deliverik.com
	 * @update
	 */
	
	public List<Invoice> searchInvoiceAction(final InvoiceInfoSearchCond cond,final int start,final int count)
			throws BLException {
		
		return InvoiceDAO.findByCond(cond,start,count);
	}
   
	/**
	 * <p>
	 * Description: ɾ��֪ͨ
	 * </p>
	 */
	
	public void deleteNotice(Integer nid) throws BLException {
		Invoice invoice = checkExistInvoice(nid);
		InvoiceDAO.delete(invoice);
	}
	
	/**
	 * <p>
	 * Description: ��ѯ�Ƿ���ڸ�����ID��֪ͨ
	 * </p>
	 */
	protected Invoice checkExistInvoice(Integer nid) throws BLException{
		Invoice info = InvoiceDAO.findByPK(nid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","��Ʊ����");
		}
		
		return info;
	}
   
	/**
	 * <p>
	 * Description: ͨ��������ѯ��Ӧ��¼
	 * </p>
	 */
	
	public Invoice searchInvoiceByKey(Integer iid) {
		Invoice ret = InvoiceDAO.findByPK(iid);
		return ret;
	}
	
	/**
	 * <p>
	 * Description: ����֪ͨ
	 * </p>
	 */
	
	public Invoice updateNotice(Invoice invoice) throws BLException {
		checkExistInvoice(invoice.getIid());
		Invoice ret = InvoiceDAO.save(invoice);
		return ret;
	}
	
	/**
	 * <p>
	 * Description: ��Ʊ����ͳ����Ϣ��ѯ
	 * </p>
	 */
	public List<InvoiceTj> searchInvoiceVW(InvoiceInfoSearchCond cond,
			int start, int count) {
		List<InvoiceTj> ret = invoiceVWDAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * <p>
	 * Description: ��Ʊ����ͳ����Ϣ������ѯ
	 * </p>
	 */
	public int getCountInvoiceVW(InvoiceInfoSearchCond cond,
			int start, int count) {
		List<InvoiceTj> ret = invoiceVWDAO.findByCond(cond,start,count);
		return ret.size();
	}

}

/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.task.InvoiceBL;
import com.csebank.lom.dto.IGLOM04DTO;
import com.csebank.lom.form.IGLOM0401Form;
import com.csebank.lom.model.Invoice;
import com.csebank.lom.model.InvoiceTj;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;

/**
 *  ��Ʊ����BLʵ��
 */
public class IGLOM04BLImpl extends BaseBLImpl implements IGLOM04BL {
	
	static Log log = LogFactory.getLog(IGLOM01BLImpl.class);
    
	/** ��Ʊ����BL */
	protected InvoiceBL invoiceBL;
	
	

	public InvoiceBL getInvoiceBL() {
		return invoiceBL;
	}
	public void setInvoiceBL(InvoiceBL invoiceBL) {
		this.invoiceBL = invoiceBL;
	}

	/**
	 * �Ӵ��Ǽ�����
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 */
	public IGLOM04DTO insertInvoiceAction(IGLOM04DTO dto) throws BLException {
		log.debug("========��Ʊ�ǼǴ���ʼ========");
		//����Formȡ��
		IGLOM0401Form form = dto.getIglom0401Form();
//		InvoiceTB itb = new InvoiceTB();
//		itb.setFingerPrint(form.getFingerprint());
//		itb.setIaccount(form.getIaccount());
//		itb.setIbank(form.getIbank());
//		itb.setIcomment(form.getIcomment());
//		itb.setIcontractname(form.getIcontractname());
//		itb.setIcontractserial(form.getIcontractserial());
//		itb.setIcorporation(form.getIcorporation());
//		itb.setIdate(form.getIdate());
//		itb.setIid(form.getIid());
//		itb.setInum(form.getInum());
//		itb.setIpaymentdate(form.getIpaymentdate());
//		itb.setIpaymenttype(form.getIpaymenttype());
//		itb.setIpaymenttypecode(form.getIpaymenttypecode());
//		itb.setIreqemp(form.getIreqempid());
//		itb.setIrequser(form.getIrequser());
//		itb.setIrequsername(form.getIrequsername());
//		itb.setIstatus(form.getIstatus());
//		itb.setItype(form.getItype());
		this.invoiceBL.registInvoice(dto.getInvoice());
	//	this.invoiceBL.registInvoice(itb);
		dto.setIglom0401Form(form);
				
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "��Ʊ����") );

		log.debug("========��Ʊ�ǼǴ�������========");
		return dto;
		
		
		
	}
   
	/**
	 * ��Ʊ��Ϣ��ѯ����
	 *
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 */
	public IGLOM04DTO searchInvoiceAction(IGLOM04DTO dto) throws BLException {
      log.debug("========��Ʊ��Ϣ��ѯ����ʼ========");
		
		//��Ʊ��Ϣ��ѯ����ȡ�� 
		int totalCount = this.invoiceBL.getSearchCount(dto.getInvoiceInfoSearchCond());
		
		if (totalCount == 0) {
			log.debug("========��Ʊ��Ϣ��ѯ���ݲ�����========");
			//�Ӵ�������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��Ʊ��Ϣ��ѯ���ݼ�������========");
			//�Ӵ�������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ��Ϣȡ��
		List<Invoice> invoiceList = this.invoiceBL.searchInvoiceAction(dto.getInvoiceInfoSearchCond(),pDto.getFromCount(), pDto.getPageDispCount());
    
		
		pDto.setTotalCount(totalCount);
		
		dto.setInvoiceList(invoiceList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========��Ʊ��Ϣ��ѯ��������========");
		return dto;
	}
    
	
	/**
	 * ��Ʊ��������
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 */
	public IGLOM04DTO updateInvoiceAction(IGLOM04DTO dto) throws BLException {
		invoiceBL.updateNotice(dto.getInvoice());
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "��Ʊ������Ϣ") );
		return dto;
	}
	
	

	/**
	 * <p>
	 * Description: ֪ͨɾ��
	 * </p>
	 * 
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 * @throws BLException
	 * @author piaowei@deliverik.com
	 * @update
	 */
	
	public IGLOM04DTO deleteNoticeAction(IGLOM04DTO dto) throws BLException {
		log.debug("========֪ͨɾ������ʼ========");
		//ѭ��ɾ��
		for( int i=0;i<dto.getDeleteNid().length;i++ ){
			//֪ͨɾ������
			String nid = dto.getDeleteNid()[i];

			invoiceBL.deleteNotice(new Integer(nid));
		}
		dto.addMessage(new ActionMessage("IGCO10000.I006", "֪ͨ������Ϣ"));
		log.debug("========֪ͨɾ����������========");
		return dto;
	}
   
	
	/**
	 * <p>
	 * Description: ֪ͨ�����ʼ��
	 * </p>
	 * 
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 * @throws BLException
	 * @author piaowei@deliverik.com
	 * @update
	 */
	
	public IGLOM04DTO initIGLOM0402Action(IGLOM04DTO dto) throws BLException {
		log.debug("========�����֪ͨ������Ϣ��ѯ����ʼ========");
		IGLOM0401Form form = dto.getIglom0401Form();
		Invoice invoice = invoiceBL.searchInvoiceByKey(form.getIid());
		if ( invoice == null ){
			throw new BLException("IGCO10000.E004","�������֪ͨ����");
		}
		 form.setFingerprint(invoice.getFingerPrint());
		 form.setIaccount(invoice.getIaccount());
		 form.setIamount(invoice.getIamount());
		 form.setIbank(invoice.getIbank());
		 form.setIcomment(invoice.getIcomment());
		 form.setIcontractname(invoice.getIcontractname());
		 form.setIcontractserial(invoice.getIcontractserial());
		 form.setIcorporation(invoice.getIcorporation());
		 form.setIdate(invoice.getIdate());
		 form.setIid(invoice.getIid());
		 form.setInum(invoice.getInum());
		 form.setIpaymentdate(invoice.getIpaymentdate());
		 form.setIpaymenttype(invoice.getIpaymenttype());
		 form.setIpaymenttypecode(invoice.getIpaymenttypecode());
		 
		 form.setIreqemp(invoice.getIreqemp());
		 form.setIreqempid(invoice.getOrganizationTB().getOrgname());
		 
		 form.setIrequser(invoice.getIrequser());
		 form.setIrequsername(invoice.getIrequsername());
		 form.setIstatus(invoice.getIstatus());
		 form.setItype(invoice.getItype());
	    
		
		//�����ʼ��ģʽ
		form.setMode("1");
		dto.addMessage(new ActionMessage("IGCO10000.I001","֪ͨ������Ϣ"));
		log.debug("========�����֪ͨ������Ϣ��ѯ��������========");
		return dto;
	}

	
	/**
	 * ��ѯstock����ָ����Ʒ����ϸ��Ϣ
	 */
	public IGLOM04DTO searchStockDetailAction(IGLOM04DTO dto) throws BLException {
		Invoice invoice = invoiceBL.searchInvoiceByKey(dto.getIglom0401Form().getIid());
		dto.setInvoice(invoice);
		return dto;
	}
    
	
	/**
	 * ��Ʊ����ͳ����Ϣ��ѯ����
	 *
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 */
	public IGLOM04DTO searchInvoiceVWAction(IGLOM04DTO dto) throws BLException {
		
		log.debug("========��Ʊ����ͳ����Ϣ��ѯ����ʼ========");
		
		//��Ʊ��Ϣ��ѯ����ȡ�� 
		int totalCount = this.invoiceBL.getCountInvoiceVW(dto.getInvoiceInfoSearchCond(),0,0);
		
		if (totalCount == 0) {
			log.debug("========��Ʊ��Ϣ��ѯ���ݲ�����========");
			//��Ʊ��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��Ʊ��Ϣ��ѯ���ݼ�������========");
			//��Ʊ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		//��ǰҳ��Ϣȡ��
		List<InvoiceTj> invoiceTjList = this.invoiceBL.searchInvoiceVW(dto.getInvoiceInfoSearchCond(),pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setInvoiceVWList(invoiceTjList);
		
		log.debug("========��Ʊ����ͳ����Ϣ��ѯ��������========");
		return dto;
	}
	/**
	 * ��Ʊ���ͳ����Ϣ��ѯ����
	 *
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 */
	public IGLOM04DTO searchInvoiceYearVWAction(IGLOM04DTO dto) throws BLException {

		log.debug("========��Ʊ���ͳ����Ϣ��ѯ����ʼ========");
		
		//��ǰҳ��Ϣȡ��
		List<InvoiceTj> invoiceTjList = this.invoiceBL.searchInvoiceVW(dto.getInvoiceInfoSearchCond(),0, 0);

		dto.setInvoiceVWList(invoiceTjList);
		
		log.debug("========��Ʊ���ͳ����Ϣ��ѯ��������========");
		return dto;
	}
}

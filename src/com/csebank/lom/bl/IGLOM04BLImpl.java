/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
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
 *  发票管理BL实现
 */
public class IGLOM04BLImpl extends BaseBLImpl implements IGLOM04BL {
	
	static Log log = LogFactory.getLog(IGLOM01BLImpl.class);
    
	/** 发票管理BL */
	protected InvoiceBL invoiceBL;
	
	

	public InvoiceBL getInvoiceBL() {
		return invoiceBL;
	}
	public void setInvoiceBL(InvoiceBL invoiceBL) {
		this.invoiceBL = invoiceBL;
	}

	/**
	 * 接待登记新增
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 */
	public IGLOM04DTO insertInvoiceAction(IGLOM04DTO dto) throws BLException {
		log.debug("========发票登记处理开始========");
		//输入Form取得
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
				
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "发票工作") );

		log.debug("========发票登记处理终了========");
		return dto;
		
		
		
	}
   
	/**
	 * 发票信息查询处理
	 *
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 */
	public IGLOM04DTO searchInvoiceAction(IGLOM04DTO dto) throws BLException {
      log.debug("========发票信息查询处理开始========");
		
		//发票信息查询件数取得 
		int totalCount = this.invoiceBL.getSearchCount(dto.getInvoiceInfoSearchCond());
		
		if (totalCount == 0) {
			log.debug("========发票信息查询数据不存在========");
			//接待工作信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========发票信息查询数据件数过多========");
			//接待工作信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页信息取得
		List<Invoice> invoiceList = this.invoiceBL.searchInvoiceAction(dto.getInvoiceInfoSearchCond(),pDto.getFromCount(), pDto.getPageDispCount());
    
		
		pDto.setTotalCount(totalCount);
		
		dto.setInvoiceList(invoiceList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========发票信息查询处理终了========");
		return dto;
	}
    
	
	/**
	 * 发票工作更新
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 */
	public IGLOM04DTO updateInvoiceAction(IGLOM04DTO dto) throws BLException {
		invoiceBL.updateNotice(dto.getInvoice());
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "发票基本信息") );
		return dto;
	}
	
	

	/**
	 * <p>
	 * Description: 通知删除
	 * </p>
	 * 
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 * @throws BLException
	 * @author piaowei@deliverik.com
	 * @update
	 */
	
	public IGLOM04DTO deleteNoticeAction(IGLOM04DTO dto) throws BLException {
		log.debug("========通知删除处理开始========");
		//循环删除
		for( int i=0;i<dto.getDeleteNid().length;i++ ){
			//通知删除主键
			String nid = dto.getDeleteNid()[i];

			invoiceBL.deleteNotice(new Integer(nid));
		}
		dto.addMessage(new ActionMessage("IGCO10000.I006", "通知基本信息"));
		log.debug("========通知删除处理终了========");
		return dto;
	}
   
	
	/**
	 * <p>
	 * Description: 通知变更初始化
	 * </p>
	 * 
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 * @throws BLException
	 * @author piaowei@deliverik.com
	 * @update
	 */
	
	public IGLOM04DTO initIGLOM0402Action(IGLOM04DTO dto) throws BLException {
		log.debug("========变更用通知基本信息查询处理开始========");
		IGLOM0401Form form = dto.getIglom0401Form();
		Invoice invoice = invoiceBL.searchInvoiceByKey(form.getIid());
		if ( invoice == null ){
			throw new BLException("IGCO10000.E004","变更对象通知基本");
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
	    
		
		//变更初始化模式
		form.setMode("1");
		dto.addMessage(new ActionMessage("IGCO10000.I001","通知基本信息"));
		log.debug("========变更用通知基本信息查询处理终了========");
		return dto;
	}

	
	/**
	 * 查询stock表中指定物品的详细信息
	 */
	public IGLOM04DTO searchStockDetailAction(IGLOM04DTO dto) throws BLException {
		Invoice invoice = invoiceBL.searchInvoiceByKey(dto.getIglom0401Form().getIid());
		dto.setInvoice(invoice);
		return dto;
	}
    
	
	/**
	 * 发票部门统计信息查询处理
	 *
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 */
	public IGLOM04DTO searchInvoiceVWAction(IGLOM04DTO dto) throws BLException {
		
		log.debug("========发票部门统计信息查询处理开始========");
		
		//发票信息查询件数取得 
		int totalCount = this.invoiceBL.getCountInvoiceVW(dto.getInvoiceInfoSearchCond(),0,0);
		
		if (totalCount == 0) {
			log.debug("========发票信息查询数据不存在========");
			//发票信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========发票信息查询数据件数过多========");
			//发票信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		
		//当前页信息取得
		List<InvoiceTj> invoiceTjList = this.invoiceBL.searchInvoiceVW(dto.getInvoiceInfoSearchCond(),pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setInvoiceVWList(invoiceTjList);
		
		log.debug("========发票部门统计信息查询处理终了========");
		return dto;
	}
	/**
	 * 发票年度统计信息查询处理
	 *
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 */
	public IGLOM04DTO searchInvoiceYearVWAction(IGLOM04DTO dto) throws BLException {

		log.debug("========发票年度统计信息查询处理开始========");
		
		//当前页信息取得
		List<InvoiceTj> invoiceTjList = this.invoiceBL.searchInvoiceVW(dto.getInvoiceInfoSearchCond(),0, 0);

		dto.setInvoiceVWList(invoiceTjList);
		
		log.debug("========发票年度统计信息查询处理终了========");
		return dto;
	}
}

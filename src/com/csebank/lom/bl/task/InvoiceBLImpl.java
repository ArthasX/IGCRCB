/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
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
 * 接待管理业务逻辑接口实现
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
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(InvoiceInfoSearchCond cond) {
		return InvoiceDAO.getSearchCount(cond);
		
	}
   
	/**
	 * 登录处理
	 * 
	 * @param recption 登录数据
	 * @return 发票信息
	 */
	public Invoice registInvoice(Invoice invoice) throws BLException {
		
		return InvoiceDAO.save(invoice);
	}
   
	/**
	 * <p>
	 * Description: 发票查询
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
	 * Description: 删除通知
	 * </p>
	 */
	
	public void deleteNotice(Integer nid) throws BLException {
		Invoice invoice = checkExistInvoice(nid);
		InvoiceDAO.delete(invoice);
	}
	
	/**
	 * <p>
	 * Description: 查询是否存在该主键ID的通知
	 * </p>
	 */
	protected Invoice checkExistInvoice(Integer nid) throws BLException{
		Invoice info = InvoiceDAO.findByPK(nid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","发票基本");
		}
		
		return info;
	}
   
	/**
	 * <p>
	 * Description: 通过主键查询相应记录
	 * </p>
	 */
	
	public Invoice searchInvoiceByKey(Integer iid) {
		Invoice ret = InvoiceDAO.findByPK(iid);
		return ret;
	}
	
	/**
	 * <p>
	 * Description: 更新通知
	 * </p>
	 */
	
	public Invoice updateNotice(Invoice invoice) throws BLException {
		checkExistInvoice(invoice.getIid());
		Invoice ret = InvoiceDAO.save(invoice);
		return ret;
	}
	
	/**
	 * <p>
	 * Description: 发票部门统计信息查询
	 * </p>
	 */
	public List<InvoiceTj> searchInvoiceVW(InvoiceInfoSearchCond cond,
			int start, int count) {
		List<InvoiceTj> ret = invoiceVWDAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * <p>
	 * Description: 发票部门统计信息数量查询
	 * </p>
	 */
	public int getCountInvoiceVW(InvoiceInfoSearchCond cond,
			int start, int count) {
		List<InvoiceTj> ret = invoiceVWDAO.findByCond(cond,start,count);
		return ret.size();
	}

}

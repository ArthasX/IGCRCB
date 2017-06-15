/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Invoice;
import com.csebank.lom.model.InvoiceTj;
import com.csebank.lom.model.condition.InvoiceInfoSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 发票管理业务逻辑接口
 */
public interface InvoiceBL extends BaseBL {

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(InvoiceInfoSearchCond cond);

	/**
	 * 登录处理
	 * 
	 * @param Recption 登录数据
	 * @return 发票检查项信息
	 */
	public Invoice registInvoice(Invoice invoice) throws BLException;

	/**
	 * 查询处理
	 * 
	 * @param Invoice 查询数据
	 * @return 发票检查项信息
	 */
	public List<Invoice> searchInvoiceAction(InvoiceInfoSearchCond cond, int start, int count) throws BLException;
	
	/**
	 * 删除处理
	 * Description: 删除通知
	 * </p>
	 */
	
	public void deleteNotice(Integer nid) throws BLException;
	
	/**
	 * <p>
	 * Description: 通过主键查询相应记录
	 * </p>
	 */
	
	public Invoice searchInvoiceByKey(Integer iid);
	
	/**
	 * <p>
	 * Description: 发票变更
	 * </p>
	 */
	
	public Invoice updateNotice(Invoice invoice) throws BLException;
	
	/**
	 * <p>
	 * Description: 发票部门统计查询
	 * </p>
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return List<ChangeKpi>
	 * @author piaowei@deliverik.com
	 */
	public List<InvoiceTj> searchInvoiceVW(InvoiceInfoSearchCond cond,int start, int count);
	/**
	 * <p>
	 * Description: 发票部门统计件数取得
	 * </p>
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return int
	 * @author piaowei@deliverik.com
	 */
	public int getCountInvoiceVW(InvoiceInfoSearchCond cond,int start, int count);
	
	
}

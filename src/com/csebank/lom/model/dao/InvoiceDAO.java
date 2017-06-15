/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Invoice;
import com.csebank.lom.model.condition.InvoiceInfoSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 发票DAO接口
 * @author lipeng@deliverik.com
 */
public interface InvoiceDAO extends BaseHibernateDAO<Invoice> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<Invoice> findAll();

	/**
	 * 主键检索处理
	 * @param raid 主键
	 * @return 检索结果
	 */
	public Invoice findByPK(Serializable iid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final InvoiceInfoSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Invoice> findByCond(final InvoiceInfoSearchCond cond, final int start, final int count);
	
	/**
	 * 获取当前最大版本根标识
	 * @return 最大版本根标识
	 */
	
	public String getMaxRacode();
	

}

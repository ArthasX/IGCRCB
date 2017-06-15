package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.InvoiceTj;
import com.csebank.lom.model.condition.InvoiceInfoSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;



public interface InvoiceVWDAO extends BaseHibernateDAO<InvoiceTj> {

	public List<InvoiceTj> findByCond(final InvoiceInfoSearchCond cond,
			final int start, final int count);

}

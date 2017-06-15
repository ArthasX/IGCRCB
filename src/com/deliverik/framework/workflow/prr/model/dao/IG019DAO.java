package com.deliverik.framework.workflow.prr.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG019Info;
import com.deliverik.framework.workflow.prr.model.condition.IG019SearchCond;

/**
 * 
 */
public interface IG019DAO extends
		BaseHibernateDAO<IG019Info> {

	public List<IG019Info> findByCond(
			final IG019SearchCond cond, final int start,
			final int count);

	public int getSearchCount(final IG019SearchCond cond);

}

package com.deliverik.infogovernor.scheduling.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessRecord;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessRecordSearchCond;

public interface QuartzProcessRecordTBDAO extends BaseHibernateDAO<QuartzProcessRecord> {

	public List<QuartzProcessRecord> findAll();
	
	public int getSearchCount(final QuartzProcessRecordSearchCond cond);

	public QuartzProcessRecord findByPK(Serializable qprid);

	public List<QuartzProcessRecord> findByCond(final QuartzProcessRecordSearchCond cond, final int start, final int count);

}

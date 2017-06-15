package com.deliverik.infogovernor.scheduling.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfo;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessInfoSearchCond;

public interface QuartzProcessInfoTBDAO extends BaseHibernateDAO<QuartzProcessInfo> {

	public List<QuartzProcessInfo> findAll();

	public QuartzProcessInfo findByPK(Serializable qpiid);

	public List<QuartzProcessInfo> findByCond(final QuartzProcessInfoSearchCond cond, final int start, final int count);

}

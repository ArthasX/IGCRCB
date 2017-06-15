package com.deliverik.infogovernor.sdl.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sdl.model.ChangeKpi;
import com.deliverik.infogovernor.sdl.model.condition.ChangeKpiSearchCond;

public interface ChangeKpiVWDAO extends BaseHibernateDAO<ChangeKpi> {

	public List<ChangeKpi> findByCond(final ChangeKpiSearchCond cond,
			final int start, final int count);

}

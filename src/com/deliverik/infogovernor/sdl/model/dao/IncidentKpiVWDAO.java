package com.deliverik.infogovernor.sdl.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sdl.model.IncidentKpi;
import com.deliverik.infogovernor.sdl.model.condition.IncidentKpiSearchCond;

public interface IncidentKpiVWDAO extends BaseHibernateDAO<IncidentKpi> {

	public List<IncidentKpi> findByCond(final IncidentKpiSearchCond cond,
			final int start, final int count);

}

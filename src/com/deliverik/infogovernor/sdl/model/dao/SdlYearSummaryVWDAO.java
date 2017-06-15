package com.deliverik.infogovernor.sdl.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sdl.model.SdlYearSummary;
import com.deliverik.infogovernor.sdl.model.condition.SdlYearSummarySearchCond;


public interface SdlYearSummaryVWDAO extends BaseHibernateDAO<SdlYearSummary> {

	public List<SdlYearSummary> findByCond(final SdlYearSummarySearchCond cond, final int start, final int count);

}

package com.deliverik.infogovernor.sdl.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sdl.model.SdlSummary;
import com.deliverik.infogovernor.sdl.model.condition.SdlSummarySearchCond;


public interface SdlSummaryVWDAO extends BaseHibernateDAO<SdlSummary> {

	public List<SdlSummary> findByCond(final SdlSummarySearchCond cond, final int start, final int count);

}

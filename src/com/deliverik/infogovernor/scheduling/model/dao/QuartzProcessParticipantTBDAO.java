package com.deliverik.infogovernor.scheduling.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessParticipant;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessParticipantSearchCond;

public interface QuartzProcessParticipantTBDAO extends BaseHibernateDAO<QuartzProcessParticipant> {

	public List<QuartzProcessParticipant> findAll();

	public QuartzProcessParticipant findByPK(Serializable qppid);

	public List<QuartzProcessParticipant> findByCond(final QuartzProcessParticipantSearchCond cond, final int start, final int count);
	
	public int getCountByCond(final QuartzProcessParticipantSearchCond cond);

}

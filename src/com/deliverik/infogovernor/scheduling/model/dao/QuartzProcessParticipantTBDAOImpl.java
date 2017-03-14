package com.deliverik.infogovernor.scheduling.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessParticipant;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessParticipantSearchCond;
import com.deliverik.infogovernor.scheduling.model.entity.QuartzProcessParticipantTB;

@SuppressWarnings("deprecation")
public class QuartzProcessParticipantTBDAOImpl extends
		BaseHibernateDAOImpl<QuartzProcessParticipant> implements
		QuartzProcessParticipantTBDAO {

	public QuartzProcessParticipantTBDAOImpl() {
		super(QuartzProcessParticipantTB.class);
	}

	public List<QuartzProcessParticipant> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("qppid"));
		List<QuartzProcessParticipant> ret = findByCriteria(c);

		return ret;
	}

	public QuartzProcessParticipant findByPK(Serializable qppid) {
		QuartzProcessParticipant qpp = super.findByPK(qppid);
		if (qpp == null)
			return null;
		return qpp;
	}

	public List<QuartzProcessParticipant> findByCond(
			final QuartzProcessParticipantSearchCond cond, final int start,
			final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("qppid"));
		List<QuartzProcessParticipant> ret = findByCriteria(c, start, count);
		return ret;
	}

	public int getCountByCond(final QuartzProcessParticipantSearchCond cond) {
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	protected DetachedCriteria getCriteria(QuartzProcessParticipantSearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		if (cond.getQprid() != null && cond.getQprid() != 0) {
			c.add(Expression.eq("qprid", cond.getQprid()));
		}
		if (cond.getQpproleid() != null && cond.getQpproleid() != 0) {
			c.add(Expression.eq("qpproleid", cond.getQpproleid()));
		}
		if (!StringUtils.isEmpty(cond.getQppuserid())) {
			c.add(Expression.eq("qppuserid", cond.getQppuserid()));
		}
		if (!StringUtils.isEmpty(cond.getQppinittime())) {
			c.add(Expression.eq("qppinittime", cond.getQppinittime()));
		}
		if (!StringUtils.isEmpty(cond.getQppproctime())) {
			c.add(Expression.eq("qppproctime", cond.getQppproctime()));
		}
		if (!StringUtils.isEmpty(cond.getQppuserid())) {
			c.add(Expression.eq("qppuserid", cond.getQppuserid()));
		}
		if (!StringUtils.isEmpty(cond.getQppstatus())) {
			if ("I".equals(cond.getQppstatus())) {
				c.add(Expression.or(Expression.eq("qppstatus", "I"), Expression.eq("qppstatus", "D")));
			} else {
				c.add(Expression.eq("qppstatus", cond.getQppstatus()));
			}
		}
		if (cond.getQppuseridIsNull() != null && cond.getQppuseridIsNull().equals("Y")) {
			c.add(Expression.isNull("qppuserid"));
		}
		if (cond.getQppuseridIsNull() != null && cond.getQppuseridIsNull().equals("N")) {
			c.add(Expression.isNotNull("qppuserid"));
		}
		if (cond.getQppproctimeIsNull() != null && cond.getQppproctimeIsNull().equals("Y")) {
			c.add(Expression.isNull("qppproctime"));
		}
		if (cond.getQppproctimeIsNull() != null && cond.getQppproctimeIsNull().equals("N")) {
			c.add(Expression.isNotNull("qppproctime"));
		}
		return c;
	}

}

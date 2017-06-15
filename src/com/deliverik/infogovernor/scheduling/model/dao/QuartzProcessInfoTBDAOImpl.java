package com.deliverik.infogovernor.scheduling.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfo;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessInfoSearchCond;
import com.deliverik.infogovernor.scheduling.model.entity.QuartzProcessInfoTB;

@SuppressWarnings("deprecation")
public class QuartzProcessInfoTBDAOImpl extends BaseHibernateDAOImpl<QuartzProcessInfo> implements QuartzProcessInfoTBDAO {

	public QuartzProcessInfoTBDAOImpl(){
		super(QuartzProcessInfoTB.class);
	}

	public List<QuartzProcessInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("qpiid"));
		List<QuartzProcessInfo> ret = findByCriteria(c);
		return ret;
	}

	public QuartzProcessInfo findByPK(Serializable qpiid) {
		QuartzProcessInfo qrl = super.findByPK(qpiid);
		if(qrl == null) 
			return null;
		return qrl;
	}

	public List<QuartzProcessInfo> findByCond(final QuartzProcessInfoSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("qpiid"));
		List<QuartzProcessInfo> ret = findByCriteria(c, start, count);
		return ret;
	}

	protected DetachedCriteria getCriteria(QuartzProcessInfoSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getQprid() != null && cond.getQprid() != 0){
			c.add(Expression.eq("qprid", cond.getQprid()));
		}
		if(!StringUtils.isEmpty(cond.getQpivarname())){
			c.add(Expression.eq("qpivarname", cond.getQpivarname()));
		}
		return c;
	}

}
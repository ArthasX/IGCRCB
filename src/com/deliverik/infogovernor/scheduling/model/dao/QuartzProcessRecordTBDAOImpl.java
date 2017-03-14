package com.deliverik.infogovernor.scheduling.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessRecord;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessRecordSearchCond;
import com.deliverik.infogovernor.scheduling.model.entity.QuartzProcessRecordTB;

@SuppressWarnings("deprecation")
public class QuartzProcessRecordTBDAOImpl extends BaseHibernateDAOImpl<QuartzProcessRecord> implements QuartzProcessRecordTBDAO {

	public QuartzProcessRecordTBDAOImpl(){
		super(QuartzProcessRecordTB.class);
	}
	
	public List<QuartzProcessRecord> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("prid"));
		List<QuartzProcessRecord> ret = findByCriteria(c);
		return ret;
	}

	public QuartzProcessRecord findByPK(Serializable qprid) {

		QuartzProcessRecord qpr = super.findByPK(qprid);
		if(qpr == null) 
			return null;
		return qpr;
	}

	public List<QuartzProcessRecord> findByCond(final QuartzProcessRecordSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("qprid"));
		List<QuartzProcessRecord> ret = findByCriteria(c, start, count);
		return ret;
	}

	protected DetachedCriteria getCriteria(QuartzProcessRecordSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if( !StringUtils.isEmpty(cond.getQprtitle())){
			c.add(Expression.like("prtitle", "%"+cond.getQprtitle()+"%"));
		}
		if( !StringUtils.isEmpty(cond.getQprtype())){
			c.add(Expression.eq("prtype", cond.getQprtype()));
		}
		if( !StringUtils.isEmpty(cond.getQprstatus())){
			c.add(Expression.eq("prstatus", cond.getQprstatus()));
		}
		if( !StringUtils.isEmpty(cond.getQpcode())){
			c.add(Expression.eq("pcode", cond.getQpcode()));
		}
		if( !StringUtils.isEmpty(cond.getQprusername())){
			c.add(Expression.eq("prusername", cond.getQprusername()));
		}
		if( cond.getQprid()!=null && cond.getQprid()!=0){
			c.add(Expression.eq("prid", cond.getQprid()));
		}
		
		if( !StringUtils.isEmpty(cond.getQprurgency())){
			c.add(Expression.eq("prurgency", cond.getQprurgency()));
		}
		
		if( !StringUtils.isEmpty(cond.getQpropentime())){
			c.add(Expression.ge("propentime", cond.getQpropentime()));
		}
		
		if( !StringUtils.isEmpty(cond.getQprclosetime())){
			c.add(Expression.le("propentime", cond.getQprclosetime()));
		}
		return c;
	}
	
	public int getSearchCount(final QuartzProcessRecordSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

}

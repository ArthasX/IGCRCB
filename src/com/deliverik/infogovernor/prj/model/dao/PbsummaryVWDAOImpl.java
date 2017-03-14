/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prj.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;

import org.hibernate.criterion.Expression;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.prj.model.Pbsummary;
import com.deliverik.infogovernor.prj.model.condition.PbsummaryVWSearchCond;
import com.deliverik.infogovernor.prj.model.entity.PbsummaryVW;


/**
 * <p>����:Ԥ�㼰���̷�����Ϣ��ͼDAOʵ��</p>
 * <p>����������1.������������</p>
 * <p>������¼��</p>
 */

@SuppressWarnings("deprecation")
public class PbsummaryVWDAOImpl extends BaseHibernateDAOImpl<Pbsummary> implements PbsummaryVWDAO{
	/**
	 * Ԥ�㼰���̷�����Ϣ��ͼ���캯��
	 * 
	 */
	public PbsummaryVWDAOImpl(){
		super(PbsummaryVW.class);
	}
	
	public List<Pbsummary> findByCond(final PbsummaryVWSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		List<Pbsummary> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	protected DetachedCriteria getCriteria(PbsummaryVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getPid()!=null){
			c.add(Expression.eq("pid", cond.getPid()));
		}
		if(cond.getPbid()!=null){
			c.add(Expression.eq("pbid", cond.getPbid()));
		}
		if(cond.getBid()!=null){
			c.add(Expression.eq("bid", cond.getBid()));
		}
		if( !StringUtils.isEmpty(cond.getByear_begin())){
			c.add(Expression.ge("byear", cond.getByear_begin()));
		}
		if( !StringUtils.isEmpty(cond.getByear_end())){
			c.add(Expression.le("byear", cond.getByear_end()));
		}
		return c;
	}
}

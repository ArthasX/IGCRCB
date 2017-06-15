/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.sym.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sym.model.SMSLog;
import com.deliverik.infogovernor.sym.model.condition.SMSLogSearchCond;
import com.deliverik.infogovernor.sym.model.entity.SMSLogTB;

/**
 * ����:��Ϣ��¼DAOʵ����
 * ����������1. ȫ������
 * 			2.���������������ȡ��
 * 			3.������������
 * ������¼��zhaojun@deliverik.com    2010/12/20
 */
@SuppressWarnings("deprecation")
public class SMSLogDAOImpl extends BaseHibernateDAOImpl<SMSLog> implements SMSLogDAO {

	/**
	 * ���캯��
	 */
	public SMSLogDAOImpl(){
		super(SMSLogTB.class);
	}
	
	public List<SMSLog> findAll(){
		DetachedCriteria c = getDetachedCriteria();
		List<SMSLog> ret = findByCriteria(c);
		return ret;
	}

	public List<SMSLog> findByCond(final SMSLogSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("sid"));
		List<SMSLog> ret = findByCriteria(c, start, count);
		return ret;
	}

	public int getSearchCount(final SMSLogSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
	
	protected DetachedCriteria getCriteria(SMSLogSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if(StringUtils.isNotEmpty(cond.getSendstatus())){
			c.add(Expression.eq("sendstatus",cond.getSendstatus()));
		}
		if(cond.getGt_sendcount() != null && cond.getGt_sendcount() !=0){
			c.add(Expression.gt("sendcount", cond.getGt_sendcount()));
		}
		if(cond.getLt_sendcount() !=null && cond.getLt_sendcount() !=0){
			c.add(Expression.lt("sendcount", cond.getLt_sendcount()));
		}
		if( !StringUtils.isEmpty(cond.getS_ctime())){
			c.add(Expression.ge("ctime", cond.getS_ctime()));
		}
		if( !StringUtils.isEmpty(cond.getE_ctime())){
			c.add(Expression.lt("ctime", cond.getE_ctime()));
		}
		
		if( !StringUtils.isEmpty(cond.getS_utime())){
			c.add(Expression.ge("utime", cond.getS_utime()));
		}
		if( !StringUtils.isEmpty(cond.getE_utime())){
			c.add(Expression.lt("utime", cond.getE_utime()));
		}
		return c;
	}

}

/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0112Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0112SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0112TB;

/**
  * ����: �ʲ�����ϸ��DAOʵ��
  * ��������: �ʲ�����ϸ��DAOʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class SOC0112DAOImpl extends
		BaseHibernateDAOImpl<SOC0112Info> implements SOC0112DAO {

	/**
	 * ���캯��
	 */
	public SOC0112DAOImpl(){
		super(SOC0112TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0112Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0112Info findByPK(Serializable pk) {
		SOC0112Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0112SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0112Info> findByCond(final SOC0112SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0112Info> findBySQL(final SOC0112SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback(){

			
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				StringBuffer query  = new StringBuffer();
				query.append(session.getNamedQuery("EiDomainDetailDAO.findBySQL").getQueryString());
				getSQL(cond, query);				
				SQLQuery q = session.createSQLQuery(query.toString());	
				q.addEntity("ei",SOC0112TB.class);
				List<SOC0112TB> list = q.list();
				return list;
			}		
		};
		return (List<SOC0112Info>)execute(action);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0112SearchCond cond){
		
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getEiddid()!=null && cond.getEiddid()!=0){			
			c.add(Expression.eq("eiddid", cond.getEiddid()));
		}
	    if(cond.getEiddversion()!=null){
	    	c.add(Expression.eq("eiddversion", cond.getEiddversion()));			
		}
	    if(cond.getDeleteflag()!=null){
	    	c.add(Expression.eq("deleteflag", cond.getDeleteflag()));			
		}
		return c;
	}
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL(SOC0112SearchCond cond, StringBuffer query){
		
		if(cond.getEiddid()!=null && cond.getEiddid()!=0){			
			query.append(" and ei.eiddid = "+cond.getEiddid());
		}
	    if(cond.getEiddversion()!=null){
	    	query.append(" and ei.eiddversion = "+cond.getEiddversion());		
		}
	    if(cond.getDeleteflag()!=null){
	    	query.append(" and ei.deleteflag = '"+cond.getDeleteflag()+"'");			
		}
	}

}
/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.model.EiDomainDetailInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDetailSearchCond;
import com.deliverik.framework.asset.model.entity.EiDomainDetailTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * ����: �ʲ�����ϸ��DAOʵ��
  * ��������: �ʲ�����ϸ��DAOʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class EiDomainDetailDAOImpl extends
		BaseHibernateDAOImpl<EiDomainDetailInfo> implements EiDomainDetailDAO {

	/**
	 * ���캯��
	 */
	public EiDomainDetailDAOImpl(){
		super(EiDomainDetailTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiDomainDetailInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EiDomainDetailInfo findByPK(Serializable pk) {
		EiDomainDetailInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EiDomainDetailSearchCond cond){
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
	public List<EiDomainDetailInfo> findByCond(final EiDomainDetailSearchCond cond, final int start, final int count){
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
	public List<EiDomainDetailInfo> findBySQL(final EiDomainDetailSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback(){

			
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				StringBuffer query  = new StringBuffer();
				query.append(session.getNamedQuery("EiDomainDetailDAO.findBySQL").getQueryString());
				getSQL(cond, query);				
				SQLQuery q = session.createSQLQuery(query.toString());	
				q.addEntity("ei",EiDomainDetailTB.class);
				List<EiDomainDetailTB> list = q.list();
				session.clear();
				session.close();
				return list;
			}		
		};
		return (List<EiDomainDetailInfo>)execute(action);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(EiDomainDetailSearchCond cond){
		
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
	protected void getSQL(EiDomainDetailSearchCond cond, StringBuffer query){
		
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
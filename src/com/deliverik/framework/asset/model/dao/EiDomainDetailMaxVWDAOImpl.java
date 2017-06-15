/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.EiDomainDetailCI;
import com.deliverik.framework.asset.EiDomainDetailCIInfo;
import com.deliverik.framework.asset.model.EiDomainDetailMaxVWInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDetailMaxVWSearchCond;
import com.deliverik.framework.asset.model.entity.EiDomainDetailMaxVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * ����: �ʲ�����ϸ��DAOʵ��
 * ��������: �ʲ�����ϸ��DAOʵ��
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public class EiDomainDetailMaxVWDAOImpl extends
BaseHibernateDAOImpl<EiDomainDetailMaxVWInfo> implements EiDomainDetailMaxVWDAO {
	
	/**
	 * ���캯��
	 */
	public EiDomainDetailMaxVWDAOImpl(){
		super(EiDomainDetailMaxVW.class);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EiDomainDetailMaxVWSearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
					if("1".equals(cond.getTypeId())){
					query.append(session.getNamedQuery(
							"EiDomainDefVWDAO.getSearchCount").getQueryString());
					}
					if("2".equals(cond.getTypeId())){
						query.append(session.getNamedQuery("EiDomainDefVWDAO.getSearchCountAll").getQueryString());
					}
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				session.clear();
				session.close();
				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EiDomainDetailMaxVWInfo> findByCond(final EiDomainDetailMaxVWSearchCond cond, final int start, final int count){
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
	public List<EiDomainDetailMaxVWInfo> findBySQL(final EiDomainDetailMaxVWSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				StringBuffer query  = new StringBuffer();
					if("1".equals(cond.getTypeId())){
					query.append(session.getNamedQuery("EiDomainDetailVWDAO.findBySQL").getQueryString());
					}
					if("2".equals(cond.getTypeId())){
						query.append(session.getNamedQuery("EiDomainDetailVWDAO.findBySQLAll").getQueryString());
					}
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("e",EiDomainDetailMaxVW.class);
				setFetchPoint(q, start, count);
				List<EiDomainDetailMaxVW> list = q.list();
				session.clear();
				session.close();
				return list;
			}		
		};
		return (List<EiDomainDetailMaxVWInfo>)execute(action);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(EiDomainDetailMaxVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL(EiDomainDetailMaxVWSearchCond cond, StringBuffer query){
		if(StringUtils.isNotEmpty(cond.getEiddid())){
			query.append(" AND ei.eiddid ="+Integer.parseInt(cond.getEiddid()));
		}
		if(StringUtils.isNotEmpty(cond.getEiname())){
			query.append(" AND ei.einame ='"+cond.getEiname()+"'");
		}
		query.append(" ) e");
//		if(cond.getEiddversion()!=null){
//			query.append(" AND ei.eiddversion ="+cond.getEiddversion());
//		}
	}

	/**
	 * ����Ӱ��CI��ѯ
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<EiDomainDetailCIInfo> findBySQLCI(
			final EiDomainDetailMaxVWSearchCond cond, final int start, final int count) {
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				StringBuffer query  = new StringBuffer();
					query.append(session.getNamedQuery("EiDomainDefVWDAO.findBySQLHead").getQueryString());
				getSQLCI(cond, query);
				query.append(session.getNamedQuery(
				"EiDomainDefVWDAO.sqlEnd").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("e",EiDomainDetailCI.class);
				setFetchPoint(q, start, count);
				List<EiDomainDetailCI> list = q.list();
				session.clear();
				session.close();
				return list;
			}		
		};
		return (List<EiDomainDetailCIInfo>)execute(action);
	}

	
	/**
	 * ����Ӱ��CI��ѯ����
	 * @param cond
	 * @return
	 */
	public int getSearchCountCI(final EiDomainDetailMaxVWSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery(
							"EiDomainDefVWDAO.getSearchCountHead").getQueryString());
				getSQLCI(cond, query);
				query.append(session.getNamedQuery(
				"EiDomainDefVWDAO.sqlEnd").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				session.clear();
				session.close();
				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	}
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQLCI(EiDomainDetailMaxVWSearchCond cond, StringBuffer query){
		if(StringUtils.isNotEmpty(cond.getEiid())){
			query.append(" AND p.eiid ="+Integer.parseInt(cond.getEiid())+" ");
		}
		if(StringUtils.isNotEmpty(cond.getEiddid())){
			query.append(" AND p.domainid = "+Integer.parseInt(cond.getEiddid())+" ");
		}
	}


}

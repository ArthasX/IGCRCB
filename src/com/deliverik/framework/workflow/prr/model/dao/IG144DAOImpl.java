/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG019SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;

/**
 * <p>����:�¼��ͷ����������̻�����ͼDAOʵ��</p>
 * <p>����������1.�¼�������������</p>
 * <p>         2.��������������������</p>
 * <p>          3.�¼�������������</p>
 * <p>          4.��������������������</p>
 * <p>          5.�������������������</p>
 * <p>          6.�¼�������������</p>
 * <p>������¼��</p>
 */
public class IG144DAOImpl extends
		BaseHibernateDAOImpl<IG500Info> implements
		IG144DAO {

	/**
	 * �¼��ͷ����������̻�����ͼ���캯��
	 * 
	 */
	public IG144DAOImpl() {
		super(IG500TB.class);
	}
	/**
	 * ���ܣ��¼�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public int getIncidentSearchCount(final IG019SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query
				.append(session
						.getNamedQuery(
								"IncidentServiceRequestListVWDAO.incidentListQuery")
								.getQueryString());
				getIncidentSQL(cond, query);
				query
				.append(" ORDER BY prclosetime DESC,propentime ASC");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("prcount",IG500TB.class);
				setFetchPoint(q, 0, 0);
				List<IG500Info> list = q.list();
				session.clear();
				return list.size();
			}
		};
		return (Integer) execute(action);
	}
	/**
	 * ���ܣ���������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public int getServiceRequestSearchCount(final IG019SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query
						.append(session
								.getNamedQuery(
										"IncidentServiceRequestListVWDAO.serviceRequestListQuery")
								.getQueryString());
				getServiceRequestSQL(cond, query);
				query
						.append(" ORDER BY prclosetime DESC,propentime ASC");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("prcount",IG500TB.class);
				setFetchPoint(q, 0, 0);
				List<IG500Info> list = q.list();
				session.clear();
				return list.size();
			}
		};
		return (Integer) execute(action);
	}

	/**
	 * ���ܣ��¼�������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<IG500Info> findIncidentByCond(
			final IG019SearchCond cond, final int start,
			final int count) {
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session)
			throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query
				.append(session
						.getNamedQuery(
								"IncidentServiceRequestListVWDAO.incidentListQuery")
								.getQueryString());
				getIncidentSQL(cond, query);
				query
				.append(" ORDER BY prclosetime DESC,propentime ASC");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("prcount", IG500TB.class);
				setFetchPoint(q, start, count);
				List<IG500Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG500Info>) execute(action);
	}
	
	/**
	 * ���ܣ���������������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<IG500Info> findServiceRequestByCond(
			final IG019SearchCond cond, final int start,
			final int count) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query
						.append(session
								.getNamedQuery(
										"IncidentServiceRequestListVWDAO.serviceRequestListQuery")
								.getQueryString());
				getServiceRequestSQL(cond, query);
				query
						.append(" AND PRSTATUS <>'D' "+ " ORDER BY prclosetime DESC,propentime ASC");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("prcount", IG500TB.class);
				setFetchPoint(q, start, count);
				List<IG500Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG500Info>) execute(action);
	}

	/**
	 * ���ܣ��������������������
	 * 
	 * @param cond ��������
	 * @param query sql
	 */
	protected void getServiceRequestSQL(
			IG019SearchCond cond, StringBuffer query) {
		// ���������
		if (StringUtils.isNotEmpty(cond.getOrgsyscoding())) {
			query.append(" AND prorgid like :orgsyscoding");
		}
		// ���
		if (StringUtils.isNotEmpty(cond.getYear())) {
			query.append(" AND substr(propentime,1,4) =:year");
		}
		// ����
		if (StringUtils.isNotEmpty(cond.getPrtype())) {
			query.append(" AND prtype = :prtype");
		}
		//��������id
        if(StringUtils.isNotEmpty(cond.getSpdid())){
            query.append(" AND prpdid like ('%'||:spdid||'%')");
        }
	}

	/**
	 * ���ܣ��¼�������������
	 * 
	 * @param cond ��������
	 * @param query
	 */
	protected void getIncidentSQL(IG019SearchCond cond,
			StringBuffer query) {
		// ���������
		if (StringUtils.isNotEmpty(cond.getOrgsyscoding())) {
			query.append(" AND c.orgsyscoding like :orgsyscoding");
		}
		// ���
		if (StringUtils.isNotEmpty(cond.getYear())) {
			query.append(" AND substr(prplantime,1,4) =:year");
		}
		// ����
		if (StringUtils.isNotEmpty(cond.getPrtype())) {
			query.append(" AND prtype = :prtype");
		}
		// ����
		if (StringUtils.isNotEmpty(cond.getPrtype())) {
		    query.append(" AND prtype = :prtype");
		}
	}
}

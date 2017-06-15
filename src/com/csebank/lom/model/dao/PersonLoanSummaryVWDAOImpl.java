/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.csebank.lom.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.csebank.lom.model.PersonLoanSummary;
import com.csebank.lom.model.condition.PersonLoanSummarySearchCond;
import com.csebank.lom.model.entity.PersonLoanSummaryVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * Ԥ֧��Աͳ��DAOʵ��
 * 
 */
public class PersonLoanSummaryVWDAOImpl extends
		BaseHibernateDAOImpl<PersonLoanSummary> implements
		PersonLoanSummaryVWDAO {

	/**
	 * ���캯��
	 */
	public PersonLoanSummaryVWDAOImpl() {
		super(PersonLoanSummaryVW.class);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	@SuppressWarnings("unchecked")
	public int getSearchCount(final PersonLoanSummarySearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<PersonLoanSummary> list = null;
				query.append(session.getNamedQuery(
						"PersonLoanSummaryVWDAO.findByCond").getQueryString());
				getSQL(cond, query);
				query.append(" GROUP BY A.LPDUSER,A.lpduserorg ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("PersonLoanSummaryVW", PersonLoanSummaryVW.class);
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();
				session.close();
				return list.size();
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
	@SuppressWarnings("unchecked")
	public List<PersonLoanSummary> findByCond(
			final PersonLoanSummarySearchCond cond, final int start,
			final int count) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<PersonLoanSummary> list = null;
				query.append(session.getNamedQuery(
						"PersonLoanSummaryVWDAO.findByCond").getQueryString());
				getSQL(cond, query);
				query.append(" GROUP BY A.LPDUSER,A.lpduserorg ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("PersonLoanSummaryVW", PersonLoanSummaryVW.class);
				setFetchPoint(q, start, count);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<PersonLoanSummary>) execute(action);
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL(PersonLoanSummarySearchCond cond, StringBuffer query){
		//���������
		if( StringUtils.isNotEmpty(cond.getLpduserorg()) ){
			query.append(" AND A.lpduserorg = :lpduserorg");
		}	
		//ʱ�俪ʼ
		if( StringUtils.isNotEmpty(cond.getLpddate_from()) ){
			query.append(" AND A.lpddate >=:lpddate_from");
		}	
		//ʱ�����
		if( StringUtils.isNotEmpty(cond.getLpddate_to()) ){
			query.append(" AND A.lpddate <=:lpddate_to");
		}	
	}
	
}

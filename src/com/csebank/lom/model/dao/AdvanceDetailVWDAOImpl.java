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

import com.csebank.lom.model.AdvanceDetail;
import com.csebank.lom.model.condition.AdvanceDetailSearchCond;
import com.csebank.lom.model.entity.AdvanceDetailVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * Ԥ֧��Աͳ��DAOʵ��
 * 
 */
public class AdvanceDetailVWDAOImpl extends
		BaseHibernateDAOImpl<AdvanceDetail> implements
		AdvanceDetailVWDAO {

	/**
	 * ���캯��
	 */
	public AdvanceDetailVWDAOImpl() {
		super(AdvanceDetailVW.class);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	@SuppressWarnings("unchecked")
	public int getSearchCount(final AdvanceDetailSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<AdvanceDetail> list = null;
				query.append(session.getNamedQuery(
				"AdvanceDetailVWDAO.findByCond1").getQueryString());
				getSQL1(cond, query);
				query.append(" UNION ALL ");
				query.append(session.getNamedQuery(
				"AdvanceDetailVWDAO.findByCond2").getQueryString());
				getSQL2(cond, query);
				query.append(" UNION ALL ");
				query.append(session.getNamedQuery(
				"AdvanceDetailVWDAO.findByCond3").getQueryString());
				getSQL3(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("AdvanceDetailVW", AdvanceDetailVW.class);
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
	public List<AdvanceDetail> findByCond(
			final AdvanceDetailSearchCond cond, final int start,
			final int count) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<AdvanceDetail> list = null;
				query.append("SELECT AdvanceDetailVW.* FROM (");
				query.append(session.getNamedQuery(
				"AdvanceDetailVWDAO.findByCond1").getQueryString());
				getSQL1(cond, query);
				query.append(" UNION ALL ");
				query.append(session.getNamedQuery(
				"AdvanceDetailVWDAO.findByCond2").getQueryString());
				getSQL2(cond, query);
				query.append(" UNION ALL ");
				query.append(session.getNamedQuery(
				"AdvanceDetailVWDAO.findByCond3").getQueryString());
				getSQL3(cond, query);
				query.append(") AS AdvanceDetailVW ORDER BY TIME,TYPE,ID");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("AdvanceDetailVW", AdvanceDetailVW.class);
				setFetchPoint(q, start, count);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<AdvanceDetail>) execute(action);
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL1(AdvanceDetailSearchCond cond, StringBuffer query){
		//ʱ�俪ʼ
		if( StringUtils.isNotEmpty(cond.getDate_from()) ){
			query.append(" AND ACINSDATE >=:date_from ");
		}	
		//ʱ�����
		if( StringUtils.isNotEmpty(cond.getDate_to()) ){
			query.append(" AND ACINSDATE <=:date_to ");
		}	
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL2(AdvanceDetailSearchCond cond, StringBuffer query){
		//ʱ�俪ʼ
		if( StringUtils.isNotEmpty(cond.getDate_from()) ){
			query.append(" AND LPDDATE >=:date_from ");
		}	
		//ʱ�����
		if( StringUtils.isNotEmpty(cond.getDate_to()) ){
			query.append(" AND LPDDATE <=:date_to ");
		}	
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL3(AdvanceDetailSearchCond cond, StringBuffer query){
		//ʱ�俪ʼ
		if( StringUtils.isNotEmpty(cond.getDate_from()) ){
			query.append(" AND A.LPDDATE >=:date_from ");
		}	
		//ʱ�����
		if( StringUtils.isNotEmpty(cond.getDate_to()) ){
			query.append(" AND A.LPDDATE <=:date_to ");
		}	
	}
	
}

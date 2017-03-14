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

import com.csebank.lom.model.PersonLoanDetail;
import com.csebank.lom.model.condition.PersonLoanDetailSearchCond;
import com.csebank.lom.model.entity.PersonLoanDetailVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * ��Ա���ͳ��DAOʵ��
 * 
 */
public class PersonLoanDetailVWDAOImpl extends
		BaseHibernateDAOImpl<PersonLoanDetail> implements
		PersonLoanDetailVWDAO {

	/**
	 * ���캯��
	 */
	public PersonLoanDetailVWDAOImpl() {
		super(PersonLoanDetailVW.class);
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	@SuppressWarnings("unchecked")
	public int getSearchCount(final PersonLoanDetailSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<PersonLoanDetail> list = null;
				query.append(session.getNamedQuery(
				"PersonLoanDetailVWDAO.findByCond1").getQueryString());
				if(StringUtils.isNotEmpty(cond.getGoreqorg())){
					query.append(" AND A.LPDUSERORG = "+cond.getGoreqorg());
				}
				getSQL1(cond, query);
				query.append(" UNION ALL ");
				query.append(session.getNamedQuery(
				"PersonLoanDetailVWDAO.findByCond2").getQueryString());
				if(StringUtils.isNotEmpty(cond.getGoreqorg())){
					query.append(" AND A.LPDUSERORG = "+cond.getGoreqorg());
				}
				getSQL2(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("PersonLoanDetailVW", PersonLoanDetailVW.class);
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
	public List<PersonLoanDetail> findByCond(
			final PersonLoanDetailSearchCond cond, final int start,
			final int count) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<PersonLoanDetail> list = null;
				query.append("SELECT PersonLoanDetailVW.* FROM (");
				query.append(session.getNamedQuery(
				"PersonLoanDetailVWDAO.findByCond1").getQueryString());
				if(StringUtils.isNotEmpty(cond.getGoreqorg())){
					query.append(" AND A.LPDUSERORG = "+cond.getGoreqorg());
				}
				getSQL1(cond, query);
				query.append(" UNION ALL ");
				query.append(session.getNamedQuery(
				"PersonLoanDetailVWDAO.findByCond2").getQueryString());
				if(StringUtils.isNotEmpty(cond.getGoreqorg())){
					query.append(" AND A.LPDUSERORG = "+cond.getGoreqorg());
				}
				getSQL2(cond, query);
				query.append(") AS PersonLoanDetailVW ORDER BY DATE,TYPE,ID");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("PersonLoanDetailVW", PersonLoanDetailVW.class);
				setFetchPoint(q, start, count);
				list = q.list();
				session.clear();
				session.close();
				
				return list;
			}
		};
		return (List<PersonLoanDetail>) execute(action);
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL1(PersonLoanDetailSearchCond cond, StringBuffer query){
		//ʱ�俪ʼ
		if( StringUtils.isNotEmpty(cond.getDate_from()) ){
			query.append(" AND A.LPDDATE >=:date_from ");
		}	
		//ʱ�����
		if( StringUtils.isNotEmpty(cond.getDate_to()) ){
			query.append(" AND A.LPDDATE <=:date_to ");
		}	
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL2(PersonLoanDetailSearchCond cond, StringBuffer query){
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

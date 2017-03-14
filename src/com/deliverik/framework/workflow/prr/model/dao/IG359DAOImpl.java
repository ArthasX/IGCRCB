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
import com.deliverik.framework.workflow.prr.model.IG359Info;
import com.deliverik.framework.workflow.prr.model.condition.IG359SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG359VW;

/**
 * <p>����:����ʲ�����ͳ�ƻ���ͳ��DAOʵ��</p>
 * <p>����������1.������������</p>
 * <p>			 2.������������</p>
 * <p>������¼��</p>
 */
public class IG359DAOImpl extends BaseHibernateDAOImpl<IG359Info> implements IG359DAO {

	/**
	 * ���ܣ����̻�����ͼ���캯��
	 * 
	 */
	public IG359DAOImpl(){
		super(IG359VW.class);
	}
	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<IG359Info> findByCond(final IG359SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG359DAO.searchQuery1").getQueryString()).append("  ");
				getSQL(cond, query);
				query.append(session.getNamedQuery("IG359DAO.searchQuery2").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("prcount",IG359VW.class);
				setFetchPoint(q, start, count);
				List<IG359Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG359Info>) execute(action);
	}
	
	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @param query sql
	 */
	protected void getSQL(IG359SearchCond cond, StringBuffer query){
		//��ʼ����
		if( StringUtils.isNotEmpty(cond.getPropentime_from()) ){
			query.append(" AND propentime >= :propentime_from ");
		}	
		//��������
		if( StringUtils.isNotEmpty(cond.getPropentime_to()) ){
			query.append(" AND propentime <= (:propentime_to||' 23:59') ");
		}	
	}
}

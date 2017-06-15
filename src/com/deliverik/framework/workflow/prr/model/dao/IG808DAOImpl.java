/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.framework.workflow.prr.model.IG808Info;
import com.deliverik.framework.workflow.prr.model.entity.IG808VW;

/**
 * <p>����:��ҳ�ϰ�����ͳ�ƹ���������ѯDAOʵ��</p>
 * <p>������������ȡsqlִ�в�ѯ</p>
 * <p>������¼���κ��� 2010/11/13</p>
 */
public class IG808DAOImpl extends BaseHibernateDAOImpl<IG808Info> implements IG808DAO {

	/**
	 * ��ͼ���캯��
	 * 
	 */
	public IG808DAOImpl(){
		super(IG808VW.class);
	}
	
	/**
	 * ���ܣ���ȡ��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<IG808Info> findIG808Info(){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG808DAO.searchIG808").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("prcount",IG808VW.class);
				List<IG160Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG808Info>) execute(action);
	}
	
	
}

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
import com.deliverik.framework.workflow.prr.model.IG003Info;
import com.deliverik.framework.workflow.prr.model.condition.IG003SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG003VW;
import com.deliverik.framework.workflow.prr.model.entity.IG160VW;

/**
 * <p>����:������Ȼ���ͳ��DAOʵ��</p>
 * <p>����������1.������������</p>
 * <p>������¼��</p>
 */
public class IG003DAOImpl extends BaseHibernateDAOImpl<IG003Info> implements IG003DAO {

	/**
	 * ���̻�����ͼ���캯��
	 * 
	 */
	public IG003DAOImpl(){
		super(IG160VW.class);
	}
	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<IG003Info> findByCond(final IG003SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG003DAO.searchIG003").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("yearSummary",IG003VW.class);
				setFetchPoint(q, start, count);
				List<IG003Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG003Info>) execute(action);
	}
	

}

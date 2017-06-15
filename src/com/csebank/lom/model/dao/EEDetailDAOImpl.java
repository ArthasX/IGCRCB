/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.csebank.lom.model.Eentertainment;
import com.csebank.lom.model.condition.EESearchCond;
import com.csebank.lom.model.entity.EEOrgDetail;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * ģ�飺���ڹ���-ʳ�ù���
 * ˵����ʳ���д����Ż�����ϸDAOʵ��
 * ���ߣ�������
 */
public class EEDetailDAOImpl extends BaseHibernateDAOImpl<Eentertainment> implements EEDetailDAO {

	/**
	 * ���캯��
	 */
	public EEDetailDAOImpl(){
		super(EEOrgDetail.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Eentertainment> findByCond(final EESearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<Eentertainment> list =null;
				query.append(session.getNamedQuery("EEOrgVWDAO.eedtail").getQueryString());
			
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("eedetail",EEOrgDetail.class);
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<Eentertainment>) execute(action);
	}
	
	

}

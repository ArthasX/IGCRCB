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

import com.csebank.lom.model.EEOrg;
import com.csebank.lom.model.condition.EEOrgVWSearchCond;
import com.csebank.lom.model.entity.EEOrgVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * ģ�飺���ڹ���-ʳ�ù���
 * ˵����ʳ���д����Ż���DAOʵ��
 * ���ߣ�������
 */
public class EEOrgVWDAOImpl extends BaseHibernateDAOImpl<EEOrg> implements EEOrgVWDAO {

	/**
	 * ���캯��
	 */
	public EEOrgVWDAOImpl(){
		super(EEOrgVW.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<EEOrg> findByCond(final EEOrgVWSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<EEOrg> list =null;
				
				query.append(session.getNamedQuery("EEOrgVWDAO.eeOrgVW").getQueryString());
				getSQL(cond, query);
				query.append(" group by o.orgname) EEORGVW where eeorgvw.rapporgname=oo.orgname )EEORGVWSQL ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("EEORGVWSQL",EEOrgVW.class);
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<EEOrg>) execute(action);
	}
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL(EEOrgVWSearchCond cond, StringBuffer query){
		//���������
		if( StringUtils.isNotEmpty(cond.getRapporgid()) ){
			query.append(" AND r.rapporgid = :rapporgid");
		}
	}
	

}

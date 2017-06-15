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

import com.csebank.lom.model.DealOrg;
import com.csebank.lom.model.condition.DealOrgVWSearchCond;
import com.csebank.lom.model.entity.DealOrgVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * ģ�飺���ڹ���-�Ӵ�����
 * ˵������������Ͳ�DAOʵ��
 * ���ߣ�������
 */
public class DealOrgVWDAOImpl extends BaseHibernateDAOImpl<DealOrg> implements DealOrgVWDAO {

	/**
	 * ���캯��
	 */
	public DealOrgVWDAOImpl(){
		super(DealOrgVW.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<DealOrg> findByCond(final DealOrgVWSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<DealOrg> list =null;
				
				query.append(session.getNamedQuery("DealOrgVWDAO.dealOrgVW").getQueryString());
				getSQL(cond, query);
				query.append(" GROUP BY RP.RAPPORGID, ORG.ORGNAME ) AS RECPTIONORGVW ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("DealOrgVW",DealOrgVW.class);
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<DealOrg>) execute(action);
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL(DealOrgVWSearchCond cond, StringBuffer query){
		//���������
		if( StringUtils.isNotEmpty(cond.getRapporgid()) ){
			query.append(" AND rapporgid = :rapporgid");
		}
	}

}
